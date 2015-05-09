package kechengsheji;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/*
 *判断是不是照片
 */
public class ImageJudge {
	//是照片的话放回True
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
