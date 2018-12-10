package simplemerge;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SimpleMergeView {

	private JFrame frame;
	private JTextArea leftTextArea;
	private JTextArea rightTextArea;
	private JScrollPane scrollLeft;
	private JScrollPane scrollRight;
	private JPanel mainPanel;
	private JPanel winPanel;
	private JPanel txtPanel;
	private JPanel comparePanel;
	private JLayeredPane layeredPanel;
	private JButton leftLoadButton;
	private JButton rightLoadButton;
	private JButton lefteditButton;
	private JButton righteditButton;
	private JButton leftsaveButton;
	private JButton rightsaveButton;
	private JButton compareButton;
	private JButton copytoleft;
	private JButton copytoright;
	private JButton allCpyToRight;
	private JButton allCpyToLeft;

	static SimpleMergeView inst = null;
	public static SimpleMergeView createFrame() {
		if (inst == null)
			inst = new SimpleMergeView();
		return inst;
	}
	
	/**
	 * Create the application.
	 */
	public SimpleMergeView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("SimpleMerge");
		
		frame.setBounds(500, 200, 1000, 500);
		mainPanel = new JPanel(new BorderLayout());
		txtPanel = new JPanel();
		winPanel = new JPanel(new FlowLayout());
		
		//North panel
		
		comparePanel = new JPanel();
		
		
		copytoright = new JButton("Copy to Right");
		comparePanel.add(copytoright);		
		compareButton = new JButton("Compare");
		comparePanel.add(compareButton);
		copytoleft = new JButton("Copy to Left");
		comparePanel.add(copytoleft);
		
		allCpyToRight = new JButton("...");
		allCpyToLeft = new JButton("...");
		
		//Center panel
		
		layeredPanel = new JLayeredPane();
		layeredPanel.setBackground(Color.GRAY);
		
		leftLoadButton = new JButton("Load");
		leftLoadButton.setBounds(63, 36, 80, 23);
		layeredPanel.add(leftLoadButton);
		
		lefteditButton = new JButton("Edit");
		lefteditButton.setBounds(153, 36, 80, 23);
		layeredPanel.add(lefteditButton);
		
		leftsaveButton = new JButton("Save");
		leftsaveButton.setBounds(243, 36, 80, 23);
		layeredPanel.add(leftsaveButton);
		
		rightLoadButton = new JButton("Load");
		rightLoadButton.setBounds(610, 36, 80, 23);
		layeredPanel.add(rightLoadButton);
		
		righteditButton = new JButton("Edit");
		righteditButton.setBounds(700, 36, 80, 23);
		layeredPanel.add(righteditButton);
		
		rightsaveButton = new JButton("Save");
		rightsaveButton.setBounds(790, 36, 80, 23);
		layeredPanel.add(rightsaveButton);
		
		scrollLeft = new JScrollPane();
		scrollLeft.setBounds(63, 70, 260, 219);
		layeredPanel.add(scrollLeft);
		
		leftTextArea = new JTextArea();
		leftTextArea.setEditable(false);
		scrollLeft.setViewportView(leftTextArea);
		
		scrollRight = new JScrollPane();
		scrollRight.setBounds(610, 70, 260, 219);
		layeredPanel.add(scrollRight);
		
		rightTextArea = new JTextArea();
		rightTextArea.setEditable(false);
		scrollRight.setViewportView(rightTextArea);
		
		mainPanel.add(comparePanel, BorderLayout.NORTH);
		
		
		mainPanel.add(layeredPanel, BorderLayout.CENTER);		
		
		frame.getContentPane().add(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
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
	
	public JButton getCopytoLeft() {
		return this.copytoleft;
	}
	
	public JButton getCopytoRigth() {
		return this.copytoright;
	}
	
	public JTextArea getLeftText() {
		return this.leftTextArea;
	}
	
	public JTextArea getRightText() {
		return this.rightTextArea;
	}
	
	public JButton getAllCpyToLeft() {
		return this.allCpyToLeft;
	}
	public JButton getAllCpyToRight() {
		return this.allCpyToRight;
	}
}
