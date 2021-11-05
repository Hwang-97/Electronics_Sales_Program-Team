package main;

import java.util.List;
import java.util.Scanner;

import createObject.*;
import createDump.*;

public class Main {
	public static Scanner scan = new Scanner(System.in);
	
	public static List<Member> memberList;			// 회원 데이터
	public static List<Basket> basketList;			// 장바구니 데이터
	public static List<Order> orderList;			// 주문 데이터
	public static List<Product> productList;		// 상품 데이터
	public static List<Query> queryList;			// 상품 문의
	public static List<Review> reviewList;			// 상품 리뷰
	public static List<Tracking> trackingList;		// 배송 데이터
	
	public static List<Basket> nonMemberBasketList;	// 비회원 장바구니 데이터
	public static List<Member> nonMemberList;		// 비회원데이터
	public static List<Order> nonMemberOrderList;	// 비회원 주문 데이터
	
	public static String id;		//로그인 id
	public static String pw;		//로그인 pw
	public static Boolean nowLogin;	//로그인 여부 
	public static int memberNumber;	//로그인 여부 
	
	static {
		nowLogin=false;
	}
	
	public static void main(String[] args) throws Exception {
		// 데이터 로드
	
		basketList = BasketList.load();		//장바구니 데이터.txt
		orderList = OrderList.load();		//주문 데이터.txt
		productList= ProductList.load();	//상품 데이터.txt
		queryList = QueryList.load();		//상품 문의.txt
		reviewList = ReviewList.load();		//상품 리뷰.txt
		trackingList = TrackingList.load();	//배송 데이터.txt
		
		memberList=MemberList.load();		//회원데이터.txt
		//nonMemberBasketList = NonMemberBasketList.load();      // 비회원 장바구니 데이터.txt
	    nonMemberList = NonMemberList.load();               // 비회원데이터.txt
	    nonMemberOrderList = NonMemberOrderList.load();         // 비회원 주문 데이터.txt
	    
//	    DetailPageDump.dump(); //덤프파일 생성시 주석 삭제
	    
		MainScreen.main();
		
		scan.close();
		System.out.println("텍스트 파일을 업데이트 합니다.");
//		save();
		System.out.println("프로그램이 종료되었습니다.");
		
		//ContentData.saveQuery();
		ContentData.saveReview();
		
	}// 메인 메소드
	
	
	public static int inputUserNum(int startNum, int endNum) {

		// 메인
		// 사용자에게 메인 메뉴에서 입력값을 받음 (범위: startNum ~ endNum)
		// startNum: 메뉴의 첫 번호
		// endNum: 메뉴의 마지막 번호

		while (true) {
			try {
				int input = scan.nextInt();
				if (input >= startNum && input <= endNum) {
					return input;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("다시 입력하세요.\n");
				System.out.print("선택: ");
				scan.nextLine();
			}
		}

	}// inputSwitchNum()


}














//test 코드
//System.out.println(memberList.get(0));								//회원
//System.out.println("\n\n\n");
//System.out.println(basketList.get(0));								//장바구니 데이터.txt
//System.out.println("\n\n\n");
//System.out.println(orderList.get(0));								//주문 데이터.txt
//System.out.println("\n\n\n");
//System.out.println(productList.get(0).getProductCategory1Name());	//상품 데이터.txt
//System.out.println("\n\n\n");
//System.out.println(queryList.get(0).getAnswerContent());			//상품 문의.txt
//System.out.println("\n\n\n");
//System.out.println(reviewList.get(0).getItemCode());				//상품 리뷰.txt
//System.out.println("\n\n\n");
//System.out.println(trackingList.get(0).getOrderNumber());			//배송 데이터.txt

//수정 test 코드
//System.out.println(basketList.get(0));								//장바구니 데이터.txt
//basketList.get(0).setItemNumber(2);
//System.out.println(basketList.get(0));								//장바구니 데이터.txt
//basketList.get(0).setItemNumber(27);
//System.out.println(basketList.get(0));								//장바구니 데이터.txt
