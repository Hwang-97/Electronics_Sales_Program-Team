package Func;

import java.util.Scanner;

public class Login // 로그인 메뉴
{
	public static void login() throws Exception
	{
		menuLogin();
		
		System.out.print("번호 입력 : ");
		try(Scanner scanner = new Scanner(System.in)) 
		{
			if(!scanner.hasNextInt())
			{
				System.out.println("잘못된 번호입니다");
				Login.login();
			}
			int num = scanner.nextInt();
			
			switch(num)
			{
				case 0:
					Func.Main.main();
					break;
				case 1:
					Func.LoginInput.main();
					break;
				case 2:
					//nonMember.main();
					break;
				case 3:
					//Admin.main();
					break;
				case 4:
					FindID.main();
					break;
				case 5:
					FindPW.main();
					break;
				default:
					System.out.println("잘못된 번호입니다");
					Login.login();
					break;	
			}
		}
	}
	private static void menuLogin()
	{
		System.out.println();
		System.out.println("#####로그인#####");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 회원");
		System.out.println("2. 비회원");
		System.out.println("3. 관리자");
		System.out.println("4. 아이디 찾기");
		System.out.println("5. 비밀번호 찾기");
		System.out.println();
	}
}