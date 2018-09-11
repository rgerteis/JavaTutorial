package io.roman.tutorial.collections;

public enum Friends {

	JOEY("Joey"), RACHEL("Rachel"), PHOEBE("Phoebe"), CHANDLER("Chandler"), MONICA("Monica"), ROSS("Ross");

	private final String name;

	Friends(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
