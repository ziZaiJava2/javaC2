package bank;

public class Account {
	private String accountId;
	private double moneyInAccount;

	public Account(String accountId, double moneyInAccount) {
		this.accountId = accountId;
		this.moneyInAccount = moneyInAccount;
	}

	/** 获取账户号码 */
	public String getAccountId() {
		return this.accountId;
	}

	/** 给账户设置一个账号 */
	public void setAccountId(String AccountId) {
		this.accountId = AccountId;
	}

	/** 获取账户内存款金额 */
	public double getMoneyInAccount() {
		return moneyInAccount;
	}

	/** 设置存款金额 */
	public void setMoneyInAccount(double moneyInAccount) {
		this.moneyInAccount += moneyInAccount;
	}

}
