package commands;


public abstract class Command {
	String name;
	String permission;
	public Command(String name, String permission){
		this.name = name;
		this.permission = permission;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public abstract boolean run(CommandSender sender, String[] args);
}
