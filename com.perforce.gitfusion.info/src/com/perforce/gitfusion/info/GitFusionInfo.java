package com.perforce.gitfusion.info;
import java.io.File;
import java.util.Random;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;

public class GitFusionInfo {

	private String gitFusionUrl;
	
	public GitFusionInfo() {
		gitFusionUrl = "user@git-fusion-server";
	}
	
	public GitFusionInfo(String gfUrl) {
		gitFusionUrl = gfUrl;
	}
	
	public void setUrl(String gfUrl) {
		gitFusionUrl = gfUrl;
	}
	
	public String getUrl() {
		return gitFusionUrl;
	}
	 
	public String getInfo() {
		return getAt(IGFInfoConstants.INFO);
	}
	
	public String getHelp() {
		return getAt(IGFInfoConstants.HELP);
	}
	
	public String getList() {
		return getAt(IGFInfoConstants.LIST);
	}
	
	private String getRandomTempDir() {
		Random random = new Random();
		String tempdir = System.getProperty("java.io.tmpdir") 
				+ File.separator + random.nextInt();
		return tempdir;
	}
	
	private String getAt(String command) {
		String message = null;
		String error = null;
		try {
 			File file = new File(getRandomTempDir());
 			Git.cloneRepository()
				.setURI(gitFusionUrl + ":" + command)
				.setDirectory(file)
				.call();
		} catch (InvalidRemoteException e) {
			String dump = e.getCause().getMessage().toString();
			int index = dump.indexOf(command);
			message = dump.substring(index + 7);
			System.out.println(message);
		} catch (TransportException e) {
			error = e.getCause().getMessage().toString();
			message = error + "\n" + IGFInfoConstants.UNABLE_TO_CONNECT;
		} catch (GitAPIException e) {
			e.printStackTrace();
		}
		return message;
	}

}
