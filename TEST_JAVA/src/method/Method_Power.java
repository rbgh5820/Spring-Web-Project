package method;

import java.util.*;

public class Method_Power {
	public static int power(int a, int b) { // 메소드이름 : power a,b는 입력값 변수는 정수형
		if(b<=0) { // b가 0보다 작을경우라는 조건문
			return 1; // 1로 리턴값 불러오기
		}else {
			return a * power(a,b-1); //a를 b번 곱한다
		}
	}
    public static void main(String[] args) {
    	System.out.println("power(3,1) : "+power(3,1));
    	System.out.println("power(3,2) : "+power(3,2));
    	System.out.println("power(3,3) : "+power(3,3));
    	System.out.println("power(3,4) : "+power(3,4));
    	System.out.println("power(3,5) : "+power(3,5));
    	System.out.println("power(3,6) : "+power(3,6));
    }
}
