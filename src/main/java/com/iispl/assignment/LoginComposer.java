package com.iispl.assignment;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class LoginComposer extends SelectorComposer<Window>{

	@Wire
    private Textbox username;
    
    @Wire
    private Textbox password;

    @Wire
    private Label message;

    @Listen("onClick = #loginBtn")
    public void doLogin() {
        String user = username.getValue();
        String pass = password.getValue();

        // Dummy authentication (You can replace it with DB check)
        if("Aashu".equals(user) && "Aashu@1234".equals(pass)) {
            Session sess = Sessions.getCurrent();
            sess.setAttribute("user", user);
            sess.setAttribute("role", "admin");

            Clients.showNotification("Login Successful!", "info", null, "top_center", 2000);
            Executions.sendRedirect("/dashbord.zul");
        } else if("user".equals(user) && "123".equals(pass)) {
            Session sess = Sessions.getCurrent();
            sess.setAttribute("user", user);
            sess.setAttribute("role", "user");

            Clients.showNotification("Login Successful!", "info", null, "top_center", 2000);
            Executions.sendRedirect("/userHome.zul");
        } else {
            Messagebox.show("Invalid Username or Password!");
        }
    }
}
