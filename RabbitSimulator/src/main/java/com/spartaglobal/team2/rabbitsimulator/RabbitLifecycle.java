package com.spartaglobal.team2.rabbitsimulator;

import java.util.ArrayList;

public class RabbitLifecycle {//int months to run array
    RabbitContainer maleRabbits = new RabbitContainer('m');
    RabbitContainer femaleRabbits = new RabbitContainer('f');
    RabbitContainer deadRabbits = new RabbitContainer();

    public long getNumberOfRabbits(){
      return maleRabbits.size() + femaleRabbits.size();
    }
    public long getNumberOfMales(){
        return maleRabbits.size();
    }
    public long getNumberOfFemales(){
        return femaleRabbits.size();
    }
    public long getNumberOfDeadRabbits(){return deadRabbits.size();}
}
