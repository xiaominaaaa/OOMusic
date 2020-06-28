var serverRoot = "http://127.0.0.1:8088/oomusic";
var server = serverRoot+'/';

//暴露出去
export default{
  //根目录
  SERVER_ROOT : serverRoot,
  //测试的用户
  API_USER : server+'user',
  //主页数据
  API_MAIN_DATA: server+'main',
  //添加用户
  API_USER_ADD: server+'user/add',
  //查询用户
  API_USER_FIND: server+'user/find',
  //修改账号和密码
  API_USER_PASSNAME:server+'user/passname',
  //修改电话和邮箱
  API_USER_EMAILPHONE:server+'user/emailphone',

  //删除用户
  API_USER_DELETE: server+'user/delete',

  //获取所有收藏
  API_LIKE_GET: server+"like/get",
  //拿到歌单推荐数据
  API_MIAN_GEDAN:server+"main/ge",
  //拿到搜索页数据
  API_MAIN_SEARCH: server+"main/search",
  //拿到完整的歌曲
  API_GET_SONG:server+"main/getsong",
  //登录 
  API_USER_LOGIN:server+"user/login",
}
