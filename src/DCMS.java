import javax.sound.sampled.AudioInputStream;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.text.DefaultEditorKit;
import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



public class DCMS 
{	
	/**
	 * Variables.
	 */
	private JFrame frmSsDiagnosticCentre;
	
	private JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6, textField_7, textField_8, textField_9, textField_10, textField_11, textField_12, textField_13, textField_14, textField_15, textField_16, textField_17, textField_18, textField_19, textField_20, textField_21, textField_22, textField_23, textField_24, textField_25, textField_26, textField_27, textField_28, textField_29;
	
	private JRadioButton rdbtnMale, rdbtnFemale;
	
	private double p=0, p1=0, p2=0, p3=0, p4=0, p5=0, p6=0, p7=0, p8=0, p9=0, p10=0;
	
	private String str1="", str2="", str3="", str4="", str5="", str6="", str7="", str8="", str9="", str10="", x="",bill="",gender="";
	
	private JCheckBox chckbxHaemoglobinTest, chckbxBloodTest, chckbxUrineTest, chckbxHivTest, chckbxCreatinineTest, chckbxElectrolytes, chckbxXraychest, chckbxXrayskull, chckbxXraykneeJoint, chckbxXrayhipJoint;

	private JCheckBox chckbxSound;
	
	AudioInputStream audio;
	Clip clip = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try 
		{
			DCMS window = new DCMS();
			window.frmSsDiagnosticCentre.setVisible(true);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	

	/**
	 * Create the application.
	 */
	public DCMS() 
	{		
		frmSsDiagnosticCentre = new JFrame();
		frmSsDiagnosticCentre.setTitle("SS Diagnostic Centre");
		frmSsDiagnosticCentre.setSize(569, 692);
		frmSsDiagnosticCentre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	
		/**
		 * Menu Bar.
		 */
		JMenuBar menuBar = new JMenuBar();
		frmSsDiagnosticCentre.setJMenuBar(menuBar);
		
		//File Menu
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				PrintWriter pw=null;
				try 
				{
					pw = new PrintWriter("D:\\DATA.txt");
				} 
				catch (FileNotFoundException e1) 
				{					
					e1.printStackTrace();
				}
				pw.println("Invoice ID: "+textField.getText());
				pw.println("Date: "+textField_1.getText());
				pw.println("Name: "+textField_2.getText());
				pw.println("Referred By: "+textField_3.getText());
				pw.println("Age: "+textField_4.getText());
				pw.println("Weight: "+textField_5.getText());
				pw.println("BP: "+textField_6.getText());
				pw.println("Gender: "+ gender);
				pw.println("List of Tests: "+textField_7.getText()+textField_8.getText()+textField_9.getText()+textField_10.getText()+textField_11.getText()+textField_12.getText()+textField_13.getText()+textField_14.getText()+textField_15.getText()+textField_16.getText());
				pw.println("Total: "+textField_27.getText());
				pw.println("Paid: "+textField_28.getText());
				pw.println("Due: "+textField_29.getText());
				pw.close();			
			}
		});
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnFile.add(mntmNew);
		
		
		//Edit Menu
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmCut = new JMenuItem(new DefaultEditorKit.CutAction());
		mntmCut.setText("Cut");	
		mntmCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem(new DefaultEditorKit.CopyAction());
		mntmCopy.setText("Copy");
		mntmCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem(new DefaultEditorKit.PasteAction());
		mntmPaste.setText("Paste");
		mntmPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mnEdit.add(mntmPaste);
		
		JMenuItem mntmSelectAll = new JMenuItem("Select All");
		mntmSelectAll.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				SelectAllOption sa = new SelectAllOption();
				sa.selectAll(textField);
				sa.selectAll(textField_1);
				sa.selectAll(textField_2);
				sa.selectAll(textField_3);
				sa.selectAll(textField_4);
				sa.selectAll(textField_5);
				sa.selectAll(textField_6);
				sa.selectAll(textField_7);
				sa.selectAll(textField_8);
				sa.selectAll(textField_9);
				sa.selectAll(textField_10);
				sa.selectAll(textField_11);
				sa.selectAll(textField_12);
				sa.selectAll(textField_13);
				sa.selectAll(textField_14);
				sa.selectAll(textField_15);
				sa.selectAll(textField_16);
				sa.selectAll(textField_17);
				sa.selectAll(textField_18);
				sa.selectAll(textField_19);
				sa.selectAll(textField_20);
				sa.selectAll(textField_21);
				sa.selectAll(textField_22);
				sa.selectAll(textField_23);
				sa.selectAll(textField_24);
				sa.selectAll(textField_25);
				sa.selectAll(textField_26);
				sa.selectAll(textField_27);
				sa.selectAll(textField_28);
				sa.selectAll(textField_29);	
			}
		});
		mntmSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnEdit.add(mntmSelectAll);
		
		
		//Option Menu
		JMenu mnOption = new JMenu("Option");
		menuBar.add(mnOption);
		
		chckbxSound = new JCheckBox("Sound");
		chckbxSound.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{	
				
				
				if(chckbxSound.isSelected()==true)
				{
					try 
					{
						audio = AudioSystem.getAudioInputStream(new File("a.wav"));
			            clip = AudioSystem.getClip();			            
			            clip.open(audio);
			            clip.start();
			            clip.loop(clip.LOOP_CONTINUOUSLY);
			        }
			         			        
			        catch(UnsupportedAudioFileException uae)
			        {
			            System.out.println(uae);
			        }
			        catch(IOException ioe)
			        {
			            System.out.println(ioe);
			        }
			        catch(LineUnavailableException lua)
			        {
			            System.out.println(lua);
			        }
				}	
				
				else
				{					
					clip.stop();
				}
			}
		
		});
		mnOption.add(chckbxSound);
		
		
		//Help Menu
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null,"Version 1.0.0"+"\nProgrammed By: Source Coders." + "\nAuthors: Md. Shafiqul Islam & Md. Ainul Haque."+"\n\nCopyright 2014 Source Coders."+"\n\nWarnings:This program is protected By copyright law and international treaties.\nUnauthorized production or distribution of this program may result severe criminal to the law.");				
			}
		}
		);
		mnHelp.add(mntmAbout);
		
		frmSsDiagnosticCentre.getContentPane().setLayout(null);
		
		
		
		/**
		 *  First Panel
		 */
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 205, 170));
		panel_1.setBounds(0, 0, 553, 94);
		frmSsDiagnosticCentre.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		//Invoice ID
		JLabel lblInvoiceId = new JLabel("Invoice ID");
		lblInvoiceId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInvoiceId.setBounds(10, 0, 70, 26);
		panel_1.add(lblInvoiceId);
		
		textField = new JTextField();	
		textField.setBounds(72, 3, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		InvoiceID id = new InvoiceID();
		textField.setText(id.generateInvoiceNum());
		
		
		//Patient's Information
		JLabel lblPatientsInformation = new JLabel("Personal Information");
		lblPatientsInformation.setFont(new Font("Calibri", Font.BOLD, 15));
		lblPatientsInformation.setBounds(211, 2, 159, 23);
		panel_1.add(lblPatientsInformation);
		
		
		//Date
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate.setBounds(396, 3, 40, 20);
		panel_1.add(lblDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(431, 3, 112, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		GetCurrentDateTime d = new GetCurrentDateTime();
		textField_1.setText(d.getDate());
		
		JLabel lblName = new JLabel("Patient's Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(10, 37, 103, 17);
		panel_1.add(lblName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(102, 34, 441, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblRefferdBy = new JLabel("Reffered by");
		lblRefferdBy.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRefferdBy.setBounds(10, 69, 70, 14);
		panel_1.add(lblRefferdBy);
		
		textField_3 = new JTextField();
		textField_3.setBounds(102, 65, 441, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		
		
		/**
		 * Second Panel.
		 */
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 94, 553, 80);
		frmSsDiagnosticCentre.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		//Personal Information
		JLabel lblPersonalInformation = new JLabel("Patient's Information");
		lblPersonalInformation.setBounds(213, 0, 138, 19);
		lblPersonalInformation.setFont(new Font("Calibri", Font.BOLD, 15));
		panel.add(lblPersonalInformation);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGender.setBounds(10, 26, 46, 14);
		panel.add(lblGender);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(62, 22, 52, 23);
		panel.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(62, 50, 76, 23);
		panel.add(rdbtnFemale);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMale);
		group.add(rdbtnFemale);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAge.setBounds(182, 26, 28, 14);
		panel.add(lblAge);
		
		textField_4 = new JTextField();
		textField_4.setBounds(233, 23, 40, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblY = new JLabel("Y");
		lblY.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblY.setBounds(280, 26, 14, 14);
		panel.add(lblY);
		
		JLabel lblWeigth = new JLabel("Weigth");
		lblWeigth.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWeigth.setBounds(182, 54, 46, 14);
		panel.add(lblWeigth);
		
		textField_5 = new JTextField();
		textField_5.setBounds(233, 51, 40, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblKg = new JLabel("kg");
		lblKg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKg.setBounds(280, 54, 14, 14);
		panel.add(lblKg);
		
		JLabel lblBloodPresure = new JLabel("Blood Pressure");
		lblBloodPresure.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBloodPresure.setBounds(359, 26, 92, 14);
		panel.add(lblBloodPresure);
		
		textField_6 = new JTextField();
		textField_6.setBounds(359, 51, 92, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblMmhg = new JLabel("mm/Hg");
		lblMmhg.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMmhg.setBounds(461, 54, 59, 14);
		panel.add(lblMmhg);
		
		
		
		/**
		 * Third Panel.
		 */
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 250));
		panel_2.setBounds(0, 174, 553, 315);
		frmSsDiagnosticCentre.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		
		//Diagnosis Information
		JLabel lblDiagnosisInformation = new JLabel("Diagnosis Information");
		lblDiagnosisInformation.setFont(new Font("Calibri", Font.BOLD, 15));
		lblDiagnosisInformation.setBounds(212, 0, 141, 22);
		panel_2.add(lblDiagnosisInformation);
		
		JLabel lblTestList = new JLabel("Test List");
		lblTestList.setBounds(10, 23, 80, 14);
		panel_2.add(lblTestList);
		
		JLabel lblNewLabel = new JLabel("Test Name");
		lblNewLabel.setBounds(253, 23, 110, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(459, 23, 73, 14);
		panel_2.add(lblPrice);
		
		
		
		/**
		 * Test Box.
		 */	
		
		
		//Haemoglobin Test
		chckbxHaemoglobinTest = new JCheckBox("Haemoglobin Test");
		chckbxHaemoglobinTest.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxHaemoglobinTest.setBounds(6, 44, 127, 23);
		panel_2.add(chckbxHaemoglobinTest);
		
		textField_7 = new JTextField();
		textField_7.setBounds(199, 45, 164, 20);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		
		chckbxHaemoglobinTest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
					textField_7.setText("Haemoglobin Test, ");
					textField_7.setFont(new Font("Tahoma", Font.BOLD, 11));
					textField_17.setText("255.00");
					if(chckbxHaemoglobinTest.isSelected()==true)
					{
						str1=textField_17.getText();
						p1=Double.parseDouble(str1);
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						x="";
	
						textField_27.setText(x+p);
					}
					else
					{	
						textField_7.setText(null);
						textField_17.setText(null);
						p1=0;
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						x="";
					
						textField_27.setText(x+p);
					}
			}
		});
		
		
		//Blood Test
		chckbxBloodTest = new JCheckBox("Blood Test");
		chckbxBloodTest.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxBloodTest.setBounds(6, 70, 84, 23);
		panel_2.add(chckbxBloodTest);
		
		textField_8 = new JTextField();
		textField_8.setBounds(199, 71, 164, 20);
		panel_2.add(textField_8);
		textField_8.setColumns(10);
		
		chckbxBloodTest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
					textField_8.setText("Blood Test, ");
					textField_8.setFont(new Font("Tahoma", Font.BOLD, 11));
					textField_18.setText("100.00");
					if(chckbxBloodTest.isSelected()==true)
					{
						str2=textField_18.getText();
						p2=Double.parseDouble(str2);
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						String x="";
						
						textField_27.setText(x+p);
					}
					else
					{	
						textField_8.setText(null);
						textField_18.setText(null);
						p2=0;
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						x="";
					
						textField_27.setText(x+p);
					}
			}
		});		
		
		
		//Urine Test
		chckbxUrineTest = new JCheckBox("Urine Test");
		chckbxUrineTest.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxUrineTest.setBounds(6, 96, 83, 23);
		panel_2.add(chckbxUrineTest);
		
		textField_9 = new JTextField();
		textField_9.setBounds(199, 97, 164, 20);
		panel_2.add(textField_9);
		textField_9.setColumns(10);
		
		chckbxUrineTest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
					textField_9.setText("Urine Test, ");
					textField_9.setFont(new Font("Tahoma", Font.BOLD, 11));
					textField_19.setText("150.00");
					if(chckbxUrineTest.isSelected()==true)
					{
						str3=textField_19.getText();
						p3=Double.parseDouble(str3);
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						x="";
						
						textField_27.setText(x+p);
					}
					else					
					{	
						textField_9.setText(null);
						textField_19.setText(null);
						p3=0;
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						x="";
					
						textField_27.setText(x+p);
					}
			}
		});
		
		
		//HIV Test
		chckbxHivTest = new JCheckBox("HIV Test");
		chckbxHivTest.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxHivTest.setBounds(6, 122, 73, 23);
		panel_2.add(chckbxHivTest);
		
		textField_10 = new JTextField();
		textField_10.setBounds(199, 123, 164, 20);
		panel_2.add(textField_10);
		textField_10.setColumns(10);
		
		chckbxHivTest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
					textField_10.setText("HIV Test, ");
					textField_10.setFont(new Font("Tahoma", Font.BOLD, 11));
					textField_20.setText("575.00");
					if(chckbxHivTest.isSelected()==true)
					{
						str4=textField_20.getText();
						p4=Double.parseDouble(str4);
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						x="";
						
						textField_27.setText(x+p);
					}
					else					
					{	
						textField_10.setText(null);
						textField_20.setText(null);
						p4=0;
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						x="";
					
						textField_27.setText(x+p);
					}
			}
		});
		
		
		//Creatinine Test
		chckbxCreatinineTest = new JCheckBox("Creatinine Test");
		chckbxCreatinineTest.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxCreatinineTest.setBounds(6, 148, 111, 23);
		panel_2.add(chckbxCreatinineTest);
		
		textField_11 = new JTextField();
		textField_11.setBounds(199, 149, 164, 20);
		panel_2.add(textField_11);
		textField_11.setColumns(10);
		
		chckbxCreatinineTest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
					textField_11.setText("Creatinine Test, ");
					textField_11.setFont(new Font("Tahoma", Font.BOLD, 11));
					textField_21.setText("1050.00");
					if(chckbxCreatinineTest.isSelected()==true)
					{
						str5=textField_21.getText();
						p5=Double.parseDouble(str5);
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						String x="";
						
						textField_27.setText(x+p);
					}
					else					
					{	
						textField_11.setText(null);
						textField_21.setText(null);
						p5=0;
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						x="";
					
						textField_27.setText(x+p);
					}
			}
		});
		
		
		//Electrolytes Test
		chckbxElectrolytes = new JCheckBox("Electrolytes");
		chckbxElectrolytes.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxElectrolytes.setBounds(6, 174, 93, 23);
		panel_2.add(chckbxElectrolytes);
		
		textField_12 = new JTextField();
		textField_12.setBounds(199, 175, 164, 20);
		panel_2.add(textField_12);
		textField_12.setColumns(10);
		
		chckbxElectrolytes.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
					textField_12.setText("Electrolytes, ");
					textField_12.setFont(new Font("Tahoma", Font.BOLD, 11));
					textField_22.setText("1500.00");
					if(chckbxElectrolytes.isSelected()==true)
					{
						str6=textField_22.getText();
						p6=Double.parseDouble(str6);
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						x="";
						
						textField_27.setText(x+p);
					}
					else					
					{	
						textField_12.setText(null);
						textField_22.setText(null);
						p6=0;
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						x="";
					
						textField_27.setText(x+p);
					}
			}
		});
		
		
		//X-Ray (Chest)
		chckbxXraychest = new JCheckBox("X-Ray (Chest)");
		chckbxXraychest.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxXraychest.setBounds(6, 200, 105, 23);
		panel_2.add(chckbxXraychest);
		
		textField_13 = new JTextField();
		textField_13.setBounds(199, 201, 164, 20);
		panel_2.add(textField_13);
		textField_13.setColumns(10);
		
		chckbxXraychest.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
					textField_13.setText("X-Ray (Chest), ");
					textField_13.setFont(new Font("Tahoma", Font.BOLD, 11));
					textField_23.setText("1200.00");
					if(chckbxXraychest.isSelected()==true)
					{
						str7=textField_23.getText();
						p7=Double.parseDouble(str7);
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						x="";
						
						textField_27.setText(x+p);
					}
					else					
					{	
						textField_13.setText(null);
						textField_23.setText(null);
						p7=0;
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						x="";
					
						textField_27.setText(x+p);
					}
			}
		});
		
		
		//X-Ray (Skull)
		chckbxXrayskull = new JCheckBox("X-Ray (Skull)");
		chckbxXrayskull.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxXrayskull.setBounds(6, 226, 99, 23);
		panel_2.add(chckbxXrayskull);
		
		textField_14 = new JTextField();
		textField_14.setBounds(199, 227, 164, 20);
		panel_2.add(textField_14);
		textField_14.setColumns(10);
		
		chckbxXrayskull.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
					textField_14.setText("X-Ray (Skull), ");
					textField_14.setFont(new Font("Tahoma", Font.BOLD, 11));
					textField_24.setText("1250.00");
					if(chckbxXrayskull.isSelected()==true)
					{
						str8=textField_24.getText();
						p8=Double.parseDouble(str8);
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						x="";
						
						textField_27.setText(x+p);
					}
					else					
					{	
						textField_14.setText(null);
						textField_24.setText(null);
						p8=0;
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						x="";
					
						textField_27.setText(x+p);
					}
			}
		});
		
		
		//X-Ray (Knee joint)
		chckbxXraykneeJoint = new JCheckBox("X-Ray (Knee joint)");
		chckbxXraykneeJoint.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxXraykneeJoint.setBounds(6, 251, 129, 23);
		panel_2.add(chckbxXraykneeJoint);
	
		textField_15 = new JTextField();
		textField_15.setBounds(199, 252, 164, 20);
		panel_2.add(textField_15);
		textField_15.setColumns(10);
		
		chckbxXraykneeJoint.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
					textField_15.setText("X-Ray (Knee joint), ");
					textField_15.setFont(new Font("Tahoma", Font.BOLD, 11));
					textField_25.setText("1300.00");
					if(chckbxXraykneeJoint.isSelected()==true)
					{
						str9=textField_25.getText();
						p9=Double.parseDouble(str9);
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						x="";
						
						textField_27.setText(x+p);
					}
					else					
					{	
						textField_15.setText(null);
						textField_25.setText(null);
						p9=0;
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						x="";
					
						textField_27.setText(x+p);
					}
			}
		});
		
		
		//X-Ray (Hip Joint)
		chckbxXrayhipJoint = new JCheckBox("X-Ray (Hip Joint)");
		chckbxXrayhipJoint.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxXrayhipJoint.setBounds(6, 277, 123, 23);
		panel_2.add(chckbxXrayhipJoint);
				
		textField_16 = new JTextField();
		textField_16.setBounds(199, 278, 164, 20);
		panel_2.add(textField_16);
		textField_16.setColumns(10);
		
		chckbxXrayhipJoint.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
					textField_16.setText("X-Ray (Hip Joint). ");
					textField_16.setFont(new Font("Tahoma", Font.BOLD, 11));
					textField_26.setText("1250.00");
					if(chckbxXrayhipJoint.isSelected()==true)
					{
						str10=textField_26.getText();
						p10=Double.parseDouble(str10);
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						x="";
						
						textField_27.setText(x+p);
					}
					else					
					{	
						textField_16.setText(null);
						textField_26.setText(null);
						p10=0;
						p=p1+p2+p3+p4+p5+p6+p7+p8+p9+p10;
						x="";
					
						textField_27.setText(x+p);
					}
			}
		});
		
		
		
		/**
		 * Price Box.
		 */
		textField_17 = new JTextField();
		textField_17.setBounds(431, 45, 86, 20);
		panel_2.add(textField_17);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setBounds(431, 71, 86, 20);
		panel_2.add(textField_18);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setBounds(431, 97, 86, 20);
		panel_2.add(textField_19);
		textField_19.setColumns(10);
		
		textField_20 = new JTextField();
		textField_20.setBounds(431, 123, 86, 20);
		panel_2.add(textField_20);
		textField_20.setColumns(10);
		
		textField_21 = new JTextField();
		textField_21.setBounds(431, 149, 86, 20);
		panel_2.add(textField_21);
		textField_21.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setBounds(431, 175, 86, 20);
		panel_2.add(textField_22);
		textField_22.setColumns(10);
		
		textField_23 = new JTextField();
		textField_23.setBounds(431, 201, 86, 20);
		panel_2.add(textField_23);
		textField_23.setColumns(10);
		
		textField_24 = new JTextField();
		textField_24.setBounds(431, 227, 86, 20);
		panel_2.add(textField_24);
		textField_24.setColumns(10);
		
		textField_25 = new JTextField();
		textField_25.setBounds(431, 252, 86, 20);
		panel_2.add(textField_25);
		textField_25.setColumns(10);
		
		textField_26 = new JTextField();
		textField_26.setBounds(431, 278, 86, 20);
		panel_2.add(textField_26);
		textField_26.setColumns(10);
		
		
		
		/**
		 * Forth Panel
		 */
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(144, 238, 144));
		panel_3.setBounds(0, 488, 553, 145);
		frmSsDiagnosticCentre.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		
		//Total
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotal.setBounds(358, 11, 46, 14);
		panel_3.add(lblTotal);
		
		textField_27 = new JTextField();
		textField_27.setBounds(414, 8, 86, 20);
		panel_3.add(textField_27);
		textField_27.setColumns(10);
		
		JLabel lblBdt = new JLabel("BDT");
		lblBdt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBdt.setBounds(510, 11, 33, 14);
		panel_3.add(lblBdt);
		
		
		//Paid Amount
		JLabel lblPaid = new JLabel("Paid");
		lblPaid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPaid.setBounds(358, 49, 33, 14);
		panel_3.add(lblPaid);
		
		textField_28 = new JTextField();
		textField_28.setBounds(414, 46, 86, 20);
		panel_3.add(textField_28);
		textField_28.setColumns(10);
		
		JLabel lblBdt_1 = new JLabel("BDT");
		lblBdt_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBdt_1.setBounds(510, 49, 33, 14);
		panel_3.add(lblBdt_1);
		
		
		//Due Amount		
		JLabel lblDue = new JLabel("Due");
		lblDue.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDue.setBounds(358, 83, 27, 14);
		panel_3.add(lblDue);
		
		textField_29 = new JTextField();
		textField_29.setBounds(414, 80, 86, 20);
		panel_3.add(textField_29);
		textField_29.setColumns(10);
		
		JLabel lblBdt_2 = new JLabel("BDT");
		lblBdt_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBdt_2.setBounds(510, 83, 33, 14);
		panel_3.add(lblBdt_2);
		
		
		//Calculate Due Amount
		JButton btnCalculate_1 = new JButton("Calculate");
		btnCalculate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
					{
						audio = AudioSystem.getAudioInputStream(new File("b.wav"));
			            clip = AudioSystem.getClip();			            
			            clip.open(audio);
			            clip.start();
			        }
			         			        
			        catch(UnsupportedAudioFileException uae)
			        {
			            System.out.println(uae);
			        }
			        catch(IOException ioe)
			        {
			            System.out.println(ioe);
			        }
			        catch(LineUnavailableException lua)
			        {
			            System.out.println(lua);
			        }
				
				
				
				
				double a=0;
				double b=0;
				
				String str1="";
				String str2="";
				
				
				str1=textField_27.getText();
				a=Double.parseDouble(str1);
				str2=textField_28.getText();
				b=Double.parseDouble(str2);
				
				double d=a-b;
				
				String due="";
				
				textField_29.setText(due+d);
				
			}
		});
		btnCalculate_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCalculate_1.setBounds(259, 79, 89, 23);
		panel_3.add(btnCalculate_1);
	
		
		
		/**
		 * Bill.
		 */
		JButton btnBill = new JButton("BILL");
		btnBill.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					audio = AudioSystem.getAudioInputStream(new File("b.wav"));
		            clip = AudioSystem.getClip();			            
		            clip.open(audio);
		            clip.start();
		        }
		         			        
		        catch(UnsupportedAudioFileException uae)
		        {
		            System.out.println(uae);
		        }
		        catch(IOException ioe)
		        {
		            System.out.println(ioe);
		        }
		        catch(LineUnavailableException lua)
		        {
		            System.out.println(lua);
		        }
				
				gender = "";	
				
				if(rdbtnMale.isSelected()==true)
					gender = "Male";
				else
					gender = "Female";
				
				bill=
						"Invoice ID: "+textField.getText()+"\n"+
						"Date: "+textField_1.getText()+"\n"+
						"\nName: "+textField_2.getText()+"\n"+
						"Referred By: "+textField_3.getText()+"\n"+
						"Age:"+textField_4.getText()+"\n"+
						"Weight: "+textField_5.getText()+"\n"+
						"BP:"+textField_6.getText()+"\n"+
						"Gender: "+ gender +"\n"+
						"\nList of Tests:\n"+
						textField_7.getText()+
						textField_8.getText()+
						textField_9.getText()+
						textField_10.getText()+
						textField_11.getText()+
						textField_12.getText()+
						textField_13.getText()+
						textField_14.getText()+
						textField_15.getText()+
						textField_16.getText()+"\n"+
						"\nTotal: "+textField_27.getText()+"\n"+
						"Paid: "+textField_28.getText()+"\n"+
						"Due: "+textField_29.getText()+"\n";
				
				JOptionPane.showMessageDialog(null,bill);
			}
		});
		btnBill.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBill.setBounds(10, 117, 533, 23);
		panel_3.add(btnBill);		
		}
}


/**
 * End Application.
 */
