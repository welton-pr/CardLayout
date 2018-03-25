package br.com.welton.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
public class Formulario extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Formulario() {
		
		this.setLayout(new BorderLayout());
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	
		JPanel cores = newPanel(new CardLayout(), null);
		cores.add(newPanel(new FlowLayout(), Color.blue), "AZUL");
		cores.add(newPanel(new FlowLayout(), Color.yellow), "AMARELO");
		cores.add(newPanel(new FlowLayout(), Color.red), "VERMELHO");
		
		this.add(cores, BorderLayout.CENTER);
		
		JPanel opcoes = newPanel(new FlowLayout(), null);
				
		JComboBox c = newComboBox();
		c.addItem("AZUL");
		c.addItem("AMARELO");
		c.addItem("VERMELHO");
		c.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent selecionado) {
				CardLayout c =(CardLayout) cores.getLayout();
				c.show(cores, selecionado.getItem().toString());
				
			}
		});
		
		opcoes.add(c);
		this.add(opcoes, BorderLayout.NORTH);

	}

	private JPanel newPanel(LayoutManager layout, Color cor) {
		JPanel p = new JPanel();
		p.setLayout(layout);
		p.setBackground(cor);
		p.setSize(new Dimension(100, 100));
		p.setBorder(new LineBorder(Color.BLACK));
		return p;
	}
	
	private JComboBox newComboBox() {
		JComboBox c = new JComboBox();
		return c;
	}
}
