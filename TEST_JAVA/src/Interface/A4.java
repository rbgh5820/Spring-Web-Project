package Interface;

public class A4 implements Hello {
	
	public void print() { // 인터페이스에 있는 void print() 메소드 오버라이드
		System.out.println("HELLO, :)");
	}

	public static void main(String[] args) {
		A4 a4 = new A4();
		a4.print();
	}
	
}
