package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import models.Case;
import models.Grille;
import views.GrilleView;

public class GrilleController implements MouseListener {

	Grille g;
	private int iCase, jCase;
	
	public GrilleController(Grille g) {
		this.g = g;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		iCase = trouverI(e);
		jCase = trouverJ(e);
		g.toucherCase(iCase, jCase);
	}
	
	private static int trouverI(MouseEvent e) {
		switch (e.getX() / (GrilleView.TAILLE_FENETRE / Grille.TAILLE)) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 3;
		case 4:
			return 4;
		default:
			return 0;
		}
	}
	
	private static int trouverJ(MouseEvent e) {
		switch (e.getY() / (GrilleView.TAILLE_FENETRE / Grille.TAILLE)) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 2;
		case 3:
			return 3;
		case 4:
			return 4;
		default:
			return 0;
		}
	}
	
	public void effacerGrille() {
		g.effacer();
	}
	
	public void melangerGrille() {
		g.melanger();
	}
	
	public void setEnJeu(boolean etat) {
		g.setEnJeu(etat);
	}
	
	public int getCpt() {
		return g.getCpt();
	}
	
	public Case getCase(int x, int y) {
		return g.getCase(x, y);
	}
	
	public Grille getGrille() {
		return g;
	}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {	}

}
