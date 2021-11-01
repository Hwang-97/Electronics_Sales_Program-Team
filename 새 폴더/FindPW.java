package Func;

import java.util.Scanner;

public class FindPW // 비밀번호 찾기
{
	public static void main() throws Exception
	{
		menuFindPW();
		
		System.out.print("아이디 입력 : ");
		try(Scanner scanner = new Scanner(System.in)) 
		{
			String id = scanner.nextLine();
			
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
			System.out.print("이름 입력 : ");
			String name = scanner.nextLine();
			
			for(int i=0; i<main.main.memberList.size(); i++)
			{
				if(main.main.memberList.get(i).getId().equals(id) && main.main.memberList.get(i).getName().equals(name))
				{
					break;
				}
				else
				{
					System.out.println("잘못된 이름입니다");
					Login.login();
					break;
				}
			}
			System.out.println("주민등록번호 입력 : ");
			String jumin = scanner.nextLine();
			
			for(int i=0; i<main.main.memberList.size(); i++)
			{
				if(main.main.memberList.get(i).getId().equals(id) && main.main.memberList.get(i).getName().equals(name) && main.main.memberList.get(i).getRegistrationNumber().equals(jumin))
				{
					System.out.println("비밀번호 : " + main.main.memberList.get(i).getPw());
					Login.login();
					break;
				}
				else
				{
					System.out.println("잘못된 주민등록번호입니다");
					Login.login();
					break;
				}
			}
		}
	}
	private static void menuFindPW()
	{
		System.out.println();
		System.out.println("#####아이디 찾기#####");
		System.out.println();
	}
}