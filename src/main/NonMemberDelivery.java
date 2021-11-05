package main;

import java.util.Scanner;

public class NonMemberDelivery 
{
	
		public static boolean main() throws Exception
		{
			menuNonMemberDelivery(); // 비회원 배송 메뉴 출력
			
			System.out.print("번호 입력 : ");
			
			try(Scanner scanner = new Scanner(System.in)) 
			{
				if(!scanner.hasNextInt())
				{
					System.out.println("잘못된 번호입니다");
					NonMemberDelivery.main(); // 배송 메뉴로
				}
				int num = scanner.nextInt();
				
				switch(num)
				{
					case 0: // 뒤로가기
						NonMemberLogin.main(); // 비회원 메인으로
						break;
					case 1: // 배송조회
						//NonMemberDeliverySearch.main(); // 회원 배송 조회 메뉴로
						break;
					default:
						System.out.println("잘못된 번호입니다");
						NonMemberDelivery.main(); // 회원 배송 메뉴로
						break;	
				}
			}
			return true;
		}
		private static void menuNonMemberDelivery() // 배송 메뉴 출력
		{
			System.out.println();
			System.out.println("#####배송조회#####");
			System.out.println("0. 뒤로가기");
			System.out.println("1. 배송조회");
			System.out.println();
		}
	}	

