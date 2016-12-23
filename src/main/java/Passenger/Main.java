package Passenger;

public class Main {

	public static void main(String[] args) {

		Start ppp = new Start();
		Over jin = new Over();

		Thread run = new Thread(ppp);
		run.start();

		Thread run2 = new Thread(jin);
		run2.start();

	}

}
