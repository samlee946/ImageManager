package kechengsheji;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

class MyFileChooser extends JFileChooser {
    private void AddFilter() {
        this.addChoosableFileFilter(new MyFileFilter(new String[]{".BMP",".JPG",".JPEG",".JPE",".JFIF",".GIF","TIF",".TIFF",".PNG",".ICO"},"����ͼƬ") {});
        this.addChoosableFileFilter(new MyFileFilter(new String[]{".BMP"},"BMP �ļ� (*.BMP)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[]{".JPG",".JPEG",".JPE",".JFIF"},"JPEG �ļ� (*.JPG;*.JPEG;*.JPE;*.JFIF)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[]{".GIF"},"GIF �ļ� (*.GIF)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[]{".TIF",".TIFF"},"TIFF �ļ� (*.TIF;*.TIFF)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[]{".PNG"},"PNG �ļ� (*.PNG)"));
        this.addChoosableFileFilter(new MyFileFilter(new String[]{".ICO"},"ICO �ļ� (*.ICO)"));
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