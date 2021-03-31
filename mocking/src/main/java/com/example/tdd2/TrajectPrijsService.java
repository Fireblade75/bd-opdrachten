package com.example.tdd2;

public class TrajectPrijsService {

    private TrajectEenhedenNaarPrijsService trajectEenhedenNaarPrijsService;
    private TrajectNaarTrajectEenhedenService trajectNaarTrajectEenhedenService;

    public TrajectPrijsService(TrajectEenhedenNaarPrijsService trajectEenhedenNaarPrijsService, TrajectNaarTrajectEenhedenService trajectNaarTrajectEenhedenService) {
        this.trajectEenhedenNaarPrijsService = trajectEenhedenNaarPrijsService;
        this.trajectNaarTrajectEenhedenService = trajectNaarTrajectEenhedenService;
    }

    public int getTrajectPrijs(String from, String to) throws InvalidLocationException, InvalidTrajectException {
        int trajectEenheid = trajectNaarTrajectEenhedenService.getTrajectEenheden(from, to);
        return trajectEenhedenNaarPrijsService.getPriceTrajectEenheden(trajectEenheid);
    }
}
