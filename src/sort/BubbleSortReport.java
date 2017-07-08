package sort;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BubbleSortReport {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ

		/*
		 *   バブルソートの
		 *   ソートするデータ数(n)によって、ソートする時間(秒)がどのようにかわるか
		 *   グラフを作成する
		 */

		long now = System.currentTimeMillis();

	    Workbook book = new XSSFWorkbook();
	    Sheet sheet = book.createSheet("sheet1");

	    // ここの n でデータ数を指定
		int n = 2;
		for(int i=2; i<=1002; i++) {
		    Row row = sheet.createRow(i-1);
		    Cell cell0 = row.createCell(0);
		    cell0.setCellValue(n);
		    Cell cell1 = row.createCell(1);
		    long msec = msec(n);
		    cell1.setCellValue(msec);
		    System.out.println("i= " + i + "  n= " + n + "    " + msec + " msec");
			if( n==2 ) {
				n = 0;
			}
			n += 100;
		}


		// ここから出力処理
	    FileOutputStream out = null;
	    try {
	    		// 出力先のファイルを指定
	    		out = new FileOutputStream("C:\\Users\\Mikita ENDOH\\Documents\\TUS-SJ\\ソフトウェア科学\\bubble_sort_report.xlsx");
	    		book.write(out);
	    } catch (FileNotFoundException e) {
	    		System.out.println(e.getStackTrace());
	    } finally {
	    		out.close();
	    		book.close();
	    }



	    long fin = System.currentTimeMillis();
	    long time = fin - now;
	    System.out.println(time + " msec かかりました。");

	}



	// 乱数を生成してバブルソートして計算時間を返すメソッド
	private static long msec(int n) {
		// ソート対象の乱数の設定
		int[] x = new int[n];
		Random rnd = new Random();
		for(int i=0; i<n; i++) {
			x[i] = rnd.nextInt(10000);		// 0~9999までの乱数?
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
		// タイムをリターン
		return stop-start;
	}


}
