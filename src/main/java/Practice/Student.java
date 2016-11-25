package Practice;

public class Student {
	static String  StudentLocal = "SH";
	private String name;
	int credits = 0;

	public void setName(String name) {
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
		if (credits == 12) {
			return true;
		} else {
			return false;
		}

	}

	/** 我们添加一个getCredits()方法，获取学生的学分，返回一个int类型 */
	public int getCredits() {
		return this.credits;

	}

	/**
	 * 添加一个方法addCredits(int credits),用来给学生添加学分
	 * 
	 * @return
	 */
	public void addCredits(int credits) {
		 this.credits = credits;
	}

	public boolean isLocal(){
		return false;
	}
	
	/**添加新方法SetLocation(String Province),用来设置学生的籍贯*/
	public void SetLocation(String Province){
		if()
	}

}
