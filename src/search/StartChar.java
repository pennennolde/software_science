package search;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		/*
		 *   文章の先頭になにがあるのか確認する
		 */


		System.out.println("検索フレーズを入力してください。");
		Scanner scan = new Scanner(System.in);
		String word = scan.nextLine();
		System.out.println("検索フレーズ： " + word);

		String[] moji = word.split("");
		int t = moji.length;

		for(int i=0; i<t; i++) {
			System.out.println("moji[" + i+ "]= " + moji[i]);
		}

		System.out.println("moji[0]は ^ のことか？");

		String regex = "^";
		Pattern p = Pattern.compile(regex);

		for(int i=0; i<t; i++) {
			Matcher m = p.matcher(moji[i]);
			if( m.find() ) {
				System.out.println("moji[" + i+ "]= true");
			}
		}

	}

}
