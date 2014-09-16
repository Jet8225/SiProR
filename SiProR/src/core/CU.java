package core;

import java.util.List;
import instructionSet.ALU;
import instructionSet.DataMovement;
import instructionSet.JumpsControl;

/* This class contains the memory of the microprocessor,
 * the registers R0-R7, and the condition variable, program
 * counter and instruction register. 
 */

public class CU{
	/* indice 0 es para el programa
	 * indice 128 para el teclado
	 * indice 130 para entrada paralela
	 * indice 132 para salida paralela
	 * indices 136-139 para diplay hexadecimal
	 * incices 140-155 para el display ASCII
	 */
	public static int[] mem = new int[2000];
	
	List<String> results;
	
	
	public static String[][] mem_data;
	
	/* R0 siempre tiene 0
	 * R1 es acumulador
	 */
	public static int[] reg = new int[8];
	
	/* no puede pasar de 2^11 */
	public static int pc=0;
	/*no puede se mayor que 16 characteres*/
	public static String ir="";
	/* no puede ser mayor de 1*/
	public static int cond = 0;
	
	
	// Variables to divided to instruction into segments
	private static String opCode=""; 
	private static String Ra = "";
	private static String Rb = "";
	private static String Rc = "";
	private static String address="";
	private static String constant="";
	
	public CU(String op,String[][] mems){
		this.mem_data = mems;
		this.copyData(mems, mem);
		this.results = CU.executeCode(op);
	}
	
	public void copyData(String[][] sMem, int[] nMem){
        for(int i = 0; i < sMem.length && i < nMem.length;i+=2){
            nMem[i] = Integer.parseInt(sMem[i][1].substring(0,1),16);
            nMem[i+1] = Integer.parseInt(sMem[i][1].substring(2,3),16);
        }
        mem = nMem;
    }
	
	public List<String> getResults(){
		return this.results;
	}
	
	public static List<String> executeCode(String op){
		if(op.equals("Run")){
			int i = 0;
			while( i < mem_data.length ){
				CU.fetch(pc);
				CU.decode(ir);
				CU.execute();
				i++;
			}
			
			Registers.setValues(pc, ir, reg);
			
			return Registers.getValues();
		}
		else if(op.equals("Step")){
			CU.fetch(pc);
			CU.decode(ir);
			CU.execute();
			
			Registers.setValues(pc, ir, reg);
			
			return Registers.getValues();
		}
		return null;
	}
	
	static void fetch (int pc) {
		String corrector = "";
		String instruction1 = Integer.toBinaryString(mem[pc]);
		String instruction2 = Integer.toBinaryString(mem[pc+1]);
		
		if(instruction1.length() != 8) {
			for(int i=0; i<8-instruction1.length(); i++) {
				corrector= corrector+0; 
			}
		}
		instruction1 = corrector + instruction1;
		corrector = "";
		
		if(instruction2.length() != 8) {
			for(int i=0; i<8-instruction2.length(); i++) {
				corrector= corrector+0; 
			}
		}
		instruction2 = corrector +instruction2;
		
		ir = instruction1+instruction2;
	}
	
