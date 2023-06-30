<template>
    <el-menu :default-openeds="['1']" style="overflow-x: hidden"
             background-color="rgb(70, 70, 70)"
             text-color="#fff"
             router
    >
        <div style="height: 100px; text-align: center">
            <div>
                <b style="color: white; font-size: large; line-height: 50px">Sen Cheng's</b>
            </div>
            <div>
                <b style="color: white; font-size: large; line-height: 10px">Mamagement System</b>
            </div>
            <div>
                <img id="object1" src="../assets/logo.png">
            </div>
        </div>


        <el-menu-item index="/" style="text-align: center">
            <template slot="title">
                <i class="el-icon-house"></i>
                <span slot="title">Main page</span>
            </template>
        </el-menu-item>

        <el-submenu index="2" style="text-align: center">
            <template slot="title"><i class="el-icon-menu"></i>System management</template>
            <el-menu-item-group>
                <el-menu-item index="/User"><i class="el-icon-user"></i>User management</el-menu-item>
            </el-menu-item-group>
        </el-submenu>

    </el-menu>
</template>

<script>
    export default {
        name: "Aside",
        props:{

        }
    }
</script>

<style scoped>

</style>