package com.sergames.models;

import com.sergames.models.Airplane;

public class CommercialAirplane extends Airplane {
    public CommercialAirplane(String licensePlate) {
        super(licensePlate, Type.COMMERCIAL);
    }
}
