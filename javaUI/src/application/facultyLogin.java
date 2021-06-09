package application;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class facultyLogin {

		public facultyLogin() {
			
		}
	
	    @FXML
	    private TextField username;

	    @FXML
	    private PasswordField password;

	    @FXML
	    private Button login;

	    @FXML
	    private Button register;

	    @FXML
	    private Label warningLabel;

	    @FXML
	    void userLogin(ActionEvent event) throws IOException {
	    	System.out.println("checking...");
	    	checkLogin();
	    }

	    @FXML
	    void userRegiister(ActionEvent event) throws IOException {
	    	System.out.println("Register...");
	    	registerUser();
	    }
	    

	    private void checkLogin() throws IOException{
	    	Main m =new Main();

	    	try {
				BufferedReader br = new BufferedReader(new FileReader("facultyUsers.txt"));
				String temp;
				boolean isValid = false;
				while((temp = br.readLine())!=null) {
					String[] up = temp.split("#");
					if(username.getText().equals(up[0])) {
						if(password.getText().equals(up[1])) {
							isValid = true;
							break;
						}
					}
				}
				if(username.getText().isEmpty() && password.getText().isEmpty()) 
				{
			    		warningLabel.setText("Please enter data");
				}else {
					if(isValid) {
				
			    		warningLabel.setText("Success");
			    		m.changeScene("afterFacultyLogin.fxml");
			    		try  
			    		{  
			    		//constructor of the File class having file as an argument  
			    		FileReader fr=new FileReader("facultyUsers.txt");   
			    		System.out.println("faculty list: ");  
			    		int r=0;  
			    		while((r=fr.read())!=-1)  
			    		{  
			    		System.out.print((char)r);  //prints the content of the file   
			    		}  
			    		fr.close();
			    		fr=new FileReader("studentUsers.txt");   
			    		System.out.println("\n\nstudent list: ");  
			    		r=0;  
			    		while((r=fr.read())!=-1)  
			    		{  
			    		System.out.print((char)r);  //prints the content of the file   
			    		}  
			    		fr.close();

			    		}  
			    		catch(Exception e)  
			    		{  
			    		e.printStackTrace();  
			    		}
			    		

			    	}else
			    	{
			    		warningLabel.setText("Wrong username or Password");
			    	}

				}
				br.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
	    private void registerUser() throws IOException{
    		try {
    			Main m=new Main();
				File file = new File("facultyUsers.txt");
				FileWriter fr = new FileWriter(file,true);
				BufferedWriter br = new BufferedWriter(fr);
				PrintWriter pw = new PrintWriter(br);
				
				if(username.getText().isEmpty() && password.getText().isEmpty()) 
				{
			    		warningLabel.setText("Please enter data");
				}else {
				String temp = "\n"+username.getText() + "#" + password.getText();
				pw.append(temp);
				
				pw.close();
				warningLabel.setText("Now you can Login");
	    		m.changeScene("facultyLogin.fxml");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }
	

}
