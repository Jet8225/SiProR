package core;

import gui.CodeReader;
/**
 * This class is in charge of the management of the memory.
 * @author Keysha Gonzalez
 */
public class Memory {
	private static String[][] partialMem;
	
	/**
	 * References the global memory array to the display memory array.
	 * @param partial the memory bi-dimensional array
	 */
	public static void setDisplayMemory(String[][] partial){
		partialMem = partial;
	}
	
	/**
	 * Gets the array with the memory content.
	 * @return the memory array
	 */
	public static String[][] getMemoryContent(){
		return partialMem;
	}
	
	/**
	 * Returns the amount of rows on the memory array.
	 * @return size
	 */
	public static int getMemoryRows(){
		return partialMem.length;
	}
	
	/**
	 * Copies the file's content to the memory array.
	 * @param file_data the file content object
	 * @param mem_data the memory array
	 */
	public static void CopyToMemory(CodeReader file_data, String[][] mem_data){
		
		for(int i = 0, j = 0; i < mem_data.length && j < file_data.getSize(); i++, j++){
			mem_data[i][1] = file_data.getFileContent().get(j);
		}
		
		for(int i = 0; i < mem_data.length; i++){	
			mem_data[i][1] = ("0000" + mem_data[i][1]).substring(mem_data[i][1].length());
		}
	}
	
	/**
	 * Cleans the memory array to it's original state.
	 * @param mem_data the memory array to be cleaned
	 */
	public static void ClearMemory(String[][] mem_data){
		for(int i = 0; i < mem_data.length;i++){
			mem_data[i][1] = "";
		}
	}
}
