package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is in charge of opening and managing the files.
 * @author Keysha Gonzalez
 * */

public class CodeReader implements ActionListener{
	private String fileName;
	private Boolean error = false;
	private List<String> code = new ArrayList<String>();
	
	public CodeReader(){
		
	}
	
	/**
	 * Specifies the name of the file to be read.
	 * @param fileName
	 */
	public void setFileName(String fileName){
		this.fileName = fileName;
	}

	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!fileName.equals("")){
			try{
				File folder = new File("/Users/Keysha_Minel/git/SiProR/SiProR/Files");
					
				File[] listOfFiles = folder.listFiles();
					
				for(int i = 0; i < listOfFiles.length; i++){
					String filename = listOfFiles[i].getName();
					
					if(filename.equals(fileName)){
						try
						{
							BufferedReader reader = new BufferedReader(new FileReader(folder.getPath()+"/"+filename));
					    	String line;
					    	    
					    	while ((line = reader.readLine()) != null)
					    	{
					    		this.code.add(line);
					    	}
					    	reader.close();
					    	break;
					    }
					    catch (Exception ex)
					    {
					    	System.err.format("Exception occurred trying to read '%s'.", fileName);
					    	ex.printStackTrace();
					    }
					}

					else{
						error = true;
					}
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * Tells you if there was an error opening the file or not.
	 * @return true, false
	 */
	public Boolean Error(){
		return error;
	}
	
	public int getSize(){
		return this.code.size();
	}
	
	/**
	 * Gives you the content of the file.
	 * @return content of the file.
	 */
	public ArrayList<String> getFileContent(){
		return (ArrayList<String>) this.code;
	}
}
