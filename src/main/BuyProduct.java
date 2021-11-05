package main;

import java.util.Calendar;

import createObject.Member;
import createObject.Order;
import createObject.Product;
import createObject.Tracking;

public class BuyProduct {
	// InputLogin으로 돌아가는 Key
	public static boolean gotoInput;

	// 입력받을 주문 관련 데이터
	public static Order newOrder = new Order();
	public static Tracking newTracking=new Tracking();
	public static int orderNumber;
	public static int goodsNumber;
	public static int memberNumber;
	public static int usePoint;
	public static int accumulatePoint;
	public static String name;
	public static String address;
	public static String phoneNumber;
	public static String selectPayment;
	public static boolean cancelCheck;
	public static String orderDate;
	public static String invoiceNumber;
	// 주문데이터에는 없지만 선언하면 편함
	public static int price;
	public static int point;
	// 배송 데이터
	public static int trackingNum;
	

	static {
		gotoInput = false;
	}

	public static boolean main(int productNum, String productCode) {
		gotoInput = false;

//		TODO 출력되는거 수정 (printBuyProduct(), menuBuyProduct())  
		printBuyProduct();
//		menuBuyProduct();

		// 주문 입력
		if(Main.nowLogin)
			inputOrder(productNum, productCode);
		else {
//			TODO 비회원 주문 
//			inputOrderNonM(productNum, productCode);
		}
		
		//거래
		switch (selectPayment) {
		case "카드": // 카드
			System.out.println("카드 결제 시스템 . . .");
			break;
		case "무통장": // 무통장
			System.out.println("무통장 결제 시스템 . . .");
			break;
		case "핸드폰": // 핸드폰
			System.out.println("핸드폰 결제 시스템 . . .");
			break;
		}
		
		// 마지막 확인
		System.out.println("위 정보가 올바르며 주문확정 하시겠습니까? (0: 아니오 / 1: 예)");
		int lastCheck = Main.inputUserNum(0, 1);
		Main.scan.nextLine();

		if (lastCheck == 1) {
			Main.orderList.add(newOrder);
			Main.trackingList.add(newTracking);
		}
		else
			return true;
		// 여기까지 주문 끝

		gotoInput = true;
		return false;
	}

	private static void inputOrderNonM(int productNum, String productCode) {
//		***비회원 주문***
//		비회원 받는 값: 전화번호(id) 이름 주민, 주소
//		
		
		// 상품가격
		for (Product p : Main.productList) {
			if (productNum == p.getProductNum()) {
				price = p.getProductPrice();
				break;
			}
		}
		// 포인트
		point=0;
		// 주문번호 = 주문리스트의 마지막 요소(size-1)의 주문번호+1
		orderNumber = Main.orderList.get(Main.orderList.size() - 1).getOrderNumber() + 1;
		newOrder.setOrderNumber(orderNumber);
		// 상품번호 = productNum
		goodsNumber = productNum;
		newOrder.setGoodsNumber(goodsNumber);
		// 멤버번호
		memberNumber = Main.memberNumber;
		newOrder.setMemberNumber(memberNumber);
		// 누적포인트
		accumulatePoint = price / 100;
		newOrder.setAccumulatePoint(accumulatePoint);
		// 취소여부
		cancelCheck = false;
		newOrder.setCancelCheck(cancelCheck);
		// 주문시간
		Calendar now = Calendar.getInstance();
		orderDate = String.format("%tF", now);
		newOrder.setOrderDate(orderDate);

		// 수취인 이름
		System.out.print("수취인 이름을 입력하세요. >");
		name = Main.scan.nextLine();
		System.out.println();
		newOrder.setName(name);
		// 수취인 주소
		System.out.print("수취인 주소를 입력하세요. >");
		address = Main.scan.nextLine();
		System.out.println();
		newOrder.setAddress(address);
		// 수취인 연락처
		System.out.print("수취인 연락처를 입력하세요. >");
		phoneNumber = Main.scan.nextLine();
		System.out.println();
		newOrder.setPhoneNumber(phoneNumber);
		// 결제방법
		System.out.println("1. 카드");
		System.out.println("2. 무통장");
		System.out.println("3. 핸드폰");
		System.out.print("결제방법을 선택하세요. >");
		int selPay = Main.inputUserNum(1, 3);
		Main.scan.nextLine();
		switch (selPay) {
		case 1:
			selectPayment = "카드";
			break;
		case 2:
			selectPayment = "무통장";
			break;
		case 3:
			selectPayment = "핸드폰";
			break;
		}
		newOrder.setSelectPayment(selectPayment);
		System.out.println();
		// 사용포인트
		System.out.print("사용할 포인트를 입력하세요. 보유 포인트: " + point+"\n");
		while(true) {
			usePoint = Main.inputUserNum(0, point);
			if(!(usePoint>price))
				break;
		}
		System.out.println();
		newOrder.setUsePoint(usePoint);
		// 송장번호
		invoiceNumber = orderDate + Main.memberNumber;
		newOrder.setInvoiceNumber(invoiceNumber);
		
		newTracking.setOrderNumber(orderNumber);
		newTracking.setDeliveryStatus("출고준비");

	}

