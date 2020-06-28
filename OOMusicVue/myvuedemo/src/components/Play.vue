<template>
  <div>
    <div class="header">
        <h1 class="logo"><a href="#" @click="$router.push('/main')"></a></h1>
        <ul class="register">
            <li>登录</li>
            <li>设置</li>
        </ul>
    </div>
    <div class="content">
        <div class="content_in">
            <div class="content_left">
                <div class="content_toolbar">
                    <span><i></i>收藏</span>
                    <span><i></i>添加到</span>
                    <span><i></i>下载</span>
                    <span><i></i>删除</span>
                    <span><i></i>清空列表</span>
                </div>
                <div class="content_list" data-mcs-theme="minimal-dark">
                    <ul>
                        <li class="list_title">
                            <div class="list_check"><i></i></div>
                            <div class="list_number"></div>
                            <div class="list_name">歌曲</div>
                            <div class="list_singer">歌手</div>
                            <div class="list_time">时长</div>
                        </li>
                       <template v-key="song.id" v-for="(song,index) in playlist">
                          <li class="list_music">
                              <div class="list_check"><i></i></div>
                              <div class="list_number"></div>
                              <div class="list_name" @click="change(index)">{{song.songName}}
                                <div class="list_menu">
                                  <a href="javascript:;" title="播放"></a>
                                  <a href="javascript:;" title="添加"></a>
                                  <a href="javascript:;" title="下载"></a>
                                  <a href="javascript:;" title="分享"></a>
                                </div>
                              </div>
                              <div class="list_singer">{{song.singer}}</div>
                              <div class="list_time">{{gettime(song.playTime)}}</div>
                            </li>
                       </template>
                    </ul>
                </div>
            </div>
            <div class="content_right">
                <div class="song_info">
                    <a href="javascript:;" class="song_info_pic">
                        <img :src="playlist[index].songImage" alt="">
                    </a>
                    <div class="song_info_name">歌曲名称:
                        <a href="javascript:;">{{playlist[index].songName}}</a>
                    </div>
                    <div class="song_info_singer">歌手名:
                        <a href="javascript:;">{{playlist[index].singer}}</a>
                    </div>
                    <div class="song_info_ablum">专辑名:
                        <a href="javascript:;">{{playlist[index].albumName}}</a>
                    </div>
                </div>
                <div class="song_lyric_container">
                    <ul class="song_lyric">
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
        <div class="footer_in">
            <a href="javascript:;" class="music_pre"></a>
            <a href="javascript:;" class="music_play" @click="play"></a>
            <a href="javascript:;" class="music_next"></a>
            <div class="music_progress_info">
                <div class="music_progress_top">
                    <span class="music_progress_name">{{playlist[index].songName}} / {{playlist[index].singer}}</span>
                    <span class="music_progress_time">00:00 / {{gettime(playlist[index].playTime)}}</span>
                </div>
                <div class="music_progress_bar">
                    <div class="music_progress_line">
                        <div class="music_progress_dot"></div>
                    </div>
                </div>
            </div>
            <a href="javascript:;" class="music_mode"></a>
            <a href="javascript:;" class="music_fav"></a>
            <a href="javascript:;" class="music_down"></a>
            <a href="javascript:;" class="music_comment"></a>
            <a href="javascript:;" class="music_only"></a>
            <div class="music_voice_info">
                <a href="javascript:;" class="music_voice_icon"></a>
                <div class="music_voice_bar">
                    <div class="music_voice_line">
                        <div class="music_voice_dot"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="mask_bg"></div>
    <div class="mask"></div>
    <audio id="play" :src="playlist[index].songUrl"></audio>
  </div>
</template>

<script>
  export default{
    data(){
      return {
        playlist:[],
        index:0,
        flag:false,
      }
    },
    methods:{
      gettime:function(playtime){
        var time = "0"+(Math.round(playtime/60));
        var a = ""+(playtime%60);
        time += a.length >1  ? ":"+a : ":0"+a;
        time.su
        return time;
      },
      change:function(index){
        this.index = index
      },
      play:function(){
        var audio = document.getElementById("play");
       if(!this.flag){
        audio.play();
        this.flag = true;
       } else{
         audio.pause();
         this.flag = false;
       }

      },

    },
    mounted() {
      this.playlist = this.Local.get("playlist");

    }
  }
</script>

