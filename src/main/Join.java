package main;

import java.util.Calendar;
import java.util.List;

import createObject.Basket;
import createObject.Order;

public class Join // 회원 가입
{
	private static int memberNumber;
	private static int currentPoint;
	private static int totalPoint;
	private static int totalMoney;

	private static String birthday;
	private static String signUp;
	private static String leave;
	private static String id;
	private static String pw;
	private static String name;
	private static String gender;
	private static String address;
	private static String mail;
	private static String registrationNumber;
	private static String tel;

	private static boolean isAdmin;
	private static boolean isQuit;

	public static boolean main() {

		menuJoin(); // 회원 가입 메뉴 출력

		boolean flag = true;

		while (flag) // 아이디 입력
		{
			System.out.print("아이디 입력(영문+숫자 6~10자리, q를 입력하면 종료) : ");
			id = Main.scan.nextLine();

			if (id.matches("^[a-zA-Z0-9]{6,10}$")) // 영문 대소문자, 숫자 6~10자리
			{
				flag = false;
			} else if (id.equals("q") || id.equals("Q")) {
				return true; // 메인 화면으로
			}
		}
		flag = true;
		while (flag) // 비밀번호 입력
		{
			System.out.print("비밀번호 입력(영문+숫자 8~12자리, q를 입력하면 종료) : ");
			pw = Main.scan.nextLine();

			if (pw.matches("^[a-zA-Z0-9]{8,12}$")) // 영문 대소문자, 숫자 8~12자리
			{
				flag = false;
			} else if (pw.equals("q") || pw.equals("Q")) {
				return true; // 메인 화면으로
			}
		}
		flag = true;
		while (flag) // 이름 입력
		{
			System.out.print("이름 입력(한글 2~4자리, q를 입력하면 종료) : ");
			name = Main.scan.nextLine();

			if (name.matches("^[가-힣]{2,4}$")) // 한글 2~4자리
			{
				flag = false;
			} else if (name.equals("q") || name.equals("Q")) {
				return true; // 메인 화면으로
			}
		}
		flag = true;
		while (flag) // 성별 입력
		{
			System.out.print("성별 입력(남자면 M, 여자면 F를 입력, q를 입력하면 종료) : ");
			gender = Main.scan.nextLine().toUpperCase();

			if (gender.equals("F") || gender.equals("M")) // 대소문자 f, 대소문자 m
			{
				flag = false;
			} else if (gender.equals("q") || gender.equals("Q")) {
				return true; // 메인 화면으로
			}
		}
		flag = true;
		while (flag) // 주소 입력
		{
			System.out.print("주소 입력(ex)경기도 일산동구, q를 입력하면 종료) : ");
			address = Main.scan.nextLine();

			if (address.matches("^[가-힣0-9\s]+")) // 한글, 숫자, 공백
			{
				flag = false;
			} else if (address.equals("q") || address.equals("Q")) {
				return true; // 메인 화면으로
			}
		}
		flag = true;
		while (flag) // 이메일 입력
		{
			System.out.print("이메일 입력(ex) abc@google.com, q를 입력하면 종료) : ");
			mail = Main.scan.nextLine();

			if (mail.matches("^[a-zA-Z0-9]+@[a-zA-Z]+.[a-zA-Z]+$")) // 영문, 숫자 + @ + 영문 + . + 영문
			{
				flag = false;
			} else if (mail.equals("q") || mail.equals("Q")) {
				return true; // 메인 화면으로
			}
		}
		flag = true;
		while (flag) // 주민등록번호 입력
		{
			System.out.print("주민등록번호 입력(ex)010101-1010101, q를 입력하면 종료) : ");
			registrationNumber = Main.scan.nextLine();

			if (registrationNumber
					.matches("^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}$")) {
				flag = false;
			} else if (registrationNumber.equals("q") || registrationNumber.equals("Q")) {
				return true; // 메인 화면으로
			}
		}
		flag = true;
		while (flag) // 전화번호 입력
		{
			System.out.print("전화번호 입력(ex)010-XXXX-XXXX, q를 입력하면 종료) : ");
			tel = Main.scan.nextLine();

			if (tel.matches("^010-([0-9]{4})-([0-9]{4})$")) {
				flag = false;
			} else if (tel.equals("q") || tel.equals("Q")) {
				return true; // 메인 화면으로
			}
		}
		System.out.print("회원가입을 하시겠습니까? (Y/N) : ");
		String input = Main.scan.nextLine().toLowerCase();

		memberNumber = main.Main.memberList.size() + 1; // 현재 회원 번호 크기 추가
		currentPoint = 0;
		totalPoint = 0;
		totalMoney = 100000000; // 초기 자금액 1억
		birthday = registrationNumber.substring(0, registrationNumber.indexOf("-")); // 주민등록번호 앞 숫자 6자리 추출

		Calendar c = Calendar.getInstance();
		signUp = String.format("%tF", c);

		if (input.equals("y")) {
			Main.memberList.add(new createObject.Member(memberNumber, 
					currentPoint,
					totalPoint, 
					totalMoney, 
					id, 
					pw, 
					name, 
					tel, 
					address, 
					gender, 
					mail, 
					registrationNumber, 
					birthday,
					signUp, 
					leave, 
					isAdmin, 
					isQuit,
					null,
					null
					)); // 회원
																														// 리스트에
																														// 데이터
																														// 추가
//			
//			int memberNumber, 
//			int currentPoint, 
//			int totalPoint, 
//			int totalMoney, 
//			String id, 
//			String pw, 
//			String name,
//			String tel, 
//			String address, 
//			String gender, 
//			String mail, 
//			String registrationNumber, 
//			String birthday,
//			String signUp, 
//			String leave, 
//			boolean isAdmin, 
//			boolean isQuit, 
//			List<Order> orderList,
//			List<Basket> basketList
			
			System.out.println("회원가입이 완료되었습니다");
			return true; // 메인 화면으로
		} else {
			System.out.println("회원가입을 취소합니다");
			return true; // 메인 화면으로
		}

	}

	private static void menuJoin() // 회원 가입 메뉴 출력
	{
		System.out.println();
		System.out.println("\t\t\t ++++++++++++++++++++++ 회원가입 ++++++++++++++++++++++");
		System.out.println();
		
	}
}