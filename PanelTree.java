package kechengsheji;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class PanelTree extends JPanel {

	public PanelTree()
	{
		//JTree
		File[] root=File.listRoots();
		DefaultMutableTreeNode top=new  DefaultMutableTreeNode("file");
		for(File f:root)
		{
			String str=f.getPath();
			DefaultMutableTreeNode node=new DefaultMutableTreeNode(str);
			top.add(node);
		}
		JTree tree=new JTree(top);
		JPanel p=new JPanel();
		p.add(tree);
		p.add(new JScrollPane());
		add(tree);
		/*
		 * add listener
		 */
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				 DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree
	                        .getLastSelectedPathComponent();
				 if(node==null){
					 return;
				 }
				 else {
					 if(node.isLeaf()){
						 String path=node.toString();
						 Stack<String> root=FileManage.getFileInFolder(path);
						 for(String str:root){	 
						 DefaultMutableTreeNode leaf=new DefaultMutableTreeNode(str);
							node.add(leaf);
						 }
					 }
					 
				 }
			}
			
		});
		

		
		
	}
	
	public static void main(String[] args) {
		new PanelTree();
		System.out.println(132);
	}
	

}
