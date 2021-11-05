package main;

import java.util.Scanner;

public class NonMemberDataEdit {
	public static boolean main() {

		// TODO 유효성검사 필요

		for (int i = 0; i < Main.nonMemberList.size(); i++) {
			if (Main.nonMemberList.get(i).getId().equals(Main.id)) {
				System.out.println(Main.nonMemberList.get(i).toString());
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
			for (int i = 0; i < Main.nonMemberList.size(); i++) {
				if (Main.nonMemberList.get(i).getId().equals(Main.id)) {
					System.out.println("기존 비밀번호 : " + Main.nonMemberList.get(i).getPw());
					System.out.print("새 비밀번호 입력 : ");
					String newPw = scanner.nextLine();
					Main.nonMemberList.get(i).setPw(newPw);
					System.out.println("비밀번호가 변경되었습니다");
					System.out.println("새 비밀번호 : " + Main.nonMemberList.get(i).getPw());
					return true;
				}
			}
			break;
		case 2:
			for (int i = 0; i < Main.nonMemberList.size(); i++) {
				if (Main.nonMemberList.get(i).getId().equals(Main.id)) {
					System.out.println("기존 전화번호 : " + Main.nonMemberList.get(i).getTel());
					System.out.print("새 전화번호 입력 : ");
					String newTel = scanner.nextLine();
					Main.nonMemberList.get(i).setTel(newTel);
					Main.nonMemberList.get(i).setId(newTel);
					// TODO 비회원 전화번호변경 시 로그인을 다시 해야함
					// > Main.id는 그대로, tel만 바뀌기 때문에 Main.id로 탐색하는 모든 함수에서 꼬임
					// 비회원은 Tel == id > 전화번호 변경 불가하게 해야하나? 팀원들에게 물어봐야함
					Main.id = newTel;
					System.out.println("전화번호가 변경되었습니다");
					System.out.println("새 전화번호 : " + Main.nonMemberList.get(i).getTel());
					return true;
				}
			}
			break;
		case 3:
			for (int i = 0; i < Main.nonMemberList.size(); i++) {
				if (Main.nonMemberList.get(i).getId().equals(Main.id)) {
					System.out.println("기존 이메일 : " + Main.nonMemberList.get(i).getMail());
					System.out.print("새 이메일 입력 : ");
					String newMail = scanner.nextLine();
					Main.nonMemberList.get(i).setMail(newMail);
					System.out.println("이메일이 변경되었습니다");
					System.out.println("새 이메일 : " + Main.nonMemberList.get(i).getMail());
					return true;
				}
			}
			break;
		case 4:
			for (int i = 0; i < Main.nonMemberList.size(); i++) {
				if (Main.nonMemberList.get(i).getId().equals(Main.id)) {
					System.out.println("기존 주소 : " + Main.nonMemberList.get(i).getAddress());
					System.out.print("새 주소 입력 : ");
					String newAddress = scanner.nextLine();
					Main.nonMemberList.get(i).setAddress(newAddress);
					System.out.println("주소가 변경되었습니다");
					System.out.println("새 주소 : " + Main.nonMemberList.get(i).getAddress());
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
		System.out.println("\t\t\t 1. 비밀번호 \t\t\t\t 2. 전화번호");
		System.out.println();
		System.out.println("\t\t\t 3. 이메일 \t\t\t\t 4. 주소");
		System.out.println();
		System.out.println("\t\t\t 0. 뒤로가기");
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println();
	}
}