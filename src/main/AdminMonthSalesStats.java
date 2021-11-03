package main;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;

/**
 * 
 * @author 황현우	
 *관리자 로그인 후 통계를 반환하는 클래스
 */
public class AdminMonthSalesStats {
	
	private static long totalSales;
	public static boolean main() {
		
		boolean loop = true;
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n");
		
		while (loop) {
			printMain();
			printStat();
			menuMain();

			System.out.print("선택: ");
			int sel = Main.inputUserNum(0,1);
			Main.scan.nextLine();
			

			switch (sel) {
			case 0: //종료
				loop = false;
				break;
			case 1: //종료
				loop = getProduct();
				break;
			}
		}
		return true;
	}
	private static void printStat() {
		
		totalSales=0;
		
		//성별 나이 카테고리..? 인기순
		System.out.println("[분류]");
		System.out.println();
		getGender();
		line(87);
		getAge();
		line(87);
		getCategory1();
		line(87);
		getCategory2();
		line(87);
		System.out.println();
		System.out.printf("총 누적 매출액 : %,d원\r\n",totalSales);
		System.out.println();
	}
	private static boolean getProduct() {
		line(87);
		AdminStats.currenMonthProductStats.sort((p1,p2)->p2.getProductOrderNum()-p1.getProductOrderNum());
		System.out.println("[인기순]");
		AdminStats.currenMonthProductStats.stream().map(p->p.getProductCategory2Name()+" "+p.getProductName()+" "+String.format("\t\t%,20d원", p.getProductPrice()*p.getProductOrderNum())).forEach(name -> System.out.println("\t"+name));
		System.out.println("───────────────── [ 메뉴 목록 ] ─────────────────");
		System.out.println("0. 뒤로가기");
		System.out.println("──────────────────────────────────────────────────");
		System.out.print("선택: ");
		int sel = Main.inputUserNum(0,0);
		Main.scan.nextLine();
		if(sel==0) {
			return true;
		}
		return true;
	}
	private static void getCategory2() {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		System.out.println("[카테고리 2]");
		for(int i=0; i<AdminStats.currenMonthProductStats.size();i++) {
			String key =AdminStats.currenMonthProductStats.get(i).getProductCategory2Name();
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+AdminStats.currenMonthProductStats.get(i).getProductPrice());
			}else {
				map.put(key, AdminStats.currenMonthProductStats.get(i).getProductPrice());
			}
		}
		Set<String> set = map.keySet();
		for(String s : set) {
			System.out.printf("\t%-5s \t\t%,10d원\r\n",s,map.get(s));
		}
		System.out.println();
	}

	private static void getCategory1() {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		System.out.println("[카테고리 1]");
		for(int i=0; i<AdminStats.currenMonthProductStats.size();i++) {
			String key =AdminStats.currenMonthProductStats.get(i).getProductCategory1Name();
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+AdminStats.currenMonthProductStats.get(i).getProductPrice());
			}else {
				map.put(key, AdminStats.currenMonthProductStats.get(i).getProductPrice());
			}
		}
		Set<String> set = map.keySet();
		for(String s : set) {
			System.out.printf("\t%-5s \t\t%,10d원\r\n",s,map.get(s));
		}
		System.out.println();
	}
	
	private static void getAge() {
		int teenager=0;
		int twenties=0;
		int thirties=0;
		int forties =0;
		int fifties=0;
		int old=0;
		
		Calendar c = Calendar.getInstance();
		int now = Integer.parseInt(String.format("%tF", c).substring(0,4));		// 현재년도
														// 각각 카운트 한 뒤 저장
		int age=0;										// 나이 변환할 곳
		
		System.out.println("[나이]");
		tap();
		for(int i=0;i<AdminStats.currenMonthMember.size();i++) {
			int year = 0;
			String total = AdminStats.currenMonthMember.get(i).getRegistrationNumber().substring(0,2);
			total = total.substring(0,1).equals("0")? "20"+total : "19"+total;
			year=Integer.parseInt(total);
			age=(now-year)/10;
			switch(age) {
				case 1:
					teenager+=AdminStats.currenMonthMember.get(i).getTotalMoney();
					break;
				case 2:
					twenties+=AdminStats.currenMonthMember.get(i).getTotalMoney();
					break;
				case 3:
					thirties+=AdminStats.currenMonthMember.get(i).getTotalMoney();
					break;
				case 4:
					forties+=AdminStats.currenMonthMember.get(i).getTotalMoney();
					break;
				case 5:
					fifties+=AdminStats.currenMonthMember.get(i).getTotalMoney();
					break;
				default:
					old+=AdminStats.currenMonthMember.get(i).getTotalMoney();
					break;
			}
		}
		System.out.printf("[10대%,10d원] ",teenager);
		System.out.printf("[20대%,10d원] ",twenties);
		System.out.printf("[30대%,10d원] ",thirties);
		System.out.printf("[40대%,10d원] ",forties);
		System.out.printf("[50대%,10d원] ",fifties);
		System.out.printf("[60세이상 %,10d원]",old);
		System.out.println();
	}
	private static void getGender() {
		System.out.println("[성별]");
		tap();
		
		int money=0;
		for(int i=0;i<AdminStats.currenMonthMember.size();i++) {
			if(AdminStats.currenMonthMember.get(i).getGender().equals("M")) {
				money+=AdminStats.currenMonthMember.get(i).getTotalMoney();
			}
		}
		System.out.printf("남자 : %,10d원",money);
		tap();
		tap();
		totalSales+=money;
		money=0;
		for(int i=0;i<AdminStats.currenMonthMember.size();i++) {
			if(AdminStats.currenMonthMember.get(i).getGender().equals("F")) {
				money+=AdminStats.currenMonthMember.get(i).getTotalMoney();
			}
		}
		System.out.printf("여자 : %,10d원",money);
		totalSales+=money;
		System.out.println();
	}

	private static void menuMain() {
		
		// 메인
		// 메뉴출력
		
		System.out.println("───────────────── [ 매출 통계 ] ─────────────────");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 인기상품순 통계");
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
