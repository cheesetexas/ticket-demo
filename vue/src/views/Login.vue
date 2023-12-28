<template>
  <el-header style="margin: 0; padding: 0">
    <Header/>
  </el-header>
  <div style="font-family: Arial, sans-serif; text-align: center">
    <div style="width: 100%; height: 94vh; overflow: hidden; background-color: aliceblue">
      <div style="width: 400px; margin: 150px auto;">
        <el-card>
          <div style="color: black; font-size: 30px; padding-bottom: 30px">
            车票管理系统
          </div>
          <el-form ref="form" :model="form" :rules="rules">
            <el-form-item prop="email">
              <el-input
                  prefix-icon="Message"
                  v-model="form.username"
                  placeholder="请输入用户名"
              />
            </el-form-item>
            <el-form-item prop="password">
              <el-input
                  prefix-icon="Lock"
                  v-model="form.password"
                  type="password"
                  autocomplete="off"
                  show-password
                  placeholder="请输入密码"
              />
            </el-form-item>
            <div style="text-align: center">
              <el-button type="primary" @click="login" style="width: 100%">登录</el-button>
            </div>
          </el-form>
        </el-card>
      </div>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
import Header from "@/components/Header.vue";
import { getCookie, deleteCookie } from "@/utils/cookie";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Login",
  components: {
    Header
  },
  data() {
    return {
      user: {},
      form: {},
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur'}
        ]
      },
      loading: false
    }
  },
  created() {
    if(getCookie("user")) {
      deleteCookie("user")
    }
  },
  methods: {
    login() {
      this.$refs.form.validate((valid) => {
        if(valid) {
          request.post("/user/login", this.form).then(res => {
            if(res.msg === "success") {
              this.$router.push("/home")
            } else {
              this.$message({
                type: "error",
                message: res.msg,
                customClass: "font"
              })
            }
          })
        } else {
          this.$message({
            type: "error",
            message: "请输入用户名和密码",
            customClass: "font"
          })
        }
      })
    }
  }
}
</script>

<style>
.font {
  font-family: Arial, sans-serif;
}
</style>