
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class InfoFileManage {

	private static FileFunction f=new FileFunctionA();
	
	/*
	 * �½�һ���ڲ����������������е�����
	 */
	public static void main(String[] args) {
		
	}
	/*
	 * �������Ը�������
	 */
	public static void update(String attribute,String value){
		ConfigMessage oldCon=getConfig();
		oldCon.update(attribute, value);
		try{
		ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(f.getFile("config.dat")));
		output.writeObject(oldCon);
		output.close();
		}catch(Exception ex){
			ShowError.ShowMessage(ex);
		}
	}
	/*
	 * ���������������
	 */
	public static ConfigMessage getConfig(){
		try{
		ObjectInputStream input=new ObjectInputStream(new FileInputStream(f.getFile("config.dat")));
		ConfigMessage con=(ConfigMessage) input.readObject();
		input.close();
		return con;
		}catch(Exception ex){ShowError.ShowMessage(ex);}
		return null;
	}
	/*
	 * �������Ի����������
	 */
	public static String getAttribute(String attribute){
		ConfigMessage con=getConfig();
		return con.getData(attribute);
	}
}
/*
 * �ļ�·�����ã���Ҫ���������ʹ��ǰ��·���任
 */
interface FileFunction
{
	public File getFile(String fileName);
	public boolean checkFile(String fileName);
}
/*
 * ���ǰ��·������
 */
class FileFunctionA implements FileFunction
{

	@Override
	public File getFile(String filePath) {
		File f= new File(filePath);
		if(f.exists())
		{
			return f;
		}
		else{
			System.out.println("error");
			return null;
		}
		// TODO Auto-generated method stub
	}

	@Override
	public boolean checkFile(String filePath) {
		// TODO Auto-generated method stub
		return new File(filePath).exists();
	}
	
}
