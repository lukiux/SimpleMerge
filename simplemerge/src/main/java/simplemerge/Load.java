package simplemerge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class Load implements ActionListener{
	private JTextArea txtArea;
	private int option;
	public static String filename;
	final private int kfff;
	
	public Load(JTextArea txt, int option) {
		this.txtArea = txt;
		this.option = option;
		this.kfff = 0;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str; // string line
		
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Select a file");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT (*.txt)", "txt");
		jfc.addChoosableFileFilter(filter);
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			System.out.println(jfc.getSelectedFile().getPath());
			filename = jfc.getSelectedFile().getPath();
			
			if(option == 0)
				SimpleMergeController.leftFile = filename;
			else
				SimpleMergeController.rightFile = filename;
			
			try {
				FileReader reader = new FileReader(filename);
				BufferedReader br = new BufferedReader(reader);
				txtArea.setText("");
				while ((str = br.readLine()) != null)
					txtArea.append(str + "\n");
				br.close();
				
			} catch (Exception ee) {System.out.println("Error!");}
		}
	}	
}
