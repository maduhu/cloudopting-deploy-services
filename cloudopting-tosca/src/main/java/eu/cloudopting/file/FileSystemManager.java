package eu.cloudopting.file;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSystemManager {
	public void getDockerVersion() throws IOException, InterruptedException
	  {
	    // build the system command we want to run
	    List<String> commands = new ArrayList<String>();
	    commands.add("/bin/sh");
	    commands.add("-c");
	    commands.add("docker --version");

	    // execute the command
	    SystemCommandExecutor commandExecutor = new SystemCommandExecutor(commands);
	    int result = commandExecutor.executeCommand();

	    // get the stdout and stderr from the command that was run
	    StringBuilder stdout = commandExecutor.getStandardOutputFromCommand();
	    StringBuilder stderr = commandExecutor.getStandardErrorFromCommand();
	    
	    // print the stdout and stderr
	    System.out.println("The numeric result of the command was: " + result);
	    System.out.println("STDOUT:");
	    System.out.println(stdout);
	    System.out.println("STDERR:");
	    System.out.println(stderr);
	  }
	
	
	public void buildDockerImage(String customer, String service, String dockerfile,String path){
	    // build the system command we want to run
	    List<String> commands = new ArrayList<String>();
	    commands.add("/bin/sh");
	    commands.add("-c");
	    commands.add("docker build -t cloudopting/"+customer+"_"+dockerfile.toLowerCase()+" -f "+path+"/"+customer+"-"+service+"/"+dockerfile+".dockerfile "+path);
	    System.out.println("docker build -t cloudopting/"+customer+"_"+dockerfile.toLowerCase()+" -f "+path+"/"+customer+"-"+service+"/"+dockerfile+".dockerfile "+path);
	    // execute the command
	    SystemCommandExecutor commandExecutor = new SystemCommandExecutor(commands);
	    int result = 0;
		try {
			result = commandExecutor.executeCommand();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // get the stdout and stderr from the command that was run
	    StringBuilder stdout = commandExecutor.getStandardOutputFromCommand();
	    StringBuilder stderr = commandExecutor.getStandardErrorFromCommand();
	    
	    // print the stdout and stderr
	    System.out.println("The numeric result of the command was: " + result);
	    System.out.println("STDOUT:");
	    System.out.println(stdout);
	    System.out.println("STDERR:");
	    System.out.println(stderr);
		
	}
	
	public void runR10K(String customer, String service, String path){
	    // build the system command we want to run
	    List<String> commands = new ArrayList<String>();
	    commands.add("/bin/sh");
	    commands.add("-c");
	    commands.add("PUPPETFILE="+path+"/"+customer+"-"+service+"/Puppetfile PUPPETFILE_DIR="+path+"/puppet/modules r10k puppetfile install");
	    System.out.println("PUPPETFILE="+path+"/"+customer+"-"+service+"/Puppetfile PUPPETFILE_DIR="+path+"/puppet/modules r10k puppetfile install");
	    // execute the command
	    SystemCommandExecutor commandExecutor = new SystemCommandExecutor(commands);
	    int result = 0;
		try {
			result = commandExecutor.executeCommand();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // get the stdout and stderr from the command that was run
	    StringBuilder stdout = commandExecutor.getStandardOutputFromCommand();
	    StringBuilder stderr = commandExecutor.getStandardErrorFromCommand();
	    
	    // print the stdout and stderr
	    System.out.println("The numeric result of the command was: " + result);
	    System.out.println("STDOUT:");
	    System.out.println(stdout);
	    System.out.println("STDERR:");
	    System.out.println(stderr);
		
	}
}