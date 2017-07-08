package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SentenceSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ

		/*
		 * mojiretsu[] から sentence を検索
		 */

		int n = 15;
		String[] mojiretsu = new String[n];
		mojiretsu[0] = "violin";
		mojiretsu[1] = "viola";
		mojiretsu[2] = "cello";
		mojiretsu[3] = "bass";
		mojiretsu[4] = "flute";
		mojiretsu[5] = "oboe";
		mojiretsu[6] = "clarinet";
		mojiretsu[7] = "bassoon";
		mojiretsu[8] = "horn";
		mojiretsu[9] = "trumpet";
		mojiretsu[10] = "trombone";
		mojiretsu[11] = "tuba";
		mojiretsu[12] = "percussion";
		mojiretsu[13] = "piano";
		mojiretsu[14] = "conductor KAWAI";


		System.out.println("検索ワードを入力してください。");
		//Scanner scan = new Scanner(System.in);
		//String word = scan.next();
		InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String sentence = br.readLine();

		System.out.println("検索senence： " + sentence);

		int count = 0;

		for(int i=0; i<mojiretsu.length; i++) {
			if( sentence.length()<=mojiretsu[i].length() ) {
				if( mojiretsu[i].indexOf(sentence) != -1 ) {
					System.out.println(mojiretsu[i]);
					count++;
				}
			}
		}

		System.out.println("検索結果： " + count + "件");


	}

}
