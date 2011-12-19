package org.tkassembled.maven.jasperreports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URL;

import net.sf.jasperreports.engine.JasperCompileManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JasperReportsApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(JasperReportsApplication.class);
	
	/*
	 * There are basically four steps to a finished product:
	 * 		<X> Design a report with a JRXML file.
	 * 		<X> Compile the report to a binary, serialized JasperReport and save to disk.
	 * 		<X> Fill the compiled report with data.
	 * 		<X> Export it.
	 */
	public static void main(String[] args) throws Exception {
		
	}
}
