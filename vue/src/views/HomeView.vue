<template>
  <div>
    <el-container style="height: 100vh; border: 1px solid #eee">
      <el-aside width="210px" style="background-color: rgb(70, 70, 70)">
        <el-menu :default-openeds="['1']" style="overflow-x: hidden"
                 background-color="rgb(70, 70, 70)"
                 text-color="#fff"
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

          <el-submenu index="1">
            <template slot="title"><i class="el-icon-message"></i>Navigator One</template>
            <el-menu-item-group>
              <template slot="title">Group 1</template>
              <el-menu-item index="1-1">Option 1</el-menu-item>
              <el-menu-item index="1-2">Option 2</el-menu-item>
            </el-menu-item-group>

            <el-submenu index="1-3">
              <template slot="title">Option3</template>
              <el-menu-item index="1-3-1">Option 3-1</el-menu-item>
            </el-submenu>
          </el-submenu>

          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i>Navigator Two</template>
            <el-menu-item-group>
              <template slot="title">Group 1</template>
              <el-menu-item index="2-1">Option 1</el-menu-item>
              <el-menu-item index="2-2">Option 2</el-menu-item>
            </el-menu-item-group>
          </el-submenu>

          <el-submenu index="3">
            <template slot="title"><i class="el-icon-setting"></i>Navigator Three</template>
            <el-menu-item-group>
              <template slot="title">Group 1</template>
              <el-menu-item index="3-1">Option 1</el-menu-item>
              <el-menu-item index="3-2">Option 2</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px; border: 1px solid #aaa; line-height: 60px">
          <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>View</el-dropdown-item>
              <el-dropdown-item>Add</el-dropdown-item>
              <el-dropdown-item>Delete</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>Tom</span>
        </el-header>



        <el-main>

          <div style="padding: 10px">
            <el-input style="width: 450px" suffix-icon="el-icon-search" placeholder="please input name"
                      v-model="name"></el-input>
            <el-button style="margin-left: 5px" type="primary" @click="load">search</el-button>
          </div>

          <div>
            <el-button type="primary" >add<i class="el-icon-circle-plus-outline"></i></el-button>
            <el-button type="danger" style="margin-left: 30px">batch delete<i class="el-icon-delete-solid"></i></el-button>
            <el-button type="primary" style="margin-left: 30px">import<i class="el-icon-bottom"></i></el-button>
            <el-button type="primary" style="margin-left: 30px">export<i class="el-icon-top"></i></el-button>
          </div>



          <el-table :data="tableData">
            <el-table-column prop="id" label="ID" width="80">
            </el-table-column>
            <el-table-column prop="name" label="Name" width="140">
            </el-table-column>
            <el-table-column prop="phone" label="Phone" width="200">
            </el-table-column>
            <el-table-column prop="address" label="Address">
            </el-table-column>

            <el-table-column>
              <el-button>edit<i class="el-icon-edit"></i></el-button>
              <el-button>delete<i class="el-icon-delete"></i></el-button>
            </el-table-column>
          </el-table>
        </el-main>

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


      </el-container>
    </el-container>
  </div>
</template>


<script>

export default {
  name: 'Home',
    data(){

        return {
            tableData: [],
            total: 0,
            pageNum: 1,
            pageSize: 2,
            name : ""
        }
    },

    created(){
        this.load()
    },

    methods: {

        load(){
            //请求分页查询数据
            fetch("http://localhost:9090/user/page?pageNum=" + this.pageNum + "&pageSize="
                + this.pageSize + "&name=" + this.name).then(res => res.json()).then(res => {
                console.log(res)
                this.tableData = res.data
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
        }
    }
}
</script>
