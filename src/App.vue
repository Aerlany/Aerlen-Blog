<template>
  <div class="root">
    <router-view></router-view>
  </div>
</template>

<script>
import PageHead from './components/PageHead.vue'
import PageBody from './components/PageBody.vue'
import LoginPage from './components/LoginPage.vue'


export default {
  name: 'App',
  components: {
    PageHead,
    PageBody,
    LoginPage,
  },
}
</script>

<style>
* {
  margin: 0;
  padding: 0;
}

.root {
  /* display: flex; */
  min-height: 100vh;
  background-color: #f5f7f9;
  background-repeat: repeat-y;
}
</style>
 