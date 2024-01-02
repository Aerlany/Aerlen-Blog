<template>
    <!-- 主页 -->
    <div>
        <div v-for="(tableData, index) in tableDatas" :key="index" class="article">
            <div class="textBody">
                <h1 class="title">{{ tableData.title }}</h1>
                <div class="message">
                    <span></span>
                    <p>{{ tableData.date }}</p>
                    <p>{{ tableData.username }}</p>
                    <span></span>
                </div>
                <div class="text">
                    <mainPageChild :content="tableData.content"></mainPageChild>
                </div>
            </div>
        </div>

        <!-- 分页 -->
        <div style="text-align: center;margin-top: 20px; margin-bottom: 30px;">
            <div class="block">
                <el-pagination @current-change="handleCurrentChange" :current-page.sync="currentPage" :page-size="5"
                    layout="total, prev, pager, next" :total="Count">
                </el-pagination>
            </div>
        </div>
    </div>
</template>

<script>
import api from '@/api/api'
import mainPageChild from '@/components/mainPageChild.vue'

export default {
    name: "mainPage",
    components: {
        mainPageChild,
    },
    data() {
        return {
            //getAll 数据
            tableDatas: [],

            //getAll 数据 用于分页统计总数据数
            Count: 0,

            //当前页
            currentPage: 1,
        }
    },
    methods: {
        //查询所有
        getAll() {
            this.tableDatas = [];
            api.get("/pages/4/" + this.currentPage, "", (resp) => {
                this.tableDatas = resp.data.data;
            })
        },

        //查询Count
        getCount() {
            api.get("/pages/getCount", "", (resp) => {
                this.Count = resp.data.data;
            })
        },

        //翻页栏
        handleCurrentChange(val) {
            this.currentPage = val;
            this.getAll();
            window.scrollTo(0, 0);
        },
    },
    mounted() {
        this.$bus.$on("reLodeMainPage", () => {
            this.currentPage = 1;
            this.getAll();
        });
        this.getAll();
        this.getCount();
    }
}
</script>

<style>
@import "@/style/css/dataList.css";
</style>