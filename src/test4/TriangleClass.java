package test4;

import java.awt.Point;

public class TriangleClass extends ShapeClass {
    private int a;
    private int b;
    private int c;
    
    public TriangleClass(){
    	super();
    	a=0;
    	b=0;
    	c=0;

    }
    public TriangleClass(Point place,int a,int b,int c){
    	
    	super(place);
    	this.a=a;
    	this.b=b;
    	this.c=c;
    }
 public TriangleClass(int a,int b,int c){
    	
    	super();
    	this.a=a;
    	this.b=b;
    	this.c=c;
    }
    
    public double area(){
    	int  s=0;
    	s=1/2*(a+b+c);
       return Math.sqrt(s*(s-a)*(s-b)*(s-c));    	
    }
    public int pemeter(){ return a+b+c; }
    
    public int getA(){ return a; }
    public int getB(){  return b;}
     public int getC(){ return c;  }
    public void setLW(int a,int b,int c){ 
    	this.a=a;
    	this.b=b;
    	this.c=c;
    	
    }
}
