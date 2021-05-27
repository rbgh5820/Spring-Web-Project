package variable;

public class elseif {
	public static void main(String[] args) {
		int age = 31;
		if(age>=20 && age<30){	// 조건식 1
			// 조건식 1이 true일 때 실행
			System.out.println("20대");
		}else if(age>10&&age<20){	// 조건식 2
			// 조건식 1이 false이면서 조건식 2가 true일 때 실행
			System.out.println("10대");
		}else{
			// 조건식 1과 2가 false일 때 실행
			System.out.println("30대 이상");
		}
	}
}