package PackageSnake;

import java.awt.AWTException;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.border.TitledBorder;



public class JDialogColorChooseBox extends JDialog {
	
	private Color myColor[] = {Color.white,		
			Color.lightGray,			
			Color.gray, 			
			Color.darkGray, 			
			Color.black, 			
			Color.red, 			
			Color.pink, 			
			Color.orange, 			
			Color.yellow, 			
			Color.green, 			
			Color.magenta, 			
			Color.cyan, 			
			Color.blue 			
			};
	
	private Color colorRGBChoose = Color.black;
	private static Color colorRGBSet = Color.black;
	
	private Color currentColor;
	
	private int xMarker = 0;
	private int yMarker = 0;
	private int xMarkerBuf = 0;
	private int yMarkerBuf = 0;
	
	private int apply = 0;
	
	
	
	
	public JDialogColorChooseBox(String nameFrame)
	{
		this.setFont(new Font(null,  Font.BOLD, 20));
		
		setTitle(nameFrame);
	
		setModal(true);
		setBounds(200, 100, 360, 380);
		setResizable(false);
		setVisible(false);
		setLayout(null);
		Label lColor = new Label("Current color: ");
		lColor.setBackground(Color.white);
		lColor.setBounds(50, 230, 140, 30);
		Font fnt = new Font(null, Font.BOLD, 20);
		lColor.setFont(fnt);
		add(lColor);
		Button bOK = new Button("OK");
		bOK.setBounds(70, 300, 100, 30);
		add(bOK);
		Button bCancel = new Button("Cancel");
		bCancel.setBounds(200, 300, 100, 30);
		add(bCancel);
		
		bOK.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				setColor(colorRGBChoose);
				currentColor = getColor();
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
	
		addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int xx = getX();
				int yy = getY();
				Point p = e.getPoint();
				xMarker = p.x;
				yMarker = p.y;
				try {
					Robot robot = new Robot();
					colorRGBChoose = robot.getPixelColor(xx + p.x, yy + p.y);
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
	}
	public void paint(Graphics g)
	{
		
		int x = 4;
		int y = 28;
		int cellSize = 70;
		int countCellX = 5;
		int countCellY = 3;
		int iColor = 0;
		for(int j = 0 ; j < countCellY; j++)
			for(int i = 0 ; i < countCellX; i++)
			{	
				//if(j > 1) x = 70 + 35;
				if(iColor < myColor.length)
				{
					g.setColor(Color.black);
					g.drawRect(x + i * cellSize, y + j * cellSize, cellSize, cellSize);
					g.setColor(myColor[iColor]);
					g.fillRect(x + i * cellSize + 1, y + j * cellSize + 1, cellSize - 1, cellSize - 1);
					if(xMarker >= x + i * cellSize && xMarker <= x + i * cellSize + cellSize
							&& yMarker >= y + j * cellSize && yMarker <= y + j * cellSize + cellSize)
					{
						g.setColor(Color.BLACK);
						g.drawRect(x + i * cellSize + 1, y + j * cellSize + 1, cellSize - 2, cellSize - 2);
						g.drawRect(x + i * cellSize + 2, y + j * cellSize + 2, cellSize - 4, cellSize - 4);
						g.drawRect(x + i * cellSize + 3, y + j * cellSize + 3, cellSize - 6, cellSize - 6);
					}
				}
				iColor++;
		}
		Color c = new Color(255);
		g.setColor(colorRGBChoose);
		g.fillRect(215, 250, 135, 40);
		g.setColor(Color.black);
		g.drawRect(215, 250, 135, 40);
			
	}
	public static void setColor(Color c)
	{
		colorRGBSet = c;
	}
	public static Color getColor()
	{
		return colorRGBSet;
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
