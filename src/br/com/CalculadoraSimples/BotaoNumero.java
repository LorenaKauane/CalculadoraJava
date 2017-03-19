package br.com.CalculadoraSimples;

import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class BotaoNumero extends Botao {

	private int numero;
	
	public BotaoNumero(int numero, ActionListener acao){
		
		super(String.valueOf(numero));
		this.numero = numero;
		
		/* Adicionando o nome do comando, e aplicando o evento sobre ele */
		this.setActionCommand("botaoNumero");
		this.addActionListener(acao);
	}

	public int getNumero() {
		return numero;
	}
	
}
