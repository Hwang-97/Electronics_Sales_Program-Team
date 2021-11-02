package createObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class NonMemberBasketList {
	private static String path = "txtData\\비회원장바구니 데이터.txt";

	public static List<Basket> load() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = null;
		List<Basket> basketList = new ArrayList<Basket>();

		while ((line = reader.readLine()) != null) {
			String[] temp = line.split("▶");
			Basket b = new Basket();
//			System.out.println(temp[0]);
			
			b.setMemberNum(Integer.parseInt(temp[0]));
			b.setItemNumber(Integer.parseInt(temp[1]));
			b.setNumberOfItem(Integer.parseInt(temp[2]));
			
			basketList.add(b);
		}

		reader.close();
		return basketList;
	}

}
