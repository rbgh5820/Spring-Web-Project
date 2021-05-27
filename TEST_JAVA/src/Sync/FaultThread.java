package Sync;

public class FaultThread extends Thread {
	FaultThread1 ft;
	int i;
	public FaultThread(FaultThread1 ft,int i) {
		this.ft=ft;
		this.i = i;
	}
	public void run() {
		ft.increMethod(i);
	}
}
