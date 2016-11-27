package Account;

public class BankTest {
	public static void main(String[] args) {

		Person a = new Person("4455669", "徐加亮", 10000);
		Person b = new Person("3355447", "徐嘉良", 500000);
		Person c = new Person("2299887", "虚假亮", 800000);
		
		Bank icbc = new Bank();
		icbc.register(a);
		icbc.register(b);
		icbc.register(c);
		
		icbc.saveMoney(a, 50000);
		icbc.saveMoney(b, 400000);
		icbc.saveMoney(c, 700000);
	
		a.showMyMoney();
		b.showMyMoney();
		c.showMyMoney();
	}
}
