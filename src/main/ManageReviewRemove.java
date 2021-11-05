package main;

public class ManageReviewRemove // 리뷰 삭제
{
	public static boolean main() {
		boolean loop = true;

		while (loop) {
			menuManageReviewRemove(); // 리뷰 삭제 메뉴 출력

			System.out.print("리뷰 번호 입력 : ");
			int num = Main.inputUserNum(1, Main.reviewList.size());

			for (int i = 0; i < main.Main.reviewList.size(); i++) {
				if (main.Main.reviewList.get(i).getReviewNum() == num) {
					main.Main.reviewList.remove(i);
					return true;
				}
			}
		}
		return true;

	}

	private static void menuManageReviewRemove() // 리뷰 삭제 메뉴 출력
	{
		System.out.println();
		System.out.println("#####리뷰 삭제#####");
		System.out.println();
	}
}