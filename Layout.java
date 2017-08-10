package JobApp;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@SuppressWarnings("serial")
public class Layout extends JFrame{
	

	//JTextField id=new JTextField("");
	JTextField name=new JTextField("");
	JTextField age=new JTextField("");
	JTextField mobile=new JTextField("");
	JTextField email=new JTextField("");

	
	
//	JLabel labelx=new JLabel("id.");
	JLabel label1=new JLabel("Name.");
	JLabel label2=new JLabel("Age.");
	JLabel label3=new JLabel("Mobile number.");
	JLabel label4=new JLabel("Email address.");
	JLabel label5=new JLabel("Vacancy.");
	JLabel label6=new JLabel("Qualifications.");
	JLabel label7=new JLabel("Gender.");
	
	JButton display=new JButton("Display");
	JButton delete=new JButton("Delete");
	JButton update=new JButton("Update");
	JButton  clear=new JButton("Clear");
	JButton submit=new JButton("Submit");
	JButton about=new JButton("About");
	
	 
	JPanel pane =new JPanel(new GridLayout(3,7,80,30));
	JPanel panex =new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel panek =new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	JPanel pane2 =new JPanel(new GridLayout(6,4,70,30));
	JPanel pane3 =new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JPanel pane4=new JPanel(new FlowLayout(FlowLayout.RIGHT));
	
	
	String[] pos={"","Network Administration","Database Administration","System Administration"};
	String[] qual={"","CCNA","OCP","IT essentials"};
	String[] sex={" ","Male","Female"};
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox  vacancy=new JComboBox(pos);
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox Qualification=new JComboBox(qual);
	//JComboBox gender=new JComboBox(sex);
	JRadioButton male =new JRadioButton("Male");
	JRadioButton female =new JRadioButton("Female");
	ButtonGroup grp=new ButtonGroup();
	
	Validation valid=new Validation();
	
