package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import pxv425.Client;
import pxv425.User;

/**
 * public class which creates the sign up view, in order
 * for the user to become a member of the chat
 * 
 * @author kxk432
 */
public class SignUpView extends View {

	/*
	 * initialize private variables
	 */
	private static final long serialVersionUID = 1L;
	private LoginModel loginModel;
	private SignUpModel signUpModel;
	private JPanel panelHeader;
	private JPanel panelBackButton;
	private JPanel panelFields;
	private JPanel panelFirstname;
	private JPanel panelLastname;
	private JPanel panelAlias;
	private JPanel panelUsername;
	private JPanel panelPassword;
	private JPanel panelConfirmPassword;
	private JPanel panelEmail;
	private JPanel panelConfirmEmail;
	private JPanel panelSubmitButton;
	private JPanel panelCity;
	private JPasswordField firstnameField;
	private JPasswordField lastnameField;
	private JPasswordField aliasField;
	private JPasswordField usernameField;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	private JPasswordField emailField;
	private JPasswordField confirmEmailField;
	private TextPrompt firstnamePrompt;
	private TextPrompt lastnamePrompt;
	private TextPrompt aliasPrompt;
	private TextPrompt usernamePrompt;
	private TextPrompt passwordPrompt;
	private TextPrompt confirmPasswordPrompt;
	private TextPrompt emailPrompt;
	private TextPrompt confirmEmailPrompt;
	private JLabel imageBackLabel;
	private JLabel imageSubmitLabel;
	private JLabel imageCityLabel;
	private JLabel headerLabel;
	private ImageIcon imageBack;
	private ImageIcon imageCity;
	private ImageIcon imageSubmit;
	private Cursor imageBackBird;
	private Cursor imageSubmitSun;
	private boolean firstnameClicked = true;
	private boolean lastnameClicked = true;
	private boolean aliasClicked = true;
	private boolean usernameClicked = true;
	private boolean emailClicked = true;
	private boolean confirmEmailClicked = true;

	public SignUpView(Client client, SignUpModel signUpModel) {

		super(client);
		this.signUpModel = signUpModel;
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
		setPreferredSize(new Dimension(800,600));
		// Set the panel's background color
		setBackground(new Color(255,165,0));
		// Set allignment
		setAlignmentX(Component.CENTER_ALIGNMENT);
		// Add components to container
		addHeader();
		addBackButton();
		addTitle();
		addSignUpPanelFields();
		addSubmitButton();
		addCity();
		// Add listeners
		addListeners();
	}

	/*
	 * private void method to create
	 * the sign up frame's header
	 */
	private void addHeader() {

		// Create a new panel
		panelHeader = new JPanel();
		// Set the panel's size
		panelHeader.setPreferredSize(new Dimension(800,-310));
		// Set the panel's background color
		panelHeader.setBackground(new Color(255,165,0));
		// Set allignment
		panelHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
		// Add panel to container
		add(panelHeader);
	}

	/*
	 * private void method to create
	 * the sign up frame's back button
	 */
	private void addBackButton() {

		// Create a new panel
		panelBackButton = new JPanel();
		// Set the panel's size
		panelBackButton.setPreferredSize(new Dimension(800,-215));
		// Set the panel's background color
		panelBackButton.setBackground(new Color(255,165,0));
		// Set allignment
		panelBackButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		// Add image to panel
		imageBack = new ImageIcon(".//assets//BackBird.png");
		// Insert the image into the JLabel
		imageBackLabel = new JLabel(" ", imageBack, JLabel.CENTER);
		// Make label visible
		imageBackLabel.setVisible(true);
		// Add label to panel
		panelBackButton.add(imageBackLabel);
		// Add panel to container
		add(panelBackButton);
	}

