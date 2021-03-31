package com.example.tdd2;

public class TrajectEenhedenNaarPrijsService {
    public int getPriceTrajectEenheden(int aantalTrajectEenheden) {
        return Math.min(8, (int) Math.floor(aantalTrajectEenheden * 0.1));
    }
}
