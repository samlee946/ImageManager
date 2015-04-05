import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class ImageViewer extends javax.swing.JFrame {
    public ImageViewer() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("照片管理器 ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 975, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("文件");

        jMenuItem1.setText("打开");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setText("选项");
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator2);

        jMenuItem3.setText("退出");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("工具");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("关于");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
           
    }//GEN-LAST:event_jMenuItem1MouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageViewer().setVisible(true);
            }
        });
    }
    public class MyFileFilter extends javax.swing.filechooser.FileFilter {
        String SuffixArray[], description;
        public MyFileFilter(String[] SuffixArray, String desctiption) {
            super();
            this.SuffixArray = SuffixArray;
            this.description = description;
        }
        public boolean accept(File file) {
            String FileName = file.getName().toUpperCase();
            for(String suffix : SuffixArray) {
                if(FileName.endsWith(suffix)) {
                    return true;
                }
            }
            return false;
        }
        @Override
        public String getDescription() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
            
    }
    public class FileChooser extends JFileChooser {
        private void AddFilter() {
            this.addChoosableFileFilter(new MyFileFilter(new String[]{".BMP",".JPG",".JPEG",".JPE",".JFIF",".GIF","TIF",".TIFF",".PNG",".ICO"},"所有图片") {});
            this.addChoosableFileFilter(new MyFileFilter(new String[]{".BMP"},"BMP 文件 (*.BMP)"));
            this.addChoosableFileFilter(new MyFileFilter(new String[]{".JPG",".JPEG",".JPE",".JFIF"},"JPEG 文件 (*.JPG;*.JPEG;*.JPE;*.JFIF)"));
            this.addChoosableFileFilter(new MyFileFilter(new String[]{".GIF"},"GIF 文件 (*.GIF)"));
            this.addChoosableFileFilter(new MyFileFilter(new String[]{".TIF",".TIFF"},"TIFF 文件 (*.TIF;*.TIFF)"));
            this.addChoosableFileFilter(new MyFileFilter(new String[]{".PNG"},"PNG 文件 (*.PNG)"));
            this.addChoosableFileFilter(new MyFileFilter(new String[]{".ICO"},"ICO 文件 (*.ICO)"));
        }
        public FileChooser() {
            super.setAcceptAllFileFilterUsed(false);
            AddFilter();
        }
    }
    public class ImageAction {
        private final FileChooser filechooser = new FileChooser();
        private File CurrentFile = null;
        private File CurrentDir = null;
        private File[] FilesArr;
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
