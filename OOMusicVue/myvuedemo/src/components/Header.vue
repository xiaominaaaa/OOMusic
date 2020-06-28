<template>
  <!-- 头部组件 -->
  <div class="table header">
  			<header class="header">
  				  <div class="header-container">
  				    <div class="header-top">
  				      <a @click="$router.push('/main')" class="logo"></a>
  				      <nav class="header-nav">
  				        <ul>
  				          <li><a href="#" class="header-nav__cur">音乐馆</a></li>
  				          <li><a href="#">我的音乐</a></li>
  				          <li><a href="#">下载客户端</a></li>
  				          <li><a href="#">VIP</a></li>
  				        </ul>
  				      </nav>
  				      <div class="header-search">
  				        <input v-model="name" type="text" class="text" placeholder="here...">
  				        <div class="btn"><i class="icon-sprite"></i></div>
  				        <div class="result">
  				          <a href="#" class="result-item">
  				            <span class="rank">1</span>
  				            <span class="title">默</span>
  				            <span class="num">3.4万</span>
  				          </a>
  				          <a href="#" class="result-item">
  				            <span class="rank">2</span>
  				            <span class="title">侧田</span>
  				            <span class="num">3.4万</span>
  				          </a>
  				          <a href="#" class="result-item">
  				            <span class="rank">3</span>
  				            <span class="title">让我留在你身边</span>
  				            <span class="num">3.4万</span>
  				          </a>
  				          <a href="#" class="result-item">
  				            <span class="rank">4</span>
  				            <span class="title">皮皮虾我们走</span>
  				            <span class="num">3.4万</span>
  				          </a>
  				          <a href="#" class="result-item">
  				            <span class="rank">5</span>
  				            <span class="title">欢乐好声音</span>
  				            <span class="num">3.4万</span>
  				          </a>
  				          <div class="history">
  				            <span>搜索历史</span>
  				            <i class="icon-sprite"></i>
  				          </div>
  				        </div>
  				      </div>
                <div style="position: absolute; left: 73%; top: 25%;" @click="search()">
                <i class="el-icon-search"></i>
                </div>
  				      <div class="header-login">
  				        <a href="#" class="login" @click="$router.push('/user/login')">{{user == null?'登录':user.userName }}</a>
  				        <a href="#" class="open-green">开通绿钻豪华版</a>
  				        <a href="#" class="open-vip" @click="zhuxiao()">注销</a>
  				      </div>
  				    </div>
  				   <!-- <ul class="header-subNav">
  				      <li><a href="#" class="subNav-cur">首页</a></li>
  				      <li><a href="#">歌手</a></li>
  				      <li><a href="#">专辑</a></li>
  				      <li><a href="#">排行榜</a></li>
  				      <li><a href="#">分类歌单</a></li>
  				      <li><a href="#">MV</a></li>
  				    </ul> -->
  				  </div>
  				</header>
  </div>
</template>

<script>
  export default{
    name:"Header",
    data(){
      return {
        name:"",
        user:null,
      }
    },
    methods:{
      search:function(){
        this.$router.push({path:'/main/search',query: {type:0,w:this.name}});
      },
      zhuxiao:function(){
        this.Session.remove('user');
        location.reload(true);
      }
    },
    mounted() {
      this.user = this.Session.get("user");
      console.log(this.user)
    }
  }
</script>

<style scoped>
/* ====== public ====== */

.main {
  overflow: hidden;
  position: relative;
}
.main-inner {
  position: relative;
  width: 1200px;
  margin: 0 auto;
}
.main-title {
  position: relative;
  width: 490px;
  height: 46px;
  padding-top: 80px;
  margin: 0 auto 50px;
}
.main-title .title {
  width: 490px;
  text-align: center;
}
.main-title .title i {
  display: inline-block;
  width: 196px;
  height: 46px;
}
.main-title .line {
  position: absolute;
  top: 104px;
  width: 72px;
  height: 1px;
  background-color: #fff;
  opacity: .1;
}
.main-title .line-left {
  left: 0;
}
.main-title .line-right {
  right: 0;
}
.readAll {
  position: absolute;
  right: 0;
  color: #fff;
  font-size: 15px;
}
.readAll i {
  display: inline-block;
  width: 7px;
  height: 12px;
  margin-left: 6px;
  background-position: -40px -260px;
}
.readAll:hover i {
  background-position: -120px -60px;
}
.main-tab {
  text-align: center;
  font-size: 0;
}
.main-tab .item {
  display: inline-block;
  height: 50px;
  font-size: 16px;
  margin: 0 35px;
  color: #fff;
  opacity: .5;
}
.main-tab .item:hover,
.main-tab .item-cur {
  opacity: 1;
}
.main-slider {
  overflow: hidden;
  width: 1200px;
}
.main-slider .slider-wrapper {
  position: relative;
  left: 0;
  height: 414px;
  margin-bottom: 35px;
}
.slider-wrapper li {
  float: left;
  width: 300px;
  height: 414px;
}
.slider-wrapper .img {
  position: relative;
  overflow: hidden;
  width: 300px;
  height: 300px;
}

