package test4;

import java.awt.Point;

public class SquareClass extends RectangleClass {
     public SquareClass(){ super();}
     public SquareClass(Point place, int edge){
    	 
    	 super(place, edge, edge);
     }
     public int getEdge(){ return getLength();}
     public void setEdge(int edge) { setLW(edge, edge);}
}
