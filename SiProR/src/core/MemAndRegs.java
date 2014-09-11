package core;
/* This class contains the memory of the microprocessor,
 * the registers R0-R7, and the condition variable, program
 * counter and instruction register. 
 */
public class MemAndRegs {
	public static int[] mem = new int[2000];
	public static int[] reg = new int[8];
	
	public static int pc=0;
	public static int ir=0;
	public static int cond = 0;
	
	
	
}
