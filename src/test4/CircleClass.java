package test4;

import java.awt.Point;

public class CircleClass extends ShapeClass {
     private int r;
     
     public CircleClass(){
    	 super();
    	 r=0;
     }
     public CircleClass(int r){
   	  super();
   	  this.r=r;
     }
      public CircleClass(Point place,int r){
    	  super(place);
    	  this.r=r;
      }
      public double area(){
    	  return 3.14*r*r;
      }
      public double pemeter(){ return 2*3.14*r; }
      
      public int getR(){return r;}
      public void setLW(int r){
    	  this.r=r;
    	  
      }
      
}
