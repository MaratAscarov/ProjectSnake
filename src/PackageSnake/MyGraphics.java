package PackageSnake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class MyGraphics extends Frame 
{
	
	private int x = 0;
	private int y = 0;
	private int dx = 0;
	private int dy = 0;
	private int tx = 0;
	private int ty = 0;
	private int sizeSnake = 0;
	private int xField = 15;
	private int yField = 45;
	private int countCellX = 20;
	private int countCellY = 20;
	private int sizeCell = 20;
	private int fillSnake = 1;
	private int fillTarget = 1;
	
	private int outBorderSnake = 0;
	private int disableIntersectionSnake = 0;
	private int speedGame = 200;
	
	
	private Color fieldColor = Color.black;
	private Color fieldBkColor = Color.cyan;
	
	private Color snakeColor = Color.blue;
	private Color targetColor = Color.magenta;
	
	private boolean stopMoveSnake = false;
	private int newRandomTarget = 0;
	
	private Random rand = new Random();
	private int rCountCellX = 0;
	private int rCountCellY = 0;
	
		
	private ArrayList<Integer> xList = new ArrayList<Integer>();
	private ArrayList<Integer> yList = new ArrayList<Integer>();
	
	private JDialogSnakeGraphicOptions grOptions = new JDialogSnakeGraphicOptions("Настройки графики");
	private JDialogSnakeGameOptions gameOptions = new JDialogSnakeGameOptions("Опции игры");
	private JDialogSnakeGameOver gameOverSnake = new JDialogSnakeGameOver();
	
	private JDialogSnakeHelp fHelp = new JDialogSnakeHelp("Справка");
	private JDialogSnakeAbout fAbout = new JDialogSnakeAbout("О приложении");
	
	private ConfigSnake cfgSnake = new ConfigSnake();
	private ArrayList configList;

	public MyGraphics(String frameName)
	{
		super(frameName);
		setBounds(300, 100, 600, 500);
		setResizable(false);
		setVisible(true);
		setLayout(null);
		
		Label l1 = new Label("    Управление ");
		l1.setBounds(450, 170, 100, 20);
		add(l1);
		
		Label l2 = new Label(" Влево  - <Left>");
		l2.setBounds(450, 210, 100, 20);
		add(l2);
		
		Label l3 = new Label(" Вправо - <Right>");
		l3.setBounds(450, 230, 100, 20);
		add(l3);
		
		Label l4 = new Label(" Вверх   - <Up>");
		l4.setBounds(450, 250, 100, 20);
		add(l4);
		Label l5 = new Label(" Вниз    - <Down>");
		l5.setBounds(450, 270, 100, 20);
		add(l5);
		Label l6 = new Label(" Пауза   - <Space>");
		l6.setBounds(450, 290, 100, 20);
		add(l6);
		
		
		//configList = cfgSnake.loadConfig();
		//saveLoadParameters();
		//recordParametersToListCFG();
		//cfgSnake.saveConfig(configList);
			
		MenuBar menuBar = new MenuBar();
		Menu File = new Menu("Файл");
		Menu Options = new Menu("Настройки");
		Menu Help = new Menu("Справка");
		
		menuBar.add(File);
		menuBar.add(Options);
		menuBar.add(Help);
		
		//File
		MenuItem New = new MenuItem("Новая игра");
		MenuItem Exit = new MenuItem("Выход");
		//Options
		MenuItem Graphics = new MenuItem("Графика");
		MenuItem Game = new MenuItem("Игра");
		//Help
		MenuItem Details = new MenuItem("Помощь");
		MenuItem About = new MenuItem("О приложении");
		
	
		
		File.add(New);
		File.add(Exit);
		Options.add(Graphics);
		Options.add(Game);
		
		Help.add(Details);
		Help.add(About);
		Details.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stopMoveSnake = true;
				fHelp.setVisible(true);
			}
		});
		
		About.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stopMoveSnake = true;
				fAbout.setVisible(true);
			}
		});
	
		
		New.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				newBegin();
			}
		});
		
		Exit.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		Graphics.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stopMoveSnake = true;
				
				grOptions.setColorField(fieldColor);
				grOptions.setColorBkField(fieldBkColor);
				grOptions.setColorSnake(snakeColor);
				grOptions.setColorTarget(targetColor);
				grOptions.setSizeCell(sizeCell);
				grOptions.setCountCellX(countCellX);
				grOptions.setCountCellY(countCellY);
				grOptions.setFillSnake(fillSnake);
				grOptions.setFillTarget(fillTarget);
				grOptions.setVisible(true);
				if(grOptions.getApply() == 1)
				{	
					fieldColor = grOptions.getFieldColor();
					fieldBkColor = grOptions.getFieldBkColor();
					snakeColor = grOptions.getSnakeColor();
					targetColor = grOptions.getTargetColor();
					fillSnake = grOptions.getFillSnake();
					fillTarget = grOptions.getFillTarget();
					
					x = x / sizeCell;
					y = y / sizeCell;
					for(int i = 1; i <= sizeSnake; i++)
					{
						xList.set(i, xList.get(i) / sizeCell);
						yList.set(i, yList.get(i) / sizeCell);
					}
				
					sizeCell = grOptions.getSizeCell();
					
					tx = rCountCellX * sizeCell;
					ty = rCountCellY * sizeCell;
				
					if(countCellX != grOptions.getCountCellX() ||
							countCellY != grOptions.getCountCellY())
					{
						countCellX = grOptions.getCountCellX();
						countCellY = grOptions.getCountCellY();
						x = 0;
						y = 0;
						xList.clear();
						yList.clear();
						xList.add(x);
						yList.add(y);
						sizeSnake = 0;
						do
						{
							rCountCellX = rand.nextInt(countCellX - 1);
							rCountCellY = rand.nextInt(countCellY - 1);
							
							tx = rCountCellX * sizeCell;
							ty = rCountCellY * sizeCell;
							
							newRandomTarget = 0;
							for(int i = 0; i < xList.size(); i++)
							{
								if(xList.get(i) == tx && yList.get(i) == ty) 
								{
									newRandomTarget = 1;
								}
							}
						}
						while(newRandomTarget == 1);
				
					}
			
					x = x * sizeCell;
					y = y * sizeCell;
					xList.set(0, x);
					yList.set(0, y);
					for(int i = 1; i <= sizeSnake; i++)
					{
						xList.set(i, xList.get(i) * sizeCell);
						yList.set(i, yList.get(i) * sizeCell);
					}
					
					//recordParametersToListCFG();
					//cfgSnake.saveConfig(configList);
				}
			}
			
		});
		
		Game.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stopMoveSnake = true;
				gameOptions.setSpeedGame(speedGame);
				gameOptions.setOutBorderSnake(outBorderSnake);
				gameOptions.setDisableIntersectionSnake(disableIntersectionSnake);
				gameOptions.setVisible(true);
				
				if(gameOptions.getApply() == 1)
				{
					speedGame = gameOptions.getSpeedGame();
					outBorderSnake = gameOptions.getOutBorderSnake();
					disableIntersectionSnake = gameOptions.getDisableIntersectionSnake();
					
					//recordParametersToListCFG();
					//cfgSnake.saveConfig(configList);
				}
			}
			
		});
		setMenuBar(menuBar);
		rCountCellX = rand.nextInt(countCellX - 1);
		rCountCellY = rand.nextInt(countCellY - 1);
		
		tx = rCountCellX * sizeCell;
		ty = rCountCellY * sizeCell;
		xList.add(x);
		yList.add(y);
		
		addWindowListener(new WindowListener()
		{

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		addKeyListener(new KeyListener()
		{

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == e.VK_UP)
				{	dy = -1;
					if(dx != 0) dx = 0;
					stopMoveSnake = false;
				}
				if(e.getKeyCode() == e.VK_DOWN)
				{	dy = 1;
					if(dx != 0) dx = 0;
					stopMoveSnake = false;
				}
				if(e.getKeyCode() == e.VK_LEFT)
				{	dx = -1;
					if(dy != 0) dy = 0;
					stopMoveSnake = false;
				}
				if(e.getKeyCode() == e.VK_RIGHT)
				{	dx = 1;
					if(dy != 0) dy = 0;
					stopMoveSnake = false;
				}
				if(e.getKeyCode() == e.VK_SPACE)
				{
					stopMoveSnake = !stopMoveSnake;
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		while(true)
		{
			if(!stopMoveSnake)
				move();			//Движение змейки
			newTarget();		//Генерация новой цели
						
			repaint();
			try {
				Thread.sleep(speedGame);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private void newBegin()   //новая игра по выбору пользователя
	{
		stopMoveSnake = false;
		x = 0;
		y = 0;
		dx = 0;
		dy = 0;
		xList.clear();
		yList.clear();
		xList.add(x);
		yList.add(y);
		sizeSnake = 0;
		do
		{
			rCountCellX = rand.nextInt(countCellX - 1);
			rCountCellY = rand.nextInt(countCellY - 1);
			tx = rCountCellX * sizeCell;
			ty = rCountCellY * sizeCell;
			newRandomTarget = 0;
			for(int i = 0; i < xList.size(); i++)
				{
					if(xList.get(i) == tx && yList.get(i) == ty) 
						newRandomTarget = 1;
				}
		}	
		while(newRandomTarget == 1);

	}
	
	private void newGame()  //новая игра после проигрыша 
	{
		stopMoveSnake = true;
		gameOverSnake.setHighScore(sizeSnake);
		gameOverSnake.setVisible(true);
		if(gameOverSnake.getApply() == 1)
		{
			stopMoveSnake = false;
			x = 0;
			y = 0;
			dx = 0;
			dy = 0;
			xList.clear();
			yList.clear();
			xList.add(x);
			yList.add(y);
			sizeSnake = 0;
			do
			{
				rCountCellX = rand.nextInt(countCellX - 1);
				rCountCellY = rand.nextInt(countCellY - 1);
				tx = rCountCellX * sizeCell;
				ty = rCountCellY * sizeCell;
				newRandomTarget = 0;
				for(int i = 0; i < xList.size(); i++)
					{
						if(xList.get(i) == tx && yList.get(i) == ty) 
							newRandomTarget = 1;
					}
			}	
			while(newRandomTarget == 1);
		}
	}
	
	private void move()
	{
		if(sizeSnake > 0) 
		{
			for(int i = sizeSnake ; i > 0; i--)
			{
				if(i != 0)
				{
					//перекопирование значений координат по X  и по Y
					//отдельных ячеек змейки 
					xList.set(i, xList.get(i-1));
					yList.set(i, yList.get(i-1));
				}
			}
		}
		x = x + dx * sizeCell;
		y = y + dy * sizeCell;
		
		if(outBorderSnake == 0)
		{
			if(x < 0 || x > sizeCell * (countCellX - 1)||
					y < 0 || y > sizeCell * (countCellY - 1)) 
				newGame();
		}
		else
			if(outBorderSnake == 1)
			{
				if(x < 0) x = sizeCell * (countCellX - 1);
				if(x > sizeCell * (countCellX - 1)) x = 0;
				if(y < 0) y = sizeCell * (countCellY - 1);
				if(y > sizeCell * (countCellY - 1)) y = 0;
			}
		
		xList.set(0, x);
		yList.set(0, y);
		
		if(disableIntersectionSnake == 0)
		{	
			intersectionSnake();
		}	
	}
	
	private void  intersectionSnake()
	{
		int flagIntersection = 0;
		if(sizeSnake > 0)
			for(int ii = 1; ii < xList.size(); ii++)
			{	
				if(x == xList.get(ii) && y == yList.get(ii))
				{
					flagIntersection = 1;
					break;
				}
			}
		if(flagIntersection == 1)
			newGame();
	}
	
	private void newTarget()
	{
		if(x == tx && y == ty)
		{
			do
			{
				rCountCellX = rand.nextInt(countCellX - 1);
				rCountCellY = rand.nextInt(countCellY - 1);
				tx = rCountCellX * sizeCell;
				ty = rCountCellY * sizeCell;
				newRandomTarget = 0;
				for(int i = 0; i < xList.size(); i++)
				{
					if(xList.get(i) == tx && yList.get(i) == ty) 
						newRandomTarget = 1;
				}
			}
			while(newRandomTarget == 1);
			sizeSnake++;
			xList.add(x);
			yList.add(y);
		}
	}
	
	public void saveLoadParameters()
	{
		for(int i = 0; i < configList.size(); i++)
		{
			if(cfgSnake.getField(configList.get(i).toString()).equals("countCellX"))
				countCellX = Integer.parseInt(cfgSnake.getValue(configList.get(i).toString()));
			if(cfgSnake.getField(configList.get(i).toString()).equals("countCellY"))
				countCellY = Integer.parseInt(cfgSnake.getValue(configList.get(i).toString()));
			if(cfgSnake.getField(configList.get(i).toString()).equals("sizeCell"))
				sizeCell = Integer.parseInt(cfgSnake.getValue(configList.get(i).toString()));
			if(cfgSnake.getField(configList.get(i).toString()).equals("fillSnake"))
				fillSnake = Integer.parseInt(cfgSnake.getValue(configList.get(i).toString()));
			if(cfgSnake.getField(configList.get(i).toString()).equals("fillTarget"))
				fillTarget = Integer.parseInt(cfgSnake.getValue(configList.get(i).toString()));
			if(cfgSnake.getField(configList.get(i).toString()).equals("outBorderSnake"))
				outBorderSnake = Integer.parseInt(cfgSnake.getValue(configList.get(i).toString()));
			if(cfgSnake.getField(configList.get(i).toString()).equals("disableIntersectionSnake"))
				disableIntersectionSnake = Integer.parseInt(cfgSnake.getValue(configList.get(i).toString()));
			if(cfgSnake.getField(configList.get(i).toString()).equals("speedGame"))
				speedGame = Integer.parseInt(cfgSnake.getValue(configList.get(i).toString()));
			if(cfgSnake.getField(configList.get(i).toString()).equals("fieldColor"))
				fieldColor = cfgSnake.getColorValue(configList.get(i).toString());
			if(cfgSnake.getField(configList.get(i).toString()).equals("fieldBkColor"))
				fieldBkColor = cfgSnake.getColorValue(configList.get(i).toString());
			if(cfgSnake.getField(configList.get(i).toString()).equals("snakeColor"))
				snakeColor = cfgSnake.getColorValue(configList.get(i).toString());
			if(cfgSnake.getField(configList.get(i).toString()).equals("targetColor"))
				targetColor = cfgSnake.getColorValue(configList.get(i).toString());
		}
	}
	public void recordParametersToListCFG()
	{
		configList.clear();
		configList.add("countCellX = " + String.valueOf(countCellX));
		configList.add("countCellY = " + String.valueOf(countCellY));
		configList.add("sizeCell = " + String.valueOf(sizeCell));
		configList.add("fillSnake = " + String.valueOf(fillSnake));
		configList.add("fillTarget = " + String.valueOf(fillTarget));
		configList.add("outBorderSnake = " + String.valueOf(outBorderSnake));
		configList.add("disableIntersectionSnake = " + String.valueOf(disableIntersectionSnake));
		configList.add("speedGame = " + String.valueOf(speedGame));
		configList.add("fieldColor = " + cfgSnake.getColorStringValue(fieldColor));
		configList.add("fieldBkColor = " + cfgSnake.getColorStringValue(fieldBkColor));
		configList.add("snakeColor = " + cfgSnake.getColorStringValue(snakeColor));
		configList.add("targetColor = " + cfgSnake.getColorStringValue(targetColor));
		
	}
	
	private void drawField(Graphics g, Color fieldColor)
	{
		
		g.setColor(Color.black);
		g.drawRect(xField + sizeCell - 1, yField + sizeCell - 1, countCellX * sizeCell + 2, sizeCell * countCellY + 2);
		
		g.setColor(fieldBkColor);
		g.fillRect(xField + sizeCell, yField + sizeCell, countCellX * sizeCell, sizeCell * countCellY);
		
		g.setColor(fieldColor);
		for(int i = 1; i <= (countCellX + 1); i++)
			g.drawLine(xField + i * sizeCell, yField + sizeCell, xField + i * sizeCell, yField + sizeCell * (countCellY + 1));
		
		for(int i = 1; i <= (countCellY + 1); i++)
			g.drawLine(xField + sizeCell,yField + i * sizeCell, xField + sizeCell * (countCellX + 1), yField + i * sizeCell);
	}

	private void drawSnake(Graphics g, Color c)
	{
		g.setColor(c);
		for(int i = 0; i < xList.size(); i++)
		{	
			if(fillSnake == 1)
				g.fillRect(xField + sizeCell + xList.get(i) + 1, yField + sizeCell + yList.get(i) + 1, sizeCell - 1, sizeCell - 1);
			else
			{	
				g.drawRect(xField + sizeCell + xList.get(i) + 1, yField + sizeCell + yList.get(i) + 1, sizeCell - 2, sizeCell - 2);
				g.drawRect(xField + sizeCell + xList.get(i) + 2, yField + sizeCell + yList.get(i) + 2, sizeCell - 4, sizeCell - 4);
			}
		}
	}
	
	private void drawTarget(Graphics g, Color c)
	{
		g.setColor(c);
		if(fillTarget == 1)
			g.fillRect(tx + sizeCell + xField + 1, ty + sizeCell + yField + 1, sizeCell - 1, sizeCell - 1);
		else
		{	
			g.drawRect(tx + sizeCell + xField + 1, ty + sizeCell + yField + 1, sizeCell - 2, sizeCell - 2);
			g.drawRect(tx + sizeCell + xField + 2, ty + sizeCell + yField + 2, sizeCell - 4, sizeCell - 4);
		}
	}
	
	private void drawLabelSizeSnake(Graphics g)
	{
		g.setColor(Color.blue);
		g.setFont(new Font(null, Font.BOLD, 16));
		g.drawString("Результат : " + String.valueOf(sizeSnake + 1), 450, 100);
	}
	
	private void drawLabelPaused(Graphics g)
	{
		g.setColor(Color.blue);
	//	g.setFont(new Font(null, Font.BOLD, 70));
	//	g.drawString("Пауза", 140, 270);
		g.setFont(new Font(null, Font.BOLD, 20));
		g.drawString("Пауза", 470, 150);
	
	}
	
	
	public void paint(Graphics g)
	{
		g = (Graphics2D) g;
		drawField(g, fieldColor);
		drawSnake(g, snakeColor);
		drawTarget(g, targetColor);
		drawLabelSizeSnake(g);
		if(stopMoveSnake == true)
			drawLabelPaused(g);
		
	}

}
