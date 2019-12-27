import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
/*
Steven Li
31647656
Project 3
Lab Days: Tuesday, Thursday 9:40-10:55
I did not collaborate with anyone on this assignment
 */

//Class that sets the frame and adds fireWorks a runner class

public class Runner extends JFrame implements ActionListener{
	public static void main(String[] args) {
		new Runner().setVisible(true);
		

	}
	
	public Runner() {
		setSize(640,640);
		setTitle("FIREWORKS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		fireWorks two = new fireWorks();
		add(two.panel);
		add(two);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
