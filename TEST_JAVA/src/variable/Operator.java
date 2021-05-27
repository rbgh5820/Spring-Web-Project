package variable;

public class Operator {

	public static void main(String[] args) {
		// 산술 연산
		int num1 = 10;
		int num2 = 200;
		int num3 = 1000; 
		
		System.out.println("연산자의 합계 : "+(num1+num2)); //num1과 num3의 값을 합친다
		System.out.println("연산자의 차 : "+(num3-num1)); // num1과 num3의 값을 뺀다 
		System.out.println("연산자의 곱 : "+(num3*num1)); // num1과 num3의 값을 곱한다 사칙연산
		
		
		//대입 연산자 : 변수의 값을 대입할때 쓰는 연산자
		int a = 10;
		int b = 20;
		
		System.out.println(a+=b);
		System.out.println(a-=b); // 이미 20번째 줄에서 a=30이라는 변수가 입력됐기때문에 a-=b =>30-20 = 10
		System.out.println(a*=b);
		System.out.println(a/=b);
		
		
     
        boolean A = true;
        boolean B = false;
        boolean C = true;

        boolean d = A & B;
        boolean e = A | B;
        boolean f = !A;
        boolean g = C & A; // 논리연산자
		
        System.out.println("d="+d);
        System.out.println("e="+e);
        System.out.println("f="+f);
        System.out.println("g="+g);
	}

}
