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
import static java.util.Objects.isNull;

import br.com.microservice.saqueDeposito.controller.dto.TransferenciaDTO;

@Service
public class TransferenciaService {

	@Autowired private RestTemplate client;
	
	public ResponseEntity<String> realizaTransferencia(TransferenciaDTO transferencia) {
		if(!valorDaTransferenciaEhValido(transferencia.getValor()))
			return new ResponseEntity<String>("O valor da transferencia não pode ser negativo", HttpStatus.INTERNAL_SERVER_ERROR);
		return client.exchange("http://carteira/transferencia",HttpMethod.POST, new HttpEntity<String>(montaJson(transferencia), null), String.class);			
	}
	
	private boolean valorDaTransferenciaEhValido(Double valor) {
		return valor > 0;
	}


	private String montaJson(TransferenciaDTO saqueDeposito) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		return gson.toJson(saqueDeposito);
	}

}
