package main;

public class InputLogin {
	public static boolean main() throws Exception {
		// 메인 - 로그인 - 회원 로그인
		
		boolean loop = true;
		
		while (loop) {
			System.out.println("루프1**********");
			BuyProduct.gotoInput=false;
			if(Main.nowLogin) {	//로그인이 되어있는 경우
				System.out.println("루프2**********");
				printInputLogin();
				menuInputLogin();
				
				System.out.print("선택: ");
				int sel = Main.inputUserNum(1, 7);
				Main.scan.nextLine();
				
				System.out.println("\n\n\n\n\n\n\n\n\n\n");
				
				switch (sel) {
				case 1:
					loop = UserData.main();
					break;
				case 2:
					loop = OrderDetailsCheck.main();
					break;
				case 3:
					loop = BasketStart.main();
					break;
				case 4:
					loop = SearchProduct.main();
					break;
				case 5:
					loop = Delivery.main();
					break;
				case 6:
					loop = Withdraw.main();
					break;
				case 7:
					Main.id=null;
					Main.pw=null;
					Main.memberNumber=(Integer) null;
					Main.nowLogin=false;
					loop = false;
					break;
				}
				
			} else {			//로그인이 안돼있는 경우
				System.out.println("───────────────── [ 회원 로그인 ] ─────────────────");
				System.out.print("아이디 입력: ");
				Main.id=Main.scan.nextLine();
				System.out.print("패스워드 입력: ");
				Main.pw=Main.scan.nextLine();
				System.out.println();
				
				if(isValidLogin(Main.id, Main.pw)) { //로그인 성공했을 경우
//				System.out.println("로그인에 성공했습니다.");
					System.out.println("루프3**********");
					Main.nowLogin=true;
					printInputLogin();
					menuInputLogin();
					Main.memberList.stream().filter(
							m-> (m.getId().equals(Main.id)
									&& m.getPw().equals(Main.pw)))
							.forEach(m->Main.memberNumber = m.getMemberNumber());
					
					System.out.print("선택: ");
					int sel = Main.inputUserNum(1, 7);
					Main.scan.nextLine();
					
					System.out.println("\n\n\n\n\n\n\n\n\n\n");
					
					switch (sel) {
					case 1:
						loop = UserData.main();
						break;
					case 2:
						loop = OrderDetailsCheck.main();
						break;
					case 3:
						loop = BasketStart.main();
						break;
					case 4:
						loop = SearchProduct.main();
						break;
					case 5:
						System.out.print("배송조회로~");
						loop = Delivery.main();
						System.out.print("배송조회끝~");
						break;
					case 6:
						loop = Withdraw.main();
						break;
					case 7:
						Main.id=null;
						Main.pw=null;
						Main.nowLogin=false;
						loop = false;
						break;
					}
				} else { //로그인 실패했을 경우
					System.out.println("루프4**********");
					printFailLogin();
					
					System.out.print("선택: ");
					int sel = Main.inputUserNum(0, 1);
					
					switch(sel) {
					case 0:
						loop=false;
						break;
					case 1:
						Main.scan.nextLine();
						loop=true;
						break;
					}
				}
				
			}
			
			
			
		}// while (loop)
		return true;

	} // 메인 메소드

	private static void menuInputLogin() {
		
		// 메인 - 로그인 - 회원 로그인 후
		// 메뉴출력
		
		System.out.println("───────────────── [ 메뉴 목록 ] ─────────────────");
		System.out.println("1. 개인정보 확인");
		System.out.println("2. 구매내역");
		System.out.println("3. 장바구니");
		System.out.println("4. 상품조회");
		System.out.println("5. 배송조회");
		System.out.println("6. 회원탈퇴");
		System.out.println("7. 로그아웃");
		System.out.println("───────────────────────────────────────────────");                   
	}

	private static void printFailLogin() {
		System.out.println();
		System.out.println("───────────────── [ ❌ 로그인 실패 ❌ ] ─────────────────");
		System.out.println("로그인에 실패했습니다. 다시 입력하시겠습니까?");
		System.out.println("0. 뒤로가기");
		System.out.println("1. 다시 입력하기");
	}
	
	private static void printInputLogin() {
		System.out.println("───────────────── [ ⭕ 로그인 성공 ⭕ ] ─────────────────");
		
	}

	private static boolean isValidLogin(String id, String pw) {
		for(int i=0; i<Main.memberList.size(); i++)
		{
			if(Main.memberList.get(i).getId().equals(id))
			{
				break;
			}
			else if(i == Main.memberList.size()-1 && !(Main.memberList.get(i).getId().equals(id)))
			{
				System.out.println("잘못된 아이디입니다");
				return false;
			}
			else
			{
				continue;
			}
		}
		
	      for(int i=0; i<Main.memberList.size(); i++)
	      {
	         if(Main.memberList.get(i).getId().equals(id) && Main.memberList.get(i).getPw().equals(pw))
	         {
	            return true;
	         }
	         else if(i == Main.memberList.size()-1 && !(Main.memberList.get(i).getId().equals(id) && Main.memberList.get(i).getPw().equals(pw)))
	         {
	            System.out.println("잘못된 비밀번호입니다");
	            return false;
	         }
	         else
	         {
	            continue;
	         }
		}
		
		
		
		return true;
	}

}
