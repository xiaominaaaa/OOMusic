import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Main from '@/components/Main.vue'
import Data from '@/components/Data.vue'
import Play from '@/components/Play.vue'
import login from '@/components/Login.vue'
import Reg from '@/components/Register.vue'
import Playlist from '@/components/Playlist.vue'
import Search from '@/components/Search.vue'
import Song from '@/components/Song.vue'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      // name: 'HelloWorld',
      // component: HelloWorld
      redirect: '/main',
    },
    {
      path:'/main', //主页
      name:'Main',
      component:Main
    },
    {
      path:'/data',
      name:"Data",
      component:Data
    },
    {
      path:'/play',
      name:"Play",
      component:Play
    },
    {
      path:'/user/login', //登录
      name:"login",
      component:login
    },
    {
      path:'/user/reg', //注册
      name:"reg",
      component:Reg
    },
    {
      path:'/playlist', //播放
      name:"playlist",
      component:Playlist
    },
    {
      path:'/main/search', //搜索
      name:"search",
      component:Search
    },
    {
      path:'/main/song', //歌曲详情页
      name:"Song",
      component:Song
    },
  ]
})
