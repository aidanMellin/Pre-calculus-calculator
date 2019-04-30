package out.newOutput.input;
import out.newOutput.data.complexGraphDataTri;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

public class complexTransTri {

	//create local private variables for use across functions
    private JFrame frame;
    private JPanel pane;
 
    private JTextField x1Input;
    private JTextField y1Input;
    private JTextField x2Input;
    private JTextField y2Input;
    private JTextField x3Input;
    private JTextField y3Input;
    private JTextField cisInput;
    private JTextField rotPtInx;
    private static JTextField rotPtIny;
    
    private double x1 = -1;
    private double y1 = -1;
    private double x2 = -1;
    private double y2 = -1;
    private double x3 = -1;
    private double y3 = -1;
    private double cis = -1;
    private static double rotPtx = -1;
    private static double rotPty = -1;
    


    public static void main(String[] args) {
    	//Easy Runnable window for multiple instances
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
           
                new complexTransTri().singleDialogInformation();
            }
        });
    }
    
    public void singleDialogInformation() {

    	
    	//Base pane with blank TextFields
        pane = new JPanel();
        pane.setLayout(new GridLayout(0, 4, 6, 0));

        
        x1Input = new JTextField(2);
        y1Input = new JTextField(2);
        x2Input = new JTextField(2);
        y2Input = new JTextField(2);
        x3Input = new JTextField(2);
        y3Input = new JTextField(2);
        cisInput = new JTextField(2);
        rotPtInx = new JTextField(2);
        rotPtIny = new JTextField(2);

        pane.add(new JLabel(" (x1,y1)"));
        pane.add(x1Input);
        //pane.add(new JLabel(","));
        pane.add(y1Input);
        pane.add(new JLabel(""));
        
        pane.add(new JLabel(" (x2,y2)"));
        pane.add(x2Input);
        //pane.add(new JLabel(","));
        pane.add(y2Input);
        pane.add(new JLabel(""));

        pane.add(new JLabel(" (x3,y3)"));
        pane.add(x3Input);
        //pane.add(new JLabel(","));
        pane.add(y3Input);
        pane.add(new JLabel(""));
        
        pane.add(new JLabel("Cis Theta = "));
        pane.add(cisInput);
        pane.add(new JLabel(""));
        pane.add(new JLabel(""));
        
        pane.add(new JLabel(" (X,Y Rot)"));
        pane.add(""+rotPtx,rotPtInx);
        //pane.add(new JLabel(","));
        pane.add(""+rotPty,rotPtIny);
        
        JToggleButton button3 = new JToggleButton("Origin");
     	pane.add(button3);
     	button3.addActionListener (new originPress());
	       
        //If the button pressed  = yes, move on to next section of code  
        int option = JOptionPane.showConfirmDialog(frame, pane, "Please fill all the fields", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        
        if (option == JOptionPane.YES_OPTION) {


        	String x1S = x1Input.getText();
        	String y1S = y1Input.getText();
        	String x2S = "";
        	String y2S = "";
        	String x3S = "";
        	String y3S = ""; 
        	
        	if (x2Input.getDocument().getLength() <= 0 && y2Input.getDocument().getLength() <= 0 && x3Input.getDocument().getLength() <= 0 && y3Input.getDocument().getLength() <= 0) {
        		
        		x2S = "0";
        		y2S = "0";
        		
        		x3S = "0";
        		y3S = "0";
        		
        		

        	} else if(x2Input.getDocument().getLength() > 0 && x3Input.getDocument().getLength() <= 0 && y3Input.getDocument().getLength() <= 0) {
        		x2S = x2Input.getText();
        		y2S = y2Input.getText();
        		x3S = x1S;
        		y3S = y1S;
     
        		System.out.println(x3S+","+y3S+" This Works");
        		
        	}
        	else {
        		System.out.println("Running Else CodeBlock");
        		x2S = x2Input.getText();
        		y2S = y2Input.getText();
        		x3S = x3Input.getText();
        		y3S = y3Input.getText();
        	}
        	
        	String cisS = cisInput.getText();
        	
        	String rotPtxS = "";
        	String rotPtyS = "";
        	
        	if (rotPtx != 0 && rotPtx != 0) {
        		rotPtxS = rotPtInx.getText();
        		rotPtyS = rotPtIny.getText();
	        	
        	} else {
        		rotPtxS = "0";
        		rotPtyS = "0";
        	}
        	
        	
        	
        	x1 = Double.parseDouble(x1S);
        	y1 = Double.parseDouble(y1S);
        	x2 = Double.parseDouble(x2S);
        	y2 = Double.parseDouble(y2S);
        	x3 = Double.parseDouble(x3S);
        	y3 = Double.parseDouble(y3S);
        	cis = Double.parseDouble(cisS);
        	rotPtx = Double.parseDouble(rotPtxS);
        	rotPty = Double.parseDouble(rotPtyS);
        
        	
        	System.out.println("Rotation Points: "+ rotPtx+","+rotPty);
        	
        	complexGraphDataTri.main(x1, y1, x2, y2, x3, y3, cis, rotPtx,rotPty);
        	
        	
        	}
    }
    static class originPress implements ActionListener { 
		
		//Filler Action button
		 public void actionPerformed (ActionEvent e) { 
		    rotPtx = 0;
		    rotPty = 0;
		    System.out.println("Rotation is now Origin");
		    //return true;
		  }
        
}
}