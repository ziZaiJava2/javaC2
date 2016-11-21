package App;

public class Shape1 {
	static String[][] data = {
			{"Circle","10"},
			{"Square","20"},
			{"Circle","11"},
			{"Circle","13"},
			{"Square","15"},
			{"EquilateralTriangle","10"}
	};
	
	
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(String[] shape : data){
			Shape s = ShapeFactory.getInstance(shape[0],Integer.parseInt(shape[1]));
			
			System.out.print(s.toString() + "，");
			System.out.println("周长：" + s.perimeter());
		}
	}

}

class Circle implements Shape{
	private int r;
	
	public Circle(int r){
		this.r = r;
	}
	
	public String toString(){
		return String.format("圆形，半径：%d",this.r);
	}
	
	public double perimeter(){
		return 2*this.r*Math.PI;
	}
}

class Square implements Shape{
	private int side;
	
	public Square(int side){
		this.side = side;
	}
	
	public String toString(){
		return String.format("正方形，边长：%d",this.side);
	}
	public double perimeter(){
		return 4*this.side;
	}	
}

class ETriangle implements Shape{
	private int side;
	
	public ETriangle(int side){
		this.side = side;
	}
	
	public String toString(){
		return String.format("等边三角形，边长：%d",this.side);
	}
	
	public double perimeter(){
		return 3*this.side;
	}
}


class ShapeFactory{
	public static final String CIRCLE = "Circle";
	public static final String SQUARE = "Square";
	public static final String E_TRIANGLE = "EquilateralTriangle";
	public static final Shape getInstance(String type,int len){
		Shape s = null;
		if(CIRCLE.equals(type)){
			s = new Circle(len);
		}else if(SQUARE.equals(type)){
			s = new Square(len);
		}else if(E_TRIANGLE.equals(type)){
			s = new ETriangle(len);
		}else{
			System.out.println("错误输入！！");
			System.exit(0);
		}
		return s;
	}
}

interface Shape{
	
	public String toString();
		
	public double perimeter();
}





