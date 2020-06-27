package com.orange.base;

import static com.orange.base.GlobalThings.listOfInputs;
import static com.orange.base.GlobalThings.totalTestCases;
import static com.orange.base.GlobalThings.xmlFile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.testng.TestNG;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XML {

	private static Document document;
	private static Element testName = null;
	private static String className = "";
	private static Element methodName = null;
	private static Element clasz = null;
	private static Element parameter = null;
	private static Element testSuite = null;
	private static final String BROWSER_THREAD_COUNT = "1";
	private static String TEST_THREAD_COUNT = "1";

	// Initial configuration of XML file
	private static void setXMLFile() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// Root elements for Test Case
			document = docBuilder.newDocument();

			// Create a Test Suite section
		//	testSuite = document.createElement("!DOCTYPE suite SYSTEM \"https://testng.org/testng-1.0.dtd\" ");
			testSuite = document.createElement("suite");
			document.appendChild(testSuite);
			Attr suiteName = document.createAttribute("name");
			suiteName.setValue("End to End Suite");
			testSuite.setAttributeNode(suiteName);
			testSuite.setAttribute("allow-return-values", "true");
			testSuite.setAttribute("parallel", "tests");
			testSuite.setAttribute("thread-count", BROWSER_THREAD_COUNT);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	// Create test & class
	private static void createNode(String claszName) {
		className = "com.orange.testcases." + claszName;

		// Test Case class
		clasz = document.createElement("class");
		testName.appendChild(clasz);

		Attr attr = document.createAttribute("name");
		attr.setValue(className);
		clasz.setAttribute("name", className);

	}

	// Create Methods
	private static void createEmptyMethod() {
		methodName = document.createElement("methods");
		clasz.appendChild(methodName);
	}

	// Add methods
	private static void includeMethods(String methodNme) {
		totalTestCases++;
		Element includeMethod = document.createElement("include");
		methodName.appendChild(includeMethod);
		includeMethod.setAttribute("name", methodNme);
	}

	// Save XML file after adding tests
	public static void saveXml() {
		try {
			// Write content to XML file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			// enable indent on the xml file
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(xmlFile));
			transformer.transform(source, result);
			System.out.println("testNg.xml file is generated!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Run testNG.xml file
	public static void triggerXml() {
		// Create object of TestNG Class
		TestNG runner = new TestNG();

		// Create a list of String
		List<String> suitefiles = new ArrayList<String>();

		// Add xml file which you have to execute
		suitefiles.add(xmlFile);

		// now set xml file for execution
		runner.setTestSuites(suitefiles);

		// finally execute the runner using run method
		runner.run();
	}

	// Generate xml file
	public static void createXMLFile() {
		setXMLFile();
		for (InputBrowserDetails browsers : GlobalThings.listOfBrowser) {
			createTest(browsers);
			// Create a Test section
			for (String classes : getClasses()) {
				createNode(classes);
				createEmptyMethod();
				for (InputTestDetails methods : listOfInputs) {
					if (methods.getModule().equals(classes)) {
						includeMethods("test_" + methods.getTestCaseID());
					}
				}

			}
		}
	}

	// Get unique list of test classes
	private static Set<String> getClasses() {
		Set<String> li = new HashSet<String>();
		for (InputTestDetails e : listOfInputs) {
			li.add(e.getModule());
		}
		return li;
	}

	// Add parameter type as browser
	private static void addParameter(String browser, Element test) {
		parameter = document.createElement("parameter");
		test.appendChild(parameter);
		parameter.setAttribute("name", "browser");
		parameter.setAttribute("value", browser);
	}

	private static void createTest(InputBrowserDetails browsers) {
		Element test = document.createElement("test");
		testSuite.appendChild(test);
		Attr attr = document.createAttribute("name");
		attr.setValue(browsers.getBrowserName());
		test.setAttributeNode(attr);
		test.setAttribute("parallel", "methods");
		if (GlobalThings.listOfBrowser.size() > 1) {
			TEST_THREAD_COUNT = "2";
		}
		test.setAttribute("thread-count", TEST_THREAD_COUNT);
		addParameter(browsers.getBrowserName(), test);

		// Test Classes section
		testName = document.createElement("classes");
		test.appendChild(testName);
	}

}
