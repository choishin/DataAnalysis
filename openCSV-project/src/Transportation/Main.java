package Transportation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		
		getBus();
//		getSubway();

	}

//	private static void getSubway() {
//		// TODO Auto-generated method stub
//		String readFileName = "C:\\Users\\최신\\Desktop\\Data\\01\\BUS_STATION_BOARDING_MONTH_202001(콤마제거).csv";
//		String writeFileName = "C:\\Users\\최신\\Desktop\\bus.csv";
//		CSVReader csvReader;
//		
//		
//		
//	}

	public static void getBus() throws IOException {
		String readFileName = "C:\\Users\\최신\\Desktop\\Data\\01\\BUS_STATION_BOARDING_MONTH_202001(콤마제거).csv";
		String writeFileName = "C:\\Users\\최신\\Desktop\\bus.csv";
		CSVReader csvReader;
		CSVWriter cw = null;
		try {
			csvReader = new CSVReader(new InputStreamReader(new FileInputStream(readFileName), "CP949"));
			cw = new CSVWriter(new FileWriter(writeFileName));
			String[] nextLine;
			// 한줄씩 data안에 넣기 (데이터 읽어오기전에 csv파일의 콤마 다 제거하고 읽기)
			List<String> data = new ArrayList<String>();
			while ((nextLine = csvReader.readNext()) != null) {
				data.add(String.join(",", nextLine));
			}
			// 필드명 추출
//			String[] field = data.get(0).split(",");
//			System.out.println(Arrays.toString(field));

			// 다중배열에 콤마로 끊어서 한 단어씩 넣기(Hashset->ArrayList)
			String[][] words = new String[data.size()][];
			HashSet<String> dateSet = new HashSet<String>();
			for (int i = 1; i < data.size(); i++) {
				words[i] = data.get(i).split(",");
//				//날짜
//				System.out.println(words[i][0]);
//				//승차
//				System.out.println(words[i][5]);
//				//하차
//				System.out.println(words[i][6]);	
				// 날짜를 넣고
				dateSet.add(words[i][0]);
			}

			List<String> dateArr = new ArrayList<String>(dateSet);
			Collections.sort(dateArr);
			String[] fieldname = new String[] { "일자", "지하철승차", "지하철하차", "버스승차", "버스하차" };
			cw.writeNext(fieldname);

			int[] getOn = new int[dateArr.size()];
			int[] getOff = new int[dateArr.size()];
			for (int i = 0; i < dateArr.size(); i++) {
				getOn[i] = 0;
				getOff[i] = 0;
			}
			for (int i = 1; i < data.size(); i++) {
				for (int j = 0; j < dateArr.size(); j++) {
					words[i] = data.get(i).split(",");
					if (words[i][0].contains(dateArr.get(j))) {
						int temp_getOn = Integer.parseInt(words[i][5]);
						int temp_getOff = Integer.parseInt(words[i][6]);
						getOn[j] = getOn[j] + temp_getOn;
						getOff[j] = getOff[j] + temp_getOff;
					} // if

				} // for

			} // for
			
			//가공한 데이터 가지고 오기
			String[] result = new String[3];
			for (int i = 0; i < dateArr.size(); i++) {
				result[0] = dateArr.get(i);
				result[1] = Integer.toString(getOn[i]);
				result[2] = Integer.toString(getOff[i]);
				System.out.println(result[0]);
				System.out.println(result[1]);
				System.out.println(result[2]);
				cw.writeNext(result);
			}
					
		} catch (IOException e) {
			System.out.println(e);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cw.close();
		}

	}

}
