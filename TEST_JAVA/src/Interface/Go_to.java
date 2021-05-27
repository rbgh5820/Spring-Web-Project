package Interface;

public class Go_to implements go,where,BYE { // 한 클래스에 다수의 인터페이스를 구현이 가능하다

	public static void main(String[] args) {
		Go_to go = new Go_to();
		go.go();
		go.where();
		go.BYE();
	}

	@Override
	public void BYE() {
		System.out.println("그럼 다음에 놀자"); // BYE 인터페이스에 메소드를 오버라이드
	}

	@Override
	public void where() {
		System.out.println("ㄴㄴ 출근해야함."); // where 인터페이스에 메소드를 오버라이드
	}

	@Override
	public void go() {
		System.out.println("내일 시간되니?"); // go 인터페이스에 메소드를 오버라이드
	}
}
