package pxv425;

import exs406.PrivateMessage;
import gui.TextPrompt;
import gui.View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Cursor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * public class which creates the chat view, in order
 * for the user to chat with other online users
 * 
 * @authors kxk432, exs406, pxv425
 */
public class ChatView extends View implements Observer {

	private static final long serialVersionUID = 1L;
	private ChatModel chatModel;
	private PrivateMessage privateMessage;
	private JPanel listPanel;
	private JPanel usersPanel;
	private JPanel infoPanel;
	private JPanel historyPanel;
	private JPanel logoutImagePanel; 
	private JPanel scrollPanePanel;
	private JPanel inputPanel;
	private JPanel centerPanel;
	private JPanel helpButtonPanel;
	private JPanel userDetailsPanel;
	private JPanel header;
	private JButton logout;
	private JButton history;
	private JButton userDetails;
	private JButton helpButton;
	private JTextArea chatArea;
	private JTextArea historyArea;
	private JScrollPane scrollPane;
	private JScrollPane historyPane;
	private String un;
	private JTextField ms;
	private JTextField userInputArea;
	private JLabel usersPanelTitle1;
	private JLabel usersPanelTitle2;
	private JList<Object> userList;
	private Set<String> onlineUsers= new HashSet<>();
	private String sentence = "";
	private String user;
	private String d = "";
	@SuppressWarnings("unused")
	private TextPrompt ui;
	@SuppressWarnings("unused")
	private TextPrompt pm;
	private Cursor mouseCursorUser;
	private Cursor mouseCursorHistory;
	private Cursor mouseCursorHelp;
	private Cursor mouseCursorLogout;

	public ChatView(Client client, ChatModel chatmodel) {

		super(client);
		this.chatModel = chatmodel;
		chatmodel.addObserver(this);
		initGUIComponents();
	}

