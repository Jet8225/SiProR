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
	
	public static void shr(String ra, String rb, int rc) {
		
	}
}
