package gui;

import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GraphicInterface  extends JFrame {
	
	public static StringBuilder aBuilder=new StringBuilder();
	public static StringBuilder aBuilder2=new StringBuilder();
	public static StringBuilder aBuilder3=new StringBuilder();
	public static StringBuilder aBuilder4=new StringBuilder();
	public static StringBuilder jtextAreaBuilder=new StringBuilder();
	public static StringBuilder jtextAreaBuilder1=new StringBuilder();

	private JLabel lblServer1;
	public static JLabel lblServer1Q;
	private JLabel lbServer2;
	public static JLabel lbServer2Q; 
	JLabel lblServer3;
	private static JLabel lblServer3Q ;
	
	JLabel lblServer4;
	private static JLabel lblServer4Q ;
	private static JTextArea textArea;
	private static JTextArea textArea_1;
	private JScrollPane bScrollPane;
	private JScrollPane aScrollPane;	
	
	
	private JTextField MinArrTimeTextField;
	private JTextField MaxArrTimetextField;
	private JTextField MinServiceTimeTextField;
	private JTextField MaxServiceTimetextField;
	private JTextField SimulationIntervaltextField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	
	private static JLabel lblServer1Time;
	private static JLabel lblServer2Time;
	private static JLabel lblServer3Time;
	private static JLabel lblServer4time;
	private JButton saveBtnNewButton;
	private JLabel lblTextpeakTime;
	private JLabel lblTexTPeakValue;
	private static JLabel lblpeakTime;
	private static JLabel lblPeakValue;
	private JLabel lblWatingtime;
	private JLabel lblEmptyserver;
	private static JLabel lblEmptyServer1;
	private static JLabel lblEmptyServer2;
	private static JLabel lblEmptyServer3;
	private static JLabel lblEmptyServer4;
	private static JLabel lblAvgservivetime;
	private static JLabel lblServiceTime1;
	private static JLabel lblServiceTime2;
	private static JLabel lblServiceTime3;
	private static JLabel lblServiceTime4;
	private JLabel lblNewLabel_5;
	private static JLabel lblWaitingTime1;
	private static JLabel lblWaitingTime2;
	private static JLabel lblWaitingTime3;
	private static JLabel lblWaitingTime4;
	
	
	
	public GraphicInterface() {
		this.setBounds(100, 100, 865, 451);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
				
		 lblServer1 = new JLabel("Server1");
		lblServer1.setBounds(100, 54, 46, 14);
		getContentPane().add(lblServer1);
		
		 lblServer1Q = new JLabel("");
		lblServer1Q.setBounds(176, 54, 165, 14);
		getContentPane().add(lblServer1Q);
		
		lbServer2 = new JLabel("Server2");
		lbServer2.setBounds(100, 79, 46, 14);
		getContentPane().add(lbServer2);
		
		 lbServer2Q = new JLabel("");
		lbServer2Q.setBounds(175, 79, 166, 14);
		getContentPane().add(lbServer2Q);
		
		 lblServer3 = new JLabel("Server3");
		lblServer3.setBounds(100, 104, 46, 14);
		getContentPane().add(lblServer3);
		
		lblServer3Q = new JLabel("");
		lblServer3Q.setBounds(176, 104, 183, 14);
		getContentPane().add(lblServer3Q);
		
		lblServer4 = new JLabel("Server4");
		lblServer4.setBounds(100, 132, 46, 14);
		getContentPane().add(lblServer4);
		
		 lblServer4Q = new JLabel("");
		lblServer4Q.setBounds(175, 132, 183, 14);
		getContentPane().add(lblServer4Q);
		
		textArea_1 = new JTextArea();
		textArea_1.setTabSize(10);
		textArea_1.setSize( 233, 165);
		
		
		aScrollPane=new JScrollPane();
		aScrollPane.setSize(303, 155);
		aScrollPane.setLocation(26, 247);
		aScrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		aScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		bScrollPane=new JScrollPane(textArea_1);
		bScrollPane.setSize(303, 155);
		bScrollPane.setLocation(359, 247);
		bScrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
	
		bScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	
		getContentPane().add(aScrollPane);
		
		textArea = new JTextArea();
		aScrollPane.setViewportView(textArea);
		textArea.setTabSize(10);
		getContentPane().add(bScrollPane);
		
		MinArrTimeTextField = new JTextField();
		MinArrTimeTextField.setBounds(700, 23, 117, 20);
		getContentPane().add(MinArrTimeTextField);
		MinArrTimeTextField.setColumns(10);
		
		MaxArrTimetextField = new JTextField();
		MaxArrTimetextField.setBounds(700, 61, 117, 20);
		getContentPane().add(MaxArrTimetextField);
		MaxArrTimetextField.setColumns(10);
		
		MinServiceTimeTextField = new JTextField();
		MinServiceTimeTextField.setBounds(700, 101, 117, 20);
		getContentPane().add(MinServiceTimeTextField);
		MinServiceTimeTextField.setColumns(10);
		
		MaxServiceTimetextField = new JTextField();
		MaxServiceTimetextField.setBounds(700, 148, 117, 20);
		getContentPane().add(MaxServiceTimetextField);
		MaxServiceTimetextField.setColumns(10);
		
		SimulationIntervaltextField = new JTextField();
		SimulationIntervaltextField.setBounds(700, 193, 117, 20);
		getContentPane().add(SimulationIntervaltextField);
		SimulationIntervaltextField.setColumns(10);
		
		lblNewLabel = new JLabel("MinArrTime");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(604, 26, 94, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("MaxArrTime");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(617, 64, 81, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("MinServTime");
		lblNewLabel_2.setBounds(624, 104, 74, 14);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("MaxServiceTime");
		lblNewLabel_3.setBounds(617, 151, 81, 14);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("SimulationTime");
		lblNewLabel_4.setBounds(615, 196, 94, 14);
		getContentPane().add(lblNewLabel_4);
		
		 saveBtnNewButton = new JButton("Save");
		saveBtnNewButton.setBounds(734, 247, 89, 23);
		getContentPane().add(saveBtnNewButton);
		
		lblServer1Time = new JLabel("0");
		lblServer1Time.setBounds(44, 54, 46, 14);
		getContentPane().add(lblServer1Time);
		

		lblServer2Time = new JLabel("0");
		lblServer2Time.setBounds(44, 79, 46, 14);
		getContentPane().add(lblServer2Time);
		
		lblServer3Time = new JLabel("0");
		lblServer3Time.setBounds(44, 104, 46, 14);
		getContentPane().add(lblServer3Time);
		
		 lblServer4time = new JLabel("0");
		lblServer4time.setBounds(44, 132, 46, 14);
		getContentPane().add(lblServer4time);
		
		lblTextpeakTime = new JLabel("peak Time");
		lblTextpeakTime.setBounds(26, 171, 67, 14);
		getContentPane().add(lblTextpeakTime);
		
		lblTexTPeakValue = new JLabel("peak Value");
		lblTexTPeakValue.setBounds(26, 196, 67, 14);
		getContentPane().add(lblTexTPeakValue);
		
		lblpeakTime = new JLabel("0");
		lblpeakTime.setBounds(100, 171, 46, 14);
		getContentPane().add(lblpeakTime);
		
		lblPeakValue = new JLabel("0");
		lblPeakValue.setBounds(100, 196, 46, 14);
		getContentPane().add(lblPeakValue);
		
		lblWatingtime = new JLabel("WatingTime");
		lblWatingtime.setBounds(26, 26, 89, 14);
		getContentPane().add(lblWatingtime);
		
		lblEmptyserver = new JLabel("EmptyServer");
		lblEmptyserver.setBounds(330, 26, 81, 14);
		getContentPane().add(lblEmptyserver);
		
		lblEmptyServer1 = new JLabel("0");
		lblEmptyServer1.setBounds(351, 54, 46, 14);
		getContentPane().add(lblEmptyServer1);
		
		lblEmptyServer2 = new JLabel("0");
		lblEmptyServer2.setBounds(351, 79, 46, 14);
		getContentPane().add(lblEmptyServer2);
		
		lblEmptyServer3 = new JLabel("0");
		lblEmptyServer3.setBounds(351, 104, 46, 14);
		getContentPane().add(lblEmptyServer3);
		
		 lblEmptyServer4 = new JLabel("0");
		lblEmptyServer4.setBounds(351, 132, 46, 14);
		getContentPane().add(lblEmptyServer4);
		
		lblAvgservivetime = new JLabel("ServiceTime");
		lblAvgservivetime.setBounds(429, 26, 74, 14);
		getContentPane().add(lblAvgservivetime);
		
		lblServiceTime1 = new JLabel("0");
		lblServiceTime1.setBounds(432, 54, 46, 14);
		getContentPane().add(lblServiceTime1);
		
		lblServiceTime2 = new JLabel("0");
		lblServiceTime2.setBounds(431, 79, 46, 14);
		getContentPane().add(lblServiceTime2);
		
		lblServiceTime3 = new JLabel("0");
		lblServiceTime3.setBounds(431, 104, 46, 14);
		getContentPane().add(lblServiceTime3);
		
		lblServiceTime4 = new JLabel("0");
		lblServiceTime4.setBounds(431, 132, 46, 14);
		getContentPane().add(lblServiceTime4);
		
		lblNewLabel_5 = new JLabel("WaitingTime");
		lblNewLabel_5.setBounds(519, 26, 81, 14);
		getContentPane().add(lblNewLabel_5);
		
		lblWaitingTime1 = new JLabel("0");
		lblWaitingTime1.setBounds(529, 54, 46, 14);
		getContentPane().add(lblWaitingTime1);
		
		lblWaitingTime2 = new JLabel("0");
		lblWaitingTime2.setBounds(529, 79, 46, 14);
		getContentPane().add(lblWaitingTime2);
		
		lblWaitingTime3 = new JLabel("0");
		lblWaitingTime3.setBounds(529, 104, 46, 14);
		getContentPane().add(lblWaitingTime3);
		
		lblWaitingTime4 = new JLabel("0");
		lblWaitingTime4.setBounds(529, 132, 46, 14);
		getContentPane().add(lblWaitingTime4);
		
		
		
	
	
		
		this.setVisible(true);
	}
	
	



	public static void setLblServer1Q() {
		lblServer1Q.setText(aBuilder.toString());
	}
	
	public static void setLblServer3Q() {
		lblServer3Q.setText(aBuilder3.toString());
	}

	public static void setLblServer4Q() {
		lblServer4Q.setText(aBuilder4.toString());
	}

	public static void setLblServer2Q() {
		lbServer2Q.setText(aBuilder2.toString());
	}
	
	public JTextField getMinArrTimeTextField() {
		return MinArrTimeTextField;
	}





	public JTextField getMaxArrTimetextField() {
		return MaxArrTimetextField;
	}





	public JTextField getMinServiceTimeTextField() {
		return MinServiceTimeTextField;
	}





	public JTextField getMaxServiceTimetextField() {
		return MaxServiceTimetextField;
	}





	public JTextField getSimulationIntervaltextField() {
		return SimulationIntervaltextField;
	}





	public static StringBuilder getJtextAreaBuilder() {
		return jtextAreaBuilder;
	}





	public static void setTextArea(String message) {
		GraphicInterface.jtextAreaBuilder.append(message);
		textArea.setText(jtextAreaBuilder.toString());
		
	}
	public static void setTextArea1(String message) {
		GraphicInterface.jtextAreaBuilder1.append(message);
		textArea_1.setText(jtextAreaBuilder1.toString());
		
	}
	public void setSaveBtnActionListener(final ActionListener actionListener)
	{
		saveBtnNewButton.addActionListener(actionListener);
	}





	public static void setLblServer2Time(String message) {
	lblServer2Time.setText(message);
	}





	public static void setLblServer1Time(String message) {
		GraphicInterface.lblServer1Time.setText(message);
	}





	public static void setLblServer3Time(String message) {
		GraphicInterface.lblServer3Time.setText(message);;
	}





	public static void setLblServer4time(String message) {
		GraphicInterface.lblServer4time.setText(message);
	}
	
	public static void  setLblPeakValue(String message)
	{
		GraphicInterface.lblPeakValue.setText(message);
	}
	public static void setLblPeakTime(String message)
	{
		GraphicInterface.lblpeakTime.setText(message);
	}
	
	public static void  setEMptyServer1(String message)
	{
		GraphicInterface.lblEmptyServer1.setText(message);
	}
	public static void  setEMptyServer2(String message)
	{
		GraphicInterface.lblEmptyServer2.setText(message);
	}
	public static void  setEMptyServer3(String message)
	{
		GraphicInterface.lblEmptyServer3.setText(message);
	}
	public static void  setEMptyServer4(String message)
	{
		GraphicInterface.lblEmptyServer4.setText(message);
	}
	
	public static void setServTime1(String message )
	{
		GraphicInterface.lblServiceTime1.setText(message);
	}
	public static void setServTime2(String message )
	{
		GraphicInterface.lblServiceTime2.setText(message);
	}
	public static void setServTime3(String message )
	{
		GraphicInterface.lblServiceTime3.setText(message);
	}
	public static void setServTime4(String message )
	{
		GraphicInterface.lblServiceTime4.setText(message);
	}
	public static void setWaitingTime1(String message)
	{
		GraphicInterface.lblWaitingTime1.setText(message);
	}
	public static void setWaitingTime2(String message)
	{
		GraphicInterface.lblWaitingTime2.setText(message);
	}
	public static void setWaitingTime3(String message)
	{
		GraphicInterface.lblWaitingTime3.setText(message);
	}
	public static void setWaitingTime4(String message)
	{
		GraphicInterface.lblWaitingTime4.setText(message);
	}
}
