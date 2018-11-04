<template>
  <el-container>
    <el-header height="50px">
      <div style="display:flex;">
        <span style="display:flex;align-items:flex-end">
          <h1 style="padding-right:5px;">智汇星红EHR管理信息平台</h1>
          <h5 style="color:blue;">v1.0.3116</h5>
        </span>
      </div>
      <div style="display:flex;">
        <el-dropdown>
          <div class="el-dropdown-link circle-button">Liu</div>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>用户设置</el-dropdown-item>
            <el-dropdown-item>修改密码</el-dropdown-item>
            <el-dropdown-item divided>退出系统</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </el-header>
    <el-container>
      <el-aside id="system-nav-menu" width="250px">
        <div class="system-nav-menu">系&nbsp;统&nbsp;菜&nbsp;单</div>
        <el-tabs tab-position="left" type="border-card" style="height:100%;">
          <el-tab-pane>
            <div slot="label">系统</div>
            <div id="nav-menu" class="menu-content">
              <el-menu :default-openeds="defaultOpeneds" class="system-menu-panel">
                <el-submenu index="1">
                  <template slot="title">
                    <font-awesome-icon icon="user-lock"/>
                    <span>用户与权限</span>
                  </template>
                  <el-menu-item index="1-1">
                    <font-awesome-icon icon="user-shield"/>
                    <span>系统账号</span>
                  </el-menu-item>
                  <el-menu-item index="1-2">
                    <font-awesome-icon icon="user-tag"/>
                    <span>业务角色</span>
                  </el-menu-item>
                  <el-menu-item index="1-3">
                    <font-awesome-icon icon="address-card"/>
                    <span>用户统计</span>
                  </el-menu-item>
                </el-submenu>
                <el-submenu index="2">
                  <template slot="title">
                    <font-awesome-icon icon="cogs"/>
                    <span>系统配置</span>
                  </template>
                  <el-menu-item index="2-1">
                    <font-awesome-icon icon="book"/>
                    <span>数据字典</span>
                  </el-menu-item>
                  <el-menu-item index="2-2">
                    <font-awesome-icon icon="sliders-h"/>
                    <span>运行参数</span>
                  </el-menu-item>
                </el-submenu>
                <el-submenu index="3">
                  <template slot="title">
                    <font-awesome-icon icon="cogs"/>
                    <span>系统版本</span>
                  </template>
                  <el-menu-item index="3-1">
                    <font-awesome-icon icon="user-tie"/>
                    <span>客户信息</span>
                  </el-menu-item>
                  <el-menu-item index="3-2">
                    <font-awesome-icon icon="key"/>
                    <span>系统密钥</span>
                  </el-menu-item>
                </el-submenu>                
              </el-menu>
            </div>
          </el-tab-pane>
          <el-tab-pane>
            <div slot="label">规划</div>
            <div>规划</div>
          </el-tab-pane>
          <el-tab-pane>
            <div slot="label">人事</div>
            <div>人事管理</div>
          </el-tab-pane>
          <el-tab-pane>
            <div slot="label">考勤</div>
            <div>考勤管理</div>
          </el-tab-pane>
          <el-tab-pane>
            <div slot="label">绩效</div>
            <div>绩效</div>
          </el-tab-pane>
          <el-tab-pane>
            <div slot="label">薪资</div>
            <div>薪资</div>
          </el-tab-pane>
          <el-tab-pane>
            <div slot="label">培训</div>
            <div>培训</div>
          </el-tab-pane>
          <el-tab-pane>
            <div slot="label">招聘</div>
            <div>招聘</div>
          </el-tab-pane>
          <el-tab-pane>
            <div slot="label">任务</div>
            <div>任务</div>
          </el-tab-pane>
          <el-tab-pane>
            <div slot="label">流程</div>
            <div>流程</div>
          </el-tab-pane>
          <el-tab-pane>
            <div slot="label">分析</div>
            <div>分析</div>
          </el-tab-pane>
        </el-tabs>
      </el-aside>
      <el-main>
        <div class="main-desktop-panel-header">首页>活动管理>活动详情</div>
        <div id="main-desktop-panel">  
          <router-view/>       
        </div>
      </el-main>
    </el-container>
    <el-footer height="30px">Footer</el-footer>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      data2: [
        {
          menuId: "SYS-01",
          menuName: "用户与权限",
          children: [
            {
              menuId: "SYS-01-01",
              menuName: "系统账号",
              programId: "LoginAccount"
            },
            {
              menuId: "SYS-01-02",
              menuName: "角色管理",
              programId: "BusinessRole"
            },
            {
              menuId: "SYS-01-03",
              menuName: "用户在线统计",
              programId: "UserOnlineAccountting"
            }
          ]
        },

        {
          menuId: "SYS-02-01",
          menuName: "数据字典",
          programId: "DataDictionary"
        },
        {
          menuId: "SYS-02-02",
          menuName: "系统参数",
          programId: "SystemParameters"
        },
        {
          menuId: "SYS-03-01",
          menuName: "产品注册",
          programId: "ProductRegistration"
        }
      ],
      treeProps: {
        children: "children",
        label: "menuName"
      },
      defaultOpeneds: ["1", "2", "3", "4", "5"]
    };
  }
};
</script>

<style>
.el-header,
.el-footer {
  position: fixed;
  left: 0;
  width: 100%;
  display: flex;
  display: -webkit-flex;
  align-items: center;
  -webkit-align-items: center;
  justify-content: space-between;
  -webkit-justify-content: space-between;

  background-color: #b3c0d1;
}

.el-header {
  top: 0;
  color: #333;
}

.el-footer {
  bottom: 0px;
  height: 30px;
}

.el-aside {
  position: absolute;
  left: 0;
  top: 50px;
  bottom: 0;

  text-align: left;
}

.circle-button {
  background-color: #e9eef3;
  height: 40px;
  width: 40px;
  line-height: 40px;
  border-radius: 50%;
  cursor: pointer;
  vertical-align: middle;
  font-weight: bolder;
}

.el-tabs__item {
  width: 33px !important;
  height: 100% !important;
  padding: 8px;
  line-height: normal !important;
  word-wrap: normal !important;
  white-space: normal !important;
}

.el-tabs__header {
  padding-right: 0px !important;
}

.el-tabs--border-card > .el-tabs__content {
  padding: 0px !important;
}
#system-nav-menu {
  overflow: hidden;
}

.system-nav-menu {
  height: 35px;
  background-color: royalblue;
  color: white;
  font-size: 16px;
  padding-left: 60px;
  line-height: 35px;
  vertical-align: middle;
}

#system-nav-menu .el-tabs__content,
#system-nav-menu .el-tabs__content > .el-tab-pane {
  height: 100% !important;
}

.menu-content {
  height: 100%;
  padding: 0px;
  margin: 0px;
  overflow-y: auto;
}

.system-menu-panel {
  width: 100%;
}

.el-submenu .el-menu-item {
  padding-left: 2px;
}

.el-main {
  position: absolute;
  left: 250px;
  top: 50px;
  bottom: 50px;
  right: 0;
  padding: 0px 0px 0px 5px;
  text-align: left;
  overflow: hidden;
}

.main-desktop-panel-header {
  width: 100%;
  height: 35px;
  background-color: royalblue;
  color: white;
  font-size: 16px;
  padding-left: 10px;
  line-height: 35px;
  vertical-align: middle;
}

#main-desktop-panel {
  background-color: normal !important;
  padding: 0px;
  margin: 0px;
  height: 100%;
  width: 100%;
  border-left: 1px solid rgb(220, 223, 230);
  overflow: auto !important;
}
</style>

