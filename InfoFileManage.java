package kechengsheji;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
	 * 新建一个内部类用来来保存所有的配置
	 */
	public static void main(String[] args) {
//		update("path","123fff");
		ConfigMessage con=getConfig();
		System.out.println("a+"+con.path);
		System.out.println("main "+ con.getData("path"));	
	}
	/*
	 * 根据属性更新数据
	 */
	public static void update(String attribute,String value){
		ConfigMessage oldCon=getConfig();
		oldCon=oldCon.update(attribute, value);
		System.out.println("data"+oldCon.getData("path"));
		try{
			File file=f.getFile("config.dat");
//			if(!file.exists()){System.out.println("error");}
			FileOutputStream out=new FileOutputStream(file);

		ObjectOutputStream output=new ObjectOutputStream(out);
		output.writeObject(oldCon);
		output.close();
		}catch(Exception ex){
			System.out.println("update");
			ShowError.ShowMessage(ex);
		}
	}
	/*
	 * 获得所有配置数据
	 */
	public static ConfigMessage getConfig(){
		try{
		ObjectInputStream input=new ObjectInputStream(new FileInputStream(f.getFile("config.dat")));
		ConfigMessage con=(ConfigMessage) input.readObject();
		input.close();
		return con;
		}catch(Exception ex){return new ConfigMessage();}
	}
	/*
	 * 根据属性获得配置数据
	 */
	public static String getAttribute(String attribute){
		ConfigMessage con=getConfig();
		return con.getData(attribute);
	}
}
/*
 * 文件路径配置，主要用来打包后和打包前的路径变换
 */
interface FileFunction
{
	public File getFile(String fileName);
	public boolean checkFile(String fileName);
}
/*
 * 打包前的路径配置
 */
class FileFunctionA implements FileFunction
{

	@Override
	public File getFile(String filePath) {
		File f= new File(filePath);
		if(f.exists()&&f.isFile())
		{
			return f;
		}
		else{
			try {
				f.createNewFile();
				return f;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("getFile");
				e.printStackTrace();
			}
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
