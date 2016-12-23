package BuyTicket;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class LineInStation extends ComePassager{

	private static LinkedList<Person> line1 = new LinkedList<>();
	private static LinkedList<Person> line2 = new LinkedList<>();
	private static LinkedList<Person> line3 = new LinkedList<>();
	private static LinkedList<Person> line4 = new LinkedList<>();
	

	public static void main(String[] args) {

		ExecutorService er = Executors.newCachedThreadPool();
		er.execute(new Runnable() {

			@Override
			public void run() {
				// 为了让他一直执行下去，我们定义一个死循环

				while (true) {

					// 这里定义每隔多久进入一个人

					try {

						Thread.sleep(1000);

					} catch (InterruptedException e) {

						// 可以了解一下这个异常，我们下次课再说明一下

						e.printStackTrace();

					}

					// 需要一个锁来在保证队伍的线程安全，我这里用了 一个比较大粒度的锁。

					// 这里也可以用一个比较小粒度的锁，在不是对加入的队列有特别严格的要求的时候可以每个队列一个锁

					// 只在修改和获取的时候锁相应的队伍

					// 大家可以自行考虑怎么做

					// 然后为了防止队伍爆掉，可以加入限制，人数到一定数量就不让排入队伍了。

					synchronized (LineInStation.class) {
						List<Person> min = line1;

						if (min.size() > line2.size()) {
							min = line2;
							System.out.println("加入了队伍2:" );
						}
						if (min.size() > line3.size()) {
							min = line3;
							System.out.println("加入了队伍3:" );
						}
						if (min.size() > line4.size()) {
							min = line4;
							System.out.println("加入了队伍4:" );
						}else{
							System.out.println("加入了队伍1:");
						}
						min.addAll(ComePassager.comingPassagers());
						

					}

				}

			}

		});
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(new Runnable() {
             int count1 =0;
			@Override
			public void run() {
				
				while (true) {

					try {

						Thread.sleep(1000);

					} catch (InterruptedException e) {

						e.printStackTrace();

					}

					synchronized (LineInStation.class) {

						if (line1.size() > 0) {

							Person person = line1.removeFirst();

							System.out.println(person.getName() + " 买了票  "+"\n1号窗口卖出了： "+(++count1)+"张票");

						}

					}

				}

			}
		});
		es.execute(new Runnable() {
			int count2 = 0;
			@Override
			public void run() {
				
				while (true) {

					try {

						Thread.sleep(1000);


						synchronized (LineInStation.class) {

						if (line2.size() > 0) {

							Person person = line2.removeFirst();

							System.out.println(person.getName() + " 买了票  "+"\n2号窗口卖出了： "+(++count2)+"张票");
						}

					}
					} catch (InterruptedException e) {
						
						e.printStackTrace();
						
					}

				}

			}
		});
		es.execute(new Runnable() {
          int count3 = 0;
			@Override
			public void run() {
								
				while (true) {

					try {

						Thread.sleep(1000);

					} catch (InterruptedException e) {

						e.printStackTrace();

					}

					synchronized (LineInStation.class) {

						if (line3.size() > 0) {

							Person person = line3.removeFirst();

							System.out.println(person.getName() + " 买了票  "+"\n3号窗口卖出了： "+(++count3)+"张票");

						}

					}

				}

			}
		});
		es.execute(new Runnable() {
         int count4 = 0;
			@Override
			public void run() {
				
				while (true) {

					try {

						Thread.sleep(1000);

					} catch (InterruptedException e) {

						e.printStackTrace();

					}

					synchronized (LineInStation.class) {

						if (line4.size() > 0) {

							Person person = line4.removeFirst();

							System.out.println(person.getName() + " 买了票"+"\n4号窗口卖出了： "+(++count4)+"张票");


						}

					}

				}

			}
		});

	}
	


}
	
	