	public Layout(){
		super("Job Application Form");
		//pane.setBorder(new TitledBorder("Personal Details"));
		
		
		setLayout(null);
		
		setBackground(Color.GRAY);
		
		label1.setBounds(30,10, 90, 90);
		name.setBounds(143,45, 200, 20);
		
		add(label1);
		add(name);

		label2.setBounds(30,50, 90, 90);
		age.setBounds(143,85, 200, 20);
			
		add(label2);
		add(age);

		
		label7.setBounds(30,95, 100, 90);
		male.setBounds(143,128, 100, 20);
		female.setBounds(250,128, 100, 20);
		
		male.setActionCommand("Male");
		female.setActionCommand("Female");
		add(male);
		add(female);

		grp.add(male);
		grp.add(female);
		
		add(label7);

		label6.setBounds(30,135, 102, 90);
		Qualification.setBounds(143,170,100, 20);
		add(label5);
		add(vacancy);
		
		
		label5.setBounds(30,180, 110, 90);
		vacancy.setBounds(143,215, 200, 20);
		add(label6);
		add(Qualification);
		
		label3.setBounds(30,225, 110, 90);
		mobile.setBounds(143,260, 200, 20);
		add(label3);
		add(mobile);
		
		label4.setBounds(30,265, 110, 90);
		email.setBounds(143,300, 200, 20);
		add(label4);
		add(email);
	
		submit.setBounds(255,355, 83,25);
		clear.setBounds(355,355, 87, 25);
		update.setBounds(355,215, 87, 25);
		delete.setBounds(355,260, 85, 25);
		display.setBounds(355,300, 87, 25);
		
		
		add(display);
		add(delete);
		add(update);
		add(about);
		add(submit);		
		add(clear);
	
		
		
		
		// guides the users what the buttons do
		delete.setToolTipText("click Delete to remove the data stored in database");
		update.setToolTipText("click update to make changes to the data stored in database");
		submit.setToolTipText("Click to submit the form");		
		display.setToolTipText("Writes the data  stored in the database to a text file");
		clear.setToolTipText("Clear the textbox");
		about.setToolTipText("information about the creators of the software");
	//setBackground(new Color(204,199,199));
		
			///info about the creator of the application
	about.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent arg0) {
	
			JOptionPane.showMessageDialog(null, "Creators : \nNelson guest katale\n Sanya Emmanuel"
					+ "\n Odongo Peter\nKatusiime Kevin", "About", JOptionPane.INFORMATION_MESSAGE);
			
		}
	});
			//////////////////////////////////////////////	
		

		///submit button   the data entered in textbox into the database
		submit.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent event0) {
	
			try{
				
	if((name.getText().isEmpty()) &&  (age.getText().isEmpty()) 
		   
		&& (mobile.getText().isEmpty())&& (email.getText().isEmpty()))//ensures that the textfield arer not empty
	{
		JOptionPane.showMessageDialog(pane3, "Form still empty.Please fill the form .", "info",JOptionPane.ERROR_MESSAGE);	
	
	}else
		
		//if the person selects  IT essentials ask the user for wihich qualification he does
		if(Qualification.getSelectedItem()==qual[3]){
					
					String temp =JOptionPane.showInputDialog("Enter your qualifications ");
				
					ExecCmd("INSERT INTO applicant(name,Age,gender,vacancy,Qualification,mobile,email)"
						+ " VALUES('"+name.getText()+"',"
						+ "'"+age.getText()+"' ," +
						"'"+grp.getSelection().getActionCommand()+"','"+vacancy.getSelectedItem()+"'," +
								"'"+temp+ "','"+mobile.getText()+"','"+email.getText()+"')");
				}
			//otherwise just execute the below statement
		else{
					ExecCmd("INSERT INTO applicant(name,Age,gender,vacancy,Qualification,mobile,email)"
							+ " VALUES('"+name.getText()+"',"
							+ "'"+age.getText()+"' ," +
							"'"+grp.getSelection().getActionCommand()+"','"+vacancy.getSelectedItem()+"'," +
									"'"+Qualification.getSelectedItem()+ "','"+mobile.getText()+"','"+email.getText()+"')");		
		
					//Automatically clear the text in textbox
					name.setText(null); 
					grp.clearSelection();
					mobile.setText(null); 
					email.setText(null); 
					age.setText(null);
					vacancy.setSelectedItem(qual[0]);
					Qualification.setSelectedItem(qual[0]); 
					///////////////////////////////////
						}
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,"Error in database connection"+e.getMessage());
					}
				}
		});
		//////////////////////////////////////////////////////////

		
		
		///clear button  clears the text entered in the textbox
		clear.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
			
				if(!(name.equals(null)) || !(age.equals(null)) || !(mobile.equals(null)) || !(email.equals(null))){	//clears the text in the box
					name.setText(null); 
					grp.clearSelection(); 
					mobile.setText(null); 
					email.setText(null); 
					age.setText(null);
					vacancy.setSelectedItem(qual[0]);
					Qualification.setSelectedItem(qual[0]); 
						
				}
			}
		});
		
		///Update button  updates the data in the database as specified by row
		update.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent event0) {
			// TODO Auto-generated method stub
		
			try{

				String is=JOptionPane.showInputDialog("Enter the Application no");
				//if the person selects  IT essentials ask the user for wihich qualification he does
				if(Qualification.getSelectedItem()==qual[3]){
				
				String temp =JOptionPane.showInputDialog("Enter your qualifications ");	
				
				ExecCmd("UPDATE applicant SET name='" + name.getText()
						+ "', age='" + age.getText()+ "', gender='" + grp.getSelection().getActionCommand()
						+ "', vacancy='" + vacancy.getSelectedItem()+ "', Qualification='" +temp
						+ "', mobile='" + mobile.getText()
						+ "', email='" + email.getText()+ "' WHERE id = '"+is+"'");
				
				}

				//otherwise just execute the below statement
				else{
					ExecCmd("UPDATE applicant SET name='" + name.getText()
							+ "', age='" + age.getText()+ "', gender='" + grp.getSelection().getActionCommand()
							+ "', vacancy='" + vacancy.getSelectedItem()+ "', Qualification='" +Qualification.getSelectedItem()
							+ "', mobile='" + mobile.getText()
							+ "', email='" + email.getText()+ "' WHERE id = '"+is+"'");
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,"Error in database connection"+e.getMessage());
					}
				}
		});
		/////////////////////////////////////////////////////////////////////////

		///delete button  removes the data in the database as specified by row
		delete.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent event0) {
			// TODO Auto-generated method stub
			try{
	String is=JOptionPane.showInputDialog("Enter your phone number");
			
			
	ExecCmd("DELETE  FROM applicant WHERE mobile ='"+is+"'");
				
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,"Error in database connection"+e.getMessage());
					}
				}
		});
		////////////////////////////////////////////////////////////////////
		
		//display button triggers the  database to output the data in a textfile
		display.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
		
				//String kontact=JOptionPane.showInputDialog("Enter your phone no");
				ExecQuery("SELECT * FROM applicant ");
		 

			}
		});
		}

	////to create a connection to database 
	public void ExecCmd(String statement){
		Connection conn=null;
		Statement st=null; 
		try{
			//API on hw t connect to dtabasw
	conn=DriverManager.getConnection("jdbc:sqlite:Info.db");
	
	 st=conn.createStatement();
	 
	 String sequel= "CREATE TABLE Applicant"+
	 "(name TEXT NOT NULL,"+"Age INT NOT NULL,"+"gender TEXT NOT NULL,"+
	" vacancy TEXT NOT NULL,"+"Qualification TEXT NOT NULL,"+" mobile INT NOT NULL,"+
	"email TEXT NOT NULL)";
	
	st.executeUpdate(sequel);
	 st.executeUpdate(statement);
	
	 JOptionPane.showMessageDialog(null," Operation Successful !");
		
		}catch(SQLException e){
			
				//connection to th database has failed
			 JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	public void ExecQuery(String statement){
	
		
		//frame for the table
		JFrame	frame1=new JFrame("Data");
		
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		frame1.setSize(640, 480);
		frame1.setLayout(new BorderLayout());
		frame1.setLocationRelativeTo(null);
		///
		
		
		//name of  the columns of the table
		 String[] column={"name","Age","gender","vacancy","Qualification","mobile","email"};
		
		 Connection conn=null;
			Statement st=null; 
			try{
				//API for connecting to the mysql database 
	conn=DriverManager.getConnection("jdbc:mysql://localhost/testdb","root","");

	 st=conn.createStatement();
	
	 //get the sql command and store into the ResultSet
	 ResultSet res= st.executeQuery(statement);

	//creates the table
	DefaultTableModel table=new DefaultTableModel();
	table.setColumnIdentifiers(column);
	JTable table1=new JTable();
	
	////
		while(res.next()){
	 		///fetch the data from the ResultSet object and store it in the JTable
			String temp1=res.getString("name");
	 		String temp2=res.getString("Age");
	 		String temp3=res.getString("gender");
	 		String temp4=res.getString("vacancy");
	 		String temp5=res.getString("Qualification");
	 		String temp6=res.getString("mobile");
	 		String temp7=res.getString("email");
	 
	 		///storing the data obtained from the database into the table
	 table.addRow(new Object[]{temp1,temp2,temp3,temp4,temp5,temp6,temp7});
	 
	 //it can make  the table columns to resize
	 table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

	 
	 		table1.setModel(table);
	 		
	 		//add the table to the window
	 		frame1.add(table1);	
		}
	 	}catch(SQLException e){
			
	 			//send a message if the database connection fails
			 JOptionPane.showMessageDialog(null,e.getMessage());
		}
		frame1.setVisible(true);	//Show the table in the frame and make the frame visible
	}
		
		}
	
	
	
	
	
	


