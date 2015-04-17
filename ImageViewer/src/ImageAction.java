import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import static java.lang.Math.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import java.awt.GraphicsConfiguration;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
class ImageAction {
    private final MyFileChooser filechooser = new MyFileChooser();
    private static ImageAction existance = null;
    private File FilePath = null;
    private File CurrentDir = null;
    private File CurrentFile = null;
    private ArrayList<File> ImagesPreLoad = null;
    private String FileName = null;
    private String[] Filter = new String[]{".BMP",".JPG",".JPEG",".JPE",".JFIF",".GIF","TIF",".TIFF",".PNG",".ICO"};
    private ImageIcon imageicon = null;
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
        }
    }
    void ViewPreImage(ImageViewer frame) {
         int index = this.ImagesPreLoad.indexOf(this.CurrentFile), size = ImagesPreLoad.size();
         if(size > 0) {
            int Newindex = (index - 1 + size) % size;
            this.CurrentFile = ImagesPreLoad.get(Newindex);
            imageicon = new ImageIcon(this.CurrentFile.getPath());
            frame.getLabel().setIcon(imageicon);
         }
    }
    void ViewNextImage(ImageViewer frame) {
         int index = this.ImagesPreLoad.indexOf(this.CurrentFile), size = ImagesPreLoad.size();
         if(size > 0) {
            int Newindex = (index + 1) % size;
            this.CurrentFile = ImagesPreLoad.get(Newindex);
            imageicon = new ImageIcon(this.CurrentFile.getPath());
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
//            trans.scale(100, 100);
            BufferedImage buffer = new BufferedImage(h, w, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = buffer.createGraphics();
            g2.setTransform(trans);
            trans.rotate(Math.PI * direction / 2, w / 2, h / 2);
            g2.setTransform(trans);
            g2.drawImage(image, null, null);
            imageicon = new ImageIcon(buffer);
            frame.getLabel().setIcon(imageicon);
            System.out.println("Rotate");
        }
    }
  }