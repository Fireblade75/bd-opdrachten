package com.example.tdd2.traject;

import com.example.tdd2.InvalidLocationException;

import java.util.HashSet;
import java.util.Set;

public class Traject {
    private final Set<Plaats> plaatsen = new HashSet<Plaats>(2);;
    private final int trajectEenheden;

    public Traject(Plaats plaats1, Plaats plaats2, int trajectEenheden) {
        this.plaatsen.add(plaats1);
        this.plaatsen.add(plaats2);
        this.trajectEenheden = trajectEenheden;
    }

    public int getTrajectEenheden() {
        return trajectEenheden;
    }

    public Set<Plaats> getPlaatsen() {
        return plaatsen;
    }

    public boolean containsLocations(String from, String to) throws InvalidLocationException {
        try {
            return plaatsen.contains(Plaats.valueOf(from.toUpperCase()))
                    && plaatsen.contains(Plaats.valueOf(to.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new InvalidLocationException();
        }
    }
}