	static void decode (String ir) {
		// increment program counter
		pc +=2;
		
		opCode = ir.substring(0,4);
		
		if(Integer.parseInt(opCode, 2)==0) {
			Ra = ir.substring(5,7);
			address = ir.substring(8);	
		}
		else if(Integer.parseInt(opCode, 2)==1) {
			Ra = ir.substring(5,7);
			constant = ir.substring(8);
		}
		else if(Integer.parseInt(opCode, 2)==2) {
			constant = ir.substring(5);
		}
		else if(Integer.parseInt(opCode, 2)==3) {
			Ra = ir.substring(5,7);
			address = ir.substring(8);	
		}
		else if(Integer.parseInt(opCode, 2)==4) {
			address = ir.substring(5);
		}
		else if(Integer.parseInt(opCode, 2)==5) {
			Ra = ir.substring(5,7);
			Rb = ir.substring(8,10);
		}
		else if(Integer.parseInt(opCode, 2)==6) {
			Ra = ir.substring(5,7);
			Rb = ir.substring(8,10);
		}
		else if(Integer.parseInt(opCode, 2)==7) {
			Ra = ir.substring(5,7);
			Rb = ir.substring(8,10);
			Rc = ir.substring(11,13);
		}
		else if(Integer.parseInt(opCode, 2)==8) {
			Ra = ir.substring(5,7);
			Rb = ir.substring(8,10);
			Rc = ir.substring(11,13);
		}
		else if(Integer.parseInt(opCode, 2)==9) {
			Ra = ir.substring(5,7);
			constant = ir.substring(8);
		}
		else if(Integer.parseInt(opCode, 2)==10) {
			Ra = ir.substring(5,7);
			constant = ir.substring(8);
		}
		else if(Integer.parseInt(opCode, 2)==11) {
			Ra = ir.substring(5,7);
			Rb = ir.substring(8,10);
			Rc = ir.substring(11,13);
		}
		else if(Integer.parseInt(opCode, 2)==12) {
			Ra = ir.substring(5,7);
			Rb = ir.substring(8,10);
			Rc = ir.substring(11,13);
		}
		else if(Integer.parseInt(opCode, 2)==13) {
			Ra = ir.substring(5,7);
			Rb = ir.substring(8,10);
			Rc = ir.substring(11,13);
		}
		else if(Integer.parseInt(opCode, 2)==14) {
			Ra = ir.substring(5,7);
			Rb = ir.substring(8,10);
		}
		else if(Integer.parseInt(opCode, 2)==15) {
			Ra = ir.substring(5,7);
			Rb = ir.substring(8,10);
			Rc = ir.substring(11,13);
		}
		else if(Integer.parseInt(opCode, 2)==16) {
			Ra = ir.substring(5,7);
			Rb = ir.substring(8,10);
			Rc = ir.substring(11,13);
		}
		else if(Integer.parseInt(opCode, 2)==17) {
			Ra = ir.substring(5,7);
			Rb = ir.substring(8,10);
			Rc = ir.substring(11,13);
		}
		else if(Integer.parseInt(opCode, 2)==18) {
			Ra = ir.substring(5,7);
			Rb = ir.substring(8,10);
			Rc = ir.substring(11,13);
		}
		else if(Integer.parseInt(opCode, 2)==19) {
			Ra = ir.substring(5,7);
			Rb = ir.substring(8,10);
			Rc = ir.substring(11,13);
		}
		else if(Integer.parseInt(opCode, 2)==20) {
			Ra = ir.substring(5,7);
			
		}
		else if(Integer.parseInt(opCode, 2)==21) {
			address = ir.substring(5);
		}
		else if(Integer.parseInt(opCode, 2)==22) {
			Ra = ir.substring(5,7);
		}
		else if(Integer.parseInt(opCode, 2)==23) {
			address = ir.substring(5);
		}
		else if(Integer.parseInt(opCode, 2)==24) {
			Ra = ir.substring(5,7);
			address = ir.substring(8);
		}
		else if(Integer.parseInt(opCode, 2)==25) {
			Ra = ir.substring(5,7);
			Rb = ir.substring(8,10);
			
		}
		else if(Integer.parseInt(opCode, 2)==26) {
			Ra = ir.substring(5,7);
			Rb = ir.substring(8,10);
			
		}
		else if(Integer.parseInt(opCode, 2)==27) {
			Ra = ir.substring(5,7);
			Rb = ir.substring(8,10);
			
		}
		else if(Integer.parseInt(opCode, 2)==28) {
			Ra = ir.substring(5,7);
			Rb = ir.substring(8,10);
			
		}
		else if(Integer.parseInt(opCode, 2)==29) {
			;
		}
		else if(Integer.parseInt(opCode, 2)==30) {
			;
		}
	}
	
