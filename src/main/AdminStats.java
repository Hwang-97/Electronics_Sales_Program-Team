package main;

import java.util.ArrayList;
import java.util.List;

import createObject.Member;
import createObject.Product;

/**
 * 
 * @author 황현우	
 *관리자 로그인 후 통계를 반환하는 클래스
 */
public class AdminStats {
	/**
	 * Admin 통계 내부파일
	 */
	public static List<Member> memberstat; 		// 한번이라도 구매한 회원
	/**
	 * Admin 통계 내부파일
	 */
	public static List<Product> productStats;	// 한번이라도 판매된 상품
	private static int i=0; 					// stream class 사용용
	
	private static void addList() {
		
		memberstat = new ArrayList<Member>();
		productStats = new ArrayList<Product>();
																													// 한번이라도 구매한 회원 복사
		for(i=0;i<Main.orderList.size();i++) {
			Main.memberList.stream().filter(m-> m.getMemberNumber()==Main.orderList.get(i).getMemberNumber()).forEach(m->memberstat.add(m));
		}
		for(i=0;i<Main.orderList.size();i++) {																		// 한번이라도 판매된 상품 복사 ( 중복이 없게 contain 확인) + 비회원도 진행
			Main.productList.stream().filter(p->p.getProductNum()==Main.orderList.get(i).getGoodsNumber() && !productStats.contains(p)).forEach(p->productStats.add(p));
		}
		for(i=0;i<Main.nonMemberOrderList.size();i++) {
			Main.productList.stream().filter(p->p.getProductNum()==Main.nonMemberOrderList.get(i).getGoodsNumber() && !productStats.contains(p)).forEach(p->productStats.add(p));
		}
	}
	/**
	 * 
	 * 
	 * @return boolean
	 * 
	 * 모든 관련 클래스들 끼리 상호작용하며 최종적으로 해당 화면을 나올시 true를 반환한다.
	 */
	public static boolean main() {
		
		addList();
		
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
			case 1: //구매통계
				loop = AdminPurchaseStats.main();
				break;
			case 2: //장바구니 통계
				loop = AdminBasketStats.main();
				break;
			case 3: //매출 통계
				loop = AdminSalesStats.main();
				break;
			case 4: //회원 통계
				loop = AdminMemberStats.main();
				break;
			}
		}
		return true;
	}
	
	private static void menuMain() {
		
		// 메인
		// 메뉴출력
		
		System.out.println("───────────────── [ 메뉴 목록 ] ─────────────────");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 구매 통계");
		System.out.println("2. 장바구니 통계");
		System.out.println("3. 매출 통계");
		System.out.println("4. 회원 통계");
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
		System.out.println("───────────────── [ 통계 관리 ] ─────────────────");
		// TODO figlet으로 상품조회 이미지 넣기
	}
}
