package com.ccit.ui;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.ccit.bean.User;
import com.ccit.dao.imp.DaoManager;
import com.ccit.uimytool.MyLink;
import com.ccit.uimytool.MyButton;
import com.ccit.uimytool.MyPanel;


public class LoginFrame extends JFrame implements DaoManager {
	private Box box=Box.createVerticalBox();
	private Box boxhead=Box.createHorizontalBox();
	private Box boximg=Box.createHorizontalBox();
	private Box boxuser=Box.createHorizontalBox();
	private Box boxpwd=Box.createHorizontalBox();
	private Box boxmid1=Box.createVerticalBox();
	private Box mylinkbox=Box.createVerticalBox();
	private Box boxmid2=Box.createHorizontalBox();
	private Box box12=Box.createHorizontalBox();
	private Box boxuserimg=Box.createHorizontalBox();
	private Box boxbut=Box.createHorizontalBox();
	private Box boxcheck=Box.createHorizontalBox();
	private JLabel imgup=new JLabel(new ImageIcon("src/com/ccit/img/head.jpg"));
	private JLabel imgmid=new JLabel(new ImageIcon("src/com/ccit/img/title.jpg"));
	private JLabel imgdown=new JLabel(new ImageIcon("src/com/ccit/img/user.png"));
	private JLabel jluser=new JLabel("用户：");
	private JLabel jlpwd=new JLabel("密码：");
	private JTextField jtuer=new JTextField();
	private JPasswordField jtpwd=new JPasswordField();
	private JCheckBox jckauto=new JCheckBox("自动登陆");
	private JCheckBox jckrempw=new JCheckBox("记住密码",true);
	private JButton jblogin=new JButton("登陆");
	private JButton jbcancel=new JButton("取消");
	private MyLink myForget = new MyLink("忘记密码");
	private MyLink myRegister = new MyLink("注册用户");
	private MyButton mbexit=new MyButton(0,"/com/ccit/img/expend1.png");
	private MyButton mbexpend=new MyButton(1,"/com/ccit/img/exit.png");
	private MyPanel mp=new MyPanel();
	private Choice chStates = new Choice();
	public LoginFrame()
	{
		super("登陆界面");
		inintFrame();
		
		this.setVisible(true);
	}
	
	public void inintFrame()
	{
		this.setUndecorated(true);
		this.setSize(335, 250);
		this.setLocation(300, 300);
		
		displayFrame();
		
	}
	public void displayFrame()
	{
		
		boxhead.add(imgup);
		boxhead.add(mbexit);
		boxhead.add(mbexpend);
		
		boximg.add(imgmid);
		
		
		boxuser.add(jluser);
		boxuser.add(jtuer);
		
		jtpwd.setEchoChar('$');
		boxpwd.add(jlpwd);
		boxpwd.add(jtpwd);
		
		boxmid1.add(boxuser);
		boxmid1.add(Box.createVerticalStrut(6));
		boxmid1.add(boxpwd);
		
		mylinkbox.add(Box.createHorizontalStrut(15));
		mylinkbox.add(myForget);
		mylinkbox.add(Box.createVerticalStrut(10));
		mylinkbox.add(myRegister);
		mylinkbox.add(Box.createHorizontalStrut(20));
		
		boxuserimg.add(Box.createHorizontalStrut(10));
		boxuserimg.add(imgdown);
		boxuserimg.add(Box.createHorizontalStrut(15));
		boxmid2.add(boxuserimg);
		boxmid2.add(boxmid1);
		boxmid2.add(mylinkbox);
		boxmid2.add(Box.createHorizontalStrut(5));
		
		
		chStates.add("普通用户");
		chStates.add("管理员");
		
		boxcheck.add(Box.createHorizontalStrut(5));
		boxcheck.add(chStates);
		boxcheck.add(Box.createHorizontalStrut(25));
		boxcheck.add(jckauto);
		boxcheck.add(Box.createHorizontalStrut(10));
		boxcheck.add(jckrempw);
		
		
		boxbut.add(jblogin);
		boxbut.add(Box.createHorizontalStrut(20));
		boxbut.add(jbcancel);
		mp.add(boxbut);
		
		box.add(boxhead);
		box.add(boximg);
		box.add(Box.createVerticalStrut(10));
		box.add(boxmid2);
		box.add(Box.createVerticalStrut(6));
		box.add(boxcheck);
		box.add(Box.createVerticalStrut(0));
		box.add(mp);
		
		this.add(box);
		addListener();
		LoginAction();
	}
	public void addListener()
	{
		mbexit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String orgin=e.getActionCommand();
				if("1".equals(orgin))
				{
					LoginFrame.this.dispose();
				}
				else
					LoginFrame.this.setState(1);
				
			}
		});
		mbexpend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String orgin=e.getActionCommand();
				if("1".equals(orgin))
				{
					LoginFrame.this.dispose();
				}
				else
					LoginFrame.this.setState(1);
			}
		});
		
	}
	
	public void LoginAction()
	{
		String username=jtuer.getText();
		String pwd=String.valueOf(jtpwd.getPassword());
		int rights=chStates.getSelectedIndex();
		
		User user=new User(username,pwd,rights);
		//int states =  udi.loginUser(user);
		
		JOptionPane.showMessageDialog(LoginFrame.this, "登录成功", "成功", JOptionPane.INFORMATION_MESSAGE);
		LoginFrame.this.dispose();
		
		
	}
	

	public static void main(String args[])
	{
		new LoginFrame();
	}

}


