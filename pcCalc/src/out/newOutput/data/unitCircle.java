package out.newOutput.data;


//Importing the used functions...
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//Beginning the setup to allow for graphing, especially in real time
@SuppressWarnings("serial")
public class unitCircle extends JFrame implements MouseListener{
	private final static int WIDTH = 500;
	private final static int HEIGHT =1000;
	private Container drawable;
	private JPanel canvas;
	private static final Stroke gStroke = new BasicStroke(2f);
	//Label l;


	//The basic runnable commands to get the program going
	public unitCircle(double[] someData) {
		super("UnitCircle");
		//		frame.setVisible(true);
		//		frame.setSize(500,200);
		//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		//		JPanel panel = new JPanel();
		//		frame.add(panel);
		//		JButton button = new JButton("Check Solver");
		//		panel.add(button);
		//		button.addActionListener (new Action1());
		//		System.out.println("Ye");

		drawable = getContentPane();
		canvas = new GraphCanvas(someData);
		drawable.add(canvas);
		setSize(WIDTH, HEIGHT);
	}

	//Setting up the graphing aspect
	public class GraphCanvas extends JPanel {
		public GraphCanvas(double[] someData) {
			super();

		}
	}

	//This will be where the primary work happens, so that the cicle can be resized at any point when the window is expanded.
	@Override
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		Dimension size = canvas.getBounds().getSize();


		int height = size.height;
		int width = size.width;
		g2.setStroke(gStroke);
		int radiusW = 3*width/4;
		int radiusH = 3*height/4;
		//System.out.println(width);

		addMouseListener(this);

		//		l=new Label();
		//        //l.setBounds(width,height,100,20);
		//        add(l);
		//        setLayout(null);
		//        setVisible(true);

		//Making the updating "background" to hide the circles that are being repeatedly drawn
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, width*10, height*10);

		//Draw the base unit circle
		g2.setColor(Color.black);
		//Ovals are drawn from the TL corner
		g2.drawOval(width/8, height/16, radiusW, radiusH/2);

		//Draw the Divisons of the Unit Circle
		//First the Horizontal and Vertical
		//W
		g2.drawLine(width/8, (height/4), 7*width/8, (height/4));
		//H
		g2.drawLine(width/2, height/16, width/2, (7*height/8)/2);

		//30
		int cos30 = (int) (width/2+(radiusW/2*(Math.cos(Math.toRadians(30)))));
		int sin30 = (int) (height/4-(radiusH/4*(Math.sin(Math.toRadians(30)))));

		int cos150 = (int) (width/2-(radiusW/2*(Math.cos(Math.toRadians(30)))));
		int sin150 = (int) (height/4-(radiusH/4*(Math.sin(Math.toRadians(30)))));

		int cos210 = (int) (width/2-(radiusW/2*(Math.cos(Math.toRadians(30)))));
		int sin210 = (int) (height/4+(radiusH/4*(Math.sin(Math.toRadians(30)))));

		int cos330 = (int) (width/2+(radiusW/2*(Math.cos(Math.toRadians(30)))));
		int sin330 = (int) (height/4+(radiusH/4*(Math.sin(Math.toRadians(30)))));

		g2.drawLine(cos30, sin30, width/2, height/4);
		g2.drawLine(cos150, sin150, width/2, height/4);
		g2.drawLine(cos210, sin210, width/2, height/4);
		g2.drawLine(cos330, sin330, width/2, height/4);

		//45
		int cos45 = (int) (width/2+(radiusW/2*(Math.cos(Math.toRadians(45)))));
		int sin45 = (int) (height/4-(radiusH/4*(Math.sin(Math.toRadians(45)))));

		int cos135 = (int) (width/2-(radiusW/2*(Math.cos(Math.toRadians(45)))));
		int sin135 = (int) (height/4-(radiusH/4*(Math.sin(Math.toRadians(45)))));

		int cos225 = (int) (width/2-(radiusW/2*(Math.cos(Math.toRadians(45)))));
		int sin225 = (int) (height/4+(radiusH/4*(Math.sin(Math.toRadians(45)))));

		int cos315 = (int) (width/2+(radiusW/2*(Math.cos(Math.toRadians(45)))));
		int sin315 = (int) (height/4+(radiusH/4*(Math.sin(Math.toRadians(45)))));

		g2.drawLine(cos45, sin45, width/2, height/4);
		g2.drawLine(cos135, sin135, width/2, height/4);
		g2.drawLine(cos225, sin225, width/2, height/4);
		g2.drawLine(cos315, sin315, width/2, height/4);

		//60
		int cos60 = (int) (width/2+(radiusW/2*(Math.cos(Math.toRadians(60)))));
		int sin60 = (int) (height/4-(radiusH/4*(Math.sin(Math.toRadians(60)))));

		int cos120 = (int) (width/2-(radiusW/2*(Math.cos(Math.toRadians(60)))));
		int sin120 = (int) (height/4-(radiusH/4*(Math.sin(Math.toRadians(60)))));

		int cos240 = (int) (width/2-(radiusW/2*(Math.cos(Math.toRadians(60)))));
		int sin240 = (int) (height/4+(radiusH/4*(Math.sin(Math.toRadians(60)))));

		int cos300 = (int) (width/2+(radiusW/2*(Math.cos(Math.toRadians(60)))));
		int sin300 = (int) (height/4+(radiusH/4*(Math.sin(Math.toRadians(60)))));

		g2.drawLine(cos60, sin60, width/2, height/4);
		g2.drawLine(cos120, sin120, width/2, height/4);
		g2.drawLine(cos240, sin240, width/2, height/4);
		g2.drawLine(cos300, sin300, width/2, height/4);


		Color rectButtonColor = Color.BLACK;
		g2.drawRect((width/30),(3*height/5-height/25),(width/5-width/50),50);
		g2.drawRect((width/30),(3*height/5+height/25),(width/5-width/50),50);
//		g2.drawRect((width/30),(3*height/5+(3*height/25)),(width/5-width/50),50);

		g2.drawRect((width/4 + width/30),(3*height/5-height/25),(width/5-width/50),50);
		g2.drawRect((width/4 + width/30),(3*height/5+height/25),(width/5-width/50),50);
//		g2.drawRect((width/4 + width/30),(3*height/5+(3*height/25)),(width/5-width/50),50);

		g2.drawRect((width/2 + width/30),(3*height/5-height/25),(width/5-width/50),50);
		g2.drawRect((width/2 + width/30),(3*height/5+height/25),(width/5-width/50),50);
//		g2.drawRect((width/2 + width/30),(3*height/5+(3*height/25)),(width/5-width/50),50);

		g2.drawRect((3*width/4 + width/30),(3*height/5-height/25),(width/5-width/50),50);
		g2.drawRect((3*width/4 + width/30),(3*height/5+height/25),(width/5-width/50),50);
//		g2.drawRect((3*width/4 + width/30),(3*height/5+(3*height/25)),(width/5-width/50),50);

	}

	@Override
	public void mousePressed(MouseEvent e) {

		if (e.getX() <= (500/5-500/50) && e.getX() >= (500/30)) {
			System.out.println("True "+e.getX() + "Hello?");
			System.out.println();

		}
	}

	//Run the program
	public static void main(String[] args) {
		double[] d =  {0,0};
		Frame f = new unitCircle(d);
		f.setVisible(true);
	}
}
