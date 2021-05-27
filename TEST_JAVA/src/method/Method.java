package method;

public class Method {
	public static int max(int a,int b,int c) { // void없는 max라는 메소드를 수행하기 위해 return값 필수
		if(a>b && a>c) {
			return a;
		} else if(b>c) {
			return b;
		}else {
			return c; // 출력값을 불러온다.
		}
	}
	public static void main(String[] args) { // void에서는 실행을 담당하기 때문에 메소드 return값이 필요없음
		int a = 30;
		int b = 25;
		int c = 35; // 정수형 변수값 지정
		System.out.println(max(a,b,c));
	}

}
