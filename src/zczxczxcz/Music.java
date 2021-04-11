package zczxczxcz;

import java.applet.AudioClip;
import java.io.*;
import java.applet.Applet;
import java.net.MalformedURLException;
import java.net.URL;

 
// 2：少年 3：dream 4：光明
public class Music {
	public static void main(String args[]) {
		playMusic1();
	}

	static void playMusic1(){//背景音乐播放
		try {
			URL cb;
			File f = new File("image/1.wav");
			// 引号里面的是音乐文件所在的路径
			
			cb = f.toURL();
			AudioClip aau;
			aau = Applet.newAudioClip(cb);
			aau.play();	
			aau.loop();//循环播放
			System.out.println("播放安娜的橱窗！");
			// 循环播放 aau.play()
//			aau.stop(); //停止播放
		} catch (MalformedURLException e) {
			e.printStackTrace();

		}

	}	
	static void playMusic2(){//背景音乐播放
		try {
			URL cb;
			File f = new File("image/2.wav");
			// 引号里面的是音乐文件所在的路径
			
			cb = f.toURL();
			AudioClip aau;
			aau = Applet.newAudioClip(cb);
			aau.play();	
			aau.loop();//循环播放
			System.out.println("播放读者！");
//			// 循环播放
//			aau.play();
//			//单曲 
//			aau.stop();//停止播放
		} catch (MalformedURLException e) {
			e.printStackTrace();

		}

	}	
	static void playMusic3(){//背景音乐播放
		try {
			URL cb;
			File f = new File("image/3.wav");
			// 引号里面的是音乐文件所在的路径
			
			cb = f.toURL();
			AudioClip aau;
			aau = Applet.newAudioClip(cb);
			aau.play();	
			aau.loop();//循环播放
			System.out.println("播放光明！");
//			// 循环播放
//			aau.play();
//			//单曲 
//			aau.stop();//停止播放
		} catch (MalformedURLException e) {
			e.printStackTrace();

		}

	}
	static void playMusic4(){//背景音乐播放
		try {
			URL cb;
			File f = new File("image/4.wav");
			// 引号里面的是音乐文件所在的路径
			
			cb = f.toURL();
			AudioClip aau;
			aau = Applet.newAudioClip(cb);
			aau.play();	
			aau.loop();//循环播放
			System.out.println("播放 Dream It Possible！");
//			// 循环播放
//			aau.play();
//			//单曲 
//			aau.stop();//停止播放
		} catch (MalformedURLException e) {
			e.printStackTrace();

		}

	}
}
