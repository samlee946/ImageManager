import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.max;
import static java.lang.System.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ImageViewer extends javax.swing.JFrame {
    static ImageViewer frame = null;
    public ImageViewer() {
        initComponents();
        ImageLabel.setHorizontalAlignment(SwingConstants.CENTER); //居中显示Label的内容
        validate();
//        //DEBUG
//        ImageAction action = ImageAction.getInstance();
//        action.imageicon = new ImageIcon("I:\\Users\\Administrator\\Pictures\\03bd91a2-aafc-11e4-848d-ed0abaecf4a1.jpg");
//        ImageLabel.setIcon(action.imageicon);
//        //
    }
    static ImageViewer getInstance() {
        System.out.println("open outside");
        if(frame == null) frame = new ImageViewer();
        frame.setVisible(true);
        frame.setSize(1280, 720);
        return frame;
    }
    void open(File file) {
        ImageAction action = ImageAction.getInstance();
        action.openByPath(file, frame);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JScrollPane();
        ImageLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        ControlPanel = new javax.swing.JPanel();
        AutoPlayButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        CounterClockwiseButton = new javax.swing.JButton();
        ClockwiseButton = new javax.swing.JButton();
        ResizeSlider = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        ZoomLabel = new javax.swing.JLabel();
        ResetsizeButton = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        OpenMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        OptionMenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        ExitMenu = new javax.swing.JMenuItem();
        ToolsMenu = new javax.swing.JMenu();
        PreMenu = new javax.swing.JMenuItem();
        NextMenu = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        ClockwiseMenu = new javax.swing.JMenuItem();
        CounterClockwiseMenu = new javax.swing.JMenuItem();
        AboutMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("照片管理器 ");
        setMinimumSize(new java.awt.Dimension(480, 480));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        MainPanel.setMinimumSize(new java.awt.Dimension(0, 0));

        ImageLabel.setMaximumSize(new java.awt.Dimension(10086, 10086));
        MainPanel.setViewportView(ImageLabel);

        getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);

        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(120, 120));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.add(jPanel3, java.awt.BorderLayout.LINE_END);

        ControlPanel.setMinimumSize(new java.awt.Dimension(0, 480));
        ControlPanel.setPreferredSize(new java.awt.Dimension(80, 80));

        AutoPlayButton.setText("AutoPlay");
        AutoPlayButton.setEnabled(false);
        AutoPlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutoPlayButtonActionPerformed(evt);
            }
        });

        jButton2.setText("下一张");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("上一张");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("删除");

        CounterClockwiseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/counterclockwise.jpg"))); // NOI18N
        CounterClockwiseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CounterClockwiseButtonActionPerformed(evt);
            }
        });

        ClockwiseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/clockwise.jpg"))); // NOI18N
        ClockwiseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClockwiseButtonActionPerformed(evt);
            }
        });

        ResizeSlider.setMaximum(5000);
        ResizeSlider.setValue(1000);
        ResizeSlider.setEnabled(false);
        ResizeSlider.setPreferredSize(new java.awt.Dimension(97, 23));
        ResizeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ResizeSliderStateChanged(evt);
            }
        });

        jLabel1.setText("当前放大倍数:");

        ZoomLabel.setText("100%");

        ResetsizeButton.setLabel("复原");
        ResetsizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetsizeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ControlPanelLayout = new javax.swing.GroupLayout(ControlPanel);
        ControlPanel.setLayout(ControlPanelLayout);
        ControlPanelLayout.setHorizontalGroup(
            ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ControlPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ZoomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ControlPanelLayout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AutoPlayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ControlPanelLayout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CounterClockwiseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClockwiseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 163, Short.MAX_VALUE))
                    .addGroup(ControlPanelLayout.createSequentialGroup()
                        .addComponent(ResetsizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        ControlPanelLayout.setVerticalGroup(
            ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlPanelLayout.createSequentialGroup()
                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(ControlPanelLayout.createSequentialGroup()
                        .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AutoPlayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(2, 2, 2)
                        .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ResizeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ZoomLabel)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ControlPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CounterClockwiseButton)
                            .addComponent(ClockwiseButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ResetsizeButton)))
                .addContainerGap(366, Short.MAX_VALUE))
        );

        jPanel1.add(ControlPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        FileMenu.setText("文件");

        OpenMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        OpenMenu.setText("打开");
        OpenMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenMenuActionPerformed(evt);
            }
        });
        FileMenu.add(OpenMenu);
        FileMenu.add(jSeparator1);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("保存图片");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        FileMenu.add(jMenuItem1);

        OptionMenu.setText("选项");
        FileMenu.add(OptionMenu);
        FileMenu.add(jSeparator2);

        ExitMenu.setText("退出");
        ExitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuActionPerformed(evt);
            }
        });
        FileMenu.add(ExitMenu);

        MenuBar.add(FileMenu);

        ToolsMenu.setText("工具");

        PreMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_LEFT, 0));
        PreMenu.setText("上一张");
        PreMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreMenuActionPerformed(evt);
            }
        });
        ToolsMenu.add(PreMenu);

        NextMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_RIGHT, 0));
        NextMenu.setText("下一张");
        NextMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextMenuActionPerformed(evt);
            }
        });
        ToolsMenu.add(NextMenu);
        ToolsMenu.add(jSeparator3);

        ClockwiseMenu.setText("顺时针旋转图片");
        ClockwiseMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClockwiseMenuActionPerformed(evt);
            }
        });
        ToolsMenu.add(ClockwiseMenu);

        CounterClockwiseMenu.setText("逆时针旋转图片");
        CounterClockwiseMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CounterClockwiseMenuActionPerformed(evt);
            }
        });
        ToolsMenu.add(CounterClockwiseMenu);

        MenuBar.add(ToolsMenu);

        AboutMenu.setText("关于");
        MenuBar.add(AboutMenu);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    JLabel getLabel() {
        return ImageLabel;
    }
    JSlider getSlider() {
        return ResizeSlider;
    }
    JButton getAutoPlay() {
        return AutoPlayButton;
    }
    private void ExitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuActionPerformed
        exit(0);
    }//GEN-LAST:event_ExitMenuActionPerformed

    private void OpenMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenMenuActionPerformed
        ImageAction action = ImageAction.getInstance();
        action.open(frame);
        validate();
        System.out.println("button: open file ok");
    }//GEN-LAST:event_OpenMenuActionPerformed

    private void PreMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreMenuActionPerformed
        try {
            ImageAction action = ImageAction.getInstance();
            action.ViewPreImage(frame);
            validate();
        } catch (IOException ex) {
            Logger.getLogger(ImageViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PreMenuActionPerformed

    private void NextMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextMenuActionPerformed
        try {
            ImageAction action = ImageAction.getInstance();
            action.ViewNextImage(frame);
            validate();
        } catch (IOException ex) {
            Logger.getLogger(ImageViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_NextMenuActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        int width = frame.getWidth(), height = frame.getHeight();
        
        MainPanel.setSize(width, (int) (height * 0.7));
        ImageLabel.setSize(width, (int) (height * 0.7));
        
        int Blankwidth = max((int) (width - 480) / 2, 0);
        jPanel1.setSize(width, (int) (height * 0.2));
        jPanel2.setPreferredSize(new Dimension(Blankwidth, (int) (height * 0.2)));
        jPanel3.setPreferredSize(new Dimension(Blankwidth, (int) (height * 0.2)));
        
        validate();
        System.out.println(width);
        System.out.println(frame.getMinimumSize());
        System.out.println("");
    }//GEN-LAST:event_formComponentResized

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            ImageAction action = ImageAction.getInstance();
            action.ViewPreImage(frame);
            ResizeSlider.setValue(1000);
        } catch (IOException ex) {
            Logger.getLogger(ImageViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            ImageAction action = ImageAction.getInstance();
            action.ViewNextImage(frame);
            ResizeSlider.setValue(1000);
        } catch (IOException ex) {
            Logger.getLogger(ImageViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ResizeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ResizeSliderStateChanged
        ImageAction action = ImageAction.getInstance();
        int val = max(1, ResizeSlider.getValue());
        double time = (double)val / 1000;
        System.out.println(val);
        ZoomLabel.setText(time * 100 + "%");
        action.ImageResize(frame, time);
    }//GEN-LAST:event_ResizeSliderStateChanged

    private void ResetsizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetsizeButtonActionPerformed
        ResizeSlider.setValue(1000);
    }//GEN-LAST:event_ResetsizeButtonActionPerformed

    private void ClockwiseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClockwiseButtonActionPerformed
        ImageAction action = ImageAction.getInstance();
        action.rotate(frame, 1);
        validate();
    }//GEN-LAST:event_ClockwiseButtonActionPerformed

    private void CounterClockwiseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CounterClockwiseButtonActionPerformed
        ImageAction action = ImageAction.getInstance();
        action.rotate(frame, -1);
        validate();
    }//GEN-LAST:event_CounterClockwiseButtonActionPerformed

    private void ClockwiseMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClockwiseMenuActionPerformed
        ImageAction action = ImageAction.getInstance();
        action.rotate(frame, 1);
        validate();
    }//GEN-LAST:event_ClockwiseMenuActionPerformed

    private void CounterClockwiseMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CounterClockwiseMenuActionPerformed
        ImageAction action = ImageAction.getInstance();
        action.rotate(frame, -1);
        validate();
    }//GEN-LAST:event_CounterClockwiseMenuActionPerformed

    private void AutoPlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutoPlayButtonActionPerformed
        try {
            //AutoPlay autoplay = AutoPlay.getInstance();
            //autoplay.start();
            Slider slider = Slider.getInstance();
            slider.setFrame(frame);
            slider.setVisible(true);
            slider.Play();
        } catch (IOException ex) {
            Logger.getLogger(ImageViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AutoPlayButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Slider slider = Slider.getInstance();
        slider.setFrame(frame);
        slider.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
                System.out.println("open inside");
                frame = new ImageViewer();
                frame.setVisible(true);
                frame.setSize(1280, 720);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AboutMenu;
    public javax.swing.JButton AutoPlayButton;
    private javax.swing.JButton ClockwiseButton;
    private javax.swing.JMenuItem ClockwiseMenu;
    private javax.swing.JPanel ControlPanel;
    private javax.swing.JButton CounterClockwiseButton;
    private javax.swing.JMenuItem CounterClockwiseMenu;
    private javax.swing.JMenuItem ExitMenu;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JLabel ImageLabel;
    private javax.swing.JScrollPane MainPanel;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem NextMenu;
    private javax.swing.JMenuItem OpenMenu;
    private javax.swing.JMenuItem OptionMenu;
    private javax.swing.JMenuItem PreMenu;
    private javax.swing.JButton ResetsizeButton;
    public javax.swing.JSlider ResizeSlider;
    private javax.swing.JMenu ToolsMenu;
    private javax.swing.JLabel ZoomLabel;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
