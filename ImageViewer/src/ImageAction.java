import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import static java.lang.Math.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
class ImageAction {
    private final MyFileChooser filechooser = new MyFileChooser();
    private int RotateCount;
    private static ImageAction existance = null;
    private File FilePath = null;
    private File CurrentDir = null;
    private File CurrentFile = null;
    private ArrayList<File> ImagesPreLoad = null;
    private String FileName = null;
    private String[] Filter = new String[]{".BMP",".JPG",".JPEG",".JPE",".JFIF",".GIF","TIF",".TIFF",".PNG",".ICO"};
    BufferedImage outputbuffer = null;
    ImageIcon imageicon = null;
    static ImageAction getInstance() {
        if(existance == null) existance = new ImageAction();
        return existance;
    }
    void open(ImageViewer frame) {
        System.out.println("filechooser ok");
        if(filechooser.showOpenDialog(filechooser) == JFileChooser.APPROVE_OPTION) {
            this.CurrentFile = filechooser.getSelectedFile();
            FileName = CurrentFile.getPath();
            FilePath = CurrentFile.getParentFile();
            if(FilePath != CurrentDir) {
                ImagesPreLoad = new ArrayList<File>();
                CurrentDir = FilePath;
                File Temp[] = CurrentDir.listFiles();
                for(File file : Temp) {
                    if(!file.isHidden() && !file.isDirectory()) {
                        for(String s : Filter) {
                            if(file.toString().toUpperCase().endsWith(s)) {
                                this.ImagesPreLoad.add(file);
                                System.out.println(file.getName());
                                break;
                            }
                        }
                    }
                }
            }
            imageicon = new ImageIcon(FileName);
            frame.getLabel().setIcon(imageicon);
            frame.getSlider().enable(true);
            RotateCount = 0;
        }
    }
    void ViewPreImage(ImageViewer frame) throws IOException {
        if(ImagesPreLoad != null) {
            int index = this.ImagesPreLoad.indexOf(this.CurrentFile), size = ImagesPreLoad.size();
            //if the image has been rotated
            if(RotateCount != 0) {
                int ret_val = JOptionPane.showConfirmDialog(null, "你已对图片进行过改动，是否保存修改？", "提示", JOptionPane.YES_NO_OPTION);
                if(ret_val == JOptionPane.YES_OPTION) {
                    String suffix = FileName.substring(FileName.lastIndexOf(".") + 1);
                    ImageIO.write(outputbuffer, suffix, this.CurrentFile);
                }
                RotateCount = 0;
//                if(ret_val == JOptionPane.YES_OPTION) System.out.println("Yes-save image");
//                else System.out.println("No-do not save image");
            }
            int Newindex = (index - 1 + size) % size;
            this.CurrentFile = ImagesPreLoad.get(Newindex);
            BufferedImage buff = ImageIO.read(this.CurrentFile);
            imageicon = new ImageIcon(buff);
            frame.getLabel().setIcon(imageicon);
        }
    }
    void ViewNextImage(ImageViewer frame) throws IOException {
        if(ImagesPreLoad != null) {
            int index = this.ImagesPreLoad.indexOf(this.CurrentFile), size = ImagesPreLoad.size();
            //if the image has been rotated
            if(RotateCount != 0) {
                int ret_val = JOptionPane.showConfirmDialog(null, "你已对图片进行过改动，是否保存修改？", "提示", JOptionPane.YES_NO_OPTION);
                if(ret_val == JOptionPane.YES_OPTION) {
                    String suffix = FileName.substring(FileName.lastIndexOf(".") + 1);
                    ImageIO.write(outputbuffer, suffix, this.CurrentFile);
                }
                RotateCount = 0;
//                if(ret_val == JOptionPane.YES_OPTION) System.out.println("Yes-save image");
//                else System.out.println("No-do not save image");
            }
            int Newindex = (index + 1) % size;
            this.CurrentFile = ImagesPreLoad.get(Newindex);
            BufferedImage buff = ImageIO.read(this.CurrentFile);
            imageicon = new ImageIcon(buff);
            frame.getLabel().setIcon(imageicon);
        }
    }
    void ImageResize(ImageViewer frame, double size) {
        if(imageicon != null) {
            int width = max(1, (int)(imageicon.getIconWidth() * size));
            int height = max(1, (int)(imageicon.getIconHeight() * size));
            frame.getLabel().setIcon(new ImageIcon(imageicon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
        }
    }
    void rotate(ImageViewer frame, int direction) {
        if(imageicon != null) {
            AffineTransform trans = new AffineTransform();
            Image image = imageicon.getImage();
            
            int w = image.getWidth(null), h = image.getHeight(null);
            int maxx = max(w, h);
            BufferedImage buffer = new BufferedImage(2 * maxx, 2 * maxx, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = buffer.createGraphics();
            trans.rotate(Math.PI * direction / 2, maxx, maxx);
            g2.setTransform(trans);
            
            int nw = (int) (maxx - w / 2), nh = (int) (maxx - h / 2);
            g2.drawImage(image, nw, nh, null);
            buffer = buffer.getSubimage(nh, nw, h, w);
            outputbuffer = buffer;      //for save image
            imageicon = new ImageIcon(buffer);
            frame.getLabel().setIcon(imageicon);
            
            //Record the times of rotation
            RotateCount += direction;
            if(RotateCount >= 4) RotateCount -= 4;
            if(RotateCount < 0) RotateCount += 4;
            
            System.out.println("Rotate");
        }
    }
  }