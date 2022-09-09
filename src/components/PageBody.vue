<template>
    <!-- 导航栏 -->
    <div class="container">
        <div class="left">
            <!-- <NavigationBar></NavigationBar> -->
            <div class="main2">
                <li style="--l:20%" @click="changepage(1)">
                    <router-link to="/mainPage"><a><i class="fas fa-home"></i></a>
                    </router-link>
                </li>
                <li style="--l:30%" @click="changepage()">
                    <router-link to="/searchPage"><a><i class="fas fa-search"></i></a>
                    </router-link>
                </li>
                <li style="--l:40%" @click="changepage()">
                    <router-link to="/articleManger"><a><i class="fas fa-feather-alt"></i></a>
                    </router-link>
                </li>
                <li style="--l:50%" @click="changepage()">
                    <router-link to="/userHomePage"><a><i class="fas fa-user"></i></a></router-link>
                </li>

                <div class="top"></div>
                <div class="middle"></div>
                <div class="bottom"></div>
            </div>

        </div>

        <div class="main">

            <transition name="el-fade-in-linear">
                <router-view></router-view>
            </transition>

        </div>

        <!-- 其它展示 -->
        <div class="right">
        </div>

    </div>
</template>

<script>
// import NavigationBar from './NavigationBar.vue';

export default {
    name: "PageBody",
    data() {
        return {
        }
    },
    methods: {
        //跳转界面
        changepage(index) {
            //回到顶部
            if (index == 1) {
                this.$bus.$emit("reLodeMainPage");
            }
            window.scrollTo(0, 0);
        }
    },
    mounted() {
    },
    components: {
    }
}
</script>

<style scoped>
@import "https://cdn.bootcdn.net/ajax/libs/font-awesome/5.15.3/css/all.css";
@import "@/style/css/dataList.css";
@import "@/style/css/NavigationBar.css";


.container {
    display: flex;
    margin-top: 50px;
}

.left {
    margin-right: 20px;
    padding: 10px;
    width: 280px;
    /* background-color: rgb(219, 24, 24); */
}

.right {
    margin-left: 20px;
    padding: 10px;
    width: 280px;
    /* background-color: rgb(20, 208, 86); */
}

.main {
    flex: 1;
    max-width: 1290px;
}
</style>