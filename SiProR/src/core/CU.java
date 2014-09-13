package core;

import gui.SimulatorInterface;
import instructionSet.DataMovement;

/* This class contains the memory of the microprocessor,
 * the registers R0-R7, and the condition variable, program
 * counter and instruction register. 
 */
public class CU {
	/* indice 0 es para el programa
	 * indice 128 para el teclado
	 * indice 130 para entrada paralela
	 * indice 132 para salida paralela
	 * indices 136-139 para diplay hexadecimal
	 * incices 140-155 para el display ASCII
	 */
	public static int[] mem = new int[2000];
	
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
	
	public static void main (String args[]) {
		
		// Create a new SimulatorInterface
        new SimulatorInterface();
		
		
		/* cuando se haga load leer el file y pasar a memoria */
		
		
		/* cuando haga run o step */
		/* se hace una condici�n para determinar si est� en step o run*/
		
		while(true) {
			fetch(pc);
			/* action listener dentro de una condici�n */
			decode(ir);
			/* action listener dentro de una condicion */
			execute();
			/* action listener dentro de una condici�n */ 
		}
	}
	
	
	static void fetch (int pc) {
		String corrector = "";
		String instruction = Integer.toBinaryString(mem[pc]);
		
		if(instruction.length() != 16) {
			for(int i=0; i<16-instruction.length(); i++) {
				corrector= corrector+0; 
			}
		}
		ir = corrector + instruction;
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
			
		}
		else if(Integer.parseInt(opCode, 2)==30) {
			
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
			DataMovement.st(Integer.parseInt(address), Integer.parseInt(Ra,2));
		}
		else if(Integer.parseInt(opCode, 2)==4) {
			DataMovement.stacc(Integer.parseInt(address,2));
		}
		else if(Integer.parseInt(opCode, 2)==5) {
			DataMovement.ldr(Integer.parseInt(Ra,2), Integer.parseInt(Rb));
		}
		else if(Integer.parseInt(opCode, 2)==6) {
			DataMovement.str(Integer.parseInt(Ra), Integer.parseInt(Rb));
		}
		else if(Integer.parseInt(opCode, 2)==7) {
			
		}
		else if(Integer.parseInt(opCode, 2)==8) {
			
		}
		else if(Integer.parseInt(opCode, 2)==9) {
			
		}
		else if(Integer.parseInt(opCode, 2)==10) {
			
		}
		else if(Integer.parseInt(opCode, 2)==11) {
			
		}
		else if(Integer.parseInt(opCode, 2)==12) {
			
		}
		else if(Integer.parseInt(opCode, 2)==13) {
			
		}
		else if(Integer.parseInt(opCode, 2)==14) {
			
		}
		else if(Integer.parseInt(opCode, 2)==15) {
			
		}
		else if(Integer.parseInt(opCode, 2)==16) {
			
		}
		else if(Integer.parseInt(opCode, 2)==17) {
			
		}
		else if(Integer.parseInt(opCode, 2)==18) {
			
		}
		else if(Integer.parseInt(opCode, 2)==19) {
			
		}
		else if(Integer.parseInt(opCode, 2)==20) {
			
		}
		else if(Integer.parseInt(opCode, 2)==21) {
			
		}
		else if(Integer.parseInt(opCode, 2)==22) {
			
		}
		else if(Integer.parseInt(opCode, 2)==23) {
			
		}
		else if(Integer.parseInt(opCode, 2)==24) {
			
		}
		else if(Integer.parseInt(opCode, 2)==25) {
			
		}
		else if(Integer.parseInt(opCode, 2)==26) {
			
		}
		else if(Integer.parseInt(opCode, 2)==27) {
			
		}
		else if(Integer.parseInt(opCode, 2)==28) {
			
		}
		else if(Integer.parseInt(opCode, 2)==29) {
			
		}
		else if(Integer.parseInt(opCode, 2)==30) {
			
		}
	}
	
}
