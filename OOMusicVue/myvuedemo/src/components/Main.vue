<template>
  <!-- 头部组件 -->
  <div>
    <vHeader></vHeader>

        <!-- 歌单推荐 start-->
          <div class="song_l">
              <div class="slid_p">
                  <p class="slid_p_o">歌单推荐</p>
              </div>
              <div class="song_l_box">
                      <ul class="sild_ul">
                       <template v-key="song.id" v-for="(song,index) in gedan">
                           <li class="slid_li">
                               <a href="#"><img @click="getgedan(index)" :src="song.image" alt="" /></a>
                               <p class="td_p_o">{{song.songName}}</p>
                               <p class="td_p_t">播放量：{{song.play}}</p>
                           </li>
                       </template>
                      </ul>
              </div>
          </div>
          <!-- 歌单推荐 end -->

          <!-- 新歌首发 start-->
          <div class="song_l" style="margin-bottom: 550px;margin-right: 20%;margin-left: 20%;" >
            <div class="slid_p1">
                  <p class="slid_p_o1">新歌首发</p>
                </div>
                <div class="box1">
                    <table>
                      <tr>
                        <template v-key="value.id" v-for="value in newsong.slice(0,3)">
                            <td class="box2">
                              <div id="box3"><a href="#"><img :src="value.image" alt="" /></a>
                              <div id="box4"><p class="td_p_o1"><span>{{value.songName}}</span></p></div>
                              <div id="box5"><p class="td_p_t1"><span>{{value.singer}}</span></p></div></div>
                            </td>
                        </template>
                       </tr>
                       <tr>
                         <template v-key="value.id" v-for="value in newsong.slice(3,6)">
                             <td class="box2">
                               <div id="box3"><a href="#"><img :src="value.image" alt="" /></a>
                               <div id="box4"><p class="td_p_o1"><span>{{value.songName}}</span></p></div>
                               <div id="box5"><p class="td_p_t1"><span>{{value.singer}}</span></p></div></div>
                             </td>
                         </template>
                        </tr>
                        <tr>
                          <template v-key="value.id" v-for="(value,key,index) in newsong.slice(6)">
                              <td class="box2">
                                <div id="box3"><a href="#"><img :src="value.image" alt="" /></a>
                                <div id="box4"><p class="td_p_o1"><span>{{value.songName}}</span></p></div>
                                <div id="box5"><p class="td_p_t1"><span>{{value.singer}}</span></p></div></div>
                              </td>
                          </template>
                         </tr>
                    </table>
                </div>
            </div>
          <!-- 新歌首发 end -->

          <!-- 新蝶首发 start-->
          <div class="song_n">
              <div class="slid_p">
                  <p class="slid_p_o">新碟首发</p>
                </div>

                <div class="song_n_box">
                    <table>
                        <tr>
                          <template  v-key="value.id" v-for="(value,key,index) in newdie.slice(0,5)" >
                            <td>
                              <a href="#"><img class="img_n" :src="value.image" alt="" /></a>
                              <p class="td_p_o"><span class="n_s">{{value.songName}}</span></p>
                              <p class="td_p_t"><span class="n_s">{{value.singer}}</span></p>
                            </td>
                          </template>
                        </tr>
                        <tr>
                          <template  v-key="value.id" v-for="(value,key,index) in newdie.slice(5)">
                            <td>
                              <a href="#"><img class="img_n" :src="value.image" alt="" /></a>
                              <p class="td_p_o"><span class="n_s">{{value.songName}}</span></p>
                              <p class="td_p_t"><span class="n_s">{{value.singer}}</span></p>
                            </td>
                            <td>
                              <a href="#"><img class="img_n" :src="value.image" alt="" /></a>
                              <p class="td_p_o"><span class="n_s">{{value.songName}}</span></p>
                              <p class="td_p_t"><span class="n_s">{{value.singer}}</span></p>
                            </td>
                          </template>
                        </tr>
                    </table>
                </div>
          </div>
          <!-- 新碟首发 end -->

          <!-- 排行榜 start-->
          <div class="ranking_l">
              <div class="slid_p">
                  <p class="slid_p_o">排行榜</p>
                </div>
                <div class="ranking_box">
                  <ul class="sild_ul">
                    <li class="slid_li">
                      <div class="img_1">
                        <p class="p_u"><span class="r_s">巅峰榜</span></p>
                        <p class="p_o">
                          <a href=""><span class="r_s">热歌</span></a>
                        </p>
                        <a href=""><hr /></a>
                        <template v-key="value.id" v-for="(value,key,index) in top.slice(0,3)">
                          <p class="p_i">
                            <a href=""><span class="r_s">{{key+1}}  {{value.songName}}</span></a>
                          </p>
                          <p class="p_i_o">
                            <a href=""><span class="r_s">   {{value.singer}}</span></a>
                          </p>
                        </template>
                      </div>
                    </li>
                    <li class="slid_li">
                        <div class="img_2">
                            <p class="p_u"><span class="r_s">巅峰榜</span></p>
                            <p class="p_o">
                              <a href=""><span class="r_s">新歌</span></a>
                            </p>
                            <a href=""><hr /></a>
                            <template v-key="value.id" v-for="(value,key,index) in top.slice(3,6)">
                              <p class="p_i">
                                <a href=""><span class="r_s">{{key+1}}  {{value.songName}}</span></a>
                              </p>
                              <p class="p_i_o">
                                <a href=""><span class="r_s">   {{value.singer}}</span></a>
                              </p>
                            </template>
                          </div>
                    </li>
                    <li class="slid_li">
                        <div class="img_3">
                            <p class="p_u"><span class="r_s">巅峰榜</span></p>
                            <p class="p_o">
                              <a href=""><span class="r_s">流行指数</span></a>
                            </p>
                            <a href=""><hr /></a>
                            <template v-key="value.id" v-for="(value,key,index) in top.slice(6,9)">
                              <p class="p_i">
                                <a href=""><span class="r_s">{{key+1}}  {{value.songName}}</span></a>
                              </p>
                              <p class="p_i_o">
                                <a href=""><span class="r_s">   {{value.singer}}</span></a>
                              </p>
                            </template>
                          </div>
                    </li>
                    <li class="slid_li">
                        <div class="img_4">
                            <p class="p_u"><span class="r_s">巅峰榜</span></p>
                            <p class="p_o">
                              <a href=""><span class="r_s">欧美</span></a>
                            </p>
                            <a href=""><hr /></a>
                            <template v-key="value.id" v-for="(value,key,index) in top.slice(9,12)">
                              <p class="p_i">
                                <a href=""><span class="r_s">{{key+1}}  {{value.songName}}</span></a>
                              </p>
                              <p class="p_i_o">
                                <a href=""><span class="r_s">   {{value.singer}}</span></a>
                              </p>
                            </template>
                          </div>
                    </li>
                    <li class="slid_li">
                        <div class="img_5">
                            <p class="p_u"><span class="r_s">巅峰榜</span></p>
                            <p class="p_o">
                              <a href=""><span class="r_s">韩国</span></a>
                            </p>
                            <a href=""><hr /></a>
                            <template v-key="value.id" v-for="(value,key,index) in top.slice(12)">
                              <p class="p_i">
                                <a href=""><span class="r_s">{{key+1}}  {{value.songName}}</span></a>
                              </p>
                              <p class="p_i_o">
                                <a href=""><span class="r_s">   {{value.singer}}</span></a>
                              </p>
                            </template>
                          </div>
                    </li>
                  </ul>
                </div>
          </div>
          <!-- 排行榜 end -->


      <vFooter style="margin-top: 1000px;"></vFooter>

    </div>