	public static void inputOrder(int productNum, String productCode) {
		// ***주문관련 입력받는 메소드***

//		//입력받을 주문 관련 데이터
//		static int orderNumber;			O 주문번호
//		static int goodsNumber;			O 상품번호
//		static int memberNumber;		O 주문자번호
//		static int usePoint;			O 사용포인트 <입력
//		static int accumulatePoint;		O 누적포인트
//		static String name;				O 수취인 이름 <입력
//		static String address;			O 수취인 주소 <입력
//		static String phoneNumber;		O 수취인 연락처 <입력
//		static String selectPayment;	결제방법 <입력
//		static boolean cancelCheck;		O 취소여부(초기:false)
//		static String orderDate;		O 주문시간
//		static String invoiceNumber;	송장번호 
		// 주문데이터에는 없지만 선언하면 편함
//		static int price				O 상품가격
//		static int point				O 유저보유포인트

		// 상품가격
		for (Product p : Main.productList) {
			if (productNum == p.getProductNum()) {
				price = p.getProductPrice();
				break;
			}
		}
		// 포인트
		for (Member m : Main.memberList) {
			if (Main.memberNumber == m.getMemberNumber()) {
				point = m.getTotalPoint();
			}
		}
		// 주문번호 = 주문리스트의 마지막 요소(size-1)의 주문번호+1
		orderNumber = Main.orderList.get(Main.orderList.size() - 1).getOrderNumber() + 1;
		newOrder.setOrderNumber(orderNumber);
		// 상품번호 = productNum
		goodsNumber = productNum;
		newOrder.setGoodsNumber(goodsNumber);
		// 멤버번호
		memberNumber = Main.memberNumber;
		newOrder.setMemberNumber(memberNumber);
		// 누적포인트
		accumulatePoint = price / 100;
		newOrder.setAccumulatePoint(accumulatePoint);
		// 취소여부
		cancelCheck = false;
		newOrder.setCancelCheck(cancelCheck);
		// 주문시간
		Calendar now = Calendar.getInstance();
		orderDate = String.format("%tF", now);
		newOrder.setOrderDate(orderDate);

		// 수취인 이름
		System.out.print("수취인 이름을 입력하세요. >");
		name = Main.scan.nextLine();
		System.out.println();
		newOrder.setName(name);
		// 수취인 주소
		System.out.print("수취인 주소를 입력하세요. >");
		address = Main.scan.nextLine();
		System.out.println();
		newOrder.setAddress(address);
		// 수취인 연락처
		System.out.print("수취인 연락처를 입력하세요. >");
		phoneNumber = Main.scan.nextLine();
		System.out.println();
		newOrder.setPhoneNumber(phoneNumber);
		// 결제방법
		System.out.println("1. 카드");
		System.out.println("2. 무통장");
		System.out.println("3. 핸드폰");
		System.out.print("결제방법을 선택하세요. >");
		int selPay = Main.inputUserNum(1, 3);
		Main.scan.nextLine();
		switch (selPay) {
		case 1:
			selectPayment = "카드";
			break;
		case 2:
			selectPayment = "무통장";
			break;
		case 3:
			selectPayment = "핸드폰";
			break;
		}
		newOrder.setSelectPayment(selectPayment);
		System.out.println();
		// 사용포인트
		System.out.print("사용할 포인트를 입력하세요. 보유 포인트: " + point+"\n");
		while(true) {
			usePoint = Main.inputUserNum(0, point);
			if(!(usePoint>price))
				break;
		}
		System.out.println();
		newOrder.setUsePoint(usePoint);
		// 송장번호
		invoiceNumber = orderDate + Main.memberNumber;
		newOrder.setInvoiceNumber(invoiceNumber);
		
		newTracking.setOrderNumber(orderNumber);
		newTracking.setDeliveryStatus("출고준비");

	}

	private static void printBuyProduct() {
		
		System.out.println();
		System.out.println("────────────────────────────────────────── [ 상품구매 - 주문서 작성 ] ──────────────────────────────────────────");
		System.out.println();
	}

	private static void menuBuyProduct() {
		
		System.out.println();
		System.out.println("─────────────────────────────────────────── +-+-+|M|E|N|U|+-+-+ ───────────────────────────────────────────");
		System.out.println("\t\t\t 1. 개인정보 확인 \t\t\t\t 0. 뒤로가기");
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println();
		
//		System.out.println("───────────────── [ 메뉴 목록 ] ─────────────────");
//		System.out.println("0. 뒤로가기");
//		System.out.println("1. 개인정보 확인");
//		System.out.println("───────────────────────────────────────────────");
	}
}
