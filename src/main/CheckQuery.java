package main;

import createObject.*;

public class CheckQuery {
	public static boolean main() {
		
		System.out.println("┏┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯ [ 문의상품 정보 ] ┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┯┐\n");
		for(Query q:Main.queryList) {
			String answer=q.getAnswerContent();
			if(answer==null) {
				answer="문의가 전달되어 확인중입니다.";
			}
			
			
			String productName = "상품이름오류";
			for(Product p:Main.productList) {
				if(q.getItemCode().equals(p.getProductCode())) {
					productName=p.getProductName();
				}
			}
			
			if(Main.memberNumber==q.getMemberNum()) {
				System.out.println("\t\t\t┌───────────────── [ 문의상품 정보 ] ─────────────────┐");
				System.out.println("\t\t\t│문의 번호\t   상품코드\t    상품이름");
				System.out.printf ("\t\t\t│%d\t\t %5s\t %7s\n",q.getQueryNum(),q.getItemCode(),productName);
				System.out.println("\t\t\t│");
				System.out.println("\t\t\t├───────────────── [ 작성문의 내용 ] ─────────────────┤");
				System.out.println("\t\t\t│"+Main.id+": "+q.getQueryContent());
				System.out.println("\t\t\t│");
				System.out.println("\t\t\t├───────────────── [ 답변문의 목록 ] ─────────────────┤");
				System.out.println("\t\t\t│"+answer);
				System.out.println("\t\t\t│");
				System.out.println("\t\t\t└─────────────────────────────────────────────────┘");
				System.out.println("");
				System.out.println("");
			}
			
		}
		
		System.out.println("\t엔터를 입력하면 돌아갑니다.");
		String temp=Main.scan.nextLine();
		
		return true;
	}
}
