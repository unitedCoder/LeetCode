package com.skawatra.leetcode;
/**
 * NOTES:
 * string.length = l
 *  
 * @author skawatra
 *
 */
public class ZigZagConversion {

	public static void main(String[] args) {
		String inputString = "PAYPALISHIRING";
		int numberOfRows = 4;
		ZigZagConversion obj = new ZigZagConversion();
		System.out.println(obj.convert(inputString,numberOfRows));

	}
	/**
	 * Input - PAYPALISHIRING
	 * Output - PAHNAPLSIIGYIR
	 * P A H N
	 * APLSIIG
	 * Y I R
	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert(String s, int numRows) {
		
		int strLength = s.length();
		int rowIndex = 0;
		int startIndex = 0, nextIndex = 0;
		int lastStartIndex = 0;
		boolean ndnuMode = true;
		StringBuilder finalString = new StringBuilder();
		// empty string testcase
		// numRows = 0 testcase
		if(strLength == 0 || numRows == 0) {
			return "";
		}
		
		if(numRows == 1) {
			return s;
		}
		
		// equal to the number of rows
		while(rowIndex < numRows) {
			// Calculating indices to traverse - startIndex, nextIndex			
			// adding first character of the string for each row
			
			// Useful check when strLength < numRows
			if(startIndex<strLength)
				finalString.append(s.charAt(startIndex));
			
			lastStartIndex = startIndex;
			
			if(rowIndex == 0) {
				nextIndex = ndnu(startIndex,numRows,rowIndex);
				while(startIndex<strLength && nextIndex<strLength) {
					finalString.append(s.charAt(nextIndex));
					startIndex = nextIndex;
					nextIndex = ndnu(startIndex,numRows,rowIndex);
				}
			} else if(rowIndex == numRows - 1) {
				nextIndex = nund(startIndex,rowIndex);
				while(startIndex<strLength && nextIndex<strLength) {
					finalString.append(s.charAt(nextIndex));
					startIndex = nextIndex;
					nextIndex = nund(startIndex,rowIndex);
				}
			} else {
				// alternate between ndnu and nund, starting with ndnu
				nextIndex = ndnu(startIndex,numRows,rowIndex);
				ndnuMode = !ndnuMode;
				while(startIndex<strLength && nextIndex<strLength) {
					if(ndnuMode) {
						finalString.append(s.charAt(nextIndex));
						startIndex = nextIndex;
						nextIndex = ndnu(startIndex,numRows,rowIndex);
						ndnuMode = !ndnuMode;
					}
					else {
						finalString.append(s.charAt(nextIndex));
						startIndex = nextIndex;
						nextIndex = nund(startIndex,rowIndex);
						ndnuMode = !ndnuMode;
					}
				}
				
					
			}
				
			startIndex = lastStartIndex + 1;
			rowIndex++;
			ndnuMode = true;
			
		}
		
		return finalString.toString();
	}
	
	/**
	 * 
	 * @param x - StartIndex
	 * @param n - NumRows
	 * @param i - row index
	 * @return
	 */
	private int ndnu(int x, int n, int i) {
		return x + 2*(n-i-1);
	}
	
	private int nund(int x, int i) {
		return x + 2*i;
	}

}
