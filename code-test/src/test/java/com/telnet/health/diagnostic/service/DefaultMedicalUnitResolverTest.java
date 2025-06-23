package com.telnet.health.diagnostic.service;

import com.telnet.health.diagnostic.service.impl.DefaultMedicalUnitResolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("DefaultMedicalUnitResolver Tests")
class DefaultMedicalUnitResolverTest {

    private final DefaultMedicalUnitResolver resolver = new DefaultMedicalUnitResolver();

    @Test
    @DisplayName("returns empty when not multiple of 3 or 5")
    void testNone() {
        List<String> units = resolver.resolve(7);
        assertTrue(units.isEmpty(), "Expected no units for index 7");
    }

    @ParameterizedTest(name = "index={0} yields {1}")
    @CsvSource({
            "3, Cardiologie",
            "5, Traumatologie",
            "15, Cardiologie|Traumatologie"
    })
    @DisplayName("returns correct units for multiples of 3, 5, and both")
    void testMultiples(int index, String expectedJoined) {
        List<String> units = resolver.resolve(index);
        String joined = String.join("|", units);
        assertEquals(expectedJoined, joined);
    }
}
