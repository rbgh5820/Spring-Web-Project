package multithread;

public class MultiTest {

	public static void main(String[] args) {
		Multi1 Multi1 = new Multi1(); // multi1 객체생성
		Multi2 Multi2 = new Multi2(); // multi2 객체생성
		
		Multi1.start();
		Multi2.start();
		
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {}
		Multi1.work = false; // 각 스레드를 예외처리한다
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {}
		Multi1.work = true; // 마찬가지로 예외처리
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {}
		Multi1.stop = true;
		Multi2.stop=true;
	}
}
