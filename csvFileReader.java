import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class csvFileReader{
	private FileInputStream fileInputStream;
	private InputStreamReader inputStreamReader;
	private BufferedReader bufferedReader;
	//CSV�t�@�C�����J��
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
	//CSV�t�@�C���̎��̍s��ǂݎ��u,�v�ŕ���
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
	//����i�������Anext()�ōŌ�܂œǂ܂ꂽ�ꍇ�͎����ŕ���̂ŁA���̎��͌Ă΂Ȃ��Ă悢)
	public void close(){
		try{
			bufferedReader.close();
		}catch(IOException e){
			System.out.println(e);
			System.exit(0);
		}
	}
}