<template>
  <div>
    <h2>dajiahao1</h2>
    <h1>的味道无多无多</h1>
    <div v-html="name"></div>
  </div>
</template>

<script>
 export default{
   data(){
     return {
      data:'',
      name:'wdwdwdwd',
     }
   },
   methods:{
     test:function(){
        //http://localhost:8088/oomusic/main
        this.get(this.api.API_MAIN_DATA,{
          userid:'id'
        }).then( responese =>{
          console.log(responese)
          console.log(responese.length)
          console.log(typeof responese)
        } )
     },

   },
   mounted() {
      this.test();
   }
 }
</script>

<style>
</style>
