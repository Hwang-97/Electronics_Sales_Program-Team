package createDump;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import main.Main;
//import java.util.ArrayList;
/**
 * 
 * @author 황현우
 *	상품상세정보를 txtData\product폴더에 덤프합니다.
 */
public class DetailPageDump {
	// 상세 페이지 상품 명으로 덤프
	private static String path = ".\\txtData\\product";
	private static ArrayList<String> list;
	/**
	 * 상품 상세정보 덤프
	 */
	public static void dump() {
		list = new ArrayList<String>();
		Main.productList.stream().map(p->p.getProductCode()).forEach(pc->list.add(pc));
		File file = new File(path);
		if(file.exists()) {
			try {
				for(int i=1;i<300;i++) {
					String s= "\t\t\t상품번호 : "+i+"번 상품의 상세정보 입니다." // i 부분을 상품 코드로 교체
							+ "blah blah blah";
					BufferedWriter writer = new BufferedWriter(new FileWriter(path+"\\"+i+"-"+list.get(i-1)+".txt"));
					writer.write(s);
					writer.close();
				}
				System.out.println("덤프 완료");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			file.mkdir();// 폴더가 없을시 폴더 생성후 다시 실행
			System.out.println("폴더 생성");
			dump();
		}
	}
}
