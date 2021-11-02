//package main;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
//import createObject.Product;
//
//public class ItemSearch // 상품 조회
//{
//	public static void main() throws Exception
//	{
//		Main.searchProduct.showProductList(); // 상품 목록 전체 출력
//		
//		menuItemSearch1(); // 카테고리1 메뉴 출력
//		System.out.print("번호 입력 : ");
//		int category1 = main.searchProduct.inputCategoryNum(); // 유효성 검사
//		
//		if(category1 == 0) // 0 : 뒤로가기
//		{
//			Func.Main.main(); // 메인으로 뒤로가기
//		}
//		
//		menuItemSearch2(); // 카테고리2 메뉴 출력
//		System.out.print("번호 입력 : ");
//		int category2 = main.searchProduct.inputCategoryNum(); // 유효성 검사
//		
//		if(category2 == 0) // 0 : 뒤로가기
//		{
//			Func.ItemSearch.main(); // 카테고리1 메뉴로 뒤로가기
//		}
//		
//		main.searchProduct.showProductList(category1, category2); // 카테고리1, 카테고리2 에 해당하는 상품 목록 출력
//		
//		menuItemSearch3(); // 카테고리3 (추가 메뉴) 출력
//		
//		System.out.print("번호 입력 : ");
//		Scanner scanner = new Scanner(System.in);
//		
//		if(!scanner.hasNextInt())
//		{
//			System.out.println("잘못된 번호입니다");
//			Func.Main.main();
//		}
//		int num = scanner.nextInt();
//		//----------------------------------
//		
//		switch(num)
//		{
//			case 0:
//				Func.Main.main();
//				break;
//			case 1:
//				
//				ArrayList<Product> temp = new ArrayList<Product>();
//				
//				for (Product p : main.main.productList) 
//				{
//					if(Integer.parseInt(p.getProductCategory1()) == category1 && Integer.parseInt(p.getProductCategory2()) == category2) 
//					{
//						/*
//						System.out.printf("%s\t" 	//상품번호
//										+ "%s\t"	//상품코드
//										+ "%s\t"	//상품명
//										+ "%s\t"	//모델이름
//										+ "%s\t"	//카테고리1
//										+ "%s\t"	//카테고리2
//										+ "%,8d원\t"	//가격
//										+ "%s개\t"	//재고
//										+ "%s%%\t"	//할인율
//										+ "%s회\t"	//주문횟수
//										+ "%s회\n"	//환불횟수
//										,p.getProductNum()
//										,p.getProductCode()
//										,p.getProductName()
//										,p.getProductModel()
//										,p.getProductCategory1Name()
//										,p.getProductCategory2Name()
//										,p.getProductPrice()
//										,p.getProductStock()
//										,p.getProductSale()*100
//										,p.getProductOrderNum()
//										,p.getProductRefundNum());
//						*/
//						temp.add(p);
//					}
//				}
//				
//				Collections.sort(temp);
//				
//				System.out.println("상품번호\t상품코드\t\t상품명\t모델이름\t카테고리1\t카테고리2\t가격\t재고\t할인율\t주문횟수\t환불횟수");
//				for(int i=0; i<temp.size(); i++)
//				{
//					System.out.println(temp.get(i).toString());
//				}
//				break;
//			case 2:
//				System.out.println("최저가순");
//				break;
//			case 3:
//				System.out.println("최고가순");
//				break;
//			case 4:
//				System.out.println("상세조회");
//				break;
//			default:
//				System.out.println("잘못된 번호입니다");
//				Func.Main.main();
//				break;
//		}
//	}
//	private static void menuItemSearch1()
//	{
//		System.out.println();
//		System.out.println();
//		System.out.println("#####카테고리1#####");
//		System.out.println("0. 뒤로가기");
//		System.out.println("1. 모니터");
//		System.out.println("2. 노트북");
//		System.out.println("3. 마우스");
//		System.out.println("4. 키보드");
//		System.out.println("5. 헤드셋");
//		System.out.println("6. 핸드폰");
//		System.out.println();
//	}
//	private static void menuItemSearch2()
//	{
//		System.out.println();
//		System.out.println();
//		System.out.println("#####카테고리2#####");
//		System.out.println("0. 뒤로가기");
//		System.out.println("1. 삼성");
//		System.out.println("2. Apple");
//		System.out.println("3. 로지텍");
//		System.out.println("4. LG");
//		System.out.println("5. MSI");
//		System.out.println("6. ASUS");
//		System.out.println();
//	}
//	private static void menuItemSearch3()
//	{
//		System.out.println();
//		System.out.println("#####상품조회#####");
//		System.out.println("0. 뒤로가기");
//		System.out.println("1. 인기순");
//		System.out.println("2. 최저가순");
//		System.out.println("3. 최고가순");
//		System.out.println("4. 상세조회");
//		System.out.println();
//	}
//}