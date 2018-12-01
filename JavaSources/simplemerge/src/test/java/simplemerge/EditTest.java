package simplemerge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;

class EditTest {

	
	private int option;
	private SimpleMergeView view;
	private JTextArea leftArea;
	private JTextArea rightArea;
	
	@Test
	public void testGetEdit() {
		this.view = SimpleMergeView.createFrame();
		this.leftArea = view.getLeftText();
		this.rightArea = view.getRightText();
		assertTrue(leftArea.isEditable());
		assertTrue(rightArea.isEditable());
	}

}