</template>

<script>
  import headervue from "./Header.vue"
  import footer from "./Footer.vue"
  export default{
    name:"Main",
    data(){
      return {
        maindata:"",
        gedan:"",
        newsong:"",
        newdie:"",
        top:"",
      }
    },
    methods:{
      getmaindata:function(){ //获取首页数据
        this.get(this.api.API_MAIN_DATA,{}).then(response =>{
          var list = response.list;

            //拿到歌单推荐
            this.gedan = list.slice(0,5);
            //拿到新歌首发
            this.newsong = list.slice(5,14);
            //拿到新碟首发
            this.newdie = list.slice(14,21);
            //拿到排行榜
            this.top = list.slice(21);

            // console.log(this.gedan)
            // console.log(this.newsong)
            // console.log(this.newdie)
            // console.log(this.top)

        })
      },
      getgedan:function(index){
       var next=  this.gedan[index].nextUrl;
        this.post(this.api.API_MIAN_GEDAN,{
          nextUrl:next
        }).then(response =>{
          //获取歌单推荐的信息
          console.log(response)
          //存入sessin中
           this.Session.set("listdata",response);
           //跳转至搜索页,1是歌单推荐来的，0是搜索来的
           this.$router.push({path:"/main/search",query:{type:1}})
        })
      }

    },
    mounted() {
      this.getmaindata();
        // this.Local.set("playlist",[])
        //console.log(this.Local.get("playlist"))
    },
    components:{
      vHeader:headervue,
      vFooter:footer,
    }
  }
</script>

<style scoped="scoped">
*{
    margin: 0;
    padding: 0;
}

