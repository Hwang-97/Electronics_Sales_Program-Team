package main;

public class ManageItemRemove // 관리자 - 상품 삭제
{
	public static boolean main() {
		boolean loop = true;

		while (loop) {

			main.SearchProduct.showProductList(); // 상품 목록 전체 출력

			menuManageItemEdit();

			System.out.print("번호 입력 : ");
			int num = Main.inputUserNum(0, 2);
			Main.scan.nextLine();

			switch (num) {
			case 0:
				return true;
			case 1:
				main.Main.productList.clear(); // 상품 리스트 내 전체 데이터 삭제
				break;
			case 2:
				System.out.print("상품 번호 입력 : ");
				int productNumber = Main.inputUserNum(0, Main.productList.size());
				Main.scan.nextLine();

				for (int i = 0; i < main.Main.productList.size(); i++) {
					if (main.Main.productList.get(i).getProductNum() == productNumber) // 입력한 상품 번호와 같은 값을 가지는 상품 데이터
																						// 리스트의 상품 번호 검색
					{
						main.Main.productList.remove(i);
						break;
					}
				}
				break;
			}
		}
		return true;
	}

	private static void menuManageItemEdit() // 상품 삭제 메뉴 출력
	{
		System.out.println();
		System.out.println("#####상품 삭제#####");
		System.out.println("0. 뒤로 가기");
		System.out.println("1. 전체 삭제");
		System.out.println("2. 개별 삭제");
		System.out.println();
	}
}