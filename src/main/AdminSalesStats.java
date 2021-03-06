package main;

import java.util.Calendar;


/**
 * 
 * @author 황현우	
 *관리자 로그인 후 통계를 반환하는 클래스
 */
public class AdminSalesStats {
	
	
	/**
	 * 
	 * 
	 * @return boolean
	 * 
	 * 모든 관련 클래스들 끼리 상호작용하며 최종적으로 해당 화면을 나올시 true를 반환한다.
	 */
	public static boolean main() {
		
		boolean loop = true;
		
		while (loop) {
			printMain();
//			printStat();
			menuMain();

			System.out.print("선택: ");
			int sel = Main.inputUserNum(0,3);
			Main.scan.nextLine();
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n");

			switch (sel) {
			case 0: 
				loop = false;
				break;
			case 1: 
				loop =AdminTotalSalesStats.main();
				break;
			case 2: 
				loop = AdminYearSalesStats.main();
				break;
			case 3: //년간
				loop = AdminMonthSalesStats.main();
				break;
			}
		}
		return true;
	}
	
	private static void menuMain() {
		
		// 메인
		// 메뉴출력
		Calendar c = Calendar.getInstance();
		String s = String.format("%tF", c);
		String year = s.substring(0,4);
		String month = s.substring(5,7);
		System.out.println("───────────────── [ 매출 통계 ] ─────────────────");
		System.out.println("0. 뒤로가기");
		System.out.println("1. Total 매출");
		System.out.println("2. "+year+"년 매출");
		System.out.println("3. "+month+"월 매출");
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
}
