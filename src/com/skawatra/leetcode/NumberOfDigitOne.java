package com.skawatra.leetcode;

public class NumberOfDigitOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countDigitOne(100));
	}
	
	public static int countDigitOne(int n) {
		int count  = 0;
		int restOfNumber = 0, currentDigit = 0, digitPlace = -1,lastDigit = 0;
		while(n>0) {
			
			currentDigit = n%10;
			digitPlace++;
			if(digitPlace > 0)
				restOfNumber = 10*restOfNumber + lastDigit;
			
			// 2 parts to it
			// calculate number of ones in current digitPlace
			// add to the count for the last digitPlace
			
			if (currentDigit < 1) {
				if (digitPlace>0) { 
					count += tenRaisedTo(digitPlace);
					count += restOfNumber;
				}
			} else if (currentDigit == 1) {
				
				count += restOfNumber + 1;
				
				if(digitPlace > 0)
					count += currentDigit*(tenRaisedTo(digitPlace-1));
				
			} else {
				count += tenRaisedTo(digitPlace);
				if(digitPlace > 0)
					count += currentDigit*(tenRaisedTo(digitPlace-1));
			}
			
			n = n/10;
			lastDigit = currentDigit;
		}
		
		return count;
	}
	
	public static int tenRaisedTo(int n) {
		int finalNumber = 1;
		for(int i=0;i<n;i++) {
			finalNumber = finalNumber*10;
		}
		return finalNumber;
	}

}
