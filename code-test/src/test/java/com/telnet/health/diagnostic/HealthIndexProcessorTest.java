package com.telnet.health.diagnostic;
import com.telnet.health.diagnostic.service.MedicalUnitResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HealthIndexProcessorTest {

    @Mock
    private MedicalUnitResolver resolver;

    private HealthIndexProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new HealthIndexProcessor(resolver);
    }

    @Test
    void givenNoUnits_returnsNoneMessage() {
        when(resolver.resolve(7)).thenReturn(List.of());

        String result = processor.getMedicalUnits(7);

        assertEquals("Aucune pathologie détectée.", result);
        verify(resolver, times(1)).resolve(7);
        verifyNoMoreInteractions(resolver);
    }

    @Test
    void givenOneUnit_returnsUnitOnly() {
        when(resolver.resolve(9)).thenReturn(List.of("Cardiologie"));

        String result = processor.getMedicalUnits(9);

        assertEquals("Cardiologie", result);
        verify(resolver).resolve(9);
    }

    @Test
    void givenMultipleUnits_returnsCommaSeparated() {
        when(resolver.resolve(15)).thenReturn(List.of("Cardiologie", "Traumatologie"));

        String result = processor.getMedicalUnits(15);

        assertEquals("Cardiologie, Traumatologie", result);
        verify(resolver).resolve(15);
    }
}
