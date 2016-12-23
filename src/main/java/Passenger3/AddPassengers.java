package Passenger3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AddPassengers extends Thread {

	private static int totalPassagers = 0;

	public static int getTotalPassagers() {
		return totalPassagers;
	}

	private static List<String> names = Arrays.asList("11", "22", "33", "44", "55", "66", "77", "88", "99", "00");

	@Override
	public void run() {
		synchronized (this) {
			try {
				Thread.sleep(2000);

				Random random = new Random();

				System.out.println("等待中：" + "\n" + Main.linesDesc());

				for (int x = 0; x < random.nextInt(3) + 1; x++) {
					List<Person> peoplepp = new ArrayList<>();

					for (int i = 1; i <= random.nextInt(3) + 1; i++) {
						Person person = new Person(names.get(random.nextInt(names.size())));
						totalPassagers += 1;
						peoplepp.add(person);
					}
					System.out.print("组队过来一批：");
					for (Person person : peoplepp) {

						System.out.print(person + " ");
					}
					System.out.println();
					Main.lineUp(peoplepp);
				}
				System.out.println("\n" + "排到队伍中" + "\n" + Main.linesDesc());
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}