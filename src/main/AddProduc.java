package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import createObject.Product;
import createObject.ProductList;
import jdk.internal.misc.FileSystemOption;

public class AddProduc {
	//상품정보를 담고있는 Product 타입의 정보를 만들고 List에 추가
	private static String checkCode;
	private static String checkName;
	
	static {
		checkCode="";
		checkName="";
	}
	public static boolean main() {
		
//		printMain();
		
//		addPoduct();
		return true;
	}
	private static boolean addPoduct() {
		/*
		 * 상품추가 , 상품검색 , 전체상품검색 , 문의관리
		 * p.setProductNum(Integer.parseInt(temp[0]));
				p.setProductCode(temp[1]);
				p.setProductName(temp[2]);
				p.setProductModel(temp[3]);
				
//				TODO 참고* 나중에 상품목록 출력할 때 아래 구문 참고해서 사용 (숫자 카테고리 > 실제 이름으로 변형하는 구문)
				p.setProductCategory1(temp[4]);
				p.setProductCategory2(temp[5]);
				p.setProductPrice(Integer.parseInt(temp[6]));
				p.setProductStock(Integer.parseInt(temp[7]));
				p.setProductSale(Double.parseDouble(temp[8]));
				p.setProductOrderNum(Integer.parseInt(temp[9]));
				p.setProductRefundNum(Integer.parseInt(temp[10]));
				
				1. 상품 번호는 productList.size()+1로 한다.
				2. 해당 정보는 productList.add(productList.size()) 방에 넣는다.
				3. setProductOrderNum setProductRefundNum ==0 환분횟수와 주문 횟수는 0을 넣는다.
				4. 카테고리1 카테고리2 동일시 상품코드 중간값확인 후 마지막 값에 +1
				5. 카테고리1 카테고리2 이름 상품코드 중간값확인 동일 시 모델넘버의 마지막 숫자 확인 후 +1 한다
		 */
		Product p = new Product();
//		p.setProductCategory1(getCotegory1());
//		System.out.println(getCotegory1());
//		p.setProductCategory2(getCotegory2());
//		System.out.println(getCotegory2());
//		p.setProductName(getProductName());
//		System.out.println(getProductName());
//		p.setProductCode(getCheckCode());
//		System.out.println(getCheckCode());
		
		
		
		
		return false;
	}
	//카테고리 정보가 같을경우 이름을 확인 후 이름도 동일한 경우 중간 갑은 같고 이름이 없을 경우 중간값 상승 이후 ****모든 정보가 같고 모델이 같으면 잘못됨 ****** 무조건 마지막 모델 자리는 증가
//	private static String getCheckCode() {
//		// 현재 카테고리 정보가 저장 되었기 때문에 상품코드의 0~1 까지의 코드와 비교한 뒤 동일한 갑을 모두 가져온다.
//		ArrayList<Integer> uniqueArr = new ArrayList<Integer>();
//		for(int i = 0;i<Main.productList.size();i++) {
//			String check = Main.productList.get(i).getProductCode().substring(0,2);
//			if(check.equals(checkCode)&&Main.productList.get(i).getProductName().equals(checkName)) {
//				checkCode+="-"+Main.productList.get(i).getProductCode().substring(3,6);
//				break;
//			}else if(check.equals(checkCode)&&!Main.productList.get(i).getProductName().equals(checkName)) {
//				uniqueArr.add(Integer.parseInt(Main.productList.get(i).getProductCode().substring(3,6)));
//			}
//		}
//		
//		
//		return "확인";
//	}
	private static String getProductName() {
		System.out.println("───────────────── [ 상품 이름 입력 ] ─────────────────");
		System.out.println("[상품입력을 취소하고싶으시면 0을 입력 후 Enter 하세요.]");
		System.out.print("입력 : ");
		try {
			String name = Main.scan.nextLine();
			name.trim();
			if(name.equals("0")) {
				System.out.println("상품등록이 취소되었습니다.");
				AdminProduct.main();
			}else {
				checkName = name;
				return name;
			}
		}catch(Exception e) {
			System.out.println("내용을 입력해 주세요");
			getProductName();
		}
		return null;
	}
	private static String getCotegory2() {
		System.out.println("───────────────── [ 카테고리 2 선택 ] ─────────────────");
		System.out.println();
		System.out.println("0. 뒤로가기");
		for(int i=0; i<ProductList.CName2.length;i++) {
			System.out.printf("%d. %s\r\n",i+1,ProductList.CName2[i]);
		}
		line();
		System.out.print("입력: ");
		int sel =0;
		try {
			sel = Integer.parseInt(Main.scan.nextLine());
			checkCode +=sel;
		}catch(Exception e) {
			System.out.println("해당하는 번호를 눌러주세요.");
			getCotegory1();
		}
		if(sel==0) {
			System.out.println("상품등록이 취소되었습니다.");
			AdminProduct.main();
		}else if(0<sel&&sel<=ProductList.CName2.length){
			return ProductList.CName2[sel-1];
		}else {
			System.out.println("해당하는 번호를 눌러주세요.");
			getCotegory1();
		}
		return null;
	}
	private static String getCotegory1() {
		System.out.println("───────────────── [ 카테고리 1 선택 ] ─────────────────");
		System.out.println();
		System.out.println("0. 뒤로가기");
		for(int i=0; i<ProductList.CName1.length;i++) {
			System.out.printf("%d. %s\r\n",i+1,ProductList.CName1[i]);
		}
		line();
		System.out.print("입력: ");
		int sel =0;
		try {
			sel = Integer.parseInt(Main.scan.nextLine());
			checkCode +=sel;
		}catch(Exception e) {
			System.out.println("해당하는 번호를 눌러주세요.");
			getCotegory1();
		}
		if(sel==0) {
			System.out.println("상품등록이 취소되었습니다.");
			AdminProduct.main();
		}else if(0<sel&&sel<=ProductList.CName1.length){
			return ProductList.CName1[sel-1];
		}else {
			System.out.println("해당하는 번호를 눌러주세요.");
			getCotegory1();
		}
		return null;
	}
	
	private static void menuMain() {
		
		// 메인
		// 메뉴출력
		// 
		/*
		 * 
		 */
		
		System.out.println("───────────────── [ 메뉴 목록 ] ─────────────────");
		System.out.println("0. 아니요");
		System.out.println("1. 예");
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
		System.out.println("───────────────── [ 상품 관리 ] ─────────────────");
		// TODO figlet으로 상품조회 이미지 넣기
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
	private static void tap() {
		System.out.print("\t");
	}
	private static void tap(int num) {
		for(int i=0;i<num;i++) {
			System.out.print("\t");
		}
	}
}
