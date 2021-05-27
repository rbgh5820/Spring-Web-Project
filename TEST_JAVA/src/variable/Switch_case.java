package variable;

public class Switch_case {

	public static void main(String[] args) {
		
		int score = 70;
		
		switch(score/10) {
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break; // 조건이 만족할시 아래 조건 출력방지 break가 걸린다
		case 6:
			System.out.println("D학점");
			break;
		default:
			System.out.println("F학점 재시험");
			break;
	}

}
}