package com.iispl.internationalization;

import java.util.Locale;

import org.zkoss.web.Attributes;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

public class PopupComposer extends SelectorComposer<Window>{

	@Override
	public void doAfterCompose(Window comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
	}
	
	@Listen("onClick=#radioHin")
	public void setLocalelanguageHI() {
		Locale l = Locale.of("hi","IN");
		Sessions.getCurrent().setAttribute(Attributes.PREFERRED_LOCALE, l);
		Executions.sendRedirect("");
		Messagebox.show("Hindi");
		Executions.sendRedirect("Internationalization.zul");
		
	}
	
	@Listen("onClick=#radioEng")
	public void setLocalelanguageEG() {
		Locale locale = Locale.of("en","IN");
		Sessions.getCurrent().setAttribute(Attributes.PREFERRED_LOCALE, locale);
		Executions.sendRedirect("");
		Messagebox.show("English");
		Executions.sendRedirect("Internationalization.zul");
	}
	
	@Listen("onClick=#radioFre")
	public void setLocalelanguageFR() {
		Locale lcl = Locale.of("fr","FR");
		Sessions.getCurrent().setAttribute(Attributes.PREFERRED_LOCALE, lcl);
		Messagebox.show("French");
		Executions.sendRedirect("Internationalization.zul");
		
	}
}
