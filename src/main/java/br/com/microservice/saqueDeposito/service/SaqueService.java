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
public class SaqueService {

	@Autowired private RestTemplate client;
	
	public ResponseEntity<String> realizaSaque(InfoOperacaoBancariaDTO saque) {
		if(verificaSaqueValido(saque))
			return client.exchange("http://carteira/saque",HttpMethod.POST, new HttpEntity<String>(montaJson(saque), null), String.class);
		return new ResponseEntity<String>("Não é possível realizar saque com valor negativo",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	private boolean verificaSaqueValido(InfoOperacaoBancariaDTO saque) {
		return saque.getValor() > 0;
	}

	private String montaJson(InfoOperacaoBancariaDTO saqueDeposito) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		return gson.toJson(saqueDeposito);
	}

}