package project17;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

public class Compare implements ActionListener {
	private JTextArea leftArea;
	private JTextArea rightArea;
	
	public Compare(JTextArea lArea, JTextArea rArea) {
		this.leftArea = lArea;
		this.rightArea = rArea;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.green);
		HighlightPainter rightpainter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
		String[] leftTxt = leftArea.getText().split("\n"); 
		String[] rightTxt = rightArea.getText().split("\n");
		int leftLength = leftTxt.length; int rightLength = rightTxt.length;
		
		int L[][] = new int[leftLength + 1][rightLength + 1]; // Length of LCS
		String sequence[][] = new String[leftLength + 1][rightLength + 1]; // Checking sequence step-by-step
		String state[] = {"STAND", "TOP", "LEFT"};
		
		// LCS Algorithm
		for(int i = 0; i <= leftLength; i++)
			for(int j = 0; j <= rightLength; j++) {
				if(i == 0 || j == 0) {
					L[i][j] = 0;
					sequence[i][j] = null;
				}
				else if(leftTxt[i - 1].equals(rightTxt[j - 1])) {
					L[i][j] = L[i - 1][j - 1] + 1;
					sequence[i][j] = state[0];
				}
				else {
					L[i][j] = Math.max(L[i][j - 1], L[i - 1][j]);
					if(L[i][j] == L[i - 1][j]) sequence[i][j] = state[1];
					else sequence[i][j] = state[2];
				}				
			}
		
		// Get line start
		int id = 0;
		int leftSolu[] = new int[leftLength];  //Line index of solution line
		int rightSolu[] = new int[rightLength]; //Line index of solution line
		
		Highlighter lihighlighter = leftArea.getHighlighter();
		Highlighter rihighlighter = rightArea.getHighlighter();		
		
		//Make differences between the left and the right
		while(sequence[leftLength][rightLength] != null) {
			if(sequence[leftLength][rightLength].equals(state[0])) {
				try {
					leftSolu[id] = leftArea.getLineOfOffset(leftArea.getLineStartOffset(leftLength - 1));
					rightSolu[id] = rightArea.getLineOfOffset(rightArea.getLineStartOffset(rightLength - 1));
					id++;
				} catch (BadLocationException e) {e.printStackTrace();}
				leftLength--; rightLength--;				
			}
			else if(sequence[leftLength][rightLength].equals(state[1])) {
				try {
					lihighlighter.addHighlight(leftArea.getLineStartOffset(leftLength-1) - 1, leftArea.getLineEndOffset(leftLength - 1), painter);
				} catch (BadLocationException e) {e.printStackTrace();}
				leftLength--;
			}
			else if(sequence[leftLength][rightLength].equals(state[2])) {
				try {
					rihighlighter.addHighlight(rightArea.getLineStartOffset(rightLength-1) - 1, rightArea.getLineEndOffset(rightLength - 1), rightpainter);
				} catch (BadLocationException e) {e.printStackTrace();}
				rightLength--;
			}
		}
		
		// stepping from the bottom to the top for highlighted the some color on every the line
		for(; leftLength > 0; leftLength--){
			try {
				lihighlighter.addHighlight(leftArea.getLineStartOffset(leftLength - 1), leftArea.getLineEndOffset(leftLength - 1), painter);
			} catch (BadLocationException e) {e.printStackTrace();}
		}
		
		for(; rightLength > 0; rightLength--){
			try {
				rihighlighter.addHighlight(rightArea.getLineStartOffset(rightLength - 1), rightArea.getLineEndOffset(rightLength - 1), rightpainter);
			} catch (BadLocationException e) {e.printStackTrace();}
		}
		
		// Insert new lines into the right text area and the left text area
		int leftNewLine = 0; int rightNewLine = 0; // initialize new lines		
		
		for(int m = id - 1; m >-1; m--) {			
			if(leftSolu[m] + leftNewLine < rightSolu[m] + rightNewLine)
				while(rightSolu[m] + rightNewLine - leftSolu[m] - leftNewLine > 0) {
					try {
						leftArea.insert("\n", leftArea.getLineStartOffset(leftSolu[m] + leftNewLine));
					} catch (BadLocationException e) {e.printStackTrace();}
					leftNewLine++;
				}
			else if(leftSolu[m] + leftNewLine > rightSolu[m] + rightNewLine)
				while(leftSolu[m] + leftNewLine - rightSolu[m] - rightNewLine > 0) {
					try {
						rightArea.insert("\n", rightArea.getLineStartOffset(rightSolu[m] + rightNewLine));
					} catch (BadLocationException e) {e.printStackTrace();}
					rightNewLine++;					
				}
			}
		
		// New line inserted in the line end
		leftTxt = leftArea.getText().split("\n");
		rightTxt = rightArea.getText().split("\n");
		if(leftTxt.length > rightTxt.length) 
			for(int m = 0; m < leftTxt.length - rightTxt.length; m++)
				rightArea.append("\n\0");		
		else if(leftTxt.length < rightTxt.length) 
			for(int m = 0; m < rightTxt.length - leftTxt.length; m++)
				leftArea.append("\n\0");				
	}	
}
