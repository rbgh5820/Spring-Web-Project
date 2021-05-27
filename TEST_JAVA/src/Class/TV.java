package Class;

public class TV {

		boolean power;
		int channel; // 6~8줄은 속성(변수 선언)
		
		void power() {
			power = !power;
		}
		void channelUp() {
			++channel; // 채널up 메소드 실행시 +1씩 올라가는 함수
		}
		void channelDown() {
			--channel; // 채널down 메소드 실행시 1씩 내려가는 함수
		}
}
