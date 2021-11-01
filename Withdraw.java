package Func;

import java.util.Scanner;

import main.main;

public class Withdraw // 회원탈퇴
{
	public static void main() throws Exception
	{
		menuWithdraw();
		
		System.out.print("비밀번호 확인 : ");
		try(Scanner scanner = new Scanner(System.in)) 
		{
			String pw = scanner.nextLine();
			
			if(LoginInput.pw.equals(pw))
			{
				System.out.print("회원 탈퇴를 진행하시겠습니까? (Y/N)");
				String input = scanner.nextLine().toLowerCase();
				
				if(input.equals("y"))
				{
					for(int i=0; i<main.memberList.size(); i++)
					{
						if(main.memberList.get(i).getPw().equals(pw))
						{
							main.memberList.remove(i);
							System.out.println("회원 탈퇴가 완료되었습니다");
							Main.main();
							break;
						}
					}
				}
				else
				{
					System.out.println("회원 탈퇴를 취소합니다");
					MemberMain.main();
				}
			}
			else
			{
				System.out.println("비밀번호가 일치하지 않습니다");
				MemberMain.main();
			}
		}
	}
	private static void menuWithdraw()
	{
		System.out.println();
		System.out.println("#####회원 탈퇴#####");
		System.out.println();
	}
}