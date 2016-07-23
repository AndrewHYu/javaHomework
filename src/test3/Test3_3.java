package test3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Test3_3
{
       public static void main(String[] args)
       {
              int[] pai = new int[54];
              for(int i=0;i<54;i++)
              {
                     pai[i] = i+1;
              }
              new DispFrame3_3(pai).setVisible(true);
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

class DispFrame3_3 extends JFrame implements ActionListener
{
       public int[] pai;
       public String[] spai = new String[]{
               "♠A","♠2","♠3","♠4","♠5","♠6","♠7","♠8","♠9","♠10","♠J","♠Q","♠K",
               "♥A","♥2","♥3","♥4","♥5","♥6","♥7","♥8","♥9","♥10","♥J","♥Q","♥K",
               "♣A","♣2","♣3","♣4","♣5","♣6","♣7","♣8","♣9","♣10","♣J","♣Q","♣K",
               "♦A","♦2","♦3","♦4","♦5","♦6","♦7","♦8","♦9","♦10","♦J","♦Q","♦K",
               "joker","JOKER"};
       public DispFrame3_3(int[] pai)
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

                 if(s.startsWith("♥") || s.startsWith("♦") || s.startsWith("JOKER"))
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
              Test3_3.xi(this.pai);
              this.repaint();
       }
}