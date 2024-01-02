//用于创建路由器
import VueRouter from "vue-router";

//引入组件
import searchPage from '@/pages/searchPage'
import mainPage from '@/pages/mainPage'
import articleManger from '@/pages/articleManger'
import userHomePage from '@/pages/userHomePage'
import LoginPage from '@/components/LoginPage'
import showMain from '@/pages/showMain'

export default new VueRouter({
    routes: [
        {
            path: "/",
            component: showMain,
            children: [
                {
                    path: 'mainPage', //  此处不能写/
                    component: mainPage
                },
                {
                    path: "searchPage",
                    component: searchPage
                },
                {
                    path: "articleManger",
                    component: articleManger
                },
                {
                    path: "userHomePage",
                    component: userHomePage,
                    children: [
                        {
                            path: 'updatePage', //  此处不能写/
                            component: articleManger
                        }
                    ]
                },
            ]
        },
        {
            path: "/login",
            component: LoginPage
        },


    ]
})