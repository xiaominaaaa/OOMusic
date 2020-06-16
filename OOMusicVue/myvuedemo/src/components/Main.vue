<template>
  <!-- 头部组件 -->
  <div>
    <vHeader></vHeader>

    <button @click=" $router.push({path:'/data'}) ">跳到data去</button>
    </div>
</template>

<script>
  import headervue from "./Header.vue"
  export default{
    name:"Main",
    data(){
      return {
        username:""
      }
    },
    methods:{
      test:function(){
       this.post(this.api.API_USER_PASSNAME,{
         userId:2,
         userName:'老八'
       }).then(response =>{
         console.log(response)
       }).catch(error=>{
         console.log(error)
       })
      }
    },
    mounted() {
      this.test();
    },
    components:{
      vHeader:headervue
    }
  }
</script>

<style>
</style>
