package createObject;

import main.Main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderList {
	private static String path = "txtData\\주문데이터.txt";

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
			d.setInvoiceNumber(temp[11]);
			orderList.add(d);
		}

		reader.close();
		return orderList;
	}

	public static void save() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			String temp = "";
			for (Order o : Main.orderList) {
				temp += o.getOrderNumber() + "▶";
				temp += o.getGoodsNumber() + "▶";
				temp += o.getMemberNumber() + "▶";
				temp += o.getUsePoint() + "▶";
				temp += o.getAccumulatePoint() + "▶";
				temp += o.getName() + "▶";
				temp += o.getAddress() + "▶";
				temp += o.getPhoneNumber() + "▶";
				temp += o.getSelectPayment() + "▶";
				temp += o.isCancelCheck() + "▶";
				temp += String.format("%tF", o.getOrderDate()) + "▶";
				temp += o.getInvoiceNumber() + "▶";
				temp += "\r\n";
			}

			writer.write(temp);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
