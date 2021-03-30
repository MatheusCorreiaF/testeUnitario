package br.com.testeUnitario2.testeUnitario2.service;

import br.com.testeUnitario2.testeUnitario2.model.Parametros;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class CalculadoraServiceTest {

    @TestConfiguration
    static class CalculadoraServiceTestConfiguration {

        @Bean
        public CalculadoraService calculadoraService() {
            return new CalculadoraService();
        }
    }

    @Autowired
    CalculadoraService calculadoraService;

    @Test
    public void soma() {

        Parametros parametros = new Parametros(5.0,4.0);

        Assertions.assertEquals(9.0, calculadoraService.soma(parametros).getResultado());
    }
}