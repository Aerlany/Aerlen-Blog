<template>
    <div class="body">
        <div class="container" v-bind:class="success">
            <h1>Welcome</h1>
            <div class="form">

                <input type="text" placeholder="您的账号" v-model="formData.username">
                <input type="password" placeholder="您的密码" v-model="formData.password">
                <button class="btn-login" @click="submit()">登录</button>
                <button class="btn-regin" @click="regin()">注册</button>

            </div>
        </div>
        <ul class="bg-squares">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>

</template>

<script>
import api from '@/api/api'

export default {
    name: " LoginPage",
    data() {
        return {
            success: "",
            formData: {
                username: "",
                password: ""
            },
        }
    },
    methods: {
        submit() {
            if (this.formData.username && this.formData.password.length >= 6) {
                api.post("/users/addUser", this.formData, (resp) => {
                    if (resp.data.flag == true) {
                        this.$message({
                            type: 'success',
                            message: 'Welcome !!'
                        });
                        localStorage.setItem("username", this.formData.username);
                        localStorage.setItem("password", this.formData.password);
                        this.success = "success";
                        setTimeout(() => {
                            this.$router.push({ path: '/mainPage' });
                        }, 2000);
                    } else {
                        this.$message({
                            type: 'error',
                            message: '登录失败!用户名或密码有误'
                        });
                    }
                })
            } else {
                this.$message({
                    type: 'error',
                    message: '用户名或密码格式错误!'
                });
            }
        },
        regin() {
            this.$confirm('是否提交 ?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                if (this.formData.username && this.formData.password.length >= 6) {
                    api.post("/users", this.formData, (resp) => {
                        if (resp.data.flag) {
                            this.$message({
                                type: 'success',
                                message: '注册成功!!'
                            });

                        } else {
                            this.$message({
                                type: 'error',
                                message: '注册失败!!'
                            });
                        }
                        setTimeout(() => {
                            window.location.reload();
                        }, 2000);
                    })
                } else {
                    this.$message({
                        type: 'error',
                        message: '用户名或密码格式错误!(密码必须大于6位)'
                    });
                }
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消'
                });
            });

        }
    },
} 
</script>
<style scoped>
* {
    /* 初始化 */
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

.body {
    height: 100vh;
    /* 弹性布局 居中显示 */
    display: flex;
    justify-content: center;
    align-items: center;
    /* 渐变背景 */
    background: linear-gradient(to top left, #0c08e2, #03e8f4, #fefefe);
    /* 溢出隐藏 */
    overflow: hidden;
}

.container {
    text-align: center;
    color: #fff;
}

.container h1 {
    font-size: 40px;
    font-weight: 100;
    letter-spacing: 2px;
    margin-bottom: 15px;
    /* 过渡效果 */
    transition: 1s ease-in-out;
}

.form {
    display: flex;
    flex-direction: column;
    align-items: center;
    position: relative;
    z-index: 2;
    opacity: 1;
    /* 不透明度改变时的过渡效果 */
    transition: opacity 0.5s;
}

.form input {
    outline: none;
    border: 1px solid rgba(255, 255, 255, 0.4);
    background-color: rgba(255, 255, 255, 0.2);
    width: 250px;
    padding: 10px 15px;
    border-radius: 3px;
    margin: 0 auto 10px auto;
    text-align: center;
    color: #fff;
    font-size: 15px;
    transition: 0.25s;
}

.form input::placeholder {
    color: #fff;
    font-size: 14px;
    font-weight: 300;
}

.form input:hover {
    background-color: rgba(255, 255, 255, 0.4);
}

.form input:focus {
    background-color: #fff;
    width: 300px;
    color: #ff719a;
}

.btn-login {
    outline: none;
    background-color: #fff;
    color: #ff719a;
    border: none;
    width: 250px;
    padding: 10px 15px;
    border-radius: 3px;
    font-size: 15px;
    cursor: pointer;
    transition: 0.25s;
}

.btn-login:hover {
    background-color: #f5f7f9;
}

.btn-regin {
    outline: none;
    border: 1px solid rgba(255, 255, 255, 0.4);
    background-color: rgba(255, 255, 255, 0.2);
    width: 250px;
    padding: 10px 15px;
    border-radius: 3px;
    margin: 10px auto 10px auto;
    text-align: center;
    color: #fff;
    font-size: 15px;
    transition: 0.25s;
}

.btn-regin:hover {
    background-color: #16a6df;
}

.btn-skip {
    outline: none;
    border: 1px solid rgba(255, 255, 255, 0.4);
    background-color: rgba(255, 255, 255, 0.2);
    width: 250px;
    padding: 10px 15px;
    border-radius: 3px;
    margin: 10px auto 10px auto;
    text-align: center;
    color: #fff;
    font-size: 15px;
    transition: 0.25s;
}

.btn-skip:hover {
    background-color: #16a6df;
}

/* 背景方块 */
.bg-squares {
    list-style: none;
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 1;
}

.bg-squares li {
    width: 40px;
    height: 40px;
    background-color: rgba(255, 255, 255, 0.15);
    position: absolute;
    bottom: -160px;
    /* 执行动画：动画名 时长 线性 无限次播放 */
    animation: square 20s linear infinite;
}

/* 为每一个方块设置不同的位置、大小、动画延迟时间、动画时长、背景色 */
.bg-squares li:nth-child(1) {
    left: 10%;
}

.bg-squares li:nth-child(2) {
    left: 20%;
    width: 80px;
    height: 80px;
    /* 动画延迟时间 */
    animation-delay: 2s;
    /* 动画时长 */
    animation-duration: 17s;
}

.bg-squares li:nth-child(3) {
    left: 25%;
    animation-delay: 4s;
}

.bg-squares li:nth-child(4) {
    left: 40%;
    width: 60px;
    height: 60px;
    background-color: rgba(255, 255, 255, 0.25);
    animation-duration: 22s;
}

.bg-squares li:nth-child(5) {
    left: 70%;
}

.bg-squares li:nth-child(6) {
    left: 80%;
    width: 120px;
    height: 120px;
    background-color: rgba(255, 255, 255, 0.2);
    animation-delay: 3s;
}

.bg-squares li:nth-child(7) {
    left: 32%;
    width: 160px;
    height: 160px;
    animation-delay: 7s;
}

.bg-squares li:nth-child(8) {
    left: 55%;
    width: 20px;
    height: 20px;
    animation-delay: 15s;
    animation-duration: 40s;
}

.bg-squares li:nth-child(9) {
    left: 25%;
    width: 10px;
    height: 10px;
    background-color: rgba(255, 255, 255, 0.3);
    animation-delay: 2s;
    animation-duration: 40s;
}

.bg-squares li:nth-child(10) {
    left: 90%;
    width: 160px;
    height: 160px;
    animation-delay: 11s;
}

.container.success h1 {
    transform: translateY(75px);
}

.container.success .form {
    opacity: 0;
}

/* 定义动画 */
@keyframes square {
    0% {
        transform: translateY(0);
    }

    100% {
        transform: translateY(-120vh) rotate(600deg);
    }
}
</style>