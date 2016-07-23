package test4;

import java.awt.Point;

public class Circle implements Cloneable {
     private Point centre=new Point(50,50);
     private float radius=10.0f;
     
     public Circle clone() throws CloneNotSupportedException{
    	 Circle c=(Circle)super.clone();
    	 c.centre=(Point)centre.clone(); 
    	 return c;
     }
}
