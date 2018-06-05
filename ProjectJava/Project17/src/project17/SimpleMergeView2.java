package project17;

import java.awt.*;
import javax.swing.*;

public class SimpleMergeView2 {
	private JFrame frame;
	private JTextArea leftTextArea;
	private JTextArea rightTextArea;
	private JScrollPane scrollLeft;
	private JScrollPane scrollRight;
	private JPanel mainPanel;
	private JPanel winPanel;
	private JPanel txtPanel;
	private JPanel txtPanel1;
	private JPanel editPanel;
	private JPanel comparePanel;
	private JLayeredPane layeredPanel;
	private JButton leftLoadButton;
	private JButton rightLoadButton;
	private JButton lefteditButton;
	private JButton righteditButton;
	private JButton leftsaveButton;
	private JButton rightsaveButton;
	private JButton compareButton;
	
	public SimpleMergeView2() {
		frame = new JFrame("SimpleMerge");
		
		frame.setBounds(500, 200, 1000, 500);
		mainPanel = new JPanel(new BorderLayout());
		txtPanel = new JPanel();
		winPanel = new JPanel(new FlowLayout());
		
		//North panel
		
		comparePanel = new JPanel();
		compareButton = new JButton("Compare");
		comparePanel.add(compareButton);
		
		//Center panel
		
		layeredPanel = new JLayeredPane();
		layeredPanel.setBackground(Color.GRAY);
		
		leftLoadButton = new JButton("Load");
		leftLoadButton.setBounds(63, 36, 89, 23);
		layeredPanel.add(leftLoadButton);
		
		lefteditButton = new JButton("Edit");
		lefteditButton.setBounds(162, 36, 89, 23);
		layeredPanel.add(lefteditButton);
		
		leftsaveButton = new JButton("Save");
		leftsaveButton.setBounds(261, 36, 89, 23);
		layeredPanel.add(leftsaveButton);
		
		rightLoadButton = new JButton("Load");
		rightLoadButton.setBounds(610, 36, 89, 23);
		layeredPanel.add(rightLoadButton);
		
		righteditButton = new JButton("Edit");
		righteditButton.setBounds(709, 36, 89, 23);
		layeredPanel.add(righteditButton);
		
		rightsaveButton = new JButton("Save");
		rightsaveButton.setBounds(808, 36, 89, 23);
		layeredPanel.add(rightsaveButton);
		
		scrollLeft = new JScrollPane();
		scrollLeft.setBounds(63, 70, 287, 219);
		layeredPanel.add(scrollLeft);
		
		leftTextArea = new JTextArea();
		//leftTextArea.setBounds(63, 70, 287, 219);
		scrollLeft.setViewportView(leftTextArea);
		
		scrollRight = new JScrollPane();
		scrollRight.setBounds(610, 70, 287, 219);
		layeredPanel.add(scrollRight);
		
		rightTextArea = new JTextArea();
		//rightTextArea.setBounds(610, 70, 287, 219);
		scrollRight.setViewportView(rightTextArea);
		
		mainPanel.add(comparePanel, BorderLayout.NORTH);
		mainPanel.add(layeredPanel, BorderLayout.CENTER);
		frame.add(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
				
	}
	
	// Property button
	public JButton getLeftLoad() {
		return this.leftLoadButton;
	}
	
	public JButton getRightLoad() {
		return this.rightLoadButton;
	}
	
	public JButton getLeftEdit() {
		return this.lefteditButton;
	}
	
	public JButton getRightEdit() {
		return this.righteditButton;
	}
	
	public JButton getLeftSave() {
		return this.leftsaveButton;
	}
	
	public JButton getRightSave() {
		return this.rightsaveButton;
	}
	
	public JButton getCompare() {
		return this.compareButton;
	}
	
	public JTextArea getLeftText() {
		return this.leftTextArea;
	}
	
	public JTextArea getRightText() {
		return this.rightTextArea;
	}
}
