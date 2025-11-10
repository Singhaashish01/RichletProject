package com.iispl.userauthentication;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class LoginComposer extends SelectorComposer<Window>{

	@Wire
	Textbox username, pwd;
	
	@Wire
	Button logn;
	
	@Override
	public void doAfterCompose(Window comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
	}
	
	@Listen("onClick=#logn")
	public void onLogin() {
		String user= username.getText();
	String pass = 	pwd.getText();
	if(user.equals("Aashu")&& pass.equals("Aashu@123")) {
		Session session = Sessions.getCurrent();
		session.setAttribute("currentUser", username.getValue());
		Executions.sendRedirect("logout.zul");
	} else {
		Messagebox.show("Invalid Credentials");
	}
		
	}
}
