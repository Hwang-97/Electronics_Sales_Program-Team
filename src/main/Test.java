package main;

import createObject.BasketList;
import createObject.MemberList;
import createObject.OrderList;
import createObject.ProductList;
import createObject.QueryList;
import createObject.ReviewList;
import createObject.TrackingList;

public class Test {
	public static void main(String[] args) throws Exception {
		// 데이터 로드
//		main.memberList=main.MemberList.load();		//회원데이터.txt
//		main.memberList=createObject.MemberList.load();			//회원데이터.txt
//		main.basketList = createObject.BasketList.load();		//장바구니 데이터.txt
		Main.orderList = createObject.OrderList.load();			//주문 데이터.txt
		Main.productList= createObject.ProductList.load();		//상품 데이터.txt
		Main.queryList = createObject.QueryList.load();			//상품 문의.txt
		Main.reviewList = createObject.ReviewList.load();		//상품 리뷰.txt
		Main.trackingList = createObject.TrackingList.load();	//배송 데이터.txt
		
		Main.memberList=MemberList.load();			//회원데이터.txt
		Main.basketList = BasketList.load();		//장바구니 데이터.txt
		Main.orderList = createObject.OrderList.load();			//주문 데이터.txt
		Main.productList= createObject.ProductList.load();		//상품 데이터.txt
		Main.queryList = createObject.QueryList.load();			//상품 문의.txt
		Main.reviewList = createObject.ReviewList.load();		//상품 리뷰.txt
		Main.trackingList = createObject.TrackingList.load();	//배송 데이터.txt
		
		
		
		System.out.println(Main.basketList);								//장바구니 데이터.txt
		System.out.println(Main.basketList.get(0).getItemNumber());								//장바구니 데이터.txt
		Main.basketList.get(0).setItemNumber(2);
		System.out.println(Main.basketList.get(0).getItemNumber());								//장바구니 데이터.txt
		Main.basketList.get(0).setItemNumber(27);
		System.out.println(Main.basketList.get(0).getItemNumber());	
	}
}
