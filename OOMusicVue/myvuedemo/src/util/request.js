import axios from 'axios'
// 添加响应拦截器
axios.interceptors.response.use(function (response) {
    // 只返回响应数据，不返回其他的
    return response.data;
  }, function (error) {
    // 只返返回错误信息，不返回其他信息
    return error.data;
  });

export default {
  post(url, data) {
      return axios({
        method: 'post',
        url,
        // data: qs.stringify(data),
        data,
        timeout: 15000,
        headers: {
          // 'X-Requested-With': 'XMLHttpRequest',
          // 'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
          'content-type': 'application/json;charset=UTF-8'
        }
      }).then(
        (response) => {
          return response
        }
      ).then(
        (res) => {
          return res
        }
      )
    },
    //文件上传
    upload(url, data) {
      let form = new FormData()
      Object.keys(data).forEach(value => {
        form.append(value, data[value])
      })
      return axios({
        method: 'post',
        // baseURL: process.env.BASE_API,
        url,
        data,
        transformRequest: [function (data) {
          let ret = ''
          for (let it in data) {
            ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
          }
          return ret
        }],
        timeout: 15000,
        headers: {
          // 'X-Requested-With': 'XMLHttpRequest',
          'Content-Type': 'application/x-www-form-urlencoded'
        }
      }).then(
        (response) => {
          return response
        }
      ).then(
        (res) => {
          return res
        }
      )
    },

    get(url, params) {
      return axios({
        method: 'get',
        // baseURL: process.env.BASE_API,
        url,
        params, // get 请求时带的参数
        timeout: 15000
      }).then(
        (response) => {
          return response
        }
      ).then(
        (res) => {
          return res
        }
      )
    },
    put(url, data) {
      return axios({
        method: 'put',
        baseURL: process.env.BASE_API,
        url,
        data,
        timeout: 15000
      }).then(
        (response) => {
          return response
        }
      ).then(
        (res) => {
          return res
        }
      )
    }
}
