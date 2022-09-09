<template>
    <div>
        <mavon-editor v-model="content" class="two" :class="change" :toolbarsFlag="false" :editable="false"
            :subfield="false" defaultOpen="preview" :navigation="true">
        </mavon-editor>
        <center><button class="btn" @click="showAll()">阅读全文 >></button></center>
    </div>
</template>

<script>
import { mavonEditor } from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
export default {
    name: "mainPageChild",
    data() {
        return {
            change: ""
        }
    },
    components: {
        mavonEditor
    },
    props: ["content"],
    methods: {
        showAll() {
            if (this.change == "") {
                this.change = "one"
            } else {
                this.change = ""
            }
        }
    }
}
</script>

<style>
@import "@/style/css/dataList.css";

.two {
    max-height: 100px;
    transition: 0.3s linear;
}

.one {
    max-height: 1080px;
    transition: 0.3s linear;
}

.btn {
    margin-top: 30px;
}
</style>