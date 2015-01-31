package PackageSnake;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class JDialogSnakeAbout extends JDialog{

	public JDialogSnakeAbout(String nameFrame)
	{
	   	setTitle(nameFrame);
		setBounds(450, 230, 260, 140);
		setModal(true);
		this.setResizable(false);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		JLabel jl = new JLabel("Snake v. 1.0  2015");
		jl.setBounds(75, 20, 200, 30);
		add(jl);
	
		JLabel jl2 = new JLabel("Разработчик проекта: Аскаров Марат");
		jl2.setBounds(10, 50, 250, 30);
		add(jl2);
		
	}
}
