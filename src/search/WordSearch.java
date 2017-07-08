package search;

import java.util.Scanner;

public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		/*
		 * mojiretsu[] から word を検索
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
		mojiretsu[14] = "conductor";


		System.out.println("検索ワードを入力してください。");
		Scanner scan = new Scanner(System.in);
		String word = scan.next();
		System.out.println("検索ワード： " + word);

		int count = 0;

		for(int i=0; i<mojiretsu.length; i++) {
			if( word.length()<=mojiretsu[i].length() ) {
				if( mojiretsu[i].indexOf(word) != -1 ) {
					System.out.println(mojiretsu[i]);
					count++;
				}
			}
		}

		System.out.println("検索結果： " + count + "件");


	}

}
