package simplemerge;

import java.util.*;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

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
	private JButton copytoleft;
	private JButton copytoright;
	private JButton allCpyToRight;
	private JButton allCpyToLeft;
	
	public static int compOption = 0;
	public static int leftLineNum = -1;
	public static int rightLineNum = -1;
	public static ArrayList<Integer> lbl;
	public static ArrayList<Integer> rbl;
	
	public static String leftFile = null;  // File name from left panel
	public static String rightFile = null; // File name from right panel
	
	public static void setLeftLineNum(int k) {
		SimpleMergeController.leftLineNum = k;
	}
	
	public static void setRightLineNum(int k) {
		SimpleMergeController.rightLineNum = k;
	}
	
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
		this.copytoleft = this.view.getCopytoLeft();
		this.copytoright = this.view.getCopytoRigth();
		this.allCpyToRight = this.view.getAllCpyToRight();
		this.allCpyToLeft = this.view.getAllCpyToLeft();
		
		//call ActionListener
		this.leftLoad.addActionListener(new Load(leftArea, 0));
		this.rightLoad.addActionListener(new Load(rightArea, 1));
		this.leftedit.addActionListener(new Edit(leftArea, 0));
		this.rightedit.addActionListener(new Edit(rightArea, 1));
		this.leftsave.addActionListener(new Save(leftArea, 0));
		this.rightsave.addActionListener(new Save(rightArea, 1));
		this.compare.addActionListener(new Compare(leftArea, rightArea));
		this.copytoright.addActionListener(new MergeEventHandler(leftArea, rightArea, 0));
		this.copytoleft.addActionListener(new MergeEventHandler(leftArea, rightArea, 1));
		this.allCpyToRight.addActionListener(new CopyEventHandler(leftArea, rightArea, 0));
		this.allCpyToLeft.addActionListener(new CopyEventHandler(leftArea, rightArea, 1));
		
		leftArea.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                JTextArea editArea = (JTextArea)e.getSource();
                try {
                	rightLineNum = -1;
                    int caretpos = editArea.getCaretPosition();
                    leftLineNum = editArea.getLineOfOffset(caretpos) + 1;

                }
                catch(Exception ex) { ex.printStackTrace(); }
            }
        });
      
		rightArea.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                JTextArea editArea = (JTextArea)e.getSource();
                try {
                	leftLineNum = -1;
                    int caretpos = editArea.getCaretPosition();
                    rightLineNum = editArea.getLineOfOffset(caretpos) + 1;
                }
                catch(Exception ex) { ex.printStackTrace(); }
            }
		});
		
	}

	public JButton getLeftedit() {
		return leftedit;
	}

	public void setLeftedit(JButton leftedit) {
		this.leftedit = leftedit;
	}

	public JButton getRightedit() {
		return rightedit;
	}

	public void setRightedit(JButton rightedit) {
		this.rightedit = rightedit;
	}
	
	
}
