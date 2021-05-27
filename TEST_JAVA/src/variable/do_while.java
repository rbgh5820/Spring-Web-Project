package variable;

public class do_while {

	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		
		do {
			sum+=i;
			i++;
		}while(i<=20);
		System.out.println("합계 : "+sum);
		System.out.println("i 값 : "+i);
	}

}
