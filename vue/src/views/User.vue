<template>
    <div>
        <div style="padding: 10px">
            <el-input style="width: 450px" suffix-icon="el-icon-search" size="large" placeholder="please input name"
                      v-model="name"></el-input>
            <el-button style="margin-left: 10px" size="large" type="primary" @click="load">search</el-button>
            <el-button style="margin-left: 10px" size="large" type="warning" @click="reset">reset</el-button>
        </div>

        <div>
            <el-button type="success" style="margin-left: 10px" size="large" @click="handleAdd">add<i class="el-icon-circle-plus-outline"></i></el-button>
            <el-button type="danger" style="margin-left: 30px" size="large">batch delete<i class="el-icon-delete-solid"></i></el-button>
            <el-button type="primary" style="margin-left: 30px" size="large">import<i class="el-icon-bottom"></i></el-button>
            <el-button type="primary" style="margin-left: 30px" size="large">export<i class="el-icon-top"></i></el-button>
        </div>



        <el-table :data="tableData">

            <el-table-column prop="id" label="ID" width="80"></el-table-column>
            <el-table-column prop="name" label="Name" width="140"></el-table-column>
            <el-table-column prop="phone" label="Phone" width="200"></el-table-column>
            <el-table-column prop="address" label="Address"></el-table-column>

            <el-table-column>
                <template v-slot="row">
                    <el-button size="large" type="primary" @click="handleEdit(row)">edit<i class="el-icon-edit"></i></el-button>
                    <el-button size="large" type="danger" @click="handleDelete(row.id)">delete<i class="el-icon-delete"></i></el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-dialog title="User Info" :visible.sync="dialogFormVisible" width="30%">
            <el-form size="large">
                <el-form-item label="name">
                    <el-input v-model="form.name" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="phone">
                    <el-input v-model="form.phone" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="address">
                    <el-input v-model="form.address" auto-complete="off"></el-input>
                </el-form-item>
            </el-form>

            <div slot="footer" class="dialog-footer" >
                <el-button size="large" type="primary" @click="save">confirm</el-button>
                <el-button size="large" type="primary" @click="dialogFormVisible=false">cancel</el-button>
            </div>
        </el-dialog>

        <div style="padding: 10px 0">
            <el-pagination

                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :page-size="this.pageSize"
                    layout="total, sizes, prev, pager, next,jumper"
                    :page-sizes="[2,5,10,20]"
                    :total="total">
            </el-pagination>
        </div>
    </div>
</template>

<script>
export default {

    name: "User",

    data(){

        return {
            tableData: [],
            total: 0,
            pageNum: 1,
            pageSize: 2,
            name : "",
            phone : "",
            address : "",
            form:{},
            dialogFormVisible: false
        }
    },

    created() {
        this.load()
    },

    methods: {

        load(){

            //使用axios发送http请求
            this.myRequest.get("/user/page",{
                params: {
                    pageNum: this.pageNum,
                    pageSize: this.pageSize,
                    name: this.name
                }
            }).then(res =>{
                console.log(res)

                this.tableData = res.records
                this.total = res.total
            })

        },

        handleSizeChange(pageSize) {
            console.log(`${pageSize} items per page`);
            this.pageSize = pageSize
            this.load()
        },

        handleCurrentChange(pageNum) {
            console.log(`current page: ${pageNum}`);
            this.pageNum = pageNum
            this.load()
        },

        reset(){
            this.pageNum = 1
            this.pageSize = 2
            this.name = ""
            this.load()
        },

        handleAdd(){
            this.dialogFormVisible = true
            this.form = {}

        },

        save(){

            this.myRequest.post("/user", this.form).then(res => {
                console.log(res)
                if(res){
                    this.$message.success("saved successfully!")
                    this.dialogFormVisible = false
                    this.load()
                }else{
                    this.$message.error("failed saved")
                }
            })
        },

        handleEdit(row){

            this.form = row
            this.dialogFormVisible = true

        },

        handleDelete(id){

            this.myRequest.delete("/user",id).then(res => {
                console.log(res)

                if(res){
                    this.$message.success("successfully deleted!")
                    this.dialogFormVisible = false
                    this.load()
                }else{
                    this.$message.error("failed deleted")
                }
            })
        }
    }
}


</script>

<style scoped>

</style>