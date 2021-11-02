package main;

public class UserDataCheck {
	public static boolean main()
	{
		menuUserDataCheck();
		
		for(int i=0; i<Main.memberList.size(); i++)
		{
			if(Main.memberList.get(i).getId().equals(Main.id))
			{
				System.out.println(Main.memberList.get(i).toString());
				return true;
			}
		}
		return false;
	}
	private static void menuUserDataCheck()
	{
		System.out.println();
		System.out.println("#####개인정보 확인#####");
		System.out.println();
	}
}
