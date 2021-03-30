package br.com.testeUnitario2.testeUnitario2.service;

import br.com.testeUnitario2.testeUnitario2.model.Parametros;
import br.com.testeUnitario2.testeUnitario2.model.Resultado;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class CalculadoraServiceTest2 {

    @InjectMocks
    CalculadoraService calculadoraService;

    @Test
    public void shouldReturn10to5and4() {

        Parametros parametros = new Parametros(5.0,4.0);

        Assertions.assertEquals(10.0, calculadoraService.soma(parametros).getResultado());

    }

    @Test
    public void shouldReturn10to5and4WithMock() {

        Parametros parametros = new Parametros(5.0,4.0);
        Parametros parametros2 = new Parametros(6.0,5.0);

        when(calculadoraService.maisUm(eq(parametros))).thenReturn(parametros2);

        Resultado resultado = calculadoraService.soma(parametros);

        Assertions.assertEquals(11.0, resultado.getResultado());


    }

    @Test
    public void maisUm() {

        //Parametros parametrosReturn = mock(Parametros.class);

        Parametros parametros = new Parametros(5.0, 4.0);

        Assertions.assertEquals(10, calculadoraService.maisUm(parametros).getP1() + calculadoraService.maisUm(parametros).getP2());

    }

    @Test
    public void shouldThrowException() {

        Parametros parametros = new Parametros(-5.0,4.0);

        Assertions.assertThrows(IllegalArgumentException.class,() -> calculadoraService.soma(parametros));

    }
}