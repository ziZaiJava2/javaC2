package bank;

public class BankTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person a = new Person("aa","11",10000);
		Person b = new Person("bb","22",500000);
		Person c = new Person("cc","33",800000);
		Bank bank = new Bank();
		bank.register(a);
		bank.register(b);
		bank.register(c);
		bank.saveMoney(a,50000);
		bank.saveMoney(b,100000);
		bank.saveMoney(c,500000);
		a.showMyMoney();
		b.showMyMoney();
		c.showMyMoney();
	}

}
