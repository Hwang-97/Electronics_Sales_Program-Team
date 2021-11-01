package Func;

import java.util.Scanner;

public class UserDataEdit // 개인정보 수정
{
	public static void main()
	{
		menuUserDataEdit();
		
		System.out.print("번호 입력 : ");
		
		try(Scanner scanner = new Scanner(System.in)) 
		{
			
		}
	}
	private static void menuUserDataEdit()
	{
		System.out.println();
		System.out.println("#####개인정보 수정#####");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 비밀번호");
		System.out.println("2. 전화번호");
		System.out.println("3. 이메일");
		System.out.println("4. 주소");
		System.out.println();
	}
}