
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * ����ļ����µ��ļ��ʹ���
 */
public class FileManage extends JFrame {
	
	public static void main(String[] args)
	{
		try{
			String st=getFloder();
			System.out.println(st);
		for(String path:getFileInFolder(st))
		{
			if(new File(path).exists())
			{
				System.out.println(path+"is real");
			}
			else System.out.println(path+" error");
		}
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.toString(),"error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//ѡ���ļ���
	public static String getFloder()
	{
		JFileChooser fileChooser=new JFileChooser();
		fileChooser.setDialogTitle("��ѡ���ļ���");		
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
		return fileChooser.getSelectedFile().getPath();
		}
		else return null;
	}
	
	//�ж��ļ����µ��ļ������ļ��л��ļ���ѹջ��������·������
	public static Stack<String> getFileInFolder(String path)
	{
		try{
		Stack<String>stack=new Stack<String>();
		File fload=new File(path);
		if(fload.isDirectory())
		{
			for(String s: fload.list())
			{
				File file=new File(path+"//"+s);
				if(file.exists()&&(ImageJudge.IsImage(file)||file.isDirectory()))
				{
					stack.push(path+"//"+s);
				}
			}
			if(stack.isEmpty())
			{
				return null;
			}
			else
			{
			return stack;
			}
		}
		else return null;
		}catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.toString(),"error",JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
}
