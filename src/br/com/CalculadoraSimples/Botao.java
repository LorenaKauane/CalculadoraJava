package br.com.CalculadoraSimples;

import java.awt.Font;

import javax.swing.JButton;

public class Botao extends JButton {

	/* Classe responsavel apenas para os botoes
	 * Nesta classe você consegue realizar todo layout do botão caso deseje 
	 * Uma classe generica */
	public Botao(String nomeBotao){
		super(nomeBotao);
		
		this.setFont( new Font("monospaced", Font.BOLD, 14) );
	}
	
}
