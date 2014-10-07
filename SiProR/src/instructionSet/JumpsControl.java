package instructionSet;
import core.CU;

/** 
 * This class will contain instructions that
 * handle "jumps" and control functions of the CPU.
 * author Roberto E. Cruz Quesada
 */
public class JumpsControl {

	/**
	 * This method performs a jump using a register's content.
	 * The PC is updated using the content of the register
	 * in the parameter.
	 * @param regNumber - the number of the register being used. 
	 */
	public static void jmpr(int regNumber){
		CU.pc = CU.reg[regNumber];
	}
	
	/**
	 * This method performs a jump using an address' content.
	 * The PC is updated using the content of the address 
	 * in the parameter.
	 * @param memIndex - the number representation of the address being used. 
	 */
	public static void jmpa(int memIndex){
		CU.pc = memIndex;
	}
	
	/**
	 * This method utilizes the "cond" variable to
	 * permit, or not, a jump using a register's content. 
	 * If the "cond" variable is equal to zero, 
	 * the "nop()" method is called.
	 * @param regNumber - the number of the register being used.
	 */
	public static void jcr(int regNumber){
		if(CU.cond != 0)
		{
			jmpr(regNumber);	// Since this is basically a jump using a register, call "jmpr".
		}
		else
		{
			nop();				// Condition was not met, do nothing. Go to next instruction.
		}
	}
	
	/**
	 * This method utilizes the "cond" variable to
	 * permit, or not, a jump using an address' content. 
	 * If the "cond" variable is equal to zero, 
	 * the "nop()" method is called.
	 * @param memIndex - the number representation of the address being used.
	 */
	public static void jca(int memIndex){
		if(CU.cond != 0)
		{
			jmpa(memIndex);		// Since this is basically a jump using an address, call "jmpa".
		}
		else
		{
			nop();				// Condition was not met, do nothing. Go to next instruction.
		}
	}
	
	/**
	 * This method provides a loop wherein the PC will not move
	 * to the next instruction until the value of the register's
	 * content is zero.
	 * @param regNumber - the number for the register who's content will whether the loop will end or not.
	 * @param memIndex - the number representation of the address to be used.
	 */
	public static void loop(int regNumber, int memIndex){
		CU.reg[regNumber] = CU.reg[regNumber-1]; // Decrease the value of the register's content by 1.
		
		while(CU.reg[regNumber] !=0)			 // While this value is not zero...
		{
			CU.reg[regNumber]--;				     // Decrease the value by 1 again.
		}
		CU.pc = CU.mem[memIndex];				   // Once the value is zero, update the PC accordingly.
	}
	
	/**
	 * This method checks if the first register (in the first parameter)
	 * is greater than the second register (in the second parameter).
	 * Returns false if it's not greater.
	 * @param regNumber1 - the number representing the first register.
	 * @param regNumber2 - the number representing the second register.
	 */
	public static void gr(int regNumber1, int regNumber2){
		if(CU.reg[regNumber1] > CU.reg[regNumber2]) // If the value in register1 is greater than the value in register2...
		{											
			CU.cond = 1;
		}
		else										// Otherwise...
		{
			CU.cond = 0;
		}
	}
	
	/**
	 * This method checks if the first register (in the first parameter)
	 * is greater or equal to the second register (in the second parameter).
	 * Returns false if both conditions are not true.
	 * @param regNumber1 - the number representing the first register.
	 * @param regNumber2 - the number representing the second register.
	 */
	public static void gre(int regNumber1, int regNumber2){
		if(CU.reg[regNumber1] > CU.reg[regNumber2] | CU.reg[regNumber1] == CU.reg[regNumber2])
		{
			CU.cond = 1;		// Return true if only one of the two conditions is met.
		}
		else
		{
			CU.cond = 0;
		}
	}
	
	/**
	 * This method checks if two registers are equal.
	 * Returns false if they are not.
	 * @param regNumber1 - the number representing the first register.
	 * @param regNumber2 - the number representing the second register.
	 */
	public static void eq(int regNumber1, int regNumber2){
		if(CU.reg[regNumber1] == (CU.reg[regNumber2]))  // If the value in register1 is the same as the value of register2...
		{												
			CU.cond = 1;
		}
		else											// Otherwise...
		{
			CU.cond = 0;
		}
	}
	
	/** 
	 * This method checks if two registers are not equal.
	 * Returns false if they are equal.
	 * @param regNumber1 - the number representing the first register.
	 * @param regNumber2 - the number representing the second register.
	 */
	public static void neq(int regNumber1, int regNumber2){
		if(CU.reg[regNumber1] != CU.reg[regNumber2])	// If the value in register1 is not the same as the value of register2...
		{										
			CU.cond = 1;
		}
		else									// Otherwise...
		{
			CU.cond = 0;
		}
	}
	
	/**
	 * This method performs a "no operation" instruction,
	 * essentially "doing nothing" except a CPU clock cycle or the such.
	 */
	public static void nop(){
		/* 
		 * Apparently, writing "{}" acts the same as "no operation".
		 */
		{}
	}
	
	/**
	 * This method stops execution.
	 */
	public static void stop(){
		System.exit(0);     // Immediately stops execution of the program.
	}
}
