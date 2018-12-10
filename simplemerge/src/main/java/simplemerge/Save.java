package simplemerge;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Save implements ActionListener {
	
	private JTextArea textArea;
	private int option;
	private File file;
	private String fileName;
	
	public Save(JTextArea text, int option) {
		this.textArea = text;
		this.option = option;
		file = null;
		fileName = null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (option == 0 && SimpleMergeController.leftFile != null) {
			file = new File(SimpleMergeController.leftFile);
			fileName = file.toString();
		}else if (option == 1 && SimpleMergeController.rightFile != null) {
			file = new File(SimpleMergeController.rightFile);
			fileName = file.toString();
		}
		
		try {
			String line;
			BufferedReader br = new BufferedReader(new StringReader(textArea.getText()));
			BufferedWriter wr = new BufferedWriter(new FileWriter(fileName));
			
			while((line = br.readLine()) != null) {
				wr.write(line);
				wr.newLine();
			}
			wr.flush();
			wr.close();
			JOptionPane.showMessageDialog(new Frame(), "Saved", "Save file information", JOptionPane.PLAIN_MESSAGE);
		} catch (Exception ee) {JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);}			
	}

}
