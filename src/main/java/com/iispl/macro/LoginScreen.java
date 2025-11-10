package com.iispl.macro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.zkoss.zk.ui.HtmlMacroComponent;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

import com.iispl.dbconnection.DBConnections;

public class LoginScreen extends HtmlMacroComponent{

	@Wire
	Textbox tUsername, tPassword;
	
	@Wire
	Button bSubmit, bReset;
	
	public LoginScreen() {
		setMacroURI("/macroComponent/login.zul");
	}
	
	@Override
	public void afterCompose() {
		// TODO Auto-generated method stub
		super.afterCompose();
		bSubmit.addForward(Events.ON_CLICK, this, "onSubmit");
		
	}
	
	public void setPassword(String s) {
		tPassword.setText(s);
	}
	
	public String getPassword() {
		return tPassword.getValue();
	}
	
	public boolean validateUser() {
		String uname = tUsername.getValue();
		String pass = tPassword.getValue();
		
		Connection conn = DBConnections.getConnection();
		String query = "Select * from users where username=? and password=?";
		try  {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, uname);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Listen("onClick=#bReset")
	public void onReset() {
		tUsername.setValue("");
		tPassword.setValue("");
	}
}
