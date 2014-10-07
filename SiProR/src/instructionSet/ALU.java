package instructionSet;
/* This class contains the functions that make up
 * the Arithmetic Logic Unit(ALU). That is classes
 * that perform math operations and that perform
 * logic operations on the registers. Included are
 * also methods that shift or rotate the data in 
 * the registers.
 */

import core.CU;

public class ALU {
	
	/**
	 * Performs the Sum between two registers content and stores the result on another register.
	 * R[ra]<=R[rb]+R[rc]
	 * @author Keysha Gonzalez
	 * @param regNumber content in Ra
	 * @param regNumber2 content in Rb
	 * @param regNumber3 content in Rc
	 */
	public static void add(int regNumber, int regNumber2, int regNumber3){
		CU.reg[regNumber] = CU.reg[regNumber2] + CU.reg[regNumber3];
	}
	
	/**
	 * Performs the Subtraction between two registers content and stores the result on another register.
	 * R[ra]<=R[rb]-R[rc]
	 * @author Keysha Gonzalez
	 * @param regNumber
	 * @param regNumber2
	 * @param regNumber3
	 */
	public static void sub(int regNumber, int regNumber2, int regNumber3){
		CU.reg[regNumber] = CU.reg[regNumber2] - CU.reg[regNumber3];
	}
	
	/**
	 * Performs the Sum between a register content and a constant and stores the result on R1. 
	 * R[1]<=R[ra]+constant
	 * @author Keysha Gonzalez
	 * @param regNumber
	 * @param constant
	 */
	public static void adi(int regNumber, int constant){
		CU.reg[1] = CU.reg[regNumber] + constant;
	}
	
	/**
	 * Performs the Subtract between a register content and a constant and stores the result on R1. 
	 * R[1]<=R[ra]-constant
	 * @author Keysha Gonzalez
	 * @param regNumber
	 * @param constant
	 */
	public static void sbi(int regNumber, int constant){
		CU.reg[1] = CU.reg[regNumber] - constant;
	}
	
	/**
	 * Performs the bitwise AND operation between two registers content and stores the result on another register.
	 * R[ra]<=R[rb]&R[rc]
	 * @author Keysha Gonzalez
	 * @param regNumber
	 * @param regNumber2
	 * @param regNumber3
	 */
	public static void and(int regNumber, int regNumber2, int regNumber3){
		CU.reg[regNumber] = CU.reg[regNumber2] & CU.reg[regNumber3];
	}
	
	/**
	 * Performs the bitwise OR operation between two registers content and stores the result on another register.
	 * R[ra]<=R[rb]|R[rc] 
	 * @author Keysha Gonzalez
	 * @param regNumber
	 * @param regNumber2
	 * @param regNumber3
	 */
	public static void or(int regNumber, int regNumber2, int regNumber3){
		CU.reg[regNumber] = CU.reg[regNumber2] | CU.reg[regNumber3];
	}
	
	/**
	 * Performs the bitwise XOR operation between two registers content and stores the result on another register.
	 * R[ra]<=R[rb]^R[rc]
	 * @author Keysha Gonzalez
	 * @param regNumber
	 * @param regNumber2
	 * @param regNumber3
	 */
	public static void xor(int regNumber, int regNumber2, int regNumber3){
		CU.reg[regNumber] = CU.reg[regNumber2] ^ CU.reg[regNumber3];
	}
	
	/**
	 * Performs the bitwise NOT operation of a register's content and stores the result on another register.
	 * R[ra]<=~R[rb]
	 * @author Keysha Gonzalez
	 * @param regNumber
	 * @param regNumber2
	 */
	public static void not(int regNumber, int regNumber2){
		CU.reg[regNumber] = ~CU.reg[regNumber2];
		
	}
	
	/**
	 * Performs the negation of a register's content and stores the result on another register.
	 * R[ra]<=-R[rb]
	 * @author Keysha Gonzalez
	 * @param regNumber 
	 * @param regNumber2
	 */
	public static void neg(int regNumber, int regNumber2){
		CU.reg[regNumber] = (-1)*CU.reg[regNumber2];
	}
	
	public static void shr(int ra, int rb, int rc) {
		String corrector = "";
		String RB = Integer.toBinaryString(CU.reg[rb]);
		
		if(RB.length() != 8) {
			for(int i=0; i<8-RB.length(); i++) {
				corrector= corrector+0; 
			}
		}
		
		RB = corrector + RB;
		
		for(int i=0; i<CU.reg[rc]; i++) {
			RB = 1+RB;
		}
		RB = RB.substring(0,7);
		
		CU.reg[ra] = Integer.parseInt(RB,2);
	}
	
	public static void shl(int ra, int rb, int rc) {
		String corrector = "";
		String RB = Integer.toBinaryString(CU.reg[rb]);
		
		if(RB.length() != 8) {
			for(int i=0; i<8-RB.length(); i++) {
				corrector= corrector+0; 
			}
		}
		
		RB = corrector + RB;
		
		for(int i=0; i<CU.reg[rc]; i++) {
			RB = RB+0;
		}
		
		RB = RB.substring(RB.length()-8, RB.length());
		
		CU.reg[ra] = Integer.parseInt(RB,2);
	}
	
	public static void rtr(int ra, int rb, int rc) {
		String corrector = "";
		String RB = Integer.toBinaryString(CU.reg[rb]);
		char temp;
		
		if(RB.length() != 8) {
			for(int i=0; i<8-RB.length(); i++) {
				corrector= corrector+0; 
			}
		}
		
		RB = corrector + RB;
		
		for(int i=0; i<CU.reg[rc]; i++) {
			temp = RB.charAt(7);
			RB = temp+RB;
		}
		
		RB = RB.substring(0,7);
		
		CU.reg[ra] = Integer.parseInt(RB,2);
	}
	
	public static void rtl(int ra, int rb, int rc) {
		String corrector = "";
		String RB = Integer.toBinaryString(CU.reg[rb]);
		char temp;
		
		if(RB.length() != 8) {
			for(int i=0; i<8-RB.length(); i++) {
				corrector= corrector+0; 
			}
		}
		
		RB = corrector + RB;
		
		for(int i=0; i<CU.reg[rc];i++) {
			temp = RB.charAt(0);
			RB = RB.substring(1) +temp;
		}
		
		CU.reg[ra] = Integer.parseInt(RB,2);
	}
}
