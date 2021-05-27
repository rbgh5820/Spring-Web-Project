package abstractHard;

public class Circle extends shape {

	@Override
	void draw() {
		System.out.println("원 그리기 : "); // shape 추상클래스를 상속하여 메소드 선언
		
	}

	@Override
	void computeArea(double r1, double r2) {
		System.out.println("원의 넓이 : "+(3.14*r1*r2)); // 7번째줄이랑 마찬가지 
	}

}
