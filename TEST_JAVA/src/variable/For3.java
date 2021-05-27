package variable;

public class For3 {

	public static void main(String[] args) {
		
		int i;
		int j;
		for(i=0;i<10;i++){
			for(j=0;j<10-i;j++){
				System.out.print(" "); 
			}
			for(j=0;j<2*i+1;j++){
				System.out.print("*"); 
			}
			System.out.println("");
		}
	}
}