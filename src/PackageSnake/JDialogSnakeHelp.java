package PackageSnake;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class JDialogSnakeHelp extends JDialog{
	
	public JDialogSnakeHelp(String nameFrame)
	{
		setTitle(nameFrame);
		setBounds(400, 130, 400, 450);
		setModal(true);
		this.setResizable(false);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		String sTextHelp = "                                    Управление змейкой        \n"
				+ "                    Клавиша <ВВЕРХ>  -    Движение вверх        \n"
				+ "                    Клавиша <ВНИЗ>   -    Движение вниз        \n"
				+ "                    Клавиша <ВЛЕВО>  -    Движение влево        \n"
				+ "                    Клавиша <ВПРАВО> -    Движение вправо        \n"
				+ "                    Клавиша <ПРОБЕЛ> -    Пауза\n"
				+ "\n"
				+ "                                             Начало игры\n"
				+ "                    Меню <Файл> -> <Новая игра>\n\n"
				+ "                                             Выход из игры\n"
				+ "                    Меню <Файл> -> <Выход>\n\n"
				+ "                                             Настройки графики\n"
				+ "                    Меню <Настройки> -> <Графика>\n\n"
				+ "                                             Настройки игрового режима\n"
				+ "                    Меню <Настройки> -> <Игра> \n\n  "
				+ "                                             Справочная информация\n"
				+ "                    Меню <Справка> -> <Помощь> \n"
				+ "                    Меню <Справка> -> <О приложении> "
				+ "                         "
				;
		
		JTextArea ja = new JTextArea();
		ja.setBounds(5, 5, 400, 365);
		ja.setText(sTextHelp);
		ja.setEditable(false);
		add(ja);
		
		Button b = new Button("Ok");
		b.setBounds(160, 372, 70, 30);
		add(b);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		setVisible(false);
	}

}
