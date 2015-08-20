package com.recommind.tools.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

}
