package practice;
/**
 * 学生类
 * @author Administrator
 *
 */
public class Student {
	String name;
	private int Cre;
	private static String Local = "SH";
	//创造Student对象
	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public String toString() {
		return getName();
	}
	//判断是否为全日制学生
	public boolean iffullTime() {
		if (Cre >= 12) {
			return true;
		} else {
			return false;
		}
	}
	//获得学分
	public int getCredits() {
		return Cre;
	}
	//增加学分
	public int addCredits(int credits) {
		return Cre += credits;
	}
	//判断是否为本地学生
	public boolean isLocal() {
		if (Local.equals("SH")) {
			return true;
		} else {
			return false;
		}
	}
	//设置学生籍贯
	public void setLocation(String province) {
		Local = province;
	}

}
