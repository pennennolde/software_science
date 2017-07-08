package sort;

import java.util.Random;

public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		/*
		 *   バブルソートの事後評価
		 */

		// ソートするデータ数
		int n = 10;

		// ソート対象の乱数の設定
		int[] x = new int[n];
		Random rnd = new Random();
		for(int i=0; i<n; i++) {
			x[i] = rnd.nextInt(10000);		// 0~9999までの乱数?
		}


		for(int i=0; i<n; i++) {
			System.out.println("x[" + i+ "]= " + x[i]);
		}


		// タイム計測開始
		long start = System.currentTimeMillis();

		// バブルソート
		for(int i=0; i<n-1; i++) {
			for(int j=n-1; j>i; j--) {
				if( x[j]<x[j-1] ) {
					int t = x[j];
					x[j] = x[j-1];
					x[j-1] = t;
				}
			}
		}

		// タイム計測終了
		long stop = System.currentTimeMillis();

		// タイム出力
		System.out.println("cpu time = " + (stop-start) + " (msec)");



		for(int i=0; i<n; i++) {
			System.out.println("x[" + i+ "]= " + x[i]);
		}


	}

}
