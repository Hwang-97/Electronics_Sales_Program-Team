package main;

import createObject.ProductList;

public class AddProduct {
	
	private static String checkCode;
	private static String checkName;
	
	public static boolean main() {
		System.out.println("add check");
		return true;
	}
	private static String getCotegory1() {
		System.out.println("───────────────── [ 카테고리 1 선택 ] ─────────────────");
		System.out.println();
		System.out.println("0. 뒤로가기");
		for(int i=0; i<ProductList.CName1.length;i++) {
			System.out.printf("%d. %s\r\n",i+1,ProductList.CName1[i]);
		}
		line();
		System.out.print("입력: ");
		int sel =0;
		try {
			sel = Integer.parseInt(Main.scan.nextLine());
			checkCode +=sel;
		}catch(Exception e) {
			System.out.println("해당하는 번호를 눌러주세요.");
			getCotegory1();
		}
		if(sel==0) {
			System.out.println("상품등록이 취소되었습니다.");
			AdminProduct.main();
		}else if(0<sel&&sel<=ProductList.CName1.length){
			return ProductList.CName1[sel-1];
		}else {
			System.out.println("해당하는 번호를 눌러주세요.");
			getCotegory1();
		}
		return null;
	}
	private static void menuMain() {
		
		// 메인
		// 메뉴출력
		// 
		/*
		 * 
		 */
		
		System.out.println("───────────────── [ 메뉴 목록 ] ─────────────────");
		System.out.println("0. 아니요");
		System.out.println("1. 예");
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
