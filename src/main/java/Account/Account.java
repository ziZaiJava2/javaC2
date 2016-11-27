package Account;

public class Account {
	/*
	 * 定义成员变量
	 */
	private String accountId;
	private double moneyInAccount;

	/*
	 * 定义一个两个参数的构造方法， 参数分别为 accountId, moneyInAccount
	 */
	public Account(String accountId, double moneyInAccuont) {
		this.accountId = accountId;
		this.moneyInAccount = moneyInAccount;
	}

	/*
	 * 获取账户号码
	 */
	public String getAccountId() {
		return accountId;

	}

	/*
	 * 给账户设置一个账号
	 */
	public void setAconutId(String accountId) {
		this.accountId = accountId;

	}

	/*
	 * 获取账户内存款金额
	 */
	public double getMoneyInAccount() {
		return moneyInAccount;

	}

	/*
	 * 设置存款金额
	 */
	public void setMoneyInAccount(double cashNum) {
		this.moneyInAccount += cashNum;

	}

}