.main .img img,
.main .img i,
.main .mask,
.main .icon-play {
  transition: all 0.4s;
  -webkit-transition: all 0.4s;
}
.main .img:hover img {
  transform: scale(1.07);
  -webkit-transform: scale(1.07);
}
.main .mask {
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background-color: #000;
  opacity: 0;
}
.main .icon-play {
  position: absolute;
  left: 50%;
  top: 50%;
  width: 70px;
  height: 70px;
  margin: -35px;
  background: url(../assets/img/icon_play.png) no-repeat;
  opacity: 0;

  transform: scale(0.7);
  -webkit-transform: scale(0.7);
}

/* ====== header ====== */
.header {}
.header-container {
  position: relative;
  width: 1200px;
  height: 142px;
  margin: 0 auto;
}
.header-top {
  height: 90px;
  border-bottom: 1px solid #f2f2f2;
}
.header-top .logo {
  float: left;
  width: 190px;
  height: 52px;
  margin-top: 18px;
  background: url(../assets/img/logo.png) no-repeat;
}
.header-nav {
  float: left;
  margin: 0 29px 0 35px;
}
.header-nav ul {}
.header-nav li {
  float: left;
}
.header-nav li a {
  height: 90px;
  line-height: 90px;
  padding: 0 20px;
  font-size: 18px;
}
.header-nav li a.header-nav__cur {
  color: #fff;
  background-color: #31c27c;
}
.header-search {
  position: relative;
  float: left;
  width: 248px;
  height: 36px;
  margin-top: 26px;
  border: 1px solid #c9c9c9;
  border-radius: 3px;
  font-size: 0;
}
.header-search .text {
  display: inline-block;
  width: 212px;
  height: 36px;
  padding-left: 14px;
  box-sizing: border-box;
  font-family: "Microsoft Yahei";
  font-size: 14px;
  vertical-align: top;
}
.header-search .btn {
  display: inline-block;
  width: 36px;
  height: 36px;
  line-height: 52px;
  text-align: center;
  cursor: pointer;
}
.header-search .btn i {
  display: inline-block;
  width: 16px;
  height: 16px;
  background-position: 0 -40px;
}
.header-search .btn:hover i {
  background-position: 0 -60px;
}
.header-search .result {
  display: none;
  position: absolute;
  z-index: 999;
  top: 36px;
  left: -1px;
  width: 248px;
  padding: 6px 0 14px;
  border: 1px solid #c9c9c9;
  font-size: 14px;
  background-color: #fff;
}
.header-search .result-item {
  position: relative;
  padding: 0 15px;
  height: 36px;
  line-height: 36px;
  font-size: 12px;
}
.header-search .result-item:hover {
  background-color: #31c27c;
}
.header-search .result-item .rank {
  margin-right: 12px;
  color: #ff594b;
}
.header-search .result-item .title {
  font-size: 14px;
}
.header-search .result-item .num {
  position: absolute;
  right: 15px;
  color: #999;
}
.header-search .result-item:hover .rank,
.header-search .result-item:hover .title,
.header-search .result-item:hover .num {
  color: #fff;
}
.header-search .history {
  position: relative;
  padding: 0 15px;
  margin-top: 15px;
  height: 24px;
  line-height: 24px;
}
.header-search .history span {
  color: #999;
}
.header-search .history i {
  position: absolute;
  top: 5px;
  right: 15px;
  width: 16px;
  height: 16px;
  background-position: -100px 0;
  cursor: pointer;
}
.header-search .history i:hover {
  background-position: -20px -60px;
}
.header-login {
  float: right;
  margin-top: 24px;
  font-size: 0;
}
.header-login a {
  display: inline-block;
}
.header-login a.login,
.header-login a.open-green,
.header-login a.open-vip {
  height: 40px;
  line-height: 40px;
  text-align: center;
  font-size: 14px;
  border-radius: 3px;
}
.header-login a.login {
  width: 60px;
}
.header-login a.open-green {
  width: 115px;
  margin: 0 10px;
  color: #fff;
  background-color: #31c27c;
}
.header-login a.open-vip {
  width: 86px;
  height: 38px;
  border: 1px solid #c9c9c9;
  background-color: #fff;
  color: #333;
}
.header-login a.open-green:hover {
  background-color: #2caf6f;
}
.header-login a.open-vip:hover {
  background-color: #ededed;
}
.header-subNav {
  padding-left: 228px;
}
.header-subNav li {
  display: inline-block;
  margin: 0 24px;
}
.header-subNav a {
  line-height: 50px;
  font-size: 15px;
}
.header-subNav a.subNav-cur {
  color: #31c27c;
}

html, body, div, span, h1, h2, h3, h4, h5, h6, p, em, small, strong, dl, dt, dd, ol, ul, li {
  margin: 0;
  padding: 0;
  font-size: 100%;
}
em, strong, i {
  font-style: normal;
}
h1, h2, h3, h4, h5, h6 {
  font-weight: normal;
}
body {
  line-height: 1;
  font-size: 14px;
  font-family: "Microsoft Yahei";
  color: #333;
  background-color: #fff;
}
ul, ol {
  list-style: none;
}
a {
  display: block;
  color: #333;
  text-decoration: none;
}
a:hover {
  color: #31c27c;
}
input, button {
  padding: 0;
  border: none;
  outline: none;
  background: none;
}
img {
  vertical-align: top;
}
</style>
