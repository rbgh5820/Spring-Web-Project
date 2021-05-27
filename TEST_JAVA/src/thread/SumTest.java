package thread;

public class SumTest {

	public static void main(String[] args) {
		Sum1 sum1 = new Sum1();
		sum1.start();
		try {
			sum1.join();
		}catch(InterruptedException e) {
			
		}
		 System.out.println("1부터 100까지 합 : "+sum1.getsum());
	}

}
