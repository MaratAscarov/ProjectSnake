package PackageSnake;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class JDialogSnakeGameOver extends JDialog{
	
	private int apply = 0;
	private int highScore = 0;
	private Label lMessage = new Label("»√–¿ «¿ ŒÕ◊≈Õ¿");
	private Label lHighScore = new Label("¬¿ÿ –≈«”À‹“¿“ : " + String.valueOf(highScore));
	
	public JDialogSnakeGameOver()
	{
		setResizable(false);
		setBounds(420, 200, 350, 145);
	
		setVisible(false);
	    
		setModal(true);
	    setLayout(null);
	 	
	    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	    	    
	    lMessage.setBounds(80, 10, 190, 30);
		lMessage.setForeground(Color.red);
		lMessage.setFont(new Font(null, Font.BOLD, 20));
		add(lMessage);
		
		lHighScore.setBounds(70, 40, 250, 30);
		lHighScore.setForeground(Color.blue);
		lHighScore.setFont(new Font(null, Font.BOLD, 20));
		add(lHighScore);
		
	    
		Button bBegin = new Button("Õ‡˜‡Ú¸ Á‡ÌÓ‚Ó");
		bBegin.setBounds(50, 80, 100, 30);
		add(bBegin);
		bBegin.addActionListener(new ActionListener()
		{

		    @Override
		  	public void actionPerformed(ActionEvent e) {
		   		// TODO Auto-generated method stub
		   	   	setApply(1);
		   	   	setVisible(false);
		   	}
			
		 });

		 Button bExitGameSnake = new Button("¬˚ıÓ‰ ËÁ Ë„˚");
		 bExitGameSnake.setBounds(190, 80, 100, 30);
		 add(bExitGameSnake);
		 bExitGameSnake.addActionListener(new ActionListener()
		 {

		   	@Override
		   	public void actionPerformed(ActionEvent e) {
		   		// TODO Auto-generated method stub
		   		System.exit(0);
		   	}
			
		 });
	}
	
	public void setApply(int apply)
	{
		this.apply = apply;
	}
	
	public int getApply()
	{
		return apply;
	}
	
	public void setHighScore(int highScore)
	{
		this.highScore = highScore;
		lHighScore.setText("¬¿ÿ –≈«”À‹“¿“ : " + String.valueOf(highScore + 1));
	}
	
	public int getHighScore()
	{
		return highScore;
	}
	
}
