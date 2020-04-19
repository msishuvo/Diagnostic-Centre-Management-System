import javax.swing.JTextField;


public class SelectAllOption {
	public void selectAll(JTextField jtf)
	{
		jtf.select(0,jtf.getText().length());
	}

}
