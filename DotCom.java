package ch16.dotcom;

import java.util.ArrayList;

public class DotCom {
    private ArrayList<String> locations;
    private String name;

    public DotCom(String name) {
        this.name = name;
    }

    public void setLocations(ArrayList<String> locations) {
        this.locations = locations;
    }

    public String checkYourself(String userGuess) {
        String status = "miss";
        int index = locations.indexOf(userGuess);
        if(index >= 0){
            locations.remove(index);
            if(locations.isEmpty()){
                status = "kill";
            } else {
                status = "hit";
            }
        }
        return status;
    }

    @Override
    public String toString() {
        return name;
    }
}
