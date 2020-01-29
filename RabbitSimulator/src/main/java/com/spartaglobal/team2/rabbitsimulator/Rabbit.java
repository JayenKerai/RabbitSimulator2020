package com.spartaglobal.team2.rabbitsimulator;

public abstract class Rabbit {
    private int age = 0; //age in months
    private boolean isMature = false;
    private String gender;
    private boolean isPregnant = false;

    public Rabbit() {
    }

    public void increaseAge() {
        this.age++;
        if(!this.isMature()){ //everytime age is incremented, the check for mature will be performed
            this.updateIsMature();
        }//else{checkIsDead();}
    }

    public void updateIsMature() {
        if(age >= 3){
            this.isMature = true;
        }
    }
    public boolean isPregnant() {
        return isPregnant;
    }
    public int getAge() {
        return age;
    }
    public boolean isMature() {
        return isMature;
    }
    public String getGender() {
        return gender;
    }

    public void setMature(boolean mature) {
        isMature = mature;
    }
    public void setGender(String gender) {
        this.gender = gender.toLowerCase();
    }
    public void setPregnant(boolean pregnant) {
        isPregnant = pregnant;
    }
}
