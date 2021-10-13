package com.julius745.crudfile;

public class notesmodels {
    int id;
    String name;
    Boolean checked;

    public notesmodels(){

    }

    public notesmodels(int id, String name, Boolean checked){
        this.id = id;
        this.name = name;
        this.checked = checked;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setId(String name){
        this.name = name;
    }

    public Boolean getChecked(){
        return checked;
    }

    public void setId(Boolean checked){
        this.checked = checked;
    }
}
