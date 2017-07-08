package sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BubbleSort_Public {
  static String path ="";

  public static void main(String[] args) {


	  /*
	   *   クラス全体で分担してバブルソートの事後評価のグラフを作成する
	   *   これはそのために共有してもらったプログラム
	   *   自分の担当はデータ数50万、10回以上やる
	   *   あと、PC性能の差異をなくす基準としてデータ数100万もやる
	   *
	   *   評価を正確にするため、
	   *   ソートするデータの中身の数字も全員DATA.txtを使うことによって同じにする
	   */


    //ここにはDATA.txtのパスを書きます。変えましょう。
    //path = "C:\\pleiades\\eclipse\\DATA.txt" ;
    path = "C:\\Users\\Mikita ENDOH\\Documents\\TUS-SJ\\ソフトウェア科学\\DATA.txt" ;

    //データ数のデフォルト:100万にしているので、必要に応じて変えてください
    //Sort(1000000);

    for(int i=0; i<11; i++) {
    	Sort(1000000);
    }

  }


  public static long Sort(int n){ // 引数：データ数n、fileの読み込みが必要
    System.out.println("データ数: " + n);
    File fileInput = new File(path);

    int x[] = new int[n];

    try {
     FileReader fr = new FileReader(fileInput);
     BufferedReader br = new BufferedReader(fr);

     String str;
     int idx = 0;
     while((str = br.readLine()) != null && idx < n){
      x[idx] += Integer.parseInt(str);
      idx++;
     }
     br.close();
    } catch (IOException e1) {
     e1.printStackTrace();
     return -1;
    }

    long start = System.currentTimeMillis();
    // バブルソート
    for(int i = 0; i < n-1; i++){
     for(int j = n-1; j > i; j--){
      if(x[j] < x[j-1]){
       int t = x[j];
       x[j] = x[j-1];
       x[j-1] = t;
      }
     }
    }
    long stop = System.currentTimeMillis();

    System.out.println("cpu time = " + (stop - start) + "msec");
    return stop - start;
  }
}
