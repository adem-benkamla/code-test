package com.telnet.health.diagnostic;

import com.telnet.health.diagnostic.service.MedicalUnitResolver;

import java.util.List;

/**
 * Processes a health index by delegating to a MedicalUnitResolver.
 */
public class HealthIndexProcessor {
    private final MedicalUnitResolver resolver;

    public HealthIndexProcessor(MedicalUnitResolver resolver) {
        this.resolver = resolver;
    }

    public String getMedicalUnits(int index) {
        List<String> units = resolver.resolve(index);
        if (units.isEmpty()) {
            return "Aucune pathologie détectée.";
        }

        return String.join(", ", units);
    }
}
