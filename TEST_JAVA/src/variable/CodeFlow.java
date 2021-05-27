package variable;

class CodeFlow {

	public static void main(String[] args) {
		//if문
		int score = 61;
		
		if(score>=90) {
			System.out.println("A입니다.");
		}
		if(score>80 && score <90){
			System.out.println("B입니다.");
		}
		if(score>70 && score <80) {
			System.out.print("C입니다.");
		}else {
			System.out.print("F입니다.");
		}

	}

}
