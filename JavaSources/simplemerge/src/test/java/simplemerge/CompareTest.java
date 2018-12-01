package simplemerge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CompareTest {

	private String txt1 = "1 2 3 4 5 6 7 8 9 10";
	private String txt2 = "1 2 4 5 6 7 9 10";
	
	String[] leftTxt = txt1.split(" ");
	String[] rightTxt = txt2.split(" ");
	int leftLength = leftTxt.length; int rightLength = rightTxt.length;
	
	int L[][] = new int[leftLength + 1][rightLength + 1]; // Length of LCS
	String sequence[][] = new String[leftLength + 1][rightLength + 1];
	String state[] = {"STAND", "TOP", "LEFT"};
	
	public String[][] LCSAlgorithm() {
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
		return sequence;
	}
	
	@Test
	public void test() {
		String[][] sequence = LCSAlgorithm();
		
		for (int i = 0; i < sequence.length; i++)
			for(int j = 0; j < sequence[i].length; j++)
				System.out.println(sequence[i][j]);
		
		assertNotNull(sequence, "Checking sequence isn't NULL");
		assertEquals(11, sequence.length);
	}

}
