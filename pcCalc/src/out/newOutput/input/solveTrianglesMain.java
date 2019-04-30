package out.newOutput.input;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import out.newOutput.data.solveTrianglesData;



public class solveTrianglesMain {

	//create local private variables for use across functions
    private JFrame frame;
    private JPanel pane;
 
    private JTextField a1Input;
    private JTextField s1Input;
    private JTextField a2Input;
    private JTextField s2Input;
    private JTextField a3Input;
    private JTextField s3Input;
    
    private double a1Val = -1;
    private double s1Val = -1;
    private double a2Val = -1;
    private double s2Val = -1;
    private double a3Val = -1;
    private double s3Val = -1;
    private int BinSum = 0;

    public static void main(String[] args) {
    	//Easy Runnable window for multiple instances
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
           
                new solveTrianglesMain().singleDialogInformation();
            }
        });
    }

    public void singleDialogInformation() {
    	
    	//Base pane with blank TextFields
        pane = new JPanel();
        pane.setLayout(new GridLayout(0, 4, 5, 4));
       
        
        a1Input = new JTextField(5);
        s1Input = new JTextField(5);
        a2Input = new JTextField(5);
        s2Input = new JTextField(5);
        a3Input = new JTextField(5);
        s3Input = new JTextField(5);

        pane.add(new JLabel("Side A"));
        pane.add(s1Input);
        pane.add(new JLabel("Angle A"));
        pane.add(a1Input);
        
        pane.add(new JLabel("Side B"));
        pane.add(s2Input);
        pane.add(new JLabel("Angle B"));
        pane.add(a2Input);

        pane.add(new JLabel("Side C"));
        pane.add(s3Input);
        pane.add(new JLabel("Angle C"));
        pane.add(a3Input);
        
        //If the button pressed  = yes, move on to next section of code  
        int option = JOptionPane.showConfirmDialog(frame, pane, "Please fill all the fields", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {
        	
        	//Here I set all the possible values (S1,A1,S2,A2,S3,A3) to a binary value for ease of calling functions for solutions        	
        	if (s1Input.getDocument().getLength() >= 1) {
            	BinSum = BinSum + 1;
            	            }        	
        	if (a1Input.getDocument().getLength() >= 1) {
            	BinSum = BinSum + 2;

            }
        	if (s2Input.getDocument().getLength() >= 1) {
            	BinSum = BinSum + 4;

            }
            if (a2Input.getDocument().getLength() >= 1) {
            	BinSum = BinSum + 8;

            }
            if (s3Input.getDocument().getLength() >= 1) {
            	BinSum = BinSum + 16;

            }            
            if (a3Input.getDocument().getLength() >= 1) {
            	BinSum = BinSum + 32;

            }
            
            //Just a test to make sure the right Binary Sum is being called
            System.out.println(BinSum+" Bin Sum\n");
            
        	//I made an overarching If and then interior if statements for ease of organization so each individual case can be jumped to quickly
            //For all the cases (except for SSA, the idea is to export the input variables into the function needed, and then convert all values to double for viewing as a text field)
            //SSA will be explained later
        	if (BinSum == 11 || BinSum == 14 || BinSum == 35 || BinSum == 44 || BinSum == 50 || BinSum == 56) { //AAS Cases
	        		if (BinSum == 11) {
	        			String a1ValS = a1Input.getText();
	        			String a2ValS = a2Input.getText();
	        			String s1ValS = s1Input.getText();
	        			
	        			System.out.println(a1ValS);
	        			System.out.println(a2ValS);
	        			System.out.println(s1ValS);
	        			
	        			
	        			a1Val = Double.parseDouble(a1ValS);
	                	a2Val = Double.parseDouble(a2ValS);
	                	s1Val = Double.parseDouble(s1ValS);
	                	
	                	String answer = solveTrianglesData.AAS(a1Val, a2Val, s1Val);
	                	
	                	String [] temp;
	                	String delimiter = ",";
	                	temp = answer.split(delimiter);
	                	
	                	String s1 = temp[0];
	                	String a1 = temp[1];
	                	String s2 = temp[2];
	                	String a2 = temp[3];
	                	String s3 = temp[4];
	                	String a3 = temp[5];
	                	
	                	s1Val = Math.round(Double.parseDouble(s1)*1000.0)/1000.0;
    	            	a1Val = Math.round(Double.parseDouble(a1)*1000.0)/1000.0;
    	            	s2Val = Math.round(Double.parseDouble(s2)*1000.0)/1000.0;
    	            	a2Val = Math.round(Double.parseDouble(a2)*1000.0)/1000.0;
    	            	s3Val = Math.round(Double.parseDouble(s3)*1000.0)/1000.0;
    	            	a3Val = Math.round(Double.parseDouble(a3)*1000.0)/1000.0;
    	            	
    	            	s1 = Double.toString(s1Val);
    	            	a1 = Double.toString(a1Val);
    	            	s2 = Double.toString(s2Val);
    	            	a2 = Double.toString(a2Val);
    	            	s3 = Double.toString(s3Val);
    	            	a3 = Double.toString(a3Val);
	                	
    	            	if (solveTrianglesData.TriPossible(s1Val, s2Val, s3Val) == true) {
		                	System.out.println(answer);
		                	 
		                    pane = new JPanel();
		                    pane.setLayout(new GridLayout(0, 4, 5, 4));
		
		                    pane.add(new JLabel("Side A   "));
		                    pane.add(new JTextField(s1));
		                    pane.add(new JLabel("Angle A   "));
		                    pane.add(new JTextField(a1+"\n"));
		                    pane.add(new JLabel("Side B   "));
		                    pane.add(new JTextField(s2));
		                    pane.add(new JLabel("Angle B   "));
		                    pane.add(new JTextField(a2));
		                    pane.add(new JLabel("Side C   "));
		                    pane.add(new JTextField(s3));
		                    pane.add(new JLabel("Angle C   "));
		                    pane.add(new JTextField(a3));
		
		                    JOptionPane.showMessageDialog(frame, pane);
    	            	}
	       			} else if (BinSum == 14) {
		        		String a2ValS = a2Input.getText();
	        			String a1ValS = a1Input.getText();
	        			String s2ValS = s2Input.getText();
	        			
	        			System.out.println(a2ValS);
	        			System.out.println(a1ValS);
	        			System.out.println(s2ValS);
	        			
	        			
	        			a2Val = Double.parseDouble(a2ValS);
	                	a1Val = Double.parseDouble(a1ValS);
	                	s2Val = Double.parseDouble(s2ValS);
	                	
	                	String answer = solveTrianglesData.AAS(a2Val, a1Val, s2Val);
	                	
	                	String [] temp;
	                	String delimiter = ",";
	                	temp = answer.split(delimiter);
	                	
	                	String s1 = temp[2];
	                	String a1 = temp[3];
	                	String s2 = temp[0];
	                	String a2 = temp[1];
	                	String s3 = temp[4];
	                	String a3 = temp[5];
	                	
	                	s1Val = Math.round(Double.parseDouble(s1)*1000.0)/1000.0;
    	            	a1Val = Math.round(Double.parseDouble(a1)*1000.0)/1000.0;
    	            	s2Val = Math.round(Double.parseDouble(s2)*1000.0)/1000.0;
    	            	a2Val = Math.round(Double.parseDouble(a2)*1000.0)/1000.0;
    	            	s3Val = Math.round(Double.parseDouble(s3)*1000.0)/1000.0;
    	            	a3Val = Math.round(Double.parseDouble(a3)*1000.0)/1000.0;
    	            	
    	            	s1 = Double.toString(s1Val);
    	            	a1 = Double.toString(a1Val);
    	            	s2 = Double.toString(s2Val);
    	            	a2 = Double.toString(a2Val);
    	            	s3 = Double.toString(s3Val);
    	            	a3 = Double.toString(a3Val);
	                	
    	            	if (solveTrianglesData.TriPossible(s1Val, s2Val, s3Val) == true) {
		                	System.out.println(answer);
		                	 
		                    pane = new JPanel();
		                    pane.setLayout(new GridLayout(0, 4, 5, 4));
		
		                    pane.add(new JLabel("Side A   "));
		                    pane.add(new JTextField(s1));
		                    pane.add(new JLabel("Angle A   "));
		                    pane.add(new JTextField(a1+"\n"));
		                    pane.add(new JLabel("Side B   "));
		                    pane.add(new JTextField(s2));
		                    pane.add(new JLabel("Angle B   "));
		                    pane.add(new JTextField(a2));
		                    pane.add(new JLabel("Side C   "));
		                    pane.add(new JTextField(s3));
		                    pane.add(new JLabel("Angle C   "));
		                    pane.add(new JTextField(a3));
		
		                    JOptionPane.showMessageDialog(frame, pane); 
    	            	}
	       			} else if (BinSum == 35) {
		        		String a1ValS = a1Input.getText();
	        			String a3ValS = a3Input.getText();
	        			String s1ValS = s1Input.getText();
	        			
	        			System.out.println(a1ValS);
	        			System.out.println(a3ValS);
	        			System.out.println(s1ValS);
	        			
	        			
	        			a1Val = Double.parseDouble(a1ValS);
	                	a3Val = Double.parseDouble(a3ValS);
	                	s1Val = Double.parseDouble(s1ValS);
	                	
	                	String answer = solveTrianglesData.AAS(a1Val, a3Val, s1Val);
	                	
	                	String [] temp;
	                	String delimiter = ",";
	                	temp = answer.split(delimiter);
	                	
	                	String s1 = temp[0];
	                	String a1 = temp[1];
	                	String s2 = temp[4];
	                	String a2 = temp[5];
	                	String s3 = temp[2];
	                	String a3 = temp[3];
	                	
	                	s1Val = Math.round(Double.parseDouble(s1)*1000.0)/1000.0;
    	            	a1Val = Math.round(Double.parseDouble(a1)*1000.0)/1000.0;
    	            	s2Val = Math.round(Double.parseDouble(s2)*1000.0)/1000.0;
    	            	a2Val = Math.round(Double.parseDouble(a2)*1000.0)/1000.0;
    	            	s3Val = Math.round(Double.parseDouble(s3)*1000.0)/1000.0;
    	            	a3Val = Math.round(Double.parseDouble(a3)*1000.0)/1000.0;
    	            	
    	            	s1 = Double.toString(s1Val);
    	            	a1 = Double.toString(a1Val);
    	            	s2 = Double.toString(s2Val);
    	            	a2 = Double.toString(a2Val);
    	            	s3 = Double.toString(s3Val);
    	            	a3 = Double.toString(a3Val);
	                	
    	            	if (solveTrianglesData.TriPossible(s1Val, s2Val, s3Val) == true) {	
		                	System.out.println(answer);
		                	 
		                    pane = new JPanel();
		                    pane.setLayout(new GridLayout(0, 4, 5, 4));
		
		                    pane.add(new JLabel("Side A   "));
		                    pane.add(new JTextField(s1));
		                    pane.add(new JLabel("Angle A   "));
		                    pane.add(new JTextField(a1+"\n"));
		                    pane.add(new JLabel("Side B   "));
		                    pane.add(new JTextField(s2));
		                    pane.add(new JLabel("Angle B   "));
		                    pane.add(new JTextField(a2));
		                    pane.add(new JLabel("Side C   "));
		                    pane.add(new JTextField(s3));
		                    pane.add(new JLabel("Angle C   "));
		                    pane.add(new JTextField(a3));
		
		                    JOptionPane.showMessageDialog(frame, pane); 
    	            	}
	       			} else if (BinSum == 44) {
	       				
	       				String a2ValS = a2Input.getText();
	        			String a3ValS = a3Input.getText();
	        			String s2ValS = s2Input.getText();        			
	        			
	        			a2Val =  Double.parseDouble(a2ValS);
	                	a3Val =  Double.parseDouble(a3ValS);
	                	s2Val =  Double.parseDouble(s2ValS);
	                	
	                	String answer = solveTrianglesData.AAS(a2Val, a3Val, s2Val);
	                	
	                	String [] temp;
	                	String delimiter = ",";
	                	temp = answer.split(delimiter);
	                	
	                	String s1 = temp[4];
	                	String a1 = temp[5];
	                	String s2 = temp[0];
	                	String a2 = temp[1];
	                	String s3 = temp[2];
	                	String a3 = temp[3];
	                	
	                	s1Val = Math.round(Double.parseDouble(s1)*1000.0)/1000.0;
    	            	a1Val = Math.round(Double.parseDouble(a1)*1000.0)/1000.0;
    	            	s2Val = Math.round(Double.parseDouble(s2)*1000.0)/1000.0;
    	            	a2Val = Math.round(Double.parseDouble(a2)*1000.0)/1000.0;
    	            	s3Val = Math.round(Double.parseDouble(s3)*1000.0)/1000.0;
    	            	a3Val = Math.round(Double.parseDouble(a3)*1000.0)/1000.0;
    	            	
    	            	s1 = Double.toString(s1Val);
    	            	a1 = Double.toString(a1Val);
    	            	s2 = Double.toString(s2Val);
    	            	a2 = Double.toString(a2Val);
    	            	s3 = Double.toString(s3Val);
    	            	a3 = Double.toString(a3Val);
    	            	
    	            	if (solveTrianglesData.TriPossible(s1Val, s2Val, s3Val) == true) {
		                	System.out.println(answer);
		                	 
		                    pane = new JPanel();
		                    pane.setLayout(new GridLayout(0, 4, 5, 4));
		
		                    pane.add(new JLabel("Side A   "));
		                    pane.add(new JTextField(s1));
		                    pane.add(new JLabel("Angle A   "));
		                    pane.add(new JTextField(a1+"\n"));
		                    pane.add(new JLabel("Side B   "));
		                    pane.add(new JTextField(s2));
		                    pane.add(new JLabel("Angle B   "));
		                    pane.add(new JTextField(a2));
		                    pane.add(new JLabel("Side C   "));
		                    pane.add(new JTextField(s3));
		                    pane.add(new JLabel("Angle C   "));
		                    pane.add(new JTextField(a3));
		
		                    JOptionPane.showMessageDialog(frame, pane);
    	            	}
	       			} else if (BinSum == 50) {
	       				
	       				String a3ValS = a3Input.getText();
	        			String a1ValS = a1Input.getText();
	        			String s3ValS = s3Input.getText();        			
	        			
	        			a3Val = Double.parseDouble(a3ValS);
	                	a1Val = Double.parseDouble(a1ValS);
	                	s3Val = Double.parseDouble(s3ValS);
	                	
	                	String answer = solveTrianglesData.AAS(a3Val, a1Val, s3Val);
	                	
	                	String [] temp;
	                	String delimiter = ",";
	                	temp = answer.split(delimiter);
	                	
	                	String s1 = temp[2];
	                	String a1 = temp[3];
	                	String s2 = temp[4];
	                	String a2 = temp[5];
	                	String s3 = temp[0];
	                	String a3 = temp[1];
	                	
	                	s1Val = Math.round(Double.parseDouble(s1)*1000.0)/1000.0;
    	            	a1Val = Math.round(Double.parseDouble(a1)*1000.0)/1000.0;
    	            	s2Val = Math.round(Double.parseDouble(s2)*1000.0)/1000.0;
    	            	a2Val = Math.round(Double.parseDouble(a2)*1000.0)/1000.0;
    	            	s3Val = Math.round(Double.parseDouble(s3)*1000.0)/1000.0;
    	            	a3Val = Math.round(Double.parseDouble(a3)*1000.0)/1000.0;
    	            	
    	            	s1 = Double.toString(s1Val);
    	            	a1 = Double.toString(a1Val);
    	            	s2 = Double.toString(s2Val);
    	            	a2 = Double.toString(a2Val);
    	            	s3 = Double.toString(s3Val);
    	            	a3 = Double.toString(a3Val);
	                	
    	            	if (solveTrianglesData.TriPossible(s1Val, s2Val, s3Val) == true) {
    	            		System.out.println(answer);
		                	 
		                    pane = new JPanel();
		                    pane.setLayout(new GridLayout(0, 4, 5, 4));
		
		                    pane.add(new JLabel("Side A   "));
		                    pane.add(new JTextField(s1));
		                    pane.add(new JLabel("Angle A   "));
		                    pane.add(new JTextField(a1+"\n"));
		                    pane.add(new JLabel("Side B   "));
		                    pane.add(new JTextField(s2));
		                    pane.add(new JLabel("Angle B   "));
		                    pane.add(new JTextField(a2));
		                    pane.add(new JLabel("Side C   "));
		                    pane.add(new JTextField(s3));
		                    pane.add(new JLabel("Angle C   "));
		                    pane.add(new JTextField(a3));
		
		                    JOptionPane.showMessageDialog(frame, pane);
    	            	}
	       			} else if (BinSum == 56) {
		        		String a3ValS = a3Input.getText();
	        			String a2ValS = a2Input.getText();
	        			String s3ValS = s3Input.getText();
	        			
	        			
	        			a3Val = Double.parseDouble(a3ValS);
	                	a2Val = Double.parseDouble(a2ValS);
	                	s3Val = Double.parseDouble(s3ValS);
	                	System.out.println(a3Val);
	        			System.out.println(a2Val);
	        			System.out.println(s3Val);
	                	
	                	String answer = solveTrianglesData.AAS(a3Val, a2Val, s3Val);
	                	
	                	String [] temp;
	                	String delimiter = ",";
	                	temp = answer.split(delimiter);
	                	
	                	String s1 = temp[4];
	                	String a1 = temp[5];
	                	String s2 = temp[2];
	                	String a2 = temp[3];
	                	String s3 = temp[0];
	                	String a3 = temp[1];
	                	
	                	s1Val = Math.round(Double.parseDouble(s1)*1000.0)/1000.0;
    	            	a1Val = Math.round(Double.parseDouble(a1)*1000.0)/1000.0;
    	            	s2Val = Math.round(Double.parseDouble(s2)*1000.0)/1000.0;
    	            	a2Val = Math.round(Double.parseDouble(a2)*1000.0)/1000.0;
    	            	s3Val = Math.round(Double.parseDouble(s3)*1000.0)/1000.0;
    	            	a3Val = Math.round(Double.parseDouble(a3)*1000.0)/1000.0;
    	            	
    	            	s1 = Double.toString(s1Val);
    	            	a1 = Double.toString(a1Val);
    	            	s2 = Double.toString(s2Val);
    	            	a2 = Double.toString(a2Val);
    	            	s3 = Double.toString(s3Val);
    	            	a3 = Double.toString(a3Val);
	                	
    	            	if (solveTrianglesData.TriPossible(s1Val, s2Val, s3Val) == true) {
		                	System.out.println(answer);
		                	 
		                    pane = new JPanel();
		                    pane.setLayout(new GridLayout(0, 4, 5, 4));
		
		                    pane.add(new JLabel("Side A   "));
		                    pane.add(new JTextField(s1));
		                    pane.add(new JLabel("Angle A   "));
		                    pane.add(new JTextField(a1+"\n"));
		                    pane.add(new JLabel("Side B   "));
		                    pane.add(new JTextField(s2));
		                    pane.add(new JLabel("Angle B   "));
		                    pane.add(new JTextField(a2));
		                    pane.add(new JLabel("Side C   "));
		                    pane.add(new JTextField(s3));
		                    pane.add(new JLabel("Angle C   "));
		                    pane.add(new JTextField(a3));
		
		                    JOptionPane.showMessageDialog(frame, pane); 
    	            	} else {
		            		JOptionPane.showMessageDialog(frame, "This triangle is not possible" + answer);
		            	}
	       			}
       		}if (BinSum == 21) { //SSS Case

		   				String s1ValS = s1Input.getText();
		    			String s2ValS = s2Input.getText();
		    			String s3ValS = s3Input.getText();        			
		    			
		    			s1Val = Double.parseDouble(s1ValS);
		            	s2Val = Double.parseDouble(s2ValS);
		            	s3Val = Double.parseDouble(s3ValS);
		            	
		            	String answer = solveTrianglesData.SSS(s1Val, s2Val, s3Val);
		            	
		            	
		            		
		            		String [] temp;
			            	String delimiter = ",";
			            	temp = answer.split(delimiter);
			            	
			            	String s1 = temp[0];
			            	String a1 = temp[1];
			            	String s2 = temp[2];
			            	String a2 = temp[3];
			            	String s3 = temp[4];
			            	String a3 = temp[5];
			            	
			            	s1Val = Math.round(Double.parseDouble(s1)*1000.0)/1000.0;
	    	            	a1Val = Math.round(Double.parseDouble(a1)*1000.0)/1000.0;
	    	            	s2Val = Math.round(Double.parseDouble(s2)*1000.0)/1000.0;
	    	            	a2Val = Math.round(Double.parseDouble(a2)*1000.0)/1000.0;
	    	            	s3Val = Math.round(Double.parseDouble(s3)*1000.0)/1000.0;
	    	            	a3Val = Math.round(Double.parseDouble(a3)*1000.0)/1000.0;
	    	            	
	    	            	s1 = Double.toString(s1Val);
	    	            	a1 = Double.toString(a1Val);
	    	            	s2 = Double.toString(s2Val);
	    	            	a2 = Double.toString(a2Val);
	    	            	s3 = Double.toString(s3Val);
	    	            	a3 = Double.toString(a3Val);
			            	
			            if (solveTrianglesData.TriPossible(s1Val, s2Val, s3Val) == true) {
			            	System.out.println(answer);
			            	 
			                pane = new JPanel();
			                pane.setLayout(new GridLayout(0, 4, 5, 4));
			
			                pane.add(new JLabel("Side A   "));
			                pane.add(new JTextField(s1));
			                pane.add(new JLabel("Angle A   "));
			                pane.add(new JTextField(a1+"\n"));
			                pane.add(new JLabel("Side B   "));
			                pane.add(new JTextField(s2));
			                pane.add(new JLabel("Angle B   "));
			                pane.add(new JTextField(a2));
			                pane.add(new JLabel("Side C   "));
			                pane.add(new JTextField(s3));
			                pane.add(new JLabel("Angle C   "));
			                pane.add(new JTextField(a3));
			
			                JOptionPane.showMessageDialog(frame, pane);
		            	} else {
		            		JOptionPane.showMessageDialog(frame, "This triangle is not possible");
		            	}
			            	
	       			
       				} 
       		if (BinSum == 22 || BinSum == 25 || BinSum == 37){ //SAS Cases
       				if (BinSum == 22) {
       					String s2ValS = s2Input.getText();
    	    			String a1ValS = a1Input.getText();
    	    			String s3ValS = s3Input.getText();        			
    	    			
    	    			s2Val = Double.parseDouble(s2ValS);
    	            	a1Val = Double.parseDouble(a1ValS);
    	            	s3Val = Double.parseDouble(s3ValS);
    	            	
    	            	String answer = solveTrianglesData.SAS(s2Val, a1Val, s3Val);
    	            	
    	            	String [] temp;
    	            	String delimiter = ",";
    	            	temp = answer.split(delimiter);
    	            	
    	            	String s1 = temp[0];
    	            	String a1 = temp[1];
    	            	String s2 = temp[2];
    	            	String a2 = temp[3];
    	            	String s3 = temp[4];
    	            	String a3 = temp[5];
    	            	
    	            	s1Val = Math.round(Double.parseDouble(s1)*1000.0)/1000.0;
    	            	a1Val = Math.round(Double.parseDouble(a1)*1000.0)/1000.0;
    	            	s2Val = Math.round(Double.parseDouble(s2)*1000.0)/1000.0;
    	            	a2Val = Math.round(Double.parseDouble(a2)*1000.0)/1000.0;
    	            	s3Val = Math.round(Double.parseDouble(s3)*1000.0)/1000.0;
    	            	a3Val = Math.round(Double.parseDouble(a3)*1000.0)/1000.0;
    	            	
    	            	s1 = Double.toString(s1Val);
    	            	a1 = Double.toString(a1Val);
    	            	s2 = Double.toString(s2Val);
    	            	a2 = Double.toString(a2Val);
    	            	s3 = Double.toString(s3Val);
    	            	a3 = Double.toString(a3Val);
    	            	
    	            	if (solveTrianglesData.TriPossible(s1Val, s2Val, s3Val) == true) {
			            	System.out.println(answer);
			            	 
			                pane = new JPanel();
			                pane.setLayout(new GridLayout(0, 4, 5, 4));
			
			                pane.add(new JLabel("Side A   "));
			                pane.add(new JTextField(s1));
			                pane.add(new JLabel("Angle A   "));
			                pane.add(new JTextField(a1+"\n"));
			                pane.add(new JLabel("Side B   "));
			                pane.add(new JTextField(s2));
			                pane.add(new JLabel("Angle B   "));
			                pane.add(new JTextField(a2));
			                pane.add(new JLabel("Side C   "));
			                pane.add(new JTextField(s3));
			                pane.add(new JLabel("Angle C   "));
			                pane.add(new JTextField(a3));
			
			                JOptionPane.showMessageDialog(frame, pane);
		            	} else {
		            		JOptionPane.showMessageDialog(frame, "This triangle is not possible");
		            	}
       					
       				} else if (BinSum == 25) {
       					
       					String s3ValS = s3Input.getText();
    	    			String a2ValS = a2Input.getText();
    	    			String s1ValS = s1Input.getText();        			
    	    			
    	    			s3Val = Double.parseDouble(s3ValS);
    	            	a2Val = Double.parseDouble(a2ValS);
    	            	s1Val = Double.parseDouble(s1ValS);
    	            	
    	            	String answer = solveTrianglesData.SAS(s3Val, a2Val, s1Val);
    	            	
    	            	String [] temp;
    	            	String delimiter = ",";
    	            	temp = answer.split(delimiter);
    	            	
    	            	String s1 = temp[4];
    	            	String a1 = temp[5];
    	            	String s2 = temp[0];
    	            	String a2 = temp[1];
    	            	String s3 = temp[2];
    	            	String a3 = temp[3];
    	            	
    	            	s1Val = Math.round(Double.parseDouble(s1)*1000.0)/1000.0;
    	            	a1Val = Math.round(Double.parseDouble(a1)*1000.0)/1000.0;
    	            	s2Val = Math.round(Double.parseDouble(s2)*1000.0)/1000.0;
    	            	a2Val = Math.round(Double.parseDouble(a2)*1000.0)/1000.0;
    	            	s3Val = Math.round(Double.parseDouble(s3)*1000.0)/1000.0;
    	            	a3Val = Math.round(Double.parseDouble(a3)*1000.0)/1000.0;
    	            	
    	            	s1 = Double.toString(s1Val);
    	            	a1 = Double.toString(a1Val);
    	            	s2 = Double.toString(s2Val);
    	            	a2 = Double.toString(a2Val);
    	            	s3 = Double.toString(s3Val);
    	            	a3 = Double.toString(a3Val);
    	            	
    	            	if (solveTrianglesData.TriPossible(s1Val, s2Val, s3Val) == true) {
			            	System.out.println(answer);
			            	 
			                pane = new JPanel();
			                pane.setLayout(new GridLayout(0, 4, 5, 4));
			
			                pane.add(new JLabel("Side A   "));
			                pane.add(new JTextField(s1));
			                pane.add(new JLabel("Angle A   "));
			                pane.add(new JTextField(a1+"\n"));
			                pane.add(new JLabel("Side B   "));
			                pane.add(new JTextField(s2));
			                pane.add(new JLabel("Angle B   "));
			                pane.add(new JTextField(a2));
			                pane.add(new JLabel("Side C   "));
			                pane.add(new JTextField(s3));
			                pane.add(new JLabel("Angle C   "));
			                pane.add(new JTextField(a3));
			
			                JOptionPane.showMessageDialog(frame, pane);
		            	} else {
		            		JOptionPane.showMessageDialog(frame, "This triangle is not possible");
		            	}
       				} else if (BinSum == 37) {
       					String s1ValS = s1Input.getText();
    	    			String a3ValS = a3Input.getText();
    	    			String s2ValS = s2Input.getText();        			
    	    			
    	    			s1Val = Double.parseDouble(s1ValS);
    	            	a3Val = Double.parseDouble(a3ValS);
    	            	s2Val = Double.parseDouble(s2ValS);
    	            	
    	            	String answer = solveTrianglesData.SAS(s1Val, a3Val, s2Val);
    	            	
    	            	String [] temp;
    	            	String delimiter = ",";
    	            	temp = answer.split(delimiter);
    	            	
    	            	String s1 = temp[2];
    	            	String a1 = temp[3];
    	            	String s2 = temp[4];
    	            	String a2 = temp[5];
    	            	String s3 = temp[0];
    	            	String a3 = temp[1];
    	            	
    	            	s1Val = Math.round(Double.parseDouble(s1)*1000.0)/1000.0;
    	            	a1Val = Math.round(Double.parseDouble(a1)*1000.0)/1000.0;
    	            	s2Val = Math.round(Double.parseDouble(s2)*1000.0)/1000.0;
    	            	a2Val = Math.round(Double.parseDouble(a2)*1000.0)/1000.0;
    	            	s3Val = Math.round(Double.parseDouble(s3)*1000.0)/1000.0;
    	            	a3Val = Math.round(Double.parseDouble(a3)*1000.0)/1000.0;
    	            	
    	            	s1 = Double.toString(s1Val);
    	            	a1 = Double.toString(a1Val);
    	            	s2 = Double.toString(s2Val);
    	            	a2 = Double.toString(a2Val);
    	            	s3 = Double.toString(s3Val);
    	            	a3 = Double.toString(a3Val);
    	            	
    	            	if (solveTrianglesData.TriPossible(s1Val, s2Val, s3Val) == true) {
			            	System.out.println(answer);
			            	 
			                pane = new JPanel();
			                pane.setLayout(new GridLayout(0, 4, 5, 4));
			
			                pane.add(new JLabel("Side A   "));
			                pane.add(new JTextField(s1));
			                pane.add(new JLabel("Angle A   "));
			                pane.add(new JTextField(a1+"\n"));
			                pane.add(new JLabel("Side B   "));
			                pane.add(new JTextField(s2));
			                pane.add(new JLabel("Angle B   "));
			                pane.add(new JTextField(a2));
			                pane.add(new JLabel("Side C   "));
			                pane.add(new JTextField(s3));
			                pane.add(new JLabel("Angle C   "));
			                pane.add(new JTextField(a3));
			
			                JOptionPane.showMessageDialog(frame, pane);
		            	} else {
		            		JOptionPane.showMessageDialog(frame, "This triangle is not possible");
		            	}
       				}
       			} 
       		
       		//SSA is kind of a pain because it might have two possible triangles, but there is no easy way with the way I had set up to
       		//just display the two in separate panes, so the values that could have two values were solved for and then changed to strings
       		//After that I split the string by the " " that I put between the values, reassigned them with an OR in the middle and placed them for output
       		// PSA the NewPos string is the __ OR __ values for reassignment
       		if (BinSum == 7 || BinSum == 13 || BinSum == 19 || BinSum == 28 || BinSum == 49 || BinSum == 52) { //SSA Cases
       				if (BinSum == 7) {
       					
       					String s1ValS = s1Input.getText();
    	    			String s2ValS = s2Input.getText();
    	    			String a1ValS = a1Input.getText();        			
    	    			
    	    			s1Val = Double.parseDouble(s1ValS);
    	            	s2Val = Double.parseDouble(s2ValS);
    	            	a1Val = Double.parseDouble(a1ValS);
    	            	
    	            	String answer = solveTrianglesData.SSA(s1Val, s2Val, a1Val);
    	            	
    	            	String [] temp;
    	            	String delimiter = ",";
    	            	temp = answer.split(delimiter);
    	            	
    	            	String s1 = temp[0];
    	            	String a1 = temp[1];
    	            	String s2 = temp[2];
    	            	String a2 = temp[3];
    	            	String s3 = temp[4];
    	            	String a3 = temp[5];
    	            	
    	            	String newPos = (a2+" "+s3+" "+a3);
    	            	
    	            	s1Val = Math.round(Double.parseDouble(s1)*1000.0)/1000.0;
    	            	a1Val = Math.round(Double.parseDouble(a1)*1000.0)/1000.0;
    	            	s2Val = Math.round(Double.parseDouble(s2)*1000.0)/1000.0;
    	            	
    	            	s1 = Double.toString(s1Val);
    	            	a1 = Double.toString(a1Val);
    	            	s2 = Double.toString(s2Val);
    	            	
    	            	String [] tempNew;
    	            	tempNew = newPos.split(delimiter);
    	            	tempNew = newPos.split(" ");
    	            	System.out.println("TempNew = "+tempNew[0]+" "+tempNew[1]+" "+tempNew[2]+" "+tempNew[3]+" "+tempNew[4]+" "+tempNew[5]);
    	            	
    	            	Double a2Val0 = Double.parseDouble(tempNew[0]);
    	            	Double a2Val1 = Double.parseDouble(tempNew[1]);
    	            	Double s3Val0 = Double.parseDouble(tempNew[2]);
    	            	Double s3Val1 = Double.parseDouble(tempNew[3]);
    	            	Double a3Val0= Double.parseDouble(tempNew[4]);
    	            	Double a3Val1= Double.parseDouble(tempNew[5]);
    	            	
    	            	a2 = a2Val0+" OR "+a2Val1;
    	            	s3 = s3Val0+" OR "+s3Val1;
    	            	a3 = a3Val0+" OR "+a3Val1;
    	            	
    	            	if (solveTrianglesData.TriPossible(s1Val, s2Val, s3Val0) == true) {
			            	System.out.println(answer);
			            	 
			                pane = new JPanel();
			                pane.setLayout(new GridLayout(0, 4, 5, 4));
			
			                pane.add(new JLabel("Side A   "));
			                pane.add(new JTextField(s1));
			                pane.add(new JLabel("Angle A   "));
			                pane.add(new JTextField(a1+"\n"));
			                pane.add(new JLabel("Side B   "));
			                pane.add(new JTextField(s2));
			                pane.add(new JLabel("Angle B   "));
			                pane.add(new JTextField(a2));
			                pane.add(new JLabel("Side C   "));
			                pane.add(new JTextField(s3));
			                pane.add(new JLabel("Angle C   "));
			                pane.add(new JTextField(a3));
			
			                JOptionPane.showMessageDialog(frame, pane);
		            	} else {
		            		JOptionPane.showMessageDialog(frame, "This triangle is not possible");
		            	}
       				} else if (BinSum == 13) {
       					
       					String s2ValS = s2Input.getText();
    	    			String s1ValS = s1Input.getText();
    	    			String a2ValS = a2Input.getText();        			
    	    			
    	    			s2Val = Double.parseDouble(s2ValS);
    	            	s1Val = Double.parseDouble(s1ValS);
    	            	a2Val = Double.parseDouble(a2ValS);
    	            	
    	            	String answer = solveTrianglesData.SSA(s2Val, s1Val, a2Val);
    	            	
    	            	String [] temp;
    	            	String delimiter = ",";
    	            	temp = answer.split(delimiter);
    	            	
    	            	String s1 = temp[2];
    	            	String a1 = temp[3];
    	            	String s2 = temp[0];
    	            	String a2 = temp[1];
    	            	String s3 = temp[4];
    	            	String a3 = temp[5];
    	            	
    	            	String newPos = (a1+" "+s3+" "+a3);
    	            	
    	            	s1Val = Math.round(Double.parseDouble(s1)*1000.0)/1000.0;
    	            	s2Val = Math.round(Double.parseDouble(s2)*1000.0)/1000.0;
    	            	a2Val = Math.round(Double.parseDouble(a2)*1000.0)/1000.0;
    	            	
    	            	s1 = Double.toString(s1Val);
    	            	s2 = Double.toString(s2Val);
    	            	a2 = Double.toString(a2Val);

    	            	String [] tempNew;
    	            	tempNew = newPos.split(delimiter);
    	            	tempNew = newPos.split(" ");
    	            	System.out.println("TempNew = "+tempNew[0]);
    	            	
    	            	Double a1Val0 = Double.parseDouble(tempNew[0]);
    	            	Double a1Val1 = Double.parseDouble(tempNew[1]);
    	            	Double s3Val0 = Double.parseDouble(tempNew[2]);
    	            	Double s3Val1 = Double.parseDouble(tempNew[3]);
    	            	Double a3Val0= Double.parseDouble(tempNew[4]);
    	            	Double a3Val1= Double.parseDouble(tempNew[5]);

    	            	a1 = a1Val0+" OR "+a1Val1;
    	            	s3 = s3Val0+" OR "+s3Val1;
    	            	a3 = a3Val0+" OR "+a3Val1;

    	            	
    	            	if (solveTrianglesData.TriPossible(s1Val, s2Val, s3Val0) == true) {
			            	System.out.println(answer);
			            	 
			                pane = new JPanel();
			                pane.setLayout(new GridLayout(0, 4, 5, 4));
			
			                pane.add(new JLabel("Side A   "));
			                pane.add(new JTextField(s1));
			                pane.add(new JLabel("Angle A   "));
			                pane.add(new JTextField(a1+"\n"));
			                pane.add(new JLabel("Side B   "));
			                pane.add(new JTextField(s2));
			                pane.add(new JLabel("Angle B   "));
			                pane.add(new JTextField(a2));
			                pane.add(new JLabel("Side C   "));
			                pane.add(new JTextField(s3));
			                pane.add(new JLabel("Angle C   "));
			                pane.add(new JTextField(a3));
			
			                JOptionPane.showMessageDialog(frame, pane);
		            	} else {
		            		JOptionPane.showMessageDialog(frame, "This triangle is not possible");
		            	}
       					
       				} else if (BinSum == 19) {
       					
       					String s1ValS = s1Input.getText();
    	    			String s3ValS = s3Input.getText();
    	    			String a1ValS = a1Input.getText();        			
    	    			
    	    			s1Val = Double.parseDouble(s1ValS);
    	            	s3Val = Double.parseDouble(s3ValS);
    	            	a1Val = Double.parseDouble(a1ValS);
    	            	
    	            	String answer = solveTrianglesData.SSA(s1Val, s3Val, a1Val);
    	            	
    	            	String [] temp;
    	            	String delimiter = ",";
    	            	temp = answer.split(delimiter);
    	            	
    	            	String s1 = temp[0];
    	            	String a1 = temp[1];
    	            	String s2 = temp[4];
    	            	String a2 = temp[5];
    	            	String s3 = temp[2];
    	            	String a3 = temp[3];
    	            	
    	            	String newPos = (s2+" "+a2+" "+a3);
    	            	
    	            	s1Val = Math.round(Double.parseDouble(s1)*1000.0)/1000.0;
    	            	a1Val = Math.round(Double.parseDouble(a1)*1000.0)/1000.0;
    	            	s3Val = Math.round(Double.parseDouble(s3)*1000.0)/1000.0;
    	            	
    	            	s1 = Double.toString(s1Val);
    	            	a1 = Double.toString(a1Val);
    	            	s3 = Double.toString(s3Val);
    	            	
    	            	String [] tempNew;
    	            	tempNew = newPos.split(delimiter);
    	            	tempNew = newPos.split(" ");
    	            	System.out.println("TempNew = "+tempNew[0]);

    	            	Double s2Val0 = Double.parseDouble(tempNew[0]);
    	            	Double s2Val1 = Double.parseDouble(tempNew[1]);
    	            	Double a2Val0 = Double.parseDouble(tempNew[2]);
    	            	Double a2Val1 = Double.parseDouble(tempNew[3]);
    	            	Double a3Val0= Double.parseDouble(tempNew[4]);
    	            	Double a3Val1= Double.parseDouble(tempNew[5]);

    	            	s2 = s2Val0+" OR "+s2Val1;
    	            	a2 = a2Val0+" OR "+a2Val1;
    	            	a3 = a3Val0+" OR "+a3Val1;
    	            	
    	            	System.out.println(answer);
    	            	
    	            	if (solveTrianglesData.TriPossible(s1Val, s2Val0, s3Val) == true) {
			            	System.out.println(answer);
			            	 
			                pane = new JPanel();
			                pane.setLayout(new GridLayout(0, 4, 5, 4));
			
			                pane.add(new JLabel("Side A   "));
			                pane.add(new JTextField(s1));
			                pane.add(new JLabel("Angle A   "));
			                pane.add(new JTextField(a1+"\n"));
			                pane.add(new JLabel("Side B   "));
			                pane.add(new JTextField(s2));
			                pane.add(new JLabel("Angle B   "));
			                pane.add(new JTextField(a2));
			                pane.add(new JLabel("Side C   "));
			                pane.add(new JTextField(s3));
			                pane.add(new JLabel("Angle C   "));
			                pane.add(new JTextField(a3));
			
			                JOptionPane.showMessageDialog(frame, pane);
		            	} else {
		            		JOptionPane.showMessageDialog(frame, "This triangle is not possible");
		            	}
       				} else if (BinSum == 28) {
       					
       					String s2ValS = s2Input.getText();
    	    			String s3ValS = s3Input.getText();
    	    			String a2ValS = a2Input.getText();        			
    	    			
    	    			s2Val = Double.parseDouble(s2ValS);
    	            	s3Val = Double.parseDouble(s3ValS);
    	            	a2Val = Double.parseDouble(a2ValS);
    	            	
    	            	String answer = solveTrianglesData.SSA(s2Val, s3Val, a2Val);
    	            	
    	            	String [] temp;
    	            	String delimiter = ",";
    	            	temp = answer.split(delimiter);
    	            	
    	            	String s1 = temp[4];
    	            	String a1 = temp[5];
    	            	String s2 = temp[0];
    	            	String a2 = temp[1];
    	            	String s3 = temp[2];
    	            	String a3 = temp[3];
    	            	
    	            	String newPos = (s1+" "+a1+" "+a3);
    	            	
    	            	s2Val = Math.round(Double.parseDouble(s2)*1000.0)/1000.0;
    	            	a2Val = Math.round(Double.parseDouble(a2)*1000.0)/1000.0;
    	            	s3Val = Math.round(Double.parseDouble(s3)*1000.0)/1000.0;
    	            	
    	            	s2 = Double.toString(s2Val);
    	            	a2 = Double.toString(a2Val);
    	            	s3 = Double.toString(s3Val);
    	            	
    	            	String [] tempNew;
    	            	tempNew = newPos.split(delimiter);
    	            	tempNew = newPos.split(" ");
    	            	System.out.println("TempNew = "+tempNew[0]);
    	            	
    	            	Double s1Val0 = Double.parseDouble(tempNew[0]);
    	            	Double s1Val1 = Double.parseDouble(tempNew[1]);
    	            	Double a1Val0 = Double.parseDouble(tempNew[2]);
    	            	Double a1Val1 = Double.parseDouble(tempNew[3]);
    	            	Double a3Val0= Double.parseDouble(tempNew[4]);
    	            	Double a3Val1= Double.parseDouble(tempNew[5]);
    	            	
    	            	s1 = s1Val0+" OR "+s1Val1;
    	            	a1 = a1Val0+" OR "+a1Val1;
    	            	a3 = a3Val0+" OR "+a3Val1;
    	            	
    	            	
    	            	
    	            	if (solveTrianglesData.TriPossible(s1Val0, s2Val, s3Val) == true) {	
    	            		System.out.println(answer);
			            	 
			                pane = new JPanel();
			                pane.setLayout(new GridLayout(0, 4, 5, 4));
			
			                pane.add(new JLabel("Side A   "));
			                pane.add(new JTextField(s1));
			                pane.add(new JLabel("Angle A   "));
			                pane.add(new JTextField(a1+"\n"));
			                pane.add(new JLabel("Side B   "));
			                pane.add(new JTextField(s2));
			                pane.add(new JLabel("Angle B   "));
			                pane.add(new JTextField(a2));
			                pane.add(new JLabel("Side C   "));
			                pane.add(new JTextField(s3));
			                pane.add(new JLabel("Angle C   "));
			                pane.add(new JTextField(a3));
			
			                JOptionPane.showMessageDialog(frame, pane);
		            	} else {
		            		JOptionPane.showMessageDialog(frame, "This triangle is not possible");
		            	}
    	            	
       				} else if (BinSum == 49) {
       					
       					String s3ValS = s3Input.getText();
    	    			String s1ValS = s1Input.getText();
    	    			String a3ValS = a3Input.getText();        			
    	    			
    	    			s3Val = Double.parseDouble(s3ValS);
    	            	s1Val = Double.parseDouble(s1ValS);
    	            	a3Val = Double.parseDouble(a3ValS);
    	            	
    	            	String answer = solveTrianglesData.SSA(s3Val, s1Val, a3Val);
    	            	
    	            	String [] temp;
    	            	String delimiter = ",";
    	            	temp = answer.split(delimiter);
    	            	
    	            	String s1 = temp[2];
    	            	String a1 = temp[3];
    	            	String s2 = temp[4];
    	            	String a2 = temp[5];
    	            	String s3 = temp[0];
    	            	String a3 = temp[1];
    	            	
    	            	String newPos = (a1+" "+s2+" "+a2);
    	            	
    	            	s1Val = Math.round(Double.parseDouble(s1)*1000.0)/1000.0;
    	            	s3Val = Math.round(Double.parseDouble(s3)*1000.0)/1000.0;
    	            	a3Val = Math.round(Double.parseDouble(a3)*1000.0)/1000.0;
    	            	
    	            	s1 = Double.toString(s1Val);
    	            	s3 = Double.toString(s3Val);
    	            	a3 = Double.toString(a3Val);
    	            	
    	            	String [] tempNew;
    	            	tempNew = newPos.split(delimiter);
    	            	tempNew = newPos.split(" ");
    	            	System.out.println("TempNew = "+tempNew[0]);

    	            	Double a1Val0 = Double.parseDouble(tempNew[0]);
    	            	Double a1Val1 = Double.parseDouble(tempNew[1]);
    	            	Double s2Val0 = Double.parseDouble(tempNew[2]);
    	            	Double s2Val1 = Double.parseDouble(tempNew[3]);
    	            	Double a2Val0= Double.parseDouble(tempNew[4]);
    	            	Double a2Val1= Double.parseDouble(tempNew[5]);

    	            	a1 = a1Val0+" OR "+a1Val1;
    	            	s2 = s2Val0+" OR "+s2Val1;
    	            	a2 = a2Val0+" OR "+a2Val1;
    	            	
    	            	if (solveTrianglesData.TriPossible(s1Val, s2Val0, s3Val) == true) {
			            	System.out.println(answer);
			            	 
			                pane = new JPanel();
			                pane.setLayout(new GridLayout(0, 4, 5, 4));
			
			                pane.add(new JLabel("Side A   "));
			                pane.add(new JTextField(s1));
			                pane.add(new JLabel("Angle A   "));
			                pane.add(new JTextField(a1+"\n"));
			                pane.add(new JLabel("Side B   "));
			                pane.add(new JTextField(s2));
			                pane.add(new JLabel("Angle B   "));
			                pane.add(new JTextField(a2));
			                pane.add(new JLabel("Side C   "));
			                pane.add(new JTextField(s3));
			                pane.add(new JLabel("Angle C   "));
			                pane.add(new JTextField(a3));
			
			                JOptionPane.showMessageDialog(frame, pane);
		            	} else {
		            		JOptionPane.showMessageDialog(frame, "This triangle is not possible");
		            	}
       				} else if (BinSum == 52) {
       					
       					String s3ValS = s3Input.getText();
    	    			String s2ValS = s2Input.getText();
    	    			String a3ValS = a3Input.getText();        			
    	    			
    	    			s3Val = Double.parseDouble(s3ValS);
    	            	s2Val = Double.parseDouble(s2ValS);
    	            	a3Val = Double.parseDouble(a3ValS);
    	            	
    	            	String answer = solveTrianglesData.SSA(s3Val, s2Val, a3Val);
    	            	
    	            	String [] temp;
    	            	String delimiter = ",";
    	            	temp = answer.split(delimiter);
    	            	
    	            	String s1 = temp[4];
    	            	String a1 = temp[5];
    	            	String s2 = temp[2];
    	            	String a2 = temp[3];
    	            	String s3 = temp[0];
    	            	String a3 = temp[1];
    	            	
    	            	String newPos = (s1+" "+a1+" "+a2);
    	            	
    	            	s2Val = Math.round(Double.parseDouble(s2)*1000.0)/1000.0;
    	            	s3Val = Math.round(Double.parseDouble(s3)*1000.0)/1000.0;
    	            	a3Val = Math.round(Double.parseDouble(a3)*1000.0)/1000.0;
    	            	
    	            	s2 = Double.toString(s2Val);
    	            	s3 = Double.toString(s3Val);
    	            	a3 = Double.toString(a3Val);
    	            	
    	            	String [] tempNew;
    	            	tempNew = newPos.split(delimiter);
    	            	tempNew = newPos.split(" ");
    	            	System.out.println("TempNew = "+tempNew[0]);

    	            	Double s1Val0 = Double.parseDouble(tempNew[0]);
    	            	Double s1Val1 = Math.round(Double.parseDouble(tempNew[1])*1000.0)/1000.0;
    	            	Double a1Val0 = Double.parseDouble(tempNew[2]);
    	            	Double a1Val1 = Double.parseDouble(tempNew[3]);
    	            	Double a2Val0= Double.parseDouble(tempNew[4]);
    	            	Double a2Val1= Double.parseDouble(tempNew[5]);
    	            	
    	            	System.out.println(s1Val1+" s1v1");

    	            	s1 = s1Val0+" OR "+Math.round(s1Val1*1000.0)/1000.0;
    	            	a1 = a1Val0+" OR "+a1Val1;
    	            	a2 = a2Val0+" OR "+a2Val1;
    	            	
    	            	if (solveTrianglesData.TriPossible(s1Val0, s2Val, s3Val) == true) {
			            	System.out.println(answer);
			            	
			            	 
			                pane = new JPanel();
			                pane.setLayout(new GridLayout(0, 4, 5, 4));
			
			                pane.add(new JLabel("Side A   "));
			                pane.add(new JTextField(s1));
			                pane.add(new JLabel("Angle A   "));
			                pane.add(new JTextField(a1+"\n"));
			                pane.add(new JLabel("Side B   "));
			                pane.add(new JTextField(s2));
			                pane.add(new JLabel("Angle B   "));
			                pane.add(new JTextField(a2));
			                pane.add(new JLabel("Side C   "));
			                pane.add(new JTextField(s3));
			                pane.add(new JLabel("Angle C   "));
			                pane.add(new JTextField(a3));
			
			                JOptionPane.showMessageDialog(frame, pane);
		            	} else {
		            		JOptionPane.showMessageDialog(frame, "This triangle is not possible");
		            	}
    	            	
       				}
       			} 
       		if (BinSum == 26 || BinSum == 38 || BinSum == 41) { //ASA Case
       					if (BinSum == 26) {
       						
       						String a1ValS = a1Input.getText();
        	    			String s3ValS = s3Input.getText();
        	    			String a2ValS = a2Input.getText();        			
        	    			
        	    			a1Val = Double.parseDouble(a1ValS);
        	            	s3Val = Double.parseDouble(s3ValS);
        	            	a2Val = Double.parseDouble(a2ValS);
        	            	
        	            	String answer = solveTrianglesData.ASA(a1Val, s3Val, a2Val);
        	            	
        	            	String [] temp;
        	            	String delimiter = ",";
        	            	temp = answer.split(delimiter);
        	            	
        	            	String s1 = temp[0];
        	            	String a1 = temp[1];
        	            	String s2 = temp[2];
        	            	String a2 = temp[3];
        	            	String s3 = temp[4];
        	            	String a3 = temp[5];
        	            	
        	            	s1Val = Math.round(Double.parseDouble(s1)*1000.0)/1000.0;
        	            	a1Val = Math.round(Double.parseDouble(a1)*1000.0)/1000.0;
        	            	s2Val = Math.round(Double.parseDouble(s2)*1000.0)/1000.0;
        	            	a2Val = Math.round(Double.parseDouble(a2)*1000.0)/1000.0;
        	            	s3Val = Math.round(Double.parseDouble(s3)*1000.0)/1000.0;
        	            	a3Val = Math.round(Double.parseDouble(a3)*1000.0)/1000.0;
        	            	
        	            	s1 = Double.toString(s1Val);
        	            	a1 = Double.toString(a1Val);
        	            	s2 = Double.toString(s2Val);
        	            	a2 = Double.toString(a2Val);
        	            	s3 = Double.toString(s3Val);
        	            	a3 = Double.toString(a3Val);
        	            	
        	            	if (solveTrianglesData.TriPossible(s1Val, s2Val, s3Val) == true) {
    			            	System.out.println(answer);
    			            	 
    			                pane = new JPanel();
    			                pane.setLayout(new GridLayout(0, 4, 5, 4));
    			
    			                pane.add(new JLabel("Side A   "));
    			                pane.add(new JTextField(s1));
    			                pane.add(new JLabel("Angle A   "));
    			                pane.add(new JTextField(a1+"\n"));
    			                pane.add(new JLabel("Side B   "));
    			                pane.add(new JTextField(s2));
    			                pane.add(new JLabel("Angle B   "));
    			                pane.add(new JTextField(a2));
    			                pane.add(new JLabel("Side C   "));
    			                pane.add(new JTextField(s3));
    			                pane.add(new JLabel("Angle C   "));
    			                pane.add(new JTextField(a3));
    			
    			                JOptionPane.showMessageDialog(frame, pane);
    		            	} else {
    		            		JOptionPane.showMessageDialog(frame, "This triangle is not possible");
    		            	}
        	            	
       					} else if (BinSum == 38) {
       						
       						String a3ValS = a3Input.getText();
        	    			String s2ValS = s2Input.getText();
        	    			String a1ValS = a1Input.getText();        			
        	    			
        	    			a3Val = Double.parseDouble(a3ValS);
        	            	s2Val = Double.parseDouble(s2ValS);
        	            	a1Val = Double.parseDouble(a1ValS);
        	            	
        	            	String answer = solveTrianglesData.ASA(a3Val, s2Val, a1Val);
        	            	
        	            	String [] temp;
        	            	String delimiter = ",";
        	            	temp = answer.split(delimiter);
        	            	
        	            	String s1 = temp[4];
        	            	String a1 = temp[5];
        	            	String s2 = temp[0];
        	            	String a2 = temp[1];
        	            	String s3 = temp[2];
        	            	String a3 = temp[3];
        	            	
        	            	s1Val = Math.round(Double.parseDouble(s1)*1000.0)/1000.0;
        	            	a1Val = Math.round(Double.parseDouble(a1)*1000.0)/1000.0;
        	            	s2Val = Math.round(Double.parseDouble(s2)*1000.0)/1000.0;
        	            	a2Val = Math.round(Double.parseDouble(a2)*1000.0)/1000.0;
        	            	s3Val = Math.round(Double.parseDouble(s3)*1000.0)/1000.0;
        	            	a3Val = Math.round(Double.parseDouble(a3)*1000.0)/1000.0;
        	            	
        	            	s1 = Double.toString(s1Val);
        	            	a1 = Double.toString(a1Val);
        	            	s2 = Double.toString(s2Val);
        	            	a2 = Double.toString(a2Val);
        	            	s3 = Double.toString(s3Val);
        	            	a3 = Double.toString(a3Val);
        	            	
        	            	if (solveTrianglesData.TriPossible(s1Val, s2Val, s3Val) == true) {
    			            	System.out.println(answer);
    			            	 
    			                pane = new JPanel();
    			                pane.setLayout(new GridLayout(0, 4, 5, 4));
    			
    			                pane.add(new JLabel("Side A   "));
    			                pane.add(new JTextField(s1));
    			                pane.add(new JLabel("Angle A   "));
    			                pane.add(new JTextField(a1+"\n"));
    			                pane.add(new JLabel("Side B   "));
    			                pane.add(new JTextField(s2));
    			                pane.add(new JLabel("Angle B   "));
    			                pane.add(new JTextField(a2));
    			                pane.add(new JLabel("Side C   "));
    			                pane.add(new JTextField(s3));
    			                pane.add(new JLabel("Angle C   "));
    			                pane.add(new JTextField(a3));
    			
    			                JOptionPane.showMessageDialog(frame, pane);
    		            	} else {
    		            		JOptionPane.showMessageDialog(frame, "This triangle is not possible");
    		            	}
        	            	
       					} else if (BinSum == 41) {
       						
       						String a2ValS = a2Input.getText();
        	    			String s1ValS = s1Input.getText();
        	    			String a3ValS = a3Input.getText();        			
        	    			
        	    			a3Val = Double.parseDouble(a2ValS);
        	            	s2Val = Double.parseDouble(s1ValS);
        	            	a1Val = Double.parseDouble(a3ValS);
        	            	
        	            	String answer = solveTrianglesData.ASA(a2Val, s1Val, a3Val);
        	            	
        	            	String [] temp;
        	            	String delimiter = ",";
        	            	temp = answer.split(delimiter);
        	            	
        	            	String s1 = temp[2];
        	            	String a1 = temp[3];
        	            	String s2 = temp[4];
        	            	String a2 = temp[5];
        	            	String s3 = temp[0];
        	            	String a3 = temp[1];
        	            	
        	            	s1Val = Math.round(Double.parseDouble(s1)*1000.0)/1000.0;
        	            	a1Val = Math.round(Double.parseDouble(a1)*1000.0)/1000.0;
        	            	s2Val = Math.round(Double.parseDouble(s2)*1000.0)/1000.0;
        	            	a2Val = Math.round(Double.parseDouble(a2)*1000.0)/1000.0;
        	            	s3Val = Math.round(Double.parseDouble(s3)*1000.0)/1000.0;
        	            	a3Val = Math.round(Double.parseDouble(a3)*1000.0)/1000.0;
        	            	
        	            	s1 = Double.toString(s1Val);
        	            	a1 = Double.toString(a1Val);
        	            	s2 = Double.toString(s2Val);
        	            	a2 = Double.toString(a2Val);
        	            	s3 = Double.toString(s3Val);
        	            	a3 = Double.toString(a3Val);
        	            	
        	            	if (solveTrianglesData.TriPossible(s1Val, s2Val, s3Val) == true) {
    			            	System.out.println(answer);
    			            	 
    			                pane = new JPanel();
    			                pane.setLayout(new GridLayout(0, 4, 5, 4));
    			
    			                pane.add(new JLabel("Side A   "));
    			                pane.add(new JTextField(s1));
    			                pane.add(new JLabel("Angle A   "));
    			                pane.add(new JTextField(a1+"\n"));
    			                pane.add(new JLabel("Side B   "));
    			                pane.add(new JTextField(s2));
    			                pane.add(new JLabel("Angle B   "));
    			                pane.add(new JTextField(a2));
    			                pane.add(new JLabel("Side C   "));
    			                pane.add(new JTextField(s3));
    			                pane.add(new JLabel("Angle C   "));
    			                pane.add(new JTextField(a3));
    			
    			                JOptionPane.showMessageDialog(frame, pane);
    		            	} else {
    		            		JOptionPane.showMessageDialog(frame, "This triangle is not possible");
    		            	}
        	            	
       					}
       		}
    	}
    }
}