<template>
    <div>
        <mavon-editor v-model="content" ref="md" @change="change" style="min-height: 600px" />

        <center v-if="type"><button class="btn" @click="submit">提交</button></center>
        <center v-if="!type"><button class="btn" @click="update">修改</button></center>

    </div>
</template>



<script>
import api from '@/api/api'
import { mavonEditor } from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
export default {
    // 注册
    name: "markDown",
    components: {
        mavonEditor
    },
    props: ["date", "title", "type","content"],
    data() {
        return {
            content: '', // 输入的markdown
            html: '',    // 及时转的html

            tableDatas: {
                username: "",
                date: "",
                title: "",
                content: "",
            },
        }
    },
    methods: {
        // 所有操作都会被解析重新渲染
        change(value, render) {
            // render 为 markdown 解析后的结果[html]
            this.html = render;
        },
        // 提交
        submit() {
            // console.log(this.content);
            // console.log(this.html);

            this.tableDatas.username = "张三";
            this.tableDatas.date = this.date;
            this.tableDatas.title = this.title;
            this.tableDatas.content = this.content;

            this.$confirm('是否提交 ?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                api.post("/pages", this.tableDatas, (resp) => {
                    if (resp.data.flag) {
                        this.$message({
                            type: 'success',
                            message: '添加成功!'
                        });
                        setTimeout(() => {
                            window.location.reload();
                        }, 1000);
                    } else if (resp.status != 200) {
                        this.$message({
                            type: 'error',
                            message: '添加失败!'
                        });
                    }
                })
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消'
                });
            });

        },
        //修改
        update() {
            // console.log(this.content);
            // console.log(this.html);

            this.tableDatas.username = "张三";
            this.tableDatas.date = this.date;
            this.tableDatas.title = this.title;
            this.tableDatas.content = this.content;

            this.$confirm('是否提交 ?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                api.post("/pages", this.tableDatas, (resp) => {
                    if (resp.data.flag) {
                        this.$message({
                            type: 'success',
                            message: '添加成功!'
                        });
                        setTimeout(() => {
                            window.location.reload();
                        }, 1000);
                    } else if (resp.status != 200) {
                        this.$message({
                            type: 'error',
                            message: '添加失败!'
                        });
                    }
                })
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消'
                });
            });

        },
    },
    mounted() {

    }
}
</script>
<style scoped>
@import "@/style/css/dataList.css";

.btn {
    margin-top: 20px;
    margin-bottom: 20px;
    padding-left: 30px;
    padding-right: 30px;
}
</style>