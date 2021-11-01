package Func;

import java.util.Scanner;

public class MemberMain // 회원 메인 메뉴
{
	public static void main() throws Exception
	{
		menuMemberMain();
		
		System.out.print("번호 입력 : ");
		try(Scanner scanner = new Scanner(System.in)) 
		{
			if(!scanner.hasNextInt())
			{
				System.out.println("잘못된 번호입니다");
				MemberMain.main();
			}
			int num = scanner.nextInt();
			
			switch(num)
			{
				case 1:
					Func.UserData.main();
					break;
				case 2:
					//nonMember.main();
					break;
				case 3:
					//Admin.main();
					break;
				case 4:
					//FindID.main();
					break;
				case 5:
					//FindPW.main();
					break;
				case 6:
					Func.Withdraw.main();
				case 7:
					Func.Main.main();
				default:
					System.out.println("잘못된 번호입니다");
					MemberMain.main();
					break;	
			}
		}
	}
	private static void menuMemberMain()
	{
		System.out.println();
		System.out.println("#####회원 메인#####");
		System.out.println("1. 개인정보");
		System.out.println("2. 구매내역");
		System.out.println("3. 장바구니");
		System.out.println("4. 상품조회");
		System.out.println("5. 배송조회");
		System.out.println("6. 회원탈퇴");
		System.out.println("7. 로그아웃");
		System.out.println();
	}
}