package main;

public class FindID {
	public static boolean main() {
		menuFindID();
		
		System.out.print("이름 입력 : ");
		try 
		{
			String name = Main.scan.nextLine();
			
			for(int i=0; i<Main.memberList.size(); i++)
			{
				if(Main.memberList.get(i).getName().equals(name))
				{
					break;
				}
				else if(i == Main.memberList.size()-1 && !(Main.memberList.get(i).getName().equals(name)))
				{
					System.out.println("잘못된 이름입니다");
					return true;
				}
				else
				{
					continue;
				}
			}
			System.out.print("주민등록번호 입력 : ");
			String jumin = Main.scan.nextLine();
			
			for(int i=0; i<Main.memberList.size(); i++)
			{
				if(Main.memberList.get(i).getName().equals(name) && Main.memberList.get(i).getRegistrationNumber().equals(jumin))
				{
					System.out.println("아이디 : " + Main.memberList.get(i).getId());
					return true;
				}
				else if(i == Main.memberList.size()-1 && 
						!(Main.memberList.get(i).getRegistrationNumber().equals(jumin)))
				{
					System.out.println("잘못된 주민등록번호입니다");
					return true;
				}
				else
				{
					continue;
				}
			}
		} catch (Exception e) {
			System.out.println("로그인으로 돌아갑니다.");
		}
		return true;
	}

	private static void menuFindID() {
		System.out.println();
		System.out.println("#####아이디 찾기#####");
		System.out.println();
	}
}












