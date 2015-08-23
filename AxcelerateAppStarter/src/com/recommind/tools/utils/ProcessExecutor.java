package com.recommind.tools.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class models the execution of various commands or process and returns
 * the output This will be used by all the service classes
 * 
 * @author asu, nkr
 *
 */
public class ProcessExecutor {

	public static void consoleOutput(ProcessBuilder builder)
			throws IOException, InterruptedException {
		builder.redirectErrorStream(true);
		Process p = builder.start();
		BufferedReader r = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		String line;
		while (true) {
			line = r.readLine();
			if (line == null) {
				break;
			}
			System.out.println(line);
		}
		final int exitValue = p.waitFor();
		System.out.println(exitValue);
	}

	/**
	 * Executes a given command and returns an output
	 * 
	 * @author asu
	 * @param aCommand
	 * @return
	 */
	public String executeCommand(String aCommand) {
		StringBuffer output = new StringBuffer();
		Process p;
		try {
			p = Runtime.getRuntime().exec(aCommand);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return output.toString();
	}

	/**
	 * Executes any windows command and returns an exit value
	 * 
	 * @author asu
	 * @param directory
	 * @param aCommand
	 * @return
	 */
	public int executeCommand(String directory, String aCommand) {
		int exitValue = -1;
		try {
			ProcessBuilder probuilder = new ProcessBuilder("CMD", "/C",
					aCommand);
			probuilder.directory(new File(directory));
			Process process;

			process = probuilder.start();

			BufferedReader br = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line;
			System.out.printf("Output of running command is:\n");
			while ((line = br.readLine()) != null) {
				System.out.println(line);// need to add in logger
			}

			exitValue = process.waitFor();
		} catch (IOException e) {
			System.err.println(e.getMessage());// need to add in logger
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());// need to add in logger
		}
		return exitValue;
	}

	/**
	 * Usage testing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ProcessExecutor pe = new ProcessExecutor();
		String aCommand = "ping aksahu.blogspot.in";
		String output = pe.executeCommand(aCommand);
		System.out.println("The Output is:" + output);

		int exitValue = new ProcessExecutor().executeCommand(
				"G://aksahu_ws/UtilityAKSahu", "dir");
		// int exitValue = new ProcessExecutor().executeCommand("D://", "dir");
		System.out.println("Exit value is:" + exitValue);
	}

}
