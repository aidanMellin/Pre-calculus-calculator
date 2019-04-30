package out.newOutput.data;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class DemoShapes {
    public static final Color DEFAULT_COLOR = Color.LIGHT_GRAY;

    public DemoShapes() {

        JFrame frame = new JFrame("Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        Dimension size = frame.getBounds().getSize();
//		int height = size.height;
//		int width = size.width;
//
//		System.out.print(width);
//		System.out.print(height);

		List<ShapeItem> shapes = new ArrayList<ShapeItem>();
        shapes.add(new ShapeItem(new Rectangle2D.Double(100, 300, 100,25),
                DEFAULT_COLOR));
        shapes.add(new ShapeItem(new Rectangle2D.Double(250,300, 100,25),
                DEFAULT_COLOR));
        shapes.add(new ShapeItem(new Rectangle2D.Double(100,350, 100,25),
                DEFAULT_COLOR));
        shapes.add(new ShapeItem(new Rectangle2D.Double(250,350, 100,25),
        		DEFAULT_COLOR));

        ShapesPanel panel = new ShapesPanel(shapes);
        frame.add(panel);

        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);

    }

    class ShapeItem {
        private Shape shape;
        private Color color;

        public ShapeItem(Shape shape, Color color) {
            super();
            this.shape = shape;
            this.color = color;
        }

        public Shape getShape() {
            return shape;
        }

        public void setShape(Shape shape) {
            this.shape = shape;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }

    @SuppressWarnings("serial")
	class ShapesPanel extends JPanel {
        private List<ShapeItem> shapes;
        public ShapesPanel(List<ShapeItem> shapesList) {
            this.shapes = shapesList;

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    Color color = Color.RED;
                    for (ShapeItem item : shapes) {
                        if (item.getShape().contains(e.getPoint())) {
                            item.setColor(color);
                            //Probably will send answer here to quiz to check
                        }
                    }
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);
            Dimension size = this.getBounds().getSize();
    		int height = size.height;
    		int width = size.width;

            Graphics2D g2 = (Graphics2D) g.create();

            for (ShapeItem item : shapes) {
            	//Draw the base unit circle
        		g2.setColor(Color.black);
        		g2.setStroke(new BasicStroke(2f));
        		//Ovals are drawn from the TL corner
        		g2.drawOval(width/4, height/25, width/2, height/2);

                g2.setStroke(new BasicStroke(2f));

                int radiusW = width/2;
        		int radiusH = height/2;

        		//Draw the Divisons of the Unit Circle
        		//First the Horizontal and Vertical
        		//W

        		//The reason for the(x+height/25) is because there is a height/25 offset from the top as a buffer, so it needs to be added to
        		//The values to get them aligned correctly
        		g2.drawLine(width/4, (height/4+height/25), 3*width/4, (height/4+height/25));
        		//H
        		g2.drawLine(width/2, height/25, width/2, (height/2+height/25));

        		//30
        		int cos30 = (int) (width/2+(radiusW/2*(Math.cos(Math.toRadians(30)))));
        		int sin30 = (int) ((height/4+height/25)-(radiusH/2*(Math.sin(Math.toRadians(30)))));

        		int cos150 = (int) (width/2-(radiusW/2*(Math.cos(Math.toRadians(30)))));
        		int sin150 = (int) ((height/4+height/25)-(radiusH/2*(Math.sin(Math.toRadians(30)))));

        		int cos210 = (int) (width/2-(radiusW/2*(Math.cos(Math.toRadians(30)))));
        		int sin210 = (int) ((height/4+height/25)+(radiusH/2*(Math.sin(Math.toRadians(30)))));

        		int cos330 = (int) (width/2+(radiusW/2*(Math.cos(Math.toRadians(30)))));
        		int sin330 = (int) ((height/4+height/25)+(radiusH/2*(Math.sin(Math.toRadians(30)))));

        		g2.drawLine(cos30, sin30, width/2, (height/4+height/25));
        		g2.drawLine(cos150, sin150, width/2,(height/4+height/25));
        		g2.drawLine(cos210, sin210, width/2, (height/4+height/25));
        		g2.drawLine(cos330, sin330, width/2, (height/4+height/25));

        		//45
        		int cos45 = (int) (width/2+(radiusW/2*(Math.cos(Math.toRadians(45)))));
        		int sin45 = (int) ((height/4+height/25)-(radiusH/2*(Math.sin(Math.toRadians(45)))));

        		int cos135 = (int) (width/2-(radiusW/2*(Math.cos(Math.toRadians(45)))));
        		int sin135 = (int) ((height/4+height/25)-(radiusH/2*(Math.sin(Math.toRadians(45)))));

        		int cos225 = (int) (width/2-(radiusW/2*(Math.cos(Math.toRadians(45)))));
        		int sin225 = (int) ((height/4+height/25)+(radiusH/2*(Math.sin(Math.toRadians(45)))));

        		int cos315 = (int) (width/2+(radiusW/2*(Math.cos(Math.toRadians(45)))));
        		int sin315 = (int) ((height/4+height/25)+(radiusH/2*(Math.sin(Math.toRadians(45)))));

        		g2.drawLine(cos45, sin45, width/2, (height/4+height/25));
        		g2.drawLine(cos135, sin135, width/2, (height/4+height/25));
        		g2.drawLine(cos225, sin225, width/2, (height/4+height/25));
        		g2.drawLine(cos315, sin315, width/2, (height/4+height/25));

        		//60
        		int cos60 = (int) (width/2+(radiusW/2*(Math.cos(Math.toRadians(60)))));
        		int sin60 = (int) ((height/4+height/25)-(radiusH/2*(Math.sin(Math.toRadians(60)))));

        		int cos120 = (int) (width/2-(radiusW/2*(Math.cos(Math.toRadians(60)))));
        		int sin120 = (int) ((height/4+height/25)-(radiusH/2*(Math.sin(Math.toRadians(60)))));

        		int cos240 = (int) (width/2-(radiusW/2*(Math.cos(Math.toRadians(60)))));
        		int sin240 = (int) ((height/4+height/25)+(radiusH/2*(Math.sin(Math.toRadians(60)))));

        		int cos300 = (int) (width/2+(radiusW/2*(Math.cos(Math.toRadians(60)))));
        		int sin300 = (int) ((height/4+height/25)+(radiusH/2*(Math.sin(Math.toRadians(60)))));

        		g2.drawLine(cos60, sin60, width/2, (height/4+height/25));
        		g2.drawLine(cos120, sin120, width/2, (height/4+height/25));
        		g2.drawLine(cos240, sin240, width/2, (height/4+height/25));
        		g2.drawLine(cos300, sin300, width/2, (height/4+height/25));

        		g2.setColor(item.getColor());
                g2.fill(item.getShape());
            }

            g2.dispose();


        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }

//        private Color getRandomColor() {
//            return Color.RED;
//        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DemoShapes();
            }
        });
    }
}
