package practice;

/**
 * ѧ����
 * 
 * @author Administrator
 *
 */
public class Student {
	String name;
	private int Cre;
	private static String LOCAL = "SH";

	// ����Student����
	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return getName();
	}

	// �ж��Ƿ�Ϊȫ����ѧ��
	public boolean iffullTime() {
		return Cre >= 12;
	}

	// ���ѧ��
	public int getCredits() {
		return Cre;
	}

	// ����ѧ��
	public int addCredits(int credits) {
		return Cre += credits;
	}

	// �ж��Ƿ�Ϊ����ѧ��
	public boolean isLocal() {
		return "SH".equals(LOCAL);
	}

	// ����ѧ������
	public void setLocation(String province) {
		LOCAL = province;
	}

}
