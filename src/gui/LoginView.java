package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import pxv425.Client;
import pxv425.User;

/**
 * public class which creates the login view, in order
 * for the user to login into the chat messenger program 
 * 
 * @author kxk432
 */
public class LoginView extends View {

	/*
	 * initialize private variables
	 */
	private static final long serialVersionUID = 1L;
	private LoginModel loginModel;
	private SignUpModel signUpModel;
	private JPanel panelHeader;
	private JPanel panelLogo;
	private JPanel panelUsername;
	private JPanel panelPassword;
	private JPanel panelSignIn;
	private JPanel panelSignUpPanel;
	private JPanel panelSignUpButton;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private TextPrompt usernamePrompt;
	private TextPrompt passwordPrompt;
	private JButton buttonSignIn;
	private JButton buttonAccount;
	private JLabel labelImage;
	private ImageIcon image;
	private Cursor mouseCursorSignIn;
	private Cursor mouseCursorAccount;
	private boolean usernameClicked = true;

	public LoginView(Client client, LoginModel loginModel) {
		
		super(client);
		this.loginModel = loginModel;
		initGUIComponents();
	}

	/*
	 * private void method to
	 * initialize the GUI components
	 */
	private void initGUIComponents() {
		
		// Set pane layout
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		// Set pane preferred size
		setPreferredSize(new Dimension(675,450));
		// Set the panel's background color
		setBackground(new Color(255,110,0));
		// Set allignment
		setAlignmentX(Component.CENTER_ALIGNMENT);
		// Add components to container
		addHeader();
		addLogo();
		addUsername();
		addPassword();
		addSignInButton();
		addSignUpPanel();
		addSignUpButton();
		// Set listeners
		setListeners();
	}

	/*
	 * private void method to create
	 * the login frame's header
	 */
	private void addHeader() {
		
		// Create a new panel
		panelHeader = new JPanel();
		// Set the panel's size
		panelHeader.setPreferredSize(new Dimension(675,-20));
		// Set the panel's background color
		panelHeader.setBackground(new Color(255,165,0));
		// Set allignment
		panelHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
		// Add panel to container
		add(panelHeader);
	}

	/*
	 * private void method to create
	 * the login frame's logo
	 */
	private void addLogo() {
		
		// Create a new panel
		panelLogo = new JPanel();
		// Set the panel's size
		panelLogo.setPreferredSize(new Dimension(675,75));
		// Set the panel's background color
		panelLogo.setBackground(new Color(255,165,0));
		// Add image to panel
		image = new ImageIcon(".//assets//ChatCity.png");
		// Insert the image into the JLabel
		labelImage = new JLabel(" ", image, JLabel.CENTER);
		// Make label visible
		labelImage.setVisible(true);
		// Add label to panel
		panelLogo.add(labelImage);
		// Add panel to container
		add(panelLogo);
	}

