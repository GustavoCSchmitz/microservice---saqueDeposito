package br.com.microservice.saqueDeposito.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.saqueDeposito.service.MovimentacaoFinanceiraService;

@RestController
public class MovimentacaoFinanceiraController {
		
	@Autowired private MovimentacaoFinanceiraService movimentacaoFinanceiraService;
	
	@GetMapping("/movimentacoes/{idTitular}")
	public ResponseEntity<String> realizaSaque(@PathVariable Integer idTitular) throws IOException{
		try {
			return movimentacaoFinanceiraService.getMovimentacoes(idTitular);
		}catch(Exception e) {
			return new ResponseEntity<>("Ocorreu um erro durante a execução do saque", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

