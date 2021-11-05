package main;

public class Withdraw {
	public static boolean main() {
		menuWithdraw();

		System.out.print("비밀번호 확인 : ");

		String pw = Main.scan.nextLine();

		if (Main.pw.equals(pw)) {
			System.out.print("회원 탈퇴를 진행하시겠습니까? (Y/N)");
			String input = Main.scan.nextLine().toLowerCase();

			if (input.equals("y")) {
				for (int i = 0; i < Main.memberList.size(); i++) {
					if (Main.memberList.get(i).getPw().equals(pw)) {
						Main.memberList.remove(i);
						Main.id=null;
						Main.pw=null;
						Main.nowLogin=false;
						System.out.println("회원 탈퇴가 완료되었습니다");
						System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
						return false;
					}
				}
			} else {
				System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
				System.out.println("회원 탈퇴를 취소합니다");
				return true;
			}
		} else {
			System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
			System.out.println("비밀번호가 일치하지 않습니다");
			return true;
		}
		return false;
	}

	private static void menuWithdraw() {
		System.out.println();
		System.out.println("\t\t\t ++++++++++++++++++++++ 회원탈퇴 ++++++++++++++++++++++");
		System.out.println();
	}

}
