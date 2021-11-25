package br.com.microservice.saqueDeposito.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.saqueDeposito.controller.dto.InfoOperacaoBancariaDTO;
import br.com.microservice.saqueDeposito.service.SaqueService;

@RestController
public class SaqueController {
	
	@Autowired private SaqueService saqueService;
	
	@PostMapping("/saque")
	public ResponseEntity<String> realizaSaque(@RequestBody InfoOperacaoBancariaDTO saque) throws IOException{
		try {
			return saqueService.realizaSaque(saque);
			//return new ResponseEntity<>("Saque no valor de R$"+saque.getValor()+" realizado com sucesso", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>("Ocorreu um erro durante a execução do saque", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}