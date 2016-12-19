package jintaidaili;

public class DaiLi implements Move {

	private BeiDaiLi running;
	
	public DaiLi(BeiDaiLi run) {
		this.running = run;
	}
	@Override
	public void action() {

		running.action();
	}

}
