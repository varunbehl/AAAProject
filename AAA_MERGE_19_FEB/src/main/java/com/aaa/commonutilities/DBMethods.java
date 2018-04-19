package com.aaa.commonutilities;

import org.apache.log4j.Logger;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DBMethods {
	protected static final Logger LOG = Logger.getLogger(DBMethods.class);
	private static final String ROOT = System.getProperty("user.dir");
	protected static final String SEPARATOR = File.separator;
	protected static final String CR_SQL_ROOT = ROOT + SEPARATOR + "resources" + SEPARATOR + "sqlFiles" + SEPARATOR + "CR";

	/**
	 * utility method
	 *
	 * @param filePath is the sql file path
	 * @return the path to string
	 */
	protected static String fileToString(String filePath) {
		String str = null;
		try {
			str = new String(Files.readAllBytes(Paths.get(filePath)), Charset.forName("UTF-8"));
		} catch (Exception ex) {
			LOG.debug(ex.getMessage());
		}
		return str;
	}

	/**
	 * utility method to decode site_name
	 *
	 * @param siteName is the site_name of the DB
	 * @return the DB based on site_name
	 */
	protected static DB getDb(String siteName) {
		DB db;
		//set at job and get system property to find db if not null
		switch (siteName.toLowerCase()) {
			case "d3cr":
				db = DB.D3CR_1;
				break;
			default:
				db = null;
				break;
		}
		return db;
	}
}