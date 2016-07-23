package test4;

public class Test2 {
     public static void main(String[] args) {
		
    	 ShapeClass[] shapeClass =new ShapeClass[10];
    	 shapeClass[0]=new RectangleClass(3,3);
    	 shapeClass[1]=new TriangleClass(3,3,3);
    	 shapeClass[2]=new CircleClass(3);
    	 
    	 for(int i=0;i<3;i++){
    		 System.out.println(shapeClass[i].area());
    		 
    	 }
    	 
    	 
    	 
	}
}
