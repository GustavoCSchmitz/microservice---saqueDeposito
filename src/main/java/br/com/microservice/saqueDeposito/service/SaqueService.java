package br.com.microservice.saqueDeposito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.microservice.saqueDeposito.controller.dto.InfoOperacaoBancariaDTO;

@Service
public class SaqueService {

	@Autowired private RestTemplate client;
	
	public void realizaSaque(InfoOperacaoBancariaDTO saque) {
		//externalizar urls
		client.exchange("http://carteira/saque",HttpMethod.POST, new HttpEntity<String>(montaJson(saque), null), String.class);
	}
	
	private String montaJson(InfoOperacaoBancariaDTO saqueDeposito) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		return gson.toJson(saqueDeposito);
	}

}