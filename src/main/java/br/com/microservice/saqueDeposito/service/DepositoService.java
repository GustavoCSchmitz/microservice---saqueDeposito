package br.com.microservice.saqueDeposito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.microservice.saqueDeposito.controller.dto.InfoOperacaoBancariaDTO;

@Service
public class DepositoService {
	
	@Autowired private RestTemplate client;

	public ResponseEntity<String> realizaDeposito(InfoOperacaoBancariaDTO deposito) {
		if(verificaSeValorEhValido(deposito)) 
			return client.exchange("http://carteira/deposito",HttpMethod.POST, new HttpEntity<String>(montaJson(deposito), null), String.class);
		return new ResponseEntity<>("O valor do depósito não pode ser negativo", HttpStatus.INTERNAL_SERVER_ERROR);
				
	}
	
	private boolean verificaSeValorEhValido(InfoOperacaoBancariaDTO deposito) {		
		return deposito.getValor() > 0;
	}

	private String montaJson(InfoOperacaoBancariaDTO saqueDeposito) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		return gson.toJson(saqueDeposito);
	}
}
