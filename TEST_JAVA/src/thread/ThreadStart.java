package thread;

public class ThreadStart {

	public static void main(String[] args) {
		ThreadTest t1 = new ThreadTest();
		ThreadTest t2 = new ThreadTest();
		
		t1.run();
		t2.run(); // t1이 0~15까지 숫자 실행되면 t2가 0~15까지 실행함
	}
}
