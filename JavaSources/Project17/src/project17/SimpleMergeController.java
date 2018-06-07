package project17;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.CaretEvent;

public class SimpleMergeController {
	private SimpleMergeView view;
	private JButton rightLoad;
	private JButton leftLoad;
	private JTextArea leftArea;
	private JTextArea rightArea;
	private JButton leftedit;
	private JButton rightedit;
	private JButton leftsave;
	private JButton rightsave;
	private JButton compare;
	
	public static String leftFile = null;  // File name from left panel
	public static String rightFile = null; // File name from right panel
	
	public SimpleMergeController() {
		this.view = new SimpleMergeView();
		// Link Model
		
		this.leftArea = this.view.getLeftText();
		this.rightArea = this.view.getRightText();
		
		this.rightLoad = this.view.getRightLoad();
		this.leftLoad = this.view.getLeftLoad();		
		this.leftedit = this.view.getLeftEdit();
		this.rightedit = this.view.getRightEdit();
		this.leftsave = this.view.getLeftSave();
		this.rightsave = this.view.getRightSave();
		this.compare = this.view.getCompare();
		
		//call ActionListener
		this.leftLoad.addActionListener(new Load(leftArea, 0));
		this.rightLoad.addActionListener(new Load(rightArea, 1));
		this.leftedit.addActionListener(new Edit(leftArea, 0));
		this.rightedit.addActionListener(new Edit(rightArea, 1));
		this.leftsave.addActionListener(new Save(leftArea, 0));
		this.rightsave.addActionListener(new Save(rightArea, 1));
		this.compare.addActionListener(new Compare(leftArea, rightArea));
		
	}
}
