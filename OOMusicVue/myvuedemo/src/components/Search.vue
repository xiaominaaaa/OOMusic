<template>
  <div>
    <vHeader></vHeader>
    <!-- 头部搜索  BEGIN-->
    <div >
      <img src="../assets/image/bg_search.jpg" />
       <div class="searchbox">
         <el-input
            placeholder="搜索关键字"
            suffix-icon="el-icon-search"
            v-model="search">
          </el-input>
       </div>
    </div>
    <!--头部搜索 END-->
    <!-- 下面显示栏 BEGIN -->
    <div class="showbox" align="center" style="margin-top: 20px;" >
         <el-table
               v-loading="isload"
              highlight-current-row
               @current-change="toSong"
              stripe
              :data="songdata"
              style="width: 80%">
              <el-table-column
                prop="songName"
                label="歌曲"
                width="520">
              </el-table-column>
              <el-table-column
                prop="singer"
                label="歌手"
                >
              </el-table-column>
              <el-table-column
                prop="albumName"
                label="专辑">
              </el-table-column>
              <el-table-column
                prop="playTime"
                label="时长">
              </el-table-column>
            </el-table>
    </div>
    <!-- 下面显示栏 END -->
    <vFooter style="margin-top: 200px;"></vFooter>
  </div>
</template>

<script>
  import headervue from "./Header.vue"
  import footer from "./Footer.vue"
  export default{
    name:"Main",
    data(){
      return {
        search:"",
        datalist:"",
        searchdata:[],
        songdata:[],
        isload:true,
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
      tojson:function(back){
        var a = back.t.substring(back.t.indexOf("{"),back.t.lastIndexOf("}")+1);
        console.log(typeof a)
        console.log(JSON.parse(a))
        return(JSON.parse( back.t.substring(back.t.indexOf("{"),back.t.lastIndexOf("}")+1)));
      },
      toSong:function(item){
        //跳转到歌曲详情页
        this.$router.push({name:"Song",params:{song:item}})
      },

    },
    mounted() {
      var type =  this.$route.query.type;
      //1 是歌单推荐来的  0 是搜索来的
      if(type == 1){
          this.datalist = this.Session.get("listdata");
          console.log(this.datalist)
           this.datalist.forEach(
            (item,index) => {
              this.songdata.push({
                  songName:item.songName,
                  singer:item.singer,
                  albumName:item.albumName.length > 10 ?item.albumName.substring(0,10)+"...":item.albumName ,
                  playTime:this.gettime(item.playTime),
                  songId:item.songId,
              });
            }
           );
           this.isload = false;
      }else if(type == 0){
        //来自搜索页
        this.search = this.$route.query.w;
        if(this.search != ""){
            //发送请求获取搜索数据
            this.get(this.api.API_MAIN_SEARCH,{
              nextUrl: this.search,
            })
            .then( response =>{
              console.log(response)
                var da =  this.tojson(response);
                this.datalist = da.data.song.list;
                this.datalist.forEach(
                  (item,index)=>{
                    this.searchdata.push({
                      songName:item.songname,
                      songId:item.songmid,
                      playTime:this.gettime(item.interval),
                      albumName:item.albumname,
                      singer:item.singer[0].name,
                    });
                  }
                );
                this.songdata = this.searchdata;
                this.isload = false;
            });
        }

      }
    },
    components:{
      vHeader:headervue,
      vFooter:footer,
    }
  }
</script>
<style scoped="">
.bg{

  background-image: url(../assets/image/bg_search.jpg);
}

.searchbox{
    position: absolute;
    margin-left: 35%;
    margin-top: -10%;
    width: 30%;
}

.showbox{
  font-size: 3px;
}

</style>
