const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false, //关闭语法检查

  devServer: {
    proxy: 'http://localhost:8080'
    // proxy: 'http://39.105.177.248:8080',
  }
})
