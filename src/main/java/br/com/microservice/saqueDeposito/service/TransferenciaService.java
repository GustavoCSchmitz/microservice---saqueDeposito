package br.com.microservice.saqueDeposito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.microservice.saqueDeposito.controller.dto.TransferenciaDTO;

@Service
public class TransferenciaService {

	@Autowired private RestTemplate client;
	
	public void realizaTransferencia(TransferenciaDTO transferencia) {
		client.exchange("http://carteira/transferencia",HttpMethod.POST, new HttpEntity<String>(montaJson(transferencia), null), String.class);			
	}
	
	private String montaJson(TransferenciaDTO saqueDeposito) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		return gson.toJson(saqueDeposito);
	}

}
