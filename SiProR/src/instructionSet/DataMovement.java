package instructionSet;
/* This class will contain instructions that move 
 * data into registers or into memory. 
 */
import core.MemAndRegs;

public class DataMovement {
	
	public static void load(int regNumber, int memIndex) {
		MemAndRegs.reg[regNumber] = MemAndRegs.mem[memIndex];	
	}
	
	public static void loadImmediate(int regNumber, int constant) {
		MemAndRegs.reg[regNumber] = constant;
	}
	
	public static void loadAcc(int constant) {
		MemAndRegs.reg[1] = constant;
	}
	
	public static void store(int memIndex, int regNumber) {
		MemAndRegs.mem[memIndex] = MemAndRegs.reg[regNumber];
	}
	
	public static void storeAcc(int memIndex) {
		MemAndRegs.mem[memIndex] = MemAndRegs.reg[1];
	}
	
	public static void loadR(int regNumber, int memIndex) {
		MemAndRegs.reg[regNumber] = MemAndRegs.mem[memIndex];
	}
	
	public static void storeR(int memIndex, int regNumber) {
		MemAndRegs.mem[memIndex] = MemAndRegs.reg[regNumber];
	}
	
}
