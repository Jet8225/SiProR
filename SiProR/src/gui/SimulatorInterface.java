package gui;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class SimulatorInterface extends JFrame{
	private static final long serialVersionUID = 1L;
	
	/*Main Panels*/
	private JPanel reg_panel = new JPanel(new GridLayout(10,2,5,5));
	private JPanel right_panel = new JPanel(new GridLayout(2,1));
	private JPanel mem_panel = new JPanel(new GridLayout(1,2,5,5));
	private JPanel per_panel = new JPanel(new GridLayout(5,2,5,5));
	private JPanel buttons_panel = new JPanel();
	
	private JPanel main_panel = new JPanel(new GridLayout(0,2));
	
	/*Text Fields*/
	private JTextField[] regs = new JTextField[10];
	private JTextField keyb = new JTextField();
	private JTextField a_disp = new JTextField();
	private JTextField h_disp = new JTextField();
	private JTextField parallel_in = new JTextField();
	private JTextField parallel_out = new JTextField();
	private JTextArea memory = new JTextArea();
	
	/*Buttons*/
	private JButton load = new JButton("Load");
	private JButton run = new JButton("Run");
	private JButton step = new JButton("Step");
	private JButton exit = new JButton("Exit");
	
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
		
		this.add(this.main_panel);
		this.add(this.buttons_panel);
		
		this.setVisible(true);
		this.setMinimumSize(new Dimension(500,575));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
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
	
	private void memory(){
		
		JScrollPane scroll = new JScrollPane (memory, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.mem_panel.add(new JLabel("Memory"));
		this.mem_panel.add(scroll);
	}
	
	private void buttons(){
		this.buttons_panel.setBorder(new EmptyBorder(25,50,25,50));
		
		
		this.buttons_panel.add(this.load);
		this.buttons_panel.add(this.run);
		this.buttons_panel.add(this.step);
		this.buttons_panel.add(this.exit);
	}
	
}
