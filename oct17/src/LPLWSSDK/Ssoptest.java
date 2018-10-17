package LPLWSSDK;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.w3c.dom.NodeList;

public class Ssoptest {

	public static void main(String[] args) throws IOException, SOAPException {
		System.out.println("------21------");
		String strPath = "C://workspace//WSXMLs//test1.wsdl";
		System.out.println("------23------");
		SOAPMessage message = null;
		System.out.println(message + "111");
		System.out.println("------------");
		System.out.println(strPath);
		FileInputStream fis = new FileInputStream(new File(strPath));

		System.out.println(fis);

		MessageFactory factory = MessageFactory.newInstance();
		message = factory.createMessage(new MimeHeaders(), fis);

		System.out.println(message);

		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory.createConnection();

		String strEndpoint = "http://www.webservicex.com/globalweather.asmx";
		SOAPMessage soapResponse = soapConnection.call(message, strEndpoint);

		System.out.println(soapResponse);

		SOAPBody soapBody = soapResponse.getSOAPBody();
		NodeList elements = soapBody.getElementsByTagName("CountryName");

		System.out.println(elements);
	}

}
