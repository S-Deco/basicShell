import java.util.Scanner;



public class SimpleShell {

	public static void main(String [] args) {
		final String prompt = "> ";
		Scanner sc = new Scanner(System.in);
		DirectoryTree t = new DirectoryTree();
		System.out.print(prompt);
		while (sc.hasNext()) {
			String cmd = sc.next();
			
			if (cmd.equals("ls")) {
				System.out.print(t.ls());
			}
			
			else if (cmd.equals("tree")) {
				System.out.print(t.printSubTree());
			}
			
			else if (cmd.equals("cd")) {
				String dir = sc.next();
				boolean result;
				if (dir.equals(".."))
					result = t.cdUp();
				else
					result = t.cd(dir);
				if (result==false)
					System.out.println("No such directory");
			}
			
			else if (cmd.equals("rmdir")) { 
				if (t.rmdir(sc.next())==false)
					System.out.println("No such directory");
			}
			
			else if (cmd.equals("mkdir")) {
				if (t.mkdir(sc.next())==false)
					System.out.println("Directory already exists");
			}
			
			else if (cmd.equals("pwd")) {
				System.out.println(t.pwd());
			}
			else if (cmd.equals("size")) {
				System.out.println(t.numNodes());
			}
			else if (cmd.equals("exit")) {
				System.out.println("Goodbye.");
				sc.close();
				return;
			}
			
			else
				System.out.println("Invalid command. Valid commands are ls, tree, cd, rmdir, mkdir, pwd, exit.");
			System.out.print(prompt);
		}
		sc.close();
	}
}

