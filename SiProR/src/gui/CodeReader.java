package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * This class is in charge of opening and managing the files.
 * @author Keysha Gonzalez
 * */

public class CodeReader implements ActionListener{
	private String fileDirectory;
	private Boolean exist = false;
	private List<String> code = new ArrayList<String>();
	
	public CodeReader(){
		
	}
	
	/**
	 * Specifies the name of the file to be read.
	 * @param fileName
	 */
	public void setFileDirectory(String fileDirectory){
		this.fileDirectory = fileDirectory;
	}

	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!fileDirectory.equals("") && fileDirectory != null){
			try{
				File folder = new File(fileDirectory);
				try
				{
					BufferedReader reader = new BufferedReader(new FileReader(folder.getPath()));
					String line;
					
					while ((line = reader.readLine()) != null)
					{
						this.code.add(line);
					}
					reader.close();
					exist = true;
				}
			    catch (Exception ex)
			    {
			    	System.err.format("Exception occurred trying to read the file.");
			    }
			}
			catch(Exception ex){
				
			}
		}
	}
	
	public Boolean fileExist(){
		return exist;
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
