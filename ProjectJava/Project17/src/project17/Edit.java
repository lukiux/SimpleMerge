package project17;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Edit implements ActionListener {
	private JTextArea textArea;
	private int option;
	
	public Edit(JTextArea txt, int option) {
		this.textArea = txt;
		this.option = option;
	}

	@Override
	public void actionPerformed(ActionEvent e) {			
		
			if (option == 0 && SimpleMergeController.leftFile != null)
				if(textArea.isEditable()) textArea.setEditable(false);
				else textArea.setEditable(true);
			else if (option == 1 && SimpleMergeController.rightFile != null)
					if(textArea.isEditable()) textArea.setEditable(false);
					else textArea.setEditable(true);
			else {JOptionPane.showMessageDialog(null, "Please to load text file", "Alert", JOptionPane.ERROR_MESSAGE);}
			/*if(option == 0 && (textArea.isEditable() || SimpleMergeController.leftFile == null))
				textArea.setEditable(false);
			else if(option == 0 && !textArea.isEditable()) textArea.setEditable(true);
			else if(option == 1 && (textArea.isEditable() || SimpleMergeController.rightFile == null)) textArea.setEditable(false);
			else if(option == 1 && !textArea.isEditable()) textArea.setEditable(true);*/
			
	}
}