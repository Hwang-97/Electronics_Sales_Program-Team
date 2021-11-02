package main;

import java.util.Scanner;

public class Login {
	public static boolean main() {
		
		// 메인 - 로그인
		boolean loop = true;
		
		while (loop) {
			printLogin();
			menuLogin();
			
			System.out.print("선택: ");
			int sel = Main.inputUserNum(0,5);
			Main.scan.nextLine();
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n");
		
			switch(sel) {
			case 0:
				loop = false;				//뒤로가기
				break;
			case 1: 
				loop = InputLogin.main();	//
				break;
			case 2:
				//loop = nonMember.main();
				break;
			case 3:
				//loop = Admin.main();
				break;
			case 4:
				loop = FindID.main();
				break;
			case 5:
				loop = FindPW.main();
				break;
			}
		}
		return true;
	}//메인메소드
		


	private static void printLogin() {
		System.out.println("───────────────── [ 로그인 화면 ] ─────────────────");
		
	}//printLogin()

	private static void menuLogin() {
		
		// 메인 - 로그인
		
		System.out.println("───────────────── [ 메뉴 목록 ] ─────────────────");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 회원 로그인");
		System.out.println("2. 비회원 로그인");
		System.out.println("3. 관리자 로그인");
		System.out.println("4. 아이디찾기");
		System.out.println("5. 비밀번호 찾기");
		System.out.println("──────────────────────────────────────────────────");
		
	}//menuLogin()
	
	
}//class login
























//테스트 코드----------------------------------------------------------------------------------------
//System.out.println(main.memberList.get(0).getAddress());								//장바구니 데이터.txt
//main.memberList.get(0).setAddress("abcd");
//System.out.println(main.memberList.get(0).getAddress());								//장바구니 데이터.txt
//int count=0;
//System.out.println("상품번호\t상품코드\t\t상품명\t모델이름\t카테고리1\t카테고리2\t가격\t재고\t할인율\t주문횟수\t환불횟수");
//for (createObject.Product p : main.productList) {
//	if(Integer.parseInt(p.getProductCategory1())==1 &&
//			Integer.parseInt(p.getProductCategory2())==1) {
//		System.out.printf("%s\t" //상품번호
//				+ "%s\t"	//상품코드
//				+ "%s\t"	//상품명
//				+ "%s\t"	//모델이름
//				+ "%s\t"	//카테고리1
//				+ "%s\t"	//카테고리2
//				+ "%,8d원\t"	//가격
//				+ "%s개\t"	//재고
//				+ "%s%%\t"	//할인율
//				+ "%s회\t"	//주문횟수
//				+ "%s회\n"	//환불횟수
//				,p.getProductNum()
//				,p.getProductCode()
//				,p.getProductName()
//				,p.getProductModel()
//				,p.getProductCategory1Name()
//				,p.getProductCategory2Name()
//				,p.getProductPrice()
//				,p.getProductStock()
//				,p.getProductSale()*100
//				,p.getProductOrderNum()
//				,p.getProductRefundNum());
//		count++;
//	}
//}
//----------------------------------------------------------------------------------------
