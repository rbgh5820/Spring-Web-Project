package overriding;

public class Student extends people { // people 클래스에 상속함
	String job;
	
	public void print() { // people에 있는 print()을 오버라이딩
		System.out.println("이름은 "+this.name+"이고, 나이는"+this.age+"입니다.");
		System.out.println(this.name+"은 "+this.job+" 입니다.");
	}
}
