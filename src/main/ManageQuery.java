package main;

import java.util.Scanner;

public class ManageQuery // 관리자 - 문의 관리
{
	private static String productCode; // 상품 코드값 저장할 변수
	private static int productNum; // 상품 번호값 저장할 변수
	private static String productName; // 상품 이름값 저장할 변수

	public static boolean main() {

		boolean loop = true;
		while (loop) {
			menuManageQuery(); // 문의 관리 메뉴 출력

			System.out.print("번호 입력 : ");
			int num = Main.inputUserNum(0, 1);
			Main.scan.nextLine();

			switch (num) {
			case 0:
				return true;
			case 1: // 문의 조회
				System.out.print("상품 번호 입력 : ");
				int productNumber = Main.inputUserNum(1, Main.productList.size());
				Main.scan.nextLine();

				for (int i = 0; i < main.Main.productList.size(); i++) {
					if (main.Main.productList.get(i).getProductNum() == productNumber) {
						productCode = main.Main.productList.get(i).getProductCode(); // 입력한 상품 번호를 가지는 상품 리스트 내 객체의 상품
																						// 코드값
						// 반환
						productName = main.Main.productList.get(i).getProductName(); // 입력한 상품 번호를 가지는 상품 리스트 내 객체의 상품
																						// 이름값
						// 반환
						productNum = main.Main.productList.get(i).getProductNum(); // 입력한 상품 번호를 가지는 상품 리스트 내 객체의 상품 번호값
																					// 반환
						break;
					}
				}
				System.out.println("[상품번호] \t[상품명] \t[문의번호] \t[문의내용]     \t\t[답변내용]");
				for (int i = 0; i < main.Main.queryList.size(); i++) {
					if (main.Main.reviewList.get(i).getItemCode().equals(productCode)) {
						System.out.println(String.format("%5d\t\t%s\t%d \t\t%s   \t%s", 
								productNum, 
								productName,
								main.Main.queryList.get(i).getQueryNum(), 
								main.Main.queryList.get(i).getQueryContent(),
								main.Main.queryList.get(i).getAnswerContent()));
					}
				}

				menuManageQuery2(); // 답변 메뉴 출력

				System.out.print("번호 입력 : ");
				num = Main.inputUserNum(0, 1);
				Main.scan.nextLine();

				if (num == 1) {
					loop=ManageQueryAnswer.main(); // 답변 작성 메뉴로
				} else {
					return true;
				}
				break;
			}
			
		}
		return true;

	}

	private static void menuManageQuery() // 문의 관리 메뉴 출력
	{
		System.out.println();
		System.out.println();
		System.out.println("─────────────────────────────────────────── +-+-+|문|의|관|리|+-+-+ ───────────────────────────────────────────");
		System.out.println("\t\t\t 1. 문의 조회" );
		System.out.println();
		System.out.println("\t\t\t 0. 뒤로가기");
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
		
	}

	private static void menuManageQuery2() // 답변 메뉴 출력
	{
		System.out.println();
		System.out.println("─────────────────────────────────────────── +-+-+|답|변|관|리|+-+-+ ───────────────────────────────────────────");
		System.out.println("\t\t\t 1. 답변 작성" );
		System.out.println();
		System.out.println("\t\t\t 0. 뒤로가기");
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
		
	}
}