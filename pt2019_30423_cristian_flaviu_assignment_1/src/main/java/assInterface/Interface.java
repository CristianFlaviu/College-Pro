package assInterface;

import java.awt.event.ActionListener;

import javax.swing.*;

public class Interface extends JFrame {

	private JTextField firstPolTextField;
	private JButton getFirstPolinomBtn;
	private JLabel firstPolLabel;
	private JLabel firstPolLabel1;
	private JTextField secondPolTextField;
	private JButton getSecondPolinomBtn;
	private JLabel secondPolLabel;
	private JLabel secondtPolLabel1;
	private JButton addBtn;
	private JButton subttractBtn;
	private JButton multiplyBtn;
	private JButton divideBtn;
	private JButton integrateBtn;
	private JButton derivateBtn;	
	private JLabel result;
	private JLabel result1;
	public Interface() {
		this.setBounds(100, 100, 600, 500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		derivateBtn=new JButton("D");
		derivateBtn.setBounds(430, 220, 45, 45);
		getContentPane().add(derivateBtn);
		
		integrateBtn=new JButton("I");
		integrateBtn.setBounds(360, 220, 45, 45);
		getContentPane().add(integrateBtn);
		
		divideBtn=new JButton("/");
		divideBtn.setBounds(290, 220, 45, 45);
		getContentPane().add(divideBtn);
		
		multiplyBtn=new JButton("*");
		multiplyBtn.setBounds(220, 220, 45, 45);
		getContentPane().add(multiplyBtn);
		
		addBtn=new JButton("+");
		addBtn.setBounds(80, 220, 45, 45);
		getContentPane().add(addBtn);
		
		subttractBtn=new JButton("-");
		subttractBtn.setBounds(150, 220, 45, 45);
		getContentPane().add(subttractBtn);
		
		
		firstPolTextField = new JTextField();
		firstPolTextField.setBounds(130, 53, 162, 20);
		getContentPane().add(firstPolTextField);

		getFirstPolinomBtn = new JButton("SaveFirstPolynomial");
		getFirstPolinomBtn.setBounds(301, 53, 175, 23);
		getContentPane().add(getFirstPolinomBtn);
		
		firstPolLabel = new JLabel("First polynomial:");
		firstPolLabel.setBounds(20, 53, 356, 16);
		getContentPane().add(firstPolLabel);
		
		firstPolLabel1 = new JLabel("Not recorded yet");
		firstPolLabel1.setBounds(134, 100, 356, 16);
		getContentPane().add(firstPolLabel1);
		
		secondPolTextField = new JTextField();
		secondPolTextField.setBounds(130, 150, 162, 20);
		getContentPane().add(secondPolTextField);

		getSecondPolinomBtn = new JButton("SaveSecPolynomial");
		getSecondPolinomBtn.setBounds(301, 150, 175, 23);
		getContentPane().add(getSecondPolinomBtn);
		
		secondPolLabel = new JLabel("Second polynomial:");
		secondPolLabel.setBounds(20, 150, 356, 16);
		getContentPane().add(secondPolLabel);
		
		secondtPolLabel1 = new JLabel("Not recorded yet    ");
		secondtPolLabel1.setBounds(134, 180, 356, 16);
		getContentPane().add(secondtPolLabel1);
		
		result = new JLabel("Not recorded yet");
		result.setBounds(100, 270, 500, 100);
		getContentPane().add(result);
		
		result1 = new JLabel(" ");
		result1.setBounds(100, 300, 500, 100);
	getContentPane().add(result1);


	
		
	}

	public void setAddBtnActionListener(final ActionListener actionListener)
	{
	addBtn.addActionListener(actionListener);
	}
	
	public void setSubtractBtnActionListener(final ActionListener actionListener)
	{
	subttractBtn.addActionListener(actionListener);
	}
	
	public void setMultiplyBtnActionListener(final ActionListener actionListener)
	{
	multiplyBtn.addActionListener(actionListener);
	}

	public void setDivideBtnActionListener(final ActionListener actionListener)
	{
	divideBtn.addActionListener(actionListener);
	}
	
	public void setDerivateBtnActionListener(final ActionListener actionListener)
	{
	derivateBtn.addActionListener(actionListener);
	}
	public void setIntegrateBtnActionListener(final ActionListener actionListener)
	{
	integrateBtn.addActionListener(actionListener);
	}

	public void setfirstPolinomValue(String aString)
	{
		firstPolLabel1.setText(aString);
	}
	public void setSecondPolValue(String aString)
	{
		secondtPolLabel1.setText(aString);
	}
	public void addGetFirstPOlinomButtonActionListener(final ActionListener actionListener) {
		getFirstPolinomBtn.addActionListener(actionListener);
	}
	public void addGetSecondPOlinomButtonActionListener(final ActionListener actionListener) {
		getSecondPolinomBtn.addActionListener(actionListener);
	}

	public String getFirstPoli() {
		return firstPolTextField.getText();
	}
	public String getSecondPoli()
	{
		return secondPolTextField.getText();
	}
	
	public void setFirstMessage(String message)
	{
		result.setText(message);
	}
	public void setSecondMessage(String message)
	{
		result1.setText(message);
	}

}
