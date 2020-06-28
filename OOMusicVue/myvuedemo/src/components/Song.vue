<template>
  <div >
    <vHeader></vHeader>
    <el-container style="background: rgb(248,248,248);"  v-loading="loading">
      <el-container>
        <el-aside width="30%">
          <div>
            <div >
              <img  class="imgg" :src="song.songImage"/>
            </div>
          </div>
        </el-aside>
        <el-main >
          <div class="conn">
              <div class="title">{{song.songName}}</div>
              <div class="singer"><i class="el-icon-user"></i>{{song.singer}}</div>
              <div class="alb">专辑:{{song.albumName}}</div>
              <div>
                <el-button type="success" icon="el-icon-caret-right" style="background: rgb(49,194,124);" @click="play">播放</el-button>
                <el-button  icon="el-icon-star-off">收藏</el-button>
                <el-button  icon="el-icon-chat-line-square">评论</el-button>
                <el-button  icon="el-icon-more-outline">更多</el-button>
              </div>
          </div>
        </el-main>
      </el-container>
      <el-footer>
        <div class="commit">
          <div style="font-size: 30px;margin-bottom: 20px;">评论</div>
          <el-input
          style="width: 60%;"
            type="textarea"
            :rows="5"
            placeholder="期待你的神评论......"
            v-model="textarea">
          </el-input>
        </div>
      </el-footer>
    </el-container>

    <vFooter style="margin-top: 300px;"></vFooter>
  </div>
</template>

<script>
  import headervue from "./Header.vue"
  import footer from "./Footer.vue"
  export default{
    data(){
      return {
        textarea:"",
        song:"",
        loading:true,
      }
    },
    methods:{
      stringtoint:function(time){
          var a = time.split(":");
          var b = a[0]*60;
          b += parseInt(a[1]);
          return b;
      },
      play:function(){
        //存入歌单列表
        var arr =  this.Local.get("playlist");
        arr.forEach( (item,index)=>{
            if(this.song.songId = item.songId){
             this.$router.push("/play")
              return;
            }
        });
        arr.push(this.song);
      this.Local.set("playlist", arr);
        this.$router.push("/play")
      }
    },
    mounted() {
      this.song = this.$route.params.song;
      console.log(this.song)
        this.post(this.api.API_GET_SONG,{
          songId:this.song.songId,
          albumName:this.song.albumName,
          playTime:this.stringtoint(this.song.playTime),
          singer:this.song.singer,
          songName:this.song.songName,
        }).then(response =>{
            this.song = response;
            var a = JSON.parse(response.songUrl);
            //拿到最终的完整的歌曲
            this.song.songUrl = a.data.musicUrl;
            console.log(this.song)
            this.loading= false;
        });

    },
    components:{
      vHeader:headervue,
      vFooter:footer,
    }
  }
</script>

<style scoped="scoped">
  .imgg{
    margin: 20px;
    width: 80%;
    height: 80%;
  }

  .commit{
    margin: 20px 0;
  }

  .title{
    font-size: 30px;
    margin: 15px 0;
  }

  .singer{
    font-size: 18px;
  }

  .alb{
    margin: 15px 0;
    font-size: 18;
  }

  .conn{
    display: flex;
    flex-direction: column;
  }
</style>
