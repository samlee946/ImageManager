
import java.io.File;
import java.util.Stack;

import javax.swing.JOptionPane;

import net.lingala.zip4j.core.ZipFile;

/*
 * ��ѹ�ļ�����ز���
 */
@SuppressWarnings({ "unused", "unused", "unused", "unused", "unused" })
public class UnZipFile {
	public static void main(String[] args){
		for(String s:getFileInZip("D://123.zip")){
			System.out.println(s);
		}
	}
	/*
	 * ��ѹ�ļ������ŵ�ָ��Ŀ¼
	 * Filepatn���ļ�·����directorPath��ָ��Ŀ¼·��
	 */
	@SuppressWarnings({ "unused", "unused" })
	public static boolean UnZip(String filePath,String directoryPath){
		File file=new File(filePath);
		//�ж��ļ��ǲ����ļ����ǲ��Ǵ���
		if(file.exists()&&file.isFile()){
			try{
				net.lingala.zip4j.core.ZipFile zFile=new ZipFile(file);
			zFile.setFileNameCharset("GBK");
			if(!zFile.isValidZipFile()){
				throw new Exception("�ļ��𻵻��ļ������ڣ��޷���");
			}
				//�жϽ�ѹ���·���Ƿ���ڣ��������򴴽��µģ��������֮ǰ��ɾ��//�ݶ���ɾ
				File fload=new File(directoryPath);
				if(fload.isDirectory()&&fload.exists()){
					//delete fload
			    }
				//����ָ��Ŀ¼
				else if(fload.isDirectory()&&fload.exists()){
					fload.mkdir();
				}
				//�ļ�Ҫ���ܣ��������ɲ���ѹ�ɹ���ֹͣ��ѭ�����ǲ�ѭ�������ʾ�������ͺ�
				if(zFile.isEncrypted()){
					String data=null;
					while(data==null||data==""||data=="	"){
					data=JOptionPane.showInputDialog("����������");
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
	 * ���ؽ�ѹ�������ļ���·��
	 */
	public static Stack<String> getFileInZip(String filePath){
		String defaultPath="D://456";
			if(UnZip(filePath,defaultPath)) {
				return FileManage.getFileInFolder(defaultPath);
			}
			else return null;
	}
}
