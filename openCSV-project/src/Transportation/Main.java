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
//		String readFileName = "C:\\Users\\�ֽ�\\Desktop\\Data\\01\\BUS_STATION_BOARDING_MONTH_202001(�޸�����).csv";
//		String writeFileName = "C:\\Users\\�ֽ�\\Desktop\\bus.csv";
//		CSVReader csvReader;
//		
//		
//		
//	}

	public static void getBus() throws IOException {
		String readFileName = "C:\\Users\\�ֽ�\\Desktop\\Data\\01\\BUS_STATION_BOARDING_MONTH_202001(�޸�����).csv";
		String writeFileName = "C:\\Users\\�ֽ�\\Desktop\\bus.csv";
		CSVReader csvReader;
		CSVWriter cw = null;
		try {
			csvReader = new CSVReader(new InputStreamReader(new FileInputStream(readFileName), "CP949"));
			cw = new CSVWriter(new FileWriter(writeFileName));
			String[] nextLine;
			// ���پ� data�ȿ� �ֱ� (������ �о�������� csv������ �޸� �� �����ϰ� �б�)
			List<String> data = new ArrayList<String>();
			while ((nextLine = csvReader.readNext()) != null) {
				data.add(String.join(",", nextLine));
			}
			// �ʵ�� ����
//			String[] field = data.get(0).split(",");
//			System.out.println(Arrays.toString(field));

			// ���߹迭�� �޸��� ��� �� �ܾ �ֱ�(Hashset->ArrayList)
			String[][] words = new String[data.size()][];
			HashSet<String> dateSet = new HashSet<String>();
			for (int i = 1; i < data.size(); i++) {
				words[i] = data.get(i).split(",");
//				//��¥
//				System.out.println(words[i][0]);
//				//����
//				System.out.println(words[i][5]);
//				//����
//				System.out.println(words[i][6]);	
				// ��¥�� �ְ�
				dateSet.add(words[i][0]);
			}

			List<String> dateArr = new ArrayList<String>(dateSet);
			Collections.sort(dateArr);
			String[] fieldname = new String[] { "����", "����ö����", "����ö����", "��������", "��������" };
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
			
			//������ ������ ������ ����
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
