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
                <li style="--l:30%" @click="changepage(2)">
                    <router-link to="/searchPage"><a><i class="fas fa-search"></i></a>
                    </router-link>
                </li>
                <li style="--l:40%" @click="changepage(3)">
                    <router-link to="/articleManger"><a><i class="fas fa-feather-alt"></i></a>
                    </router-link>
                </li>
                <li style="--l:50%" @click="changepage(4)">
                    <router-link to="/userHomePage"><a><i class="fas fa-user"></i></a></router-link>
                </li>

                <div class="top"></div>
                <div class="middle"></div>
                <div class="bottom"></div>
            </div>

            <!-- <aplayer class="aplayer" autoplay :music="musicSrc" :list="list" /> -->


        </div>

        <div class="main">

            <transition name="el-fade-in-linear">
                <router-view></router-view>
            </transition>

        </div>

        <!-- 其它展示 -->
        <div class="right">
            <div class="userMessage" v-if="isLogin">
                <div class="textBody" style="height: 40vh;">
                    <p class="title">{{ Username }}</p>
                    <p class="text" style="text-align:center">article signature</p>
                </div>
            </div>
        </div>

    </div>
</template>

<script>
// import NavigationBar from './NavigationBar.vue';

//音乐播放器组件
// import aplayer from 'vue-aplayer'
import api from '@/api/api.js'


export default {
    name: "PageBody",
    data() {
        return {
            musicSrc: {
                title: '日落大道',
                artist: '梁博',
                src: 'http://39.105.177.248/music/test4.flac',
                pic: 'http://39.105.177.248/music/test4.png',
            },
            list: [
                {
                    title: '好想爱这个世界啊',
                    artist: '华晨宇',
                    src: 'http://39.105.177.248/music/test1.flac',
                    pic: 'http://39.105.177.248/music/test1.png'
                },
                {
                    title: '烟火里的尘埃',
                    artist: '华晨宇',
                    src: 'http://39.105.177.248/music/test2.mp3',
                    pic: 'http://39.105.177.248/music/test2.jpeg'
                },
                {
                    title: '句号',
                    artist: '邓紫棋',
                    src: 'http://39.105.177.248/music/test3.mp3',
                    pic: 'http://39.105.177.248/music/test3.jpg'
                },
                {
                    title: '日落大道',
                    artist: '梁博',
                    src: 'http://39.105.177.248/music/test4.flac',
                    pic: 'http://39.105.177.248/music/test4.png',
                    // lrc: 'http://39.105.177.248/music/test4.lrc'
                },
            ],
            Username: "",
            isLogin: false
        }
    },
    methods: {
        //跳转界面
        changepage(index) {
            //回到顶部
            if (index == 1) {

                this.$bus.$emit("reLodeMainPage");
            } else if (index == 2) {

            } else if (index == 3) {

            } else if (index == 4) {

                this.$bus.$emit("reLodeUserHomePage");
            }
            window.scrollTo(0, 0);
        }
    },
    mounted() {
        //检测登录状态
        api.getUserStatus((status) => {
            this.isLogin = status;
        })
        this.Username = localStorage.getItem("username");
    },
    components: {
        //音乐播放器
        // aplayer,
    }
}
</script>

<style scoped>
@import "https://cdn.bootcdn.net/ajax/libs/font-awesome/5.15.3/css/all.css";
@import "@/style/css/dataList.css";
@import "@/style/css/NavigationBar.css";

.aplayer {
    position: fixed;
    bottom: 5px;
    left: 5px;
    width: 300px;
}

.container {
    display: flex;
    padding-top: 50px;
    /* background: linear-gradient(to left, #02fff2, #ffffff); */
}

.left {
    margin-right: 20px;
    padding: 10px;
    width: 330px;

    /* background-color: rgb(219, 24, 24); */
}

.right {
    margin-left: 20px;
    padding: 10px;
    width: 330px;

    /* background-color: rgb(20, 208, 86); */
}

.userMessage {
    /* background-color: #fff; */
    display: block;
    width: 300px;
    /* background-color: rgb(48, 178, 185); */
    position: sticky;
    top: 10px;
}

.main {
    flex: 1;
    max-width: 1290px;
}
</style>