package kechengsheji;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Stack;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import org.omg.CORBA.ShortSeqHolder;
import org.w3c.dom.events.MouseEvent;

public class PreviewFrame extends JFrame {

	private JPanel imgPanel = new JPanel();
	public MyMouseListener l;

	public void setImgPanel(JPanel panel) {
		imgPanel = panel;
		//System.out.println("length " + imgPanel);
		imgPanel.repaint();
		imgPanel.setSize(1000, 630);

		this.validate();
		this.repaint();

	}

	private Stack<JPanel> panelStack = new Stack<JPanel>();

	public PreviewFrame() {
		setLayout(null);

		File[] root = File.listRoots();
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("file");
		for (File f : root) {
			String str = f.getPath();
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(str);
			top.add(node);
		}
		// 样式
		JTree tree = new JTree(top);
		tree.setSize(300, 720);
		JScrollPane p = new JScrollPane();
		p.setViewportView(tree);
		p.setBounds(10, 40, 200, 630);
		// 顶头工具栏

		JToolBar item = new JToolBar("菜单");
		item.add(new LastBtn());
		// item.add(new ReturnBtn(this,imgPanel,panelStack));
		item.add(new JMenuItem("菜单"));

		item.setBounds(2, 2, 1280, 30);
		add(item);
		add(p);

		imgPanel.setSize(1000, 630);

		JScrollPane p1 = new JScrollPane();
		// p1.setSize(1000,720);
		p1.setViewportView(imgPanel);
		p1.setBounds(250, 40, 1000, 630);

		add(p1);

		setTitle("文件管理器");
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// 文件树双击监听
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
						.getLastSelectedPathComponent();
				if (node == null) {
					// System.out.println(node.toString());
					return;
				} else {
					if (node.isLeaf()) {
						String path = node.toString();
						Stack<String> root = FileManage.getFileInFolder(path);

						if (root != null)
							for (String str : root) {
								DefaultMutableTreeNode leaf = new DefaultMutableTreeNode(
										str);
								node.add(leaf);
							}
						// 把文件图标加到Panel上
						addImginPanel(root);
					} else {
						Stack<String> root = new Stack<String>();
						for (int i = 0; i < node.getChildCount(); i++) {
							String t = node.getChildAt(i).toString();
							// System.out.println(""+node.getChildAt(i).toString());
							// System.out.println("path"+t);
							if (t != null && t != "")
								root.add(t);
						}
						// 把文件图标加到Panel上
						if (root != null)
							addImginPanel(root);

					}
					imgPanel.repaint();
					imgPanel.validate();
					repaint();
					validate();
				}
			}
		});

	}

	//
	private int row = 0;
	private boolean isEnd = false;

	public void addImginPanel(Stack<String> filePaths) {
		panelStack.push(imgPanel);
		row = 0;
		isEnd = false;
		imgPanel.removeAll();
		row = (filePaths.toArray().length + 3) / 4;
		// 总行数
		row = row > 5 ? 5 : row;
		imgPanel.setLayout(new GridLayout(row, 4, 5, 5));
		int count = 0;
		for (String filePath : filePaths) {
			count++;
			addImg(filePath);
			if (count >= 4 * row)
				break;
		}
		imgPanel.removeMouseWheelListener(l);
		l = new MyMouseListener();
		if (filePaths.toArray().length > 4 * row) {
			l.setFilePaths(filePaths);
			imgPanel.addMouseWheelListener(l);
		}
		// MyMouseRightClick s= new MyMouseRightClick();
		// imgPanel.addMouseListener(s);
		imgPanel.repaint();
		imgPanel.validate();
		panelStack.push(imgPanel);
		repaint();
		validate();
	}

	// 鼠标滚动监听
	private class MyMouseListener implements MouseWheelListener {
		private Stack<String> filePaths;

		private void setFilePaths(Stack<String> filePaths) {
			this.filePaths = filePaths;
		}

		public void mouseWheelMoved(MouseWheelEvent e) {
			int rotatin = e.getWheelRotation();
			int count = filePaths.toArray().length;
			int start = 0;
			int end = 0;
			if (rotatin > 0 && !isEnd) {
				//System.out.println("rotatin" + rotatin);
				row += rotatin;
				if (row > (filePaths.toArray().length + 3) / 4) {
					isEnd = true;
				}
				row = row > (filePaths.toArray().length + 3) / 4 ? (filePaths
						.toArray().length + 3) / 4 : row;

				imgPanel.setLayout(new GridLayout(row, 4, 5, 5));
				imgPanel.repaint();
				imgPanel.validate();
				start = (row - rotatin) * 4;
				end = start + 4;
				if (start > count || end > count) {
					isEnd = true;
				}
				start = start > count ? count - 4 : start;
				end = end > count ? count : end;
				if (end == count) {
					isEnd = true;
				}
				//System.out.println("end" + isEnd);
				for (int i = start; i < end; i++) {
					String filePath = filePaths.get(i);
					addImg(filePath);
				}
				//System.out.println(filePaths.get(end - 1));
				if (isEnd) {
					imgPanel.removeMouseWheelListener(this);
					filePaths = null;
					row = 0;
					isEnd = false;
				}
			}
			imgPanel.repaint();
			imgPanel.validate();
			repaint();
			validate();
		}

	}

	// 给面板添加图标
	private void addImg(String filePath) {
		MyLabel jlbl = new MyLabel(filePath);
		jlbl.addMouseListener(new MyMouseRightClick(jlbl, imgPanel, this));
		imgPanel.add(jlbl);
		//.out.println("imgPanel" + jlbl.getFilePath());
	}

	public static void main(String[] args) {
		new PreviewFrame();
		// TODO Auto-generated method stub
	}

}

