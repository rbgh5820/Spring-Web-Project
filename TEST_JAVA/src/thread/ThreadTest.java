package thread;

public class ThreadTest extends Thread {
	public void run() {
	 // 예외처리 하는 곳
		try {
			for(int i=0; i<=15; i++) { 
				Thread.sleep(1000); //1초 동안 대기
				System.out.println("Thread : "+i+"초");
			}
		}catch(InterruptedException e) {
			System.out.println(e);
		}
	}
}
