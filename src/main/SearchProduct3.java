package main;

public class SearchProduct3 {
	public static boolean main(int category1, int category2) {
		int searchCategory1=category1;
		int searchCategory2=category2;
		boolean loop=true;
		
		while(loop) {
			SearchProduct.showProductList(searchCategory1, searchCategory2);
			if(BuyProduct.gotoInput) 
				return false;
			menuSearchProduct3();
			System.out.print("선택: ");
			int sel = Main.inputUserNum(0, 3);
			Main.scan.nextLine();
			

			switch (sel) {
			case 0:
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
				loop = false;
				break;
			case 1:
				loop = SortProduct.main(1, searchCategory1, searchCategory2);
				break;
			case 2:
				loop = SortProduct.main(2, searchCategory1, searchCategory2);
				break;
			case 3:
				System.out.println("상품코드를 입력하세요. 형식: 00-000-0");
				String code = inputCode();
				loop = DetailProduct.main(code);
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
		
		System.out.println("─────────────────────────────────────────── +-+-+|M|E|N|U|+-+-+ ───────────────────────────────────────────");
		System.out.println("\t\t\t 1. 최저가순 \t\t\t\t 2. 최고가순");
		System.out.println();
		System.out.println("\t\t\t 3. 상세조회 ");
		System.out.println();
		System.out.println("\t\t\t 0. 뒤로가기");
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
		
//		System.out.println("───────────────── [ 메뉴 목록 ] ─────────────────");
//		System.out.println("0. 뒤로가기");
//		System.out.println("1. 최저가순");
//		System.out.println("2. 최고가순");
//		System.out.println("3. 상세조회");
//		System.out.println("──────────────────────────────────────────────────");
		
	}

	public static String inputCode() {
		while (true) {
			try {
				String code = Main.scan.nextLine();
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
}


/*


*/
