package br.com.microservice.saqueDeposito.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.saqueDeposito.controller.dto.InfoOperacaoBancariaDTO;
import br.com.microservice.saqueDeposito.service.DepositoService;

@RestController
public class DepositoController {
	
	@Autowired private DepositoService depositoService;
	
	@PostMapping("/deposito")
	public ResponseEntity<String> realizaDeposito(@RequestBody InfoOperacaoBancariaDTO deposito) throws IOException{
		try {
			depositoService.realizaDeposito(deposito);
			return new ResponseEntity<>("Depósito no valor de R$"+deposito.getValor()+" realizado com sucesso", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("Ocorreu um erro durante a execução do depósito", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}