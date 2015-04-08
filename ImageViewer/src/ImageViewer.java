import java.awt.Dimension;
import static java.lang.Math.max;
import static java.lang.System.*;
import javax.swing.*;

public class ImageViewer extends javax.swing.JFrame {
    static ImageViewer frame;
    public ImageViewer() {
        initComponents();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        OpenMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        OptionMenu = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        ExitMenu = new javax.swing.JMenuItem();
        ToolsMenu = new javax.swing.JMenu();
        PreMenu = new javax.swing.JMenuItem();
        NextMenu = new javax.swing.JMenuItem();
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
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 80));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel3.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 0));
        jPanel1.add(jPanel3, java.awt.BorderLayout.LINE_END);

        ControlPanel.setMinimumSize(new java.awt.Dimension(0, 480));
        ControlPanel.setPreferredSize(new java.awt.Dimension(80, 80));

        jButton1.setText("jButton1");

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

        jButton4.setText("jButton3");

        jButton5.setText("jButton3");

        jButton6.setText("jButton3");

        javax.swing.GroupLayout ControlPanelLayout = new javax.swing.GroupLayout(ControlPanel);
        ControlPanel.setLayout(ControlPanelLayout);
        ControlPanelLayout.setHorizontalGroup(
            ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );
        ControlPanelLayout.setVerticalGroup(
            ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addComponent(jButton3)
                .addComponent(jButton4)
                .addComponent(jButton5)
                .addComponent(jButton6))
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

        OptionMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
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

        MenuBar.add(ToolsMenu);

        AboutMenu.setText("关于");
        MenuBar.add(AboutMenu);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    JLabel getLabel() {
        return ImageLabel;
    }
    private void ExitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuActionPerformed
        exit(0);
    }//GEN-LAST:event_ExitMenuActionPerformed

    private void OpenMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenMenuActionPerformed
        ImageAction action = ImageAction.getInstance();
        action.open(frame);
        System.out.println("button: open file ok");
    }//GEN-LAST:event_OpenMenuActionPerformed

    private void PreMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreMenuActionPerformed
        ImageAction action = ImageAction.getInstance();
        action.ViewPreImage(frame);
    }//GEN-LAST:event_PreMenuActionPerformed

    private void NextMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextMenuActionPerformed
        ImageAction action = ImageAction.getInstance();
        action.ViewNextImage(frame);
    }//GEN-LAST:event_NextMenuActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        int width = frame.getWidth(), height = frame.getHeight();
        
        MainPanel.setSize(width, (int) (height * 0.8));
        ImageLabel.setSize(width, (int) (height * 0.8));
        
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
        ImageAction action = ImageAction.getInstance();
        action.ViewPreImage(frame);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ImageAction action = ImageAction.getInstance();
        action.ViewNextImage(frame);
    }//GEN-LAST:event_jButton2ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> {
            frame = new ImageViewer();
            frame.setVisible(true);
            frame.setSize(1280, 720);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AboutMenu;
    private javax.swing.JPanel ControlPanel;
    private javax.swing.JMenuItem ExitMenu;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JLabel ImageLabel;
    private javax.swing.JScrollPane MainPanel;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem NextMenu;
    private javax.swing.JMenuItem OpenMenu;
    private javax.swing.JMenuItem OptionMenu;
    private javax.swing.JMenuItem PreMenu;
    private javax.swing.JMenu ToolsMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
