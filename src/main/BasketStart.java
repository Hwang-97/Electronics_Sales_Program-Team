/*
package main;

import java.util.ArrayList;
import java.util.List;

import createObject.Basket;
import createObject.Member;
import createObject.Product;

public class BasketStart {

	public static List<Basket> memberBasket;
	public static List<Product> memberProductBasket;

	public static boolean main() {

		// 메인 - 로그인 - 회원 - 장바구니
		// 로그인 한 회원이 장바구니 바로 조회할 수 있다.
		// int index = findMemberIndex(); // 못 찾으면 -1 반환
		boolean loop = true;

		while (loop) {
			copyMemberBasket();
			copyProductBasket();
			printBasket();
			printDetails();

			copyMemberBasket();
			copyProductBasket();
			menuInputBasket(); // 메뉴 출력
			System.out.print("선택: ");
			int sel = Main.inputUserNum(0, 2);
			Main.scan.nextLine();
			System.out.println("\n\n\n\n\n\n\n\n\n\n");

			switch (sel) {
			case 0:
				copyMemberBasket();
				copyProductBasket();
				loop = false; // 뒤로가기
				break;
			case 1:
				loop = BasketDetails.main(); //상세조회
				break;
//			case 2:
//				loop = BasketRemove.main(); // 장바구니 삭제
//				break;
			}

		} // while

		return true;

	}// main 메소드

	private static void printDetails() {

		for (int i = 0; i < memberBasket.size(); i++) {
			String result = "";
			result += String.format("%5d \t\t%5d \t\t%5s %5s\t%,5d개 \t %,5d원", memberBasket.get(i).getMemberNum(),
					memberBasket.get(i).getItemNumber(), memberProductBasket.get(i).getProductName(),
					memberProductBasket.get(i).getProductModel(), memberBasket.get(i).getNumberOfItem(),
					memberProductBasket.get(i).getProductPrice());
			System.out.println(result);

		}
	}

	private static void copyProductBasket() {
		memberProductBasket = new ArrayList<Product>();
		memberBasket.stream().map(b -> {
			for (int i = 0; i < Main.productList.size(); i++) {
				if (b.getItemNumber() == Main.productList.get(i).getProductNum()) {
					return Main.productList.get(i);
				}
			}
			return null;
		}).filter(p -> p != null).forEach(p -> memberProductBasket.add(p));
	}

	private static void copyMemberBasket() {
		// 회원정보에서 로그인한 회원의 basket복사
		memberBasket = new ArrayList<Basket>();
		Main.basketList.stream().filter(b -> b.getMemberNum() == Main.memberNumber).forEach(b -> memberBasket.add(b));
	}

	private static void menuInputBasket() {

		// 메인 - 로그인 - 회원 - 장바구니 - 하위 메뉴
		// 메뉴출력

		System.out.println("─────────────────── +-+-+|m|e|n|u|+-+-+ ─────────────────────");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 상세조회");
//		System.out.println("2. 장바구니 물품 삭제");
		System.out.println("─────────────────────────────────────────────────────────────");
	}

//	private static void printFailDetail() { 
//		System.out.println("이전 화면으로 돌아가시겠습니까?");
//		System.out.println("0. 뒤로가기");
//		System.out.println("1. 다시 입력하기");
//	}

	private static void printBasket() {

		System.out.println("------------------------------------------------------------");
		System.out.println(" _______                       __                   __     \r\n"
				+ "|       \\                     |  \\                 |  \\    \r\n"
				+ "| $$$$$$$\\  ______    _______ | $$   __   ______  _| $$_   \r\n"
				+ "| $$__/ $$ |      \\  /       \\| $$  /  \\ /      \\|   $$ \\  \r\n"
				+ "| $$    $$  \\$$$$$$\\|  $$$$$$$| $$_/  $$|  $$$$$$\\\\$$$$$$  \r\n"
				+ "| $$$$$$$\\ /      $$ \\$$    \\ | $$   $$ | $$    $$ | $$ __ \r\n"
				+ "| $$__/ $$|  $$$$$$$ _\\$$$$$$\\| $$$$$$\\ | $$$$$$$$ | $$|  \\\r\n"
				+ "| $$    $$ \\$$    $$|       $$| $$  \\$$\\ \\$$     \\  \\$$  $$\r\n"
				+ " \\$$$$$$$   \\$$$$$$$ \\$$$$$$$  \\$$   \\$$  \\$$$$$$$   \\$$$$ \r\n"
				+ "                                                           \r\n");
		System.out.println("------------------------------------------------------------");
		System.out.println("회원번호 \t상품번호 \t상품명 \t모델이름 \t 상품수량 \t 상품금액");

	}

}
*/
package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import createObject.Basket;
import createObject.Product;

public class BasketStart
{
	public static List<Basket> memberBasket;
	public static List<Product> memberProductBasket;
	
