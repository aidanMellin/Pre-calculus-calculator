package out.newOutput.data;

import java.awt.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class complexGraphDataTri extends JFrame {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private Container drawable;
    private JPanel canvas;
    
    private static final Color graphOrig = Color.blue;
    private static final Stroke gStroke = new BasicStroke(3f);
    
    private static int winSizeX = 500;
    private static int winSizeY = 500;
    private static int winSize = 500;
        
    public complexGraphDataTri(double[] someData) {
        super("SimpleGraph");
        drawable = getContentPane();
        canvas = new GraphCanvas(someData);
        drawable.add(canvas);
        setSize(WIDTH, HEIGHT+22); //Give the bottom some extra space to be able to actually show the hatches
    }
    public class GraphCanvas extends JPanel {
        private double[] data;
        private int points;
        private double[] XData;
        private double[] YData;
        
        public GraphCanvas(double[] someData) {
            super();
            
            data = someData;
            points = data.length;
            XData = new double[points];
            YData = new double[points];
            for(int i = 0; i < points/2; i++) {
           
                XData[i] = data[i*2];
                YData[i] = data[i*2+ 1];
                //System.out.println(XData[i]+" "+YData[i]);
            }
        }
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            //Base axes
            g2.drawLine(0,winSizeY/2,winSizeX,winSizeY/2);
            g2.drawLine(winSizeX/2, 0, winSizeX/2, winSizeY);
           
            
            //Create hatches for axes
            //Y
            for (int j = 0; j < winSizeY/2; j++) {
            	if (j > winSizeY/2) {
            		int xH0Y = winSizeX/2 - 5;
                	int xH1Y = winSizeX/2 + 5;
                	
                	int yH0Y = 500-j*winSizeY/20;
                	int yH1Y = yH0Y;
                	
                	g2.drawLine(xH0Y, yH0Y, xH1Y, yH1Y);
            		
            	} else {
            		int xH0Y = winSizeX/2 - 5;
                	int xH1Y = winSizeX/2 + 5;
                	
                	int yH0Y = j*winSizeY/20;
                	int yH1Y = yH0Y;
                	
                	g2.drawLine(xH0Y, yH0Y, xH1Y, yH1Y);
                }
            }
            
            //X
            for (int j = 0; j <winSizeX/2; j++) {
            	if (j < winSizeX/2) { 
            		int xH0X = j*winSizeX/20;
            		int xH1X = xH0X;
            		
            		int yH0X = winSizeX/2 - 5;
            		int yH1X = winSizeX/2 + 5;
            		
            		g2.drawLine(xH0X, yH0X, xH1X, yH1X);
            	} else {
            		int xH0X = 500 - j*winSizeX/20;
            		int xH1X = xH0X;
            		
            		int yH0X = winSizeX/2 - 5;
            		int yH1X = winSizeX/2 + 5;
            		
            		g2.drawLine(xH0X, yH0X, xH1X, yH1X);
            	}
            	
            }
            int scalar = 10;
            for(int i = 0; i < points/3-2 ; i++) {
                int x0 = (int) (XData[i]);
                int x1 = (int) (XData[i + 1]);
                int y0 = (int) (YData[i]);
                int y1 = (int) (YData[i + 1]);
                
               // System.out.println("X "+i+" "+x0+" "+y0+","+x1+" "+y1);
                
                String x0S = "";
                String y0S = "";
                
                
                
                if (x0 > winSize/2 && y0 < winSize/ 2) { //Q1
                	x0S = ""+(scalar*(x0-winSize/2)/(winSize/2));
                	y0S = ""+(scalar*(y0-winSize/2)/(-winSize/2));
                	System.out.println("Q11 Configure");
                } else if (x0 < winSize/2 && y0 < winSize/2) {
                	x0S = ""+(scalar*(x0-250)/-250);
                	y0S = ""+(scalar*(y0-250)/-250);
                	System.out.println("Q2 Configure");
                } else if (x0 < winSize/2 && y0 > winSize/2) {
                	x0S = ""+(scalar*(x0-250)/-250);
                	y0S = ""+(scalar*(y0-250)/250);
                	System.out.println("Q3 Configure");
                } else if (x0 > winSize/2 && y0 > winSize/2) {
                	x0S = ""+(scalar*(x0-250)/250);
                	y0S = ""+(scalar*(y0-250)/250);
                	System.out.println("Q4 Configure");
                } else if (x0 == winSize/2 && y0 == winSize/2){
                	x0S = ""+0;
                	y0S = ""+0;
                } else if (y0 == winSize/2 && x0 != winSize/2) {
                	x0S = ""+(scalar*(x0-winSize/2)/(winSize/2));
                	y0S = ""+0;
                } else if (x0 == winSize/2 && y0 != winSize/2) {
                	x0S = ""+0;
                	y0S = ""+(scalar*(y0-winSize/2)/(winSize/2));
                }
                
                System.out.println("Reconverted Coordinates \n"+x0S+","+y0S);

                
                g2.setColor(graphOrig);
                g2.setStroke(gStroke);
                
                g2.drawString("("+x0S+","+y0S+")", x0-25, y0+25);
                
                g2.drawLine(x0, y0, x1, y1);
                

        }
            
            for(int i = points/4; i < points/2-1; i++) {
            	if (XData[i] > 0 || YData[i] > 0) {
            		
                int zx0 = (int) (XData[i]);
                int zx1 = (int) (XData[i + 1]);
                int zy0 = (int) (YData[i]);
                int zy1 = (int) (YData[i + 1]);
                
                String zx0S = "";
                String zy0S = "";
                
                if (zx0 > winSize/2 && zy0 < winSize/ 2) { //Q1
                	zx0S = ""+(scalar*(zx0-winSize/2)/(winSize/2));
                	zy0S = ""+(scalar*(zy0-winSize/2)/(-winSize/2));
                	System.out.println("Q1 Configure");
                } else if (zx0 < winSize/2 && zy0 < winSize/2) {
                	zx0S = ""+(scalar*(zx0-winSize/2)/(-winSize/2));
                	zy0S = ""+(scalar*(zy0-winSize/2)/(-winSize/2));
                	System.out.println("Q2 Configure");
                } else if (zx0 < winSize/2 && zy0 > winSize/2) {
                	zx0S = ""+(scalar*(zx0-winSize/2)/(-winSize/2));
                	zy0S = ""+(scalar*(zy0-winSize/2)/(winSize/2));
                	System.out.println("Q3 Configure");
                } else if (zx0 > winSize/2 && zy0 > winSize/2) {
                	zx0S = ""+(scalar*(zx0-winSize/2)/(winSize/2));
                	zy0S = ""+(scalar*(zy0-winSize/2)/(winSize/2));
                	System.out.println("Q4 Configure");
                } else if (zx0 == winSize/2 && zy0 == winSize/2){
                	zx0S = ""+0;
                	zy0S = ""+0;
                } else if (zy0 == winSize/2 && zx0 != winSize/2) {
                	zx0S = ""+(scalar*(zx0-winSize/2)/(winSize/2));
                	zy0S = ""+0;
                } else if (zx0 == winSize/2 && zy0 != winSize/2) {
                	zx0S = ""+0;
                	zy0S = ""+(scalar*(zy0-winSize/2)/(winSize/2));
                }
                
                System.out.println("Reconverted Coordinates \n"+zx0S+","+zy0S);

                g2.setColor(Color.RED);
                g2.setStroke(gStroke);
                
                g2.drawLine(zx0, zy0, zx1, zy1);
                
                g2.drawString("("+zx0S+","+zy0S+")", zx0-25, zy0+25);
               // g2.drawString("("+zx1+","+zy1+")", zx1-25, zy1+25);
                //g2.drawString(x1String, x1, y1);
                                
            	} 
            	//g2.drawLine(XData[points/4], YData[points/4], XData[points/2-1], YData[points/2-1]);
            	
      }
    }
  }
   
 
    public static void main(double x1, double y1, double x2, double y2, double x3, double y3, double cis, double rotPtx, double rotPty){
    	int Q1 = 0;
    	int Q2 = 0;
    	int Q3 = 0;
    	
    	int zQ1 = 0;
    	int zQ2 = 0;
    	int zQ3 = 0;
    	
    	
    	double cos = Math.cos(cis*Math.PI/180);
        double sin = Math.sin(cis*Math.PI/180);
        
    
       
        //System.out.print("Z "+a1+" "+b1+"\n");
        
        double zx1 = rotPtx + (cos*(x1-rotPtx)-sin*(y1-rotPty));
        double zy1 = rotPty + (sin*(x1-rotPtx)+cos*(y1-rotPty));
        
        double zx2 = rotPtx + (cos*(x2-rotPtx)-sin*(y2-rotPty));
        double zy2 = rotPty + (sin*(x2-rotPtx)+cos*(y2-rotPty));
        
        double zx3 = rotPtx + (cos*(x3-rotPtx)-sin*(y3-rotPty));
        double zy3 = rotPty + (sin*(x3-rotPtx)+cos*(y3-rotPty));
        
        System.out.println(zx1+" ZX1");
        
        System.out.println("Z Raw Data\n"+zx1+","+zy1+"\n"+zx2+","+zy2+"\n"+zx3+","+zy3+"\n");
   
    	if (x1 > 0 && y1 > 0) {
    		Q1 = 1;
    	} else if (x1 < 0 && y1 > 0) {
    		Q1 = 2;
    	} else if (x1 < 0 && y1 < 0) {
    		Q1 = 3;
    	} else if (x1 > 0 && y1 < 0) {
    		Q1 = 4;
    		}
    	if (x2 > 0 && y2 > 0) {
    		Q2 = 1;
    	} else if (x2 < 0 && y2 > 0) {
    		Q2 = 2;
    	} else if (x2 < 0 && y2 < 0) {
    		Q2 = 3;
    	} else if (x2 > 0 && y2 < 0) {
    		Q2 = 4;
    		}
    	if (x3 > 0 && y3 > 0) {
    		Q3 = 1;
    	} else if (x3 < 0 && y3 > 0) {
    		Q3 = 2;
    	} else if (x3 < 0 && y3 < 0) {
    		Q3 = 3;
    	} else if (x3 > 0 && y3 < 0) {
    		Q3 = 4;
    		}
    	
    	//Z Quarters
    	if (zx1 > 0 && zy1 > 0) {
    		zQ1 = 1;
    	} else if (zx1 < 0 && zy1 > 0) {
    		zQ1 = 2;
    	} else if (zx1 < 0 && zy1 < 0) {
    		zQ1 = 3;
    	} else if (zx1 > 0 && zy1 < 0) {
    		zQ1 = 4;
    		}
    	if (zx2 > 0 && zy2 > 0) {
    		zQ2 = 1;
    	} else if (zx2 < 0 && zy2 > 0) {
    		zQ2 = 2;
    	} else if (zx2 < 0 && zy2 < 0) {
    		zQ2 = 3;
    	} else if (zx2 > 0 && zy2 < 0) {
    		zQ2 = 4;
    		}
    	if (zx3 > 0 && zy3 > 0) {
    		zQ3 = 1;
    	} else if (zx3 < 0 && zy3 > 0) {
    		zQ3 = 2;
    	} else if (zx3 < 0 && zy3 < 0) {
    		zQ3 = 3;
    	} else if (zx3 > 0 && zy3 < 0) {
    		zQ3 = 4;
    		}
    	
    	//System.out.println(zx1+","+zy1+" "+zQ1);
    	
    	//double[] xList = {x1,y1,x2,y2,3,y3};
    	
    	//System.out.println("Q1 "+Q1);    	
    	
    	if (Math.abs(x1) < 100 && Math.abs(y1) < 100 && Math.abs(x2) < 100 && Math.abs(y2) < 100 && Math.abs(x3) < 100 && Math.abs(y3) < 100) {
    		//Making X1 & Y1 Coordinates go to the right Quadrant and coordiante
    		double x1a = x1;
    		double y1a = y1;
    		double x2a = x2;
    		double y2a = y2;
    		double x3a = x3;
    		double y3a = y3;
    		
    		double zx1a = zx1;
    		double zy1a = zy1;
    		double zx2a = zx2;
    		double zy2a = zy2;
    		double zx3a = zx3;
    		double zy3a = zy3;
    		
    		
    		x1 = Math.abs(x1);
    		y1 = Math.abs(y1);
    		x2 = Math.abs(x2);
    		y2 = Math.abs(y2);
    		x3 = Math.abs(x3);
    		y3 = Math.abs(y3);
    		
    		zx1 = Math.abs(zx1);
    		zy1 = Math.abs(zy1);
    		zx2 = Math.abs(zx2);
    		zy2 = Math.abs(zy2);
    		zx3 = Math.abs(zx3);
    		zy3 = Math.abs(zy3);
    		
    		//double[] zList = {zx1a,zy1a,zx2a,zy2a,zx3a,zy3a};
    		
    		int xMax = 0;
    		int yMax = 0;
    		
    		double[] xMaxList = {x1,x2,x3,zx1,zx2,zx3};
    		double[] yMaxList = {y1,y2,y3,zy1,zy2,zy3};
    		
    		for (int i = 0; i < xMaxList.length; i++) {
    			if (xMaxList[i]> xMax) {
    				xMax = (int) xMaxList[i];
    				System.out.println("XMax "+xMax);
    			}
    			
    		}
    		for (int i = 0; i < yMaxList.length; i++) {
    			if (yMaxList[i] > yMax) {
    				yMax = (int) yMaxList[i];
    				System.out.println("YMax "+yMax);
    			}
    		}
    		
    		double scalar = 0;
    		//int sHatch = 0;
    		
    		if (xMax < 10) {
    			scalar = 20;

    		} else if(xMax < 25) {
    			scalar = 50;
    			
    		} else if(xMax < 50) {
    			scalar = 100;
    			
    		} else if (xMax < 100) {
    			scalar = 200;
    			
    		}
    		
    		//sHatch = scalar * 2 +2;
    		//System.out.println(sHatch);
    		/*
    		double x1String = x1;
    		double y1String = y1;
    		double x2String = x2;
    		double y2String = y2;
    		double x3String = x3;
    		double y3String = y3;
    		*/
    	
    		
    		if (Q1 == 1) { //Quarter 1 for X&Y 1    			
    			x1 = winSize / 2 + winSize / scalar * x1;
        		y1 = winSize / 2 - winSize / scalar * y1;
        		
    		} else if (Q1 == 2) { //Quarter 2
    			x1 = winSize / 2 - winSize / scalar * x1;
    			y1 = winSize / 2 - winSize / scalar * y1;
        		
    		} else if (Q1 == 3) { //Quarter 3
    			x1 = winSize / 2 - winSize / scalar * x1;
    			y1 = winSize / 2 + winSize / scalar * y1;
    			
    		} else if (Q1 == 4) { //Quarter 4
    			x1 = winSize / 2 + winSize / scalar * x1;
    			y1 = winSize / 2 + winSize / scalar * y1;
    			
    		} else {
    			if (x1a > 0) {
    				x1 = winSize / 2 + winSize/scalar * x1;
    			} else {
    				x1 = winSize / 2 - winSize/scalar * x1;
    			}
    			if (y1a > 0) {
    				y1 = winSize / 2 - winSize/scalar * y1;
    			} else {
    				y1 = winSize / 2 + winSize/scalar * y1;
    			}
        		
    		}
    		//System.out.println("x "+x1);
    		
    		if (Q2 == 1) { //Quarter 1 for X&Y 2
    			x2 = winSize / 2 + winSize / scalar * x2;
        		y2 = winSize / 2 - winSize / scalar * y2;
        		
    		} else if (Q2 == 2) { //Quarter 2
    			x2 = winSize / 2 - winSize / scalar * x2;
    			y2 = winSize / 2 - winSize / scalar * y2;
        		
    		} else if (Q2 == 3) { //Quarter 3
    			x2 = winSize / 2 - winSize / scalar * x2;
    			y2 = winSize / 2 + winSize / scalar * y2;
    			
    		} else if (Q2 == 4) { //Quarter 4
    			x2 = winSize / 2 + winSize / scalar * x2;
    			y2 = winSize / 2 + winSize / scalar * y2;
    			
    		} else {
    			if (x2a > 0) {
    				x2 = winSize / 2 + winSize / scalar * x2;
    			} else {
    				x2 = winSize / 2 - winSize / scalar * x2;
    			}
    			if (y2a > 0) {
    				y2 = winSize / 2 - winSize / scalar * y2;
    			} else {
    				y2 = winSize / 2 + winSize / scalar * y2;
    			}
    		}
    		
    		if (Q3 == 1) { //Quarter 1 for X&Y 2
    			x3 = winSize / 2 + winSize/scalar * x3;
        		y3 = winSize / 2 - winSize/scalar * y3;
        		
    		} else if (Q3 == 2) { //Quarter 2
    			x3 = winSize / 2 - winSize / scalar * x3;
    			y3 = winSize / 2 - winSize / scalar * y3;
        		
    		} else if (Q3 == 3) { //Quarter 3
    			x3 = winSize / 2 - winSize / scalar * x3;
    			y3 = winSize / 2 + winSize / scalar * y3;
    			
    		} else if (Q3 == 4) { //Quarter 4
    			x3 = winSize / 2 + winSize / scalar * x3;
    			y3 = winSize / 2 + winSize / scalar * y3;
    			
    		} else {
    			if (x3a > 0) {
    				x3 = winSize / 2 + winSize/scalar * x3;
    			} else {
    				x3 = winSize / 2 - winSize/scalar * x3;
    			}
    			if (y3a > 0) {
    				y3 = winSize / 2 - winSize/scalar * y3;
    			} else {
    				y3 = winSize / 2 + winSize/scalar * y3;
    			}
    		}

    		if (zQ1 == 1) { //Quarter 1 for X&Y 1
    			zx1 = winSize / 2 + winSize/scalar * zx1;
        		zy1 = winSize / 2 - winSize/scalar * zy1;
        		
    		} else if (zQ1 == 2) { //Quarter 2
    			zx1 = winSize / 2 - winSize / scalar * zx1;
    			zy1 = winSize / 2 - winSize / scalar * zy1;
        		
    		} else if (zQ1 == 3) { //Quarter 3
    			zx1 = winSize / 2 - winSize / scalar * zx1;
    			zy1 = winSize / 2 + winSize / scalar * zy1;
    			
    		} else if (zQ1 == 4) { //Quarter 4
    			zx1 = winSize / 2 + winSize / scalar * zx1;
    			zy1 = winSize / 2 + winSize / scalar * zy1;
    			
    		} else {
    			if (zx1a > 0) {
    				zx1 = winSize / 2 + winSize/scalar * zx1;
    			} else {
    				zx1 = winSize / 2 - winSize/scalar * zx1;
    			}
    			if (zy1a > 0) {
    				zy1 = winSize / 2 - winSize/scalar * zy1;
    			} else {
    				zy1 = winSize / 2 + winSize/scalar * zy1;
    			}
        		
    		}
    		
    		if (zQ2 == 1) { //Quarter 1 for X&Y 1
    			zx2 = winSize / 2 + winSize/scalar * zx2;
        		zy2 = winSize / 2 - winSize/scalar * zy2;
        		
    		} else if (zQ2 == 2) { //Quarter 2
    			zx2 = winSize / 2 - winSize / scalar * zx2;
    			zy2 = winSize / 2 - winSize / scalar * zy2;
        		
    		} else if (zQ2 == 3) { //Quarter 3
    			zx2 = winSize / 2 - winSize / scalar * zx2;
    			zy2 = winSize / 2 + winSize / scalar * zy2;
    			
    		} else if (zQ2 == 4) { //Quarter 4
    			zx2 = winSize / 2 + winSize / scalar * zx2;
    			zy2 = winSize / 2 + winSize / scalar * zy2;
    			
    		} else {
    			if (zx2a > 0) {
    				zx2 = winSize / 2 + winSize/scalar * zx2;
    			} else {
    				zx2 = winSize / 2 - winSize/scalar * zx2;
    			}
    			if (zy2a > 0) {
    				zy2 = winSize / 2 - winSize/scalar * zy2;
    			} else {
    				zy2 = winSize / 2 + winSize/scalar * zy2;
    			}
        		
    		}
    		
    		if (zQ3 == 1) { //Quarter 1 for X&Y 1
    			zx3 = winSize / 2 + winSize/scalar * zx3;
        		zy3 = winSize / 2 - winSize/scalar * zy3;
        		
    		} else if (zQ3 == 2) { //Quarter 2
    			zx3 = winSize / 2 - winSize / scalar * zx3;
    			zy3 = winSize / 2 - winSize / scalar * zy3;
        		
    		} else if (zQ3 == 3) { //Quarter 3
    			zx3 = winSize / 2 - winSize / scalar * zx3;
    			zy3 = winSize / 2 + winSize / scalar * zy3;
    			
    		} else if (zQ3 == 4) { //Quarter 4
    			zx3 = winSize / 2 + winSize / scalar * zx3;
    			zy3 = winSize / 2 + winSize / scalar * zy3;
    			
    		} else {
    			if (zx3a > 0) {
    				zx3 = winSize / 2 + winSize/scalar * zx3;
    			} else {
    				zx3 = winSize / 2 - winSize/scalar * zx3;
    			}
    			if (zy3a > 0) {
    				zy3 = winSize / 2 - winSize/scalar * zy3;
    			} else {
    				zy3 = winSize / 2 + winSize/scalar * zy3;
    			}
        		
    		}
    		 
    	
    		
    		//System.out.println(""+x1+" "+y1);
    	}
    	//System.out.println(""+x1+" "+y1+" "+x2+" "+y2+" "+x3+" "+y3);
    	System.out.println("X Data\n"+x1+" "+y1+"\n"+x2+" "+y2+"\n"+x3+" "+y3+"\n");
        System.out.println("Z Data\n"+zx1+" "+zy1+"\n"+zx2+" "+zy2+"\n"+zx3+" "+zy3+"\n");
    	
    	double[] d =  {x1, y1,
                       x2, y2,
                       x3, y3,
                       x1, y1,
                       zx1, zy1,
         			   zx2, zy2,
         			   zx3, zy3,
         			   zx1, zy1};
       
        //double[] z = {};
        
        Frame f = new complexGraphDataTri(d);
        f.setVisible(true);
        
     
      
        }
}