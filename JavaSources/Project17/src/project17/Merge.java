package project17;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class Merge implements ActionListener{
	private JTextArea leftText;
	private JTextArea rightText;

	public Merge(JTextArea leftTxt, JTextArea rightTxt) {
		this.leftText = leftTxt;
		this.rightText = rightTxt;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
	
}
