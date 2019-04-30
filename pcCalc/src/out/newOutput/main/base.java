package out.newOutput.main;


import javax.swing.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import out.newOutput.data.unitCircle;
import out.newOutput.input.complexTransTri;
import out.newOutput.input.solveTrianglesMain;


public class base {

		public static void main (String[] args){

			//basic args for window size, title, and closing
			JFrame frame = new JFrame("Precalc Calculators");
			frame.setVisible(true);
			frame.setSize(500,200);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			//New Button
			JPanel panel = new JPanel();
			frame.add(panel);
			JButton button = new JButton("Triangle Solver");
			panel.add(button);
			button.addActionListener (new Action1()); //Calls on Action1

			JButton button2 = new JButton("Complex Transformation");
			panel.add(button2);
			button2.addActionListener (new Action2()); //Filler action for testing and clones

			JButton button3 = new JButton("Unit Circle Quiz");
			panel.add(button3);
			button3.addActionListener (new Action3()); //Filler action for testing and clones

			JButton button4 = new JButton("Work in Progress");
			panel.add(button4);
			button4.addActionListener (new Action4());


		}
		static class Action1 implements ActionListener {

			public void actionPerformed (ActionEvent e) {

				solveTrianglesMain.main(null); //Run triSolver (popup)

			  }
		}
		static class Action2 implements ActionListener {

			//Filler Action button
			 public void actionPerformed (ActionEvent e) {
			    complexTransTri.main(null);
			  }
		}

		static class Action3 implements ActionListener {

			//Filler Action button
			public void actionPerformed (ActionEvent e) {
			   unitCircle.main(null);
			  }
		}

		static class Action4 implements ActionListener {

			//Filler Action button
			 public void actionPerformed (ActionEvent e) {
			    JFrame frame3 = new JFrame("WIP");
			    frame3.setVisible(true);
			    frame3.setSize(200,200);

			  }
		}
	}
