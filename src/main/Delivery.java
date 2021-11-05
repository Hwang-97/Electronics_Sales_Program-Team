package main;


public class Delivery // 회원 배송 메뉴
{
	public static boolean main() {

		boolean loop = true;
		while (loop) {
			printDelivery();
			menuDelivery(); // 배송 메뉴 출력
			
			System.out.print("번호 입력 : ");
			int num = Main.inputUserNum(0, 1);

			switch (num) {
			case 0: // 뒤로가기
				return true;// 회원 메인으로
			case 1: // 배송조회
				loop=DeliverySearch.main(); // 회원 배송 조회 메뉴로
			}
		}
		return true;

	}

	private static void printDelivery() {
		
		System.out.println();
		System.out.println("===========================================================================================================");
		System.out.println("\t\t\t\t     ___     _ _                        \r\n"
				+ "\t\t\t\t    /   \\___| (_)_   _____ _ __ _   _   \r\n"
				+ "\t\t\t\t   / /\\ / _ \\ | \\ \\ / / _ \\ '__| | | |  \r\n"
				+ "\t\t\t\t  / /_//  __/ | |\\ V /  __/ |  | |_| |_ \r\n"
				+ "\t\t\t\t /___,' \\___|_|_| \\_/ \\___|_|   \\__, (_)\r\n"
				+ "\t\t\t\t                                |___/   ");
		System.out.println("===========================================================================================================");
		System.out.println();
		
		
	}
	
	
	private static void menuDelivery() // 배송 메뉴 출력
	{
		
		System.out.println();
		System.out.println("─────────────────────────────────────────── +-+-+|M|E|N|U|+-+-+ ───────────────────────────────────────────");
		System.out.println("\t\t\t 1. 배송조회 \t\t\t\t 0. 뒤로가기");
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println();
		
//		System.out.println("#####배송조회#####");
//		System.out.println("0. 뒤로가기");
//		System.out.println("1. 배송조회");
//		System.out.println();
	}
}