package variable;

public class For1 {

	public static void main(String[] args) {
		int i;
		int j;
		for(i=0; i<=10; i++) { // i=0,i는 10이하가 될때까지 1씩증가
			for(j=9; j>=i; j--) { // j=9, i이하가 될때까지 1씩감소
				System.out.print("@");
			}
			System.out.println();
			}
		}
	}
