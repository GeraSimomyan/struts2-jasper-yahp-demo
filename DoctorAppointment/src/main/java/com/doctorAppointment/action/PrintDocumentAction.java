package com.doctorAppointment.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperCompileManager;

import org.apache.struts2.ServletActionContext;
import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;
import org.docx4j.XmlUtils;
import org.docx4j.convert.in.xhtml.XHTMLImporter;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.NumberingDefinitionsPart;
import org.docx4j.openpackaging.parts.WordprocessingML.StyleDefinitionsPart;
import org.docx4j.wml.Style;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.opensymphony.xwork2.Action;

public class PrintDocumentAction implements Action {

	/*
	 * private InputStream fileInputStream;
	 * 
	 * public InputStream getFileInputStream() { return fileInputStream; }
	 */
	/** List to use as our JasperReports dataSource. */
	private List<DoctorDetail> myList;

	public List<DoctorDetail> getMyList() {
		return myList;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("PrintPDF start");

		HttpServletRequest request = ServletActionContext.getRequest();
		String contextFolder = request.getServletContext().getRealPath("");
		String jrxmlFilePath = contextFolder + "\\jasper_template.jrxml";

		myList = new ArrayList<DoctorDetail>();
		myList.add((DoctorDetail) request.getSession().getAttribute(
				"doctorDetail"));

		try {
			JasperCompileManager.compileReportToFile(jrxmlFilePath,
					contextFolder + "\\compiled_template.jasper");
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

		return "SUCCESS";
	}

}
