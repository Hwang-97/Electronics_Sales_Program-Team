package createObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class test 
{
	public static ArrayList<Basket> basketList;
	
	static
	{
		try
		{	
			basketList = new ArrayList<Basket>();
			
			BufferedReader reader = new BufferedReader(new FileReader("txtData\\장바구니 데이터.txt"));
			
			String line;
			while((line = reader.readLine()) != null)
			{
				String[] temp = line.split("▶");
				
				basketList.add(new Basket(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), temp[2], temp[3], Integer.parseInt(temp[4]), Integer.parseInt(temp[5])));
			}
			reader.close();
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		//makeBasket();
		//ContentData.makeQuery();
		//ContentData.makeReview();
	}
	private static void makeBasket() throws Exception
	{ 
		String path = "txtData\\";
			
		BufferedWriter writer = new BufferedWriter(new FileWriter(path + "장바구니 데이터.txt"));
				
		ArrayList<Basket> basketList = new ArrayList<Basket>();
		
		Random rnd = new Random();
			
		for(int n=0; n<5; n++)
		{
			for(int i=0; i<ProductList.productList.size(); i++)
			{
				basketList.add(new Basket(rnd.nextInt(300)+1, ProductList.productList.get(i).getProductNum(), ProductList.productList.get(i).getProductCode(), ProductList.productList.get(i).getProductName(), ProductList.productList.get(i).getProductPrice(), rnd.nextInt(5)+1));
			}
		}
		for(int i=0; i<basketList.size(); i++)
		{
			writer.write(String.format("%d▶%d▶%s▶%s▶%d▶%d\r\n", basketList.get(i).getMemberNum(), basketList.get(i).getProductNum(), basketList.get(i).getProductCode(), basketList.get(i).getProductName(), basketList.get(i).getProductPrice(), basketList.get(i).getProductCount()));
		}
		writer.close();
	}
}