package server;

import general.Mode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Collections;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import networking.Networking;
import commands.Command;
import commands.CommandLoader;
import commands.CommandSender;
import acm.program.ConsoleProgram;


public class Server extends ConsoleProgram implements CommandSender{
	/**
     * 
     */
    private static final long serialVersionUID = -7067822051105869L;
    private static final int MEGASERVER_PORT_NUMBER = 5001;
    private static final String SQLACCOUNT = "USER";
    private static final String SQLPASSWORD = "";
    private static final String SQLSERVER = "127.0.0.1";
    private Connection con;
	private Map<String, String> users = Collections.synchronizedMap(new HashMap<String, String>());
	private HashMap<String, Command> commands = new HashMap<String, Command>();
	private HashMap<String, InetAddress> onlineusers = new HashMap<String, InetAddress>();
	public static Server server;
	private ServerSocket socket;
	private CommandListener listener;
	private MessageDigest digester;
	private boolean stopping = false;
	public static void main(String[] args){
		server = new Server();
		server.start(args);
	}
	public void run(){
		printInfo("Server initializing...");
		listener = new CommandListener();
		listener.start();
		CommandLoader.addCommands();
		try {
			//socket = new ServerSocket(MEGASERVER_PORT_NUMBER, 100, InetAddress.getByName("MEGASERVER_IP"));
			socket = new ServerSocket(Networking.PORT, 100, InetAddress.getByName(Networking.HOST));
		} catch (IOException e) {
			printError("Error creating server... shutting down...");
			stopServer();
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection
					( "jdbc:mysql://" + SQLSERVER, SQLACCOUNT ,SQLPASSWORD);
		} catch(ClassNotFoundException e){
			printError("Database for MySQL not found, shutting down.");
			stopServer();
		} catch (SQLException e) {
			printError("Error loading MySQL database, shutting down.");
			stopServer();
		}
		printInfo("Connected to database.");
		try {
			digester = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e1) {
			printError("Could not load password hasher, shutting down...");
			stopServer();
		}
		printInfo("Server initialized, waiting for a connection...");
		while (!stopping) {
			try {
				new Handler(socket.accept()).start();
				if(Mode.DEBUG){
				    printInfo("Accepted a connection.");
				}
			} catch (IOException e) {
				printError("Connection failed.");
			} catch (NullPointerException e){
				printError("Connection failed. Is there another server running on this port?");
			}
		}
	}
	public void stopServer(){
		printInfo("Shutting down server...");
		stopping = true;
		pause(1000);
		exit();
	}
	
	
	/**
     * @return the con
     */
    public Connection getCon()
    {
        return con;
    }
    /**
     * @param con the con to set
     */
    public void setCon(Connection con)
    {
        this.con = con;
    }
    /**
     * @return the users
     */
    public Map<String, String> getUsers()
    {
        return users;
    }
    /**
     * @param users the users to set
     */
    public void setUsers(Map<String, String> users)
    {
        this.users = users;
    }
    /**
     * @return the commands
     */
    public HashMap<String, Command> getCommands()
    {
        return commands;
    }
    /**
     * @param commands the commands to set
     */
    public void setCommands(HashMap<String, Command> commands)
    {
        this.commands = commands;
    }
    /**
     * @return the onlineusers
     */
    public HashMap<String, InetAddress> getOnlineusers()
    {
        return onlineusers;
    }
    /**
     * @param onlineusers the onlineusers to set
     */
    public void setOnlineusers(HashMap<String, InetAddress> onlineusers)
    {
        this.onlineusers = onlineusers;
    }
    /**
     * @return the socket
     */
    public ServerSocket getSocket()
    {
        return socket;
    }
    /**
     * @param socket the socket to set
     */
    public void setSocket(ServerSocket socket)
    {
        this.socket = socket;
    }
    /**
     * @return the listener
     */
    public CommandListener getListener()
    {
        return listener;
    }
    /**
     * @param listener the listener to set
     */
    public void setListener(CommandListener listener)
    {
        this.listener = listener;
    }
    /**
     * @return the digester
     */
    public MessageDigest getDigester()
    {
        return digester;
    }
    /**
     * @param digester the digester to set
     */
    public void setDigester(MessageDigest digester)
    {
        this.digester = digester;
    }
    /**
     * @param server the server to set
     */
    public static void setServer(Server server)
    {
        Server.server = server;
    }
    /**
     * @param stopping the stopping to set
     */
    public void setStopping(boolean stopping)
    {
        this.stopping = stopping;
    }

