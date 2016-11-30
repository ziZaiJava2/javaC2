package Practice;

public class Student {
	static final String LOCAL = "SH";
	private String name;
	private int credits = 0;
	private String province;
	public double average = 0;
	int count = 0;

	public Student(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	/**
	 * 添加一个新的方法isFullTime()到Student类， 该方法返回一个布尔值，用来判断学生是否是全日制的学生。
	 * 现在先给他返回默认值false。
	 */
	public boolean isFullTime() {
		return credits >= 12;
	}

	/** 我们添加一个getCredits()方法，获取学生的学分，返回一个int类型 */
	public int getCredits() {
		return credits;

	}

	/**
	 * 添加一个方法addCredits(int credits),用来给学生添加学分
	 * 
	 * @return
	 */
	public void addCredits(int credits) {
		this.credits += credits;
	}

	public boolean isLocal() {
		return LOCAL.equals(province);
	}

	/** 添加新方法SetLocation(String Province),用来设置学生的籍贯 */
	public void setLocation(String province) {
		this.province = province;
	}
	
	/**新增一个方法，double getGPA();
	 * ,返回学生的平均成绩，默认返回0，
	 * 因为我们现在还没有添加任何成绩*/
	public double getGPA(){		
		return average / count;
	}
	
	/**新增一个方法，void addGrade(String grade);
	 * ，用来添加成绩。合法的成绩有"A"(4分), "B"(3分), 
	 * "C"(2分), "D"(1分), "F"(0分)*/
	public void addGrade(String grade){
		double answer = 0;
		
		switch(grade){
		case "A":
			answer = 4;
		break;
		case "B":
			answer = 3;
			break;
		case "C":
			answer = 2;
			break;
		case "D":
			answer = 1;
			break;

		}
		average = answer + average;
		count++; 
	}
	
	public enum Grade{
		A,B,C,D,F
	}
}
