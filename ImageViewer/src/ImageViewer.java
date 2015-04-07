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
        setMinimumSize(new java.awt.Dimension(1, 1));

        ImageLabel.setMaximumSize(new java.awt.Dimension(10086, 10086));
        ImageLabel.setMinimumSize(new java.awt.Dimension(100, 100));
        MainPanel.setViewportView(ImageLabel);

        getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);

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

        PreMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_LEFT, java.awt.event.InputEvent.CTRL_MASK));
        PreMenu.setText("上一张");
        PreMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreMenuActionPerformed(evt);
            }
        });
        ToolsMenu.add(PreMenu);

        NextMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_RIGHT, java.awt.event.InputEvent.CTRL_MASK));
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
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