// 自定义的鼠标事件
class MyMouseRightClick implements MouseListener {

	private MyLabel label = new MyLabel("");
	private JPanel panel;// 单前面板
	private PreviewFrame frame;

	public MyMouseRightClick() {
		super();
	}

	public MyMouseRightClick(MyLabel label, JPanel panel, PreviewFrame frame) {
		super();
		this.label = label;
		this.panel = panel;
		this.frame = frame;
		//System.out.println("onClick" + label.getFilePath());
	}

	@Override
	// 单击
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		int mods = e.getModifiers();
		JPopupMenu jp = new JPopupMenu();
		// 浮动菜单
		jp.add(new ChangeNameBtn(label, panel));
		jp.add(new DeleteBtn(label, panel));
		jp.add(new CopyBtn(label, panel));
		if (ImageJudge.IsImage(new File(label.getFilePath()))) {
			jp.add(new ConvertBtn(label, panel));
		}
		//System.out.println("123456");
		jp.add(new CheckBtn(label, panel));

		jp.add(new MoveBtn(label, panel));
		jp.setSize(100, 100);
		label.add(jp);
		// 右键
		if ((mods & InputEvent.BUTTON3_MASK) != 0) {
			jp.show(label, e.getX(), e.getY());
		}
		// 鼠标双击的处理
		else if (InputEvent.BUTTON1_MASK == mods && e.getClickCount() == 2) {
			// jp.show(label,e.getX(),e.getY());
			String path = label.getFilePath();
			File file = new File(label.getFilePath());
			if (file.isDirectory()) {
				Stack<String> filePaths = FileManage.getFileInFolder(path);
				if (filePaths != null) {
					panel.removeMouseWheelListener(frame.l);
					frame.addImginPanel(filePaths);

				}
			} else if (file.isFile() && ImageJudge.IsImage(file)) {
				String p=file.getPath();
				InfoFileManage.update("path",
						file.getPath().replace(file.getName(), ""));
				ImageViewer frame1 = ImageViewer.getInstance();
				frame1.open(file);
			}else if(file.isFile()&&UnZipFile.JudgeIsZip(file)){
				UnZipFile.UnZip(file.getPath(), "c:\\Adminstrator");
				Stack<String>stack=UnZipFile.getFileInZip("c:\\Adminstrator");
				if(!stack.empty()){
					InfoFileManage.update("path",
							"c:\\Adminstrator");
					for(String f:stack){
						File ff=new File(f);
						if(ImageJudge.IsImage(ff)){
						ImageViewer frame1 = ImageViewer.getInstance();
						frame1.open(ff);
						}
					}
				}
			}
		}
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

// 自定义的带图片Jlabel
class MyLabel extends JLabel {
	private String filePath = new String();

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

	MyLabel(String filePath) {
		super();
		this.filePath = new String(filePath);
		File file = new File(filePath);
		ImageIcon icon = new ImageIcon();
		if (file.exists() && file.isFile() && ImageJudge.IsImage(file)) {
			icon = new ImageIcon(filePath);
			icon.setImage(icon.getImage().getScaledInstance(100, 100,
					Image.SCALE_DEFAULT));
		} else if (file.exists() && file.isDirectory()) {
			FileSystemView fsv = FileSystemView.getFileSystemView();
			// sun.awt.shell.ShellFolder sf =
			// sun.awt.shell.ShellFolder.getShellFolder(file);
			icon = (ImageIcon) fsv.getSystemIcon(file);
			icon.setImage(icon.getImage().getScaledInstance(80, 80,
					Image.SCALE_DEFAULT));
		}
		String text = file.getName();
		if (text.length() > 10) {
			setText(text.substring(0, 10));
		} else {
			setText(text);
		}
		setIcon(icon);
		setHorizontalAlignment(SwingConstants.CENTER);
		updateUI();
		setAlignmentX(LEFT_ALIGNMENT);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setVerticalTextPosition(SwingConstants.BOTTOM);
	}
}

// 改名字按钮
class ChangeNameBtn extends JButton {
	private MyLabel label1;
	private JPanel panel;
	private String filePath1 = "";

