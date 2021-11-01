package Func;

import java.util.Scanner;

public class Main // 메인 메뉴
{
	public static void main() throws Exception
	{
		menuMain();
		
		System.out.print("번호 입력 : ");
		try(Scanner scanner = new Scanner(System.in))
		{
			if(!scanner.hasNextInt())
			{
				System.out.println("잘못된 번호입니다");
				Main.main();
			}
			int num = scanner.nextInt();
			
			switch(num)
			{
				case 1:
					Func.Login.login();
					break;
				case 2:
					//Main.join()
					break;
				case 3:
					//Main.itemSearch2();
					break;
				case 4:
					//Main.deliverySearch();
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("잘못된 번호입니다");
					Main.main();
					break;	
			}
		}
	}
	private static void menuMain()	
	{
		System.out.println();
		System.out.println("#####메인#####");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 상품조회");
		System.out.println("4. 배송조회");
		System.out.println("5. 종료");
		System.out.println();
	}
}