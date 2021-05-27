package Interface_inher;

public class Testable implements test3 {

	public static void main(String[] args) {
		Testable test= new Testable();
		
		test.test1();
		test.test2();
		test.test3();

	}
	@Override
	public void test1() {
		System.out.println("test3에 상속 되었습니다.");
	}

	@Override
	public void test2() {
		System.out.println("test3에 상속 되었습니다.");
	}

	@Override
	public void test3() {
		System.out.println("test1,2를 상속했습니다.");
	}

}
