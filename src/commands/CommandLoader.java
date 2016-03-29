package commands;

import java.util.HashMap;

import server.Server;

public class CommandLoader {
	public static void addCommands(){
		Command stop = new Command("stop", "core.stop"){
			public boolean run(CommandSender sender, String[] args){
				 Server server = Server.getServer();//.stopServer();
				 server.stopServer();
				return true;
			}
		};
		Server.getServer().addCommand("stop", stop);
	}
//	public static void addMegaServerCommands(){
//		Command stop = new Command("stop", "core.stop"){
//			public boolean run(CommandSender sender, String[] args){
//				 MegaServer server = MegaServer.getServer();//.stopServer();
//				 server.stopServer();
//				return true;
//			}
//		};
//		MegaServer.getServer().addCommand("stop", stop);
//	}
}
