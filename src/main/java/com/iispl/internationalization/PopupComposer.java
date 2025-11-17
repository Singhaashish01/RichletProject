package com.iispl.internationalization;

import java.util.Locale;

import org.zkoss.web.Attributes;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;
import org.zkoss.zul.theme.Themes;

public class PopupComposer extends SelectorComposer<Window> {

    @Wire
    private Combobox themeBox;

    @Override
    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);
        String theme = (String) Sessions.getCurrent().getAttribute("currentTheme");
        if (theme != null) {
            Themes.setTheme(Executions.getCurrent(), theme);
            themeBox.setValue(theme);
        }
    }


    @Listen("onClick=#radioHin")
    public void setLocaleLanguageHI() {
        Locale l = Locale.of("hi", "IN");
        Sessions.getCurrent().setAttribute(Attributes.PREFERRED_LOCALE, l);
        Messagebox.show("Hindi language selected");
        Executions.sendRedirect("Internationalization.zul");
    }

    @Listen("onClick=#radioEng")
    public void setLocaleLanguageEN() {
        Locale l = Locale.of("en", "IN");
        Sessions.getCurrent().setAttribute(Attributes.PREFERRED_LOCALE, l);
        Messagebox.show("English language selected");
        Executions.sendRedirect("Internationalization.zul");
    }

    @Listen("onClick=#radioFre")
    public void setLocaleLanguageFR() {
        Locale l = Locale.of("fr", "FR");
        Sessions.getCurrent().setAttribute(Attributes.PREFERRED_LOCALE, l);
        Messagebox.show("French language selected");
        Executions.sendRedirect("Internationalization.zul");
    }


    @Listen("onChange=#themeBox")
    public void onThemeChange() {
        String selectedTheme = themeBox.getSelectedItem() != null
                ? themeBox.getSelectedItem().getValue()
                : "atlantic";

        Themes.setTheme(Executions.getCurrent(), selectedTheme);
        Sessions.getCurrent().setAttribute("currentTheme", selectedTheme);

        Messagebox.show("Theme changed to: " + selectedTheme);
        Executions.sendRedirect("Internationalization.zul");
    }
}
