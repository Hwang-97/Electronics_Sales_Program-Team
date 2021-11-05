package main;

public class ManageItemSearch // 관리자 - 상품 검색
{
	public static boolean main() {

		boolean loop = true;

		while (loop) {
			menuManageItemSearch(); // 상품 검색 메뉴 출력

			System.out.print("번호 입력 : ");
			int num = Main.inputUserNum(0, 3);
			Main.scan.nextLine();

			switch (num) {
			case 0:
				return true;
			case 1:
				loop=ManageItemEdit.main(); // 상품 수정 메뉴로
				break;
			case 2:
				loop=ManageItemRemove.main(); // 상품 삭제 메뉴로
				break;
			case 3:
				loop=ManageReview.main(); // 리뷰 관리 메뉴로
				break;
			}
		}
		return true;

	}

	private static void menuManageItemSearch() // 상품 검색 메뉴 출력
	{
		System.out.println();
		System.out.println("#####상품 검색 메뉴#####");
		System.out.println("0. 뒤로 가기");
		System.out.println("1. 상품 수정");
		System.out.println("2. 상품 삭제");
		System.out.println("3. 리뷰 관리");
		System.out.println();
	}
}