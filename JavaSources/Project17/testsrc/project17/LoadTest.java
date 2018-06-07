package project17;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class LoadTest {

	private Load l;
	
	/*@Before
	public void setUp() throws Exception {
		l = new Load();
	}*/

	@Test
	void testFileChooser() {
		System.out.println("Test");
		//JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		//String filename = jfc.getSelectedFile().getPath();
		File file = new File(Load.filename);
		assertTrue(file.exists());
	}

}
