package main;

import java.util.ArrayList;
import java.util.Collections;

import createObject.Product;

public class SortProduct {
	public static boolean main(int sel, int category1, int category2) {
		// 1. 최저가 / 2. 최고가순 / 3. test(미구현)

		System.out.println("\n\n\n\n\n");
			switch (sel) {
			case 1:
				
				ArrayList<Product> temp = new ArrayList<Product>();

				for (Product p : Main.productList) {
					if (Integer.parseInt(p.getProductCategory1()) == category1
							&& Integer.parseInt(p.getProductCategory2()) == category2) {
						/*
						 * System.out.printf("%s\t" //상품번호 + "%s\t" //상품코드 + "%s\t" //상품명 + "%s\t"
						 * //모델이름 + "%s\t" //카테고리1 + "%s\t" //카테고리2 + "%,8d원\t" //가격 + "%s개\t" //재고 +
						 * "%s%%\t" //할인율 + "%s회\t" //주문횟수 + "%s회\n" //환불횟수 ,p.getProductNum()
						 * ,p.getProductCode() ,p.getProductName() ,p.getProductModel()
						 * ,p.getProductCategory1Name() ,p.getProductCategory2Name()
						 * ,p.getProductPrice() ,p.getProductStock() ,p.getProductSale()*100
						 * ,p.getProductOrderNum() ,p.getProductRefundNum());
						 */
						temp.add(p);
					}
				}

				Collections.sort(temp, Collections.reverseOrder());

				int count=0;
				System.out.println("상품번호\t상품코드\t\t상품명\t모델이름\t카테고리1\t카테고리2\t\t      가격\t재고\t할인율\t주문횟수\t환불횟수");
				for (Product p : temp) {
					System.out.printf("%s\t" // 상품번호
							+ "%s\t" // 상품코드
							+ "%s\t" // 상품명
							+ "%s\t" // 모델이름
							+ "%s\t" // 카테고리1
							+ "%s\t\t" // 카테고리2
							+ " %,8d원\t" // 가격
							+ " %s개\t" // 재고
							+ " %s%%\t" // 할인율
							+ " %s회\t" // 주문횟수
							+ "%s회\n" // 환불횟수
							, p.getProductNum(), p.getProductCode(), p.getProductName(), p.getProductModel(),
							p.getProductCategory1Name(), p.getProductCategory2Name(), p.getProductPrice(), p.getProductStock(),
							p.getProductSale() * 100, p.getProductOrderNum(), p.getProductRefundNum());
					count++;
				}
				System.out.print("최저가순 목록 ");
				System.out.printf("\n총 %d개의 상품을 찾았습니다.\n", count);
				break;
			case 2:
				temp = new ArrayList<Product>();

				for (Product p : Main.productList) {
					if (Integer.parseInt(p.getProductCategory1()) == category1
							&& Integer.parseInt(p.getProductCategory2()) == category2) {
						/*
						 * System.out.printf("%s\t" //상품번호 + "%s\t" //상품코드 + "%s\t" //상품명 + "%s\t"
						 * //모델이름 + "%s\t" //카테고리1 + "%s\t" //카테고리2 + "%,8d원\t" //가격 + "%s개\t" //재고 +
						 * "%s%%\t" //할인율 + "%s회\t" //주문횟수 + "%s회\n" //환불횟수 ,p.getProductNum()
						 * ,p.getProductCode() ,p.getProductName() ,p.getProductModel()
						 * ,p.getProductCategory1Name() ,p.getProductCategory2Name()
						 * ,p.getProductPrice() ,p.getProductStock() ,p.getProductSale()*100
						 * ,p.getProductOrderNum() ,p.getProductRefundNum());
						 */

						temp.add(p);
					}
				}

				Collections.sort(temp);
				
				count=0;
				System.out.println("상품번호\t상품코드\t\t상품명\t모델이름\t카테고리1\t카테고리2\t\t      가격\t재고\t할인율\t주문횟수\t환불횟수");
				for (Product p : temp) {
					System.out.printf("%s\t" // 상품번호
							+ "%s\t" // 상품코드
							+ "%s\t" // 상품명
							+ "%s\t" // 모델이름
							+ "%s\t" // 카테고리1
							+ "%s\t\t" // 카테고리2
							+ " %,8d원\t" // 가격
							+ " %s개\t" // 재고
							+ " %s%%\t" // 할인율
							+ " %s회\t" // 주문횟수
							+ "%s회\n" // 환불횟수
							, p.getProductNum(), p.getProductCode(), p.getProductName(), p.getProductModel(),
							p.getProductCategory1Name(), p.getProductCategory2Name(), p.getProductPrice(), p.getProductStock(),
							p.getProductSale() * 100, p.getProductOrderNum(), p.getProductRefundNum());
					count++;
				}
				System.out.print("최고가순 목록 ");
				System.out.printf("\n총 %d개의 상품을 찾았습니다.\n", count);
				break;
			}


		return true;
	}
}
