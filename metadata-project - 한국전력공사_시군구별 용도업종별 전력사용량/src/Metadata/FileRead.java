package Metadata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/*
 * FileRead : csv 파일을 불러와서 데이터 가공하는 클래스
 */
public class FileRead {

	static UsersChoice user = new UsersChoice();
	public void readData () throws IOException {

		//0.사용자의 선택을 불러오기
		String usersArea = user.usersArea;
		String usersCity = user.usersCity;
		String usersService = user.usersService;

		String path = "한국전력공사_시군구별 용도업종별 전력사용량_20170504.csv";
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(path));
		ArrayList<String> lines = new ArrayList<String>();

		//1. 자료 한줄씩 받고 ArrayList에 넣기
		while ((line = reader.readLine()) != null) {
			String[] column = line.split(",");
			lines.add(line);
		}
		//확인 System.out.println(lines.get(1));


		//2. 한줄씩 되어있는 자료를 ,로 잘라서 String[][] 에 넣기
		String[][] words = new String[lines.size()][];

		for (int i = 0; i<lines.size(); i++) {	
			words[i] = lines.get(i).split(",");
		}
		//확인//System.out.println(Arrays.toString(words[0]));	
		//System.out.println(words[1][2]);

		//3, 사용자의 선택과 사용자가 선택한 키워드가 포함된 자료를 출력
		//값들의 합,평균,최소값,최대값 출력
		System.out.println("선택한 지역 :" + usersArea);
		System.out.println("선택한 시군구 : "+ usersCity);
		System.out.println("선택한 용도업종 : " + usersService);

		int index = 0;
		for (int i = 0; i<words.length; i++) {
			if (words[i][1].contains(usersArea)&& words[i][2].contains(usersCity) 
					&& words[i][3].contains(usersService)) {
				System.out.println(Arrays.toString(words[i]));
			}
			
		}

		long count =0;
		long sum = 0; long avg = 0; 
		int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;

		for (int i = 0; i<words.length; i++) {
			if (words[i][1].contains(usersArea) && words[i][2].contains(usersCity) 
					&& words[i][3].contains(usersService)) {
				count ++;
				sum += Long.parseLong(words[i][4].replace("\"",""));
				avg = sum/count;
				if( min > Integer.parseInt(words[i][4].replace("\"",""))) {
					min =  Integer.parseInt(words[i][4].replace("\"",""));
				}
				if( max < Integer.parseInt(words[i][4].replace("\"",""))) {
					max = Integer.parseInt(words[i][4].replace("\"",""));
				}
			}//if

		}//for
		
		System.out.printf("총합계: %d\n평 균: %d\n최소값: %d\n최대값: %d\n"
				,sum,avg,min,max);
		System.out.println();


	}//readData

}
