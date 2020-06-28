<template>
  <div>
    <footer class="footer">
    		  <div class="footer-inner">
    		    <div class="footer-info">
    		      <div class="footer-info__download">
    		        <h3>下载KK音乐客户端</h3>
    		        <ul class="list">
    		          <li><a href="#">
    		            <i class="footer-icon icon-pc"></i>
    		            PC版
    		          </a></li>
    		          <li><a href="#">
    		            <i class="footer-icon icon-mac"></i>
    		            Mac版
    		          </a></li>
    		          <li><a href="#">
    		            <i class="footer-icon icon-android"></i>
    		            Android版
    		          </a></li>
    		          <li><a href="#">
    		            <i class="footer-icon icon-iphone"></i>
    		            iPhone版
    		          </a></li>
    		        </ul>
    		      </div>
    		      <div class="footer-info__product">
    		        <h3>特色产品</h3>
    		        <ul class="list">
    		          <li class="hasPic"><a href="#">
    		            <i class="footer-icon icon-kg"></i>
    		            全民K歌
    		          </a></li>
    		          <li class="hasPic"><a href="#">
    		            <i class="footer-icon icon-ss"></i>
    		            Super Sound
    		          </a></li>
    		          <li class="hasPic"><a href="#">
    		            <i class="footer-icon icon-qp"></i>
    		            OPlay
    		          </a></li>
    		          <li><a href="#">车载互联</a></li>
    		          <li><a href="#">OO演出</a></li>
    		        </ul>
    		      </div>
    		      <div class="footer-info__link">
    		        <h3>合作链接</h3>
    		        <ul class="list">
    		          <li><a href="#">CJ ENM</a></li>
    		          <li><a href="#">OO视频</a></li>
    		          <li><a href="#">手机OO空间</a></li>
    		          <li><a href="#">最新版OO</a></li>
    		          <li><a href="#">OO社交广告</a></li>
    		          <li><a href="#">电脑管家</a></li>
    		          <li><a href="#">OO浏览器</a></li>
    		          <li><a href="#">OO微云</a></li>
    		          <li><a href="#">OO云</a></li>
    		          <li><a href="#">企鹅FM</a></li>
    		          <li><a href="#">智能电视网</a></li>
    		          <li><a href="#">当贝市场</a></li>
    		        </ul>
    		      </div>
    		    </div>
    		    <div class="footer-copyright">
    		      <p><a href="#">关于OO</a><span>|</span><a href="#">About Tencent</a><span>|</span><a href="#">服务条款</a><span>|</span><a href="#">用户服务协议</a><span>|</span><a href="#">隐私政策</a><span>|</span><a href="#">权利声明</a><span>|</span><a href="#">广告服务</a><span>|</span><a href="#">腾讯招聘</a><span>|</span><a href="#">客服中心</a><span>|</span><a href="#">网站导航</a></p>
    		      <p>Copyright © 1998 - 2017 OO. All Rights Reserved.</p>
    		      <p>OO公司 版权所有 OO网络文化经营许可证</p>
    		    </div>
    		  </div>
    		</footer>
  </div>
</template>

<script>
</script>

<style >
  .footer {
      height: 470px;
      background-color: #333;
    }
    .footer-inner {
      max-width: 1200px;
      margin: 0 auto;
    }
    .footer,
    .footer a {
      color: #999;
    }
    .footer a:hover {
      color: #31c27c;
    }
    .footer-info {
      overflow: hidden;
      position: relative;
      width: 100%;
      height: 362px;
    }
    .footer-info h3 {
      padding: 80px 0 46px;
    }
    .footer-info li {
      float: left;
      text-align: center;
    }
    .footer-icon {
      display: block;
      width: 46px;
      height: 48px;
      margin: 0 29px 14px;
      background: url(../assets/img/footer_icons.png) no-repeat;
    }
    .icon-pc {
      width: 37px;
      background-position: -2px 0;
    }
    .footer-info a:hover .icon-pc {
      background-position: -2px -49px;
    }
    .icon-mac {
      background-position: -92px 0;
    }
    .footer-info a:hover .icon-mac {
      background-position: -92px -49px;
    }
    .icon-android {
      width: 37px;
      background-position: -190px 0;
    }
    .footer-info a:hover .icon-android {
      background-position: -190px -49px;
    }
    .icon-iphone {
      width: 34px;
      background-position: -279px 0;
    }
    .footer-info a:hover .icon-iphone {
      background-position: -279px -49px;
    }
    .icon-kg {
      width: 41px;
      background-position: -370px 0;
    }
    .footer-info a:hover .icon-kg {
      background-position: -370px -49px;
    }
    .icon-ss {
      width: 34px;
      background-position: -464px 0;
    }
    .footer-info a:hover .icon-ss {
      background-position: -464px -49px;
    }
    .icon-qp {
      width: 40px;
      background-position: -563px 0;
    }
    .footer-info a:hover .icon-qp {
      background-position: -563px -49px;
    }
    .footer-info__download {
      float: left;
    }
    .footer-info__download .list,
    .footer-info__product .list {
      margin-left: -29px;
    }
    .footer-info__product {
      position: absolute;
      top: 0;
      left: 478px;
      width: 304px;
    }
    .footer-info__product li {
      margin-right: 5px;
      margin-bottom: 18px;
      text-indent: 25px;
    }
    .footer-info__product li.hasPic {
      margin-right: 0;
    }
    .footer-info__link {
      float: right;
      width: 300px;
    }
    .footer-info__link li {
      width: 100px;
      margin-bottom: 22px;
      text-align: left;
    }
    .footer-copyright {
      font-size: 12px;
      text-align: center;
    }
    .footer-copyright p {
      line-height: 30px;
    }
    .footer-copyright a {
      display: inline;
    }
    .footer-copyright span {
      padding: 0 4px;
    }

    html, body, div, span, h1, h2, h3, h4, h5, h6, p, em, small, strong, dl, dt, dd, ol, ul, li {
      margin: 0;
      padding: 0;
      font-size: 100%;
    }
    em, strong, i {
      font-style: normal;
    }
    h1, h2, h3, h4, h5, h6 {
      font-weight: normal;
    }
    body {
      line-height: 1;
      font-size: 14px;
      font-family: "Microsoft Yahei";
      color: #333;
      background-color: #fff;
    }
    ul, ol {
      list-style: none;
    }
    a {
      display: block;
      color: #333;
      text-decoration: none;
    }
    a:hover {
      color: #31c27c;
    }
    input, button {
      padding: 0;
      border: none;
      outline: none;
      background: none;
    }
    img {
      vertical-align: top;
    }
</style>
