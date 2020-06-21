<template>
  <div>
  dwdwdwdwdwdwd
 <div style="display: flex; flex-direction: row;  justify-content: space-around;;">
  <div>歌曲</div>
  <div>歌手</div>
  <div>专辑</div>
  <div>时长</div>
 </div>
    <template v-key="song.id" v-for="song in songList">
      <div  style="display: flex; flex-direction: row;  justify-content: space-around;;">
        <div>{{song.id}}</div>
        <div>{{song.singer}}</div>
        <div>{{song.albumName}}</div>
        <div>{{song.playTime}}</div>
        <br>
        </div>
    </template>
  </div>
</template>

<script>
  export default{
    data(){
      return {
        songList:"dwdwd",
      }
    },
    methods:{
      test:function(){
        var userId = this.$route.params.userId;
        console.log(userId);
        this.post(this.api.API_LIKE_GET,{
           userId:userId
        }).then( responese =>{
          console.log(responese)
           this.songList = responese.list;
        })
      },
    },
    mounted() {
      this.test();
    }
  }
</script>

<style>
</style>
