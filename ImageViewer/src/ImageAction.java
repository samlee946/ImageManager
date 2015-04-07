import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
class ImageAction {
    private final MyFileChooser filechooser = new MyFileChooser();
    private static ImageAction existance = null;
    private File FilePath = null;
    private File CurrentDir = null;
    private File CurrentFile = null;
    private ArrayList<File> ImagesPreLoad = null;
    private String FileName = null;
    private String[] Filter = new String[]{".BMP",".JPG",".JPEG",".JPE",".JFIF",".GIF","TIF",".TIFF",".PNG",".ICO"};
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
            frame.getLabel().setIcon(new ImageIcon(FileName));
        }
    }
    void ViewPreImage(ImageViewer frame) {
         int index = this.ImagesPreLoad.indexOf(this.CurrentFile), size = ImagesPreLoad.size();
         int Newindex = (index - 1 + size) % size;
         this.CurrentFile = ImagesPreLoad.get(Newindex);
         frame.getLabel().setIcon(new ImageIcon(this.CurrentFile.getPath()));
    }
    void ViewNextImage(ImageViewer frame) {
         int index = this.ImagesPreLoad.indexOf(this.CurrentFile), size = ImagesPreLoad.size();
         int Newindex = (index + 1) % size;
         this.CurrentFile = ImagesPreLoad.get(Newindex);
         frame.getLabel().setIcon(new ImageIcon(this.CurrentFile.getPath()));
    }
}