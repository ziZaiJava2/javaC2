package bank;

public class Person {
	private String id;
	private String name;
	private double cashNum;
	private Account myAccount = null;

	public Person(String id, String name, double cashNum) {

	}

	public Person() {
		
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
	
	void showMyMoney(){
		System.out.println(this.id + this.name + this.cashNum +this.myAccount);
	}
}
