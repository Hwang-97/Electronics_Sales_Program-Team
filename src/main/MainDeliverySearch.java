package main;

public class MainDeliverySearch // 메인 배송 조회
{
	public static int memberNum; // 회원&비회원 번호 저장할 변수

	public static boolean main() {

		boolean loop = true;

		while (loop) {
			System.out.print("전화번호 입력 : ");
			String tel = Main.scan.nextLine();

			for (int i = 0; i < Main.memberList.size(); i++) {
				if (Main.nonMemberList.get(i).getTel().equals(tel)) // 비회원 전화번호 검색
				{
					memberNum = Main.nonMemberList.get(i).getMemberNumber();
					break;
				} else if (Main.memberList.get(i).getTel().equals(tel)) // 회원 전화번호 검색
				{
					memberNum = Main.memberList.get(i).getMemberNumber();
					break;
				} else if (i == Main.nonMemberList.size() - 1
						&& !(Main.nonMemberList.get(i).getTel().equals(tel))
						&& !(Main.memberList.get(i).getTel().equals(tel))) // 입력한 전화번호 값이 비회원, 회원 데이터 리스트에 없는 경우
				{
					System.out.println("존재하지 않는 전화번호입니다");
					return true; // 메인 배송 화면으로
				} else {
					continue;
				}
			}

			
			System.out.println("\r\n송장번호\t\t주문일자\t\t주문번호\t상품명\t상품금액\t배송주소\t\t\t배송현황");
			for (int i = 0; i < main.Main.orderList.size(); i++) {
				
				if (Main.nonMemberOrderList.get(i).getMemberNumber() == memberNum) // 주문 데이터 리스트에서 비회원 번호 값을 가지는 객체
																						// 검색
				{
					System.out.println(String.format("%s\t%s\t%s\t%s\t%d\t%s\t%s",
							Main.nonMemberOrderList.get(i).getInvoiceNumber(),
							Main.nonMemberOrderList.get(i).getOrderDate(),
							Main.nonMemberOrderList.get(i).getOrderNumber(),
							Main.productList.get(i).getProductName(),
							Main.productList.get(i).getProductPrice(),
							Main.nonMemberOrderList.get(i).getAddress(),
							Main.trackingList.get(i).getDeliveryStatus()));
				} else if (Main.orderList.get(i).getMemberNumber() == memberNum) // 주문 데이터 리스트에서 회원 번호 값을 가지는 객체 검색
				{
					System.out.println(String.format("%s\t%s\t%s\t%s\t%d\t%s\t%s",
							Main.orderList.get(i).getInvoiceNumber(), 
							Main.orderList.get(i).getOrderDate(),
							Main.orderList.get(i).getOrderNumber(), 
							Main.productList.get(i).getProductName(),
							Main.productList.get(i).getProductPrice(), 
							Main.orderList.get(i).getAddress(),
							Main.trackingList.get(i).getDeliveryStatus()));
				} else if (i == Main.orderList.size() - 1) // 주문 데이터 리스트의 마지막 인덱스까지 검사하면
				{
					break;
				}

			}
			menuDeliverySearch(); // 배송 조회 메뉴 출력

			System.out.print("번호 입력 : ");

			int num = Main.inputUserNum(0, 0);
			Main.scan.nextLine();

			switch (num) {
			case 0: // 뒤로가기
				return true;
			default:
				System.out.println("잘못된 번호입니다");
				break;
			}

		}
		return true;

	}

	private static void menuDeliverySearch() // 배송 조회 메뉴 출력
	{
		System.out.println();
		System.out.println(
				"──────────────────────────────────────────────── [ 배송 조회 ] ───────────────────────────────────────────────");
		System.out.println("\t\t\t 0. 뒤로가기");
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println();

		//System.out.println("#####배송 조회#####");
	}
}