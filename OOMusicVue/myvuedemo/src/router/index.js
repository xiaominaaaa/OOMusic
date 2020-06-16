import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Main from '@/components/Main.vue'
import Data from '@/components/Data.vue'
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
      path:'/main',
      name:'Main',
      component:Main
    },
    {
      path:'/data',
      name:"Data",
      component:Data
    },
  ]
})
