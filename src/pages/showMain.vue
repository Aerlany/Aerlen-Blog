<template>
    <div class="showMain">
        <PageHead></PageHead>
        <PageBody></PageBody>
    </div>
</template>

<script>
import PageHead from '@/components/PageHead.vue'
import PageBody from '@/components/PageBody.vue'

export default {
    name: 'showMain',
    components: {
        PageHead,
        PageBody,
    },
    mounted() {
        this.$router.push({ path: '/mainPage' });
    },
}
</script>

<style scoped>

</style>
 