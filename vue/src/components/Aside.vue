<template>
  <div style="font-weight: bold;
    font-family: Arial, sans-serif;
    color: white;"
  >
    <el-menu
        style="min-height: 94vh; font-weight: bold"
        :default-active="path"
        router
        background-color="#323744"
        text-color="#ffffff"
        active-text-color="#3888e4"
        :collapse="isCollapse"
        :collapse-transition=false
        :style="{ width: isCollapse ? '64px' : '220px' }"
    >
      <el-button
          @click="toggleCollapse"
          style="min-height: 4vh; border-radius: 0" color="#323744"
          :style="{ width: isCollapse ? '63px' : '219px' }"
      >
        <el-icon v-if="!isCollapse"><Fold /></el-icon>
        <el-icon v-if="isCollapse"><Expand /></el-icon>
      </el-button>
      <el-menu-item index="/home">
        <el-icon><HomeFilled /></el-icon>
        <span>首页</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
import { getCookie } from "@/utils/cookie";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Aside",
  data() {
    return {
      user: {},
      isCollapse: false,
      path: this.$route.path
    }
  },
  created() {
    this.user = JSON.parse(getCookie("user"))
  },
  methods: {
    toggleCollapse() {
      this.isCollapse = !this.isCollapse;
      this.$emit("getIsCollapse", this.isCollapse);
    }
  }
}
</script>