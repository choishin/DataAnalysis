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

public class Main {

	public static void main(String[] args) throws IOException {

		getBus();
//		getSubway();

	}

	public static void getBus() throws IOException {
		String[] readFileName = { "C:\\Users\\최신\\Desktop\\Data\\01\\BUS_STATION_BOARDING_MONTH_202001.csv",
				"C:\\Users\\최신\\Desktop\\Data\\01\\BUS_STATION_BOARDING_MONTH_202002.csv",
				"C:\\Users\\최신\\Desktop\\Data\\01\\BUS_STATION_BOARDING_MONTH_202003.csv",
				"C:\\Users\\최신\\Desktop\\Data\\01\\BUS_STATION_BOARDING_MONTH_202004.csv",
				"C:\\Users\\최신\\Desktop\\Data\\01\\BUS_STATION_BOARDING_MONTH_202005.csv",
				"C:\\Users\\최신\\Desktop\\Data\\01\\BUS_STATION_BOARDING_MONTH_202006.csv",
				"C:\\Users\\최신\\Desktop\\Data\\01\\BUS_STATION_BOARDING_MONTH_202007.csv",
				"C:\\Users\\최신\\Desktop\\Data\\01\\BUS_STATION_BOARDING_MONTH_202008.csv",
				"C:\\Users\\최신\\Desktop\\Data\\01\\BUS_STATION_BOARDING_MONTH_202009.csv",
				"C:\\Users\\최신\\Desktop\\Data\\01\\BUS_STATION_BOARDING_MONTH_202010.csv",
				"C:\\Users\\최신\\Desktop\\Data\\01\\BUS_STATION_BOARDING_MONTH_202011.csv",
				"C:\\Users\\최신\\Desktop\\Data\\01\\BUS_STATION_BOARDING_MONTH_202012.csv",

		};
		String writeFileName = "C:\\Users\\최신\\Desktop\\bus.csv";
		CSVReader csvReader;
		CSVWriter cw = null;
		try {
			cw = new CSVWriter(new FileWriter((writeFileName),true));
			for (int iFile = 0; iFile < readFileName.length; iFile++) {
				csvReader = new CSVReader(new InputStreamReader(new FileInputStream(readFileName[iFile]), "CP949"));

				if (iFile == 0) {
					// 필드이름 넣기
					String[] fieldname = new String[] { "일자", "버스승차", "버스하차", "지하철승차", "지하철하차" };
					cw.writeNext(fieldname);
				}

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
				if (iFile != 4 && iFile != 5 && iFile != 6) {
					for (int i = 1; i < data.size(); i++) {
						for (int j = 0; j < dateArr.size(); j++) {
							words[i] = data.get(i).split("\t");
							if (words[i][0].contains(dateArr.get(j))) {
								try {
									int temp_getOn = Integer.parseInt(words[i][5]);
									int temp_getOff = Integer.parseInt(words[i][6]);
									getOn[j] = getOn[j] + temp_getOn;
									getOff[j] = getOff[j] + temp_getOff;
								} catch (NumberFormatException ne) {
									System.out.println(words[i][0] + ". " + words[i][1] + ". " + words[i][2] + ". "
											+ words[i][3] + ". " + words[i][4] + ". " + words[i][5] + ". " + words[i][6]
											+ ". " + words[i][7]);
								}
							} // if

						} // for

					} // for
				}

				else if (iFile == 4 || iFile == 5 || iFile == 6) {
					for (int i = 1; i < data.size(); i++) {
						for (int j = 0; j < dateArr.size(); j++) {
							words[i] = data.get(i).split("\t");
							if (words[i][0].contains(dateArr.get(j))) {
								try {
									int temp_getOn = Integer.parseInt(words[i][6]);
									int temp_getOff = Integer.parseInt(words[i][7]);
									getOn[j] = getOn[j] + temp_getOn;
									getOff[j] = getOff[j] + temp_getOff;
								} catch (NumberFormatException ne) {
									System.out.println(words[i][0] + ". " + words[i][1] + ". " + words[i][2] + ". "
											+ words[i][3] + ". " + words[i][4] + ". " + words[i][5] + ". " + words[i][6]
											+ ". " + words[i][7]);
								}
							} // if

						} // for

					} // for

				}

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
		} catch (IOException e) {
			System.out.println(e);

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			cw.close();
		}

	}

}
