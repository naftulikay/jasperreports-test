package org.tkassembled.maven.jasperreports;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

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
		logger.debug("Starting up...");
//		first, we open the XML template
		logger.info("Opening the JRXML template file.");
		InputStream template = JasperReportsApplication.class
			.getResourceAsStream("/sampleReport.jrxml");
		
//		now, fill out the report
		logger.info("Compiling report and filling it out.");
		JasperReport report = JasperCompileManager.compileReport(template);
		JasperPrint print = JasperFillManager.fillReport(report, new HashMap<String, String>());
		
//		finally, export it to PDF
		logger.info("Exporting the filled out report to a file.");
		File pdfOutputFile = File.createTempFile("jasper", ".pdf");
		pdfOutputFile.deleteOnExit();
		JasperExportManager.exportReportToPdfStream(print, new FileOutputStream(pdfOutputFile));
		
//		now sleep indefinitely to allow for preview but to wipe the files on JVM exit
		logger.info("Done with export. Find the file at \"{}\" then end this process when done.",
				pdfOutputFile.getAbsolutePath());
		
		while (true) {
			try {
				Thread.sleep(Long.MAX_VALUE);
			} catch (InterruptedException e) {
				logger.info("Exiting now.");
			}
		}
	}
}
