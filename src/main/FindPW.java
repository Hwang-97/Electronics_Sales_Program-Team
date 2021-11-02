package main;

import java.util.Scanner;

public class FindPW {
	public static boolean main() {
		
		menuFindPW();

		
		
		System.out.print("아이디 입력 : ");
		try {
			String id = Main.scan.nextLine();

			for (int i = 0; i < main.Main.memberList.size(); i++) {
				if (main.Main.memberList.get(i).getId().equals(id)) {
					break;
				} else if (i == main.Main.memberList.size() - 1 && !(main.Main.memberList.get(i).getId().equals(id))) {
					System.out.println("잘못된 아이디입니다");
					return true;
				} else {
					continue;
				}
			}
			System.out.print("이름 입력 : ");
			String name = Main.scan.nextLine();

			for (int i = 0; i < main.Main.memberList.size(); i++) {
				if (main.Main.memberList.get(i).getId().equals(id)
						&& main.Main.memberList.get(i).getName().equals(name)) {
					break;
				} else if(i == Main.memberList.size()-1 &&
						!(Main.memberList.get(i).getName().equals(name))){
					System.out.println("잘못된 이름입니다");
					return true;
				} else {
					continue;
				}
			}
			System.out.print("주민등록번호 입력 : ");
			String jumin = Main.scan.nextLine();

			for (int i = 0; i < main.Main.memberList.size(); i++) {
				if (main.Main.memberList.get(i).getId().equals(id) && main.Main.memberList.get(i).getName().equals(name)
						&& main.Main.memberList.get(i).getRegistrationNumber().equals(jumin)) {
					System.out.println("비밀번호 : " + main.Main.memberList.get(i).getPw());
					return true;
				} else if(i == Main.memberList.size()-1 && 
						!(Main.memberList.get(i).getRegistrationNumber().equals(jumin))) {
					System.out.println("잘못된 주민등록번호입니다");
					return true;
				} else {
					continue;
				}
					
			}
		} catch (Exception e) {
			System.out.println("로그인으로 돌아갑니다.");
		}
		return true;
	}

	private static void menuFindPW() {
		System.out.println();
		System.out.println("#####아이디 찾기#####");
		System.out.println();
	}
}
