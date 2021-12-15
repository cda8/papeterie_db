package fr.afpa.papeterie.dal.util;

import java.io.IOException;
import java.util.Properties;




public class MesProprietes {

	
	public Properties chargerProp(String filename) {
		Properties prop = new Properties();
	try {
		prop.load(getClass().getClassLoader().getResourceAsStream(filename));
	} catch (IOException e) {
		System.err.println(e.getMessage());
	}
	return prop;

}}


