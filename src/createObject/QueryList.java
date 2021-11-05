package createObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.Main;

public class QueryList {
	private static String path = "txtData\\상품 문의.txt";

	public static List<Query> load() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = null;
		List<Query> querylist = new ArrayList<Query>();

		while ((line = reader.readLine()) != null) {
			String[] temp = line.split("▶");
			Query q = new Query(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), temp[2], temp[3], temp[4]);
			querylist.add(q);
		}
		reader.close();

		return querylist;
	}

	public static void save() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			String temp = "";
			for (Query q : Main.queryList) {
				temp += q.getQueryNum() + "▶";
				temp += q.getMemberNum() + "▶";
				temp += q.getItemCode() + "▶";
				temp += q.getQueryContent() + "▶";
				temp += q.getAnswerContent()+"\r\n";
			}
			writer.write(temp);
			writer.close();

		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}

	}
}
