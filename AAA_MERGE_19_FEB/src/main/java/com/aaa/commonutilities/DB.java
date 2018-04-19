package com.aaa.commonutilities;

public enum DB {

				
	D3CR_1("crdb.user",
			"crdb.password",
			"crdb.host",
			"crdb.port",
			"crdb.servicename",
			"crdb.sid");

	public String user() {
		return user;
	}

	public String password() {
		return password;
	}

	public String host() {
		return host;
	}

	public String port() {
		return port;
	}

	public String servicename() {
		return servicename;
	}

	public String sid() {
		return sid;
	}

	private final String user;
	private final String password;
	private final String host;
	private final String port;
	private final String servicename;
	private final String sid;

	DB(String user, String password, String host, String port, String servicename, String sid) {
		this.user = user;
		this.password = password;
		this.host = host;
		this.port = port;
		this.servicename = servicename;
		this.sid = sid;
	}

}