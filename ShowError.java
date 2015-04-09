
import javax.swing.JOptionPane;

public class ShowError {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void ShowMessage(Exception ex)
	{
		JOptionPane.showMessageDialog(null, ex.toString(),"error",JOptionPane.ERROR_MESSAGE);
	}

}
