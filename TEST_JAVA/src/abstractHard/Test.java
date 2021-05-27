package abstractHard;

public class Test {

	public static void main(String[] args) {
		Circle c = new Circle();
		c.draw();
		c.computeArea(5.0, 5.0); // shape 클래스에 있는 같은 이름의 메소드를 사용

		Angle A = new Angle(); // Angle 메소드 생성
		A.draw();
		A.computeArea(5.2, 8.2);
		
		square s = new square();
		s.draw();
		s.computeArea(10.3,20.5); // double a , b 값을 각각 대입
	}

}
