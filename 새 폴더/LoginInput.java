package Func;

import java.util.Scanner;

public class LoginInput // 아이디&비밀번호 입력
{
	public static String id; // 로그인 아이디 저장할 변수
	public static String pw; // 로그인 비밀번호 저장할 변수
	
	public static void main() throws Exception
	{
		menuLoginInput();
		
		System.out.print("아이디 입력 : ");
		try(Scanner scanner = new Scanner(System.in)) 
		{
			id = scanner.nextLine();
			
			for(int i=0; i<main.main.memberList.size(); i++)
			{
				if(main.main.memberList.get(i).getId().equals(id))
				{
					break;
				}
				else if(i == main.main.memberList.size()-1 && !(main.main.memberList.get(i).getId().equals(id)))
				{
					System.out.println("잘못된 아이디입니다");
					Login.login();
					break;
				}
				else
				{
					continue;
				}
			}
			System.out.print("비밀번호 입력 : ");
			pw = scanner.nextLine();
			
			for(int i=0; i<main.main.memberList.size(); i++)
			{
				if(main.main.memberList.get(i).getId().equals(id) && main.main.memberList.get(i).getPw().equals(pw))
				{
					MemberMain.main();
					break;
				}
				else
				{
					System.out.println("잘못된 비밀번호입니다");
					Login.login();
					break;
				}
			}
		}
	}
	private static void menuLoginInput()
	{
		System.out.println();
		System.out.println("#####아이디&비밀번호 입력#####");
		System.out.println();
	}
}