	/*
	 * private void method to create
	 * the sign up frame's title
	 */
	private void addTitle() {

		// Create a new panel
		panelHeader = new JPanel();
		// Set the panel's size
		panelHeader.setPreferredSize(new Dimension(800,-245));
		// Set the panel's background color
		panelHeader.setBackground(new Color(255,165,0));
		// Set allignment
		panelHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
		// Create a label
		headerLabel = new JLabel("Become part of the city.");
		// Set font
		headerLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		// Set color
		headerLabel.setForeground(Color.WHITE);
		// Add label to panel
		panelHeader.add(headerLabel);
		// Add panel to container
		add(panelHeader);
	}

	/*
	 * private void method to create
	 * the sign up frame's fields
	 */
	private void addSignUpPanelFields() {

		// Create main panel for the fields
		panelFields = new JPanel();
		// Set the panel's size
		panelFields.setPreferredSize(new Dimension(800,-110));
		
		// Create field panels
		panelFirstname = new JPanel();
		panelLastname = new JPanel();
		panelAlias = new JPanel();
		panelUsername = new JPanel();
		panelPassword = new JPanel();
		panelConfirmPassword = new JPanel();
		panelEmail = new JPanel();
		panelConfirmEmail = new JPanel();


		// Set the panels background color
		panelFields.setBackground(new Color(255,165,0));
		panelFirstname.setBackground(new Color(255,165,0));
		panelLastname.setBackground(new Color(255,165,0));
		panelAlias.setBackground(new Color(255,165,0));
		panelUsername.setBackground(new Color(255,165,0));
		panelPassword.setBackground(new Color(255,165,0));
		panelConfirmPassword.setBackground(new Color(255,165,0));
		panelEmail.setBackground(new Color(255,165,0));
		panelConfirmEmail.setBackground(new Color(255,165,0));

		// Set up JTextFields
		firstnameField = new JPasswordField(20);
		InputStream one;
		try {
			one = new FileInputStream(".//assets//font-regular.otf");
			Font mex1 = Font.createFont(Font.TRUETYPE_FONT, one);
			firstnameField.setFont(mex1.deriveFont(Font.PLAIN,16f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		firstnameField.setForeground(Color.BLACK);
		lastnameField = new JPasswordField(20);
		InputStream two;
		try {
			two = new FileInputStream(".//assets//font-regular.otf");
			Font mex2 = Font.createFont(Font.TRUETYPE_FONT, two);
			lastnameField.setFont(mex2.deriveFont(Font.PLAIN,16f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		lastnameField.setForeground(Color.BLACK);
		aliasField = new JPasswordField(20);
		InputStream three;
		try {
			three = new FileInputStream(".//assets//font-regular.otf");
			Font mex3 = Font.createFont(Font.TRUETYPE_FONT, three);
			aliasField.setFont(mex3.deriveFont(Font.PLAIN,16f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		aliasField.setForeground(Color.BLACK);
		usernameField = new JPasswordField(20);
		InputStream four;
		try {
			four = new FileInputStream(".//assets//font-regular.otf");
			Font mex4 = Font.createFont(Font.TRUETYPE_FONT, four);
			usernameField.setFont(mex4.deriveFont(Font.PLAIN,16f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		usernameField.setForeground(Color.BLACK);
		passwordField = new JPasswordField(20);
		InputStream five;
		try {
			five = new FileInputStream(".//assets//font-regular.otf");
			Font mex5 = Font.createFont(Font.TRUETYPE_FONT, five);
			passwordField.setFont(mex5.deriveFont(Font.PLAIN,16f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		passwordField.setForeground(Color.BLACK);
		confirmPasswordField = new JPasswordField(20);
		InputStream six;
		try {
			six = new FileInputStream(".//assets//font-regular.otf");
			Font mex6 = Font.createFont(Font.TRUETYPE_FONT, six);
			confirmPasswordField.setFont(mex6.deriveFont(Font.PLAIN,16f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		confirmPasswordField.setForeground(Color.BLACK);
		emailField = new JPasswordField(20);
		InputStream seven;
		try {
			seven = new FileInputStream(".//assets//font-regular.otf");
			Font mex7 = Font.createFont(Font.TRUETYPE_FONT, seven);
			emailField.setFont(mex7.deriveFont(Font.PLAIN,16f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		emailField.setForeground(Color.BLACK);
		confirmEmailField = new JPasswordField(20);
		InputStream eight;
		try {
			eight = new FileInputStream(".//assets//font-regular.otf");
			Font mex8 = Font.createFont(Font.TRUETYPE_FONT, eight);
			confirmEmailField.setFont(mex8.deriveFont(Font.PLAIN,16f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		confirmEmailField.setForeground(Color.BLACK);

		// Add JTextFields
		firstnamePrompt = new TextPrompt("First Name",firstnameField);
		focusLost(firstnameField);
		panelFirstname.add(firstnameField);
		lastnamePrompt = new TextPrompt("Last Name",lastnameField);
		focusLost(lastnameField);
		panelLastname.add(lastnameField);
		aliasPrompt = new TextPrompt("Alias",aliasField);
		focusLost(aliasField);
		panelAlias.add(aliasField);
		usernamePrompt = new TextPrompt("Username",usernameField);
		focusLost(usernameField);
		panelUsername.add(usernameField);
		passwordPrompt = new TextPrompt("Password",passwordField);
		focusGained(passwordField);
		panelPassword.add(passwordField);
		panelConfirmPassword.add(confirmPasswordField);
		confirmPasswordPrompt = new TextPrompt("Confirm Password",confirmPasswordField);
		focusGained(confirmPasswordField);
		panelEmail.add(emailField);
		emailPrompt = new TextPrompt("Email",emailField);
		focusLost(emailField);
		panelConfirmEmail.add(confirmEmailField);
		confirmEmailPrompt = new TextPrompt("Confirm Email",confirmEmailField);
		focusLost(confirmEmailField);

		// Add panels to main panel
		panelFields.add(panelFirstname);
		panelFields.add(panelLastname);
		panelFields.add(panelAlias);
		panelFields.add(panelUsername);
		panelFields.add(panelPassword);
		panelFields.add(panelConfirmPassword);
		panelFields.add(panelEmail);
		panelFields.add(panelConfirmEmail);

		// Add main panel to container
		add(panelFields);
	}

	/*
	 * private void method to create
	 * the sign up frame's submit button
	 */
	private void addSubmitButton() {

		// Create a new panel
		panelSubmitButton = new JPanel();
		// Set the panel's size
		panelSubmitButton.setPreferredSize(new Dimension(800,-210));
		// Set the panel's background color
		panelSubmitButton.setBackground(new Color(255,165,0));
		// Set allignment
		panelSubmitButton.setAlignmentX(Component.LEFT_ALIGNMENT);
		// Add image to panel
		imageSubmit = new ImageIcon(".//assets//SunSubmit.png");
		// Insert the image into the JLabel
		imageSubmitLabel = new JLabel(" ", imageSubmit, JLabel.CENTER);
		// Make label visible
		imageSubmitLabel.setVisible(true);
		// Add label to panel
		panelSubmitButton.add(imageSubmitLabel);
		// Add panel to container
		add(panelSubmitButton);
	}

	/*
	 * private void method to create
	 * the sign up frame's footer picture
	 */
	private void addCity() {

		// Create a new panel
		panelCity = new JPanel();
		// Set the panel's size
		panelCity.setPreferredSize(new Dimension(800,-170));
		// Set the panel's background color
		panelCity.setBackground(new Color(255,165,0));
		// Set allignment
		panelCity.setAlignmentX(Component.CENTER_ALIGNMENT);
		// Add image to panel
		imageCity = new ImageIcon(".//assets//Sky.png");
		// Insert the image into the JLabel
		imageCityLabel = new JLabel(" ", imageCity, JLabel.CENTER);
		// Make label visible
		imageCityLabel.setVisible(true);
		// Add label to panel
		panelCity.add(imageCityLabel);
		// Add panel to container
		add(panelCity);
	}

	/*
	 * public void method which disables
	 * the focus of a JPassword field
	 */
	public void focusLost(JPasswordField field) {

		char c = 0;
		field.setEchoChar(c);
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
	 * public void method which checks the
	 * validity of the user's email address
	 */
	public boolean isValidEmailAddress(String email) {

		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		boolean b = email.matches(EMAIL_REGEX);
		return b;
	}

	/*
	 * public void method which creates an
	 * event handler object and sets up the
	 * mouse etc. listeners
	 */
	public void addListeners() {

		EventHandler handler = new EventHandler();
		firstnameField.addMouseListener(handler);
		lastnameField.addMouseListener(handler);
		aliasField.addMouseListener(handler);
		usernameField.addMouseListener(handler);
		passwordField.addMouseListener(handler);
		confirmPasswordField.addMouseListener(handler);
		emailField.addMouseListener(handler);
		confirmEmailField.addMouseListener(handler);
		imageBackLabel.addMouseListener(handler);
		imageSubmitLabel.addMouseListener(handler);
	}

	/**
	 * public void method which receives a string message from the program's
	 * Client class concerning the user's attempted sign up. Depending on whether
	 * the sign up was successful or not a pop up window with a corresponding
	 * message appears
	 * 
	 * @param c
	 * @throws HeadlessException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public void registeredUser(Client c) throws HeadlessException, ClassNotFoundException, IOException {

		final ImageIcon icon = new ImageIcon(".//assets//errorIcon.png");
		final ImageIcon icon2 = new ImageIcon(".//assets//CheckMark.png");
		UIManager.put("OptionPane.minimumSize",new Dimension(300,150)); 
		UIManager.put("OptionPane.background", new Color(255,110,0));
		UIManager.put("Panel.background", new Color(255,110,0));
		UIManager.put("OptionPane.messageForeground", Color.WHITE);
		UIManager.put("OptionPane.questionDialog.titlePane.shadow", Color.WHITE);
		UIManager.put("OptionPane.okButtonText", "OK");
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 14));
		UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 14));
		if(!c.getMessageToGui2().equals("OK")) {
			JOptionPane.showMessageDialog(client,c.getMessageToGui2(),"Sign Up",JOptionPane.OK_OPTION,icon);
		} else {
			UIManager.put("OptionPane.background", new Color(255,165,0));
			UIManager.put("Panel.background", new Color(255,165,0));
			JOptionPane.showMessageDialog(client,"Successfully signed up!","Sign Up",JOptionPane.OK_OPTION,icon2);
			client.changePanel(new LoginView(client,loginModel));
		}
	}

	/**
	 * public inner class to handle the events of the main class
	 * 
	 * @author kxk432
	 */
	public class EventHandler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			// Unused method
		}

		/**
		 * public method to determine the mouse entered events
		 * 
		 * @param e
		 */
		@Override
		public void mouseEntered(MouseEvent e) {
			
			if(e.getSource().equals(imageBackLabel)) {
				imageBackBird = new Cursor(Cursor.HAND_CURSOR);
				imageBackLabel.setCursor(imageBackBird);
				imageBackLabel.setIcon(new ImageIcon(".//assets//BackBirdHover.png"));
			}

			if(e.getSource().equals(imageSubmitLabel)) {
				imageSubmitSun = new Cursor(Cursor.HAND_CURSOR);
				imageSubmitLabel.setCursor(imageSubmitSun);
				imageSubmitLabel.setIcon(new ImageIcon(".//assets//SunSubmitHover.png"));
			}

		}

		/**
		 * public method to determine the mouse exited events
		 * 
		 * @param e
		 */
		@Override
		public void mouseExited(MouseEvent e) {
			
			if(e.getSource().equals(imageBackLabel)) {
				imageBackLabel.setIcon(new ImageIcon(".//assets//BackBird.png"));
			}
			
			if(e.getSource().equals(imageSubmitLabel)) {
				imageSubmitLabel.setIcon(new ImageIcon(".//assets//SunSubmit.png"));
			}
		}

		/**
		 * public method to determine the mouse pressed events
		 * 
		 * @param e
		 */
		@Override
		public void mousePressed(MouseEvent e) {

			if(e.getSource().equals(firstnameField) && firstnameClicked == false) {
				// Set the panel's background color	
				firstnameField.setForeground(Color.BLACK);
				firstnameField.setText("");
				if (firstnameField.isCursorSet()) {
					firstnamePrompt.setShow(TextPrompt.Show.ALWAYS);
				} else {
					firstnamePrompt.setShowPromptOnce(false); // clear focusLost counter
					firstnamePrompt.setShow(TextPrompt.Show.NEVER);
					firstnamePrompt.setShowPromptOnce(true);
				}
				firstnameClicked = true;
			}

			if(e.getSource().equals(lastnameField) && lastnameClicked == false) {
				// Set the panel's background color	
				lastnameField.setForeground(Color.BLACK);
				lastnameField.setText("");
				if (lastnameField.isCursorSet()) {
					lastnamePrompt.setShow(TextPrompt.Show.ALWAYS);
				} else {
					lastnamePrompt.setShowPromptOnce(false); // clear focusLost counter
					lastnamePrompt.setShow(TextPrompt.Show.NEVER);
					lastnamePrompt.setShowPromptOnce(true);
				}
				lastnameClicked = true;
			}

			if(e.getSource().equals(aliasField) && aliasClicked == false) {
				// Set the panel's background color	
				aliasField.setForeground(Color.BLACK);
				aliasField.setText("");
				if (aliasField.isCursorSet()) {
					aliasPrompt.setShow(TextPrompt.Show.ALWAYS);
				} else {
					aliasPrompt.setShowPromptOnce(false); // clear focusLost counter
					aliasPrompt.setShow(TextPrompt.Show.NEVER);
					aliasPrompt.setShowPromptOnce(true);
				}
				aliasClicked = true;
			}

			if(e.getSource().equals(usernameField) && usernameClicked == false) {
				// Set the panel's background color	
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
					// Set the panel's background color	
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

			if(!confirmPasswordField.echoCharIsSet()) {
				if(e.getSource().equals(confirmPasswordField)) {
					// Set the panel's background color	
					confirmPasswordField.setForeground(Color.BLACK);
					focusGained(confirmPasswordField);
					if (confirmPasswordField.isCursorSet()) {
						confirmPasswordPrompt.setShow(TextPrompt.Show.ALWAYS);
					} else {
						confirmPasswordPrompt.setShowPromptOnce(false); // clear focusLost counter
						confirmPasswordPrompt.setShow(TextPrompt.Show.NEVER);
						confirmPasswordPrompt.setShowPromptOnce(true);
					}
				}
			}

			if(e.getSource().equals(emailField) && emailClicked == false) {
				// Set the panel's background color	
				emailField.setForeground(Color.BLACK);
				emailField.setText("");
				if (emailField.isCursorSet()) {
					emailPrompt.setShow(TextPrompt.Show.ALWAYS);
				} else {
					emailPrompt.setShowPromptOnce(false); // clear focusLost counter
					emailPrompt.setShow(TextPrompt.Show.NEVER);
					emailPrompt.setShowPromptOnce(true);
				}
				emailClicked = true;
			}

			if(e.getSource().equals(confirmEmailField) && confirmEmailClicked == false) {
				// Set the panel's background color	
				confirmEmailField.setForeground(Color.BLACK);
				confirmEmailField.setText("");
				if (confirmEmailField.isCursorSet()) {
					confirmEmailPrompt.setShow(TextPrompt.Show.ALWAYS);
				} else {
					confirmEmailPrompt.setShowPromptOnce(false); // clear focusLost counter
					confirmEmailPrompt.setShow(TextPrompt.Show.NEVER);
					confirmEmailPrompt.setShowPromptOnce(true);
				}
				confirmEmailClicked = true;
			}

			if (e.getSource().equals(imageBackLabel)) {
				client.changePanel(new LoginView(client,loginModel));
			}

			if(e.getSource().equals(imageSubmitLabel)) {
				signUpModel = new SignUpModel();
				signUpModel.setFirstname(firstnameField.getPassword());
				signUpModel.setLastname(lastnameField.getPassword());
				signUpModel.setAlias(aliasField.getPassword());
				signUpModel.setUsername(usernameField.getPassword());
				signUpModel.setPassword(passwordField.getPassword());
				signUpModel.setConfirmPassword(confirmPasswordField.getPassword());
				signUpModel.setEmail(emailField.getPassword());
				signUpModel.setConfirmEmail(confirmEmailField.getPassword());

				if (signUpModel.getFirstname().equals("") || signUpModel.getLastname().equals("") || signUpModel.getUsername().equals("") 
						|| signUpModel.getPassword().equals("") || signUpModel.getEmail().equals("")) {
					final ImageIcon icon = new ImageIcon(".//assets//errorIcon.png");
					UIManager.put("OptionPane.minimumSize",new Dimension(300,150)); 
					UIManager.put("OptionPane.background", new Color(255,110,0));
					UIManager.put("Panel.background", new Color(255,110,0));
					UIManager.put("OptionPane.messageForeground", Color.WHITE);
					UIManager.put("OptionPane.questionDialog.titlePane.shadow", Color.WHITE);
					UIManager.put("OptionPane.okButtonText", "OK");
					UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 14));
					UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 14));
					JOptionPane.showMessageDialog(client, "Empty mandatory fields in sign up form!", "Sign Up",JOptionPane.OK_OPTION,icon);
				} else {
					if (signUpModel.getPassword().equals(signUpModel.getConfirmPassword())
							&& signUpModel.getEmail().equals(signUpModel.getConfirmEmail())) {
						if(isValidEmailAddress(signUpModel.getEmail())) {
							try {
								User user = new User();
								Client client2 = new Client(user);
								client2.signUp(signUpModel);
								registeredUser(client2);
							} 
							catch (ClassNotFoundException e1) {
								e1.printStackTrace();
							}
							catch (IOException e1) {
								e1.printStackTrace();
							}
							catch (HeadlessException e1) {
								e1.printStackTrace();
							} 

						} else {
							final ImageIcon icon = new ImageIcon(".//assets//errorIcon.png");
							UIManager.put("OptionPane.minimumSize",new Dimension(300,150)); 
							UIManager.put("OptionPane.background", new Color(255,110,0));
							UIManager.put("Panel.background", new Color(255,110,0));
							UIManager.put("OptionPane.messageForeground", Color.WHITE);
							UIManager.put("OptionPane.questionDialog.titlePane.shadow", Color.WHITE);
							UIManager.put("OptionPane.okButtonText", "OK");
							UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 14));
							UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 14));
							JOptionPane.showMessageDialog(client, "Invalid Email form!", "Sign Up",JOptionPane.DEFAULT_OPTION,icon);
						}
					} else {
						final ImageIcon icon = new ImageIcon(".//assets//errorIcon.png");
						UIManager.put("OptionPane.minimumSize",new Dimension(300,150)); 
						UIManager.put("OptionPane.background", new Color(255,110,0));
						UIManager.put("Panel.background", new Color(255,110,0));
						UIManager.put("OptionPane.messageForeground", Color.WHITE);
						UIManager.put("OptionPane.questionDialog.titlePane.shadow", Color.WHITE);
						UIManager.put("OptionPane.okButtonText", "OK");
						UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 14));
						UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 14));
						JOptionPane.showMessageDialog(client, "Email and/or Password fields do not match!", "Sign Up",JOptionPane.DEFAULT_OPTION,icon);
					}
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			// Unused method
		}
	}
}