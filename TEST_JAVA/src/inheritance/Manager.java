package inheritance;

public class Manager extends Employee{ // manager라는 자식 클래스가 Employee라는 부모 클래스를 상속
	String department;
	public Manager(String n,int s,String d) { // 생성자
		super(n,s); // employee 클래스 생성자에게 이름과 월급을 전달
		department = d; // 부서 변수값 저장
	}
	public void getInformation() {
		System.out.println("이름: "+name+" ,월급: "+salary+" ,부서: "+department); // Employee에 있는 변수 값 name,과 salary를 사용
	}
}