	public static boolean main() throws Exception
	{
		copyMemberBasket();
		copyProductBasket();
		
		printBasket();
		
		//System.out.println("[상품번호]\t[상품코드]\t[상품명]\t[상품금액]\t[상품수량]");
		for(int i=0; i<main.Main.basketList.size(); i++)
		{
			if(Main.memberNumber == main.Main.basketList.get(i).getMemberNum())
			{
				System.out.println(String.format("%5d\t%s\t%s\t\t%d\t\t%5d", main.Main.basketList.get(i).getProductNum(), main.Main.basketList.get(i).getProductCode(), main.Main.basketList.get(i).getProductName(), main.Main.basketList.get(i).getProductPrice()
						,main.Main.basketList.get(i).getProductCount()));
			}
		}
		
		//menuBasket(); // 장바구니 메뉴 출력
		
		menuInputBasket();
		
		System.out.print("번호 입력 : ");
		try(Scanner scanner = new Scanner(System.in))
		{
			if(!scanner.hasNextInt())
			{
				System.out.println("잘못된 번호입니다");
				BasketStart.main(); // 장바구니 메뉴로
			}
			int num = scanner.nextInt();
			String temp = scanner.nextLine(); // 버퍼 비움
			
			switch(num)
			{
				case 0:
					MemberLogin.main(); // 회원 메인으로
					break;
				case 1:
					BuyBasket.main();
					break;
				case 2: // 장바구니 전체 삭제
					for(int i=0; i<main.Main.basketList.size(); i++)
					{
						if(Main.memberNumber == main.Main.basketList.get(i).getMemberNum())
						{
							if(main.Main.basketList.get(i).getMemberNum() == Main.memberNumber)
							{
								main.Main.basketList.remove(i);
							}
						}
					}
					BasketStart.main(); // 장바구니 메뉴로
					break;
				case 3: // 장바구니 개별 삭제
					System.out.print("상품번호 입력 : ");
					int itemNum = scanner.nextInt();
					
					for(int i=0; i<main.Main.basketList.size(); i++)
					{
						if(Main.memberNumber == main.Main.basketList.get(i).getMemberNum())
						{
							if(main.Main.basketList.get(i).getProductNum() == itemNum)
							{
								main.Main.basketList.remove(i);
								break;
							}
						}
					}
					BasketStart.main(); // 장바구니 메뉴로
					break;
				default:
					System.out.println("잘못된 번호입니다");
					BasketStart.main(); // 장바구니 메뉴로
					break;	
			}
		}
		return true;
	}
	private static void copyProductBasket() {
		memberProductBasket = new ArrayList<Product>();
		memberBasket.stream().map(b -> {
			for (int i = 0; i < Main.productList.size(); i++) {
				if (b.getProductNum() == Main.productList.get(i).getProductNum()) {
					return Main.productList.get(i);
				}
			}
			return null;
		}).filter(p -> p != null).forEach(p -> memberProductBasket.add(p));
	}

	private static void copyMemberBasket() {
		// 회원정보에서 로그인한 회원의 basket복사
		memberBasket = new ArrayList<Basket>();
		Main.basketList.stream().filter(b -> b.getMemberNum() == Main.memberNumber).forEach(b -> memberBasket.add(b));
	}
	/*
	private static void menuBasket()
	{
		System.out.println();
		System.out.println("#####장바구니#####");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 구매");
		System.out.println("2. 목록 전체 삭제");
		System.out.println("3. 목록 개별 삭제");
	}
	*/
	private static void menuInputBasket() {

		// 메인 - 로그인 - 회원 - 장바구니 - 하위 메뉴
		// 메뉴출력

		System.out.println("─────────────────── +-+-+|m|e|n|u|+-+-+ ─────────────────────");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 구매");
		System.out.println("2. 목록 전체 삭제");
		System.out.println("3. 목록 개별 삭제");
		System.out.println("─────────────────────────────────────────────────────────────");
	}

//	private static void printFailDetail() { 
//		System.out.println("이전 화면으로 돌아가시겠습니까?");
//		System.out.println("0. 뒤로가기");
//		System.out.println("1. 다시 입력하기");
//	}

	private static void printBasket() {

		System.out.println("------------------------------------------------------------");
		System.out.println(" _______                       __                   __     \r\n"
				+ "|       \\                     |  \\                 |  \\    \r\n"
				+ "| $$$$$$$\\  ______    _______ | $$   __   ______  _| $$_   \r\n"
				+ "| $$__/ $$ |      \\  /       \\| $$  /  \\ /      \\|   $$ \\  \r\n"
				+ "| $$    $$  \\$$$$$$\\|  $$$$$$$| $$_/  $$|  $$$$$$\\\\$$$$$$  \r\n"
				+ "| $$$$$$$\\ /      $$ \\$$    \\ | $$   $$ | $$    $$ | $$ __ \r\n"
				+ "| $$__/ $$|  $$$$$$$ _\\$$$$$$\\| $$$$$$\\ | $$$$$$$$ | $$|  \\\r\n"
				+ "| $$    $$ \\$$    $$|       $$| $$  \\$$\\ \\$$     \\  \\$$  $$\r\n"
				+ " \\$$$$$$$   \\$$$$$$$ \\$$$$$$$  \\$$   \\$$  \\$$$$$$$   \\$$$$ \r\n"
				+ "                                                           \r\n");
		System.out.println("------------------------------------------------------------");
		System.out.println("[상품번호][상품코드]\t[상품명]\t\t[상품금액]\t[상품수량]");

	}
}