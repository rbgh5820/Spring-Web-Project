package abstractHard;

public class Angle extends shape {

	@Override
	void draw() {
		System.out.println("삼각형 그리기 : ");
		
	}

	@Override
	void computeArea(double a, double h) {
		System.out.println("삼각형 넓이 : "+(a*h/2));
		
	}

}
