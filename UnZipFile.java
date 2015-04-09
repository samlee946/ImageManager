
import java.io.File;
import java.util.Stack;

import javax.swing.JOptionPane;

import net.lingala.zip4j.core.ZipFile;

/*
 * 解压文件的相关操作
 */
@SuppressWarnings({ "unused", "unused", "unused", "unused", "unused" })
public class UnZipFile {
	public static void main(String[] args){
		for(String s:getFileInZip("D://123.zip")){
			System.out.println(s);
		}
	}
	/*
	 * 解压文件，并放到指定目录
	 * Filepatn是文件路径，directorPath是指定目录路径
	 */
	@SuppressWarnings({ "unused", "unused" })
	public static boolean UnZip(String filePath,String directoryPath){
		File file=new File(filePath);
		//判断文件是不是文件和是不是存在
		if(file.exists()&&file.isFile()){
			try{
				net.lingala.zip4j.core.ZipFile zFile=new ZipFile(file);
			zFile.setFileNameCharset("GBK");
			if(!zFile.isValidZipFile()){
				throw new Exception("文件损坏或文件不存在，无法打开");
			}
				//判断解压后的路径是否存在，不存在则创建新的，存在则把之前的删掉//暂定不删
				File fload=new File(directoryPath);
				if(fload.isDirectory()&&fload.exists()){
					//delete fload
			    }
				//创建指定目录
				else if(fload.isDirectory()&&fload.exists()){
					fload.mkdir();
				}
				//文件要解密，考虑做成不解压成功不停止的循环还是不循环最后提示密码错误就好
				if(zFile.isEncrypted()){
					String data=null;
					while(data==null||data==""||data=="	"){
					data=JOptionPane.showInputDialog("请输入密码");
					}
					zFile.setPassword(data);
				}
				zFile.extractAll(directoryPath);
				return true;
				
			}catch(Exception ex){ShowError.ShowMessage(ex);}
			
		}
		return false;
	}
	/*
	 * 返回解压后所有文件的路径
	 */
	public static Stack<String> getFileInZip(String filePath){
		String defaultPath="D://456";
			if(UnZip(filePath,defaultPath)) {
				return FileManage.getFileInFolder(defaultPath);
			}
			else return null;
	}
}
