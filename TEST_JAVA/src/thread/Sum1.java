package thread;

public class Sum1 extends Thread {
	private long sum;
	public long getsum() {
		return sum;
	}
	public void setsum(long sum) {
		this.sum=sum;
	}
	public void run() {
		for(int i=0; i<=100; i++) {
			sum+=i;
			}
	}
}
