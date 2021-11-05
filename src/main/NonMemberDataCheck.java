package main;

public class NonMemberDataCheck {
	public static boolean main()
	{
		menuUserDataCheck();
		
		for(int i=0; i<Main.nonMemberList.size(); i++)
		{
			if(Main.nonMemberList.get(i).getId().equals(Main.id))
			{
				System.out.println(Main.nonMemberList.get(i).toString());
				return true;
			}
		}
		return false;
	}
	private static void menuUserDataCheck()
	{
		System.out.println();
		System.out.println("──────────────────────────────────────────────── [ 개인정보 ] ───────────────────────────────────────────────");
		System.out.println();
	}
}
