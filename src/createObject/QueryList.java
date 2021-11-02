package createObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class QueryList {
	private static String path = "txtData\\상품 문의.txt";

	public static List<Query> load() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = null;
		List<Query> querylist = new ArrayList<Query>();

		while ((line = reader.readLine()) != null) {
			String[] temp = line.split("▶");
			Query q = new Query(Integer.parseInt(temp[0]), temp[1], temp[1], temp[2]);
//			q.setMemberNum(Integer.parseInt(temp[0]));
//			q.setItemNumber(Integer.parseInt(temp[1]));
//			q.setNumberOfItem(Integer.parseInt(temp[2]));
			querylist.add(q);
		}
		reader.close();
		
		return querylist;
	}
}
