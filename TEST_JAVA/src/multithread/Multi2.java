package multithread;

public class Multi2 extends Thread {
	public boolean stop=false; // stop 초기화를 false로
	public boolean work=true; // work초기화를 true로
	
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println("Multi2 작업내용"); // 작동하면 Multi2 작업내용 띄우기
			}else {
				Thread.yield(); // 다른 스레드에게 양보
			}
		}
		System.out.println("Multi2 종료");
	}
}
