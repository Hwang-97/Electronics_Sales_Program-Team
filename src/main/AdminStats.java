package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import createObject.Member;
import createObject.Order;
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
	public static List<Member> memberstat; 				// 한번이라도 구매한 회원
	public static List<Product> productStats;			// 한번이라도 판매된 상품
	
	public static List<Member> basketMemberstat; 		// 장바구니를 사용중인 회윈
	public static List<Product> basketProductStats;		// 한번이라도 장바구니에 들어간 상품
	
	public static List<Member>  currenYearMember;		// 현재 년도에 구매한 회원 복사
	public static List<Product> currenYearProductStats;// 현재 년도에 구매된 상품 복사
	
	public static List<Member>  currenMonthMember;		// 현재 월에 구매한 회원 복사
	public static List<Product> currenMonthProductStats;// 현재 월에 구매된 상품 복사

	private static int i=0; 							// stream class 사용용
	private static String year= "";						// stream class 사용용
	private static String month= "";						// stream class 사용용
	
	private static void addList() {
		//비회원도 통합하여 계산 
		memberstat = new ArrayList<Member>();
		productStats = new ArrayList<Product>();
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 한번이라도 구매한 회원 복사
		for(i=0;i<Main.orderList.size();i++) {
			Main.memberList.stream().filter(m-> m.getMemberNumber()==Main.orderList.get(i).getMemberNumber()).forEach(m->memberstat.add(m));
		}
		for(i=0;i<Main.nonMemberOrderList.size();i++) {																																// 비회원 부분 상품 복사
			Main.nonMemberList.stream().filter(m->m.getMemberNumber()==Main.nonMemberOrderList.get(i).getMemberNumber()).forEach(m->memberstat.add(m));
		}
		//..........................................................................................................................................................................
		for(i=0;i<Main.orderList.size();i++) {																																		// 한번이라도 판매된 상품 복사 ( 중복이 없게 contain 확인) + 비회원도 진행
			Main.productList.stream().filter(p->p.getProductNum()==Main.orderList.get(i).getGoodsNumber() && !productStats.contains(p)).forEach(p->productStats.add(p));
		}
		for(i=0;i<Main.nonMemberOrderList.size();i++) {																																// 비회원 부분 상품 복사
			Main.productList.stream().filter(p->p.getProductNum()==Main.nonMemberOrderList.get(i).getGoodsNumber() && !productStats.contains(p)).forEach(p->productStats.add(p));
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 하위는 장바구니 관련
		basketMemberstat =new ArrayList<Member>();
		basketProductStats=new ArrayList<Product>();
		
		for(i=0;i<Main.basketList.size();i++) {																																		// 장바구니를 사용중인 회윈
			Main.memberList.stream().filter(m-> m.getMemberNumber()==Main.basketList.get(i).getMemberNum()).forEach(m->basketMemberstat.add(m));
		}
		for(i=0;i<Main.nonMemberBasketList.size();i++) {																															// 장바구니를 사용중인 비회윈
			Main.nonMemberList.stream().filter(m->m.getMemberNumber()==Main.basketList.get(i).getMemberNum()).forEach(m->basketMemberstat.add(m));
		}
		//.........................................................................................................................................................................
		for(i=0;i<Main.basketList.size();i++) {																																		// 한번이라도 장바구니에 들어간 상품(회원)
			Main.productList.stream().filter(p->p.getProductNum()==Main.basketList.get(i).getItemNumber()).forEach(p->basketProductStats.add(p));
		}
		for(i=0;i<Main.nonMemberBasketList.size();i++) {																															// 한번이라도 장바구니에 들어간 상품(비회원)
			Main.productList.stream().filter(p->p.getProductNum()==Main.nonMemberBasketList.get(i).getItemNumber()).forEach(p->basketProductStats.add(p));
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 년간 회원 및 데이터 복사
		currenYearMember		= new ArrayList<Member>();
		currenYearProductStats	= new ArrayList<Product>();
		Calendar c = Calendar.getInstance();
		year 	   = String.format("%tF", c).substring(0,4);																														// 현재 년도 String 화
		for(i=0;i<Main.orderList.size();i++) {																																		// 회원 정보 복사
			String memberOrderYear =Main.orderList.get(i).getOrderDate().substring(0,4);
			Main.memberList.stream().filter(m-> memberOrderYear.equals(year) && Main.orderList.get(i).getMemberNumber()==m.getMemberNumber()).forEach(m->currenYearMember.add(m));
		}
		for(i=0;i<Main.nonMemberOrderList.size();i++) {																																// 비회원 정보 복사
			String nonMemberOrderYear =Main.nonMemberOrderList.get(i).getOrderDate().substring(0,4);
			Main.nonMemberList.stream().filter(m-> nonMemberOrderYear.equals(year) && Main.nonMemberOrderList.get(i).getMemberNumber()==m.getMemberNumber()).forEach(m->currenYearMember.add(m));
		}
		//...........................................................................................................................................................................
		for(i=0;i<Main.orderList.size();i++) {
			String memberOrderYear =Main.orderList.get(i).getOrderDate().substring(0,4);																							// 현재년도에 주문했던 상품 정보 복사
			Main.productList.stream().filter(p->memberOrderYear.equals(year) && Main.orderList.get(i).getGoodsNumber()==p.getProductNum() && !currenYearProductStats.contains(p)).forEach(p->currenYearProductStats.add(p));
//			System.out.println(Main.orderList.get(i).hashCode());
//			List<Order> list = new ArrayList<Order> ()	;
//			list.add(Main.orderList.get(i));
//			System.out.println(list.get(0).hashCode());
			// 중복 방지 가능한지 확있했던 코드
		}
		for(i=0;i<Main.nonMemberOrderList.size();i++) {
			String nonMemberOrderYear =Main.nonMemberOrderList.get(i).getOrderDate().substring(0,4);																				// 현재년도에 주문했던 상품 정보 복사	
			Main.productList.stream().filter(p->nonMemberOrderYear.equals(year)&& Main.nonMemberOrderList.get(i).getGoodsNumber()==p.getProductNum() && !currenYearProductStats.contains(p)).forEach(p->currenYearProductStats.add(p));
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 월간 회원 및 데이터 복사
		currenMonthMember			= new ArrayList<Member>();
		currenMonthProductStats		= new ArrayList<Product>();
		month	   = String.format("%tF", c).substring(5,7);
//		month="10";
		for(i=0;i<Main.orderList.size();i++) {																																		// 회원 정보 복사
			String memberOrderMonth =Main.orderList.get(i).getOrderDate().substring(5,7);
			Main.memberList.stream().filter(m-> memberOrderMonth.equals(month) && Main.orderList.get(i).getMemberNumber()==m.getMemberNumber()).forEach(m->currenMonthMember.add(m));
		}
		for(i=0;i<Main.nonMemberOrderList.size();i++) {																																// 비회원 정보 복사
			String nonMemberOrderMonth =Main.nonMemberOrderList.get(i).getOrderDate().substring(5,7);
			Main.nonMemberList.stream().filter(m-> nonMemberOrderMonth.equals(month) && Main.nonMemberOrderList.get(i).getMemberNumber()==m.getMemberNumber()).forEach(m->currenMonthMember.add(m));
		}
		//.........................................................................................................................................................................
		for(i=0;i<Main.orderList.size();i++) {
			String memberOrderMonth =Main.orderList.get(i).getOrderDate().substring(5,7);																							// 현재월에 주문했던 회원 정보 복사
			Main.productList.stream().filter(p->memberOrderMonth.equals(month) && Main.orderList.get(i).getGoodsNumber()==p.getProductNum() && !currenMonthProductStats.contains(p)).forEach(p->currenMonthProductStats.add(p));
		}
		for(i=0;i<Main.nonMemberOrderList.size();i++) {
			String nonMemberOrderMonth =Main.nonMemberOrderList.get(i).getOrderDate().substring(5,7);																				// 현재년도에 주문했던 상품 정보 복사	
			Main.productList.stream().filter(p->nonMemberOrderMonth.equals(month)&& Main.nonMemberOrderList.get(i).getGoodsNumber()==p.getProductNum() && !currenMonthProductStats.contains(p)).forEach(p->currenMonthProductStats.add(p));
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
