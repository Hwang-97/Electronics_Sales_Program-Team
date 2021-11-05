package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import createObject.Basket;
import createObject.Member;
import createObject.Product;

public class BasketRemove {

	
	public static boolean main() {
		
		//메인 - 로그인 - 회원 - 장바구니
		//로그인 한 회원이 장바구니 바로 조회할 수 있다.
		boolean loop = true;
		
		while (loop) {
			
			if(Main.nowLogin) {	
				
				//TODO 삭제하는 구문 추가
//				Main.basketList.removeAll(Main.basketList.);
				
				System.out.println("해당 장바구니는 초기화 되었습니다.");
				menuInputBasket();
				
				System.out.print("선택: ");
				int sel = Main.inputUserNum(0,0);
				Main.scan.nextLine();
				
				System.out.println("\n\n\n\n\n\n\n\n\n\n");
					
			
			
			switch(sel) {
			case 0:
				return false;		//뒤로가기 -> 로그인 메뉴 목록으로 돌아감 InputLogin.main()
			}
			
			
			
			}
		}
		
		return true;
				
			
	}//main  메소드
			
			
		private static void menuInputBasket() {
			
			// 메인 - 로그인 - 회원 - 장바구니 - 하위 메뉴
			// 메뉴출력
			
			System.out.println("─────────────────────────────────────────── +-+-+|M|E|N|U|+-+-+ ───────────────────────────────────────────");
			System.out.println("\t\t\t 0. 뒤로가기");
			System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
			
			              
		}
	
	
}
