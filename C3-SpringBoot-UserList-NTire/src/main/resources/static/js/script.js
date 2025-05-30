import {createApp} from 'https://unpkg.com/vue@3/dist/vue.esm-browser.js';

const app = createApp({
    data(){
        return{
            searchForm:{
                name: '',
                gender: '',
                age: '',
            },
            users:[],
            hoveredUserName:null,
        }
    },
    methods:{
        handleMouseEnter(userName){
            this.hoveredUserName=userName;
        },
        handleMouseLeave(){
            this.hoveredUserName=null;
        },
        searchHandler(){
            fetch("/user",{
                method:"POST",
                headers:{
                    "Content-Type":"application/json",
                },
                body:JSON.stringify(this.searchForm),
            }).then(response => response.json())
                .then(data => this.users = data)
        },
        resetHandler(){
            this.searchForm.name= '';
            this.searchForm.gender= '';
            this.searchForm.age= '';
            this.searchHandler();
        }
    }
});

app.mount('#app');