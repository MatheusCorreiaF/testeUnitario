package br.com.testeUnitario2.testeUnitario2.controller;

import br.com.testeUnitario2.testeUnitario2.model.Parametros;
import br.com.testeUnitario2.testeUnitario2.model.Resultado;
import br.com.testeUnitario2.testeUnitario2.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CalculadoraController {

    @Autowired
    CalculadoraService calculadoraService;

    @GetMapping("calcula/{n1}/{n2}")
    public ResponseEntity<Resultado> getEvento(@PathVariable(value = "n1") Double n1, @PathVariable(value = "n2") Double n2) {

        Parametros parametros = new Parametros(n1,n2);

        Resultado result = calculadoraService.soma(parametros);

        return ResponseEntity.ok(result);
    }
}
