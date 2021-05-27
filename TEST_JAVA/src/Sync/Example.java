package Sync;

public class Example {

	public static void main(String[] args) {
		FaultThread1 ft = new FaultThread1();
		
		FaultThread ft1 = new FaultThread(ft,3);
		FaultThread ft2 = new FaultThread(ft,7);
		
		ft1.start();
		ft2.start();
	}

}