body{
    background-color:#f0f0f0;
}
.song_l{
    position: relative;
    margin-bottom: 400px;
}
.song_n{
    position: relative;
    margin-bottom: 600px;
}
.ranking_l{
    position: relative;
    margin-bottom: 600px;
}

.song_l_box{
    width: 1300px;
    height: 300px;
    text-align: left;
    overflow: hidden;
    position: absolute;
    left: 50%;
    margin-left: -600px;
}

.song_n_box{
    width: 1300px;
    height: 600px;
    text-align: left;
    overflow: hidden;
    position: absolute;
    left: 50%;
    margin-left: -600px;
    margin-top: -20px;
}

.ranking_box{
    width: 1300px;
    height: 500px;
    text-align: left;
    overflow: hidden;
    position: absolute;
    left: 50%;
    margin-left: -600px;
}

.img_n{
    width: 225px;
    height: 225px;
    margin: 1px 17px 1px 1px;

}

.slid_p{
    text-align: center;
    padding-top: 40px;
    margin-bottom: -10px;
    height: 100px;
}
.slid_p_o{
    font-size: 30px;
    letter-spacing: 10px;
}

.slid_li{
    float: left;
    width: 220px;
    height: 220px;
    margin: 1px 25px 20px 1px;
    list-style: none;
}
.slid_li img{
    width: 220px;
    height: 220px;
    transition: 1s;
}
.td_p_o {
    font-size: 14px;
    padding-top: 10px;
    padding-bottom: 2px;
    position: relative;
}
.td_p_t{
    font-size: 14px;
    color: rgb(172, 172, 172);
    padding-bottom: 20px;
    position: relative;
}
.td_p_o:hover{
    color: #01b468;
}
.n_s:hover{
    color: #02c874;
}

.slid_ul{
    overflow: hidden;
}

.img_1{
    background-image: url(../assets/img/11254.png);
    width: 224px;
    height: 500px;
}
.img_2{
    background-image: url(../assets/img/26544.png);
    width: 224px;
    height: 500px;
}
.img_3{
    background-image: url(../assets/img/35565.png);
    width: 224px;
    height: 500px;
}
.img_4{
    background-image: url(../assets/img/44557.png);
    width: 224px;
    height: 500px;
}
.img_5{
    background-image: url(../assets/img/54587.png);
    width: 224px;
    height: 500px;
}
.slid_li img_i{
    z-index: -1;
    transition: 1s;
}
p{
    z-index: 1;
    position: relative;
}
.p_u{
    font-size: 21px;
    color: #e0e0e0;
    margin-left: 1px;
    -webkit-user-select:none;
   -moz-user-select:none;
   -ms-user-select:none;
   user-select:none;
   position: relative;
   padding-top: 42px;
   text-align: center;
}
.p_o{
    font-size: 26px;
    text-align: center;
}
hr{
    width: 35px;
    color: white;
    margin: auto;
    position: relative;
    margin-top: 40px;
    margin-bottom: 40px;
}
a{
    text-decoration: none;
}
.r_s{
    color: white;
    padding-left: 4px;
}
.p_i{
    padding-left: 40px;
    padding-bottom: 4px;
    font-size: 15px;
    max-width: 155px;
    overflow: hidden;
text-overflow: ellipsis;
white-space: nowrap;
color: white;
}
.p_i_o{
    padding-left: 40px;
    font-size: 16px;
    padding-bottom: 30px;
    max-width: 155px;
    overflow: hidden;
text-overflow: ellipsis;
white-space: nowrap;
color: white;
}




.box1{
	width: 1400px;
	height: 700px;
    text-align: left;
    overflow: hidden;
    position: absolute;
    left: 50%;
    margin-left: -700px;
    margin-top: -20px;
}
img{
	width: 108px;
	height: 108px;
}
.box2{
	width: 530px;
	height: 120px;
}
#box3{
	width: 530px;
	height: 120px;
}
#box4{
	width: 400px;
	height: 45px;
	float: right;
	margin-top: 20px;
}
#box5{
	width: 400px;
	height: 45px;
	float: right;
	margin-top:-50px;
}
.slid_p1{
    text-align: center;
    padding-top: 40px;
    margin-bottom: 10px;
    height: 100px;
}
.slid_p_o1{
    font-size: 30px;
    letter-spacing: 10px;
}

.td_p_o1 {
    font-size: 14px;
    padding-top: 10px;
    padding-bottom: 2px;
    position: relative;

}
.td_p_t1{
    font-size: 14px;
    color: rgb(172, 172, 172);
    padding-bottom: 20px;
    position: relative;

}
span:hover{
    color: #02c874;
}
</style>
