package com.telnet.health.diagnostic.service.impl;

import com.telnet.health.diagnostic.service.MedicalUnitResolver;

import java.util.ArrayList;
import java.util.List;

import static com.telnet.health.diagnostic.enums.MedicalUnit.CARDIOLOGY;
import static com.telnet.health.diagnostic.enums.MedicalUnit.TRAUMATOLOGY;

public class DefaultMedicalUnitResolver implements MedicalUnitResolver {
    @Override
    public List<String> resolve(int patientIndex) {
        List<String> medicalUnits = new ArrayList<>();
        if (patientIndex % 3 == 0) {
            medicalUnits.add(CARDIOLOGY.getDisplayName());
        }
        if (patientIndex % 5 == 0) {
            medicalUnits.add(TRAUMATOLOGY.getDisplayName());
        }

        return medicalUnits;
    }
}
