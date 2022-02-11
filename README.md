![1 메인화면](https://user-images.githubusercontent.com/85034286/153455200-ecf940d9-21e7-43e4-951f-9c7168844d3d.png)

>  순수 JAVA를 이용한 전자제품 쇼핑몰 <br />
>  순수한 JAVA만을 이용해서 전자제품 쇼핑몰을 구현하였습니다.
   데이터는 txt파일을 프로그램 시작시 List에 저장해 사용하였고,
   이 후 프로그램 종료시 다시 txt파일에 write 하는 방식으로 구현하였습니다. <br />

<br />

# 📌 Table Of Contents
* [📖 Introduction](#-introduction)
* [🙋 My Role](#-my-role)
* [🔎 Detail](#-detail)
* [💡 Review](#-review)

<br />
<br />
<br />



# 📖 Introduction
### 1. 프로젝트 개요
* 해당 프로젝트는 순수Java를 활용한 console기반 프로젝트이며 전자제품 쇼핑몰을 구현하였습니다.
* 쇼핑몰 활용시 필요한 기초적인 기능을 모두 구현하였으며 관리자 페이지를 추가해서 회원 관리 상품 관리 통계등 관리자가 모든 데이터를 CRUD 가능하게 구현하였습니다.
<br />

### 2. 개발 환경
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"><img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">  
* 해당 프로젝트는 순수Java를 활용하여 제작했습니다.
* Eclips를 사용하여 프로젝트를 진행하였습니다.
* ![image](https://user-images.githubusercontent.com/85034286/153448359-d62945df-d095-4b2f-8afb-18063d9c19ee.png)
* ![image](https://user-images.githubusercontent.com/85034286/153448534-e5962347-4e32-4455-a36d-92d260832811.png)
* 형상 관리를 위해서 주로 깃허브랑 트렐로를 주로 사용하였습니다.
<br />

### 3. 프로젝트 내용
![1 메인화면](https://user-images.githubusercontent.com/85034286/153454860-2d211878-8e1e-43c4-80c9-8e9f85bc09ab.png)

<br />
<br />
<br />



# 🙋 My Role
### 1. 담당 업무
![image (1)](https://user-images.githubusercontent.com/85034286/153460611-faa7f1ab-f078-4f40-8512-9fb6088146d8.png)

#### 1-1. 주문 내역 확인
* 로그인 후 본인이 주문한 상품의 정보를 확인할 수 있습니다.

<br />
<br />

### 2. 담당 업무
![관리자로그인-회원정보관리-통계관리-회원통계](https://user-images.githubusercontent.com/85034286/153564074-ce151a8a-de21-40af-be30-fd0bb7ec0d09.png)

#### 2-1. 회원 정도 통계를 확인합니다.
* 관리자로 로그인 한 뒤 회원 정보 통계 , 매출 통계 , 상품 통계 등 모든 데이터의 통계를 확인할 수 있습니다.

<br />
<br />
<br />



# 🔎 Detail
### 1. 주요 코드
* 해당 메소드 외에도 각각의 메소드들이 상호작용하며 주문 정보 페이지를 구현합니다. 
    ```java
    private static void details() {
		String productPath = ".\\txtData\\product\\";	// 뒤에 상품 코드.txt를 넣어서 확인한다
		System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.print("주문번호입력 : ");						// 주문번호를 입력받으면 해당 번호를 주문 데이터에서 찾은뒤 상품코드를 반환
		String select = Main.scan.nextLine();
		int selectInt=0;
		try {
			selectInt=Integer.parseInt(select);
			int count =0;
			for(int i=0;i<orderList.size();i++) {
				if(selectInt==orderList.get(i).getOrderNumber()) {
					count++;											// 선택한 번호가 있는지 확인
					break;
				}
			}
			if(count==0) {
				System.out.println("주문번호를 확인해 주세요.");
				details();
			}
		}catch(Exception e) {
			System.out.println("주문번호를 확인해 주세요");
			details();
		}
		for(int i=0;i<orderList.size();i++) {
			if(orderList.get(i).getOrderNumber()==selectInt) {
				productPath+=orderList.get(i).getGoodsNumber()+"-";//상품번호 추가
				for(int j=0;j<productList.size();j++) {
					if(orderList.get(i).getGoodsNumber()==productList.get(j).getProductNum()) {
						productPath+=productList.get(j).getProductCode()+".txt";
					}
				}
				try {
					BufferedReader reader = new BufferedReader(new FileReader(productPath));
					String line = null;
					while((line=reader.readLine())!=null) {
						System.out.println(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}//if
		}
		menuOrderDetails();
		System.out.print("번호입력 : ");
		select = Main.scan.nextLine();
		int selectInt2=0;
		try {
			selectInt2=Integer.parseInt(select);
		}catch(Exception e){
			System.out.println("잘못 입력하셨습니다.");
			details();
		}
		switch(selectInt2) {
			case 0:
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				orderMain();								// 뒤로가기: 기본 주문 확인 페이지를 호출
				break;
			case 1:
				cancel(selectInt);								// 주문취소: 주문취소 함수 호출 선택한 주문번호를 넘김
				break;
			case 2:
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				review(selectInt);								// 리뷰: 리뷰 함수 호출 선택한 주문번호를 넘김
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				details();
				break;
		}
	}
    ```
* [장바구니 주문] 각각의 데이터를 자료형에 맞게 입력 받은 뒤 멤버 변수 에 저장한다 이후 해당 메소드를 실행하며 데이터를 입력한다.
    ```java
    private static void StartAdd() {
			int sum = 0;
			Set<Integer> key = buy.keySet();
			for(int i : key) {
				int productNum = i;
				for(int k=0;k<Main.basketList.size();k++) {//메인 장바구니 조작
					if(Main.basketList.get(k).getProductNum() == i) 
							
							{
						Main.basketList.get(k).setProductCount((Main.basketList.get(k).getProductCount()-buy.get(i)));
						break;
					}
				}
				/*
				for(int k=0;k<Main.memberList.size();k++) { //멤버장바구니 삭제 // 필요없는 행동;;
					if(Main.memberList.get(k).getMemberNumber()==memberNumber) {
						for(int m=0;m<Main.memberList.get(k).getBasketList().size();m++) {
							if(Main.memberList.get(k).getBasketList().get(m).get()==productNum) {
								Main.memberList.get(k).getBasketList().get(m).setProductCount(Main.memberList.get(k).getBasketList().get(m).getProductCount()-buy.get(i));;
								break;
							}
						}
						
					}
				}
				*/
				for(int j=0;j<buy.get(i);j++) {
					newOrder=new Order();
					newOrder.setOrderNumber(orderNumber);
					newOrder.setGoodsNumber(productNum);
					newOrder.setMemberNumber(memberNumber);
					newOrder.setUsePoint(usePoint/buyStoc);
					newOrder.setAccumulatePoint(price/100);
					newOrder.setName(name);
					newOrder.setAddress(address);
					newOrder.setPhoneNumber(phoneNumber);
					newOrder.setSelectPayment(selectPayment);
					newOrder.setCancelCheck(cancelCheck);
					newOrder.setOrderDate(orderDate);
					newOrder.setInvoiceNumber(invoiceNumber);
					/////////////////////////////////////////////////////////////주문정보;
					Main.orderList.add(newOrder);
					newTracking = new Tracking();
					newTracking.setDeliveryStatus("출고준비");
					newTracking.setOrderNumber(orderNumber);
					orderNumber++;
					Main.trackingList.add(newTracking);
					//////////////////////////////////////////////////////////////
					
				}
			}
			System.out.println("주문이 완료되었습니다.");
		}
    ```
* 통계에 필요한 모든 데이터를 List에 저장합니다.
    ```java
    private static void addList() {
		//비회원도 통합하여 계산 
		memberstat = new ArrayList<Member>();
		productStats = new ArrayList<Product>();
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 한번이라도 구매한 회원 복사
		for(i=0;i<Main.orderList.size();i++) {
			Main.memberList.stream().filter(m-> m.getMemberNumber()==Main.orderList.get(i).getMemberNumber()).forEach(m->memberstat.add(m));
		}
		for(i=0;i<Main.nonMemberOrderList.size();i++) {																																// 비회원 부분 상품 복사
			Main.nonMemberList.stream().filter(m->m.getMemberNumber()==Main.nonMemberOrderList.get(i).getMemberNumber()).forEach(m->memberstat.add(m));
		}
		//..........................................................................................................................................................................
		for(i=0;i<Main.orderList.size();i++) {																																		// 한번이라도 판매된 상품 복사 ( 중복이 없게 contain 확인) + 비회원도 진행
			Main.productList.stream().filter(p->p.getProductNum()==Main.orderList.get(i).getGoodsNumber() && !productStats.contains(p)).forEach(p->productStats.add(p));
		}
		for(i=0;i<Main.nonMemberOrderList.size();i++) {																																// 비회원 부분 상품 복사
			Main.productList.stream().filter(p->p.getProductNum()==Main.nonMemberOrderList.get(i).getGoodsNumber() && !productStats.contains(p)).forEach(p->productStats.add(p));
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 하위는 장바구니 관련
		basketMemberstat =new ArrayList<Member>();
		basketProductStats=new ArrayList<Product>();
		
		for(i=0;i<Main.basketList.size();i++) {																																		// 장바구니를 사용중인 회윈
			Main.memberList.stream().filter(m-> m.getMemberNumber()==Main.basketList.get(i).getMemberNum()).forEach(m->basketMemberstat.add(m));
		}
		/*
		for(i=0;i<Main.nonMemberBasketList.size();i++) {																															// 장바구니를 사용중인 비회윈
			Main.nonMemberList.stream().filter(m->m.getMemberNumber()==Main.basketList.get(i).getMemberNum()).forEach(m->basketMemberstat.add(m));
		}
		*/
		//.........................................................................................................................................................................
		for(i=0;i<Main.basketList.size();i++) {																																		// 한번이라도 장바구니에 들어간 상품(회원)
			Main.productList.stream().filter(p->p.getProductNum()==Main.basketList.get(i).getProductNum()).forEach(p->basketProductStats.add(p));
		}
		/*
		for(i=0;i<Main.nonMemberBasketList.size();i++) {																															// 한번이라도 장바구니에 들어간 상품(비회원)
			Main.productList.stream().filter(p->p.getProductNum()==Main.nonMemberBasketList.get(i).getProductNum()).forEach(p->basketProductStats.add(p));
		}
		*/
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 년간 회원 및 데이터 복사
		currenYearMember		= new ArrayList<Member>();
		currenYearProductStats	= new ArrayList<Product>();
		Calendar c = Calendar.getInstance();
		year 	   = String.format("%tF", c).substring(0,4);																														// 현재 년도 String 화
		for(i=0;i<Main.orderList.size();i++) {																																		// 회원 정보 복사
			String memberOrderYear =Main.orderList.get(i).getOrderDate().substring(0,4);
			Main.memberList.stream().filter(m-> memberOrderYear.equals(year) && Main.orderList.get(i).getMemberNumber()==m.getMemberNumber()).forEach(m->currenYearMember.add(m));
		}
		for(i=0;i<Main.nonMemberOrderList.size();i++) {																																// 비회원 정보 복사
			String nonMemberOrderYear =Main.nonMemberOrderList.get(i).getOrderDate().substring(0,4);
			Main.nonMemberList.stream().filter(m-> nonMemberOrderYear.equals(year) && Main.nonMemberOrderList.get(i).getMemberNumber()==m.getMemberNumber()).forEach(m->currenYearMember.add(m));
		}
		//...........................................................................................................................................................................
		for(i=0;i<Main.orderList.size();i++) {
			String memberOrderYear =Main.orderList.get(i).getOrderDate().substring(0,4);																							// 현재년도에 주문했던 상품 정보 복사
			Main.productList.stream().filter(p->memberOrderYear.equals(year) && Main.orderList.get(i).getGoodsNumber()==p.getProductNum() && !currenYearProductStats.contains(p)).forEach(p->currenYearProductStats.add(p));
			// 중복 방지 가능한지 확있했던 코드
		}
		for(i=0;i<Main.nonMemberOrderList.size();i++) {
			String nonMemberOrderYear =Main.nonMemberOrderList.get(i).getOrderDate().substring(0,4);																				// 현재년도에 주문했던 상품 정보 복사	
			Main.productList.stream().filter(p->nonMemberOrderYear.equals(year)&& Main.nonMemberOrderList.get(i).getGoodsNumber()==p.getProductNum() && !currenYearProductStats.contains(p)).forEach(p->currenYearProductStats.add(p));
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 월간 회원 및 데이터 복사
		currenMonthMember			= new ArrayList<Member>();
		currenMonthProductStats		= new ArrayList<Product>();
		month	   = String.format("%tF", c).substring(5,7);
		for(i=0;i<Main.orderList.size();i++) {																																		// 회원 정보 복사
			String memberOrderMonth =Main.orderList.get(i).getOrderDate().substring(5,7);
			Main.memberList.stream().filter(m-> memberOrderMonth.equals(month) && Main.orderList.get(i).getMemberNumber()==m.getMemberNumber()).forEach(m->currenMonthMember.add(m));
		}
		for(i=0;i<Main.nonMemberOrderList.size();i++) {																																// 비회원 정보 복사
			String nonMemberOrderMonth =Main.nonMemberOrderList.get(i).getOrderDate().substring(5,7);
			Main.nonMemberList.stream().filter(m-> nonMemberOrderMonth.equals(month) && Main.nonMemberOrderList.get(i).getMemberNumber()==m.getMemberNumber()).forEach(m->currenMonthMember.add(m));
		}
		//.........................................................................................................................................................................
		for(i=0;i<Main.orderList.size();i++) {
			String memberOrderMonth =Main.orderList.get(i).getOrderDate().substring(5,7);																							// 현재월에 주문했던 회원 정보 복사
			Main.productList.stream().filter(p->memberOrderMonth.equals(month) && Main.orderList.get(i).getGoodsNumber()==p.getProductNum() && !currenMonthProductStats.contains(p)).forEach(p->currenMonthProductStats.add(p));
		}
		for(i=0;i<Main.nonMemberOrderList.size();i++) {
			String nonMemberOrderMonth =Main.nonMemberOrderList.get(i).getOrderDate().substring(5,7);																				// 현재년도에 주문했던 상품 정보 복사	
			Main.productList.stream().filter(p->nonMemberOrderMonth.equals(month)&& Main.nonMemberOrderList.get(i).getGoodsNumber()==p.getProductNum() && !currenMonthProductStats.contains(p)).forEach(p->currenMonthProductStats.add(p));
		}
		
	}
    ```
    
<br />
<br />
<br />

# 💡 Review
### 1. 후기
* 해당 프로젝트를 진행하며 교육 중 배운 모든 기능을 한 번 이상 사용하려고 노력하였습니다.
  해당 과정에서 정확하게 사용하지 못했던 람다식 역시 확실하게 이해하는 계기가 되었습니다.
* 상품 주문시 메소드 간의 상호작용을 서로 return 하고 호출하는 방식으로 진행하면 유지보수시 어려울 수 있겠다 느끼게 되었습니다.
<br />
<br />
