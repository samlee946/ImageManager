package kechengsheji;

import javax.swing.JOptionPane;

public class ShowError {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void ShowMessage(Exception ex)
	{
		JOptionPane.showMessageDialog(null, ex.toString(),"error",JOptionPane.ERROR_MESSAGE);
	}
	public static void ShowMessage(String message){
		JOptionPane.showMessageDialog(null, message,"error",JOptionPane.ERROR_MESSAGE);

	}
	public static void ShowMessage(){
		JOptionPane.showMessageDialog(null, "操作成功","提示",JOptionPane.DEFAULT_OPTION);
	}

}
