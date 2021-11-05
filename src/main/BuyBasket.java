package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import createObject.*;

public class BuyBasket extends BasketStart {
		// 입력받을 주문 관련 데이터
		private static Member member =new Member();
		////////////////////////////////////////////////////
		private static Order newOrder = new Order();
		///////////////////////////////////////////////////
		private static Tracking newTracking=new Tracking();
		// 주문번호 , 배송현황 default 출고춘비
		///////////////////////////////////////////////////
		private static int orderNumber;
		// sort 한번 구하고 +1하며 사용	********************************************************************************
		private static int goodsNumber;
		// 입력받기						**************************************************************************************
		private static int memberNumber = Main.memberNumber;
		// 자동
		private static int usePoint;
		// 입력받기 메인 멤버 번호를 이용해서 멤버 정보 가져오기 
		private static int accumulatePoint =100; // 기본 적립금
		// 가지 포인트에서 use 빼기
		private static String name;
		// 모두 동일
		private static String address;
		//동일
		private static String phoneNumber;
		//동일
		private static String selectPayment;
		//동일
		private static boolean cancelCheck=false;
		//false
		private static String orderDate;
		// 현재날짜
		private static String invoiceNumber;
		// 현재날짜 + 멤버 번오 2자리
		////////////////////////////////////////////////주문완료 후 해당 주문번호에 주문한 갯수 --
		public static int price;
		public static int point;
		// 주문데이터에는 없지만 선언하면 편함
		private static HashMap<Integer,Integer> buy;
		// 배송 데이터
		private static int trackingNum;
		// 1. 주문할 상품의 상품번호와 갯수를 입력한다.
		//memberBasket
		//memberProductBasket
		
		
		public static boolean main() throws Exception {
			
			
			
			
			
			buy = new HashMap<Integer,Integer>();//key 상품 번호 value 갯수
			member = new Member();
			for(Member m : Main.memberList) {
				if(m.getMemberNumber() == Main.memberNumber) {
					member = m;
				}
			}
			member.setTotalPoint(member.getTotalPoint()-usePoint+100);
			for(int i=0;i<Main.memberList.size();i++) {
				if(Main.memberList.get(i).getMemberNumber()==Main.memberNumber) {
					Main.memberList.get(i).setTotalMoney(Main.memberList.get(i).getTotalMoney()+price);
					Main.memberList.get(i).setTotalPoint(Main.memberList.get(i).getTotalPoint()+price/100);
					break;
				}
			}
			
			//구상 
			//1.주문에 필요한 정보를 입력 받는다.
			//	이름 , 주소 , 연락처 , 결제방법(카드,무통장,핸드폰) , 사용할 포인트 주문 완료 후 확임받기
//			writeNewTracking();
			printBasket();
			
			System.out.println("[상품번호][상품코드]\t[상품명]\t\t[상품금액]\t[상품수량]");
			for(int i=0; i<main.Main.basketList.size(); i++)
			{
				if(Main.memberNumber == main.Main.basketList.get(i).getMemberNum())
				{
					System.out.println(String.format("%5d\t%s\t%s\t\t%d\t\t%5d", main.Main.basketList.get(i).getProductNum(), main.Main.basketList.get(i).getProductCode(), main.Main.basketList.get(i).getProductName(), main.Main.basketList.get(i).getProductPrice()
							,main.Main.basketList.get(i).getProductCount()));
				}
			}
			
			
			
//			printDetails(); TODO
			if(checkBuy()) {
				return true;
			}
			if(write()) {
				return true;
			}
			menuInputBasket();
			System.out.print("선택: ");
			int sel = Main.inputUserNum(0, 1);
			
			
			Main.scan.nextLine();
			
			//System.out.println(Main.scan.nextLine());
			
			switch (sel) {
			case 0:
				return true; // 뒤로가기 -> 로그인 메뉴 목록으로 돌아감 InputLogin.main()
			case 1:
				StartAdd();
				return MemberLogin.main();
			}
			
			return true;
		}
//		private static List<Integer> key = new ArrayList<Integer>();
		private static void StartAdd() {
			int sum = 0;
			Set<Integer> key = buy.keySet();
			for(int i : key) {
				int productNum = i;
				for(int k=0;k<Main.basketList.size();k++) {//메인 장바구니 조작
					if(Main.basketList.get(k).getProductNum() == i) 
							
							{
						Main.basketList.get(k).setProductCount((Main.basketList.get(k).getProductCount()-buy.get(i)));
						break;
					}
				}
				/*
				for(int k=0;k<Main.memberList.size();k++) { //멤버장바구니 삭제 // 필요없는 행동;;
					if(Main.memberList.get(k).getMemberNumber()==memberNumber) {
						for(int m=0;m<Main.memberList.get(k).getBasketList().size();m++) {
							if(Main.memberList.get(k).getBasketList().get(m).get()==productNum) {
								Main.memberList.get(k).getBasketList().get(m).setProductCount(Main.memberList.get(k).getBasketList().get(m).getProductCount()-buy.get(i));;
								break;
							}
						}
						
					}
				}
				*/
				for(int j=0;j<buy.get(i);j++) {
					newOrder=new Order();
					newOrder.setOrderNumber(orderNumber);
					newOrder.setGoodsNumber(productNum);
					newOrder.setMemberNumber(memberNumber);
					newOrder.setUsePoint(usePoint/buyStoc);
					newOrder.setAccumulatePoint(price/100);
					newOrder.setName(name);
					newOrder.setAddress(address);
					newOrder.setPhoneNumber(phoneNumber);
					newOrder.setSelectPayment(selectPayment);
					newOrder.setCancelCheck(cancelCheck);
					newOrder.setOrderDate(orderDate);
					newOrder.setInvoiceNumber(invoiceNumber);
					/////////////////////////////////////////////////////////////주문정보;
					Main.orderList.add(newOrder);
					newTracking = new Tracking();
					newTracking.setDeliveryStatus("출고준비");
					newTracking.setOrderNumber(orderNumber);
					orderNumber++;
					Main.trackingList.add(newTracking);
					//////////////////////////////////////////////////////////////
					
				}
			}
			System.out.println("주문이 완료되었습니다.");
		}
//		private static void writeNewTracking() {
//			newTracking.setOrderNumber(BuyBasket.orderNumber);
//			newTracking.setDeliveryStatus("출고준비");
//		}
		private static boolean checkBuy() throws Exception {
			line("구매하실 상품의 개수를 입력해 주세요.( 구매하지 않으실 상품은 0)( 취소는 n )");
			for(int i=0;i<memberBasket.size();i++) {
				System.out.printf("%s의 구매 개수 :",memberProductBasket.get(i).getProductName());
				String s = Main.scan.nextLine();
				if(s.equals("N")||s.equals("n")) {
					System.out.println("주문이 취소되었습니다.");
					return BasketStart.main();
				}
				int count =0;
				try {
					count=Integer.parseInt(s);
					if(count>=0&&count<=memberBasket.get(i).getProductCount()) {
						buy.put(memberBasket.get(i).getProductNum(), count);
					}else {
						System.out.println("구매개수를 확인해 주세요.");
						return BuyBasket.main();
					}
				}catch(Exception e) {
					System.out.println("입력값을 확인해 주세요.");
					return BuyBasket.main();
				}
			}
			return false;
		}
		private static boolean write() {
			
			if(getName()) {
				return true;
			}
			if(getAddress()) {
				return true;
			}
			if(phonNumber()) {
				return true;
			}
			if(payment()) {
				return true;
			}
			if(usePoint()) {
				return true;
			}
			getInvoiceNumber();
			getOrderNumber();
			getProductNumber();
			getPrice();
			return false;
		}
		private static int buyStoc=0;
		private static void getPrice() {
			int sum=0;
			int ope=0;
			Set<Integer> k = buy.keySet();
			for(int i : k) {
				for(int o=0;o<Main.productList.size();o++) {
					if(Main.productList.get(o).getProductNum() == i) {
						ope=Main.productList.get(o).getProductPrice();
						buyStoc++;
					}
				}
				for(int j=0;j<buy.get(i);j++) {
					sum+=ope;
				}
			}
			BuyBasket.price=sum;
		}
		private static void getProductNumber() {//**************************************************************
//			Set<Integer> key = buy.keySet();
//			for (int i : key) {
//				key.add(i);
//			}
		}/////////////////////////////////////////////////////////////////////////////이부분은 주문시 3번돌림.
		private static void getOrderNumber() {
			Main.orderList.sort((o1,o2)->o2.getOrderNumber()-o1.getOrderNumber());
			BuyBasket.orderNumber = Main.orderList.get(0).getOrderNumber()+1;
			Main.orderList.sort((o1,o2)->o1.getOrderNumber()-o2.getOrderNumber());
		}
		private static void getInvoiceNumber() {
			Calendar c = Calendar.getInstance();
			String s ="";
			s=String.format("%tF%02d", c , Main.memberNumber).replace("-", "");
			BuyBasket.invoiceNumber = s;
			BuyBasket.orderDate =String.format("%tF", c);
		}
		private static boolean usePoint() {
			line("사용할 포인트 입력");
			System.out.print("사용할 포인트를 입력하세요. 보유 포인트: " + member.getCurrentPoint()+"\n");
			System.out.println();
			System.out.print("입력: ");
			try {
				int point =0;
				point = Main.scan.nextInt();
				Main.scan.nextLine();
				if(point<=member.getTotalPoint()) {
					BuyBasket.usePoint = point;
				}else {
					System.out.println("정확한 정보를 입력해 주세요.");
					usePoint();
				}
			}catch(Exception e) {
				System.out.println("정확한 정보를 입력해 주세요.");
				usePoint();
			}
			return false;
		}
		private static boolean payment() {
			line("지불방식 선택");
			System.out.println();
			System.out.print("입력: ");
			
			System.out.println("0. 주문취소");
			System.out.println("1. 카드");
			System.out.println("2. 무통장");
			System.out.println("3. 핸드폰");
			System.out.print("결제방법을 선택하세요. >");
			int selPay = Main.inputUserNum(1, 3);
			Main.scan.nextLine();
			switch (selPay) {
			case 0:
				return true;
			case 1:
				selectPayment = "카드";
				break;
			case 2:
				selectPayment = "무통장";
				break;
			case 3:
				selectPayment = "핸드폰";
				break;
			default:
				System.out.println("정확한 정보를 입력해 주세요.");
				return payment();
			}
			newOrder.setSelectPayment(selectPayment);
			return false;
		}
		private static boolean phonNumber() {
			String str="";
			try {
				line("전화번호 입력( 주문취소 : 0 )");
				System.out.println();
				System.out.print("입력: ");
				str = Main.scan.nextLine();
				if(str.equals("0")) {
					return true;
				}else{
					BuyBasket.phoneNumber = str;
					return false;
				}
			}catch(Exception e) {
				System.out.println("정확한 정보를 입력해 주세요.");
				return phonNumber();
			}
		}
		private static boolean getAddress() {
			String str="";
			try {
				line("주소 입력( 주문취소 : 0 )");
				System.out.println();
				System.out.print("입력: ");
				str = Main.scan.nextLine();
				if(str.equals("0")) {
					return true;
				}else{
					BuyBasket.address = str;
					return false;
				}
			}catch(Exception e) {
				System.out.println("정확한 정보를 입력해 주세요.");
				return getAddress();
			}
		}
		private static boolean getName() {
			String str="";
			try {
				line("이름 입력( 주문취소 : 0 )");
				System.out.println();
				System.out.print("입력: ");
				str = Main.scan.nextLine();
				if(str.equals("0")) {
					return true;
				}else{
					BuyBasket.name= str;
					return false;
				}
			}catch(Exception e) {
				System.out.println("정확한 정보를 입력해 주세요.");
				return getName();
		}
	}
		
