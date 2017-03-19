package br.com.CalculadoraSimples;

import java.awt.event.ActionListener;

public class BotaoIgual extends Botao {

	public BotaoIgual(String texto, ActionListener evento){
		super(texto);
		
		/* Adicionando o nome do comando, e aplicando o evento sobre ele */
		this.setActionCommand("botaoIgual");
		this.addActionListener(evento);
		
		
	}
	
	
}
