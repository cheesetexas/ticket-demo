<template>
  <span>你好，{{ this.user.username }}</span>
</template>


<script>
import {getCookie} from "@/utils/cookie";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Home",
  data() {
    return {
      user: {}
    }
  },
  created() {
    this.user = JSON.parse(getCookie("user"));
    this.$nextTick(() => {
      // this.load()
    });
  },
}
</script>
