package overload;

public class OverloadTest {

	public static void main(String[] args) {
		Overload ob = new Overload(); // ob라는 객체를 생성
		ob.test(); //test() 메소드를 호출함
		ob.test(100,200); // test(int a, int b)를 호출함
	}
}
