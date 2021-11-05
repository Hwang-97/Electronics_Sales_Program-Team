package main;

import java.util.ArrayList;
import java.util.List;

import createObject.Product;
import createObject.ProductList;

public class AddProduct {
	
	private static String checkCode;
	private static String checkName;
	private static String checkModel;
	private static Product p;
	
	public static boolean main() {
		checkCode="";
		checkName="";
		checkModel="";
		p = new Product();
		printMain();
		
		if(addP()) {
			return true;
		}
		
		boolean loop = true;
		while (loop) {
			System.out.println();
			System.out.println("───────────── [ 상품정보를 등록하시겠습니까? ] ──────────");
			menuMain();
			System.out.print("선택: ");
			int sel = Main.inputUserNum(0, 1);
			Main.scan.nextLine();
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n");

			switch (sel) {
			case 0: //종료
				loop = false;
				break;
			case 1: //상품추가
				loop = resultAdd();
				break;
			}
		}
		return true;
	}

	private static boolean addP() {
		boolean flag = true;
		int pos = 0;
		
		while(flag) {
			switch(pos) {
			
				case 0:
					flag = getCotegory1();
					if(flag) {
						pos++;
					}else {
						return true;
					}
					break;
				case 1:
					flag = getCotegory2();
					if(flag) {
						pos++;
					}else {
						return true;
					}
					break;
				case 2:
					flag = getProductName();
					if(flag) {
						pos++;
					}else {
						return true;
					}
					break;
				case 3:
					flag = getModel();
					if(flag) {
						pos++;
					}else {
						return true;
					}
					break;
				case 4:
					flag = getPrice();
					if(flag) {
						pos++;
					}else {
						return true;
					}
					break;
				case 5:
					flag = getStoc();
					if(flag) {
						pos++;
					}else {
						return true;
					}
					break;
				case 6:
					flag = getDiscount();
					if(flag) {
						pos++;
					}else {
						return true;
					}
					break;
				case 7:
					flag = getProductCode();
					if(flag) {
						pos++;
					}else {
						return true;
					}
					break;
				default:
					flag = false;
					break;
			}
		}
		
		p.setProductNum(Main.productList.size()+1);
		p.setProductOrderNum(0);
		p.setProductRefundNum(0);
		return flag;
	}
	
	private static boolean resultAdd() {
		Main.productList.add(p);
		System.out.println("상품이 추가되었습니다. 상품관리로 돌아갑니다.");
		return false;
	}

	private static boolean getDiscount() {
		System.out.println("─────────────── [ 상품 할인율 입력( % ) ] ───────────────");
		System.out.println();
		System.out.println("[상품등록을 취소하고싶으시면 N을 입력 후 Enter 하세요.]");
		System.out.println();
		System.out.print("입력 : ");
		try {
			String discount = Main.scan.nextLine();
			discount.trim();
			if(discount.equals("N")||discount.equals("n")) {
				System.out.println("상품등록이 취소되었습니다.");
				return false;
			}else if(discount.matches("[0-9]+")) {
				if(Integer.parseInt(discount)>100) {
					System.out.println("할인율은 100%를 초과할 수 없습니다.");
					return getDiscount();
				}else if(Integer.parseInt(discount)<0) {
					System.out.println("할인율은 0%를 미만일 수 없습니다.");
					return getDiscount();
				}else {
					if(discount.equals("0")) {
						p.setProductSale(0.0);
						return true;
					}else {
						p.setProductSale(Double.parseDouble(discount)/100);
						return true;
					}
				}
			}else {
				System.out.println("숫자만 입력해 주세요.");
				return getDiscount();
			}
		}catch(Exception e) {
			System.out.println("내용을 입력해 주세요");
			return getDiscount();
		}
	}

	private static boolean getStoc() {
		System.out.println("─────────────── [ 상품 재고 입력( 개 ) ] ───────────────");
		System.out.println();
		System.out.println("[상품등록을 취소하고싶으시면 0을 입력 후 Enter 하세요.]");
		System.out.println();
		System.out.print("입력 : ");
		try {
			String stoc1 = Main.scan.nextLine();
			stoc1.trim();
			if(stoc1.equals("0")) {
				System.out.println("상품등록이 취소되었습니다.");
				return false;
			}else if(stoc1.matches("[0-9]+")) {
				p.setProductStock(Integer.parseInt(stoc1));
				return true;
			}else {
				System.out.println("숫자만 입력해 주세요.");
				return getStoc();
			}
		}catch(Exception e) {
			System.out.println("내용을 입력해 주세요");
			return getStoc();
		}
	}

	private static boolean getPrice() {
		System.out.println("─────────────── [ 상품 가격 입력( 원 ) ] ───────────────");
		System.out.println();
		System.out.println("[상품등록을 취소하고싶으시면 0을 입력 후 Enter 하세요.]");
		System.out.println();
		System.out.print("입력 : ");
		String price="";
		try {
			price = Main.scan.nextLine();
			price.trim();
			if(price.equals("0")) {
				System.out.println("상품등록이 취소되었습니다.");
				return false;
			}else if(price.matches("[0-9]+")) {
				p.setProductPrice(Integer.parseInt(price));
				return true;
			}else {
				System.out.println("숫자만 입력해 주세요.");
				return getPrice();
			}
		}catch(Exception e) {
			System.out.println("내용을 입력해 주세요");
			return getPrice();
		}
	}

