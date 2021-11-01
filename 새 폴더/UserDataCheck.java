package Func;

public class UserDataCheck // 개인정보 확인
{
	public static void main() throws Exception
	{
		menuUserDataCheck();
		
		for(int i=0; i<main.main.memberList.size(); i++)
		{
			if(main.main.memberList.get(i).getId().equals(LoginInput.id))
			{
				System.out.println(main.main.memberList.get(i).toString());
				UserData.main();
				break;
			}
		}
	}
	private static void menuUserDataCheck()
	{
		System.out.println();
		System.out.println("#####개인정보 확인#####");
		System.out.println();
	}
}