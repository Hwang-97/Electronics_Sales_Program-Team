package main;

public class AdminDelivery // 관리자 배송 조회
{
	public static boolean main() {

		boolean loop = true;

		while (loop) {

			menuAdminDelivery();

			System.out.print("번호 입력 : ");
			int num = Main.inputUserNum(0, 2);
			Main.scan.nextLine();

			switch (num) {
			case 0:
				return true;
			case 1:
				System.out.println("\r\n송장번호\t\t주문일자\t\t주문번호\t상품명\t상품금액\t배송주소  \t\t\t\t배송현황");
				for (int i = 0; i < main.Main.orderList.size(); i++) {
					System.out.println(String.format("%s\t%s\t%s\t%s\t%d\t%-14s \t\t%s",
							main.Main.orderList.get(i).getInvoiceNumber(), main.Main.orderList.get(i).getOrderDate(),
							main.Main.orderList.get(i).getOrderNumber(), main.Main.productList.get(i).getProductName(),
							main.Main.productList.get(i).getProductPrice(), main.Main.orderList.get(i).getAddress(),
							main.Main.trackingList.get(i).getDeliveryStatus()));
				}
				loop = AdminDelivery.memberDetailSearch(); // 회원 배송 상세 조회로
				break;
			case 2:
				System.out.println("\r\n송장번호\t\t주문일자\t\t주문번호\t상품명\t상품금액\t배송주소  \t\t\t\t배송현황");
				for (int i = 0; i < main.Main.nonMemberOrderList.size(); i++) {
					System.out.println(String.format("%s\t%s\t%s\t%s\t%d\t%-14s \t\t%s",
							main.Main.nonMemberOrderList.get(i).getInvoiceNumber(),
							main.Main.nonMemberOrderList.get(i).getOrderDate(),
							main.Main.nonMemberOrderList.get(i).getOrderNumber(),
							main.Main.productList.get(i).getProductName(),
							main.Main.productList.get(i).getProductPrice(),
							main.Main.nonMemberOrderList.get(i).getAddress(),
							main.Main.trackingList.get(i).getDeliveryStatus()));
				}
				loop = AdminDelivery.nonMemberDetailSearch(); // 비회원 배송 상세 조회로
				break;
			}
		}
		return true;
	}

	private static boolean memberDetailSearch() // 회원 배송 상세 조회
	{
		System.out.println();
		System.out.println("0. 뒤로가기");
		System.out.println("1. 개별조회");
		System.out.println();

		System.out.print("번호 입력 : ");
		int num = Main.inputUserNum(0, 1);
		Main.scan.nextLine();

		switch (num) {
		case 0:
			return true;
		case 1:
			System.out.print("송장번호 입력 : ");
			String invoiceNum = Main.scan.nextLine();

			System.out.println("\r\n송장번호\t\t주문일자\t\t주문번호\t상품명\t상품금액\t배송주소  \t\t\t\t배송현황");
			for (int i = 0; i < main.Main.orderList.size(); i++) {
				if (main.Main.orderList.get(i).getInvoiceNumber().equals(invoiceNum)) {
					System.out.println(String.format("%s\t%s\t%s\t%s\t%d\t%-14s \t\t%s",
							main.Main.orderList.get(i).getInvoiceNumber(), main.Main.orderList.get(i).getOrderDate(),
							main.Main.orderList.get(i).getOrderNumber(), main.Main.productList.get(i).getProductName(),
							main.Main.productList.get(i).getProductPrice(), main.Main.orderList.get(i).getAddress(),
							main.Main.trackingList.get(i).getDeliveryStatus()));
				}
			}
		}
		return true;
	}

	private static boolean nonMemberDetailSearch() // 비회원 배송 상세 조회
	{
		System.out.println();
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 개별조회");
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println();

		System.out.print("번호 입력 : ");
		int num = Main.inputUserNum(0, 1);
		Main.scan.nextLine();

		switch (num) {
		case 0:
			break;
		case 1:
			System.out.print("송장번호 입력 : ");
			String invoiceNum = Main.scan.nextLine();

			System.out.println("\r\n송장번호\t\t주문일자\t\t주문번호\t상품명\t상품금액\t배송주소  \t\t\t\t배송현황");
			for (int i = 0; i < main.Main.nonMemberOrderList.size(); i++) {
				if (main.Main.nonMemberOrderList.get(i).getInvoiceNumber().equals(invoiceNum)) {
					System.out.println(String.format("%s\t%s\t%s\t%s\t%d\t%-14s \t\t%s",
							main.Main.nonMemberOrderList.get(i).getInvoiceNumber(),
							main.Main.nonMemberOrderList.get(i).getOrderDate(),
							main.Main.nonMemberOrderList.get(i).getOrderNumber(),
							main.Main.productList.get(i).getProductName(),
							main.Main.productList.get(i).getProductPrice(),
							main.Main.nonMemberOrderList.get(i).getAddress(),
							main.Main.trackingList.get(i).getDeliveryStatus()));
				}
			}
			break;
		}
		return true;
	}

	private static void menuAdminDelivery() {
		System.out.println();
		System.out.println("───────────────────────────────────────────── [ 관리자 배송 메뉴 ] ────────────────────────────────────────────");
		System.out.println("\t\t\t 1. 회원 배송 조회 \t\t\t\t 2. 비회원 배송 조회");
		System.out.println();
		System.out.println("\t\t\t 0. 뒤로가기");
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
		
		//System.out.println("#####관리자 배송 메뉴#####");
//		System.out.println("0. 뒤로 가기");
//		System.out.println("1. 회원 배송 조회");
//		System.out.println("2. 비회원 배송 조회");
//		System.out.println();
	}
}