package com.iispl.assignment;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.Window;

public class DashboardComposer extends SelectorComposer<Window>{

	@Override
    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);

        Session sess = Sessions.getCurrent();
        String role = (String) sess.getAttribute("role");

        if (role == null) {
            Executions.sendRedirect("/login.zul");
        } else if (!"admin".equals(role)) {
            Executions.sendRedirect("/accessDenied.zul");
        }
    }
}
