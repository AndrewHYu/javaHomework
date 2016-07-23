package test4;

import java.awt.Point;

public class RectangleClass extends ShapeClass {
     private int length;
     private int width;
     
     public RectangleClass(){
    	 super();
    	 length=0;
    	 width=0;
    	 
     }
 public RectangleClass(int length,int width){
    	 
    	 super();
    	 this.length=length;
    	 this.width=width;
     }
     public RectangleClass(Point place,int length,int width){
    	 
    	 super(place);
    	 this.length=length;
    	 this.width=width;
     }
     public double area(){ return length*width; }
     public int permeter() { return 2* (length+width); }
     public int getLength(){ return length;}
     public int getWidth(){  return width;}
     public void setLW(int length,int width){
    	 this.length=length;
    	 this.width=width;
    	 
     }
     public String toString(){
    	 return "length: " +length +"width: "+ width;
    	 
     }
     
}
