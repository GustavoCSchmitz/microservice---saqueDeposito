package br.com.microservice.saqueDeposito.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.saqueDeposito.controller.dto.TransferenciaDTO;
import br.com.microservice.saqueDeposito.service.TransferenciaService;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {
	
	@Autowired private TransferenciaService transferenciaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> realizaTransferencia(@RequestBody TransferenciaDTO transferencia) throws IOException{
		String mensagem;
		try {
			transferenciaService.realizaTransferencia(transferencia);
			mensagem = "Transferência no valor de R$" + transferencia.getValor() + " de " + transferencia.getOrigem().getTitular() +
					" para " + transferencia.getDestino().getTitular() + " realizada com sucesso";
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		}catch(Exception e) {
			mensagem = "Ocorreu um erro durante a execução do saque";
			return new ResponseEntity<>(mensagem, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
