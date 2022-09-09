<template>
    <!-- 个人主页 -->
    <div>
        <div class="box1">
            <transition-group v-show="isShow" name="list" appear tag="ul" class="timeLink">
                <li v-for="timeLinkData in timeLinkDatas" :key="timeLinkData.id">
                    <div class="Link"></div>
                    <transition name="biaoti" appear>
                        <section>
                            <div class="textBody">
                                <p>
                                    <span>{{ timeLinkData.date }}</span>
                                    <router-link active-class="active"
                                        :to="`/userHomePage/updatePage?id=` + timeLinkData.id" tag="span">
                                        <span class="text" @click="isShow = !isShow">{{ timeLinkData.title }}</span>
                                    </router-link>
                                </p>
                                <span></span>
                                <hr>
                            </div>
                        </section>
                    </transition>
                </li>
            </transition-group>
        </div>
        <router-view></router-view>
    </div>

</template>

<script>
import api from '@/api/api'

export default {
    name: "userHomePage",
    data() {
        return {
            timeLinkDatas: [],
            isShow: true,
        }
    },
    methods: {
        getAll() {
            this.timeLinkDatas = [];
            api.get("/pages/getTimeLinkMessage", "", (resp) => {
                this.timeLinkDatas = resp.data.data;
            })
        },

    },
    mounted() {
        this.getAll();
    }
}
</script>

<style scoped>
@import "@/style/css/dataList.css";

.textBody:hover {
    border-radius: 10px;
    transition: 0.1s linear;
}

hr {
    margin-left: -10px;
    margin-top: 10px;
    min-width: 100vh;
    opacity: 0.2;
}

.box1 {
    display: flex;
    margin-top: 20px;
    margin-bottom: 20px;
    /* background-color: rgb(168, 15, 15); */
}

.timeLink {
    list-style: none;
}

.timeLink li {
    display: flex;
    min-height: 8vh;
}

.Link {
    display: flex;
    flex-flow: column;
    align-items: center;
    margin-right: 10px;
}

.Link::before {
    width: .5rem;
    height: .5rem;
    border-radius: 50%;
    content: "";
    background-color: #bbb;
}

.Link::after {
    border-left: 2px solid #bbb;
    content: "";
    flex-grow: 1;
}

.list-move,
/* 对移动中的元素应用的过渡 */
.list-enter-active,
.list-leave-active {
    transition: all 2s ease;
}

.list-enter,
.list-leave-to {
    opacity: 0;
    transform: translateX(-30px);
}

/* 确保将离开的元素从布局流中删除
  以便能够正确地计算移动的动画。 */
.list-leave-active {
    position: absolute;
}


.biaoti-enter {
    opacity: 0;
    transform: translateX(30px);
}

.biaoti-enter-active {
    transition: all 1s linear;
}
</style>