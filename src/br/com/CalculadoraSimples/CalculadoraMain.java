package br.com.CalculadoraSimples;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CalculadoraMain extends JFrame implements ActionListener{

	/* Aplicação simples de uma calculadora em java! */
	
	private JLabel lblNome;
	private JLabel campoNumero;
	private JLabel espaco;
	
	double valorArmazenado;
	
	String ultimaOperacao;

	public CalculadoraMain(){
		super("Calc"); /*Setando o titulo*/
		
		setLayout(new FlowLayout()); /*Setando o layout*/
		
		
		lblNome = new JLabel("Numero: ");
		lblNome.setFont( new Font("Monospace", Font.BOLD, 14) );
		add(lblNome);
	
		campoNumero = new JLabel("0.0");
		add(campoNumero);
		
		/* Espaço apenas para pular '' linha '' por que se não iria ficar tudo juntinho*/
		espaco = new JLabel("                   ");
		add(espaco);
		
		
		/*Botoes de 0 a 9*/
		BotaoNumero b1 = new BotaoNumero(1, this);
		add(b1);
		
		BotaoNumero b2 = new BotaoNumero(2, this);
		add(b2);
		
		BotaoNumero b3 = new BotaoNumero(3, this);
		add(b3);

		BotaoNumero b4 = new BotaoNumero(4, this);
		add(b4);

		BotaoNumero b5 = new BotaoNumero(5, this);
		add(b5);

		BotaoNumero b6 = new BotaoNumero(6, this);
		add(b6);

		BotaoNumero b7 = new BotaoNumero(7, this);
		add(b7);

		BotaoNumero b8 = new BotaoNumero(8, this);
		add(b8);

		BotaoNumero b9 = new BotaoNumero(9, this);
		add(b9);
		
		BotaoNumero b0 = new BotaoNumero(0, this);
		add(b0);
		
		
		/* Botoes das operações  */
		BotaoOperacao mais = new BotaoOperacao ("+", this,"maiss");
		add(mais);
		
		BotaoOperacao menos = new BotaoOperacao ("-", this,"menos");
		add(menos);
		
		BotaoOperacao vezes = new BotaoOperacao ("*", this,"vezes");
		add(vezes);
		
		BotaoOperacao dividir = new BotaoOperacao ("/", this,"dividir");
		add(dividir);
		
		/* Botoes para realizar o calculo ou limpar */
		BotaoIgual igual = new BotaoIgual("=", this);
		add(igual);
		
		BotaoLimpar limpar = new BotaoLimpar("Limpar", this);
		add(limpar);
		
		/* Cuidados da tela */
		setSize(180,260);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
	}
	
	
	
	public static void main(String[] args) {
		new CalculadoraMain();
	}



	@Override
	public void actionPerformed(ActionEvent evento) {
		
		/* Pego o valor atual da label */
		double valor = Double.parseDouble(campoNumero.getText());
		
		
		switch(evento.getActionCommand()){
			
			case "botaoNumero":
				
				/* Sempre que qualquer botão for pressionado 
				 *  Só atualizar a Label
				 * */
				
				
				BotaoNumero num = (BotaoNumero) evento.getSource();/* Capturando o numero */
				valor = valor * 10 + num.getNumero();/* 10 para "saltar" uma casa à esquerda */
				campoNumero.setText(String.valueOf(valor));
			break;
			
			case "botaoOperacao":
				BotaoOperacao operacao = (BotaoOperacao) evento.getSource();
				
				calcula();
				
				/* Garantindo se o valor esta atualizado */
	        	valor = Double.parseDouble( campoNumero.getText() );
	        	
	        	/* Pego o valor que o usuario digitou e armazeno na variavel abaixo */
	        	valorArmazenado = valor;
	        	
	        	/* Limpa a label campos */
	        	campoNumero.setText( String.valueOf(0.0) );
	        	
	        	/* Armazeno a ultima operação  */
	        	ultimaOperacao = operacao.getOperacao();
	        break;
	        
			case "botaoIgual":
				calcula();
			break;
			
			
			case "botaoLimpar":
				valorArmazenado = 0;
				ultimaOperacao = "";
				campoNumero.setText("0.0");
			break;
		
		}
		
	}
	
	/* Executa o calculo atraves das minhas variaveis que armazena o valor e a operação */
	public void calcula(){
		
		/* Pego o valor atual da label*/
		double valorCampo = Double.parseDouble( campoNumero.getText() );
		
		double resultado =0;
		
		if(valorArmazenado != 0 && ultimaOperacao != ""){
			
			switch (ultimaOperacao){
				case "maiss": 
					resultado = valorArmazenado + valorCampo;
					System.out.println(resultado);
				break;
				
				case "menos":
					resultado = valorArmazenado - valorCampo;
				break;
				
				case "vezes":
					resultado = valorArmazenado * valorCampo;
				break;
				
				case "dividir":
					resultado = valorArmazenado / valorCampo;
				break;

			}
			/* No final eu limpo os campos */
			campoNumero.setText(String.valueOf(resultado));
			valorArmazenado = 0;
			ultimaOperacao = "";
			
		}
		
	}

}
