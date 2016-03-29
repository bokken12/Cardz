/**
 * 
 */
package display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author joelmanning
 *
 */
public class LauncherDisplay extends Display implements ActionListener
{

    /**
     * 
     */
    private static final long serialVersionUID = 4194281608328506992L;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 350;
    private static final int TEXT_WIDTH = 120;
    private static final int TEXT_HEIGHT = 30;
    private static final int SPACING = 10;
    private JPanel loginPanel;
    private JPanel accountCreationPanel;
    private TextArea username;
    private PasswordArea password;
    private Button login;
    private Button toAccountCreation;
    private TextArea createUsername;
    private PasswordArea createPassword;
    private PasswordArea verifyPassword;
    private TextArea createEmail;
    private Button createAccount;
    private Button toLogin;

    public static void main(String[] args)
    {
        LauncherDisplay l = new LauncherDisplay();
    }

    public LauncherDisplay()
    {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Joel's Game");
        loginPanel = new JPanel();
        loginPanel.setLayout(null);
        int leftPos = WIDTH / 2 - TEXT_WIDTH - SPACING / 2;
        int rightPos = (WIDTH + SPACING) / 2;
        int topPos = (HEIGHT - TEXT_HEIGHT - SPACING - TEXT_WIDTH) / 2;
        int bottomPos = (HEIGHT + TEXT_HEIGHT + SPACING - TEXT_WIDTH) / 2;
        username = new TextArea(leftPos, topPos, TEXT_WIDTH, TEXT_HEIGHT,
                "Enter Username");
        loginPanel.add(username);
        password = new PasswordArea(rightPos, topPos, TEXT_WIDTH, TEXT_HEIGHT,
                "Enter Password");
        loginPanel.add(password);
        login = new Button(leftPos, bottomPos, TEXT_WIDTH, TEXT_WIDTH, "Login");
        loginPanel.add(login);
        login.addActionListener(this);
        toAccountCreation = new Button(rightPos, bottomPos, TEXT_WIDTH,
                TEXT_WIDTH, "Account Creation");
        loginPanel.add(toAccountCreation);
        toAccountCreation.addActionListener(this);
        add(loginPanel);
        accountCreationPanel = new JPanel();
        accountCreationPanel.setLayout(null);
        topPos = (HEIGHT - TEXT_WIDTH) / 2 - TEXT_HEIGHT - SPACING;
        int midPos = (HEIGHT - TEXT_WIDTH) / 2;
        bottomPos = (HEIGHT - TEXT_WIDTH) / 2 + TEXT_HEIGHT + SPACING;
        createUsername = new TextArea(leftPos, topPos, TEXT_WIDTH, TEXT_HEIGHT, "Enter Username");
        accountCreationPanel.add(createUsername);
        createEmail = new TextArea(rightPos, topPos, TEXT_WIDTH, TEXT_HEIGHT, "Enter Email");
        accountCreationPanel.add(createEmail);
        createPassword = new PasswordArea(leftPos, midPos, TEXT_WIDTH, TEXT_HEIGHT, "Enter Password");
        accountCreationPanel.add(createPassword);
        verifyPassword = new PasswordArea(rightPos, midPos, TEXT_WIDTH, TEXT_HEIGHT, "Verify Password");
        accountCreationPanel.add(verifyPassword);
        createAccount = new Button(leftPos, bottomPos, TEXT_WIDTH, TEXT_WIDTH, "Create Account");
        accountCreationPanel.add(createAccount);
        createAccount.addActionListener(this);
        toLogin = new Button(rightPos, bottomPos, TEXT_WIDTH, TEXT_WIDTH, "Back To Login");
        accountCreationPanel.add(toLogin);
        toLogin.addActionListener(this);
        //add(accountCreationPanel);
        setVisible(true);
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(toAccountCreation)){
            remove(loginPanel);
            add(accountCreationPanel);
            revalidate();
            repaint();
        } else if(e.getSource().equals(toLogin)){
            remove(accountCreationPanel);
            add(loginPanel);
            revalidate();
            repaint();
        } else if(e.getSource().equals(login)){
            
        }
    }
}
