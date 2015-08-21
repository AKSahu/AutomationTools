package com.recommind.tools.services;

import java.io.File;

import com.recommind.tools.utils.ConfigUtil;

/**
 * This class models the starting and stopping launcher service for the
 * Axcelerate application
 * 
 * @author asu
 *
 */
public class LauncherService {

	/**
	 * Starts the launcher service
	 */
	public void startLauncherService() {

		String workspaceDir = ConfigUtil.getProperty("workspace_dir");
		String mindserverDir = workspaceDir + File.separator
				+ "mindserver-projects";
		mindserverDir = mindserverDir.replace("\\", File.separator).replace(
				"/", File.separator);

		// TODO
	}

	/**
	 * Stops the launcher service
	 */
	public void stopLauncherService() {
		
		// TODO
	}
}
