package main;

import java.io.BufferedReader;
import java.io.FileReader;

import createObject.Product;

public class DetailProduct {
	public static boolean main(String inputCode) {
		boolean canBuy = false;
		boolean loop = true;
		String detailInfo = "";

		int productNum = getProductNumtoCode(inputCode);
		String path = ".\\txtData\\product\\" + productNum + "-" + inputCode + ".txt";

		try {

			BufferedReader reader = new BufferedReader(new FileReader(path));

			String line = null;

			while ((line = reader.readLine()) != null) {

				detailInfo += line;

			}

			reader.close();
			canBuy = true;

		} catch (Exception e) {
			System.out.println("상품코드가 일치하는 정보가 없습니다.");
			canBuy = false;
		}

		while (loop) {
			if (BuyProduct.gotoInput)
				return false;
			if (canBuy) {

				menuItemDetail(); // 상품 상세조회 화면 출력

				for (int i = 0; i < Main.productList.size(); i++) {
					if (Main.productList.get(i).getProductCode().equals(inputCode)) {

						System.out.println("\t\t\t ++++++++++++++++++++++ 상품 기본정보 ++++++++++++++++++++++");
						System.out.println("\t\t\t상품 코드 : " + Main.productList.get(i).getProductCode());
						System.out.printf("\t\t\t상품명: %s\n", Main.productList.get(i).getProductName());
						System.out.printf("\t\t\t가격: %d\n", Main.productList.get(i).getProductPrice());
						System.out.println();
						System.out.println("\t\t\t ++++++++++++++++++++++ 상품 상세정보 ++++++++++++++++++++++");
						System.out.println(detailInfo);
						System.out.println(
								"───────────────────────────────────────────────────────────────────────────────────────────────────────────");
					}
				}

				menuDetailProduct();

				System.out.print("선택: ");
				int sel = Main.inputUserNum(0, 3);
				Main.scan.nextLine();

				System.out.println("\n\n\n\n\n\n\n\n\n\n");

				switch (sel) {
				case 0:
					loop = false;
					break;
				case 1: // 상품구매
					loop = BuyProduct.main(productNum, inputCode);
					break;
				case 2: // 장바구니 추가
					if (!Main.nowLogin) {
						System.out.println("로그인 후 가능합니다.");
						break;
					}
					loop = AddBasket.main(productNum, inputCode);
					break;
				case 3: // 상품문의
					if (!Main.nowLogin) {
						System.out.println("로그인 후 가능합니다.");
						break;
					}
					loop = QueryProduct.main(productNum, inputCode);
					break;
				}
			} else
				return true;
		}
		return true;
	}

	private static int getProductNumtoCode(String inputCode) {
//		Main.productList
		int num;
		for (Product p : Main.productList) {
			if (inputCode.equals(p.getProductCode())) {
				num = p.getProductNum();
				return num;
			}
		}
		return -1;
	}

	private static void menuDetailProduct() {

		System.out.println(
				"─────────────────────────────────────────── +-+-+|M|E|N|U|+-+-+ ───────────────────────────────────────────");
		System.out.println("\t\t\t 1. 상품구매 \t\t\t\t 2. 장바구니 추가");
		System.out.println();
		System.out.println("\t\t\t 3. 상품 문의");
		System.out.println();
		System.out.println("\t\t\t 0. 뒤로가기");
		System.out.println(
				"───────────────────────────────────────────────────────────────────────────────────────────────────────────");

//		System.out.println("───────────────── [ 메뉴 목록 ] ─────────────────");
//		System.out.println("0. 뒤로가기");
//		System.out.println("1. 상품구매");
//		System.out.println("2. 장바구니 추가");
//		System.out.println("3. 상품 문의");
//		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");

	}

	private static void menuItemDetail() // 상품 상세조회 화면 출력
	{
		System.out.println(
				"──────────────────────────────────────────────── [상품 정보] ────────────────────────────────────────────────");
		System.out.println();

	}
}
