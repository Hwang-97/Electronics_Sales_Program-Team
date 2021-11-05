package main;

import java.util.Scanner;

public class MemberDataEdit
{
	public static boolean main() {
		
		//TODO 유효성검사 필요
		
		for (int i = 0; i < Main.memberList.size(); i++) {
			if (Main.memberList.get(i).getId().equals(Main.id)) {
				System.out.println(Main.memberList.get(i).toString());
				break;
			}
		}

		menuUserDataEdit();

		System.out.print("번호 입력 : ");

		Scanner scanner = new Scanner(System.in);

		if (!scanner.hasNextInt()) {
			System.out.println("잘못된 번호입니다");
			MemberData.main();
		}
		int num = scanner.nextInt();

		String temp = scanner.nextLine();

		switch (num) {
		case 0:
			return true;
		case 1:
			for (int i = 0; i < Main.memberList.size(); i++) {
				if (Main.memberList.get(i).getId().equals(Main.id)) {
					System.out.println("기존 비밀번호 : " + Main.memberList.get(i).getPw());
					System.out.print("새 비밀번호 입력 : ");
					String newPw = scanner.nextLine();
					Main.memberList.get(i).setPw(newPw);
					Main.pw=newPw;
					System.out.println("비밀번호가 변경되었습니다");
					System.out.println("새 비밀번호 : " + Main.memberList.get(i).getPw());
					return true;
				}
			}
			break;
		case 2:
			for (int i = 0; i < Main.memberList.size(); i++) {
				if (Main.memberList.get(i).getId().equals(Main.id)) {
					System.out.println("기존 전화번호 : " + Main.memberList.get(i).getTel());
					System.out.print("새 전화번호 입력 : ");
					String newTel = scanner.nextLine();
					Main.memberList.get(i).setTel(newTel);
					System.out.println("전화번호가 변경되었습니다");
					System.out.println("새 전화번호 : " + Main.memberList.get(i).getTel());
					return true;
				}
			}
			break;
		case 3:
			for (int i = 0; i < Main.memberList.size(); i++) {
				if (Main.memberList.get(i).getId().equals(Main.id)) {
					System.out.println("기존 이메일 : " + Main.memberList.get(i).getMail());
					System.out.print("새 이메일 입력 : ");
					String newMail = scanner.nextLine();
					Main.memberList.get(i).setMail(newMail);
					System.out.println("이메일이 변경되었습니다");
					System.out.println("새 이메일 : " + Main.memberList.get(i).getMail());
					return true;
				}
			}
			break;
		case 4:
			for (int i = 0; i < Main.memberList.size(); i++) {
				if (Main.memberList.get(i).getId().equals(Main.id)) {
					System.out.println("기존 주소 : " + Main.memberList.get(i).getAddress());
					System.out.print("새 주소 입력 : ");
					String newAddress = scanner.nextLine();
					Main.memberList.get(i).setAddress(newAddress);
					System.out.println("주소가 변경되었습니다");
					System.out.println("새 주소 : " + Main.memberList.get(i).getAddress());
					return true;
				}
			}
			break;
		default:
			System.out.println("잘못된 번호입니다");
			return true;
		}
		return false;
	}

	private static void menuUserDataEdit() {
		System.out.println();
		System.out.println("────────────────────────────────────────────── [ 개인정보 수정 ] ──────────────────────────────────────────────");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 비밀번호");
		System.out.println("2. 전화번호");
		System.out.println("3. 이메일");
		System.out.println("4. 주소");
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println();
	}
}