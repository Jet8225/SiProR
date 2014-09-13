package instructionSet;
/* This class will contain instructions that move 
 * data into registers or into memory. 
 */
import core.CU;

public class DataMovement {
	
	public static void ld(int regNumber, int memIndex) {
		CU.reg[regNumber] = CU.mem[memIndex];	
	}
	
	public static void ldi(int regNumber, int constant) {
		CU.reg[regNumber] = constant;
	}
	
	public static void ldacc(int constant) {
		CU.reg[1] = constant;
	}
	
	public static void st(int memIndex, int regNumber) {
		CU.mem[memIndex] = CU.reg[regNumber];
	}
	
	public static void stadcc(int memIndex) {
		CU.mem[memIndex] = CU.reg[1];
	}
	
	public static void ldr(int regNumber, int memIndex) {
		CU.reg[regNumber] = CU.mem[memIndex];
	}
	
	public static void str(int memIndex, int regNumber) {
		CU.mem[memIndex] = CU.reg[regNumber];
	}
	
}
