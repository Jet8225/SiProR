package core;

import java.util.ArrayList;
import java.util.List;

public class Registers {
	
	private static int prog_count;
	private static String instruc_r;
	private static int[] regis;
	
	public static void setValues(int pc, String ir, int[] regs){
		prog_count = pc;
		instruc_r = ir;
		regis = regs;	
	}

	public static List<String> getValues(){
		List<String> results = new ArrayList<String>();
		
		results.add("" + prog_count);
		results.add(instruc_r);
		
		for(int i = 0; i < regis.length; i++){
			results.add("" + regis[i]);
		}
		
		return results;
	}
}
