package kechengsheji;

import javax.swing.JOptionPane;

public class InputFromGUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getString("请输入"));

	}
	public static String getString(String message){
		String input="";
		do{
			input=JOptionPane.showInputDialog(null,message,"请输入",JOptionPane.QUESTION_MESSAGE);
			System.out.println("input"+input+"123");
			if(input.length()==0){ShowError.ShowMessage("输入不能为空");}
			else if(input.contains(" ")){ShowError.ShowMessage("输入不能带空格");}
		}while(input.length()==0||input.contains(" "));
		if(input!=null&&input!=""&&!input.contains(" ")){
			return input;
		}else return "";
	}
	public static boolean getBoolean(String message){
		int b=JOptionPane.NO_OPTION;
		b=JOptionPane.showConfirmDialog(null, message);
		if(b==JOptionPane.YES_OPTION) return true;
		else return false;
	}

}
