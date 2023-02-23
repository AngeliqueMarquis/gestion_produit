package com.projetProduits.Connect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Connect {
	private String url;
	private String user;
	private String password;
	private String driverClassName;
	
	
	public Connect() {
		super();
	}


	public Connect(String url, String user, String password, String driverClassName) {
		super();
		this.url = url;
		this.user = user;
		this.password = password;
		this.driverClassName = driverClassName;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDriverClassName() {
		return driverClassName;
	}


	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}


	public static Connect initConnection() {
		// TODO Auto-generated method stub
		System.out.println("-Execution methode initConnection de la class Connect");
        Properties prop = new Properties();
        Connect conn = new Connect();
        String str = "";
            conn.setUrl(str);
            conn.setUser(str);
            conn.setPassword(str);
            conn.setDriverClassName(str);

        try {
            System.out.println("-Chargement du fichier properties");
            InputStream inp = Connect.class.
                    getClassLoader().
                    getResourceAsStream("config.properties");

            if(inp == null) {
                System.out.println("-Pas de fichiers");
            }

            prop.load(inp);

            System.out.println("-Affectation des attributs de l'objet Connect");
            conn.setUrl(prop.getProperty("jdbc.url"));
            conn.setUser(prop.getProperty("jdbc.username"));
            conn.setPassword(prop.getProperty("jdbc.password"));
            conn.setDriverClassName(prop.getProperty("jdbc.driverClassName"));


        } catch ( IOException e) {
            System.out.println("-Erreur lors de l'initialisation de l'objet connexion");
            System.out.println(e);
        }
        return conn;
		
		
	}
}
