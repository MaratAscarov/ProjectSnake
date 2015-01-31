package PackageSnake;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class JDialogSnakeGraphicOptions extends JDialog {
	
	private Color colorField = Color.green;
	private Color colorBkField = Color.white;
	private Color colorSnake = Color.blue;
	private Color colorTarget = Color.black;
	private int sizeCell = 10;
	private int countCellX = 20;
	private int countCellY = 20;
	private int fillSnake = 1;
	private int fillTarget = 1;
	
	private int apply = 0;
	
	private Panel pFieldColor = new Panel();
	private Panel pFieldBkColor = new Panel();
	private Panel pSnakeColor = new Panel();
	private Panel pTargetColor = new Panel();
	private JSlider jSFieldSize = new JSlider(0, 5, 30, sizeCell);
	private JSlider jSFieldCountCellX = new JSlider(0, 5, 30, countCellX);        
	private JSlider jSFieldCountCellY = new JSlider(0, 5, 30, countCellY);
	
	private JCheckBox jChSnakeColorFill = new JCheckBox();
	private JCheckBox jChTargetColorFill = new JCheckBox();
	   
	
	public JDialogSnakeGraphicOptions(String nameFrame)
	{
		setTitle(nameFrame);
		setResizable(false);
		setBounds(300, 100, 650, 470);
		setVisible(false);
		setModal(true);
	    setLayout(null);
	 	    
	    Button bApplyGraphics = new Button("OK");
	    bApplyGraphics.setBounds(200, 370, 100, 30);
	    add(bApplyGraphics);
	    bApplyGraphics.addActionListener(new ActionListener()
	    {

	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		// TODO Auto-generated method stub
	      	   	setApply(1);
		   	   	setVisible(false);
	    	}
		
	    });

	    Button bExitGraphics = new Button("Cancel");
	    bExitGraphics.setBounds(320, 370, 100, 30);
	    add(bExitGraphics);
	    bExitGraphics.addActionListener(new ActionListener()
	    {

	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		// TODO Auto-generated method stub
	    		setApply(0);
	    		setVisible(false);
	    	}
		
	    });
	
	    //---------------------Поле-------------------------
	    
	    Label lmgField = new Label("Поле");
	    lmgField.setFont(new Font(null, Font.BOLD, 20));
	    lmgField.setForeground(Color.BLUE);
	    lmgField.setBounds(5, 5, 100, 30);
	    add(lmgField);
	
	    Label lmgFieldColor = new Label("Цвет сетки");
	    lmgFieldColor.setFont(new Font(null, Font.BOLD, 12));
		lmgFieldColor.setBounds(25, 35, 70, 30);
	    add(lmgFieldColor);
	
	    
	    pFieldColor.setBounds(110, 44, 25, 13);
	    pFieldColor.setBackground(colorField);	//Текущий цвет поля(сетки)
	    //pFieldColor.setBackground(getFieldColor());	//Текущий цвет поля(сетки)
		add(pFieldColor);
	    
	    Panel pBorderFieldColor = new Panel();
	    pBorderFieldColor.setBounds(108, 42, 30, 17);
	    pBorderFieldColor.setBackground(Color.black);
	    add(pBorderFieldColor);
	    
	    
	    Label lmgFieldBkColor = new Label("Фон поля");
	    lmgFieldBkColor.setFont(new Font(null, Font.BOLD, 12));
		lmgFieldBkColor.setBounds(25, 75, 70, 30);
	    add(lmgFieldBkColor);
	

	    pFieldBkColor.setBounds(110, 84, 25, 13);
	    pFieldBkColor.setBackground(colorBkField);	//Текущий цвет фона поля
	    add(pFieldBkColor);
	    
	    Panel pBorderFieldBkColor = new Panel();
	    pBorderFieldBkColor.setBounds(108, 82, 30, 17);
	    pBorderFieldBkColor.setBackground(Color.black);
	    add(pBorderFieldBkColor);
	    
	    Button bColorField = new Button("Выбор ");
	    bColorField.setBounds(145, 40, 50, 20);
	    add(bColorField);
	    
	    bColorField.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialogColorChooseBox colorChooseBoxField = new JDialogColorChooseBox("Выбор цвета");
				colorChooseBoxField.setVisible(true);
				if(colorChooseBoxField.getApply() == 1)
				{
					colorField = colorChooseBoxField.getColor();
					setColorField(colorField);
				}
			}
	    	
	    });
	  
	    Button bColorBkField = new Button("Выбор");
	    bColorBkField.setBounds(145, 80, 50, 20);
	    add(bColorBkField);
	
	    bColorBkField.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialogColorChooseBox colorChooseBoxField = new JDialogColorChooseBox("Выбор цвета");
				colorChooseBoxField.setVisible(true);
				if(colorChooseBoxField.getApply() == 1)
				{
					colorBkField = colorChooseBoxField.getColor();
					setColorBkField(colorBkField);
				}
			}
	    	
	    });
	    Label lmgFieldSize = new Label("Размер клетки");
	    lmgFieldSize.setFont(new Font(null, Font.BOLD, 12));
		lmgFieldSize.setBounds(245, 35, 110, 30);
	    add(lmgFieldSize);
	
	    jSFieldSize.setMajorTickSpacing(5);
	    jSFieldSize.setMinorTickSpacing(1);
	    jSFieldSize.setPaintLabels(true);
	    jSFieldSize.setPaintTicks(true);
	    jSFieldSize.setPaintTrack(true);
	    jSFieldSize.setBounds(460, 35, 150, 40);
	    add(jSFieldSize);
	   
	    jSFieldSize.addChangeListener(new ChangeListener()
	    {
	    	
	    	@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				sizeCell = jSFieldSize.getValue();	
			}
	    });
	   
	    Label lmgFieldCountCellX = new Label("Количество клеток по горизонтали");
	    lmgFieldCountCellX.setFont(new Font(null, Font.BOLD, 12));
		lmgFieldCountCellX.setBounds(245, 85, 220, 30);
	    add(lmgFieldCountCellX);
	
	    
	    jSFieldCountCellX.setMajorTickSpacing(5);
	    jSFieldCountCellX.setMinorTickSpacing(1);
	    jSFieldCountCellX.setPaintLabels(true);
	    jSFieldCountCellX.setPaintTicks(true);
	    jSFieldCountCellX.setPaintTrack(true);
	    jSFieldCountCellX.setBounds(460, 85, 150, 40);
	    add(jSFieldCountCellX);
	    
	    jSFieldCountCellX.addChangeListener(new ChangeListener()
	    {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				countCellX = jSFieldCountCellX.getValue();
			}
	    	
	    });
	   
	    Label lmgFieldCountCellY = new Label("Количество клеток по вертикали");
	    lmgFieldCountCellY.setFont(new Font(null, Font.BOLD, 12));
		lmgFieldCountCellY.setBounds(245, 135, 220, 30);
	    add(lmgFieldCountCellY);
	
	  
	    jSFieldCountCellY.setMajorTickSpacing(5);
	    jSFieldCountCellY.setMinorTickSpacing(1);
	    jSFieldCountCellY.setPaintLabels(true);
	    jSFieldCountCellY.setPaintTicks(true);
	    jSFieldCountCellY.setPaintTrack(true);
	    jSFieldCountCellY.setBounds(460, 135, 150, 40);
	    add(jSFieldCountCellY);
	    
	    jSFieldCountCellY.addChangeListener(new ChangeListener()
	    {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				countCellY = jSFieldCountCellY.getValue();
			}
	    	
	    });
	  
	    //---------------Змейка-------------------------
	    
	    Label lmgSnake = new Label("Змейка");
	    lmgSnake.setFont(new Font(null, Font.BOLD, 20));
	    lmgSnake.setForeground(Color.BLUE);
		lmgSnake.setBounds(5, 180, 100, 30);
	    add(lmgSnake);

	    Label lmgSnakeColor = new Label("Цвет змейки");
	    lmgSnakeColor.setFont(new Font(null, Font.BOLD, 12));
		lmgSnakeColor.setBounds(25, 210, 75, 30);
	    add(lmgSnakeColor);
	
	    pSnakeColor.setBounds(110, 219, 25, 13);
	    pSnakeColor.setBackground(colorSnake);	//Текущий цвет змейки
	    //pSnakeColor.setBackground(getSnakeColor());	//Текущий цвет змейки
		add(pSnakeColor);
	    
	    Panel pBorderSnakeColor = new Panel();
	    pBorderSnakeColor.setBounds(108, 217, 30, 17);
	    pBorderSnakeColor.setBackground(Color.black);
	    add(pBorderSnakeColor);
	 
	    
	    Button bColorSnake = new Button("Выбор");
	    bColorSnake.setBounds(145, 215, 50, 20);
	    add(bColorSnake);
	  
	    bColorSnake.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialogColorChooseBox colorChooseBoxField = new JDialogColorChooseBox("Выбор цвета");
				colorChooseBoxField.setVisible(true);
				if(colorChooseBoxField.getApply() == 1)
				{
					colorSnake = colorChooseBoxField.getColor();
					setColorSnake(colorSnake);
				}
			}
	    	
	    });

	    Label lmgSnakeColorFill = new Label("Заполнение цветом ");
	    lmgSnakeColorFill.setFont(new Font(null, Font.BOLD, 12));
		lmgSnakeColorFill.setBounds(345, 210, 140, 30);
	    add(lmgSnakeColorFill);
	 
	    add(jChSnakeColorFill);
	    jChSnakeColorFill.setBounds(525, 215, 20, 20);
	    jChSnakeColorFill.addItemListener(new ItemListener()
	    {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(jChSnakeColorFill.isSelected() == true)
					setFillSnake(1);
				else 
					if(jChSnakeColorFill.isSelected() == false)
						setFillSnake(0);
			}

	    });
	
	    //----------------Цель------------------------
	    
	    Label lmgTarget = new Label("Цель");
	    lmgTarget.setFont(new Font(null, Font.BOLD, 20));
	    lmgTarget.setForeground(Color.BLUE);
		lmgTarget.setBounds(5, 270, 100, 30);
	    add(lmgTarget);
	 
	    Label lmgTargetColor = new Label("Цвет цели");
	    lmgTargetColor.setFont(new Font(null, Font.BOLD, 12));
		lmgTargetColor.setBounds(25, 300, 75, 30);
	    add(lmgTargetColor);
	   
	    pTargetColor.setBounds(110, 309, 25, 13);
	    pTargetColor.setBackground(colorTarget);	//Текущий цвет цели
	   // pTargetColor.setBackground(getTargetColor());	//Текущий цвет цели
		add(pTargetColor);
	    
	    Panel pBorderTargetColor = new Panel();
	    pBorderTargetColor.setBounds(108, 307, 30, 17);
	    pBorderTargetColor.setBackground(Color.black);
	    add(pBorderTargetColor);
	 
	    
	    Button bColorTarget = new Button("Выбор");
	    bColorTarget.setBounds(145, 305, 50, 20);
	    add(bColorTarget);

	    bColorTarget.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialogColorChooseBox colorChooseBoxField = new JDialogColorChooseBox("Выбор цвета");
				colorChooseBoxField.setVisible(true);
				if(colorChooseBoxField.getApply() == 1)
				{
					colorTarget = colorChooseBoxField.getColor();
					setColorTarget(colorTarget);
				}
			}
	    	
	    });

	    
	    Label lmgTargetColorFill = new Label("Заполнение цветом ");
	    lmgTargetColorFill.setFont(new Font(null, Font.BOLD, 12));
		lmgTargetColorFill.setBounds(345, 300, 140, 30);
	    add(lmgTargetColorFill);
	
	    
	    add(jChTargetColorFill);
	    jChTargetColorFill.setBounds(525, 305, 20, 20);
	    
	    jChTargetColorFill.addItemListener(new ItemListener()
	    {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(jChTargetColorFill.isSelected() == true)
					setFillTarget(1);
				else 
					if(jChTargetColorFill.isSelected() == false)
						setFillTarget(0);
				
			}
	    	
	    });
	    
	}
	
	public void setColorField(Color c)
	{
		colorField = c;
		pFieldColor.setBackground(c);
	}
	public void setColorBkField(Color c)
	{
		colorBkField = c;
		pFieldBkColor.setBackground(c);
	}
	
	public void setColorSnake(Color c)
	{
		colorSnake = c;
		pSnakeColor.setBackground(c);		
	}
	
	public void setColorTarget(Color c)
	{
		colorTarget = c;
		pTargetColor.setBackground(colorTarget);
	}
	
	public Color getFieldColor()
	{
		return colorField;
	}
	
	public Color getFieldBkColor()
	{
		return colorBkField;
	}
	
	public Color getSnakeColor()
	{
		return colorSnake;
	}
	public Color getTargetColor()
	{
		return colorTarget;
	}
	
	public void setSizeCell(int sizeCell)
	{
		this.sizeCell = sizeCell;
		jSFieldSize.setValue(sizeCell);
	}
	
	public void setCountCellX(int countCellX)
	{
		this.countCellX = countCellX;
		jSFieldCountCellX.setValue(countCellX);
	}
	
	public int getSizeCell()
	{
		return sizeCell;
	}
	public int getCountCellX()
	{
		return countCellX;
	}
	public int getCountCellY()
	{
		return countCellY;
	}
	
	public void setCountCellY(int countCellY)
	{
		this.countCellY = countCellY;
		jSFieldCountCellY.setValue(countCellY);
	}
	
	public void setFillSnake(int fillSnake)
	{
		this.fillSnake = fillSnake;
		if(fillSnake == 1) jChSnakeColorFill.setSelected(true);
		else jChSnakeColorFill.setSelected(false);
	}
	
	public void setFillTarget(int fillTarget)
	{
		this.fillTarget = fillTarget;
		if(fillTarget == 1) jChTargetColorFill.setSelected(true);
		else jChTargetColorFill.setSelected(false);
	}
	
	public int getFillSnake()
	{
		return this.fillSnake;
	}
	public int getFillTarget()
	{
		return this.fillTarget;
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
