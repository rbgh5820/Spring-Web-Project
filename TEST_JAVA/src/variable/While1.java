package variable;

public class While1 {

	public static void main(String[] args) {
		int i = 1;
		int sum=0;
		
		while(i<=20) { // i가 20이하가 될때까지 무한반복 while문
			sum+=i; // 대입 연산
			i++; // 증감연산 i는 1씩증가
		}
		System.out.println("합 :"+sum);
		System.out.println("i 값 = "+i);
	}

}
