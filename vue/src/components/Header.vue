<template>
    <div style="font-size: 12px; line-height: 60px; display: flex">
        <div style="flex : 1; font-size: 20px">
            <span class="collapseBtnClass" style="cursor: pointer; font-size: 20px" @click="collapse"></span>

            <el-breadcrumb separator="/" style="display: inline-block">
                <el-breadcrumb-item :to="{path: '/'}">Main page</el-breadcrumb-item>
                <el-breadcrumb-item>User management</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <el-dropdown style="width: 70px; cursor : pointer" >
            <span>{{ }}</span><i class="el-icon-arrow-down" style="margin-right: 5px"></i>
            <el-dropdown-menu slot="dropdown">
                <el-dropdown-item style="font-size: 14px">personal Info</el-dropdown-item>
                <el-dropdown-item style="font-size: 14px">quit</el-dropdown-item>
            </el-dropdown-menu>
        </el-dropdown>
    </div>

</template>

<script>
    export default {
        name: "Header",
        props:{
            collapseBtnClass: String,
            collapse: Boolean
        }
    }
</script>

<style scoped>

</style>