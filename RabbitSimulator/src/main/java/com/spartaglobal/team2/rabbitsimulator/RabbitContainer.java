package com.spartaglobal.team2.rabbitsimulator;

import java.util.ArrayList;

public class RabbitContainer extends ArrayList{
    ArrayList<Rabbit> rabbits;

    public RabbitContainer(){}
    public RabbitContainer(char gender){
        if(gender == 'm'){
            this.rabbits.add(new MaleRabbit());
        }else if(gender == 'f'){
            this.rabbits.add(new FemaleRabbit());
        }
    }

    public void checkIsDead(){
        for (Rabbit r : rabbits){
            if(r.getAge()>=60){
                rabbits.remove(r);
            }
        }
    }
}
