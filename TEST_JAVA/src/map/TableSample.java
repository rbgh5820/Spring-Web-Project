package map;

import java.util.*;

public class TableSample {

	public static void main(String[] args) {
		Hashtable<String,Double> WT = new Hashtable<String, Double>(); // hashtable에서 몸무게 변형값 생성
		
		WT.put("김칰타",80.7); // 몸무게 값 입력하는 문구
		WT.put("김규호",83.4);
		WT.put("이호구",90.6);
		WT.put("박표주",56.9);
		WT.put("최 뱀",77.7); // double과 String은 null값 허용 X
		
		System.out.println(WT); // WT의 값을 모두 출력해준다.
		
		Scanner input=new Scanner(System.in); // 스캔하는 객체를 생성한다
		System.out.print("이름을 입력해 주세요. :");
		String key = input.nextLine();
		
		
		double weight = WT.get(key);
		System.out.println(key+"의 몸무게 : "+weight);
		
		System.out.println("\n이름\t몸무게"); 
		System.out.println("=================");
		
		Set<String> set = WT.keySet(); 
		for(String item : set) {
			weight = WT.get(item);
			System.out.println(item+" \t"+weight);
		}
	}
}
