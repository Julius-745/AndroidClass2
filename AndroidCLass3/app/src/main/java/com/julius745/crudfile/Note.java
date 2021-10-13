package com.julius745.crudfile;

public class Note {
    long id;
    String content;
    Boolean checked;

    public Note(){

    }

    public Note(long id, String content, Boolean checked){
        this.id = id;
        this.content = content;
        this.checked = checked;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getContent(){
        return content;
    }

    public void setId(String name){
        this.content = name;
    }

    public Boolean getChecked(){
        return checked;
    }

    public void setId(Boolean checked){
        this.checked = checked;
    }
}
