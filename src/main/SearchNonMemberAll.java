package main;

import createObject.Member;

public class SearchNonMemberAll {
	public static boolean main() {

		System.out.println("───────────────────────────────────────────── [ 전체 비회원 조회 ] ────────────────────────────────────────────");
		System.out.println("[번호]\t[이름]\t[전화번호]\t\t[성별]\t[주소]");
		for (Member m : Main.nonMemberList) {
			System.out.printf(" %3s \t %3s \t %s\t %3s\t%s\r\n", m.getMemberNumber(), m.getName(), m.getId(),
					m.getGender(), m.getAddress());

		}

		return true;
	}

}
