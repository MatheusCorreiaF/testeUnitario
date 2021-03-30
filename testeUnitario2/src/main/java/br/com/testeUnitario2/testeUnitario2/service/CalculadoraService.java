package br.com.testeUnitario2.testeUnitario2.service;

import br.com.testeUnitario2.testeUnitario2.model.Parametros;
import br.com.testeUnitario2.testeUnitario2.model.Resultado;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public Resultado soma(Parametros parametros) {

        if(parametros.getP1()<0 || parametros.getP2()<0)
            throw new IllegalArgumentException("Valor negativo não permitido!");

        parametros = maisUm(parametros);

        return new Resultado(parametros.getP1() + parametros.getP2());
    }

    public Parametros maisUm( Parametros parametros)
    {
        return new Parametros(parametros.getP1() + 0.5, parametros.getP2()+ 0.5);
    }
}
