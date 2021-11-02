package createObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReviewList {
	private static String path = "txtData\\상품 리뷰.txt";

	public static List<Review> load() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = null;
		List<Review> reviewList = new ArrayList<Review>();

		while ((line = reader.readLine()) != null) {
			String[] temp = line.split("▶");
			Review r = new Review(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), temp[3]);
			
			reviewList.add(r);
		}

		reader.close();
		return reviewList;
	}
}
