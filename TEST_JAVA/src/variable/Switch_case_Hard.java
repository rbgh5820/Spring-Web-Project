package variable;

import java.util.Scanner;

public class Switch_case_Hard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("점수를 입력하세요");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		
		String grade ="";
		switch(i/10){ // 점수를 10으로 나눈 값 판별
			case 10:
			case 9:
				grade="A";
				break; // break 문으로 종료
			case 8:
				grade="B";
				break;
			case 7:
				grade="C";
				break;
			case 6:
				grade="D";
				break;
			default :
				grade="F";
				break;
		}
		System.out.println("당신의 학점은"+grade+"학점 입니다.");
	}

}
