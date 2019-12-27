import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
Steven Li
31647656
Project 3
Lab Days: Tuesday, Thursday 9:40-10:55
I did not collaborate with anyone on this assignment

Class that makes the fireworks and GUI 
 */
public class fireWorks extends JComponent implements ActionListener, ItemListener{

	protected JLabel label;
	protected Choice dropDown;
	protected Choice shapes;
	protected JTextField speedAndAngle;
	protected JLabel instructions;
	//designs
	protected boolean start = false;
	protected boolean target = false;
	protected boolean circleSquares = false;
	protected boolean sun = false;
	protected boolean bowtie = false;
	protected boolean person = false;
	
	protected boolean peopleEverywhere = false;
	//colors
	protected boolean red = false;
	protected boolean blue = false;
	protected boolean green = false;
	protected boolean magenta = false;
	protected boolean black = false;

	protected int s; //speed
	protected int t; //velocity
	protected int a; //angle
	protected JButton boom;
	protected JPanel panel;
	protected int xCoor;
	protected int yCoor;
	protected double gravity = 9.8;


	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("MyApp.actionPerformed");
		Object src = e.getSource();
		if(src == boom ) {
			if(start) {
				start = false;
				target = false;
				circleSquares = false;
				bowtie = false;
				person = false;
				peopleEverywhere = false;
				
				red = false;
				blue = false;
				green = false;
				magenta = false;
				black = false;
				boom.setText("Go!");
			}else {
				System.out.println(speedAndAngle.getText());
				String[] split = speedAndAngle.getText().split(" ");
				s = Integer.parseInt(split[0]);
				t = Integer.parseInt(split[1]);
				a = Integer.parseInt(split[2]);
				start = true;
				System.out.println("Speed: " + s);
				System.out.println("Time: " + t);
				System.out.println("Angle: " + a);
				launchCoordinateX(s,a,t);
				launchCoordinateY(s,a,t);

				repaint();
				boom.setText("Reset");
			}
		}



	}

	@Override
	public void paintComponent(Graphics g) {
		System.out.println("We got here");
		System.out.println("We got repainted here");
		System.out.println("XCoor: " + xCoor);
		System.out.println("YCoor: " + yCoor);
		if(red) {
			g.setColor(Color.red);
		}
		if(blue) {
			g.setColor(Color.blue);
		}
		if(green) {
			g.setColor(Color.green);
		}
		if(magenta) {
			g.setColor(Color.magenta);
		}
		if(black) {
			g.setColor(Color.black);
		}
		if(target) {
			int tempX = getWidth()-getWidth()-20;
			int tempY = getHeight() + 20;
			int tempX2 = tempX;
			int tempY2 = tempY;
			for(int i = 0; i <= t; i++) {
				tempX2 = returnCoordinateX(s,a,i);
				//System.out.println("XCoord: "+ tempX2);
				tempY2 = returnCoordinateY(s,a,i);
				System.out.println("YCoord: "+ tempY2);
				g.drawLine(tempX, tempY, tempX2, tempY2);
				tempX = tempX2;
				tempY = tempY2;
			}
			g.drawLine(getWidth()-getWidth()-20, getHeight()+20, xCoor, yCoor);
			for(int i = 450; i > 0; i-=50) {
				g.drawOval(xCoor - (i/2), yCoor-(i/2), i, i);
			}

		}
		if(circleSquares) {
			g.drawLine(getWidth()-getWidth()-20, getHeight()+20, xCoor, yCoor);
			for(int i = 400; i > 0; i-=(200*Math.sqrt(2))) {
				g.drawRect(xCoor - (i/2), yCoor-(i/2), i, i);
				g.drawOval(xCoor - (i/2), yCoor-(i/2), i, i);
			}

		}
		if(sun) {
			g.drawLine(getWidth()-getWidth()-20, getHeight()+20, xCoor, yCoor);
			g.drawOval(xCoor - 100, yCoor - 100, 200, 200);
			g.drawOval(xCoor-37, yCoor-175, 75, 75);
			g.drawOval(xCoor-37, yCoor+100, 75, 75);
			g.drawOval(xCoor-175, yCoor-37, 75, 75);
			g.drawOval(xCoor+100, yCoor-37, 75, 75);

		}
		if(bowtie) {
			g.drawLine(getWidth()-getWidth()-20, getHeight()+20, xCoor, yCoor);
			g.drawRect(xCoor-100,yCoor-50,200,100);
			g.drawOval(xCoor+100, yCoor-50, 50, 100);
			g.drawOval(xCoor-150, yCoor-50, 50, 100);
			int tempX = xCoor+100;
			int tempY = yCoor-150;
			for(int i = 3; i > 0; i--) {
				if(i == 2) {
					tempX = xCoor+50;
					tempY = yCoor-100;
				}
				if(i == 1) {
					tempX = xCoor;
					tempY = yCoor-50;
				}
				for(int j = 0; j < i; j++) {
					System.out.println("yeet");
					g.drawOval(tempX, tempY, 50, 100);
					tempY=tempY+100;
				}
			}
			
			tempX = xCoor-150;
			tempY = yCoor -150; 
			for(int i = 3; i > 0; i--) {
				if(i == 2) {
					tempX = tempX+50;
					tempY = yCoor-100;
				}
				if(i == 1) {
					tempX = tempX+50;
					tempY = yCoor-50;
				}
				for(int j = 0; j < i; j++) {
					System.out.println("yeet");
					g.drawOval(tempX, tempY, 50, 100);
					tempY=tempY+100;
				}
			}
		}
		if(person) {
			g.drawLine(getWidth()-getWidth()-20, getHeight()+20, xCoor, yCoor);
			g.drawOval(xCoor-35, yCoor-100, 70, 70);
			g.drawLine(xCoor, yCoor-30, xCoor, yCoor-30+100);
			g.drawLine(xCoor-35, yCoor, xCoor+35, yCoor);
			g.drawLine(xCoor, yCoor+70, xCoor-50, yCoor+100);
			g.drawLine(xCoor, yCoor+70, xCoor+50, yCoor+100);

		}
		if(peopleEverywhere) {
			g.drawLine(getWidth()-getWidth()-20, getHeight()+20, xCoor, yCoor);
			g.drawOval(xCoor-35, yCoor-100, 70, 70);
			g.drawLine(xCoor, yCoor-30, xCoor, yCoor-30+100);
			g.drawLine(xCoor-35, yCoor, xCoor+35, yCoor);
			g.drawLine(xCoor, yCoor+70, xCoor-50, yCoor+100);
			g.drawLine(xCoor, yCoor+70, xCoor+50, yCoor+100);
			int tempX = xCoor;
			int tempY = yCoor;
			for(int i = 0; i < 6; i++) {
				Random rand = new Random();
				int randS = rand.nextInt(11) + 1;
				int randA= rand.nextInt(45) + 1;
				System.out.println("randS = :" +randS);
				System.out.println("randA = :" +randA);
				
				if(i%2 == 0) {
					tempX = returnCoordinateX(s+randS, a - randA, 2)+ xCoor;

				}
				if(i%2 != 0) {
					tempX = xCoor- returnCoordinateX(s+randS, a - randA, 2);
				}
				tempY = returnCoordinateY(s+randS, a - randA, 2) -yCoor;
				System.out.println("tempX = :" +tempX);
				System.out.println("tempY = :" +tempY);

				g.drawLine(xCoor, yCoor, tempX, tempY);
				g.drawOval(tempX-35, tempY-100, 70, 70);
				g.drawLine(tempX, tempY-30, tempX, tempY-30+100);
				g.drawLine(tempX-35, tempY, tempX+35, tempY);
				g.drawLine(tempX, tempY+70, tempX-50, tempY+100);
				g.drawLine(tempX, tempY+70, tempX+50, tempY+100);
			}
		}


	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		System.out.println(shapes.getSelectedItem() + " selected");
		if(shapes.getSelectedItem().equalsIgnoreCase("Target")) {
			target = true;
			circleSquares = false;
			sun = false;
			bowtie = false;
			person = false;
			peopleEverywhere = false;

		}
		if(shapes.getSelectedItem().equalsIgnoreCase("Circle Squares")) {
			target = false;
			circleSquares = true;
			sun = false;
			bowtie = false;
			person = false;
			peopleEverywhere = false;

		}
		if(shapes.getSelectedItem().equalsIgnoreCase("Sun")) {
			target = false;
			circleSquares = false;
			sun = true;
			bowtie = false;
			person = false;
			peopleEverywhere = false;

		}
		if(shapes.getSelectedItem().equalsIgnoreCase("Bowtie")) {
			target = false;
			circleSquares = false;
			sun = false;
			bowtie = true;
			person = false;
			peopleEverywhere = false;

		}
		if(shapes.getSelectedItem().equalsIgnoreCase("Person")) {
			target = false;
			circleSquares = false;
			sun = false;
			bowtie = false;
			person = true;
			peopleEverywhere = false;

		}
		if(shapes.getSelectedItem().equalsIgnoreCase("Overpopulation")) {
			target = false;
			circleSquares = false;
			sun = false;
			bowtie = false;
			person = false;
			peopleEverywhere = true;
		}
		
		
		if(dropDown.getSelectedItem().equalsIgnoreCase("Red")) {
			red = true;
			blue = false;
			green = false;
			magenta = false;
			black = false;
		}
		if(dropDown.getSelectedItem().equalsIgnoreCase("Blue")) {
			red = false;
			blue = true;
			green = false;
			magenta = false;
			black = false;
		}
		if(dropDown.getSelectedItem().equalsIgnoreCase("Green")) {
			red = false;
			blue = false;
			green = true;
			magenta = false;
			black = false;
		}
		if(dropDown.getSelectedItem().equalsIgnoreCase("Magenta")) {
			red = false;
			blue = false;
			green = false;
			magenta = true;
			black = false;
		}
		if(dropDown.getSelectedItem().equalsIgnoreCase("Black")) {
			red = true;
			blue = false;
			green = false;
			magenta = false;
			black = true;
		}

	}

	public void launchCoordinateX(int speed, int angle, int time) {
		xCoor = (int)(speed * Math.cos(Math.toRadians(angle))*time);
		System.out.println("LOOK AT ME: " + xCoor);
	}
	public int returnCoordinateX(int speed, int angle, int time) {
		return (int)(speed * Math.cos(Math.toRadians(angle))*time);
	}

	public void launchCoordinateY(int speed, int angle, int time) {
		int part1 = (int)(speed * Math.sin(Math.toRadians(angle))*time);
		int part2 = (int)(0.5 *gravity*Math.pow(time, 2));
		if((part1-part2)>0) {
			yCoor = Math.abs(620-(part1 - part2));

		}else {
			yCoor = Math.abs(620+(part1 - part2));

		}

	}
	public int returnCoordinateY(int speed, int angle, int time) {
		int tempY;
		int part1 = (int)(speed * Math.sin(Math.toRadians(angle))*time);
		int part2 = (int)(0.5 *gravity*Math.pow(time, 2));
		System.out.println("LOOK AT HERE " + (part1-part2));
		if((part1-part2)>0) {
			tempY = Math.abs(620-(part1 - part2));

		}else {
			tempY = Math.abs(620+(part1 - part2));

		}
		return tempY;

	}


	public fireWorks() {
		panel = new JPanel();
		panel.setSize(640, 100);
		panel.setLayout(new FlowLayout());
		boom = new JButton("GO");
		boom.addActionListener(this);
		panel.add(boom);
		label = new JLabel("");
		panel.add(label);
		speedAndAngle = new JTextField(15);
		speedAndAngle.addActionListener(this);
		panel.add(speedAndAngle);
		shapes = new Choice();
		shapes.add("Choose Shape Here");
		shapes.add("Target");
		shapes.add("Circle Squares");
		shapes.add("Sun");
		shapes.add("Bowtie");
		shapes.add("Person");
		shapes.add("Overpopulation");
		shapes.addItemListener(this);
		panel.add(shapes);
		dropDown = new Choice();
		dropDown.add("Choose Color Here");
		dropDown.add("Red");
		dropDown.add("Green");
		dropDown.add("Blue");
		dropDown.add("Magenta");
		dropDown.add("Black");
		dropDown.addItemListener(this);
		panel.add(dropDown);
		instructions = new JLabel("Choose color. Type a speed (space) time (space) and angle then click enter. Click Reset when done.");
		panel.add(instructions);

	}



}
