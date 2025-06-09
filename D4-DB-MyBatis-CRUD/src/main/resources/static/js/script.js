import {createApp} from 'https://unpkg.com/vue@3/dist/vue.esm-browser.js';

const app = createApp({
    data(){
        return{
            searchForm:{
                employeeId: '',
            },
            insertForm:{
                employeeId: '',
                firstName: '',
                lastName: '',
                jobTitle: '',
                salary: '',
                reportsTo: '',
                officeId: '',
            },
            employees:[],
            hoveredEmpId:null,
        }
    },
    methods:{
        handleMouseEnter(empId){
            this.hoveredEmpId=empId;
        },
        handleMouseLeave(){
            this.hoveredEmpId=null;
        },
        showAll(){
            fetch("/getAllEmployees")
                .then(response => response.json())
                .then(data => this.employees=data);
        },
        searchHandler(){
            fetch("/searchEmployee",{
                method:"POST",
                headers:{
                    "Content-Type":"application/json",
                },
                body:JSON.stringify(this.searchForm)
            }).then(response => response.json())
                .then(data => this.employees=data)
        },
        deleteHandler(){
            fetch("/deleteEmployee",{
                method:"POST",
                headers:{
                    "Content-Type":"application/json",
                },
                body:JSON.stringify(this.searchForm)
            }).then(this.showAll)
        },
        insertHandler(){
            fetch("/insertEmployee",{
                method:"POST",
                headers:{
                    "Content-Type":"application/json",
                },
                body:JSON.stringify(this.insertForm)
            }).then(this.showAll)
        },
        updateHandler(){
            fetch("/updateEmployee",{
                method:"POST",
                headers:{
                    "Content-Type":"application/json",
                },
                body:JSON.stringify(this.insertForm)
            }).then(this.showAll)
        },
    },
});
app.mount('#app');