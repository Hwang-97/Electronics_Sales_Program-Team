package main;

import java.util.Random;

import createObject.Basket;
import createObject.Member;
import createObject.Order;
import createObject.Product;

public class SearchMember {
	public static boolean main() {

		boolean loop = true;
		Random rnd = new Random();
		while (loop) {
			if (Main.nowLogin) {

				menuSearchMember();

				System.out.print("선택: ");
				int sel = Main.inputUserNum(0, Main.memberList.get(Main.memberList.size() - 1).getMemberNumber());
				Main.scan.nextLine();

				System.out.println("\n\n\n\n\n\n\n\n\n\n");

				switch (sel) {
				case 0:
					loop = false;
					break;
				default:
					for (Member m : Main.memberList) {
						if (m.getMemberNumber() == sel) {
							System.out.println(m);
							System.out.println("주문 조회");
							System.out.printf("[번호]\t[상품명]\t[모델명]\t[제조사]\t[가격]\t[배송주소]\r\n");
							int i = 1;
							for (Order o : m.getOrderList()) {
								for (Product p : Main.productList) {
									if (o.getGoodsNumber() == p.getProductNum()) {
										System.out.printf("%03d\t%s\t%s\t%s\t%d\t%s\r\n", i, p.getProductName(),
												p.getProductModel(), p.getProductCategory2Name(), p.getProductPrice(),
												rnd.nextBoolean() ? o.getAddress() : m.getAddress());
										i++;

									}
								}
							}
							System.out.println();
							System.out.println();
							System.out.println("장바구니 조회");
							System.out.printf("[번호]\t[상품명]\t[모델명]\t[제조사]\t[가격]\r\n");
							i = 1;
							for (Basket b : m.getBasketList()) {
								for (Product p : Main.productList) {
									if (b.getProductNum() == p.getProductNum()) {
										System.out.printf("%03d\t%s\t%s\t%s\t%d\r\n", i, p.getProductName(),
												p.getProductModel(), p.getProductCategory2Name(), p.getProductPrice());
										i++;
									}
								}
							}
							break;
						}
					}
					break;
				}

			} else {
				loop = false;
			}

		}
		return true;
	}

	private static void menuSearchMember() {
		System.out.println("────────────────────────────────────────────── [ 개인 회원 조회 ] ─────────────────────────────────────────────");
		//System.out.println("───────────────── [ 개인 회원 조회 ] ─────────────────");
		System.out.println("0. 뒤로가기");
		System.out.println("최대 " + Main.memberList.get(Main.memberList.size() - 1).getMemberNumber() + "까지");
		System.out.println("───────────────────────────────────────────────── [ 조회 ] ─────────────────────────────────────────────────");
	
	}
}
