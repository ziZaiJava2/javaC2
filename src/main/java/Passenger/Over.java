package Passenger;

public class Over implements Runnable {

	volatile boolean keepRunning2 = true;
	Start ppp = new Start();

	@Override
	public void run() {
		while (keepRunning2) {

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ppp.saleTickets();
			System.out.println("队伍：" + "\n" + ppp.linesDesc());
			if (Start.getSaledTikets() >= 20) {
				keepRunning2 = false;
			}

		}

	}

}
