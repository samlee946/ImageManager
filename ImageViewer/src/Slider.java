import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.max;
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
public class Slider extends javax.swing.JFrame implements Runnable {
    ImageIcon imageicon;
    static ImageViewer frame = null;
    File CurrentFile = null;
    ImageAction action = ImageAction.getInstance();
    File CurImage = action.getFile();
    ArrayList<File> ImagesPreLoad = action.getFiles();
    int index = ImagesPreLoad.indexOf(CurImage);
    int originalheight;
    int originalwidth;
    int play = 0;
    int type;
    double viewTimes = 1.0;
    Thread time = new Thread(this); //new thread
    void setFrame(ImageViewer frame) {
        this.frame = frame;
    }
    void setType(int type) {
        this.type = type;
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
    void slideshow() {
        System.out.println("click slideshow");
        time.start();
        play = 1;
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(this);
    }
    void ImageResize(double size) {
        if(imageicon != null) {
            int width = max(1, (int)(originalwidth * size));
            int height = max(1, (int)(originalheight * size));
            ImageLabel.setIcon(new ImageIcon(imageicon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
        }
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
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        ImageLabel.setPreferredSize(new java.awt.Dimension(1280, 720));
        ImageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImageLabelMouseClicked(evt);
            }
        });
        ImageLabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ImageLabelKeyPressed(evt);
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

    private void ImageLabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ImageLabelKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            time.suspend();
            GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
            this.setVisible(false); 
        }
    }//GEN-LAST:event_ImageLabelKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            time.suspend();
            GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
            this.setVisible(false); 
        }
    }//GEN-LAST:event_formKeyPressed

    void Play() {
        try {
            for(double i = viewTimes; i > 0; i -= 0.05) ImageResize(i);
            this.CurrentFile = ImagesPreLoad.get(index);
            BufferedImage buff = ImageIO.read(this.CurrentFile);
            imageicon = new ImageIcon(buff);
            originalheight = imageicon.getIconHeight();
            originalwidth = imageicon.getIconWidth();
            //show image in center or pull, 0 is center, 1 is pull
            if(type == 1) {
                int WindowHeight = this.getHeight();
                viewTimes = (double) WindowHeight / originalheight;
            }
            for(double i = 0; i <= viewTimes; i += 0.05) ImageResize(i);
            //ImageLabel.setIcon(imageicon);
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageLabel;
    // End of variables declaration//GEN-END:variables

}
