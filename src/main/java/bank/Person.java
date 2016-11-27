package bank;

public class Person {
	private String id;
	private String name;
	private double cashNum;
	private Account myAccount = null;

	public Person(String id, String name, double cashNum) {
		this.id = id;
		this.name = name;
		this.cashNum = cashNum;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCashNum() {
		return cashNum;
	}

	public void setCashNum(double cashNum) {
		this.cashNum = cashNum;
	}

	public Account getMyAccount() {
		return myAccount;
	}

	public void setMyAccount(Account myAccount) {
		this.myAccount = myAccount;
	}

	public void showMyMoney() {
		System.out.println("账户号:" +this.id + "   身份证号:" + this.name + "   个人身上的现金数量:" + this.cashNum + "   存款金额:" + this.myAccount.getMoneyInAccount());
	}
}
