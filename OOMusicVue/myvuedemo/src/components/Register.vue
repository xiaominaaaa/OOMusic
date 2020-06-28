<template>
  <div>
    <el-row :gutter="20" justify="center">
      <el-col :span="8">
        <div class="grid-content bg-purple">
          <img class="image" src="../assets/image/01-1.jpg" />
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
                 <el-form-item prop="email">
                   <el-input v-model="form.email" placeholder="邮箱" ></el-input>
                 </el-form-item>
                 <el-form-item prop="phone">
                   <el-input v-model="form.phone" placeholder="手机号" ></el-input>
                 </el-form-item>
                <el-radio-group v-model="form.sex" style="margin-bottom: 20px;">
                  <el-radio :label="1">男</el-radio>
                  <el-radio :label="0">女</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="reg('form')" >立即创建</el-button>
                <el-button>取消</el-button>
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
                  { required: true, message: '请输入活动名称', trigger: 'blur' },
                  {  max: 20, message: '昵称 在20个字符以内，但不能为空', trigger: 'blur' }
                ],
                password:[
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    {  max: 16,min:3, message: '密码在3~16位之间', trigger: 'blur' }
                  ],
                email:[
                    { pattern:/^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/, message: '邮箱格式不正确', trigger: 'blur' }
                  ],
                  phone:[
                    { required: true, message: '请输入电话号码', trigger: 'blur' },
                    { pattern:/^1[3456789]\d{9}$/, message: '电话号码格式不正确', trigger: 'blur' }
                  ]
            }

          }
        },
        methods: {
          reg:function(formName){
              this.$refs[formName].validate((valid) => {
                        if (valid) {
                          this.post(this.api.API_USER_ADD,{
                            userName:this.form.username,
                            userPassword:this.form.password,
                            userEmail:this.form.email,
                            userPhone:this.form.phone,
                            userSex:this.form.userSex,
                          }).then(response =>{
                            console.log(response)
                            if(response.code == 200){
                              this.$alert(response.massage, '提示消息', {
                                        confirmButtonText: '确定',
                                        callback: action => {
                                           this.$router.push("/user/login")
                                        }
                                      });
                            }else{
                                this.$alert("添加用户失败", '提示消息', { 
                                      confirmButtonText: '确定',
                                        callback: action => {
                                        }
                                      });
                            }

                          })
                        } else {
                          console.log('error submit!!');
                          return false;
                        }
                      });
          }
          },

    }
</script>
<style scoped>
 .image{
   width: 100%;
   height: 100%;
 }

 .div{
   margin-left: 20%;
   width: 100%;
   height: 100%;
   align-content: center;
 }

 .div2{
   width:40%;
 }
 </style>