	private static boolean getModel() {
		System.out.println("────────────────── [ 상품 모델 입력 ] ──────────────────");
		System.out.println();
		System.out.println("[상품등록을 취소하고싶으시면 0을 입력 후 Enter 하세요.]");
		System.out.println();
		System.out.print("입력 : ");
		try {
			String model = Main.scan.nextLine();
			model.trim();
			if(model.equals("0")) {
				System.out.println("상품등록이 취소되었습니다.");
				return false;
			}else {
				p.setProductModel(model);
				checkModel = model;
				return true;
			}
		}catch(Exception e) {
			System.out.println("내용을 입력해 주세요");
			return getModel();
		}
	}

	private static boolean getProductCode() {
		System.out.println(checkCode);
		// 코드 앞자리와 이름 비교
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<Main.productList.size();i++) {
			if(Main.productList.get(i).getProductCode().substring(0,2).equals(checkCode)
					&& Main.productList.get(i).getProductName().equals(checkName)) {
				checkCode+="-"+Main.productList.get(i).getProductCode().substring(3,6);
				break;
			}else if(Main.productList.get(i).getProductCode().substring(0,2).equals(checkCode)
					&& !(Main.productList.get(i).getProductName().equals(checkName))) {
				list.add(Integer.parseInt(Main.productList.get(i).getProductCode().substring(3,6)));
				continue;
			}else {
				continue;
			}
		}
		// 이때 동일한 정보를 받아서 코드가 수정됐는지 확인
		if(checkCode.length()!=6) {
			list.sort((p1,p2)->p2-p1);
			checkCode+="-"+String.format("%03d", (list.get(0)+1));
		}
		// 이제 코드 마지막 값을 받아야 됨
		// 이제 싱품명 , 00-000까지의 상품코드 , 해당 모델명 을 받은 후 모델명이 같다면 동일상품이 존재함으로 종료 모델명이 다르다면 list에 추가 후 가장 큰수 +1한다
		int count=0;
		for(int i=0;i<Main.productList.size();i++) {
			if(Main.productList.get(i).getProductName().equals(checkName)
					&& Main.productList.get(i).getProductCode().substring(0,6).equals(checkCode)
					&& Main.productList.get(i).getProductModel().equals(checkModel)) {
				System.out.println("이미 존재하는 상품을 입력하였습니다. 상품관리 메뉴로 돌아갑니다.");
				return false;
			}else if(Main.productList.get(i).getProductName().equals(checkName)
					&& Main.productList.get(i).getProductCode().substring(0,6).equals(checkCode)
					&& !(Main.productList.get(i).getProductModel().equals(checkModel))) {
				count++;
				continue;
			}else {
				continue;
			}
		}
		checkCode+="-"+count;
		p.setProductCode(checkCode);
		return true;
	}

	private static boolean getProductName() {
		System.out.println("────────────────── [ 상품 이름 입력 ] ──────────────────");
		System.out.println();
		System.out.println("[상품등록을 취소하고싶으시면 0을 입력 후 Enter 하세요.]");
		System.out.println();
		System.out.print("입력 : ");
		try {
			String name = Main.scan.nextLine();
			name.trim();
			if(name.equals("0")) {
				System.out.println("상품등록이 취소되었습니다.");
				return false;
			}else {
				p.setProductName(name);
				checkName = name;
				return true;
			}
		}catch(Exception e) {
			System.out.println("내용을 입력해 주세요");
			return getProductName();
		}
	}
	private static boolean getCotegory2() {
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
		}catch(Exception e) {
			System.out.println("해당하는 번호를 눌러주세요.");
			return getCotegory2();
		}
		if(sel==0) {
			System.out.println("상품등록이 취소되었습니다.");
			return false;
		}else if(0<sel&&sel<=ProductList.CName2.length){
			p.setProductCategory2(""+sel);
			checkCode +=sel;
			return true;						
		}else {
			System.out.println("해당하는 번호를 눌러주세요.");
			return getCotegory2();
		}
	}
	private static boolean getCotegory1() {
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
		}catch(Exception e) {
			System.out.println("해당하는 번호를 눌러주세요.");
			return getCotegory1();
		}
		if(sel==0) {
			System.out.println("상품등록이 취소되었습니다.");
			return false;
		}else if(0<sel&&sel<=ProductList.CName1.length){
			p.setProductCategory1(""+sel);
			checkCode +=sel;
			return true;			
		}else {
			System.out.println("해당하는 번호를 눌러주세요.");
			return getCotegory1();
		}
	}
	private static void menuMain() {
		
//		System.out.println("───────────────── [ 메뉴 목록 ] ─────────────────");
		System.out.println("0. 아니요");
		System.out.println("1. 예");
		System.out.println("──────────────────────────────────────────────────────────");
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
		System.out.println("──────────────────── [ 상품 등록 ] ────────────────────");
		// TODO figlet으로 상품조회 이미지 넣기
	}
	private static void line() {
		
		for(int i=0;i<10;i++) {
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
