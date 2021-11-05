package main;

public class DeliverySearch // 회원 배송 조회
{
	public static boolean main(){
		
		boolean loop=true;
		
		
		while(loop) {
			System.out.println("\r\n송장번호\t\t주문일자\t\t주문번호\t상품명\t상품금액\t배송주소\t\t배송현황");
			for (int i = 0; i < Main.orderList.size(); i++) {
				if (Main.orderList.get(i).getMemberNumber() == Main.memberNumber) {
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
				return true; // 회원 배송 메뉴로
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
		System.out.println("───────────────────────────────────────── +-+-+|S|e|a|r|c|h|+-+-+ ─────────────────────────────────────────");
		System.out.println("\t\t\t 0. 뒤로가기");
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println();
	}
}