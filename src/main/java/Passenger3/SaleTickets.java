package Passenger3;

import java.util.List;

public class SaleTickets extends Thread {

	private List<Person> line;

	public SaleTickets(List<Person> line) {
		this.line = line;
	}

	public void run() {

		Main.saleTicket(line);
	}

}
