<%@ page language="java" import="java.util.*" pageEncoding = "UTF-8"%>
<html>
<script type="text/javascript">
  function change(){
	  //重新生成一张图片
	  var Img = document.getElementById("myPic");
	  Img.src = "image.do?a=" + Math.random();//重新获取图片且去掉缓存
  }
</script>
  <body>
  <form action="login.do" method="post">
      用户名:<input type = "text" name = "username"/><br>
       密&nbsp;&nbsp;&nbsp;码:<input type = "password" name = "password"/><br>
    验证码:<input type = "text" name = "code"/>
  <img id = "myPic" alt="验证码" src="image.do" title = "看不清,点击我" onclick="change();"><br>
   <input type = "submit" value = "登录">
  </form>
  </body>
</html>
