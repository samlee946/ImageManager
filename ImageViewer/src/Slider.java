import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
public class Slider extends javax.swing.JFrame {
    static Slider slider = null;
    ImageViewer frame = null;
    File CurrentFile = null;
    ArrayList<File> ImagesPreLoad = null;
    void setFrame(ImageViewer frame) {
        this.frame = frame;
    }
    public Slider() {
        this.frame = frame;
        initComponents();
        ImageLabel.setHorizontalAlignment(SwingConstants.CENTER); //居中显示Label的内容
    }
    static Slider getInstance() {
        if(slider == null) slider = new Slider();
                slider.setVisible(true);
                GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
                        .getDefaultScreenDevice();
                slider.setBackground(Color.black);  
                slider.getContentPane().setBackground(Color.black);  
                slider.getContentPane().setVisible(true);
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gd.setFullScreenWindow(slider);
        return slider;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        ImageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImageLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        int width = frame.getWidth(), height = frame.getHeight();
        ImageLabel.setSize(width, (int) (height * 0.7));
    }//GEN-LAST:event_formComponentResized

    private void ImageLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImageLabelMouseClicked
        slider.setVisible(false);
    }//GEN-LAST:event_ImageLabelMouseClicked

    void Play() throws IOException {
        ImageAction action = ImageAction.getInstance();
        ImagesPreLoad = action.getFiles();
        File CurImage = action.getFile();
        int index = ImagesPreLoad.indexOf(CurImage);
        
//        while(true) {
            try {
                this.CurrentFile = ImagesPreLoad.get(index);
                BufferedImage buff = ImageIO.read(this.CurrentFile);
                ImageIcon imageicon = new ImageIcon(buff);
                frame.getLabel().setIcon(imageicon);
                index = (index + 1) % ImagesPreLoad.size();
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Slider.class.getName()).log(Level.SEVERE, null, ex);
            }
//        }
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Slider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Slider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Slider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Slider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                slider = new Slider();
                slider.setVisible(true);
                GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
                        .getDefaultScreenDevice();
                slider.setBackground(Color.black);  
                slider.getContentPane().setBackground(Color.black);  
                slider.getContentPane().setVisible(true);
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gd.setFullScreenWindow(slider);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageLabel;
    // End of variables declaration//GEN-END:variables
}
