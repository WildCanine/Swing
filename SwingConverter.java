package project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
public class SwingConverter implements ActionListener{
	private JPanel inputPanel=initInputPanel();
	private JTextField inputText;
	private JTextField inputText2;
	private JTextArea resultArea;
	private JTextArea resultArea2;
	private JButton enterButton;
	private JButton enterButton2;
	private double radius;
	private double volume;
	private double surfaceArea;
	public SwingConverter() {
		JFrame myWindow=new javax.swing.JFrame("Base Converter - Created by Matthew");
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myWindow.add(inputPanel);
		myWindow.setSize(600, 1000);
		myWindow.setVisible(true);
	}
	private JPanel initInputPanel() {
		JPanel panel=new JPanel();
		panel.setPreferredSize(new java.awt.Dimension(600, 1000));
		panel.setLayout(null);
		panel.setBackground(java.awt.Color.GRAY);
		JLabel label1=new JLabel("Swing");
		label1.setBounds(275, 10, 50, 30);
		panel.add(label1);
		JLabel label2=new JLabel("Enter a Base-10 Number: ");
		label2.setBounds(50, 50, 220, 30);
		panel.add(label2);
		JTextField text;
		text=inputText=new JTextField();
		text.setBounds(230, 50, 100, 30);
		panel.add(text);
		JButton button=new JButton("Enter");
		button.setActionCommand("Enter");
		button.setBounds(340, 50, 80, 30);
		button.addActionListener(this);
		panel.add(button);
		enterButton=button;
		button=new JButton("Reset");
		button.setActionCommand("Reset");
		button.setBounds(430, 50, 80, 30);
		button.addActionListener(this);
		panel.add(button);
		resultArea=new JTextArea();
		resultArea.setBounds(50, 100, 500, 300);
		resultArea.setEditable(false);
		resultArea.setBackground(java.awt.Color.CYAN);
		panel.add(resultArea);
		JLabel label3=new JLabel("Sphere");
		label3.setBounds(275, 510, 50, 30);
		panel.add(label3);
		JLabel label4=new JLabel("Enter the radius: ");
		label4.setBounds(100, 550, 220, 30);
		panel.add(label4);
		JTextField text2;
		text2=inputText2=new JTextField();
		text2.setBounds(230, 550, 100, 30);
		panel.add(text2);
		JButton button2=new JButton("Enter");
		button2.setActionCommand("Enter2");
		button2.setBounds(340, 550, 80, 30);
		button2.addActionListener(this);
		panel.add(button2);
		enterButton2=button2;
		button2=new JButton("Reset");
		button2.setActionCommand("Reset2");
		button2.setBounds(430, 550, 80, 30);
		button2.addActionListener(this);
		panel.add(button2);
		resultArea2=new JTextArea();
		resultArea2.setBounds(50, 600, 500, 300);
		resultArea2.setEditable(false);
		resultArea2.setBackground(java.awt.Color.MAGENTA);
		panel.add(resultArea2);
		return panel;
	}
	public static void main(String[] args) throws Exception {
		//SwingConverter baseConverter=new SwingConverter();
		new SwingConverter();
	}
	public void actionPerformed(ActionEvent ev) {
		String command=ev.getActionCommand();
		if (command.equals("Enter")) {
			showResult();
		}
		else if (command.equals("Reset")) {
			reset();
		}
		else if (command.equals("Enter2")) {
			showResult2();
		}
		else if (command.equals("Reset2")) {
			reset2();
		}
	}
	private void showResult() {
		String hexUpperCase;
		inputText.setEnabled(false);
		enterButton.setEnabled(false);
		Integer n=getInputNumber();
		if (n==null) {
			resultArea.append("Invalid number!");
			return;
		}
		int baseTenNumber=n.intValue();
		resultArea.append("Decimal = "+baseTenNumber+"\n");
		resultArea.append("Binary = "+Integer.toString(baseTenNumber, 2)+"\n");
		resultArea.append("Octal = "+Integer.toString(baseTenNumber, 8)+"\n");
		hexUpperCase=Integer.toString(baseTenNumber, 16).toUpperCase();
		resultArea.append("Hexadecimal = "+hexUpperCase+"\n");
	}
	private void reset() {
		inputText.setText("");
		resultArea.setText("");
		inputText.setEnabled(true);
		enterButton.setEnabled(true);
		inputText.requestFocus();
	}
	private Integer getInputNumber() {
		try {
			Integer n=Integer.parseInt(inputText.getText());
			return n;
		}
		catch (Exception e) {
			return null;
		}
	}
	private void showResult2() {
		inputText2.setEnabled(false);
		enterButton2.setEnabled(false);
		Integer n=getInputNumber2();
		if (n==null) {
			resultArea2.append("Invalid number!");
			return;
		}
		int radius=n.intValue();
		resultArea2.append("Radius = "+radius+"\n");
		resultArea2.append("Volume = "+((Math.PI*Math.pow(radius, 3))*4)/3+"\n");
		resultArea2.append("Surface Area = "+4*Math.PI*Math.pow(radius, 2)+"\n");
	}
	private void reset2() {
		inputText2.setText("");
		resultArea2.setText("");
		inputText2.setEnabled(true);
		enterButton2.setEnabled(true);
		inputText2.requestFocus();
	}
	private Integer getInputNumber2() {
		try {
			Integer n=Integer.parseInt(inputText2.getText());
			return n;
		}
		catch (Exception e) {
			return null;
		}
	}
}
