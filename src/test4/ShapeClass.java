package test4;

import java.awt.Point;

public abstract class ShapeClass {
     private Point place;
     
     public abstract double area();
     public ShapeClass(){
    	 place=new Point();
     }
     public ShapeClass(Point place){
    	 this.place=place;
     }
     
     public void setPlace(Point place){  this.place=place;}
     public Point getPlace(){ return place;}
     public String toString(){
    	 return place.toString();
    	 
     }
}
