package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import controllers.GrilleController;
import models.Grille;

/**
 * Vue compteur de clics
 * @author friedrich
 *
 */
@SuppressWarnings({ "deprecation", "serial" })
public class CompteurView extends JPanel implements Observer {

	public final static int HAUTEUR = 40;
	private GrilleController gc;
	private JLabel cpt; 
	
	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
		this.rafraichitCpt();
	}
	
	public CompteurView(GrilleController gc) {
		this.gc = gc;
		setPreferredSize(new Dimension(GrilleView.LARGEUR,HAUTEUR));
		gc.getGrille().addObserver(this);
		ajouteAffCpt();
	}
	
	public void paintCompenent(Graphics g) {
		super.paintComponent(g);
	}
	
	/**
	 * Ajoute un compteur de clics à la vue
	 */
	public void ajouteAffCpt() {
		JPanel jp = new JPanel();
		JLabel titre = new JLabel("Nb de clic(s) : ");
		String strCpt = Integer.toString(gc.getCpt());
		cpt = new JLabel(strCpt);
		jp.add(titre,BorderLayout.WEST);
		this.add(titre,BorderLayout.WEST);
		this.add(cpt,BorderLayout.EAST);
	}
	
	public void rafraichitCpt() {
		String strCpt = Integer.toString(gc.getCpt());
		cpt.setText(strCpt);
	}

}
