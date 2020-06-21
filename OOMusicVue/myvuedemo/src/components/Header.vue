<template>
  <!-- 头部组件 -->
  <div class="table header">
    <div class="img_table">
      <img class="img" src="../assets/icon/logo.png" />
    </div>
    <div class="">
      <ul>
        <li>音乐馆</li>
        <li @click="" >我的音乐</li>
        <li>客户端</li>
        <li>开发平台</li>
        <li>VIP</li>
      </ul>
    </div >
    <div class="mod_serch">
      <div class="input_serch">
      <input class="input__serch" style="border: none;" placeholder="搜索音乐,用户"/>
      </div>
      <button class="search_input__btn">
        <i class="icon_search sprite"></i>
      </button>
    </div>
    <div class="user_table">
      <img class="user_image" src="../assets/logo.png"/>
      <div>
        <button class="user_btn_1">开启绿钻</button>
      </div>
      <div>
        <button class="user_btn_2">没钱滚蛋</button>
      </div>
    </div>
  </div>
</template>

<script>
  export default{
    name:"Header",
    data(){
      return {
      }
    },
    methods:{
      tiao:function(){
        
        this.$router.push({name:'Play',params: {userId:'2'}});
      }
    },
    mounted() {
    }
  }
</script>

<style >
  .mod_serch{
    position: relative;
    margin-bottom: 20px;
  }
  .input_serch{
       border: 1px solid #c9c9c9;
       padding: 0 33px 0 11px;
       line-height: 36px;
       height: 36px;
       margin-top: 26px;
       position: relative;
       border-radius: 3px;
       background-color: #fff;
       transition: width .6s ease-out;
  }
  .icon_search{
    position: absolute;
    top: 50%;
    right: 11px;
    margin-top: -8px;
    width: 16px;
    height: 16px;
    background-position: 0 -40px;
  }
  .icon_search:hover{
  background-position: 0 -60px;
  }

  .sprite{
    background-image:url(../assets/icon/icon_sprite.png);
  }
  .input__serch{
    width: 174px;
    height: 36px;
    border: 0 none;
    outline: none;
    font-size: 14px;
    background: 0 0;
    -webkit-transition: width .6s ease-out,visibility .6s 1ms ease-out;
    transition: width .6s ease-out,visibility .6s 1ms ease-out;
  }
  .search_input__btn {
      position: absolute;
      top: 27px;
      right: 0;
      border: 0 none;
      outline: none;
      width: 38px;
      height: 35px;
      overflow: visible;
      background: 0 0;
  }

  .user_image{
    height: 40px;
    border: 1px solid lightgrey;
    border-radius: 50% 50%;
    margin: 0 8px;
  }

  .user_btn_1{
    border: none;
    outline: none;
    padding: 5px 10px;
    background: #31c27c;
    color: white;
    margin: 0px 8px;
  }
  .user_btn_1:hover{
    background: seagreen;
  }

  .user_btn_2{
    border: darkgray 1px solid;
    outline: none;
    padding: 5px 10px;
    margin: 0px 8px;
    background: white;
  }
   .user_btn_2:hover{
     background: #EFEFEF;
   }

  .header{
    border: 1px solid red;
    font-family: poppin,Tahoma,Arial,\5FAE\8F6F\96C5\9ED1,sans-serif;
    margin: 0 50px;
  }

  .mod_top_login {
      /* font-size: 0; */
      height: 90px;
      line-height: 90px;
  }

  .img{
    padding: 0px 20px;
    width: 170px;
    height: 46px;
  }


  .table{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    align-items: center;
  }

  .user_table{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    align-items: center;
  }
  ul{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    list-style: none;
    margin-right: 8px;
  }
   ul>li:hover{
     display: block;
     color: #31c27c;
   }

    ul>li{
      display: inline-block;
      padding:0 20px;
    }
</style>
