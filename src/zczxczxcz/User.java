package zczxczxcz;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class User extends JFrame{
private JLabel use,password;
private JTextField k1;//用户名输入框
private JPasswordField k2;//密码输入框
private JButton b1,b2;

//登录窗口
public User(JFrame f){
	super("系统登录");
	Music.playMusic1();
	ConnectDB.CONN();
	Container c=getContentPane();
	c.setLayout(new FlowLayout());
	use=new JLabel("username:");
	use.setFont(new Font("Serif",Font.PLAIN,20));
	password=new JLabel("password:");
	password.setFont(new Font("Serif",Font.PLAIN,20));
	k1=new JTextField(12);
	k2=new JPasswordField(12);
	b1=new JButton("登录");
	b2=new JButton("退出");
	
	Image img0 = new ImageIcon("image\\22.jpg").getImage(); 
	  this.setIconImage(img0);

	 
	
	
	//	设置登录方法
	BHandler b=new BHandler();
	EXIT d=new EXIT();
	b1.addActionListener(b);
	b2.addActionListener(d);
	
		//添加控件
	c.add(use);
	c.add(k1);
	c.add(password);
	c.add(k2);
	c.add(b1);
	c.add(b2);
	
	setBounds(600,300,250,150);
	setVisible(true);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    String path = "image\\22.jpg"; // 背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）
	ImageIcon background = new ImageIcon(path); // 背景图片
	JLabel label = new JLabel(background); // 把背景图片显示在一个标签里面    

	label.setBounds(0,0,this.getWidth(),this.getHeight()); // 把标签的大小位置设置为图片刚好填充整个面板
	JPanel imagePanel = (JPanel) this.getContentPane(); // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
	imagePanel.setOpaque(false);
	this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));// 把背景图片添加到分层窗格的最底层作为背景
    setSize(262,220);
}

//主函数
public static void main(String[] args) {
	User f1=new User(new JFrame());
	}
//登录按钮方法
private class BHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(k1.getText().equals("")||k2.getText().equals("")){
				JOptionPane.showMessageDialog(User.this,"用户名密码不能为空！" );
			}
			else{
				Statement stmt=null;
				ResultSet rs=null;
				String sql;
  			    sql="select * from admin where username='"+k1.getText()+"'";
			   try{
				   Connection dbConn1=ConnectDB.CONN();
					stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					rs=stmt.executeQuery(sql);					
					if(rs.next()){
						String xm=rs.getString("password");
						if(k2.getText().equals(xm.trim())){JOptionPane.showMessageDialog(User.this,"登录成功");
						dispose();
							new Menu();//管理窗口	
							
							
							
							}
						else{JOptionPane.showMessageDialog(User.this,"密码错误");}
					}
					else{JOptionPane.showMessageDialog(User.this,"用户名错误");}
					rs.close();
					stmt.close();
			   }
			   catch(SQLException e){
				   JOptionPane.showMessageDialog(User.this,"SQL Exception occur.Message is:"+e.getMessage());
				   }
			}			
	}
	}
//退出方法结束
private class EXIT implements ActionListener{
	public void actionPerformed(ActionEvent even){
		System.exit(0);
	}
}
}//父类结束
