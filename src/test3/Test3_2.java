package test3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class Test3_2
{
       public static void main(String[] args)
       {
              int[] pai = new int[54];
              for(int i=0;i<54;i++)
              {
                     pai[i] = i+1;
              }
              new DispFrame(pai).setVisible(true);
       }
       public static void xi(int [] a)
       {
              Random ran = new Random();
              int[] b = new int[a.length];
              int pos;
              for(int i=0;i<54;i++)
              {
                 pos = ran.nextInt(a.length);
                 while(b[(pos++)%a.length]!=0);
                 b[(pos+53)%a.length] = a[i];
              }
              System.arraycopy(b,0,a,0,b.length);
       }
}
class DispFrame extends JFrame implements ActionListener
{
       public int[] pai;
       public String[] spai = new String[]{
       "黑桃A","黑桃2","黑桃3","黑桃4","黑桃5","黑桃6","黑桃7","黑桃8","黑桃9","黑桃10","黑桃J","黑桃Q","黑桃K",
          "红桃A","红桃2","红桃3","红桃4","红桃5","红桃6","红桃7","红桃8","红桃9","红桃10","红桃J","红桃Q","红桃K",
          "梅花A","梅花2","梅花3","梅花4","梅花5","梅花6","梅花7","梅花8","梅花9","梅花10","梅花J","梅花Q","梅花K",
          "方块A","方块2","方块3","方块4","方块5","方块6","方块7","方块8","方块9","方块10","方块J","方块Q","方块K",
          "小王","大王"};
       public DispFrame(int[] pai)
       {
              this.setLayout(null);
              JButton jbXiPai = new JButton("洗牌");
              jbXiPai.addActionListener(this);
              jbXiPai.setBounds(10,10,60,30);
              this.getContentPane().add(jbXiPai);
              this.pai = pai;
              setTitle("显示牌局");
              setSize(800,600);
              setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       }
      
       public void drawPai(Graphics g)
       {
              g.draw3DRect(1,1,222,222,true);
       }
      
       public void paint(Graphics g)
       {
              this.paintComponents(g);
              int top = 80;
              int left = 50;
              Font font = new Font("f", Font.BOLD, 16);
              g.setFont(font);
              for(int i=0;i<54;i++)
             {
                     int x = left + i%9 * 80;
                     int y = top + (i/9) * 85;
                     g.setColor(Color.gray);
                     g.drawRoundRect(x,y,60,80,5,5);
                     g.drawRoundRect(x+1,y+1,60,80,5,5);
                     String s = spai[pai[i]-1];
                    
                     if(s.startsWith("红桃") || s.startsWith("方块") || s.startsWith("大王"))
                     {
                            g.setColor(Color.red);
                     }
                     else
                     {
                         g.setColor(Color.black);
                     }
                     g.drawString(s, x+10, y+20);
              }
       }
      
       public void actionPerformed(ActionEvent ae)
       {
              Test3_2.xi(this.pai);
              this.repaint();
       }
}