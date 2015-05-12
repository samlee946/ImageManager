import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
public class Slider extends javax.swing.JFrame implements Runnable{
    static Slider slider = null;
    static ImageViewer frame = null;
    File CurrentFile = null;
    int play = 0;
    ImageAction action = ImageAction.getInstance();
    File CurImage = action.getFile();
    ArrayList<File> ImagesPreLoad = action.getFiles();
    int index = ImagesPreLoad.indexOf(CurImage);
    Thread time = new Thread(this); //new thread
    void setFrame(ImageViewer frame) {
        this.frame = frame;
    }
    public Slider() {
        initComponents();
        ImageLabel.setHorizontalAlignment(SwingConstants.CENTER); //居中显示Label的内容
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
                        .getDefaultScreenDevice();
                this.setBackground(Color.black);  
                this.getContentPane().setBackground(Color.black);  
                this.getContentPane().setVisible(true);
                this.setVisible(true);
    }
    static Slider getInstance() {
        if(slider == null)  slider = new Slider();
                GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
                        .getDefaultScreenDevice();
                slider.setBackground(Color.black);  
                slider.getContentPane().setBackground(Color.black);  
                slider.getContentPane().setVisible(true);
                slider.setVisible(true);
//                gd.setFullScreenWindow(slider);
        return slider;
    }
    void slideshow() {
        System.out.println("click slideshow");
        time.start();
        play = 1;
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        ImageLabel.setPreferredSize(new java.awt.Dimension(1280, 720));
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
        ImageLabel.setSize(width, height);
    }//GEN-LAST:event_formComponentResized

    private void ImageLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImageLabelMouseClicked
        time.suspend();
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
        this.setVisible(false);            
    }//GEN-LAST:event_ImageLabelMouseClicked

    void Play() {
        try {
            this.CurrentFile = ImagesPreLoad.get(index);
            BufferedImage buff = ImageIO.read(this.CurrentFile);
            ImageIcon imageicon = new ImageIcon(buff);
            ImageLabel.setIcon(imageicon);
            index = (index + 1) % ImagesPreLoad.size();
            System.out.println("play index: " + index);
        } catch (IOException ex) {
            Logger.getLogger(Slider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void run() {
        System.out.println("slideshow running with state: " + play);
        while(play == 1) {
            try {
                Play();
                time.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Slider.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Slider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Slider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Slider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Slider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
            
//            public void run() {
//                System.out.println("hehe");
//                while(play == 1) {
                    
//                }
//                slider = new Slider();
//                slider.setVisible(true);
//                GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
//                        .getDefaultScreenDevice();
//                slider.setBackground(Color.black);  
//                slider.getContentPane().setBackground(Color.black);  
//                slider.getContentPane().setVisible(true);
////                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                gd.setFullScreenWindow(slider);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageLabel;
    // End of variables declaration//GEN-END:variables


}
