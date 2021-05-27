package overriding;

public class overriding_test {

	public static void main(String[] args) {
		Student st = new Student();
		
		st.name ="김규호";
		st.age=26;
		st.job="솔루션개발자";
		
		st.print(); // student에 print() 메소드 호출.
	} 
}
