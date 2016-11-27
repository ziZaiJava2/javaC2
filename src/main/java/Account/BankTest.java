package Account;

public class BankTest {
	public static void main(String[] args) {
        /*
         * 初始化三个人 
         */
		Person a = new Person("4455669", "徐加亮", 10000);
		Person b = new Person("3355447", "徐嘉良", 500000);
		Person c = new Person("2299887", "虚假亮", 800000);

		/*
		 * 初始化一个银行类， Bank icbc（工商银行）
		 */
		Bank icbc = new Bank();
		/*
		 * 用银行对象的 register方法， 为每个人注册一个账号
		 */
		icbc.register(a);
		icbc.register(b);
		icbc.register(c);
		
        /*
         * 对三个Person对象 分别调用 银行对象的 saveMoney方法， 第一个人存 5000， 第二个人存100000， 第三个人存 500000。
         */
		icbc.saveMoney(a, 50000);
		icbc.saveMoney(b, 400000);
		icbc.saveMoney(c, 700000);

		/*
		 * 分别调用三个Person对象的showMyMoney 方法
		 */
		a.showMyMoney();
		b.showMyMoney();
		c.showMyMoney();
	}
}
