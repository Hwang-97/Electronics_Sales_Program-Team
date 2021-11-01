package Func;

import java.util.Scanner;

public class UserData // 개인정보 메뉴
{
	public static void main() throws Exception
	{
		menuUserData();
		
		System.out.print("번호 입력 : ");
		
		try(Scanner scanner = new Scanner(System.in))
		{
			if(!scanner.hasNextInt())
			{
				System.out.println("잘못된 번호입니다");
				UserData.main();
			}
			int num = scanner.nextInt();
			
			switch(num)
			{
				case 0:
					Func.MemberMain.main();
					break;
				case 1:
					Func.UserDataCheck.main();
					break;
				case 2:
					//Admin.main();
					break;
				default:
					System.out.println("잘못된 번호입니다");
					MemberMain.main();
					break;	
			}
		}
	}
	private static void menuUserData()
	{
		System.out.println();
		System.out.println("#####개인정보#####");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 개인정보 확인");
		System.out.println("2. 개인정보 수정");
		System.out.println();
	}
}	