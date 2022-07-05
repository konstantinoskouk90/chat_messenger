package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pxv425.Client;

/**
 * @author kxk432
 * 
 * public class that provides an animated
 * introduction to the messenger program
 */
public class Intro extends View {

	/*
	 * initialize private variables
	 */
	private JPanel panel;
	private LoginModel loginModel;
	private static final long serialVersionUID = 1L;

	/**
	 * @param client
	 * 
	 * constructor of the class, which first
	 * calls a void method that initiates
	 * the animation for a number of seconds,
	 * and then switches to another panel
	 */
	public Intro(Client client) {
		super(client);
		animation();
		int delay = 1000; // delay for 1 second
		int period = 1000; // repeat every second 
		Timer timer = new Timer(); 
		timer.scheduleAtFixedRate(new TimerTask() {
			int count = 0;
			public void run() {
				count ++;              
				if(count == 3) {
					client.changePanel(new LoginView(client, loginModel));
				}   
			}
		}, delay, period); 
	}

	/*
	 * private void method that contains
	 * the program's introductory animation
	 */
	private void animation() {
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(675,450));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		panel.setBackground(new Color(255,165,0));
		ImageIcon imageIcon = new ImageIcon(".//assets//Gif.gif");
		JLabel label = new JLabel(imageIcon);
		panel.add(label);
		add(panel);
	}
}