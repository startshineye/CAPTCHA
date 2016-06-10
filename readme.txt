  
  title:验证码基本实现

  基本布局:(三个模块)
     index.jsp (实现客户端用户验证码输入)
     ImageServlet (生成验证码)
     LoginServlet (服务器验证)

  原理:
   在servlet中随便生成一个字符串,并把此字符串保存到session中,
   然后在servlet中画出一个图片,把生成的字符串填写上去.
   当用户提交所填写的验证码时,后端用于登录的servlet通过比较
   session中的验证码和用户提交的验证码.从而实现验证