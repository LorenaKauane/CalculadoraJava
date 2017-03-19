package br.com.CalculadoraSimples;

import java.awt.event.ActionListener;

public class BotaoOperacao extends Botao{
	
	private String operacao;

	public BotaoOperacao(String text, ActionListener acao,String operacao){
		super(text);
		this.operacao = operacao;
		
		/* Adicionando o nome do comando, e aplicando o evento sobre ele */
		this.setActionCommand("botaoOperacao");
		this.addActionListener(acao);
	}

	public String getOperacao() {
		return operacao;
	}

	
}