	/*
	 * private void method to create
	 * the login frame's username field
	 */
	private void addUsername() {
		
		// Create a new panel
		panelUsername = new JPanel();
		// Set the panel's size
		panelUsername.setPreferredSize(new Dimension(675,-20));
		// Set the panel's background color
		panelUsername.setBackground(new Color(255,165,0));
		// Set up TextField
		usernameField = new JTextField(20);
		// Set text
		usernameField.setText("");
		// Set font
		InputStream one;
		try {
			one = new FileInputStream(".//assets//font-regular.otf");
			Font mex1 = Font.createFont(Font.TRUETYPE_FONT, one);
			usernameField.setFont(mex1.deriveFont(Font.PLAIN,16f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Set font color
		usernameField.setForeground(Color.BLACK);
		// Add word TextPrompt to username
		usernamePrompt = new TextPrompt("Username",usernameField);
		// Make JPassword visible
		usernameField.setVisible(true);
		// Add TextField to panel
		panelUsername.add(usernameField);
		// Add panel to container
		add(panelUsername);
	}

	/*
	 * private void method to create the
	 * login frame's password field
	 */
	private void addPassword() {
		
		// Create a new panel
		panelPassword = new JPanel();
		// Set the panel's size
		panelPassword.setPreferredSize(new Dimension(675,-10));
		// Set the panel's background color
		panelPassword.setBackground(new Color(255,165,0));
		// Set up TextField
		passwordField = new JPasswordField(20);
		// Set text
		passwordField.setText("");
		// Set font
		InputStream two;
		try {
			two = new FileInputStream(".//assets//font-regular.otf");
			Font mex2 = Font.createFont(Font.TRUETYPE_FONT, two);
			passwordField.setFont(mex2.deriveFont(Font.PLAIN,16f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Set font color
		passwordField.setForeground(Color.DARK_GRAY);
		// Add word TextPrompt to username
		passwordPrompt = new TextPrompt("Password",passwordField);
		// Make JTextField visible
		passwordField.setVisible(true);
		// Add TextField to panel
		panelPassword.add(passwordField);
		// Add panel to container
		add(panelPassword);
	}

	/*
	 * private void method to create
	 * the login frame's sign in button
	 */
	private void addSignInButton() {
		
		// Create a new panel
		panelSignIn = new JPanel();
		// Set the panel's size
		panelSignIn.setPreferredSize(new Dimension(675,0));
		// Set the panel's background color
		panelSignIn.setBackground(new Color(255,165,0));
		// Create JButton
		buttonSignIn = new JButton();
		// Set Button dimensions
		buttonSignIn.setPreferredSize(new Dimension(250,35));
		// Make button transparent
		buttonSignIn.setBorder(null);
		buttonSignIn.setBorderPainted(false);
		buttonSignIn.setContentAreaFilled(false);
		buttonSignIn.setOpaque(false);
		// Set Button image
		buttonSignIn.setIcon(new ImageIcon(".//assets//signInButton.png"));
		// Make JButton visible
		buttonSignIn.setVisible(true);
		// Add Button to panel
		panelSignIn.add(buttonSignIn);
		// Add panel to container
		add(panelSignIn);
	}

	/*
	 * private void method to create
	 * the login frame's sign up panel
	 */
	private void addSignUpPanel() {
		
		// Create a new panel
		panelSignUpPanel = new JPanel();			
		// Set the panel's size
		panelSignUpPanel.setPreferredSize(new Dimension(675,-50));
		// Set the panel's background color
		panelSignUpPanel.setBackground(new Color(255,110,0));
		// Set allignment
		panelSignUpPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		// Add panel to container
		add(panelSignUpPanel);
	}

	/*
	 * private void method to create
	 * the login frame's sign up button
	 */
	private void addSignUpButton() {
		
		// Create a new panel
		panelSignUpButton = new JPanel();			
		// Set the panel's size
		panelSignUpButton.setPreferredSize(new Dimension(675,-25));
		// Set the panel's background color
		panelSignUpButton.setBackground(new Color(255,110,0));
		// Set up JLabel
		buttonAccount = new JButton("Create an account");
		// Make button transparent
		buttonAccount.setBorder(null);
		buttonAccount.setBorderPainted(false);
		buttonAccount.setContentAreaFilled(false);
		buttonAccount.setOpaque(false);
		// Set up JLabel font
		buttonAccount.setFont(new Font("Arial", Font.PLAIN, 14));
		// Set up JLabel font color
		buttonAccount.setForeground(Color.WHITE);
		// Make JLabel visible
		buttonAccount.setVisible(true);
		// Add JLabel to panel
		panelSignUpButton.add(buttonAccount);
		// Add panel to container
		add(panelSignUpButton);
	}

	/*
	 * public void method which enables
	 * the focus of a JPassword field
	 */
	public void focusGained(JPasswordField field) {
		
		char c = '*';
		field.setEchoChar(c);
		field.setText("");
	}

	/*
	 * public void method which creates an
	 * event handler object and sets  up
	 * the action, mouse etc. listeners
	 */
	public void setListeners() {
		
		EventHandler handler = new EventHandler();
		buttonSignIn.addActionListener(handler);
		buttonAccount.addActionListener(handler);
		buttonSignIn.addMouseListener(handler);
		buttonAccount.addMouseListener(handler);
		usernameField.addMouseListener(handler);
		passwordField.addMouseListener(handler); 
	}

	/**
	 * public void method which receives a string message from the program's
	 * Client class concerning the user's attempted, but failed login. Depending
	 * on what went wrong, a pop up window with a corresponding message appears
	 * 
	 * @param c
	 * @throws HeadlessException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void registeredUser(Client c) throws HeadlessException, ClassNotFoundException, IOException {
		
		final ImageIcon icon = new ImageIcon(".//assets//errorIcon.png");
		UIManager.put("OptionPane.minimumSize",new Dimension(300,150)); 
		UIManager.put("OptionPane.background", new Color(255,110,0));
		UIManager.put("OptionPane.messagebackground", new Color(255,110,0));
		UIManager.put("Panel.background", new Color(255,110,0));
		UIManager.put("OptionPane.messageForeground", Color.WHITE);
		UIManager.put("OptionPane.questionDialog.titlePane.shadow", Color.WHITE);
		UIManager.put("OptionPane.okButtonText", "OK");
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 14));
		UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 14));
		if(!c.getMessageToGui().equals("OK")) {
			JOptionPane.showMessageDialog(client,c.getMessageToGui(),"Login",JOptionPane.ERROR_MESSAGE,icon);
		}
	}

	/**
	 * public inner class to handle the events of the main class
	 * 
	 * @author kxk432
	 */
	public class EventHandler implements ActionListener, MouseListener {
		
		/**
		 * public method to determine the action of each button
		 * 
		 * @param e
		 */
		@Override
		public void actionPerformed(ActionEvent e) {	
			
			Object clickedButton = e.getSource();
			
			if(clickedButton == buttonSignIn) {
				loginModel = new LoginModel();
				loginModel.setUsername(usernameField.getText());
				loginModel.setPassword(passwordField.getPassword());
				try {
					new User();
					client.login(loginModel);
					client.setVisible(true);
					registeredUser(client);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				}
			}
			if (clickedButton == buttonAccount) {
				client.changePanel(new SignUpView(client,signUpModel));
			}
		}
		
		/**
		 * public method to determine the mouse pressed events
		 * 
		 * @param e
		 */
		@Override
		public void mousePressed(MouseEvent e) {
			
			if(e.getSource().equals(usernameField) && usernameClicked == false) {
				usernameField.setForeground(Color.BLACK);
				usernameField.setText("");
				if (usernameField.isCursorSet()) {
					usernamePrompt.setShow(TextPrompt.Show.ALWAYS);
				} else {
					usernamePrompt.setShowPromptOnce(false); // clear focusLost counter
					usernamePrompt.setShow(TextPrompt.Show.NEVER);
					usernamePrompt.setShowPromptOnce(true);
				}
				usernameClicked = true;
			}
			if(!passwordField.echoCharIsSet()) {
				if(e.getSource().equals(passwordField)) {
					passwordField.setForeground(Color.BLACK);
					focusGained(passwordField);
					if (passwordField.isCursorSet()) {
						passwordPrompt.setShow(TextPrompt.Show.ALWAYS);
					} else {
						passwordPrompt.setShowPromptOnce(false); // clear focusLost counter
						passwordPrompt.setShow(TextPrompt.Show.NEVER);
						passwordPrompt.setShowPromptOnce(true);
					}
				}
			}
		}

		/**
		 * public method to determine the mouse entered events
		 * 
		 * @param e
		 */
		@Override
		public void mouseEntered(MouseEvent e) {
			
			// Create mouse cursor objects
			mouseCursorSignIn = new Cursor(Cursor.HAND_CURSOR);
			mouseCursorAccount = new Cursor(Cursor.HAND_CURSOR);
			// Set mouse cursors
			buttonSignIn.setCursor(mouseCursorSignIn);
			buttonAccount.setCursor(mouseCursorAccount);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
			// Unused method
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			// Unused method
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
			// Unused method
		}
	}
}