package org.example.entity;

public class Person {
    private String personID;
    private String personName;

    public Person(){}

    public Person(String personID, String personName){
        this.personID = personID;
        this.personID = personName;
    }
    public String getPersonID(){
        return personID;
    }
    public void setPersonID(String personID){
        this.personID = personID;
    }
    public String getPersonName(){
        return personName;
    }
    public void setPersonName(String personName){
        this.personName = personName;
    }
}
