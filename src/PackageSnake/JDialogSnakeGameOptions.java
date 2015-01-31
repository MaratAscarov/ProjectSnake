package PackageSnake;

import java.awt.Button;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JDialogSnakeGameOptions extends JDialog {
		
	private int apply = 0;
	private int outBorderSnake = 1;
	private int disableIntersectionSnake = 0;
	private int speedGame = 200;
	
	private JCheckBox jChOutBorderSnake = new JCheckBox();
	private JCheckBox jChDisableIntersectionSnake = new JCheckBox();
	private JSlider jSSpeedGame = new JSlider(0, 0, 500, speedGame);
	
	public JDialogSnakeGameOptions(String nameFrame)
	{
		this.setFont(new Font(null,  Font.BOLD, 20));
		
		setTitle(nameFrame);
	
		setModal(true);
		setBounds(400, 200, 380, 250);
		setResizable(false);
		setVisible(false);
		setLayout(null);
		Label lOutBorderSnake = new Label("Разрешение выхода змейки за пределы поля ");
		lOutBorderSnake.setBounds(20, 20, 280, 30);
		lOutBorderSnake.setFont(new Font(null, Font.BOLD, 12));
		add(lOutBorderSnake);
		
		add(jChOutBorderSnake);
		jChOutBorderSnake.setBounds(320, 25, 20, 20);
		jChOutBorderSnake.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				if(jChOutBorderSnake.isSelected() == true)
					setOutBorderSnake(1);
				else 
					if(jChOutBorderSnake.isSelected() == false)
						setOutBorderSnake(0);
			
			}
			
		});
		
		Label lDisableIntersectionSnake = new Label("Разрешение пересечения змейки со своим телом ");
		lDisableIntersectionSnake.setBounds(20, 50, 295, 30);
		lDisableIntersectionSnake.setFont(new Font(null, Font.BOLD, 12));
		add(lDisableIntersectionSnake);
		
		add(jChDisableIntersectionSnake);
		jChDisableIntersectionSnake.setBounds(320, 55, 20, 20);
		
		jChDisableIntersectionSnake.addItemListener(new ItemListener()
		{

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				if(jChDisableIntersectionSnake.isSelected() == true)
					setDisableIntersectionSnake(1);
				else 
					if(jChDisableIntersectionSnake.isSelected() == false)
						setDisableIntersectionSnake(0);
			
			}
			
		});
		
		Label lSpeedGame = new Label("Скорость игры ");
		lSpeedGame.setBounds(20, 80, 100, 30);
		lSpeedGame.setFont(new Font(null, Font.BOLD, 12));
		add(lSpeedGame);
		
		jSSpeedGame.setMajorTickSpacing(100);
		jSSpeedGame.setMinorTickSpacing(10);
		jSSpeedGame.setPaintLabels(true);
		jSSpeedGame.setPaintTicks(true);
		jSSpeedGame.setPaintTrack(true);
		jSSpeedGame.setBounds(140, 80, 220, 40);
		add(jSSpeedGame);
		
		jSSpeedGame.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				speedGame = jSSpeedGame.getValue();
			}
			
		});
		   
		
		Button bOK = new Button("OK");
		bOK.setBounds(70, 150, 100, 30);
		add(bOK);
		Button bCancel = new Button("Cancel");
		bCancel.setBounds(200, 150, 100, 30);
		add(bCancel);
		
		bOK.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				setApply(1);
				setVisible(false);
				
			}
			
		});
		
		bCancel.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setApply(0);
				setVisible(false);
			}
			
		});
		
		
	}
	
	public void setOutBorderSnake(int outBorderSnake)
	{
		this.outBorderSnake = outBorderSnake;
		if(outBorderSnake == 1) jChOutBorderSnake.setSelected(true);
		else jChOutBorderSnake.setSelected(false);
	
	}
	public int getOutBorderSnake()
	{
		return outBorderSnake;
	}

	public void setDisableIntersectionSnake(int disableIntersectionSnake)
	{
		this.disableIntersectionSnake = disableIntersectionSnake;
		if(disableIntersectionSnake == 1) jChDisableIntersectionSnake.setSelected(true);
		else jChDisableIntersectionSnake.setSelected(false);
	}
	public int getDisableIntersectionSnake()
	{
		return disableIntersectionSnake;
	}
	
	public void setSpeedGame(int speedGame)
	{
		this.speedGame = speedGame;
		jSSpeedGame.setValue(speedGame);
	}
	public int getSpeedGame()
	{
		return speedGame;
	}
	
	
	
	public void setApply(int apply)
	{
		this.apply = apply;
	}
	public int getApply()
	{
		return apply;
	}
}
