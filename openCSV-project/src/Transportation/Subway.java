package Transportation;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Subway {

	public static void main(String[] args) throws IOException {
		
		getSubway();

	}

	public static void getSubway() throws IOException {
		// TODO Auto-generated method stub
		String readFileName = "C:\\Users\\최신\\Desktop\\Data\\01\\서울교통공사 2020년 일별 시간대별 역별 승하차 인원(1_8호선).csv";
		String writeFileName = "C:\\Users\\최신\\Desktop\\subway.csv";
		CSVReader csvReader;
		CSVWriter cw = null;
		try {
			cw = new CSVWriter(new FileWriter((writeFileName), true));
			csvReader = new CSVReader(new InputStreamReader(new FileInputStream(readFileName), "CP949"));
			
			String[] nextLine;
			// 한줄씩 data안에 넣기
			List<String> data = new ArrayList<String>();
			while ((nextLine = csvReader.readNext()) != null) {
				data.add(String.join("\t", nextLine));
			}
			// 다중배열에 탭으로 끊어서 한 단어씩 넣기(Hashset->ArrayList)
			String[][] words = new String[data.size()][];
			HashSet<String> dateSet = new HashSet<String>();
			for (int i = 1; i < data.size(); i++) {
				words[i] = data.get(i).split("\t");
				// 날짜를 넣고
				dateSet.add(words[i][0]);
			}
			List<String> dateArr = new ArrayList<String>(dateSet);
			Collections.sort(dateArr);
			
			// 날짜별 데이터 합산하기
			int[] getOn = new int[dateArr.size()];
			int[] getOff = new int[dateArr.size()];
			for (int i = 0; i < dateArr.size(); i++) {
				getOn[i] = 0;
				getOff[i] = 0;
			}
				for (int i = 1; i < data.size(); i=i+2) {
					for (int j = 0; j < dateArr.size(); j++) {
						words[i] = data.get(i).split("\t");
						if (words[i][0].contains(dateArr.get(j))) {
							try {
								int temp_getOn5 = Integer.parseInt(words[i][5]);
								int temp_getOn6 = Integer.parseInt(words[i][6]);
								int temp_getOn7 = Integer.parseInt(words[i][7]);
								int temp_getOn8 = Integer.parseInt(words[i][8]);
								int temp_getOn9 = Integer.parseInt(words[i][9]);
								int temp_getOn10 = Integer.parseInt(words[i][10]);
								int temp_getOn11 = Integer.parseInt(words[i][11]);
								int temp_getOn12 = Integer.parseInt(words[i][12]);
								int temp_getOn13 = Integer.parseInt(words[i][13]);
								int temp_getOn14 = Integer.parseInt(words[i][14]);
								int temp_getOn15 = Integer.parseInt(words[i][15]);
								int temp_getOn16 = Integer.parseInt(words[i][16]);
								int temp_getOn17 = Integer.parseInt(words[i][17]);
								int temp_getOn18 = Integer.parseInt(words[i][18]);
								int temp_getOn19 = Integer.parseInt(words[i][19]);
								int temp_getOn20 = Integer.parseInt(words[i][20]);
								int temp_getOn21 = Integer.parseInt(words[i][21]);
								int temp_getOn22 = Integer.parseInt(words[i][22]);
								int temp_getOn23 = Integer.parseInt(words[i][23]);
								int temp_getOn24 = Integer.parseInt(words[i][24]);
								int temp_getOff5 = Integer.parseInt(words[i+1][5]);
								int temp_getOff6 = Integer.parseInt(words[i+1][6]);
								int temp_getOff7 = Integer.parseInt(words[i+1][7]);
								int temp_getOff8 = Integer.parseInt(words[i+1][8]);
								int temp_getOff9 = Integer.parseInt(words[i+1][9]);
								int temp_getOff10 = Integer.parseInt(words[i+1][10]);
								int temp_getOff11 = Integer.parseInt(words[i+1][11]);
								int temp_getOff12 = Integer.parseInt(words[i+1][12]);
								int temp_getOff13 = Integer.parseInt(words[i+1][13]);
								int temp_getOff14 = Integer.parseInt(words[i+1][14]);
								int temp_getOff15 = Integer.parseInt(words[i+1][15]);
								int temp_getOff16 = Integer.parseInt(words[i+1][16]);
								int temp_getOff17 = Integer.parseInt(words[i+1][17]);
								int temp_getOff18 = Integer.parseInt(words[i+1][18]);
								int temp_getOff19 = Integer.parseInt(words[i+1][19]);
								int temp_getOff20 = Integer.parseInt(words[i+1][20]);
								int temp_getOff21 = Integer.parseInt(words[i+1][21]);
								int temp_getOff22 = Integer.parseInt(words[i+1][22]);
								int temp_getOff23 = Integer.parseInt(words[i+1][23]);
								int temp_getOff24 = Integer.parseInt(words[i+1][24]);

								getOn[j] = getOn[j] + temp_getOn5+temp_getOn6+temp_getOn7+temp_getOn8+temp_getOn9+temp_getOn10+
										temp_getOn11+temp_getOn11+temp_getOn12+temp_getOn13+temp_getOn14+temp_getOn15+
										temp_getOn16+temp_getOn17+temp_getOn18+temp_getOn19+temp_getOn20+temp_getOn21+temp_getOn22+temp_getOn23+temp_getOn24;
								getOff[j] = getOff[j] + temp_getOff5+temp_getOff6+temp_getOff7+temp_getOff8+temp_getOff9+temp_getOff10+
										temp_getOff11+temp_getOff12+temp_getOff13+temp_getOff14+temp_getOff15+temp_getOff16+temp_getOff17+
										temp_getOff18+temp_getOff19+temp_getOff20+temp_getOff21+temp_getOff22+temp_getOff23+temp_getOff24;
							
							} catch (Exception e) {
								System.out.println(e);
								System.out.println(words[i][0] + ". " + words[i][1] + ". " + words[i][2] + ". "
										+ words[i][3] + ". " + words[i][4] + ". " + words[i][5] + ". " + words[i][6]
										+ ". " + words[i][7]);
							}
						} // if

					} // for

				} // for
				// 가공한 데이터 가지고 오기
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
				
		}
			catch (IOException e) {
			System.out.println(e);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("done!");
			cw.close();
		}

	}
}
