package Metadata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/*
 * FileRead : csv ������ �ҷ��ͼ� ������ �����ϴ� Ŭ����
 */
public class FileRead {

	static UsersChoice user = new UsersChoice();
	public void readData () throws IOException {

		//0.������� ������ �ҷ�����
		String usersArea = user.usersArea;
		String usersCity = user.usersCity;
		String usersService = user.usersService;

		String path = "�ѱ����°���_�ñ����� �뵵������ ���»�뷮_20170504.csv";
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(path));
		ArrayList<String> lines = new ArrayList<String>();

		//1. �ڷ� ���پ� �ް� ArrayList�� �ֱ�
		while ((line = reader.readLine()) != null) {
			String[] column = line.split(",");
			lines.add(line);
		}
		//Ȯ�� System.out.println(lines.get(1));


		//2. ���پ� �Ǿ��ִ� �ڷḦ ,�� �߶� String[][] �� �ֱ�
		String[][] words = new String[lines.size()][];

		for (int i = 0; i<lines.size(); i++) {	
			words[i] = lines.get(i).split(",");
		}
		//Ȯ��//System.out.println(Arrays.toString(words[0]));	
		//System.out.println(words[1][2]);

		//3, ������� ���ð� ����ڰ� ������ Ű���尡 ���Ե� �ڷḦ ���
		//������ ��,���,�ּҰ�,�ִ밪 ���
		System.out.println("������ ���� :" + usersArea);
		System.out.println("������ �ñ��� : "+ usersCity);
		System.out.println("������ �뵵���� : " + usersService);

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
		
		System.out.printf("���հ�: %d\n�� ��: %d\n�ּҰ�: %d\n�ִ밪: %d\n"
				,sum,avg,min,max);
		System.out.println();


	}//readData

}
