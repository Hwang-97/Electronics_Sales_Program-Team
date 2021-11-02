package main;


public class SearchProduct2 {
	public static boolean main(int category1) {
		
		boolean loop=true;
		int searchCategory1 = category1; 	// 사용자가 고른 카테고리1
		int searchCategory2 = -1; 			// 사용자가 고른 카테고리2
		
		while (loop) {
			SearchProduct.menuCategoryList(createObject.ProductList.CName2); // 카테고리2 메뉴 출력

			searchCategory2 = SearchProduct.inputCategoryNum();
			Main.scan.nextLine();
			System.out.println("\n\n\n\n\n\n\n\n\n\n");

			switch (searchCategory2) {
			case 0:
				return true;
			default:
				SearchProduct3.main(searchCategory1, searchCategory2);

			}
		}
		return true;
	}
}
