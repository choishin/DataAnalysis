package Metadata;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	static Data data = new Data();
	static UsersChoice user = new UsersChoice();
	static FileRead fileread = new FileRead();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		while(true) {
			
		showMenu();
		getServiceType();
		fileread.readData();
		
		}

	}//main

	public static void showMenu() throws IOException {

		System.out.println("[한국전력공사_시군구별 용도업종별 전력사용량_20170504(출처 : 공공데이터포털)]");
		System.out.println("▶지역을 선택해주세요");
		for (int i=1; i<data.areas.length; i++) {
			System.out.printf("%d.%s ",i, data.areas[i]);
			if (i%4 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		//지역 선택 받기
		int AreaType = scanner.nextInt();
		//선택받은 지역 이름 저장
		String usersArea = data.areas[AreaType];
		user.usersArea = usersArea;
		System.out.printf("%s를 선택하셨습니다.\n▶시군구를 선택해주세요.\n",usersArea);
		//시군구 선택으로 이동
		if (AreaType == 1) { 
			for (int i=1; i<data.seoul.length; i++) {
				System.out.printf("%d.%s ",i, data.seoul[i]);
				if (i%4 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			int type2 = scanner.nextInt();
			String usersCity = data.seoul[type2];
			user.usersCity = usersCity;
		}
		else if (AreaType == 2) { 
			for (int i=1; i<data.busan.length; i++) {
				System.out.printf("%d.%s ",i, data.busan[i]);
				if (i%4 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			int type2 = scanner.nextInt();
			String usersCity = data.busan[type2];
			user.usersCity = usersCity;
		}
		else if (AreaType == 3) { 
			for (int i=1; i<data.daegu.length; i++) {
				System.out.printf("%d.%s ",i, data.daegu[i]);
				if (i%4 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			int type2 = scanner.nextInt();
			String usersCity = data.daegu[type2];
			user.usersCity = usersCity;
		}
		else if (AreaType == 4) { 
			for (int i=1; i<data.incheon.length; i++) {
				System.out.printf("%d.%s ",i, data.incheon[i]);
				if (i%4 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			int type2 = scanner.nextInt();
			String usersCity = data.incheon[type2];
			user.usersCity = usersCity;
		}
		else if (AreaType == 5) { 
			for (int i=1; i<data.gwangju.length; i++) {
				System.out.printf("%d.%s ",i, data.gwangju[i]);
				if (i%4 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			int type2 = scanner.nextInt();
			String usersCity = data.gwangju[type2];
			user.usersCity = usersCity;
		}
		else if (AreaType == 6) { 
			for (int i=1; i<data.daejeon.length; i++) {
				System.out.printf("%d.%s ",i, data.daejeon[i]);
				if (i%4 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			int type2 = scanner.nextInt();
			String usersCity = data.daejeon[type2];
			user.usersCity = usersCity;
		}
		else if (AreaType == 7) { 
			for (int i=1; i<data.ulsan.length; i++) {
				System.out.printf("%d.%s ",i, data.ulsan[i]);
				if (i%4 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			int type2 = scanner.nextInt();
			String usersCity = data.daejeon[type2];
			user.usersCity = usersCity;
		}
		else if (AreaType == 8) { 
			for (int i=1; i<data.gyeonggi.length; i++) {
				System.out.printf("%d.%s ",i, data.gyeonggi[i]);
				if (i%4 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			int type2 = scanner.nextInt();
			String usersCity = data.gyeonggi[type2];
			user.usersCity = usersCity;
		}
		else if (AreaType == 9) { 
			for (int i=1; i<data.gangwon.length; i++) {
				System.out.printf("%d.%s ",i, data.gangwon[i]);
				if (i%4 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			int type2 = scanner.nextInt();
			String usersCity = data.gangwon[type2];
			user.usersCity = usersCity;
		}
		else if (AreaType == 10) { 
			for (int i=1; i<data.chungbuk.length; i++) {
				System.out.printf("%d.%s ",i, data.chungbuk[i]);
				if (i%4 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			int CityType = scanner.nextInt();
			String usersCity = data.chungbuk[CityType];
			user.usersCity = usersCity;
		}
		else if (AreaType == 11) { 
			for (int i=1; i<data.chungnam.length; i++) {
				System.out.printf("%d.%s ",i, data.chungnam[i]);
				if (i%4 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			int type2 = scanner.nextInt();
			String usersCity = data.chungnam[type2];
			user.usersCity = usersCity;
		}
		else if (AreaType == 12) { 
			for (int i=1; i<data.jeonbuk.length; i++) {
				System.out.printf("%d.%s ",i, data.jeonbuk[i]);
				if (i%4 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			int type2 = scanner.nextInt();
			String usersCity = data.jeonbuk[type2];
			user.usersCity = usersCity;
		}
		else if (AreaType == 13) { 
			for (int i=1; i<data.jeonnam.length; i++) {
				System.out.printf("%d.%s ",i, data.jeonnam[i]);
				if (i%4 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			int type2 = scanner.nextInt();
			String usersCity = data.jeonnam[type2];
			user.usersCity = usersCity;
		}
		else if (AreaType == 14) { 
			for (int i=1; i<data.gyeongbuk.length; i++) {
				System.out.printf("%d.%s ",i, data.gyeongbuk[i]);
				if (i%5 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			int type2 = scanner.nextInt();
			String usersCity = data.gyeongbuk[type2];
			user.usersCity = usersCity;
		}
		else if (AreaType == 15) { 
			for (int i=1; i<data.gyeongnam.length; i++) {
				System.out.printf("%d.%s ",i, data.gyeongnam[i]);
				if (i%4 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			int type2 = scanner.nextInt();
			String usersCity = data.gyeongnam[type2];
			user.usersCity = usersCity;
		}
		else if (AreaType == 16) { 
			for (int i=1; i<data.jeju.length; i++) {
				System.out.printf("%d.%s ",i, data.jeju[i]);
				if (i%4 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			int type2 = scanner.nextInt();
			String usersCity = data.jeju[type2];
			user.usersCity = usersCity;
		}
		else if (AreaType == 17) { 
			for (int i=1; i<data.sejong.length; i++) {
				System.out.printf("%d.%s ",i, data.sejong[i]);
				if (i%4 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			int type2 = scanner.nextInt();
			String usersCity = data.sejong[type2];
			user.usersCity = usersCity;
		}
		else  { 

			main(null);
		}

	}//showMenu
	
	public static void getServiceType() {
		
		System.out.printf("%s를 선택하셨습니다.\n▶용도업종을 선택해주세요.\n",user.usersCity);
		for (int i=1; i<data.services.length; i++) {
			System.out.printf("%d.%s",i,data.services[i]);
			if (i%4 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		int serviceType = scanner.nextInt();
		String usersService = data.services[serviceType];
		user.usersService= usersService;
		
	}//getServiceType

}//class
