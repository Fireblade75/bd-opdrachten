package com.example.tdd;

import com.example.tdd.traject.Plaats;
import com.example.tdd.traject.Traject;

import java.util.ArrayList;
import java.util.List;

public class TrajectNaarTrajectEenhedenService {

    private List<Traject> trajectList = new ArrayList<>();

    public TrajectNaarTrajectEenhedenService() {
        trajectList.add(new Traject(Plaats.AMSTERDAM, Plaats.UTRECHT, 82));
        trajectList.add(new Traject(Plaats.AMSTERDAM, Plaats.ENSCHEDE, 247));
        trajectList.add(new Traject(Plaats.AMSTERDAM, Plaats.ZWOLLE, 199));
        trajectList.add(new Traject(Plaats.ENSCHEDE, Plaats.UTRECHT, 229));
        trajectList.add(new Traject(Plaats.ENSCHEDE, Plaats.ZWOLLE, 136));
        trajectList.add(new Traject(Plaats.ZWOLLE, Plaats.UTRECHT, 168));
    }

    public int getTrajectEenheden(String from, String to) throws InvalidLocationException, InvalidTrajectException {
        for(var traject : trajectList) {
            if(traject.containsLocations(from, to)) {
                return traject.getTrajectEenheden();
            }
        }
        throw new InvalidTrajectException();
    }
}
