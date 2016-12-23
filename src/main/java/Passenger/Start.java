package Passenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Start implements Runnable {

	volatile boolean keepRunning = true;

	// private static List<String> names = Arrays.asList("Jim", "Ken", "Leon",
	// "Ada", "Lily", "Lucy", "Will", "Eagle",
	// "David", "Zoe", "Wendy", "Acea", "Kin", "Fish", "Paul", "Dean");

	private static List<String> names = Arrays.asList("11", "22", "33", "44", "55", "66", "77", "88", "99", "00");

	private static List<Person> line1 = new ArrayList<>();
	private static List<Person> line2 = new ArrayList<>();
	private static List<Person> line3 = new ArrayList<>();
	private static List<Person> line4 = new ArrayList<>();

	@Override
	public void run() {
		while (keepRunning) {
			synchronized (this) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				List<Person> peoplepp = new ArrayList<>();

				Random random = new Random();
				for (int i = 1; i <= random.nextInt(6) + 1; i++) {
					Person person = new Person(names.get(random.nextInt(names.size())));
					peoplepp.add(person);
				}
				System.out.print("组队过来一批：");
				for (Person person : peoplepp) {

					System.out.print(person + " ");
				}

				lineUp(peoplepp);
				System.out.println("\n" + "排到队伍中" + "\n" + linesDesc());
			}
			if (Start.getSaledTikets() >= 20) {
				keepRunning = false;
				System.out.println("共卖了" + Start.getSaledTikets() + "张票");
				// System.out.println("已经快没票了，不卖了");
			}
		}
	}

	public void lineUp(List<Person> passages) {

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

	public void saleTickets() {

		saleTicket(line1);
		saleTicket(line2);
		saleTicket(line3);
		saleTicket(line4);
	}

	private static int saledTikets = 0;

	public static int getSaledTikets() {
		return saledTikets;
	}

	public static void setSaledTikets(int saledTikets) {
		Start.saledTikets = saledTikets;
	}

	public static void saleTicket(List<Person> line) {
		if (!line.isEmpty()) {
			saledTikets += 1;
			System.out.println(line.get(0) + "买到票了");
			line.remove(0);
		}

	}

	// 一组凑齐四个
	// public static boolean ddd() {
	// if (line1.size() != 0 && line2.size() != 0 && line3.size() != 0 &&
	// line4.size() != 0) {
	// return true;
	// }
	// return false;
	//
	// }

	public String linesDesc() {
		return "1号窗口:" + line1.toString() + "\n" + "2号窗口:" + line2.toString() + "\n" + "3号窗口:" + line3.toString() + "\n"
				+ "4号窗口:" + line4.toString() + "\n";
	}
}
