package createObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.Main;

public class TrackingList {

	private static ArrayList<Tracking> list;
	private static String path = "txtData\\배송 데이터.txt";

	static {
		list = new ArrayList<Tracking>();
		File trackingFile = new File(path);
		if (trackingFile.exists()) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(path));
				String line = null;
				while ((line = reader.readLine()) != null) {
					String[] temp = line.split("▶");
					if (!temp[0].equals("주문번호")) {
						Tracking t = new Tracking();
						t.setOrderNumber(Integer.parseInt(temp[0]));
						t.setDeliveryStatus(temp[1]);
						list.add(t);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static List<Tracking> load() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = null;
		List<Tracking> trackingList = new ArrayList<Tracking>();

		while ((line = reader.readLine()) != null) {
			String[] temp = line.split("▶");
			if (!temp[0].equals("주문번호")) {
				Tracking t = new Tracking();
				t.setOrderNumber(Integer.parseInt(temp[0]));
				t.setDeliveryStatus(temp[1]);
				trackingList.add(t);
			}

		}

		reader.close();
		return trackingList;
	}

	public static void save() {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(path));
			String temp = "";
			for (Tracking t : Main.trackingList) {
				temp += t.getOrderNumber() + "▶" + t.getDeliveryStatus() + "\r\n";
			}
			writer.write(temp);
			writer.close();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ArrayList<Tracking> getList() {
		return list;
	}

	public static void setList(ArrayList<Tracking> list) {
		TrackingList.list = list;
	}

}
