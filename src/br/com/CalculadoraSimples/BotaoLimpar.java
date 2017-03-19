package br.com.CalculadoraSimples;

import java.awt.event.ActionListener;

public class BotaoLimpar extends Botao {

	public BotaoLimpar(String limpar, ActionListener evento){
		super(limpar);
		/* Adicionando o nome do comando, e aplicando o evento sobre ele */
		this.setActionCommand("botaoLimpar");
		this.addActionListener(evento);
	}



	
}
