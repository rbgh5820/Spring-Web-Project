package abstractHard;

public class square extends shape {

	@Override
	void draw() {
		System.out.println("사각형 그리기 : ");
	}

	@Override
	void computeArea(double h, double v) {
		System.out.println("사각형 넓이 : "+(h*v));
	}

}
