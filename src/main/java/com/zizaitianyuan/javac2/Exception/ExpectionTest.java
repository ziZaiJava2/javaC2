package com.zizaitianyuan.javac2.Exception;

@SuppressWarnings("serial")
public class ExpectionTest extends Exception {

	public ExpectionTest(String message) {
		super(message);
	}

	public ExpectionTest() throws NetWorkDownException {
		throw new NetWorkDownException();
	}

	public boolean dizheng(String city) throws NetWorkDownException, CanNotRunning, NetworkDown {
		boolean hasPower = false;
		boolean running = false;
		boolean networkDown = false;

		boolean result = false;
		if (hasPower) {
			try {
				throw new OutOfPower("out of power");
			} catch (OutOfPower e) {
				
				e.printStackTrace();
			}// 方法可以自己定义
		}
		if (running) {
			throw new CanNotRunning("can't running");// 方法可以自己定义
		}
		if (networkDown) {
			throw new NetworkDown("networkDown");// 方法可以自己定义
		}
		result = true;
		return result;
	}

	public static void main(String[] args) {

	}

}
