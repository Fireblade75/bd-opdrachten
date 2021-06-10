package com.example.store.services;

import com.example.store.services.intbox.IntBox;
import com.example.store.services.intbox.IntBoxUtilService;

public class AdderService {

    private final IntBoxUtilService ibService;

    public AdderService(IntBoxUtilService intBoxUtilService) {
        this.ibService = intBoxUtilService;
    }

    public IntBox add(IntBox first, IntBox second) {
        int result = ibService.getInt(first) + ibService.getInt(second);
        return ibService.build(result);
    }

}
