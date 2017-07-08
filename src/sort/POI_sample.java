package sort;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class POI_sample {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ

		/*
		 *   Excelファイルで出力してみるSample
		 */

		// Excel2007以降の「.xlsx」形式のファイルの素を作成
	    Workbook book = new XSSFWorkbook();

	    // シートを「sample」という名前で作成
	    Sheet sheet = book.createSheet("sample2");

	 // 1行目作成 ※Excel上、行番号は1からスタートしてますが、
	    // ソース内では0からのスタートになっているので要注意！
	    Row row = sheet.createRow(1);

	 // 1つ目のセルを作成 ※行と同じく、0からスタート
	    Cell a1 = row.createCell(1);  // Excel上、「A1」の場所

	 // 値をセット
	    a1.setCellValue("POIのテスト2");



	 // ここから出力処理
	    FileOutputStream out = null;
	    try {
	    		// 出力先のファイルを指定
	    		//out = new FileOutputStream("C:\\Temp/Sample1.xlsx");
	    		out = new FileOutputStream("C:\\Users\\Mikita ENDOH\\Documents\\TUS-SJ\\ソフトウェア科学\\POI_sample.xlsx");
	    		// 上記で作成したブックを出力先に書き込み
	    		book.write(out);

	    } catch (FileNotFoundException e) {
	    		System.out.println(e.getStackTrace());

	    } finally {
	    		// 最後はちゃんと閉じておきます
	    		out.close();
	    		book.close();
	    }


	}

}
