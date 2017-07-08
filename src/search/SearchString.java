package search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		/*
		 * クラスメイトにつくってもらったもののコピー
		 * ファイルを読み込むためのプログラム
		 */

		/*
		 *   String[] mojiretsu に改行までが格納。数文入っていることもある。
		 *   String keyWord に検索キーワードor検索キーフレーズを格納
		 *   String[] str にkeyWordを１文字ずつ格納
		 */

		/*
		 *   キーワードをsplit("")して、１文字ずつ配列に格納したとき、
		 *   ”行の先頭”を表す文字("^"?, "\A"?)が0番目に格納される
		 *   それがネックになっている（行の先頭のときしか検索にひっかからない）
		 */



		try{
			//ファイルの読み込み
			//File file = new File("C:\\Users\\nikka\\Desktop\\にっか\\大学\\授業\\大学関連\\森田\\test.txt");
			File file = new File("C:\\Users\\Mikita ENDOH\\Documents\\TUS-SJ\\ソフトウェア科学\\search.dat");
			//ファイルオブジェクトの生成、ファイルもディレクトリの同じものとして扱われる
			if(checkBeforeReadfile(file)){
			BufferedReader br = new BufferedReader(new FileReader(file));
			// ファイルリーダーオブジェクトにさらにバッファードリーダーをかぶせてある程度まとめてテキストを読み込む(ファイルオブジェクトからファイルリーダーオブジェクトを生成)
			String sr;
				ArrayList<String> Al = new ArrayList<String>();
				// リスト、大きさの決まっていない配列、初期１０個生成
				int m = 0;
				while((sr = br.readLine()) != null){
					// テキストを１行読み込む、改行などで判断、終端文字は含めない、すべて読んだらnull
					// 改行まで読み込むので、数文入ることもある。
					Al.add(sr);
					m++;
				}
				br.close();
				// 読んだら閉じる


				//リストから配列に入れ替える
			String[] mojiretsu = new String[m];
				for(int i = 0;i < m;i++){
					mojiretsu[i] = Al.get(i);
				}


				for(int i=0; i<m; i++) {
					System.out.println("mojiretsu[" + i + "]= " + mojiretsu[i]);
				}


				//キーワード読み込み
				System.out.println("キーワードを入力してください");
				Scanner sc = new Scanner(System.in);
				String keyWord = sc.nextLine();
				// nextLine = 改行まで読み込み、改行まで返す
				// next = 改行まで読み込み、空白までごとに返す(イテレート?)
				// どちらも改行？終端文字？は入れない
				sc.close();
				//終了処理、もう使わないインスタンスは消す必要がある


				/*
				 *  String型のkeyWordという変数の中に、入力したキーワードが代入されます。
				 */

				/*本文開始*/

				//キーワードを1文字ずつ配列strに入力
				String[] str = keyWord.split("");		// ""=１文字ずつ
				int s = str.length;


				for(int i=0; i<s; i++) {
					System.out.println("str[" + i + "]= " + str[i]);
				}



				for(int k = 0;k < m;k++){
					int t = mojiretsu[k].length();
					if(t >= s){		// 入力した文字数より、格納した１行のほうが長いか等しい

						String[] moj = mojiretsu[k].split("");

						for(int p=0; p<t; p++) {
							System.out.println("moj[" + p + "]=" + moj[p] );
						}

						int sCount = 0;
						for(int i = 0;i < t - s + sCount + 1;i++){

							System.out.println("str[" + sCount + "]= " + str[sCount] + "      moj[ " + i+ "]= " + moj[i]);

							if(str[sCount].equals(moj[i])){

								System.out.println("(" + str[sCount] + " = " + (moj[i]) + ")");

								sCount++;
								if(sCount == s){
									System.out.println(mojiretsu[k]);		//検索結果
									break;
								}
							}else{
								sCount = 0;
							}
						}

					}
				}
			}else{
				System.out.println("ファイルが見つからないか読み取れません。");
			}
		}catch(FileNotFoundException e){
			System.out.println("エラー");
		}catch(IOException e){
			System.out.println("エラー");
		}

	}
	private static boolean checkBeforeReadfile(File file){
		if(file.exists()){		// ファイルが存在する => true
			if(file.isFile()&&file.canRead()){ //ファイルが存在し、それが普通のファイル=>true && ファイルが存在し、それが読み込める=>true
				return true;
			}
		}
		return false;


	}

}
