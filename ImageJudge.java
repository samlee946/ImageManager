package kechengsheji;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/*
 *�ж��ǲ�����Ƭ
 */
public class ImageJudge {
	//����Ƭ�Ļ��Ż�True
	public static boolean IsImage(File file)
	{
		try{
			BufferedImage bi=ImageIO.read(file);
			if(bi!=null)
			{
				return true;
			}
			
		}catch(Exception e){
		return false;
		}
		return false;
	}

}
