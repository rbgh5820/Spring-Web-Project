package overload;

public class Overload {
	// test() 호출
	void test() {
		System.out.println("변수X");
	}
	void test(int a, int b) { // 매개변수 int 형 2개 호출
		System.out.println("매개변수 "+a+"와 "+b);
}
}