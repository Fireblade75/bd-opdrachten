package com.example.store.services;

import com.example.store.services.intbox.IntBox;
import com.example.store.services.intbox.IntBoxUtilService;

public class CalculatorService {

    private final AdderService adderService;
    private final IntBoxUtilService ibService;

    public CalculatorService(AdderService adderService, IntBoxUtilService ibService) {
        this.adderService = adderService;
        this.ibService = ibService;
    }

    public IntBox box(int i) {
        return ibService.build(i);
    }

    public int unBox(IntBox intBox) {
        return ibService.getInt(intBox);
    }

    public IntBox add(IntBox first, IntBox second) {
        return adderService.add(first, second);
    }

    public IntBox multiply(IntBox first, IntBox second) {
        IntBox result = ibService.build(0);
        for (int i = 0; i < ibService.getInt(second); i++) {
            result = add(result, first);
        }
        return result;
    }
}