	public ChangeNameBtn(MyLabel label, JPanel panel) {
		super("改名");
		this.label1 = label;
		//System.out.println("btn" + label.getFilePath());
		this.filePath1 = label.getFilePath();
		this.panel = panel;
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 弹窗写文字
				String newFileName = InputFromGUI.getString("请输入文件名");
				System.out.println(label.getFilePath());
				if (newFileName != "") {
					label1.setText(newFileName);
					label1.setFilePath(FileManage.changeName(
							label1.getFilePath(), newFileName));
				}
				//.out.println(label1.getFilePath());
				label.repaint();
				label.validate();
				panel.repaint();
				panel.validate();
			}

		});

	}

}

// 删除按钮
class DeleteBtn extends JButton {
	private MyLabel label;
	private JPanel panel;

	public DeleteBtn(MyLabel label, JPanel panel) {
		super("删除");
		this.label = label;
		this.panel = panel;
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean temp = InputFromGUI.getBoolean("是否删除");
				if (temp) {

					if (FileManage.deleteFile(label.getFilePath())) {
						panel.remove(label);
						panel.validate();
					} else {
						ShowError.ShowMessage("删除失败");
					}
				} else {
				}
			}

		});
	}

}

// 查看..图片和压缩文件
class CheckBtn extends JButton {
	private MyLabel label;
	private JPanel panel;

	public CheckBtn(MyLabel label, JPanel panel) {
		super("查看");
		this.label = label;
		this.panel = panel;

		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				File file = new File(label.getFilePath());
				if (ImageJudge.IsImage(file)) {
					//.out.println("check" + file.getPath());
					ImageViewer frame = ImageViewer.getInstance();
					frame.open(file);
				}
			}

		});

	}
}

// 移动
class MoveBtn extends JButton {
	private MyLabel label;
	private JPanel panel;

	public MoveBtn(MyLabel label, JPanel panel) {
		super("移动");
		this.label = label;
		this.panel = panel;
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String afterP = FileManage.getFloder(true);
				if (afterP != null && afterP != "") {
					if (FileManage.fileRemove(label.getFilePath(), afterP)) {
						ShowError.ShowMessage();
						panel.remove(label);
						panel.validate();
					} else
						ShowError.ShowMessage("操作失败");
				}
			}

		});
	}
}

// 复制
class CopyBtn extends JButton {
	private MyLabel label;
	private JPanel panel;

	public CopyBtn(MyLabel label, JPanel panel) {
		super("复制");
		this.label = label;
		this.panel = panel;
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String afterP = FileManage.getFloder(true);
				if (afterP != null && afterP != "") {
					if (FileManage.fileCopy(label.getFilePath(), afterP)) {
						ShowError.ShowMessage();
					} else
						ShowError.ShowMessage("操作失败");
				}
			}

		});
	}
}

class ConvertBtn extends JButton {
	private MyLabel label;
	private JPanel panel;

	public ConvertBtn(MyLabel label, JPanel panel) {
		super("转码");
		this.label = label;
		this.panel = panel;
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String temp = "123";
				do {
					temp = InputFromGUI
							.getString("请输入需要转换成的格式，注意只能jpg pmg bmp之间进行转换");
					temp = temp.toLowerCase();
					//System.out.println("temp" + temp);
				} while (temp.compareTo("jpg") != 0
						&& temp.compareTo("png") != 0
						&& temp.compareTo("bmp") != 0);
				String path = FileManage.getFloder(true);
				if (path != null && path != "") {
					if (FileManage.convert(label.getFilePath(), temp, path))
						ShowError.ShowMessage();
					else
						ShowError.ShowMessage("操作失败");
				}
			}

		});
	}
}

class ReturnBtn extends JButton {
	private PreviewFrame frame;
	JPanel panel;
	private Stack<JPanel> panelStack;

	public ReturnBtn(PreviewFrame frame, JPanel panel, Stack<JPanel> panelStack) {
		super("回退");
		this.frame = frame;
		this.panel = panel;
		this.panelStack = panelStack;
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// frame.remove(panel);
				if (panelStack != null && panelStack.toArray().length > 0) {
					frame.remove(panel);
					frame.setImgPanel(panelStack.pop());
					frame.validate();
				}
			}

		});
	}
}

class LastBtn extends JButton {
	public LastBtn() {
		super("打开上次路径");
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ConfigMessage message = InfoFileManage.getConfig();
				String path = message.path;
				File file = new File(path);
				System.out.println("file"+file.isHidden());
				if (file.exists() && file.isDirectory()) {
//					System.out.println("592"+path);
					Stack<String> stack = FileManage.getImgFileInFolder(path);
					System.out.println("stack"+stack.isEmpty());
					ImageViewer frame = ImageViewer.getInstance();
					if (stack != null && !stack.isEmpty()) {
						for (String s : stack) {
							System.out.println(s);
							File f = new File(s);
							if (ImageJudge.IsImage(f)) {System.out.println("f "+f.getPath());
								frame.open(f);
								
								break;
							}
						}

					}
				}
			}
		});
	}
}
