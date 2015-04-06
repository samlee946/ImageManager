
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/*
 *≈–∂œ «≤ª «’’∆¨
 */
public class ImageJudge {
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
