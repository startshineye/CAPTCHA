package com.yxm.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {
	/**
	 * 程序流程:
	 * 1.随机生成一个字符
	 * 2.把这个字符保存到session中
	 * 3.根据生成的字符生成对应图片
	 * 4.把图片发送到浏览器中
	 * */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	   //1.随机生成一个字符
		String baseString = "ABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";//定义基本字符串
		Random random = new Random();
		char[] randomCharArr = new char[4];//定义长度为4的数组用于存放生成字符串
		for(int i = 0;i<randomCharArr.length;i++){
			//随机生成一个长度不超过baseString的整数,作为数组下标,从而取得baseString里面的随机一个字符
			randomCharArr[i] = baseString.toCharArray()[random.nextInt(baseString.length())];
		}
		
		//2.把这个字符保存到session中
        request.getSession().setAttribute("code",new String(randomCharArr));
        
        //3.根据生成的字符生成对应图片
          int width = 120;
          int height = 30;
          //生成图片模板(根据三原色)
          BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	      //画出以上模板
	           //填充一个白色背景画板
	          Graphics g = bi.getGraphics();
	          g.setColor(Color.white); //画笔颜色设置为"白色"
	          g.fillRect(0, 0, width, height);//填充画板颜色坐标为(0,0)开始
	          
	          //画一个黑色边框到画板上
	          g.setColor(Color.black);//设置画笔颜色为黑色
	          g.drawRect(1,1, width-2, height-2);//(1,1)出填充黑色颜色
	          
	          //把随机数字符串加到画板上
	          g.setColor(Color.red);
	          for(int i = 0;i<randomCharArr.length;i++){
	        	  g.drawString(String.valueOf(randomCharArr[i]),i*20+10,20);
	          }
	          
	          //增加抗干扰因素,防止程序识别(画5条线,两点确定一条直线)
	          int x1,x2,y1,y2;
	          g.setColor(Color.black);
	          for(int i=0;i<5;i++){
	        	  x1 = random.nextInt(width);
	        	  x2 = random.nextInt(width);
	        	  y1 = random.nextInt(height);
	        	  y2 = random.nextInt(height);
	        	  g.drawLine(x1, y1, x2, y2);
	          }
	   //4,把这个图片发送到浏览器
	       response.setContentType("image/gpeg");//告诉浏览器这是一个图片
	       ImageIO.write(bi,"jpg",response.getOutputStream());//把内存当中的图片通过流的形式发送给浏览器
	}
}

















