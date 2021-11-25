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
			return depositoService.realizaDeposito(deposito);
		}catch(Exception e) {
			return new ResponseEntity<>("Ocorreu um erro durante a execução do depósito", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}