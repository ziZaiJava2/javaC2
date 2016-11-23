package com.zizaitianyuan.javac2.lesson06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class WashTheDishes {
	public static final String CIRCLE = "Circle";
	public static final String SQUARE = "Square";
	public static final String E_TRIANGLE = "EquilateralTriangle";

	private static LinkedList<Wan> line = new LinkedList<>();//一个洗碗传送台

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			
			comingWan(wan);
		}
		System.out.printf("统计总共放入%d个盘子。1号个洗碗工洗了%d个，2号个洗碗工洗了%d个，传送台上还剩下%d个盘子。碗柜里总共有%d个盘子，各种类型的盘子是%d。最后看看盘子有没有丢\n",totalPut,totalWash1,totalWash2,,,);
	}

}

//每次从尾部放入要洗的盘子，从头拿出盘子去洗。
	public static void washDishes(List<Wan> dishes) {
		for (Wan wan : line) {
			line.addLast(wan);
			line.getFirst();
			List<Wan> passages = comingWan();

		}
	}
//碗柜
	private static Map<String, line> washedWan = new HashMap<String, line>();

	private static int totalWanGui = 0;
//洗完放入碗柜
public static list(List<Wan> type){
	Set<String> set = washedWan.keySet("Circle","Square","EquilateralTriangle");
	
	for(Wan okWan:line){
		if(CIRCLE.equals(type)){
			washedWan.put("circle",okWan);
		}else if (SQUARE.equals(type)){
			washedWan.put("Square",okWan);
		}else if (E_TRIANGLE.equals(type)){
			washedWan.put("EquilateralTriangle",okWan);
		}else{
			System.out.println("错误！！！");
			System.exit(0);
		}
		totalWanGui +=1;
	}
}



	private static int totalPut = 0;
//定义一个方法随机放入4到12个盘子到传送台，并统计总共放入盘子的数量
	public static LinkedList<Wan> randomPut() {
		Random random = new Random();
		for (int i = 1; i <= random.nextInt(9) + 4; i++) {
			totalPut += 1;
			Wan wan = new Wan(type.get(random.nextInt(type.size())));
			line.add(wan);
		}
		return line;
	}

	private static List<String> type = Arrays.asList("Circle", "Square", "EquilateralTriangle");

	private static int totalWash1 = 0;
	private static int totalWash2 = 0;
//两个洗碗工，他们可以随机从传送台取3到5个盘子
	public static List<Wan> comingWan() {
		List<Wan> wann = new ArrayList<>();
		Random random = new Random();
		for (int i = 1; i <= random.nextInt(3) + 3; i++) {
			totalWash1 += 1;
			Wan wan = new Wan(line.getFirst(line));
			wann.add(wan);
		}
		for (int i = 1; i <= random.nextInt(3) + 3; i++) {
			totalWash2 += 1;
			Wan wan = new Wan(line.getFirst());
			wann.add(wan);
		}
		return wann;
	}

public class Wan{
	private String wan;
	
	public Wan(String wan){
		this.wan = wan;
	}
	public String getWan() {
		return this.wan;
	}
}


