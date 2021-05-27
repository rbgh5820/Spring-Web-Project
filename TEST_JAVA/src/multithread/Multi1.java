package multithread;

public class Multi1 extends Thread {
	public boolean stop=false; // stop 초기화를 false로
	public boolean work=true; // work초기화를 true로
	
	public void run() {
		while(!stop) { //반복문
			if(work) { //조건문
				System.out.println("Multi1 작업내용");
			}else {
				Thread.yield();
			}
		}
		System.out.println("Multi1 종료");
	}
}
