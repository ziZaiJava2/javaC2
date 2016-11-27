package Account;

public class Person {
	private String id;
	private String name;
	private double cashNum;
	private Account myAccount = null;

	/*
	 * Account myAccount 自己的存款账户， 开始为null。 后面需要去调用Bank的 register方法去获取一个账户。
	 */
	public Person(String id, String name, double cashUnm) {
		this.id = id;
		this.name = name;
		this.cashNum = cashUnm;

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

	public Account getMyAccount() {

		return myAccount;
	}

	public void setMyAccount(Account account) {
		this.myAccount = account;

	}

	public void setCashNum(double cashNum) {
		this.cashNum = cashNum;
	}

	public void showMyMoney() {
		System.out.println("身份证号：" + this.id + "  姓名：" + this.name + "  个人身上现金余额：" + this.cashNum + "  存款金额："
				+ this.myAccount.getMoneyInAccount());
	}

}
