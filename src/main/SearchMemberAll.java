package main;

import createObject.Member;

public class SearchMemberAll {
	public static boolean main() {
		
		System.out.println("────────────────────────────────────────────── [ 전체 회원 조회 ] ─────────────────────────────────────────────");
		System.out.println("[번호]\t[이름]\t[성별]\t[주소]");
		for (Member m : Main.memberList) {
			System.out.printf(" %3s \t %3s \t %2s  \t %s \r\n", m.getMemberNumber(), m.getName(), m.getGender(),
					m.getAddress());

		}

		return true;
	}
}
