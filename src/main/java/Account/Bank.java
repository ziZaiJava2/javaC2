package Account;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	/*
	 * Map accountMap: 用来保存个人的账户。 key是 Person的id， 类似于身份证号， value是 账户信息对象
	 */
	private static Map<String, Account> accountMap = new HashMap<String, Account>();

	/*
	 * Account register(Person person) 注册账户方法， 参数为一个人的对象 方法要做的事情是： 生成一个新的
	 * 银行账户对象， 把Person对象的id设为，账户对象的账户号， 账户对象的初始金额设为0； 然后把Person对象中的myAccount
	 * 赋值为新生成的Account对象。 然后把Account对象保存在 成员变量accountMap中。 方法返回值为 新创建的Account 对象
	 */
	public Account register(Person person) {
		Account account = new Account(person.getId(), 0);
		person.setMyAccount(account);
		accountMap.put(person.getId(), account);
		return account;

	}

	/*
	 * boolean saveMoney(Person person, double moneyNum) 存钱方法， 第一个参数是 一个人的对象，
	 * 表示要往这个人的账户中存钱， 第二个参数 moneyNum。 表示要存钱的金额。 方法要做的事情是:首先要判断 Person对象中是存在银行账户，
	 * 如果不存在 打印 “请先注册银行账户”, 返回false 如果有账户的的话 先对比 Person对象的cashNum 是否大于等于要存钱的金额。
	 * Person现金不足的话要打印“现金不足”， 返回false。 现金足够的话 通过Person的id 在银行的accountMap
	 * 中找到这个人对应的 银行账户， 然后把设置账户中新的存款金额。 还要把Person对象中cashNum 减去相应的金额， 返回true；
	 */
	public boolean saveMoney(Person person, double moneyNum) {
		if (person.getMyAccount() == null) {
			System.out.println("请注册银行账户");
			return false;
		}

		else if (moneyNum >= person.getCashNum()) {
			System.out.println("现金不足");
			return false;
		} else {
			accountMap.get(person.getId()).setMoneyInAccount(moneyNum);
			person.setCashNum(person.getCashNum() - moneyNum);
			return true;
		}

	}
}
