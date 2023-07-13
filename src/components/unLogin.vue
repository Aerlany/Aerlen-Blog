<template>
    <div>
        <h2 @click="submit">登录体验更多功能</h2>
    </div>
</template>

<script>
export default {
    name: "unLogin",
    data() {
        return {

        }
    },
    methods: {
        submit() {
            this.$router.push({ path: '/login' });
        }
    },
}
</script>

<style scoped>
h2 {
    cursor: help;
    text-align: center;
}
</style>