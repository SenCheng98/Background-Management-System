<template>
  <div>
    <el-container style="height: 100vh; border: 1px solid #eee">

      <!--Aside-->
      <el-aside width="230px" style="background-color: rgb(240, 180, 35)">
        <Aside></Aside>
      </el-aside>

      <el-container>

        <!--Header-->
          <el-header style="text-align: left; font-size: 12px;
          border: 1px solid #aaa; line-height: 60px; background-color: rgb(255,255,255)">
          <Header></Header>
        </el-header>

        <!--User-->
        <el-main>
          <router-view></router-view>
        </el-main>

      </el-container>
    </el-container>
  </div>
</template>


<script>

import Aside from "../components/Aside";
import Header from "../components/Header";

export default {

  name: 'Home',

    //{}对象。[]数组
    components: {

        Header,
        Aside
    },

    data(){

        return {
            collapseBtnClass: 'el-icon-s-fold',
            isCollapsed: false,
            sideWidth: 200,
            logoTextShow: true
        }
    },

    methods: {
        collapse(){
          this.isCollapsed = !this.isCollapsed
            if(this.isCollapsed){   //fold
                this.sideWidth = 64
                this.collapseBtnClass = 'el-icon-s-unfold'
                this.logoTextShow = false

            }else{
                this.sideWidth = 200
                this.collapseBtnClass = 'el-icon-s-fold'
                this.logoTextShow = true
            }
        }
    }
}
</script>
