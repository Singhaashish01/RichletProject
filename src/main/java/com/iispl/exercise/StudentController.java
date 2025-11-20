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

	    private ListModelList<Student> lml;

	    @Override
	    public void doAfterCompose(Window comp) throws Exception {
	        super.doAfterCompose(comp);

	        DBConnection db = new DBConnection();
	        lml = new ListModelList<>(db.getAllStudents());
	        studentListbox.setModel(lml);
	        studentListbox.setItemRenderer(new StudentRenderer(this));
	    }

	    
	    public void deleteStudent(Student s) {
	        DBConnection db = new DBConnection();

	        if (db.deleteStudent(s.getId())) {
	            lml.remove(s);   
	        }
	    }
}
