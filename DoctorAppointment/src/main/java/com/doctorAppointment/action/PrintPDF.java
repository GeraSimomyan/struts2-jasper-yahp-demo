package com.doctorAppointment.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.allcolor.yahp.converter.CYaHPConverter;
import org.allcolor.yahp.converter.IHtmlToPdfTransformer;
import org.apache.struts2.ServletActionContext;

public class PrintPDF {

	private InputStream fileInputStream;

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	// configure fopFactory as desired
	// private final FopFactory fopFactory = FopFactory.newInstance();

	/** xsl-fo namespace URI */
	protected static String foNS = "http://www.w3.org/1999/XSL/Format";

	public String execute() throws Exception {

		System.out.println("PrintPDF start");
		HttpServletRequest request = ServletActionContext.getRequest();
		String html = request.getParameter("htmlString");
		String contextFolder = request.getServletContext().getRealPath("");

		String htmlFileName = contextFolder + "\\download.html";
		String pdfFileName = contextFolder + "\\download.pdf";

		File htmlFile = new File(htmlFileName);
		if (htmlFile.exists()) {
			htmlFile.delete();
			htmlFile.createNewFile();
		} else {
			htmlFile.createNewFile();
		}
		// save html
		FileWriter htmlFileWriter = new FileWriter(htmlFile);
		htmlFileWriter.write(html);
		htmlFileWriter.flush();
		htmlFileWriter.close();

		// File pdfFile=new File(pdfFileName);

		// new converter
		CYaHPConverter converter = new CYaHPConverter();
		// save pdf in outfile
		File fout = new File(pdfFileName);
		FileOutputStream out = new FileOutputStream(fout);
		// contains configuration properties
		Map properties = new HashMap();
		// list containing header/footer
		List headerFooterList = new ArrayList();
		// add header/footer
		headerFooterList
				.add(new IHtmlToPdfTransformer.CHeaderFooter(
						"<table width=\"100%\"><tbody><tr><td align=\"left\">"
								+ "Generated with YaHPConverter.</td><td align=\"right\">Page <pagenumber>/<"
								+ "pagecount></td></tr></tbody></table>",
						IHtmlToPdfTransformer.CHeaderFooter.HEADER));
		headerFooterList.add(new IHtmlToPdfTransformer.CHeaderFooter(
				"© 2009 Quentin Anciaux",
				IHtmlToPdfTransformer.CHeaderFooter.FOOTER));
		properties.put(IHtmlToPdfTransformer.PDF_RENDERER_CLASS,
				IHtmlToPdfTransformer.FLYINGSAUCER_PDF_RENDERER);
		// properties.put(IHtmlToPdfTransformer.FOP_TTF_FONT_PATH, fontPath);

		converter.convertToPdf(htmlFile.toURI().toURL(),
				IHtmlToPdfTransformer.A4P, headerFooterList, out, properties);

		out.flush();
		out.close();

		fileInputStream = new FileInputStream(fout);
		return "SUCCESS";
	}

}
