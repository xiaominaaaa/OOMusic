// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import api from './util/APIUtil.js'
import request from './util/request.js'
import storage from './util/StorageUtil.js'
//导入路由
import vuerouter from 'vue-router'
//element ui
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
//vant ui
import Vant from 'vant';
import 'vant/lib/index.css';

Vue.config.productionTip = false

Vue.use(vuerouter);
Vue.use(ElementUI);
Vue.use(Vant);

//获取原型对象，可以在原型对象中添加方法
var extend = Vue.prototype;

//添加api
extend.api = api;
//添加请求方法
extend.get = request.get;
extend.post = request.post;
//添加本地内存
extend.Local = storage.Local;
extend.Session = storage.Session;
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
