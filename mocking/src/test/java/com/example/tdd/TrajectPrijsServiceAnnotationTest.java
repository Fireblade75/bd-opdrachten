package com.example.tdd;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.Mockito.*;

public class TrajectPrijsServiceAnnotationTest {

    @Mock
    TrajectNaarTrajectEenhedenService eenhedenService;

    @Mock
    TrajectEenhedenNaarPrijsService prijsService;

    @InjectMocks
    TrajectPrijsService trajectPrijsService;

    @Test
    void testGetTrajectPrijs() throws InvalidLocationException, InvalidTrajectException {
        when(eenhedenService.getTrajectEenheden(eq("AMSTERDAM"), eq("ENSCHEDE"))).thenReturn(5);
        when(prijsService.getPriceTrajectEenheden(eq(5))).thenReturn(18);

        assertThatCode(() -> {
            int prijs = trajectPrijsService.getTrajectPrijs("AMSTERDAM", "ENSCHEDE");
            assertThat(prijs).isEqualTo(18);
        }).doesNotThrowAnyException();

        verify(eenhedenService.getTrajectEenheden(anyString(), anyString()));
        verify(prijsService.getPriceTrajectEenheden(any()));
    }

    @Test
    void testGetTrajectPrijsNonExisting() throws InvalidLocationException, InvalidTrajectException {
        Mockito.when(eenhedenService.getTrajectEenheden(eq("PARIJS"), Mockito.anyString())).thenThrow(new InvalidLocationException());

        assertThatCode(() -> {
            int prijs = trajectPrijsService.getTrajectPrijs("PARIJS", "ENSCHEDE");
        }).isInstanceOf(InvalidLocationException.class);

    }
}
