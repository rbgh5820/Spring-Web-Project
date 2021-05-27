package inheritance;

public class Employee {
	String name;
	int salary;
	
	public Employee(String n, int s) { // 생성자
		name = n;
		salary = s; // 이름과 월급 저장
	}
	public void getInfomation() {
		System.out.println("이름: "+name+" ,월급: " +salary);
	}

}
