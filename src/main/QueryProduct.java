package main;

import createObject.Query;

public class QueryProduct {
	public static boolean main(int productNum, String productCode) {
		Query q=new Query();
		String queryContent="";
		//문의 리스트 중에 마지막 리스트의 get 문의번호 후 +1
		int queryNum=Main.queryList.get(Main.queryList.size()-1).getQueryNum()+1;
		
		
		printQueryProduct();
		System.out.println("문의 내용을 작성해주세요.");
		queryContent=Main.scan.nextLine();
		
		q.setQueryNum(queryNum);
		q.setMemberNum(Main.memberNumber);
		q.setItemCode(productCode);
		q.setQueryContent(queryContent);
		q.setAnswerContent(null);	
		
		menuQueryProduct();
		System.out.println("문의를 등록하시겠습니까?");
		int num=Main.inputUserNum(0, 1);
		
		
		if(num==1) {
			Main.queryList.add(q);
			System.out.println("문의 등록 완료");
		} else {
			System.out.println("문의 등록이 취소되었습니다.");
		}
		
		return true;
	}
	
	private static void printQueryProduct() {
		System.out.println("───────────────── [ 문의 작성하기 ] ─────────────────");
	}
		
	private static void menuQueryProduct()
	{
		System.out.println("───────────────── [ 메뉴 목록 ] ─────────────────");
		System.out.println("0. 돌아가기");
		System.out.println("1. 문의 등록하기");
		System.out.println("───────────────────────────────────────────────");
	}
}
