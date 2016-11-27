package bank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Bank {
	// Person person = new Person();
	public static Map<String, Account> map = new HashMap<String, Account>();

	/**
	 * 注册账户方法， 参数为一个人的对象 方法要做的事情是： 生成一个新的 银行账户对象， 把Person对象的id设为， 账户对象的账户号，
	 * 账户对象的初始金额设为0； 然后把Person对象中的myAccount 赋值为新生成的Account对象。 然后把Account对象保存在
	 * 成员变量accountMap中。 方法返回值为 新创建的Account 对象
	 */
	public Account register(Person person) {
		Account acc = new Account(person.getId(), 0);
		acc = person.getMyAccount();
		map.put(person.getId(), acc);
		return acc;
	}

	/**
	 * 存钱方法， 第一个参数是 一个人的对象， 表示要往这个人的账户中存钱， 第二个参数 moneyNum。 表示要存钱的金额。
	 * 方法要做的事情是:首先要判断 Person对象中是存在银行账户， 如果不存在 打印 “请先注册银行账户”, 返回false 如果有账户的的话
	 * 先对比 Person对象的cashNum 是否大于等于要存钱的金额。 Person现金不足的话要打印“现金不足”， 返回false。 现金足够的话
	 * 通过Person的id 在银行的accountMap 中找到这个人对应的 银行账户， 然后把设置账户中新的存款金额。
	 * 还要把Person对象中cashNum 减去相应的金额， 返回true；
	 */
	boolean saveMoney(Person person, double moneyNum) {
		if (!map.containsKey(person.getId())) {
			System.out.println("请先注册银行账户");
			return false;
		}
		if (moneyNum >= person.getCashNum()) {
			System.out.println("现金不足");
			return false;
		}
		Set set = map.keySet();
		for (Iterator i = set.iterator(); i.hasNext();) {
			String s = (String) i.next();
			if(person.equals(s)){
		Account	uses = map.get(s).setMoneyInAccount(moneyNum);;
			}
			person.setCashNum(cashNum - moneyNum);
		}
		
	}
}