    /*class Handler extends Thread {
		private static final String SALT = "2f3b1e45d54d038a7d38383a238e6965";
        private static final String EMAIL_USERNAME = "BestCardGame";
        private static final String EMAIL_PASSWORD = "SoGood";
        private int confirmationNumber;
		private BufferedReader in;
		private PrintWriter out;
		private String name;
		private Socket socket;
		private String username = "";
		private String password = "";
		private String email = "";
		/**
		 * Constructs a handler thread, squirreling away the socket.
		 * All the interesting work is done in the run method.
		 *//*
		public Handler(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			printInfo("Got a connection.");
			// Create character streams for the socket.
			printInfo("Creating reader...");
			int attempts = 0;
			while(!stopping && attempts < 20){
				try {
					in = new BufferedReader(new InputStreamReader(
							socket.getInputStream()));
					break;
				} catch (IOException e) {
					printError("Error creating reader.");
					attempts++;
				}
			}
			printInfo("Creating writer...");
			while(!stopping && attempts < 20){
				try {
					out = new PrintWriter(socket.getOutputStream(), true);
					break;
				} catch (IOException e) {
					printError("Error creating writer");
					attempts++;
				}
			}
			if(attempts >= 20){
				printError("Connection failed, closing socket...");
				try {
					socket.close();
				} catch (IOException e) {
					printError("Could not close socket");
				}
			}
			printInfo("Connection established.");
			while (true) {
				String line = "";
				try {
					line = in.readLine();
					if(line == null){
						onlineusers.remove(username);
						break;
					}
					else if(line.startsWith("--login")){
						printInfo("Got a login.");
						StringTokenizer a = new StringTokenizer(line, " ");
						a.nextToken();
						String b = a.nextToken();
						username = b;
						String c = a.nextToken();
						if(onlineusers.containsKey(b)){
							out.println("--BadLoginAlreadyOnline");
							printInfo("Rejected a login due to that player already being online");
						} else {
							try {
								Statement stmt = con.createStatement();
								stmt.execute("USE MegaServer");
								ResultSet rs = stmt.executeQuery("SELECT password FROM Users WHERE username = \"" + username + "\"");
								if(rs.next()){
									byte[] hashedPassword = digester.digest((c + SALT).getBytes("UTF-8"));
									if(rs.getString("password").equals(new String(hashedPassword))){
										printInfo("Accepted a login from \"" + b + "\".");
										out.println("--loginaccepted ");
										onlineusers.put(b, socket.getInetAddress());
									} else {
										out.println("--BadLoginPassword");
										printInfo("Rejecting a login due to incorrect password.");
									}
								}
								else{
									out.println("--BadLoginUsername");
									printInfo("Rejecting a login due to nonexistant username.");
								}
							} 
							catch (SQLException e) {
								printError("MySQL error logging a player in."); 
							}
						}

						/*if(users.containsKey(b)){
							if(users.get(b).equals(c)) {
								printInfo("Accepted a login from \"" + b + "\".");
								out.println("--loginaccepted ");
								onlineusers.put(b, socket.getInetAddress());
							}else {
								out.println("BadLoginPassword");
								printInfo("Rejecting a login due to incorrect password.");
							} 
						} else {
							out.println("BadLoginUsername");
							printInfo("Rejecting a login due to nonexistant username.");
						}*//*
						out.flush();


					} else if(line.startsWith("--accountCreation")){
						StringTokenizer tokenizer = new StringTokenizer(line, " ");
						printInfo("Got a account creation request.");
						String firstToken = tokenizer.nextToken();
						String secondToken = tokenizer.nextToken();
						int number = Integer.parseInt(secondToken);
						printInfo("Does " + number + " = " + confirmationNumber);
						if(number == confirmationNumber){
							try {
								Statement stmt = con.createStatement();
								stmt.execute("USE MegaServer");
								byte[] hashedPassword = digester.digest((password + SALT).getBytes("UTF-8"));
								byte[] hashedPassword2 = digester.digest((password + SALT).getBytes("UTF-8"));
								String InsertStatement = "INSERT INTO Users (username, password, email) VALUES(\"" + username + "\", \"" +  
										new String(hashedPassword) + "\", \"" + email + "\")";
								stmt.execute(InsertStatement);
								out.println("--AccountConfirmed ");
								printInfo("Created account \"" + username + "\" with password \"" + password + "\".");
							} catch (SQLException e) {
								out.println("--AccountNameTaken");
								printInfo("Rejected a player trying to create an account with an already taken username.");
							}
						} else {
							out.println("--AccountWrongNumber");
							printInfo("Denied account creation because of an incorrect activation number");
						}
						out.flush();
					} else if(line.startsWith("--checkuser")){
						printInfo("Got a player check.");
						StringTokenizer a = new StringTokenizer(line, " ");
						a.nextToken();
						String b = a.nextToken();
						String c = a.nextToken();
						if(users.containsKey(b)){
							if(onlineusers.get(b).equals(InetAddress.getByName(c))) {
								printInfo("Accepted a user check of \"" + b + "\".");
								out.println("--uservalid ");
							} else {
								out.println("--userinvalid ");
								printInfo("Rejected a user check of \"" + b + "\".");
							} 
						}
						out.flush();
					} else if(line.startsWith("--sendConfirmationEmail")){
						StringTokenizer tokenizer = new StringTokenizer(line, " ");
						tokenizer.nextToken();
						email = tokenizer.nextToken();
						printInfo("Sending activation email to " + email);
						username = tokenizer.nextToken();
						password = tokenizer.nextToken();
						confirmationNumber = (int)(Math.random() * 900000) + 100000;
						try {
							GoogleMail.Send(EMAIL_USERNAME, EMAIL_PASSWORD, email, "RoboFrenzy Account Activation", "" + confirmationNumber + " is the code to activate your RoboFrenzy account");
						} catch (MessagingException e) {
							printError("Had trouble sending an email to a player.");
						}
					}
				} catch (IOException e) {
					printError("Had trouble reading a line from a user.");
				}
				System.out.println(line);
				if(line == null) break;

			}
		}
	}*/
	class CommandListener extends Thread {
		String currentline = "";
		public CommandListener(){

		}
		@Override
		public void run(){
			while(!stopping){
				currentline = readLine();
				if(currentline != null){
					String[] args = currentline.toLowerCase().split(" ");
					if(commands.containsKey(args[0])){
						commands.get(args[0]).run(Server.getServer(), args);
					} else {
						printInfo("Unknown Command \"" + args[0] + "\"");
					}
				}
			}
		}
	}
	public void printError(String string){
		println((new Date()).toString() + " [WARNING] " + string);
	}
	public void printInfo(String string){
		println((new Date()).toString() + " [INFO] " + string);
	}
	public void addCommand(String name, Command command){
		if(commands.put(name, command) != null){
			commands.remove(name);
			printError("Error in loading commands, two commands with name " + name);
		}

	}
	public static Server getServer(){
		return server;
	}
	public boolean isStopping(){
		return stopping;
	}
}