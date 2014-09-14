package instructionSet;
import core.CU;

/* 
 * This class will contain instructions that
 * handle "jumps" and control functions of the CPU.
 */
public class JumpsControl {

	/*
	 * This method performs a jump using a register's content.
	 * The PC is updated using the content of the register
	 * in the parameter. 
	 */
	public static void jmpr(int regNumber){
		CU.pc = CU.reg[regNumber];
	}
	
	/*
	 * This method performs a jump using an address' content.
	 * The PC is updated using the content of the address 
	 * in the parameter. 
	 */
	public static void jmpa(int memIndex){
		CU.pc = CU.mem[memIndex];
	}
	
	/*
	 * This method utilizes the "cond" variable to
	 * permit, or not, a jump using a register's content. 
	 * If the "cond" variable is equal to zero, 
	 * the "nop()" method is called.
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
	
	/*
	 * This method utilizes the "cond" variable to
	 * permit, or not, a jump using an address' content. 
	 * If the "cond" variable is equal to zero, 
	 * the "nop()" method is called.
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
	
	/*
	 * This method provides a loop wherein the PC will not move
	 * to the next instruction until the value of the register's
	 * content is zero.
	 */
	public static void loop(int regNumber, int memIndex){
		CU.reg[regNumber] = CU.reg[regNumber-1]; // Decrease the value of the register's content by 1.
		
		while(CU.reg[regNumber] !=0)			 // While this value is not zero...
		{
			CU.reg[regNumber]--;				     // Decrease the value by 1 again.
		}
		CU.pc = CU.mem[memIndex];				   // Once the value is zero, update the PC accordingly.
	}
	
	/*
	 * This method checks if the first register (in the first parameter)
	 * is greater than the second register (in the second parameter).
	 * Returns false if it's not greater.
	 */
	public static boolean gr(int regNumber1, int regNumber2){
		if(CU.reg[regNumber1] > CU.reg[regNumber2]) // If the value in register1 is greater than the value in register2...
		{											
			return true;
		}
		else										// Otherwise...
		{
			return false;
		}
	}
	
	/*
	 * This method checks if the first register (in the first parameter)
	 * is greater or equal to the second register (in the second parameter).
	 * Returns false if both conditions are not true.
	 */
	public static boolean gre(int regNumber1, int regNumber2){
		if(CU.reg[regNumber1] > CU.reg[regNumber2] | eq(regNumber1,regNumber2) == true)
		{
			return true;		// Return true if only one of the two conditions is met.
		}
		else{
			return false;
		}
	}
	
	/*
	 * This method checks if two registers are equal.
	 * Returns false if they are not.
	 */
	public static boolean eq(int regNumber1, int regNumber2){
		if(CU.reg[regNumber1] == (CU.reg[regNumber2]))  // If the value in register1 is the same as the value of register2...
		{												
			return true;
		}
		else											// Otherwise...
		{
			return false;
		}
	}
	
	/* 
	 * This method checks if two registers are not equal.
	 * Returns false if they are equal.
	 */
	public static boolean neq(int regNumber1, int regNumber2){
		if(eq(regNumber1, regNumber2) != true)  // Call "eq" function (a bit of recursion so to speak).
		{										
			return true;						// If the "eq" function returns false, then "neq" is true.
		}
		else									// Otherwise...
		{
			return false;
		}
	}
	
	/*
	 * This method performs a "no operation" instruction,
	 * essentially "doing nothing" except a CPU clock cycle or the such.
	 */
	public static void nop(){
		/* 
		 * Apparently, writing "{}" acts the same as "no operation".
		 */
		{}
	}
	
	/*
	 * This method stops execution.
	 */
	public static void stop(){
		System.exit(0);     // Immediately stops execution of the program.
	}
	
}
