import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

	ImageIcon image = new ImageIcon("./src/clock.png");
	
	int corTela 			= 0x000000; //PRETO
	
	int corHoraBackground 	= 0x0b1a0b; //AZUL
	int corHora				= 0x00FF15; //VERDE
	
	int corDiaBackground 	= 0x000000; //PRETO
	int corDia				= 0xFFFFFF; //BRANCO
	
	int corDataBackground 	= 0x000000; //PRETO
	int corData				= 0xFFFFFF; //BRANCO
	
	// SIMPLEDATEFORMAT : https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html#text
	SimpleDateFormat 	timeFormat;								// FORMATO HORA	
	SimpleDateFormat 	dayFormat;								// FORMATO DIA	
	SimpleDateFormat 	dateFormat;								// FORMATO DATA	
	
	String				time;									// VAR HORA
	String				day;									// VAR DIA
	String				date;									// VAR DATA
	
	JLabel 				timeLabel;								// VAR RÓTULO HORA
	JLabel 				dayLabel;								// VAR RÓTULO DIA
	JLabel 				dateLabel;								// VAR RÓTULO DATA
	
	Calendar 			calendar;								// DATA/HORA ATUAL
	
	MyFrame(){
		//TELA........................................................................................
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//BOTÃO DE FECHAR
		this.setTitle("Relógio");								//TÍTULO		
		this.setSize(220, 170);									//DIMENSÃO
		this.setLayout(new FlowLayout());						//FLOW LAYOUT
		this.setResizable(false); 								//TAMANHO FIXO
		this.setLocationRelativeTo(null);						//JANELA APARECE NO MEIO DA TELA
		this.getContentPane().setBackground(new Color(corTela));//COR
		this.setIconImage(image.getImage());					//ICONE
		
		//FORMATO HORA................................................................................
		timeFormat = new SimpleDateFormat("k:mm:ss");			//CRIA OBJETO FORMATO HORAS MINUTOS SEGUNDOS AM/PM
		
		//FORMATO DIA.................................................................................
		dayFormat = new SimpleDateFormat("EEEE");				//CRIA OBJETO FORMATO DIA SEGUNDA SEG
		
		//FORMATO DATA................................................................................
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");		//CRIA OBJETO FORMATO DIA SEGUNDA SEG
		
		//RÓTULO HORA.................................................................................
		timeLabel = new JLabel();								//CRIA OBJETO RÓTULO
		timeLabel.setFont(new Font("Fira Code", Font.PLAIN, 40));//FONTE
		timeLabel.setForeground(new Color(corHora));			//COR HORA
		timeLabel.setBackground(new Color(corHoraBackground));	//COR HORA BACKGRONUD
		timeLabel.setOpaque(true);								//COR HORA BACKGRONUD VISIVEL (OPACIDADE 1)
		
		//RÓTULO DIA..................................................................................
		dayLabel = new JLabel();								//CRIA OBJETO RÓTULO
		dayLabel.setFont(new Font("Fira Code", Font.PLAIN, 25));//FONTE
		dayLabel.setForeground(new Color(corDia));				//COR DIA
		dayLabel.setBackground(new Color(corDiaBackground));	//COR DIA BACKGRONUD
		dayLabel.setOpaque(true);								//COR DIA BACKGRONUD VISIVEL (OPACIDADE 1)
		
		//RÓTULO DATE..................................................................................
		dateLabel = new JLabel();								//CRIA OBJETO RÓTULO
		dateLabel.setFont(new Font("Fira Code", Font.PLAIN, 20));//FONTE
		dateLabel.setForeground(new Color(corData));			//COR DIA
		dateLabel.setBackground(new Color(corDataBackground));	//COR DIA BACKGRONUD
		dateLabel.setOpaque(true);								//COR DIA BACKGRONUD VISIVEL (OPACIDADE 1)
		
		//ADICIONA A TELA.............................................................................
		this.add(timeLabel);									//ADICIONA RÓTULO HORA
		this.add(dayLabel);										//ADICIONA RÓTULO DIA
		this.add(dateLabel);										//ADICIONA RÓTULO DATA
		this.setVisible(true);									//VISIBILIDADE	
		
		//CHAMA METODO................................................................................
		setTime();
	
	}
	
	//METODO ATUALIZAR HORA POR SEGUNDO................................................................
	public void setTime() {
		while(true) {
		time = timeFormat.format(Calendar.getInstance().getTime()); //HORA ATUAL
		timeLabel.setText(time);									//ADICIONA TEXTO HORA ATUAL
		
		day = dayFormat.format(Calendar.getInstance().getTime()).toUpperCase(); 	//DIA ATUAL CAIXA ALTA
		dayLabel.setText(day);										//ADICIONA TEXTO DIA ATUAL
		
		date = dateFormat.format(Calendar.getInstance().getTime()); 	//DIA ATUAL CAIXA ALTA
		dateLabel.setText(date);										//ADICIONA TEXTO DIA ATUAL
		
		try {
			Thread.sleep(1000);										//WHILE A CADA 1000 MILISEGUNDOS = 1 SEGUNDO
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		}
	}
	
	
	
	
}
