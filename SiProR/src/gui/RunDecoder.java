package gui;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import core.CU;
import core.Memory;

/**
 * Main Class
 * @author Keysha Gonzalez
 *
 */
public class RunDecoder {
	public static void main (String args[]) {
		
		// Create a new SimulatorInterface
        new SimulatorInterface();
	}
}
/**
 * This class is in charge of providing the user interface.
 * @author Keysha Gonzalez
 *
 */
class SimulatorInterface extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	/*Main Panels*/
	private JPanel reg_panel = new JPanel(new GridLayout(10,2,5,5));
	private JPanel right_panel = new JPanel(new GridLayout(2,1));
	private JPanel mem_panel = new JPanel(new GridLayout(1,2,5,5));
	private JPanel per_panel = new JPanel(new GridLayout(5,2,5,5));
	private JPanel buttons_panel = new JPanel();
	private JPanel main_panel = new JPanel(new GridLayout(0,2));
	
	/*Text Fields*/
	protected JTextField[] regs = new JTextField[10];
	protected JTextField keyb = new JTextField();
	protected JTextField a_disp = new JTextField();
	protected JTextField h_disp = new JTextField();
	protected JTextField parallel_in = new JTextField();
	protected JTextField parallel_out = new JTextField();
	
	/*Memory*/
	protected String[] columns = {"Address", "Content"};
	
	//mem_data according to file size
	protected String[][] mem_data = new String[1000][2];
	protected JTable memory;
	protected JFrame upload_file;
	
	/*Buttons*/
	protected JButton load = new JButton("Load");
	protected JButton run = new JButton("Run");
	protected JButton step = new JButton("Step");
	protected JButton exit = new JButton("Exit");
	
	/*PopUp*/
	private JTextField fileName;
	private JButton read = new JButton("Read");
	private JButton cancel = new JButton("Cancel");
	
	/*Interface with the Control Unit*/
	CU controlUnit;
	
	/**
	 * Frame definition.
	 * @author Keysha Gonzalez
	 */
	public SimulatorInterface (){
		super ("RISC Microprocessor Simulator");
		this.setLayout(new GridLayout(2,0));
		
		this.registers();
		this.peripherals();
		this.memory();
		this.buttons();
		
		this.right_panel.add(per_panel);
		this.right_panel.add(mem_panel);
		this.right_panel.setBorder(new EmptyBorder(0,10,0,0));
		this.main_panel.setBorder(new EmptyBorder(25,50,0,50));
		this.main_panel.add(this.reg_panel);
		this.main_panel.add(this.right_panel);
		
		this.run.setEnabled(false);
		this.step.setEnabled(false);

		this.add(this.main_panel);
		this.add(this.buttons_panel);
		this.setVisible(true);
		this.setMinimumSize(new Dimension(825,825));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Arranges the registers fields on the panel.
	 */
	private void registers(){
		for(int i = 0; i < this.regs.length; i++){
			this.regs[i] = new JTextField();
		}
		this.reg_panel.add(new JLabel("PC"));
		this.reg_panel.add(this.regs[0]);
		this.reg_panel.add(new JLabel("IR"));
		this.reg_panel.add(this.regs[1]);
		for(int i = 2, j = 0; i < this.regs.length; i++, j++){
			this.reg_panel.add(new JLabel("R"+j));
			this.reg_panel.add(regs[i]);
		}
	}
	
	/**
	 * Arranges the peripherals fields on the panel.
	 */
	private void peripherals(){
		this.per_panel.setBorder(new EmptyBorder(0,0,10,0));
		this.per_panel.add(new JLabel("Keyb"));
		this.per_panel.add(keyb);
		this.per_panel.add(new JLabel("A-Disp"));
		this.per_panel.add(a_disp);
		this.per_panel.add(new JLabel("H-Disp"));
		this.per_panel.add(h_disp);
		this.per_panel.add(new JLabel("Parallel in"));
		this.per_panel.add(parallel_in);
		this.per_panel.add(new JLabel("Parallel out"));
		this.per_panel.add(parallel_out);
	}
	
	/**
	 * Arranges the memory address array on the panel.
	 */
	private void memory(){
		this.memory = new JTable(mem_data, columns){

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				if(column == 0)
					return false;
				return true;
		    }
		};
		
		int counter = 0;
		
		for(int i = 0; i < this.mem_data.length; i++){
			String hex = Integer.toHexString(counter);
			this.memory.isCellEditable(i, 0);
			counter+=2;
			
			this.mem_data[i][0] = ("0000" + hex).substring(hex.length())+":";
		}
		
		this.memory.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.memory.setTableHeader(null);
		
		
		JScrollPane scroll = new JScrollPane (memory, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.mem_panel.add(new JLabel("Memory"));
		this.mem_panel.add(scroll);
	}
	
	/**
	 * These are all the buttons that are going to be used during the running of the program.
	 */
	private void buttons(){
		this.buttons_panel.setBorder(new EmptyBorder(25,50,25,50));
		this.load.addActionListener(this);
		this.run.addActionListener(this);
		this.step.addActionListener(this);
		this.exit.addActionListener(this);
		this.buttons_panel.add(this.load);
		this.buttons_panel.add(this.run);
		this.buttons_panel.add(this.step);
		this.buttons_panel.add(this.exit);
	}
	
	/**
	 * This method is in charge of giving functionalities to the buttons that the user uses to run the program.
	 */
	public void actionPerformed(ActionEvent e) {
		CodeReader uploader = new CodeReader();
		
		if( e.getSource() == this.load ){
			this.PopUp();

			this.run.setEnabled(true);
			this.step.setEnabled(true);
		
		}
		else if(e.getSource() == this.read){
			try{
				if(fileName.getText().equals("")){
					JOptionPane.showMessageDialog(upload_file, "Please enter a file name.");
				}
				else{
					uploader.setFileName(fileName.getText());
					uploader.actionPerformed(e);
					
					if(uploader.Error() == true){
						JOptionPane.showMessageDialog(upload_file, "No such file in directory.");
					}
					else{
						upload_file.dispose();
						
						String[][] temp_mem = new String[uploader.getSize()][2];
						
						for(int i = 0; i < uploader.getSize(); i++){
							for(int j = 0; j < 2; j++){
								temp_mem[i][j] = this.mem_data[i][j];
							}
						}
						
						this.mem_data = temp_mem; 
						
						Memory.CopyToMemory(uploader, this.mem_data);
						Memory.setDisplayMemory(this.mem_data);
						
						this.memory.revalidate();
					}
				}
			}
			catch(Exception ex){
				System.err.format("Exception occurred trying to read '%s'.", fileName);
		    	ex.printStackTrace();
			}
		}
		else if(e.getSource() == this.cancel){
			this.run.setEnabled(false);
			this.step.setEnabled(false);
			upload_file.dispose();
			
		}
		else if( e.getSource() == this.run ){
			controlUnit = new CU("Run", Memory.getMemoryContent());
			
			for(int i = 0; i < this.regs.length && i < controlUnit.getResults().size(); i++){
				
				this.regs[i].setText(controlUnit.getResults().get(i));
			}
		}
		else if( e.getSource() == this.step ){
			controlUnit = new CU("Step", Memory.getMemoryContent());
			
			for(int i = 0; i < this.regs.length && i < controlUnit.getResults().size(); i++){
				
				this.regs[i].setText(controlUnit.getResults().get(i));
			}
		}
		else if( e.getSource() == this.exit ){
			this.dispose();
		}
	} 
	
	/**
	 * This method is responsible for showing the pop-up that is going to ask the user for the file name.
	 */
	private void PopUp(){
		Memory.ClearMemory(this.mem_data);
		this.memory.revalidate();
		
		upload_file = new JFrame();;
		fileName = new JTextField();
		JLabel instruction = new JLabel("Enter the file name:");
		JPanel main_panel = new JPanel(new GridLayout(3,1,5,5));
		JPanel buttons = new JPanel(new GridLayout(1,2,5,5));
		
		read = new JButton("Read");
		cancel = new JButton("Cancel");
		
		read.addActionListener(this);
		cancel.addActionListener(this);
		
		buttons.add(read);
		buttons.add(cancel);
		
		main_panel.add(instruction);
		main_panel.add(fileName);
		main_panel.add(buttons);
		
		main_panel.setBorder(new EmptyBorder(25,50,25,50));
		
		upload_file.add(main_panel);
		upload_file.setResizable(false);
		upload_file.setVisible(true);
		upload_file.setMinimumSize(new Dimension(300,200));
	}
}
