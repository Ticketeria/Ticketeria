package br.edu.ufabc.Ticketeria.model;

public enum UserRole {
	ADMIN("admin"), USER("usuario");

	private final String label;

	private UserRole(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
