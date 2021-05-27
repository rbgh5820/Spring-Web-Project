package abstractTest;

public class FinalTest {

	public static void main(String[] args) {
		
		AbstractTest[] asc = new AbstractTest[3];
		// 추상 클래스에서의 객체를 생성하고 extendsClass에 있는 show 함수값을 배열로 출력했다.
		asc[0] = new extendsClass();
		asc[0].show();
		asc[1] = new extendsClass();
		asc[1].show();
		asc[2] = new extendsClass();
		asc[2].show();
	}

}
