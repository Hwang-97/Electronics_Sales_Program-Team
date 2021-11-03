package main.admin.stats;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Set;

import createObject.Member;
import main.Main;
/**
 * 
 * @author 황현우	
 *관리자 로그인 후 통계를 반환하는 클래스
 */
public class AdminMemberStats {
	
	
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
			printStat();
			menuMain();

			System.out.print("선택: ");
			int sel = Main.inputUserNum(0,0);
			Main.scan.nextLine();
			
			System.out.println("\n\n\n\n\n\n\n\n\n\n");

			switch (sel) {
			case 0: //종료
				loop = false;
				break;
			}
		}
		return true;
	}
	
	private static void printStat() {
		
		System.out.println("[분류]");
		System.out.println();
		getGenderAge("M");
		line(87);
		getGenderAge("F");
		line(87);
		getAddress();
		line(87);
		getPayment();
	}
	

	private static void getPayment() {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0;i<Main.orderList.size();i++) {
			String s =Main.orderList.get(i).getSelectPayment();
			if(map.containsKey(s)) {
				map.put(s, map.get(s)+1);
			}else {
				map.put(s, 1);
			}
		}
		Set<String> key = map.keySet();
		for(String s : key) {
			System.out.printf("\t%-5s \t\t%3d명\r\n",s,map.get(s));
		}
	}

	private static void getAddress() {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		String address="";
		System.out.println("[소비지역]");
		for(int i=0;i<Main.memberList.size();i++) {
			address=Main.memberList.get(i).getAddress().substring(0,Main.memberList.get(i).getAddress().indexOf(" "));
			if(map.containsKey(address)) {
				map.put(address, map.get(address)+1);
			}else {
				map.put(address, 1);
			}
		}
		Set<String> key = map.keySet();
		for(String s : key) {
			System.out.printf("\t%-5s \t\t%3d명\r\n",s,map.get(s));
		}
	}

	private static void getGenderAge(String gender) {
		ArrayList<Member> list = new ArrayList<Member>();
		
		if(gender.equals("F")) {
			System.out.println("[여성]");
		}else if(gender.equals("M")) {
			System.out.println("[남성]");
		}
		tap();
		Main.memberList.stream().filter(m-> m.getGender().equals(gender)).forEach(m->list.add(m));
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
		for(int i=0;i<list.size();i++) {
			int year = 0;
			String total = list.get(i).getRegistrationNumber().substring(0,2);
			total = total.substring(0,1).equals("0")? "20"+total : "19"+total;
			year=Integer.parseInt(total);
			age=(now-year)/10;
			switch(age) {
				case 1:
					teenager++;
					break;
				case 2:
					twenties++;
					break;
				case 3:
					thirties++;
					break;
				case 4:
					forties++;
					break;
				case 5:
					fifties++;
					break;
				default:
					old++;
					break;
			}
		}
		System.out.printf("[10대%3d명] ",teenager);
		System.out.printf("[20대%3d명] ",twenties);
		System.out.printf("[30대%3d명] ",thirties);
		System.out.printf("[40대%3d명] ",forties);
		System.out.printf("[50대%3d명] ",fifties);
		System.out.printf("[60세이상 %3d명]",old);
		System.out.println();
	}

	private static void menuMain() {
		
		// 메인
		// 메뉴출력
		
		System.out.println("───────────────── [ 회원 통계 ] ─────────────────");
		System.out.println("0. 뒤로가기");
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
		System.out.println("───────────────── [ 회원 통계 ] ─────────────────");
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