<style scoped>
 *{
     margin: 0;
     padding: 0;
 }
 html,body{
     width: 100%;
     height: 100%;
     font-size: 14px;
 }
 .header{
     width: 100%;
     height: 45px;
 }
 .header .logo{
     float: left;
     margin-left: 20px;
     opacity: 0.5;
 }
 .header .logo:hover{
     opacity: 1;
 }
 .header .logo a{
     display: inline-block;
     width: 78px;
     height: 21px;
     background: url(../assets/images/player_logo.png) no-repeat 0 0;
 }
 .header .register{
     float: right;
     line-height: 45px;
 }

 .header .register li{
     list-style: none;
     float: left;
     margin-right: 20px;
     color: #fff;
     opacity: 0.5;
 }
 .header .register li:hover{
     opacity: 1;
 }
 .content{
     width: 100%;
     height: 460px;
 }
 .content .content_in{
     width: 1200px;
     height: 100%;
     margin: 0 auto;
 }
 .content_in .content_left{
     float: left;
     width: 800px;
     height: 100%;
 }
 .content_left .content_toolbar{
     width: 100%;
     height: 40px;
 }
 .content_toolbar span{
     display: inline-block;
     width: 122px;
     height: 100%;
     line-height: 40px;
     text-align: center;
     border: 1px solid #fff;
     box-sizing: border-box;
     border-radius: 5px;
     color: #fff;
     opacity: 0.5;
 }
 .content_toolbar span:hover{
     opacity: 1;
 }
 .content_toolbar span i{
     display: inline-block;
     width: 18px;
     height: 18px;
     background: url(../assets/img/icon_sprite.png) no-repeat 0 0;
     margin-right: 10px;
     vertical-align: -5px;
 }
 .content_toolbar span:nth-child(1) i{
     background-position: -60px -20px;
 }
 .content_toolbar span:nth-child(2) i{
     background-position: -20px -20px;
 }
 .content_toolbar span:nth-child(3) i{
     background-position: -40px -240px;
 }
 .content_toolbar span:nth-child(4) i{
     background-position: -100px -20px;
 }
 .content_toolbar span:nth-child(5) i{
     background-position: -40px -300px;
 }
 .content_left .content_list{
     width: 100%;
     height: 420px;
     overflow: auto;
 }
 .content_list li{
     list-style: none;
     width: 100%;
     height: 50px;
     border-bottom: 1px solid rgba(255,255,255,0.5);
     box-sizing: border-box;
     user-select: none;
 }
 .content_list li div{
     float: left;
     color: rgba(255,255,255,0.5);
     line-height: 50px;
     /*opacity: 0.5;*/
 }
 .content_list .list_check{
     width: 50px;
     height: 100%;
     text-align: center;
 }
 .content_list .list_check i{
     display: inline-block;
     width: 14px;
     height: 14px;
     border: 1px solid #fff;
     opacity: 0.5;
 }
 .content_list .list_checked i{
     background: url(../assets/img/icon_sprite.png) no-repeat -60px -80px;
     opacity: 1;
 }
 .content_list .list_number{
     width: 20px;
     height: 100%;
 }
 .content_list .list_number2{
     color: transparent !important;
     background: url(../assets/img/wave.gif) no-repeat 0 center;
 }
 .content_list .list_name{
     width: 50%;
     height: 100%;
 }
 .list_name .list_menu{
     margin-top: 5px;
     float: right;
     margin-right: 20px;
 }
 .list_menu a{
     display: inline-block;
     width: 36px;
     height: 36px;
     opacity: 0.5;
 }
 .list_menu a:hover{
     opacity: 1;
 }
 .list_menu a:nth-child(1){
     background-position: -120px 0;
 }
 .list_menu a:nth-child(2){
     background-position: -120px -80px;
 }
 .list_menu a:nth-child(3){
     background-position: -120px -120px;
 }
 .list_menu a:nth-child(4){
     background-position: -120px -40px;
 }

 .list_menu .list_menu_play2{
     background-position: -80px -200px !important;
 }
 .content_list .list_singer{
     width: 20%;
     height: 100%;
 }
 .content_list .list_time a{
     display: inline-block;
     width: 36px;
     height: 36px;
     background: url(../assets/img/icon_list_menu.png) no-repeat -120px -160px;
     float: left;
     margin-top: 5px;
     opacity: 0.5;
 }
 .content_list .list_time a:hover{
     opacity: 1;
 }
 .content_in .content_right{
     float: right;
     width: 400px;
     height: 100%;
     user-select: none;
 }
 .content_right .song_info{
     text-align: center;
     color: rgba(255,255,255,0.5);
     line-height: 30px;
 }
 .song_info .song_info_pic{
     display: inline-block;
     background: url(../assets/img/album_cover_player.png) no-repeat 0 0;
     width: 201px;
     height: 180px;
     text-align: left;
 }
 .song_info_pic img{
     width: 180px;
     height: 180px;
 }
 .song_info div a{
     text-decoration: none;
     color: #fff;
     opacity: 0.5;
 }
 .song_info div a:hover{
     opacity: 1;
 }
 .content_right .song_lyric_container{
     margin-top: 30px;
     height: 150px;
     overflow: hidden;
 }
 .content_right .song_lyric{
     text-align: center;
 }
 .content_right .song_lyric li{
     list-style: none;
     line-height: 30px;
     font-weight: bold;
     color: rgba(255,255,255,0.5);
 }
 .content_right .song_lyric .cur{
     color: #31c27c;
 }

 .footer{
     width: 100%;
     height: 80px;
     position: absolute;
     left: 0;
     bottom: 0;
 }
 .footer .footer_in{
     width: 1200px;
     height: 100%;
     margin: 0 auto;
     user-select: none;
 }
 .footer_in a{
     display: inline-block;
     text-decoration: none;
     color: #fff;
     background: url(../assets/img/player.png) no-repeat 0 0;
     margin-right: 20px;
 }
 .footer_in .music_pre{
     width: 19px;
     height: 20px;
     background-position: 0 -30px;
 }
 .footer_in .music_play{
     width: 21px;
     height: 29px;
     background-position: 0 0;
     vertical-align: -5px;
 }
 .footer_in .music_play2{
     background-position: -30px 0;
 }
 .footer_in .music_next{
     width: 19px;
     height: 20px;
     background-position: 0 -52px;
 }
 .footer_in .music_progress_info{
     display: inline-block;
     width: 670px;
     height: 40px;
     position: relative;
     top: 10px;
 }
 .music_progress_info .music_progress_top{
     width: 100%;
     height: 30px;
     line-height: 30px;
     color: #fff;
 }
 .music_progress_top .music_progress_name{
     float: left;
     opacity: 0.5;
 }
 .music_progress_top .music_progress_name:hover{
     opacity: 1;
 }
 .music_progress_top .music_progress_time{
     float: right;
     opacity: 0.5;
 }
 .music_progress_info .music_progress_bar{
     width: 100%;
     height: 4px;
     background: rgba(255,255,255,0.5);
     margin-top: 5px;
     position: relative;
 }
 .music_progress_bar .music_progress_line{
     width: 0px;
     height: 100%;
     background: #fff;
 }
 .music_progress_line .music_progress_dot{
     width: 14px;
     height: 14px;
     border-radius: 50%;
     background: #fff;
     position: absolute;
     top: -5px;
     left: 0px;
 }
 .footer_in .music_mode{
     width: 26px;
     height: 25px;
     background-position: 0 -205px;
 }
 .footer_in .music_mode2{
     width: 23px;
     height: 20px;
     background-position: 0 -260px;
 }
 .footer_in .music_mode3{
     width: 25px;
     height: 19px;
     background-position: 0 -74px;
 }
 .footer_in .music_mode4{
     width: 26px;
     height: 25px;
     background-position: 0 -232px
 }
 .footer_in .music_fav{
     width: 24px;
     height: 21px;
     background-position: 0 -96px;
 }
 .footer_in .music_fav2{
     background-position: -30px -96px;
 }
 .footer_in .music_down{
     width: 22px;
     height: 21px;
     background-position: 0 -120px;
 }
 .footer_in .music_comment{
     width: 24px;
     height: 24px;
     background-position: 0 -400px;
 }
 .footer_in .music_only{
     width: 74px;
     height: 27px;
     background-position: 0 -281px;
 }
 .footer_in .music_only2{
     background-position: 0 -310px;
 }
 .footer_in .music_voice_info{
     display: inline-block;
     width: 100px;
     height: 40px;
     line-height: 40px;
     position: relative;
     top:10px;
 }
 .music_voice_info .music_voice_icon{
     width: 26px;
     height: 21px;
     background-position: 0 -144px;
     position: absolute;
     left: 0;
     top: 10px;
 }
 .music_voice_info .music_voice_icon2{
     background-position: 0 -182px;
 }
 .music_voice_info .music_voice_bar{
     width: 70px;
     height: 4px;
     background: rgba(255,255,255,0.5);
     position: absolute;
     right: 0;
     top: 18px;
 }
 .music_voice_bar .music_voice_line{
     width: 70px;
     height: 100%;
     background: #fff;
 }
 .music_voice_line .music_voice_dot{
     width: 14px;
     height: 14px;
     border-radius: 50%;
     background: #fff;
     position: relative;
     top: -5px;
     left: 70px;
 }
 /*此处放背景图*/
 .mask_bg{
     position: absolute;
     left: 0;
     top: 0;
     z-index: -2;
     width: 100%;
     height: 100%;
     background: url(../assets/img/u=1316045217,2604636646&fm=26&gp=0.jpg) no-repeat 0 0;
     background-size: cover;
     filter: blur(100px);
 }
 .mask{
     position: absolute;
     left: 0;
     top: 0;
     z-index: -1;
     width: 100%;
     height: 100%;
     background: rgba(0,0,0,0.35);
 }
 ._mCS_1 .mCSB_scrollTools .mCSB_dragger_bar{
     width:8px;
 }
</style>
