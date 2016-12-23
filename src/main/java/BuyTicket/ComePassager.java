package BuyTicket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ComePassager {
	
	public static List<Person> comingPassagers() {

		Random random = new Random();

		int number = random.nextInt(3) + 1;

		List<Person> passager = new ArrayList<Person>();

		for (int i = 0; i < number; i++) {
			
			int n = random.nextInt(names.size());

			Person person = new Person(names.get(n));

			passager.add(person);
		}
		totalPassagers += passager.size();

		return passager;
	}

	@SuppressWarnings("unused")
	private static int totalPassagers = 0;

	private static List<String> names = Arrays.asList("Jim", "Ken", "Leon", "Ada", "Lily", "Lucy", "Will", "Eagle",
			"David", "Zoe", "Wendy", "Acea", "Kin", "Fish", "Paul", "Dean");
	



}
	class Person {
		
		public String name;

		public Person(String name) {
			this.name = name;
		}

		public void set(Person person) {
			
		}

		public String getName() {
			return this.name;
		}

		public String toString() {
			return name;
		}
	}

