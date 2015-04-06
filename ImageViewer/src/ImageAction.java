import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
class ImageAction {
    private final MyFileChooser filechooser = new MyFileChooser();
    private File CurrentFile = null;
    private String FileName = null;
    private File CurrentDir = null;
    private File[] FilesArr;
    void open(ImageViewer frame) {
        System.out.println("filechooser ok");
        if(filechooser.showOpenDialog(filechooser) == JFileChooser.APPROVE_OPTION) {
            this.CurrentFile = filechooser.getSelectedFile();
            FileName = CurrentFile.getPath();
            frame.getLabel().setIcon(new ImageIcon(FileName));
//            JLabel1.setIcon(new ImageIcon(FileName));
        }
    }
}