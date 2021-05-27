package array;

public class Array2 {

	public static void main(String[] args) {
		int [] score= {100,70,93,45,87};
		int sum=0;
		for(int i=0; i<score.length; i++) { // score.length = 5(0,1,2,3,4 배열은 무조건 0부터 시작)
			sum+=score[i];
		}
		double avg=(double)sum/score.length;
		System.out.println("합계: "+sum);
		System.out.println("평균: "+avg);
	}
}
