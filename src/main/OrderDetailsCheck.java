package main;
import java.io.BufferedReader;
import createObject.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 주문조회 클래스
 * @author 황현우
 *
 */
public class OrderDetailsCheck {
	
	//데이터를 조작 또는 읽어오는 경우 해당 회원의 정보만을 담은 ArrayList<Class>로 생성한다.
	
	//해당 user의 데이터
	private static int memberNumber;
	private static List<Order> orderList;
	private static List<Product> productList;
	private static List<Tracking> trackingList;
	
	
	/**
	 * 
	 * @return boolean 
	 * 주문 정보에서 밖으로 나갈시 false 반환
	 */
	public static boolean main() {									//	첫 실행 함수 나머지 함수들은 private로 서로를 호출하며 실행
		///////////////////////////////////////////////////////////////////////////////////////회원번호를 참조해서 해당 회원의 정보만 따로 저장하는 과정
		memberNumber = Main.memberNumber;							// 회원번호 숫자로 기입
		// 각각의 정보에 해당하는 list를 생성
		orderList 		= new ArrayList<Order>();
		productList 	= new ArrayList<Product>();
		trackingList	= new ArrayList<Tracking>();
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				//회원번호와 대조해서 주문리스트 복사.
		Main.orderList.stream().filter(o->o.getMemberNumber()==memberNumber).forEach(o->orderList.add(o));
				//주문번호와 대조해서 상품리스트 복사.
		Main.productList.stream().filter(p->{
			for(int i=0; i<orderList.size();i++) {
			if(orderList.get(i).getGoodsNumber()==p.getProductNum()) {
			return true;
			}
			}
			return false;
		}).forEach(p-> productList.add(p));
				// 전체 배송 상황에서 종일한 주문번호 데이터만 복사
		Main.trackingList.stream().filter(t->{
			for(int i=0;i<orderList.size();i++) {
			if(orderList.get(i).getOrderNumber()==t.getOrderNumber()) {
			return true;
			}
			}
			return false;
		}).forEach(t->trackingList.add(t));
		///////////////////////////////////////////////////////////////////////////////////////회원번호를 참조해서 해당 회원의 정보만 따로 저장하는 과정
		
//		System.out.println(orderList.toString());
//		System.out.println();
//		System.out.println(productList.toString());
//		System.out.println();
//		System.out.println(trackingList.toString());
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		orderMain();
		
		return true;
	}
	/**
	 * 뒤로가면 orderMain() 실행
	 */
	private static void details() {
		String productPath = ".\\txtData\\product\\";	// 뒤에 상품 코드.txt를 넣어서 확인한다
		Print.line(20);	
		System.out.print("주문번호입력 : ");						// 주문번호를 입력받으면 해당 번호를 주문 데이터에서 찾은뒤 상품코드를 반환
		String select = Main.scan.nextLine();
		int selectInt=0;
		try {
			selectInt=Integer.parseInt(select);
			int count =0;
			for(int i=0;i<orderList.size();i++) {
				if(selectInt==orderList.get(i).getOrderNumber()) {
					count++;											// 선택한 번호가 있는지 확인
					break;
				}
			}
			if(count==0) {
				System.out.println("주문번호를 확인해 주세요.");
				details();
			}
		}catch(Exception e) {
			System.out.println("주문번호를 확인해 주세요");
			details();
		}
		for(int i=0;i<orderList.size();i++) {
			if(orderList.get(i).getOrderNumber()==selectInt) {
				productPath+=orderList.get(i).getGoodsNumber()+"-";//상품번호 추가
				for(int j=0;j<productList.size();j++) {
					if(orderList.get(i).getGoodsNumber()==productList.get(j).getProductNum()) {
						productPath+=productList.get(j).getProductCode()+".txt";
					}
				}
				try {
					BufferedReader reader = new BufferedReader(new FileReader(productPath));
					String line = null;
					while((line=reader.readLine())!=null) {
						System.out.println(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}//if
		}
		Print.line(20);
		System.out.println("0.뒤로가기");
		System.out.println("1.구매 취소");
		System.out.println("2.리뷰 작성");
		Print.line(20);
		System.out.print("번호입력 : ");
		select = Main.scan.nextLine();
		int selectInt2=0;
		try {
			selectInt2=Integer.parseInt(select);
		}catch(Exception e){
			System.out.println("잘못 입력하셨습니다.");
			details();
		}
		switch(selectInt2) {
			case 0:
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				orderMain();								// 뒤로가기: 기본 주문 확인 페이지를 호출
				break;
			case 1:
				cancel(selectInt);								// 주문취소: 주문취소 함수 호출 선택한 주문번호를 넘김
				break;
			case 2:
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				review(selectInt);								// 리뷰: 리뷰 함수 호출 선택한 주문번호를 넘김
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				details();
				break;
		}
	}
	private static void cancel(int select) {
		
		Print.line(20);
		System.out.print("구매를 취소하시겠습니까? ( Y / N ) :");
		String selectCancle = Main.scan.nextLine();
		
		if(selectCancle.equals("y") || selectCancle.equals("Y")) {		// Y 구매 취소시 해당 주문번호의 배송현황을 확인하여 해당하는 모든 주문데이터 삭제
			
			// 삭제 해야되는 정보 => 주문정보 & 리뷰(현재 데이터로는 삭제 불가)..참조 불가 & 배송현황
			// 배송현황을 확인 후 출고 준비일 경우만 실행 
			//1. 배송현황을 확인하여 if 
			//2. list 수정 또는 주문번호의 데이터 삭제 
			boolean check = false;
			for(int i=0;i<trackingList.size();i++) {
				if(trackingList.get(i).getOrderNumber()==select
						&& trackingList.get(i).getDeliveryStatus().trim().equals("출고준비")) {//
					check=true;
				}
			}
			if(check) { // 취소가능
				int product = 0;
				for(int i=0;i<Main.orderList.size();i++) {
					if(Main.orderList.get(i).getOrderNumber() == select) {
						product = Main.orderList.get(i).getGoodsNumber();				// 상품 재고를 더하기 위해 상품 번호 가져오기
						Main.orderList.remove(i);										// 전체 list 에서 해당 주문번호 삭제
					}
				}
				for(int i=0;i<Main.trackingList.size();i++) {
					if(Main.trackingList.get(i).getOrderNumber() == select) {
						Main.trackingList.remove(i);									//전체 list 에서 해당 배송현황 상제
					}
				}
				
																						//전체 list 에서 상품 재고 1개 올리기
				for(int i=0;i<Main.productList.size();i++) {
					if(Main.productList.get(i).getProductNum()==product) {
//						System.out.println(Main.productList.get(i).toString());
						Main.productList.get(i).setProductStock(Main.productList.get(i).getProductStock()+1);
					}
				}
//				System.out.println("===================================================");
//				System.out.println(Main.productList.toString());
				
				///////////////////////////////////////////////////////////////////////////////////////////////////////////
				for(int i=0;i<orderList.size();i++) {
					if(orderList.get(i).getOrderNumber()==select) {						// 해당 회원의 주문번호 삭제 (내부 List)
						orderList.remove(i);
					}
				}
				for(int i=0;i<trackingList.size();i++) {
					if(trackingList.get(i).getOrderNumber()==select) {					// 해당 회원의 해당 배송현황 상제
						trackingList.remove(i);
					}
				}
				
				////////////////////////////////////////////////////						//파일 직접 조작 부분이라 주석 처리
				//파일 삭제
				// 읽어오면서 txt 에 저장하다가 select에 걸리면 공회전시킨다.
//				String orderPath = ".\\src\\project1\\주문데이터.txt";
//				String trackingPath = ".\\src\\project1\\tracking.txt";
//				try {
//					StringBuilder txt= new StringBuilder();
//					BufferedReader reader = new BufferedReader ( new FileReader(orderPath));
//					String line = null;
//					while((line=reader.readLine())!=null) {
//						String[] temp = line.split("▶");
//						if(Integer.parseInt(temp[0])==select) {
//							continue;
//						}else {
//							txt.append(line);
//							txt.append("\r\n");
//						}
//					}
//					BufferedWriter writer = new BufferedWriter( new FileWriter(orderPath));
//					writer.write(txt.toString());
//					writer.close();
//					//////////////////////////////////////////////////////////////////////////////주문 데이터 삭제
//					txt.delete(0, txt.length());
//					BufferedReader reader1 = new BufferedReader ( new FileReader(trackingPath));
//					String line1 = null;
//					while((line1=reader1.readLine())!=null) {
//						String[] temp = line1.split("▶");
//						if(Integer.parseInt(temp[0])==select) {
//							continue;
//						}else {
//							txt.append(line1);
//							txt.append("\r\n");
//						}
//					}
//					BufferedWriter writer1 = new BufferedWriter( new FileWriter(trackingPath));
//					writer1.write(txt.toString());
//					writer1.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
				////////////////////////////////////////////////////							//파일 직접 조작 부분이라 주석 처리
				
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("추문이 취소되었습니다. 주문 리스트로 돌아갑니다.");
				orderMain();
			}else {
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("주문하신 제품이 이미 출고되어 취소가 불가능 함니다. 주문 리스트로 돌아갑니다.");
				orderMain();
			}
		}else if(selectCancle.equals("n") || selectCancle.equals("N")){ // N 주문리스트로 다시 되 돌아감
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			orderMain();
		}else {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("잘못입력하셨습니다. 주문 리스트로 돌아갑니다.");
			orderMain();
		}
	}

	private static void review(int select) {
		// 1. 리뷰 데이터에 정보 추가
		// 2. (상품번호,회원번호,별점,리뷰 ) 작성
		String s= "                 _               \r\n"
				+ "  _ __ _____   _(_) _____      __\r\n"
				+ " | '__/ _ \\ \\ / / |/ _ \\ \\ /\\ / /\r\n"
				+ " | | |  __/\\ V /| |  __/\\ V  V / \r\n"
				+ " |_|  \\___| \\_/ |_|\\___| \\_/\\_/  \r\n"
				+ "                                 ";
		System.out.println(s);
		String reviewTxt="";
		int productNumber = 0;
//		String path= ".\\src\\txtData\\상품 리뷰.txt";					// 리스트만 조작할 것이기 때문에 주석처리
		for(int i=0;i<orderList.size();i++) {//주문 데이터 에서 주문 번호를 선택 한 뒤 해당 상품번호를 반환
			//회원번호 > 상품 코드 > 
			if(orderList.get(i).getOrderNumber()==select) {
				reviewTxt=orderList.get(i).getMemberNumber()+"▶";
				productNumber=orderList.get(i).getGoodsNumber();		// 해당 주문 번호의 상품번호 저장
				break;
			}
		}
		for(int i=0;i<productList.size();i++) {
			if(productNumber==productList.get(i).getProductNum()) {
				reviewTxt+=productList.get(i).getProductCode()+"▶";		// 가져온 상품 번호의 상품 코드 저장
			}
		}
		Print.line();
		int score =0;
		System.out.println("상품 평정을 선택해 주세요!!");
		System.out.println("1. 1점");
		System.out.println("2. 2점");
		System.out.println("3. 3점");
		System.out.println("4. 4점");
		System.out.println("5. 5점");
		System.out.print("입력 : ");
		try {
			score = Integer.parseInt(Main.scan.nextLine());
		}catch(Exception e) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("다시 선택해 주세요..!");
			review(select);
		}
		switch(score){
			case 1 : case 2 : case 3 : case 4 : case 5 :
			break;
			default :
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("다시 선택해 주세요..!");
				review(select);
		}
		// 별점
		reviewTxt+=score+"▶";
		Print.line();
		System.out.println("아래 리뷰를 작성 후 Enter 눌러 주세요!!");
		System.out.print("입력 :");
		reviewTxt+=Main.scan.nextLine();
		Print.line();
		
		String[] reviewArr = reviewTxt.split("▶");
		Main.reviewList.add(new Review(Integer.parseInt(reviewArr[0]),reviewArr[1],Integer.parseInt(reviewArr[2]),reviewArr[3]));
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("리뷰가 입력되었습니다. 주문 리스트로 돌아갑니다.");
		orderMain();
		//List 조작
		
//		try {																				// 파일을 직점 조작하는 부분이기 때문에 주석처리
//			BufferedWriter writer = new BufferedWriter(new FileWriter(path,true));
//			writer.write(reviewTxt+"\r\n");
//			writer.close();
//			System.out.println("리뷰가 입력되었습니다. 주문 리스트로 돌아갑니다.");
//			orderMain();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		// 직접 추가																		// 파일을 직점 조작하는 부분이기 때문에 주석처리
	}

	private static void orderMain() {
		
		///////////////////////////////////////////////////////////////////////		 삭제해도 되는부분																	
		String s = "   ___          _           \r\n"
				+ "  / _ \\ _ __ __| | ___ _ __ \r\n"
				+ " | | | | '__/ _` |/ _ \\ '__|\r\n"
				+ " | |_| | | | (_| |  __/ |   \r\n"
				+ "  \\___/|_|  \\__,_|\\___|_|   \r\n"
				+ "                            ";
		System.out.println(s);
		////////////////////////////////////////////////////////////////////////	삭제해도 되는부분
		Print.line(106);
		System.out.print("[주문일자]"); 
		Print.tap(); 
		System.out.print("[주문번호]");
		Print.tap(); 
		Print.tap(); 
		System.out.print("[상품명]");
		Print.tap(); 
		Print.tap(); 
		System.out.print("[수량]");
		Print.tap(); 
		Print.tap(); 
		System.out.print("[상품금액]");
		Print.tap(); 
		System.out.print("[배송현황]");
		System.out.println();
		
		for(int i=0; i<orderList.size();i++) { 																// 주문 내용만큼 돌리면서 출력함
			System.out.print(orderList.get(i).getOrderDate());						// 주문일
			Print.tap(); 
			System.out.print(String.format("%10d", orderList.get(i).getOrderNumber()));						// 주문번호
			Print.tap();
			Print.tap();
			System.out.print(productList.get(i).getProductCategory2Name());									//상품리스트의 카테고리2 번호를 참조하여 카테고리2List의 데이터 출력
			System.out.print(" "+productList.get(i).getProductName());										// 상문 이름 카테고리와 띄어쓰기함
			Print.tap(); 
			Print.tap(); 
			System.out.print(productList.get(i).getProductStock());											//상품 수량
			Print.tap(); 
			Print.tap(); 
			System.out.print(String.format("%,9d원", productList.get(i).getProductPrice()));				//가격을 원 , 를 이용하여 표현
			Print.tap();
			System.out.print(String.format("%-7s", trackingList.get(i).getDeliveryStatus()));				//배송현황을 trackingKList에서 가져옴
			System.out.println();
		}
		Print.line(106);
		
		System.out.println("0.뒤로가기");														
		System.out.println("1.상세조회");
		Print.line(20);	
		System.out.print("번호입력 : ");
		String select = Main.scan.nextLine();
		int selectInt=0;
		try {
			selectInt =Integer.parseInt(select);
		}catch(Exception e) {
			System.out.println("해당하는 번호를 눌러주세요.");
			orderMain();
		}
		System.out.println(selectInt);
		switch(selectInt) {
			case 0 : 
				return;
			case 1 :
				details();																					// 상세정보 선택시 detail 함수를 호출
				break;
			default:
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println("해당하는 번호를 눌러주세요.");
				orderMain();
				break;
			}
	}
	
	
}

class Print{
	public static void line() {
		
		for(int i=0;i<50;i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	public static void line(int num) {
		
		for(int i=0;i<num;i++) {
			System.out.print("=");
		}
		System.out.println();
	}
	public static void tap() {
		System.out.print("\t");
	}
	public static void tap(int num) {
		for(int i=0;i<num;i++) {
			System.out.print("\t");
		}
	}
}
