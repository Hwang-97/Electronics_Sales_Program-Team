package main;

public class AdminProduct {
	
	public static boolean AdminProduct() {
		return true;
	}

	public static void main() {
		
		
		boolean loop = true;

		while (loop) {
			printMain();
			menuMain();

			System.out.print("선택: ");
			int sel = Main.inputUserNum(0, 4);
			Main.scan.nextLine();
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n");

			switch (sel) {
			case 0: //종료
				loop = false;
				break;
			case 1: //상품추가
				loop = AddProduct.main();
				break;
			case 2: //상품검색
//				loop = register.main();
				break;
			case 3: //전체상품검색
//				loop = searchProduct.main();
				break;
			case 4: //문의관리
//				loop = searchDelivery.main();
				break;
			}
		}
	}
	
	private static void menuMain() {
		
		// 메인
		// 메뉴출력
		// 상품추가 , 상품검색 , 전체상품검색 , 문의관리
		
		System.out.println("───────────────── [ 메뉴 목록 ] ─────────────────");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 상품 추가");
		System.out.println("2. 상품 검색");
		System.out.println("3. 전체상품 검색");
		System.out.println("4. 문의 관리");
		System.out.println("──────────────────────────────────────────────────");
	}

	private static void printMain() {

		// 메인
		// 화면출력
		String s= "     _    ____  __  __ ___ _   _ \r\n"
				+ "    / \\  |  _ \\|  \\/  |_ _| \\ | |\r\n"
				+ "   / _ \\ | | | | |\\/| || ||  \\| |\r\n"
				+ "  / ___ \\| |_| | |  | || || |\\  |\r\n"
				+ " /_/   \\_\\____/|_|  |_|___|_| \\_|\r\n"
				+ "                                 ";
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		System.out.println(s);
		System.out.println("───────────────── [ 상품 관리 ] ─────────────────");
		// TODO figlet으로 상품조회 이미지 넣기
	}
	
	private static void line() {
		
		for(int i=0;i<50;i++) {
			System.out.print("─");
		}
		System.out.println();
	}
	private static void line(int num) {
		
		for(int i=0;i<num;i++) {
			System.out.print("─");
		}
		System.out.println();
	}
	private static void tap() {
		System.out.print("\t");
	}
	private static void tap(int num) {
		for(int i=0;i<num;i++) {
			System.out.print("\t");
		}
	}
}
