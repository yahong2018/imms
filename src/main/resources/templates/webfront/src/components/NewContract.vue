<template>
  <el-row>
    <el-col :xs="24" :sm="18" :md="14" :lg="10" id="main">
      姓名:{{info.name}}
      <el-input v-model="info.name" placeholder="请输入姓名"></el-input>
      年龄:{{info.age}}
      <el-input v-model="info.age" placeholder="请输入年龄"></el-input>
      性别:{{info.sex}}
      <el-select v-model="info.sex" placeholder="请选择">
        <el-option v-for="item in options" :key="item" :value="item"></el-option>
      </el-select>
      <el-button class="btn-auto" @click="create">创建</el-button>
      <template>
        <el-table :data="tabledata" align="left">
          <el-table-column prop="name" label="姓名"></el-table-column>
          <el-table-column prop="age" label="性别"></el-table-column>
          <el-table-column prop="sex" label="性别"></el-table-column>
          <el-table-column label="操作">
            <template slot-scope="a">
              <el-button size="mini" type="danger" @click="del(a.$index)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </template>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: "NewContract",
  data() {
    return {
      info: {
        name: "",
        age: null,
        sex: ""
      },
      options: ["女", "男", "保密"],
      tabledata: [
        { name: "Leo", age: 12, sex: "man" },
        { name: "Lei", age: 22, sex: "women" },
        { name: "Lii", age: 65, sex: "men" }
      ]
    };
  },
  methods: {
    create() {
      this.tabledata.push(this.info);
      this.info = { name: "", age: null, sex: "" };
    },
    del(index) {
      this.tabledata.splice(index, 1);
    }
  },
  watch: {
    tabledata: {
      handler(items) {
        debugger;
        console.log(items);
      },
      deep: true,
      immediate: false
    }
  }
};
</script>

<style>
#main {
  float: none;
  margin: 0 auto;
}
.el-input {
  padding-bottom: 5px;
}
.el-select {
  display: block;
}
.btn-auto {
  width: 100%;
  margin-top: 12px;
}
</style>


