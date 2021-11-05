/*
package createObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class BasketList {
	private static String path = "txtData\\장바구니 데이터.txt";

	public static List<Basket> load() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = null;
		List<Basket> basketList = new ArrayList<Basket>();

		while ((line = reader.readLine()) != null) {
			String[] temp = line.split("▶");
			Basket b = new Basket(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), temp[2], temp[3], Integer.parseInt(temp[4]), Integer.parseInt(temp[5]));
			
			basketList.add(b);
		}

		reader.close();
		return basketList;
	}

}
*/

package createObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.Main;

public class BasketList {
	private static String path = "txtData\\장바구니 데이터.txt";

	public static List<Basket> load() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = null;
		List<Basket> basketList = new ArrayList<Basket>();

		while ((line = reader.readLine()) != null) {
			String[] temp = line.split("▶");
			Basket b = new Basket(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), temp[2], temp[3], Integer.parseInt(temp[4]), Integer.parseInt(temp[5]));

			basketList.add(b);
		}

		reader.close();
		return basketList;
	}

	/*
	
	private int memberNum; // 회원번호
	private int productNum; // 상품번호
	private String productCode; // 상품코드
	private String productName; // 상품명
	private int productPrice; // 상품금액
	private int productCount; // 상품수량
	
	*/
	public static void save() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			String temp = "";
			for (Basket b : Main.basketList) {
				temp += b.getMemberNum() + "▶" + b.getProductNum() + "▶" + b.getProductCode() + "▶" + b.getProductName() + "▶" + b.getProductPrice() + "▶" + b.getProductCount() + "\r\n";
			}
			writer.write(temp);
			writer.close();

		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}

	}

}
