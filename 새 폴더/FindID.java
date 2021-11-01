package Func;

import java.util.Scanner;

public class FindID // 아이디 찾기
{
	public static void main() throws Exception
	{
		menuFindID();
		
		System.out.print("이름 입력 : ");
		try(Scanner scanner = new Scanner(System.in)) 
		{
			String name = scanner.nextLine();
			
			for(int i=0; i<main.main.memberList.size(); i++)
			{
				if(main.main.memberList.get(i).getName().equals(name))
				{
					break;
				}
				else if(i == main.main.memberList.size()-1 && !(main.main.memberList.get(i).getName().equals(name)))
				{
					System.out.println("잘못된 이름입니다");
					Login.login();
					break;
				}
				else
				{
					continue;
				}
			}
			System.out.print("주민등록번호 입력 : ");
			String jumin = scanner.nextLine();
			
			for(int i=0; i<main.main.memberList.size(); i++)
			{
				if(main.main.memberList.get(i).getName().equals(name) && main.main.memberList.get(i).getRegistrationNumber().equals(jumin))
				{
					System.out.println("아이디 : " + main.main.memberList.get(i).getId());
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
	private static void menuFindID()
	{
		System.out.println();
		System.out.println("#####아이디 찾기#####");
		System.out.println();
	}
}