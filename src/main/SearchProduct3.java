package main;

public class SearchProduct3 {
	public static boolean main(int category1, int category2) {
		
		int searchCategory1=category1;
		int searchCategory2=category2;
		boolean loop=true;
		
		SearchProduct.showProductList(searchCategory1, searchCategory2);
		while(loop) {
			
			menuSearchProduct3();
			System.out.print("선택: ");
			int sel = Main.inputUserNum(0, 4);
			Main.scan.nextLine();
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n");

			switch (sel) {
			case 0:
				loop = false;
				break;
			case 1:
				loop = SortProduct.main(1, searchCategory1, searchCategory2);
				break;
			case 2:
				loop = SortProduct.main(2, searchCategory1, searchCategory2);
				break;
			case 3:
				loop = SortProduct.main(3, searchCategory1, searchCategory2);
				break;
			case 4:
				loop = ProductDetails.main();
				break;
			}
//			//
//			System.out.println("상품코드를 입력하세요. (00-000-0)");
//			System.out.print("입력 > ");
//			String code = inputCode();
//			showProductDetail(code);
			
		}
		
		return true;
	}
	
	private static void menuSearchProduct3() {
		System.out.println("───────────────── [ 메뉴 목록 ] ─────────────────");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 최저가순");
		System.out.println("2. 최고가순");
		System.out.println("3. test");
		System.out.println("4. 상세조회");
		System.out.println("──────────────────────────────────────────────────");
		
	}

	public static String inputCode() {
		while (true) {
			try {
				String code = Main.scan.nextLine();
				System.out.println(code);
				System.out.println(code.charAt(2));
				System.out.println(code.charAt(6));
				System.out.println(code.length());
				if (code.charAt(2) == '-' && code.charAt(6) == '-' && code.length() == 8) {
					return code;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("형식에 맞게 입력하세요. (00-000-0)");
				System.out.print("입력 > ");
			}
		}
	}
	
	private static void showProductDetail(String code) {
		System.out.println("─────────────────── [ 상세정보 ] ───────────────────");

		System.out.printf("상품번호 %s에 대한 상세정보 입니다.\n", code);

	}
}


/*


*/
