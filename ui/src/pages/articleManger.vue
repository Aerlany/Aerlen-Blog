<template>
    <!-- 文章管理 -->
    <div class="textBody">
        <div v-if="!isLogin">
            <unLogin></unLogin>
        </div>
        <div v-if="isLogin">
            <p class="title" style="font-family: 楷体; margin-bottom: 10px;">文章管理</p>
            <!-- 时间 和 标题 -->
            <div>
                <el-input type="text" placeholder="请输入标题" v-model="title" clearable class="title2">
                </el-input>
                <el-date-picker v-model="date" align="right" type="date" placeholder="选择日期" class="Date2"
                    :picker-options="pickerOptions" value-format="yyyy-MM-dd">
                </el-date-picker>
            </div>
            <MarkDown :date="date" :title="title" :type="type" :content="content" :id="id"></MarkDown>
        </div>
    </div>
</template>

<script>
import api from '@/api/api'
import MarkDown from '@/components/markDown.vue';
import unLogin from '@/components/unLogin.vue'

export default {
    name: "articleManger",
    data() {
        return {
            //时间选择器
            pickerOptions: {
                disabledDate(time) {
                    return time.getTime() > Date.now();
                },
                shortcuts: [{
                    text: "今天",
                    onClick(picker) {
                        picker.$emit("pick", new Date());
                    }
                }, {
                    text: "昨天",
                    onClick(picker) {
                        const date = new Date();
                        date.setTime(date.getTime() - 3600 * 1000 * 24);
                        picker.$emit("pick", date);
                    }
                }, {
                    text: "一周前",
                    onClick(picker) {
                        const date = new Date();
                        date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
                        picker.$emit("pick", date);
                    }
                }]
            },
            id: "",
            //标题
            title: "",
            //时间
            date: "",
            //类型
            type: true,
            //内容
            content: '',

            //登录验证
            isLogin: false,
        };
    },
    components: { MarkDown, unLogin },
    methods: {
        getMessage() {
            api.get("/pages/1/" + this.$route.query.id, "", (resp) => {
                this.title = resp.data.data.title;
                this.date = resp.data.data.date;
                this.content = resp.data.data.content;
            })
        }
    },
    mounted() {
        if (this.$route.query.id != undefined) {
            this.type = false;
            this.id = this.$route.query.id;

            //针对页面（再刷新一次）
            setTimeout(() => {
                this.getMessage();
            }, 10);
        }

        //检测登录状态
        api.getUserStatus((status) => {
            this.isLogin = status;
        })
    },
}
</script>

<style scoped>
@import "@/style/css/dataList.css";

/* * {
    margin: 0;
    padding: 0;
} */

.Date2 {
    width: 50%;
}

.title2 {
    width: 50%;
}
</style>