import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

class MyFileChooser extends JFileChooser {
    private void AddFilter() {
        this.addChoosableFileFilter(new MyFileFilter(new String[]{".BMP",".JPG",".JPEG",".JPE",".JFIF",".GIF","TIF",".TIFF",".PNG",".ICO"},"所有图片") {});
        this.addChoosableFileFilter(new MyFileFilter(new String[]{".BMP"},"BMP 文件 (*.BMP)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[]{".JPG",".JPEG",".JPE",".JFIF"},"JPEG 文件 (*.JPG;*.JPEG;*.JPE;*.JFIF)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[]{".GIF"},"GIF 文件 (*.GIF)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[]{".TIF",".TIFF"},"TIFF 文件 (*.TIF;*.TIFF)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[]{".PNG"},"PNG 文件 (*.PNG)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[]{".ICO"},"ICO 文件 (*.ICO)"));
    }
    public MyFileChooser() {
        super();
        System.out.println("Constructed");
        setAcceptAllFileFilterUsed(false);
        AddFilter();
    }
    class MyFileFilter extends javax.swing.filechooser.FileFilter {
        String[] SuffixArray;
        String description;
        public MyFileFilter(String[] SuffixArray, String description) {
            super();
            this.SuffixArray = SuffixArray;
            this.description = description;
        }
        @Override
        public boolean accept(File file) {
            String FileName = file.getName().toUpperCase();
            for(String suffix : SuffixArray) {
                if(FileName.endsWith(suffix)) {
                    return true;
                }
            }
            return file.isDirectory();
        }
        @Override
        public String getDescription() {
            return this.description;
        }
    }
}