package Passenger3;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private static List<Person> line1 = new ArrayList<>();
	private static List<Person> line2 = new ArrayList<>();
	private static List<Person> line3 = new ArrayList<>();
	private static List<Person> line4 = new ArrayList<>();

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			try {

				Thread.sleep(1000);
				Thread add = new AddPassengers();
				Thread sale1 = new SaleTickets(line1);
				Thread sale2 = new SaleTickets(line2);
				Thread sale3 = new SaleTickets(line3);
				Thread sale4 = new SaleTickets(line4);

				add.start();
				sale1.start();
				sale2.start();
				sale3.start();
				sale4.start();

				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		int passagers = passagersInLines();

		System.out.printf("总共有%d个乘客进入车站，卖出%d张车票，还有%d个乘客没有买到车票。\n", AddPassengers.getTotalPassagers(), saledTickets,
				passagers);
	}

	public static void lineUp(List<Person> passages) {

		List<Person> min = line1;
		if (min.size() > line2.size()) {
			min = line2;
		}
		if (min.size() > line3.size()) {
			min = line3;
		}
		if (min.size() > line4.size()) {
			min = line4;
		}
		min.addAll(passages);
	}

	private static int saledTickets = 0;

	public static int passagersInLines() {
		int passages = AddPassengers.getTotalPassagers() - saledTickets;
		return passages;
	}

	static void saleTicket(List<Person> line) {
		if (!line.isEmpty()) {
			saledTickets += 1;
			System.out.println(line.get(0) + "买到票");
			line.remove(0);
		}
	}

	public void saleTickets() {

		saleTicket(line1);
		saleTicket(line2);
		saleTicket(line3);
		saleTicket(line4);
	}

	public static String linesDesc() {
		return "line1:" + line1.toString() + "\n" + "line2:" + line2.toString() + "\n" + "line3:" + line3.toString()
				+ "\n" + "line4:" + line4.toString() + "\n";
	}
}
