package bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	Person person = new Person();
	public static Map<String,Person> map =new HashMap<String,Person>();
	map.put(Person.id,person);
}
