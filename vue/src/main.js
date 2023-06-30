import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/globe.css';

import request from "./utils/request.js";
import axios from "axios";


Vue.use(ElementUI,{size:"mini"});
Vue.config.productionTip = false


Vue.prototype.myRequest = request

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