	private void initGUIComponents() {

		/*
		 * code for frame setup
		 */
		setPreferredSize(new Dimension(1000,500));
		setLayout(new BorderLayout());
		setAlignmentX(Component.CENTER_ALIGNMENT);

		/*
		 * code for online users (east)
		 */
		listPanel = new JPanel(new BorderLayout());
		listPanel.setBackground(new Color(255,165,0));
		userList = new JList<>(onlineUsers.toArray());
		userList.setBackground(new Color(255,165,0));
		userList.setVisibleRowCount(3);
		userList.setFixedCellWidth(200);
		userList.setVisible(true);
		userList.setFont(new Font("Arial", Font.BOLD, 16));
		userList.setForeground(Color.DARK_GRAY);
		usersPanel = new JPanel();
		usersPanel.setPreferredSize(new Dimension(100,28));
		usersPanelTitle1 = new JLabel("Online Users",JLabel.CENTER);
		InputStream one;
		try {
			one = new FileInputStream(".//pics//font-bold.otf");
			Font mex1 = Font.createFont(Font.TRUETYPE_FONT, one);
			usersPanelTitle1.setFont(mex1.deriveFont(Font.PLAIN,16f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		usersPanelTitle1.setForeground(Color.DARK_GRAY);
		usersPanel.add(usersPanelTitle1);
		usersPanel.setBackground(new Color(255,165,0));
		listPanel.add(usersPanel,BorderLayout.NORTH);
		listPanel.add(userList, BorderLayout.WEST);
		listPanel.add(new JScrollPane(userList), BorderLayout.EAST);

		/*
		 * code for information panel (west)
		 */
		infoPanel = new JPanel();
		infoPanel.setBackground(new Color(255,165,0));
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

		header = new JPanel();
		header.setPreferredSize(new Dimension(200,60)); 
		header.setBackground(new Color(255,165,0));
		header.setAlignmentX(Component.CENTER_ALIGNMENT);
		usersPanelTitle2 = new JLabel("Menu",JLabel.CENTER);
		InputStream two;
		try {
			two = new FileInputStream(".//pics//font-bold.otf");
			Font mex1 = Font.createFont(Font.TRUETYPE_FONT, two);
			usersPanelTitle2.setFont(mex1.deriveFont(Font.PLAIN,16f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		usersPanelTitle2.setForeground(Color.DARK_GRAY);
		header.add(usersPanelTitle2);

		userDetailsPanel = new JPanel();
		userDetailsPanel.setPreferredSize(new Dimension(200,100)); 
		userDetailsPanel.setBackground(new Color(255,165,0));
		userDetailsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		userDetails = new JButton();
		userDetails.setIcon(new ImageIcon(".//pics//user.png"));
		userDetails.setBorder(null);
		userDetails.setBorderPainted(false);
		userDetails.setContentAreaFilled(false);
		userDetails.setOpaque(false);
		userDetails.setPreferredSize(new Dimension(50,50));
		userDetails.setToolTipText("Account Details");
		userDetailsPanel.add(userDetails);

		historyPanel = new JPanel();
		historyPanel.setPreferredSize(new Dimension(200,100));
		historyPanel.setBackground(new Color(255,165,0));
		historyPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		history = new JButton();
		history.setIcon(new ImageIcon(".//pics//book-orange.png"));
		history.setBorder(null);
		history.setBorderPainted(false);
		history.setContentAreaFilled(false);
		history.setOpaque(false);
		history.setPreferredSize(new Dimension(50,50));
		history.setToolTipText("History");
		historyPanel.add(history);

		helpButtonPanel = new JPanel();
		helpButtonPanel.setPreferredSize(new Dimension(200,100));
		helpButtonPanel.setBackground(new Color(255,165,0));
		helpButtonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		helpButton = new JButton();
		helpButton.setIcon(new ImageIcon(".//pics//info.png"));
		helpButton.setBorder(null);
		helpButton.setBorderPainted(false);
		helpButton.setContentAreaFilled(false);
		helpButton.setOpaque(false);
		helpButton.setPreferredSize(new Dimension(50,50));
		helpButton.setToolTipText("Help");
		helpButtonPanel.add(helpButton);

		logoutImagePanel = new JPanel();
		logoutImagePanel.setPreferredSize(new Dimension(200,100));
		logoutImagePanel.setBackground(new Color(255,165,0));
		logoutImagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		logout = new JButton();
		logout.setBorder(null);
		logout.setBorderPainted(false);
		logout.setContentAreaFilled(false);
		logout.setOpaque(false);
		logout.setPreferredSize(new Dimension(50,50));
		logout.setIcon(new ImageIcon(".//pics//logout.png"));
		logout.setToolTipText("Exit");
		logoutImagePanel.add(logout);
		infoPanel.add(header);
		infoPanel.add(userDetailsPanel);
		infoPanel.add(historyPanel);
		infoPanel.add(helpButtonPanel);
		infoPanel.add(logoutImagePanel);

		/*
		 * code for text area
		 */
		chatArea = new JTextArea();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		sentence = " " + "Connected as: " + client.getUser().getUsername() + "\n" + " Logged in at: " + dateFormat.format(date) + "\n" + "\n";
		chatArea.setText(sentence);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setBackground(new Color(255,255,255));
		chatArea.setEditable(false);
		chatArea.setFont(new Font("Arial", Font.ROMAN_BASELINE, 16));
		chatArea.setForeground(Color.BLACK);
		scrollPane = new JScrollPane(chatArea);
		scrollPane.setPreferredSize(new Dimension(550,455));
		scrollPanePanel = new JPanel();
		scrollPanePanel.setBackground(new Color(255,110,0));
		scrollPanePanel.add(scrollPane);

		/*
		 * code for user input
		 */
		inputPanel = new JPanel();
		inputPanel.setBackground(new Color(255,110,0));
		userInputArea = new JTextField();
		ui = new TextPrompt("Type your message..",userInputArea);
		userInputArea.setFont(new Font("Arial", Font.PLAIN, 16));
		userInputArea.setBackground(new Color(255,255,255));
		userInputArea.setEditable(true);
		userInputArea.setPreferredSize(new Dimension(550,30));
		inputPanel.add(userInputArea,BorderLayout.CENTER);

		/*
		 * code for adding the text area and the
		 * user input to a single panel (north)
		 */
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBackground(new Color(255,255,255));
		centerPanel.add(scrollPanePanel,BorderLayout.CENTER);
		centerPanel.add(inputPanel,BorderLayout.SOUTH);

		/*
		 * code for adding all components to frame
		 */
		add(centerPanel, BorderLayout.CENTER);
		add(listPanel, BorderLayout.EAST);
		add(infoPanel, BorderLayout.WEST);

		/*
		 * code for enabling the listeners
		 */
		setListeners();
	}

	public void setOnlineUsersList(Set<String> online) {

		System.out.println("Setting list");
		this.userList.setListData(online.toArray());
	}

	private void setListeners() {

		EventHandler handler = new EventHandler();
		helpButton.addMouseListener(handler);
		userList.addMouseListener(handler);
		logout.addMouseListener(handler);
		userDetails.addMouseListener(handler);
		history.addMouseListener(handler);
		userInputArea.addKeyListener(handler);
	}

	public String getSentence() {

		return sentence;
	}

	public void setSentence(String sentence) {

		this.sentence = sentence;
	}

	public class EventHandler implements MouseListener, KeyListener {

		@Override
		public void mousePressed(MouseEvent e) {

			if(e.getSource().equals(userDetails)) {
				final ImageIcon icon = new ImageIcon(".//pics//ChatCityIcon.png");
				UIManager.put("OptionPane.messageForeground", Color.BLACK);
				UIManager.put("OptionPane.background", new Color(255,165,0));
				UIManager.put("Panel.background", new Color(255,165,0));
				JOptionPane.showMessageDialog(client,"<html>Status: Online"
						+ "<br>Username: " + client.getUser().getUsername()
						+ "<br>Alias: " + client.getUser().getOnScreenName()
						+ "<br>First Name: " + client.getUser().getFirstName()
						+ "<br>Last Name: " + client.getUser().getLastName()
						+ "<br>Email: " + client.getUser().getEmail()
						+ "</html>","Account Details",JOptionPane.INFORMATION_MESSAGE,icon);
			}

			if(e.getSource().equals(history)) {
				BasicChat.getHistory();
				final ImageIcon icon = new ImageIcon(".//pics//ChatCityIcon.png");
				UIManager.put("OptionPane.messageForeground", Color.BLACK);
				UIManager.put("OptionPane.background", new Color(255,165,0));
				UIManager.put("Panel.background", new Color(255,165,0));
				historyArea = new JTextArea();
				historyArea.setLineWrap(true);
				historyArea.setWrapStyleWord(true);
				try {
					Thread.sleep(100);
					historyArea.setText(chatModel.getHistory());
					historyArea.setEditable(false);
					historyArea.setLineWrap(true);
					historyArea.setWrapStyleWord(true);
					historyArea.setCaretPosition(historyArea.getDocument().getLength());
					historyPane = new JScrollPane();
					historyPane.setPreferredSize(new Dimension(500,250));
					historyPane.setViewportView(historyArea);					
					if(!chatModel.getHistory().equals("")) {
						JOptionPane.showMessageDialog(client,historyPane,"History",JOptionPane.INFORMATION_MESSAGE,icon);
					} else {
						JOptionPane.showMessageDialog(client,"History is empty!","History",JOptionPane.INFORMATION_MESSAGE,icon);
					}
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}

			if(e.getSource().equals(helpButton)) {
				BasicChat.devTeam();
				try {
					Thread.sleep(100);
					final ImageIcon icon = new ImageIcon(".//pics//ChatCityIcon.png");
					UIManager.put("OptionPane.messageForeground", Color.BLACK);
					UIManager.put("OptionPane.background", new Color(255,165,0));
					UIManager.put("Panel.background", new Color(255,165,0));
					for(String devs : chatModel.getDevelopers()) {
						d = d + devs + "\n";
					}
					JOptionPane.showMessageDialog(client,d,"Help",JOptionPane.INFORMATION_MESSAGE,icon);
					d = "";
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			if(e.getSource().equals(logout)) {
				client.logout();
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		public void mouseClicked(MouseEvent arg0) {

			try{
				userList = (JList<Object>) arg0.getSource();
			}
			catch(ClassCastException e) {
			}
			try {
				if (arg0.getClickCount() == 2) {
					userList.setForeground(new Color(255,255,255));
					final ImageIcon icon = new ImageIcon(".//pics//pm-white.png");
					ms = new JTextField();
					pm = new TextPrompt("Type your message..",ms);
					ms.setEditable(true);
					ms.setFont(new Font("Arial", Font.PLAIN, 16));
					Object[] fields = {ms};
					UIManager.put("OptionPane.background", new Color(255,165,0));
					UIManager.put("Panel.background", new Color(255,165,0));
					UIManager.put("OptionPane.messageForeground", Color.BLACK);
					UIManager.put("OptionPane.yesButtonText", "Send");
					UIManager.put("OptionPane.noButtonText", "Cancel");
					int his = JOptionPane.showOptionDialog(client,fields,"Private Message",0,JOptionPane.OK_OPTION,icon,null,null);
					un = userList.getSelectedValue().toString();
					System.out.println(user);
					privateMessage = new PrivateMessage(un, ms.getText());
					if(his == JOptionPane.YES_OPTION) {
						client.sendPrivateMessage(privateMessage);
					} 
					int index = userList.locationToIndex(arg0.getPoint());
					if (index >= 0) {
						Object o = userList.getModel().getElementAt(index);
						System.out.println("Double-clicked on: " + o.toString());
					}
				}
			} catch (NullPointerException n) {
				System.out.println("Can't send message!\nNo user is online!");
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {

			if(arg0.getSource().equals(userDetails)) {
				mouseCursorUser = new Cursor(Cursor.HAND_CURSOR);
				userDetails.setCursor(mouseCursorUser);
				userDetails.setIcon(new ImageIcon(".//pics//userwhite.png"));
			}
			if(arg0.getSource().equals(history)) {
				mouseCursorHistory = new Cursor(Cursor.HAND_CURSOR);
				history.setCursor(mouseCursorHistory);
				history.setIcon(new ImageIcon(".//pics//book-white.png"));
			}
			if(arg0.getSource().equals(helpButton)) {
				mouseCursorHelp = new Cursor(Cursor.HAND_CURSOR);
				helpButton.setCursor(mouseCursorHelp);
				helpButton.setIcon(new ImageIcon(".//pics//infowhite.png"));
			}
			if(arg0.getSource().equals(logout)) {
				mouseCursorLogout = new Cursor(Cursor.HAND_CURSOR);
				logout.setCursor(mouseCursorLogout);
				logout.setIcon(new ImageIcon(".//pics//logoutwhite.png"));
			}
		}

		@Override
		public void mouseExited(MouseEvent arg0) {

			if(arg0.getSource().equals(userDetails)) {
				mouseCursorUser = new Cursor(Cursor.DEFAULT_CURSOR);
				userDetails.setCursor(mouseCursorUser);
				userDetails.setIcon(new ImageIcon(".//pics//user.png"));
			}
			if(arg0.getSource().equals(history)) {
				mouseCursorHistory = new Cursor(Cursor.HAND_CURSOR);
				history.setCursor(mouseCursorHistory);
				history.setIcon(new ImageIcon(".//pics//book-orange.png"));
			}
			if(arg0.getSource().equals(helpButton)) {
				mouseCursorHelp = new Cursor(Cursor.HAND_CURSOR);
				helpButton.setCursor(mouseCursorHelp);
				helpButton.setIcon(new ImageIcon(".//pics//info.png"));
			}
			if(arg0.getSource().equals(logout)) {
				mouseCursorLogout = new Cursor(Cursor.HAND_CURSOR);
				logout.setCursor(mouseCursorLogout);
				logout.setIcon(new ImageIcon(".//pics//logout.png"));
			}
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
			// Unused method
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER){
				String mes = userInputArea.getText();
				if(mes.equals("")) {
					chatArea.setText(getSentence() + "");
				} else {
					client.sendMessage(mes);
				}
				userInputArea.setText("");
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			// Unused method
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
			// Unused method
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("UPDATE METHOD");
		System.out.println(arg.getClass().toString());
		if(o instanceof ChatModel){
			if(arg instanceof HashSet){
				setOnlineUsersList((HashSet<String>) arg);
			}
			else if(arg instanceof String){	
				chatArea.setText("" + getSentence() + (String)arg + "\n");
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
				setSentence("" + getSentence() + (String)arg + "\n");
			}
		}
	}
}