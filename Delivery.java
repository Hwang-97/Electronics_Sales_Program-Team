package Func;

import java.util.Scanner;

public class Delivery 
{
	public static void main() throws Exception
	{
		menuDelivery();
		
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
				case 0:
					Func.MemberMain.main();
					break;
				case 1:
					//
					break;
				default:
					System.out.println("잘못된 번호입니다");
					Func.MemberMain.main();
					break;	
			}
		}
	}
	private static void menuDelivery()
	{
		System.out.println();
		System.out.println("#####배송조회#####");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 배송조회");
		System.out.println();
	}
}	