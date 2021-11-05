package main;

public class ManageItemEdit // 관리자 - 상품 수정
{
	public static boolean main() {

		boolean loop = true;

		while (loop) {

			main.SearchProduct.showProductList(); // 상품 목록 전체 출력

			menuManageItemEdit(); // 상품 수정 메뉴 출력

			System.out.print("번호 입력 : ");
			int num = Main.inputUserNum(0, 1);
			Main.scan.nextLine();

			switch (num) {
			case 0:
				return true;
			case 1: // 재고 수정
				System.out.print("상품 번호 입력 : ");
				int productNumber = Main.inputUserNum(0, Main.productList.size());
				Main.scan.nextLine();

				for (int i = 0; i < main.Main.productList.size(); i++) {
					if (main.Main.productList.get(i).getProductNum() == productNumber) // 입력한 상품 번호와 같은 값을 가지는 상품
																						// 데이터 리스트의 상품 번호 검색
					{
						System.out.println("현재 상품 재고 : " + main.Main.productList.get(i).getProductStock());
						System.out.print("변경할 재고량 입력 : ");
						int newStock = Main.scan.nextInt();
						Main.scan.nextLine();
						main.Main.productList.get(i).setProductStock(newStock);
						System.out.println("변경된 상품 재고 : " + main.Main.productList.get(i).getProductStock());
						break;
					}
				}
				return true;
			}
		}
		return true;
	}

	private static void menuManageItemEdit() // 상품 수정 메뉴 출력
	{
		System.out.println();
		System.out.println("#####상품 수정#####");
		System.out.println("0. 뒤로 가기");
		System.out.println("1. 재고 수정");
		System.out.println();
	}
}