package com.example.tdd;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class TrajectPrijsServiceTest {

    @Test
    void testGetTrajectPrijs() throws InvalidLocationException, InvalidTrajectException {
        var trajectNaarTrajectEenhedenService = Mockito.mock(TrajectNaarTrajectEenhedenService.class);
        var trajectEenhedenNaarPrijsService = Mockito.mock(TrajectEenhedenNaarPrijsService.class);

        Mockito.when(trajectNaarTrajectEenhedenService.getTrajectEenheden("AMSTERDAM", "ENSCHEDE")).thenReturn(5);
        Mockito.when(trajectEenhedenNaarPrijsService.getPriceTrajectEenheden(5)).thenReturn(18);

        TrajectPrijsService trajectPrijsService = new TrajectPrijsService(trajectEenhedenNaarPrijsService, trajectNaarTrajectEenhedenService);
        assertThatCode(() -> {
            int prijs = trajectPrijsService.getTrajectPrijs("AMSTERDAM", "ENSCHEDE");
            assertThat(prijs).isEqualTo(18);
        }).doesNotThrowAnyException();
    }

    @Test
    void testGetTrajectPrijsNonExisting() throws InvalidLocationException, InvalidTrajectException {
        var trajectNaarTrajectEenhedenService = Mockito.mock(TrajectNaarTrajectEenhedenService.class);
        var trajectEenhedenNaarPrijsService = Mockito.mock(TrajectEenhedenNaarPrijsService.class);

        Mockito.when(trajectNaarTrajectEenhedenService.getTrajectEenheden(Mockito.eq("PARIJS"), Mockito.anyString())).thenThrow(new InvalidLocationException());

        TrajectPrijsService trajectPrijsService = new TrajectPrijsService(trajectEenhedenNaarPrijsService, trajectNaarTrajectEenhedenService);

        assertThatCode(() -> {
            int prijs = trajectPrijsService.getTrajectPrijs("PARIJS", "ENSCHEDE");
        }).isInstanceOf(InvalidLocationException.class);

    }
}