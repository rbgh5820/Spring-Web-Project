package Sync;

public class FaultThread1 {
	public synchronized void increMethod(int i) {
		for(int j=0; j<=5; j++) {
			System.out.println(j*i); // j,i출력
		} try {
			FaultThread.sleep(1000);
		}catch(Exception e) {
		}
	}
}
