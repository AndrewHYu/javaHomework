package test5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPanel5_1 myPanel=new MyPanel5_1();
	}
}
class MyPanel5_1 extends JFrame implements ActionListener{
	private JPasswordField firstPassword;
	
	private JPasswordField secondPassword;
	
	private JLabel firstLabel;
	
	private JLabel secondLabel;
	
	private JButton determine;
	
	private JButton cancel;
	
	MyPanel5_1(){
		
		//设置布局方式
		GridLayout gLayout=new GridLayout(3,2);
		this.setLayout(gLayout);
		this.setTitle("修改密码");
		
		//创建按钮和添加监听器
		determine=new JButton("确定");
		determine.addActionListener(this);
		cancel=new JButton("取消");
		cancel.addActionListener(this);
		
		//创建文本框
		firstPassword=new JPasswordField();
		secondPassword=new JPasswordField();
		
		//创建label
		firstLabel=new JLabel("新密码");
		secondLabel=new JLabel("确认密码");
		
		//将控件加入窗体
		this.add(firstLabel);
		this.add(firstPassword);
		this.add(secondLabel);
		this.add(secondPassword);
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
		// TODO Auto-generated method stub
		if (e.getSource().equals(determine)) {
			if(firstPassword.getPassword().equals(secondPassword.getPassword())&&firstPassword.getPassword()!=null){
				JOptionPane.showMessageDialog(null,"修改成功");
			}
			else {
				JOptionPane.showMessageDialog(null,"修改失败");
			}
		}else if (e.getSource().equals(cancel)) {
			JOptionPane.showMessageDialog(null,"取消修改");
			this.dispose();
		}
	}
}
