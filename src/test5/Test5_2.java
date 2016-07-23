package test5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test5_2 {

	public static void main(String[] args) {
		MyPanel5_2 myPanel=new MyPanel5_2();
	}

}
class MyPanel5_2 extends JFrame implements ActionListener{
	private JTextField userName;
	
	private JPasswordField password;
	
	private JLabel firstLabel;
	
	private JLabel secondLabel;
	
	private JButton determine;
	
	private JButton cancel;

	MyPanel5_2(){
		
		//设置布局方式
		GridLayout gLayout=new GridLayout(3,2);
		this.setLayout(gLayout);
		this.setTitle("登录");
		
		//创建按钮和添加监听器
		determine=new JButton("确定");
		determine.addActionListener(this);
		cancel=new JButton("取消");
		cancel.addActionListener(this);
		
		//创建文本框
		userName=new JTextField();
		password=new JPasswordField();
		
		//创建label
		firstLabel=new JLabel("用户名：");
		secondLabel=new JLabel("密码：");
		
		//将控件加入窗体
		this.add(firstLabel);
		this.add(userName);
		this.add(secondLabel);
		this.add(password);
		this.add(determine);
		this.add(cancel);
		
		//设置窗口属性
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		int width=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2, height/2);
		this.setSize(350, 150);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(determine)) {
			System.out.println(password.getPassword().toString());
			if(userName.getText().equals("admin")&&String.valueOf(password.getPassword()).equals("admin")){
				JOptionPane.showMessageDialog(null,"登录成功");
				}else if(!userName.getText().equals("admin")){
				JOptionPane.showMessageDialog(null,"用户名错误");
				}else if (!String.valueOf(password.getPassword()).equals("admin")) {
				JOptionPane.showMessageDialog(null,"密码错误");
				}else{
				JOptionPane.showMessageDialog(null,"不可知错误");
				}
			}else if (e.getSource().equals(cancel)) {
			JOptionPane.showMessageDialog(null,"取消登录");
			this.dispose();
		}
	}
}