	static void execute() {
		if(Integer.parseInt(opCode, 2)==0) {
			DataMovement.ld(Integer.parseInt(Ra,2), Integer.parseInt(address,2));
		}
		else if(Integer.parseInt(opCode, 2)==1) {
			DataMovement.ldi(Integer.parseInt(Ra,2), Integer.parseInt(constant,2));
		}
		else if(Integer.parseInt(opCode, 2)==2) {
			DataMovement.ldacc(Integer.parseInt(constant,2));
		}
		else if(Integer.parseInt(opCode, 2)==3) {
			DataMovement.st(Integer.parseInt(address,2), Integer.parseInt(Ra,2));
		}
		else if(Integer.parseInt(opCode, 2)==4) {
			DataMovement.stacc(Integer.parseInt(address,2));
		}
		else if(Integer.parseInt(opCode, 2)==5) {
			DataMovement.ldr(Integer.parseInt(Ra,2), Integer.parseInt(Rb));
		}
		else if(Integer.parseInt(opCode, 2)==6) {
			DataMovement.str(Integer.parseInt(Ra,2), Integer.parseInt(Rb,2));
		}
		else if(Integer.parseInt(opCode, 2)==7) {
			ALU.add(Integer.parseInt(Ra,2), Integer.parseInt(Rb,2), Integer.parseInt(Rc,2));
		}
		else if(Integer.parseInt(opCode, 2)==8) {
			ALU.sub(Integer.parseInt(Ra,2), Integer.parseInt(Rb,2), Integer.parseInt(Rc,2));
		}
		else if(Integer.parseInt(opCode, 2)==9) {
			ALU.adi(Integer.parseInt(Ra,2), Integer.parseInt(constant,2));
		}
		else if(Integer.parseInt(opCode, 2)==10) {
			ALU.sbi(Integer.parseInt(Ra,2), Integer.parseInt(constant,2));
		}
		else if(Integer.parseInt(opCode, 2)==11) {
			ALU.and(Integer.parseInt(Ra,2), Integer.parseInt(Rb,2), Integer.parseInt(Rc,2));
		}
		else if(Integer.parseInt(opCode, 2)==12) {
			ALU.or(Integer.parseInt(Ra,2), Integer.parseInt(Rb,2), Integer.parseInt(Rc,2));
		}
		else if(Integer.parseInt(opCode, 2)==13) {
			ALU.xor(Integer.parseInt(Ra,2), Integer.parseInt(Rb,2), Integer.parseInt(Rc,2));
		}
		else if(Integer.parseInt(opCode, 2)==14) {
			ALU.not(Integer.parseInt(Ra,2), Integer.parseInt(Rb,2));
		}
		else if(Integer.parseInt(opCode, 2)==15) {
			ALU.neg(Integer.parseInt(Ra,2), Integer.parseInt(Rb,2));
		}
		else if(Integer.parseInt(opCode, 2)==16) {
			ALU.shr(Integer.parseInt(Ra,2), Integer.parseInt(Rb,2), Integer.parseInt(Rc,2));
		}
		else if(Integer.parseInt(opCode, 2)==17) {
			ALU.shl(Integer.parseInt(Ra,2), Integer.parseInt(Rb,2), Integer.parseInt(Rc,2));
		}
		else if(Integer.parseInt(opCode, 2)==18) {
			ALU.rtr(Integer.parseInt(Ra,2), Integer.parseInt(Rb,2), Integer.parseInt(Rc,2));
		}
		else if(Integer.parseInt(opCode, 2)==19) {
			ALU.rtl(Integer.parseInt(Ra,2), Integer.parseInt(Rb,2), Integer.parseInt(Rc,2));
		}
		else if(Integer.parseInt(opCode, 2)==20) {
			JumpsControl.jmpr(Integer.parseInt(Ra,2));
		}
		else if(Integer.parseInt(opCode, 2)==21) {
			JumpsControl.jmpa(Integer.parseInt(address,2));
		}
		else if(Integer.parseInt(opCode, 2)==22) {
			JumpsControl.jcr(Integer.parseInt(Ra,2));
		}
		else if(Integer.parseInt(opCode, 2)==23) {
			JumpsControl.jca(Integer.parseInt(address,2));
		}
		else if(Integer.parseInt(opCode, 2)==24) {
			JumpsControl.loop(Integer.parseInt(Ra,2), Integer.parseInt(address,2));
		}
		else if(Integer.parseInt(opCode, 2)==25) {
			JumpsControl.gr(Integer.parseInt(Ra,2), Integer.parseInt(Rb,2));
		}
		else if(Integer.parseInt(opCode, 2)==26) {
			JumpsControl.gre(Integer.parseInt(Ra,2), Integer.parseInt(Rb,2));
		}
		else if(Integer.parseInt(opCode, 2)==27) {
			JumpsControl.eq(Integer.parseInt(Ra,2), Integer.parseInt(Rb,2));
		}
		else if(Integer.parseInt(opCode, 2)==28) {
			JumpsControl.neq(Integer.parseInt(Ra,2), Integer.parseInt(Rb,2));
		}
		else if(Integer.parseInt(opCode, 2)==29) {
			JumpsControl.nop();
		}
		else if(Integer.parseInt(opCode, 2)==30) {
			JumpsControl.stop();
		}
	}
	
}
