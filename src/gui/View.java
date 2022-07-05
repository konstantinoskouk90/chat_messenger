package gui;

import javax.swing.JPanel;
import pxv425.Client;

/**
 * public abstract class - extends JPanel
 * 
 * @author kxk432
 */
public abstract class View extends JPanel {
	
	private static final long serialVersionUID = 1L;
	protected Client client;
	
	public View(Client client) {
		
		this.client = client;
	}
}
