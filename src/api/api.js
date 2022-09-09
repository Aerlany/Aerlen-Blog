import axios from 'axios';

/**
 * 公共网络请求
 * @param {*} url 
 * @param {*} paramsData 
 * @returns 
 */

const api = {
    async get(url, data, callback) {
        let res = await axios({
            url: url,
            method: "GET",
            params: data || "",
            // ContentType: "application/x-www-form-urlencoded"
        })
        callback && callback(res)
    },

    async post(url, data, callback) {
        let res = await axios({
            url: url,
            method: "POST",
            data: data || "",
            // ContentType: "application/x-www-form-urlencoded"
        })
        callback && callback(res)
    },

    async del(url, data, callback) {
        let res = await axios({
            url: url,
            method: "DELETE",
            data: data || "",
            // ContentType: "application/x-www-form-urlencoded"
        })
        callback && callback(res)
    },
}
export default api

