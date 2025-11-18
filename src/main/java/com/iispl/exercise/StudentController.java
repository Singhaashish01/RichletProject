package com.iispl.exercise;

import java.util.List;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Window;

public class StudentController extends SelectorComposer<Window>{

	@Wire
    private Listbox studentListbox;

    @Override
    public void doAfterCompose(Window comp) throws Exception {
        super.doAfterCompose(comp);

        DBConnection db = new DBConnection();
        List<Student> students = db.getAllStudents();
        ListModelList<Student> lml = new ListModelList<>(students);
        studentListbox.setModel(lml);
        studentListbox.setItemRenderer(new StudentRenderer());
    }
}
