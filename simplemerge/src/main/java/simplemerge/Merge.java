package simplemerge;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class Merge implements ActionListener{
	private JTextArea leftText;
	private JTextArea rightText;
	private int option;

	// nes tiesiog nelabai yra ka testuoti, viena vartotojo sasaja
	
	
	public Merge(JTextArea leftTxt, JTextArea rightTxt, int opt) {
		this.leftText = leftTxt;
		this.rightText = rightTxt;
		this.option = opt;
	}
	
	
	public void bar() {
		int j = 0;
		while(j > 10) {
			j++;
		}
	}

	
	// manau tikrai galima iskelti kazkiek logikos i atskira metoda. tuo paciu tai bus ir geresnis programavimo principas
	// arba pasirinkti kita programa, kur butu bent keletas metodu ka testuoti
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String[] leftTxt = leftText.getText().split("\n"); 
		String[] rightTxt = rightText.getText().split("\n");		
		int leftLength = leftTxt.length; int rightLength = rightTxt.length;
		int minLength = leftLength < rightLength ? leftLength : rightLength;
		int maxLength = leftLength > rightLength ? leftLength : rightLength;
		
		int [] hLine = new int[maxLength]; int hLength = 0;
		
		for(int i = 0; i < minLength; i++)
			if(!(leftTxt[i].equals(rightTxt[i]))) {
				hLine[i] = i + 1;
				hLength++;
			}
	}
	
	
}
