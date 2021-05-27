package variable;

public class elseif_HARD {
	public static void main(String[] args) {
		int a = 40, b = 30 , c = 25, d=50;
		int num; // int형 변수 num 선언
		
		if(a<b && a<c && a<d) {      //조건식1
			num = a;
			
		}else if(b<c && b<d) { //조건식2
			num = b;
			
		}else if(c<d) { // 조건식 3
			num = c;
			
		}else { // 조건식1,2,3이 모두 false일 경우 연산
			num = d;
		}
		System.out.print(num);
	}
}
