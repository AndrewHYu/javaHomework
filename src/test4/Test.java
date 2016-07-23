package test4;

public class Test {
    public static void main(String[] args) {
		RectangleClass rectangleClass=new RectangleClass();
		rectangleClass.setLW(2, 3);
		
    	SquareClass squareClass=new SquareClass();
    	squareClass.setEdge(3);
    	
    	TriangleClass triangleClass=new TriangleClass();
    	triangleClass.setLW(3, 3, 3);
    	
    	double tArea=triangleClass.area();
    	
    	double rArea=rectangleClass.area();
    	int rPermeter=rectangleClass.permeter();
    	
    	double sArea=squareClass.area();
    	int sPermeter=squareClass.permeter();
    	
    	System.out.println("长方形面积 ：" +rArea);
    	System.out.println("  ");
    	System.out.println("长方形周长 ：" +rPermeter);
    	System.out.println("  ");
    	System.out.println("正方形面积：  "+sArea);
    	System.out.println("  ");
    	System.out.println(" 正方形周长：  " +sPermeter);
    	System.out.println(rArea);
	}
}
