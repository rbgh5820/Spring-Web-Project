package array;

public class Array_hard {

	public static void main(String[] args) 
    {
        // 2차원배열 선언과 동시에 초기화
        int[][] ma = { { 99, 88, 77 }, 
        	       { 30, 40, 50 },
                       { 33, 12, 1}};
        int a, b;
        
        //행과 열을 출력하기위해 반복문 2
        for (a = 0; a < ma.length; a++) 
        {
            for (b = 0; b < ma[a].length; b++)
                System.out.print("  " + ma[a][b]);
            System.out.println();
        }
    }
}