		private static void menuInputBasket() {

			// 메인 - 로그인 - 회원 - 장바구니 - 하위 메뉴
			// 메뉴출력

			System.out.println("─────────────────── +-+-+|m|e|n|u|+-+-+ ─────────────────────");
			System.out.println("0. 취소");
			System.out.println("1. 주문");
			System.out.println("─────────────────────────────────────────────────────────────");
		}

//		private static void printFailDetail() { 
//			System.out.println("이전 화면으로 돌아가시겠습니까?");
//			System.out.println("0. 뒤로가기");
//			System.out.println("1. 다시 입력하기");
//		}

		private static void printBasket() {

			System.out.println("===========================================================================================================");
			System.out.println("\t\t\t\t   ___           _        _   \r\n"
					+ "\t\t\t\t  / __\\ __ _ ___| | _____| |_ \r\n"
					+ "\t\t\t\t /__\\/// _` / __| |/ / _ \\ __|\r\n"
					+ "\t\t\t\t/ \\/  \\ (_| \\__ \\   <  __/ |_ \r\n"
					+ "\t\t\t\t\\_____/\\__,_|___/_|\\_\\___|\\__|\r\n"
					+ "\t\t\t\t                             ");
			System.out.println("===========================================================================================================");
			

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
		private static void line(String num) {
			
			for(int i=0;i<20;i++) {
				System.out.print("─");
			}
			System.out.print("["+num+"]");
			for(int i=0;i<20;i++) {
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
