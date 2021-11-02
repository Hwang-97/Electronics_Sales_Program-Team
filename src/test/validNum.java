package test;

public class validNum {
	public static int inputUserNum(int startNum, int endNum) {

		
		// 메인
		// 사용자에게 메인 메뉴에서 입력값을 받음 (범위: startNum ~ endNum)
		// startNum: 메뉴의 첫 번호
		// endNum: 메뉴의 마지막 번호

		while (true) {
			try {
				int input = main.Main.scan.nextInt();
				if (input >= startNum && input <= endNum) {
					return input;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("다시 입력하세요.\n");
				System.out.print("선택: ");
				main.Main.scan.nextLine();
			}
		}

	}// inputSwitchNum()
}
