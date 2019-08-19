package XML_OPERATION.operation;

import java.io.File;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Creater {
	static int idvalue;
	static String id, username, password, usernameValue, passwordValue;
	static Scanner sc = new Scanner(System.in);

	public static void createXMl() throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory documentbuildfact = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentbuild = documentbuildfact.newDocumentBuilder();
		Document document = documentbuild.newDocument();

		System.out.println("Enter the root Element");
		String root = sc.next();
		Element rootEle = document.createElement(root);
		document.appendChild(rootEle);
		System.out.println("Enter the sub Element");
		String sub = sc.next();
		Element subEle = document.createElement(sub);
		rootEle.appendChild(subEle);
		Attr attribute = document.createAttribute("id");
		System.out.println("Enter the id value");
		idvalue = sc.nextInt();
		attribute.setValue(Integer.toString(idvalue));
		subEle.setAttributeNode(attribute);
		System.out.println("Enter the  childElement");
		username = sc.next();
		Element childEle1 = document.createElement(username);
		System.out.println("Enter the " + username + " value");
		usernameValue = sc.next();
		childEle1.appendChild(document.createTextNode(usernameValue));
		subEle.appendChild(childEle1);
		System.out.println("Enter the childElement");
		password = sc.next();
		Element childEle2 = document.createElement(password);
		System.out.println("Enter the" + password + " value");
		passwordValue = sc.next();
		childEle2.appendChild(document.createTextNode(passwordValue));
		subEle.appendChild(childEle2);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource domSource = new DOMSource(document);
		File file = new File("C:\\Users\\sakthi.sekar\\Desktop\\sakthi\\create.xml");
		StreamResult streamResult = new StreamResult(file);
		transformer.transform(domSource, streamResult);
		System.out.println("success fully created");
	}
	// return file;

}
