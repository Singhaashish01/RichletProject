package com.iispl.assignment;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

public class AdminComposer extends SelectorComposer<Window>{

	@Override
    public void doBeforeComposeChildren(Window comp) throws Exception {
        super.doBeforeComposeChildren(comp);

        String role = (String) Sessions.getCurrent().getAttribute("role");

        //  Check if user is logged in
        if (role == null) {
            Executions.sendRedirect("/login.zul");
            return;
        }

        //  Restrict non-admin users
        if (!"admin".equals(role)) {
            Executions.sendRedirect("/accessDenied.zul");
        }
    }

    
    @Listen("onClick = #logoutBtn")
    public void logout() {
        Sessions.getCurrent().invalidate();
        Executions.sendRedirect("/login.zul");
    }
}
