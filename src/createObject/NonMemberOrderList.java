package createObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class NonMemberOrderList {
	private static String path = "txtData\\비회원주문데이터.txt";

	public static List<Order> load() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = null;
		List<Order> orderList = new ArrayList<Order>();

		while ((line = reader.readLine()) != null) {
			String[] temp = line.split("▶");
			Order d = new Order();
			d.setOrderNumber(Integer.parseInt(temp[0]));
			d.setGoodsNumber(Integer.parseInt(temp[1]));
			d.setMemberNumber(Integer.parseInt(temp[2]));
			d.setUsePoint(Integer.parseInt(temp[3]));
			d.setAccumulatePoint(Integer.parseInt(temp[4]));
			d.setName(temp[5]);
			d.setAddress(temp[6]);
			d.setPhoneNumber(temp[7]);
			d.setSelectPayment(temp[8]);
			d.setCancelCheck(temp[9].equals("true"));
			d.setOrderDate(temp[10]);
			orderList.add(d);
		}

		reader.close();
		return orderList;
	}
	
	

}
