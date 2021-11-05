package main;

import createObject.Basket;

public class AddBasket {
	public static boolean main(int productNum, String productCode) {
		// 장바구니 추가
		// 1. 추가되어있는지 확인
		// 1-1 안되어 있으면 추가
		// 2. 되어있으면 이미 되어있다고 출력
		
		printAddBasket();
		
		if(isInBasket(productNum, Main.memberNumber))
		{ //회원 장바구니에 존재한다면
			for(int i=0; i<Main.basketList.size(); i++)
			{
				if(Main.memberNumber == Main.basketList.get(i).getMemberNum())
				{
					if(Main.basketList.get(i).getProductNum() == productNum)
					{
						Main.basketList.get(i).setProductCount(Main.basketList.get(i).getProductCount()+1);
					}
				}
			}
			System.out.println("- 이미 상품이 장바구니에 존재합니다. -");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		} else {
			addBasket(productNum, Main.memberNumber);
			System.out.println("- 상품을 장바구니에 추가했습니다. -");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
		}
		return true;
	}
	
	private static void addBasket(int productNum, int memberNumber) {
		
		Basket b = new Basket();
		
		for(int i=0; i<Main.basketList.size(); i++)
		{
			if(memberNumber == Main.basketList.get(i).getMemberNum())
			{
				b.setProductNum(productNum);
				b.setMemberNum(memberNumber);
				b.setProductCode(Main.basketList.get(i).getProductCode());
				b.setProductName(Main.basketList.get(i).getProductName());
				b.setProductPrice(Main.basketList.get(i).getProductPrice());
				b.setProductCount(1);
				Main.basketList.add(b);
				
				break;
			}
		}
		
		
		
	}

	public static boolean isInBasket(int productNum, int memberNumber) {
		for(Basket b: Main.basketList) {
			if(b.getMemberNum()==memberNumber) {	//장바구니 주인이 로그인한 주인
				if(b.getProductNum()==productNum) { 			//장바구니 아이템이 현재 상세보기 아이템인지
					return true;
				}
			}
		}
		return false;
	}
	private static void printAddBasket() {
		
		System.out.println("   _                  _                     \r\n"
				+ "  /  |_   _   _ |    |_)  _.  _ |   _ _|_   \r\n"
				+ "  \\_ | | (/_ (_ |<   |_) (_| _> |< (/_ |_   \r\n"
				+ "                                            ");
		System.out.println("===========================================================================================================");
		System.out.println();
		System.out.println();
		

	}
}
