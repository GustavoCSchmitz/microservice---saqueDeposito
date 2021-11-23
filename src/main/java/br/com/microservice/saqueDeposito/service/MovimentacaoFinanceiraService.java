package br.com.microservice.saqueDeposito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MovimentacaoFinanceiraService {

	@Autowired private RestTemplate client;
	
	public ResponseEntity<String> getMovimentacoes(Integer idTitular) {
		return client.exchange("http://carteira/movimentacoes/"+idTitular,HttpMethod.GET, null, String.class);				
	}
}
