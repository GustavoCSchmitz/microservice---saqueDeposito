package br.com.microservice.saqueDeposito.controller.dto;

public class InfoOperacaoBancariaDTO {

	private Double valor;
	private CarteiraDTO carteira;
		
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}

	public CarteiraDTO getCarteira() {
		return carteira;
	}

	public void setCarteira(CarteiraDTO carteira) {
		this.carteira = carteira;
	}
	
}