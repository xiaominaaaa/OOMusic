

<template>
  <div>
    <el-row :gutter="20" justify="center">
      <el-col :span="8">
        <div class="grid-content bg-purple">
          <img class="image" src="../assets/image/01-3.jpg" />
        </div>
      </el-col>
      <el-col :span="16" >
          <div class="div">
            <h2 style="font-size: 36px;margin: 20px 0;">欢迎登录OO</h2>
            <h3 style="font-size: 25px;margin: 20px 0;">每一天，乐在沟通</h3>
            <div class="div2">
            <el-form ref="form" :model="form" :rules="rules" >
                <el-form-item prop="username" >
                  <el-input v-model="form.username" placeholder="昵称"></el-input>
                </el-form-item>
                <el-form-item prop="password">
                  <el-input v-model="form.password" placeholder="密码" type="password"></el-input>
                </el-form-item>
              <el-form-item style=";">
                <el-button type="primary"  @click="login('form')">登录</el-button>
                <el-button @click="$router.push('/user/reg')">注册</el-button>
              </el-form-item>
            </el-form>
            </div>
          </div>
        </el-col>
    </el-row>
  </div>
</template>
<script>
    export default {
        name: "Register",
        data(){
          return{
            form:{
              username:"",
              password:"",
              sex:"",
              email:"",
              phone:"",
            },
            rules:{
              username:[
                  { required: true, message: '请输入昵称', trigger: 'blur' },
                  {  max: 20, message: '昵称 在20个字符以内，但不能为空', trigger: 'blur' }
                ],
                password:[
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    {  max: 16,min:3, message: '密码在3~16位之间', trigger: 'blur' }
                  ],
            }

          }
        },
        methods: {
          login: function(formName){
           this.$refs[formName].validate((valid) => {
             if (valid) {
                  this.post(this.api.API_USER_LOGIN,{
                    userName:this.form.username,
                    userPassword:this.form.password,
                  }).then(response =>{
                    if(Boolean(response)){
                      //加入Session内存
                      this.Session.set("user",response);
                       this.$message({
                        message:'用户登录成功,三秒后回到主页......',
                        type: 'success',
                        onClose: call =>{
                            setTimeout(()=>{
                               this.$router.push("/main")
                            },1000)
                        }
                        });
                    }else{
                       this.$message.error('用户名或者账号不正确');
                    }

                  })
               } else {
                 console.log('error submit!!');
                 return false;
               }
             });
          },
        }

    }
</script>
<style scoped>
 .image{
   width: 100%;
   height: 100%;
 }

 .div{
   margin-left: 20%;
   margin-top: 10%;
   width: 100%;
   height: 100%;
   align-content: center;
 }

 .div2{
   width:40%;
 }
 </style>
