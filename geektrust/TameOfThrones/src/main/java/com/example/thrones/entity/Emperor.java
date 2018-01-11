package com.example.thrones.entity;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.thrones.constants.Constants.EMPEROR_NAME;
import static com.example.thrones.constants.Constants.MIN_ALLIES_FOR_EMPEROR;

/**
 * Created by akshay on 09/12/17.
 */
public class Emperor {

    private String name;

    public Emperor() {
        this.name = null;
        this.allies = new HashSet<String>();
    }

    public Set<String> getAllies() {
        return allies;
    }

    private Set<String> allies;

    public String getName() {
        return StringUtils.isEmpty(name)?"None":name;
    }

    private void setName(String name) {
        this.name = name;
    }

    /**
     * Method to add the allies for the current emperor
     * @param kingdom
     */
    public void addAllies(String kingdom){
        this.getAllies().add(kingdom);
        validateEmperorName();
    }

    /**
     * Method to set emperor name When the allies count goes up to 3
     */
    public void validateEmperorName(){
        if(this.getAllies().size()==MIN_ALLIES_FOR_EMPEROR){
            this.setName(EMPEROR_NAME);
        }
    }
}
