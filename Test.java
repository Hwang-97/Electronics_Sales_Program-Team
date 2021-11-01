package Func;

import main.*;
//import createObject.*;
//import createDump.*;

public class Test // execute file
{
	public static void main(String[] args) throws Exception
	{
		load();
		
		Main.main();
		
		save();
	}
	private static void load() throws Exception // load all files
	{
		main.memberList = createObject.MemberList.load();
		main.basketList = createObject.BasketList.load();
		main.orderList = createObject.OrderList.load();
		main.productList = createObject.ProductList.load();
		main.queryList = createObject.QueryList.load();
		main.reviewList = createObject.ReviewList.load();
		main.trackingList = createObject.TrackingList.load();
	}
	private static void save() throws Exception // save all files
	{
		
	}
}