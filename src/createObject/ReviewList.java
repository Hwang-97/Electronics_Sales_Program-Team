package createObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.Main;

public class ReviewList {
	private static String path = "txtData\\상품 리뷰.txt";

	public static List<Review> load() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = null;
		List<Review> reviewList = new ArrayList<Review>();

		while ((line = reader.readLine()) != null) {
			String[] temp = line.split("▶");
			Review r = new Review(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), temp[2], Integer.parseInt(temp[3]), temp[4]);
			
			reviewList.add(r);
		}

		reader.close();
		return reviewList;
	}
	public static void save() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			String temp="";
			
			for(Review r : Main.reviewList) {
				temp+=r.getReviewNum()+"▶";
				temp+=r.getMemberNum()+"▶";
				temp+=r.getItemCode()+"▶";
				temp+=r.getItemScore()+"▶";
				temp+=r.getReviewContent()+"\r\n";
			}
			
			writer.write(temp);
			writer.close();
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
