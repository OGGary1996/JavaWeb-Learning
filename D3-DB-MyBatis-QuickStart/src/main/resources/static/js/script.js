import {createApp} from 'https://unpkg.com/vue@3/dist/vue.esm-browser.js';

const app = createApp({
    data(){
        return{
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
        searchHandler(){
            fetch("/employee")
                .then(response => response.json())
                .then(data => this.employees=data)
        },
    },
    mounted(){
        this.searchHandler();
    }
});

app.mount('#app');