<template>
  <div style="
    display: flex;
    background-color: #24292f;
    font-family: Arial, sans-serif;
    height: 6vh
    ">
    <div style="padding-top: 15px; padding-left: 15px">
      <el-button link style="font-weight: bold; font-size: 30px; color: white;">
        车票管理系统
      </el-button>
    </div>
    <div style="flex: 1" />
    <div style="min-width: 80px; padding-top: 15px; padding-right: 15px; font-family: Arial, sans-serif">
      <el-button color="#24292f" @click="goToLogin" style="font-size: 30px; color: white" v-if="!this.login">
        登录
      </el-button>
      <el-button color="#24292f" @click="goToLogin" style="font-size: 30px; color: white" v-if="this.login">
        退出
      </el-button>
    </div>
  </div>
</template>

<script>
import { getCookie } from "@/utils/cookie";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Header",
  data() {
    return {
      user: {},
      sessionId: "",
      login: false
    }
  },
  created() {
    if(getCookie("user")) {
      this.user = JSON.parse(getCookie("user"))
      this.login = true
    } else {
      this.login = false
    }
  },
  methods: {
    goToLogin() {
      this.$router.push("/login")
    }
  }
}
</script>