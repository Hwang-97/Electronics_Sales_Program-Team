package main;

import java.util.Scanner;

public class ManageQueryAnswer // 문의 답변
{
	public static boolean main() {
		boolean loop = true;
		while (loop) {
			menuManageQueryAnswer(); // 답변 메뉴 출력

			System.out.print("문의 번호 입력 : ");

			int num = Main.inputUserNum(1, Main.reviewList.size());
			Main.scan.nextLine();
			String temp;

			for (int i = 0; i < main.Main.reviewList.size(); i++) {
				if (main.Main.reviewList.get(i).getReviewNum() == num) {
					System.out.print("답변 입력 : ");
					temp = Main.scan.nextLine();
					main.Main.queryList.get(i).setAnswerContent(temp);
					return true;
				}
			}
		}
		return true;
	}

	private static void menuManageQueryAnswer() // 답변 메뉴 출력
	{
		System.out.println();
		System.out.println();
		System.out.println("─────────────────────────────────────────── +-+-+|답|변|작|성|+-+-+ ───────────────────────────────────────────");
		System.out.println();
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
		
//		System.out.println("#####답변 작성#####");
//		System.out.println();
	}
}