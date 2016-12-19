package jintaidaili;

public class Main {

	public static void main(String[] args) {

		BeiDaiLi run = new BeiDaiLi();
		Move action = new DaiLi(run);

		System.out.println("walk,next run");
		action.action();
		
	}

}
