package main.admin.stats;

import java.util.Calendar;


import main.Main;

/**
 * 
 * @author 황현우	
 *관리자 로그인 후 통계를 반환하는 클래스
 */
public class AdminTotalSalesStats {
	/**
	 * 
	 * 
	 * @return boolean
	 * 
	 * 모든 관련 클래스들 끼리 상호작용하며 최종적으로 해당 화면을 나올시 true를 반환한다.
	 */
	private static long totalSales;
	public static boolean main() {
		
		boolean loop = true;
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n");
		
		while (loop) {
			printMain();
//			printStat();
			menuMain();

			System.out.print("선택: ");
<<<<<<< HEAD:src/main/AdminSalesStats.java
			int sel = Main.inputUserNum(0,3);
=======
			int sel = Main.inputUserNum(0,1);
>>>>>>> refs/remotes/origin/develop:src/main/admin/stats/AdminTotalSalesStats.java
			Main.scan.nextLine();
			

			switch (sel) {
			case 0: 
				loop = false;
				break;
<<<<<<< HEAD:src/main/AdminSalesStats.java
			case 1: 
				loop =AdminTotalSalesStats.main();
				break;
			case 2: 
				loop = AdminYearSalesStats.main();
				break;
			case 3: //년간
				loop = AdminMonthSalesStats.main();
=======
			case 1: //종료
				loop = getProduct();
>>>>>>> refs/remotes/origin/develop:src/main/admin/stats/AdminTotalSalesStats.java
				break;
			}
		}
		return true;
	}
<<<<<<< HEAD:src/main/AdminSalesStats.java
	
=======
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
		AdminStats.productStats.sort((p1,p2)->p2.getProductOrderNum()-p1.getProductOrderNum());
		System.out.println("[인기순]");
		AdminStats.productStats.stream().map(p->p.getProductCategory2Name()+" "+p.getProductName()+" "+String.format("\t\t%,20d원", p.getProductPrice()*p.getProductOrderNum())).forEach(name -> System.out.println("\t"+name));
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
		for(int i=0; i<AdminStats.productStats.size();i++) {
			String key =AdminStats.productStats.get(i).getProductCategory2Name();
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+AdminStats.productStats.get(i).getProductPrice());
			}else {
				map.put(key, AdminStats.productStats.get(i).getProductPrice());
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
		for(int i=0; i<AdminStats.productStats.size();i++) {
			String key =AdminStats.productStats.get(i).getProductCategory1Name();
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+AdminStats.productStats.get(i).getProductPrice());
			}else {
				map.put(key, AdminStats.productStats.get(i).getProductPrice());
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
		for(int i=0;i<AdminStats.memberstat.size();i++) {
			int year = 0;
			String total = AdminStats.memberstat.get(i).getRegistrationNumber().substring(0,2);
			total = total.substring(0,1).equals("0")? "20"+total : "19"+total;
			year=Integer.parseInt(total);
			age=(now-year)/10;
			switch(age) {
				case 1:
					teenager+=AdminStats.memberstat.get(i).getTotalMoney();
					break;
				case 2:
					twenties+=AdminStats.memberstat.get(i).getTotalMoney();
					break;
				case 3:
					thirties+=AdminStats.memberstat.get(i).getTotalMoney();
					break;
				case 4:
					forties+=AdminStats.memberstat.get(i).getTotalMoney();
					break;
				case 5:
					fifties+=AdminStats.memberstat.get(i).getTotalMoney();
					break;
				default:
					old+=AdminStats.memberstat.get(i).getTotalMoney();
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
		for(int i=0;i<AdminStats.memberstat.size();i++) {
			if(AdminStats.memberstat.get(i).getGender().equals("M")) {
				money+=AdminStats.memberstat.get(i).getTotalMoney();
			}
		}
		System.out.printf("남자 : %,10d원",money);
		tap();
		tap();
		totalSales+=money;
		money=0;
		for(int i=0;i<AdminStats.memberstat.size();i++) {
			if(AdminStats.memberstat.get(i).getGender().equals("F")) {
				money+=AdminStats.memberstat.get(i).getTotalMoney();
			}
		}
		System.out.printf("여자 : %,10d원",money);
		totalSales+=money;
		System.out.println();
	}

>>>>>>> refs/remotes/origin/develop:src/main/admin/stats/AdminTotalSalesStats.java
	private static void menuMain() {
		
		// 메인
		// 메뉴출력
		Calendar c = Calendar.getInstance();
		String s = String.format("%tF", c);
		String year = s.substring(0,4);
		String month = s.substring(5,7);
		System.out.println("───────────────── [ 매출 통계 ] ─────────────────");
		System.out.println("0. 뒤로가기");
<<<<<<< HEAD:src/main/AdminSalesStats.java
		System.out.println("1. Total 매출");
		System.out.println("2. "+year+"년 매출");
		System.out.println("3. "+month+"월 매출");
=======
		System.out.println("1. 인기상품순 통계");
>>>>>>> refs/remotes/origin/develop:src/main/admin/stats/AdminTotalSalesStats.java
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
<<<<<<< HEAD:src/main/AdminSalesStats.java
=======
	
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

>>>>>>> refs/remotes/origin/develop:src/main/admin/stats/AdminTotalSalesStats.java
}
