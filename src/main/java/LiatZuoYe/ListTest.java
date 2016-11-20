package LiatZuoYe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<Integer> fullList = new ArrayList<Integer>();
		for (int i = 0; i <= 100; i++) {
			fullList.add(i);
		}
		System.out.println(fullList);

		List<Integer> getOdds = new ArrayList<Integer>();
		for (int number : fullList) {
			if (number % 2 == 1) {
				getOdds.add(number);
			}
		}
		System.out.println(getOdds);

		List<Integer> getEvens = new ArrayList<Integer>();
		for (int number1 : fullList) {
			if (number1 % 2 == 0) {
				getEvens.add(number1);
			}
		}
		System.out.println(getEvens);

		List<Integer> pingFangNumber = new ArrayList<Integer>();
		for (int a : fullList) {
			pingFangNumber.add(a * a);

		}
		System.out.println(pingFangNumber);
		
		
		
	
	}

}
