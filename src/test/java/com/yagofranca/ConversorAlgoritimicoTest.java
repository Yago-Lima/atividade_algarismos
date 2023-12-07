package com.yagofranca;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ConversorAlgoritimicoTest {

    ConversorAlgoritimico conversorAlgoritimico;

    @BeforeEach
    void setUp() {
        conversorAlgoritimico = new ConversorAlgoritimico();
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource({
            "1, I",
            "5, V",
            "4, IV",
            "18, XVIII",
            "51, LI",
            "150, CL",
            "510, DX",
            "3000, MMM",
            "3999, MMMCMXCIX"
    })

    void deveConverterEntradaEmRomanos(int entrada, String resultadoEsperado) {
        assertEquals(resultadoEsperado, conversorAlgoritimico.converterEmRomanos(entrada));
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource({
            "I, 1",
            "III, 3",
            "V, 5",
            "XVIII, 18",
            "LI, 51",
            "CL, 150",
            "DX, 510",
            "MMM, 3000",
            "MMMCMXCIX, 3999"

    })
    void deveConverterEntradaEmDecimais(String entrada, String resultadoEsperado) {
        assertEquals(resultadoEsperado, conversorAlgoritimico.converterEmDecimal(entrada));
    }

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "5,1,4",
            "10,1,9",
    })
    void deveSubtrair(int valorProximo,int valorAtual,int resultadoEsperado) {
        assertEquals(resultadoEsperado, conversorAlgoritimico.subtrair(valorAtual,valorProximo));
    }

     @ParameterizedTest(name = "{0} = {1}")
    @CsvSource({
            "0, use apenas numeros entre 1 e 3999",
            "4000,use apenas numeros entre 1 e 3999",
    })
    void deveValidarNumeros(int entrada, String resultadoEsperado) {
        assertEquals(resultadoEsperado, ConversorAlgoritimico.converterEmRomanos(entrada));
    }

     @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "X, XXXI, true",
            "X,XXXX,false",
            "X,IIVXXXX,false",
            "I,IIII, false",

    })
    void deveValidarAlgarismos(char atual,String entrada, String resultadoEsperado) {
        assertEquals(resultadoEsperado, String.valueOf( ConversorAlgoritimico.validaAlgarismo(atual,entrada)));
    }



   
}
