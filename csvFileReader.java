import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class csvFileReader{
	private FileInputStream fileInputStream;
	private InputStreamReader inputStreamReader;
	private BufferedReader bufferedReader;
	//CSVファイルを開く
	public void open(String filename){
		try{
			fileInputStream=new FileInputStream(filename);
			inputStreamReader=new InputStreamReader(fileInputStream);
			bufferedReader=new BufferedReader(inputStreamReader);
		}catch(IOException e){
			System.out.println(e);
			System.exit(0);
		}
	}
	//CSVファイルの次の行を読み取り「,」で分割
	public String[] next(){
		try{
			String line;
			if((line=bufferedReader.readLine())==null){
				close();
			}else{
				return line.split(",");
			}
		}catch(IOException e){
			System.out.println(e);
			System.exit(0);
		}
		return new String[] {};
	}
	//閉じる（ただし、next()で最後まで読まれた場合は自動で閉じるので、この時は呼ばなくてよい)
	public void close(){
		try{
			bufferedReader.close();
		}catch(IOException e){
			System.out.println(e);
			System.exit(0);
		}
	}
}