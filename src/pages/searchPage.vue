<template>
    <!-- 全站搜索 -->
    <div>

        <div style="display: flex; justify-content:center;">
            <input placeholder="请输入内容" v-model="SearchValue"
                style="margin-right: 20px;width:500px; border-radius: 20px; text-align: center;"
                @keyup.enter="Search()" />
            <el-button icon="el-icon-search" circle @click="Search()"></el-button>
        </div>

        <!-- 搜索数据 -->
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
        </div>

    </div>


</template>

<script>
import api from '@/api/api'
import mainPageChild from '@/components/mainPageChild.vue';

export default {
    name: "searcgPage",
    components: {
        mainPageChild
    },
    data() {
        return {
            tableDatas: [],
            SearchValue: ''
        }
    },
    methods: {
        Search() {
            api.get("/pages/2/" + this.SearchValue, "", (resp) => {
                this.tableDatas = resp.data.data;
            })
        }
    },
    mounted() {

    }
}
</script>

<style>
@import "@/style/css/dataList.css";
</style>