// 이상승님 코드
package createObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class ContentData
{		
	public static ArrayList<Query> queryList;
	public static ArrayList<Review> reviewList;
	
	static
	{
		try
		{	
			queryList = new ArrayList<Query>();
			
			BufferedReader reader = new BufferedReader(new FileReader("txtData\\상품 문의.txt"));
			
			String line;
			while((line = reader.readLine()) != null)
			{
				String[] temp = line.split("▶");
				
				queryList.add(new Query(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), temp[2], temp[3], temp[4]));
			}
			reader.close();
			
			reviewList = new ArrayList<Review>();
			
			reader = new BufferedReader(new FileReader("txtData\\상품 리뷰.txt"));
			
			while((line = reader.readLine()) != null)
			{
				String[] temp = line.split("▶");
				
				reviewList.add(new Review(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), temp[2], Integer.parseInt(temp[3]), temp[4]));
			}
			reader.close();
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void makeQuery() throws Exception // 문의 더미 데이터 생성
	{
		String path = "txtData\\";
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(path + "상품 문의.txt"));
			
		ArrayList<Query> queryList = new ArrayList<Query>();
		
		Random rnd = new Random();
		
		String[] queryContentList = {"상품이 언제 도착할까요?", "할인 이벤트 끝났나요?", "이거 정품인가요?", "A 기기와 호환이 될까요?", "화이트 계열은 없나요?", "언제 재입고되나요?"};
		String[] answerContentList = {"해당 상품은 어제 배송 시작했으며 2~3일 내에 받으실 수 있습니다", "이벤트는 3일 전에 끝났으며 현재 상품은 정상가로 판매되고 있습니다", "당사 판매점에서는 정품 인증을 받은 상품만 판매하고 있습니다", 
									  "해당 상품은 A 기기와 호환됩니다", "이 제품은 현재 블랙과 블루 색상으로만 출시되었습니다", "해당 상품은 이번주 금요일에 재입고 예정입니다"};
		
		int count = 1;
		for(int n=0; n<5; n++)
		{
			for(int i=0; i<ProductList.productList.size(); i++)
			{
				queryList.add(new Query(count, rnd.nextInt(300)+1, ProductList.productList.get(i).getProductCode(), queryContentList[rnd.nextInt(6)], answerContentList[rnd.nextInt(6)]));
				count++;
			}
		}
		for(int i=0; i<queryList.size(); i++)
		{
			writer.write(String.format("%d▶%d▶%s▶%s▶%s\r\n", queryList.get(i).getQueryNum(), queryList.get(i).getMemberNum(), queryList.get(i).getItemCode(), queryList.get(i).getQueryContent(), queryList.get(i).getAnswerContent()));
		}
		writer.close();
	}
	public static void saveQuery() throws Exception // 문의 데이터 저장
	{
		String path = "txtData\\";
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(path + "상품 문의.txt"));
		
		for(int i=0; i<queryList.size(); i++)
		{
			writer.write(String.format("%d▶%s▶%s▶%s\r\n", queryList.get(i).getMemberNum(), queryList.get(i).getItemCode(), queryList.get(i).getQueryContent(), queryList.get(i).getAnswerContent()));
		}
		writer.close();
	}
	public static void makeReview() throws Exception // 리뷰 더미 데이터 생성
	{
		String path = "txtData\\";
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(path + "상품 리뷰.txt"));
		
		ArrayList<Review> reviewList = new ArrayList<Review>();
		
		Random rnd = new Random();
		
		String[] reviewContentList = {"디자인이 너무 이뻐요", "모서리가 깨져서 왔어요", "생각보다 성능이 좋지 않아요", "가성비 최고에요", "타사 A 제품과 스펙은 별로 차이나지 않는데 가격이 너무 비싸요", "배송이 빨라서 좋았어요"};
		
		int count = 1;
		for(int n=0; n<5; n++)
		{
			for(int i=0; i<ProductList.productList.size(); i++)
			{
				reviewList.add(new Review(count, rnd.nextInt(300)+1, ProductList.productList.get(i).getProductCode(), rnd.nextInt(5)+1, reviewContentList[rnd.nextInt(6)]));
				count++;
			}
		}
		for(int i=0; i<reviewList.size(); i++)
		{
			writer.write(String.format("%d▶%d▶%s▶%d▶%s\r\n", reviewList.get(i).getReviewNum(), reviewList.get(i).getMemberNum(), reviewList.get(i).getItemCode(), reviewList.get(i).getItemScore(), reviewList.get(i).getReviewContent()));
		}
		writer.close();
	}
	public static void saveReview() throws Exception // 리뷰 데이터 저장
	{
		String path = "txtData\\";
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(path + "상품 리뷰.txt"));
		
		for(int i=0; i<main.Main.reviewList.size(); i++)
		{
			writer.write(String.format("%d▶%d▶%s▶%d▶%s\r\n", main.Main.reviewList.get(i).getReviewNum(), main.Main.reviewList.get(i).getMemberNum(), main.Main.reviewList.get(i).getItemCode(), main.Main.reviewList.get(i).getItemScore(), main.Main.reviewList.get(i).getReviewContent()));
		}
		writer.close();
	}
}