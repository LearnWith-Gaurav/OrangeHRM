package com.orange.base;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GlobalThings {

    public static final String reportDirectory = new File(".").getAbsolutePath() + "TestReport\\";

    public static final String testDirectory = new File(".").getAbsolutePath() + "TestDirectory\\";

    public static final List<InputTestDetails> listOfInputs = new ArrayList<InputTestDetails>();

    public static final List<InputSuiteDetails> listOfsuite = new ArrayList<InputSuiteDetails>();

    public static final List<InputBrowserDetails> listOfBrowser = new ArrayList<InputBrowserDetails>();

    public static final List<InputEnvironmentDetails> listOfEnv = new ArrayList<InputEnvironmentDetails>();

    public static final List<TestResultReport> testResultReports = new ArrayList<TestResultReport>();

    public static final List<InputEmailDetails> listOfEmail = new ArrayList<InputEmailDetails>();

    public static final String driversPath = System.getProperty("user.dir") + "\\Drivers";

    public static Long timeForExecution = (long) 0;

    public static int failedTestcaseCount = 0;

    public static final String downloadFilePath = new File(System.getProperty("user.dir")).getAbsolutePath()

                       + "\\DownloadedFiles\\";

    public static final String downloadUrl = "chrome://downloads";

    public static String portalLanguage = null;

    public static Long executionEndTimeForScenario = (long) 0;

    public static Long executionStartTimeForScenario = (long) 0;

    public static final String fileUpload = new File("").getAbsolutePath() + "\\SupportingDocs\\New Microsoft Word Document.docx";

    public static final List<InputTestDetails> listOfTestSkipped = new ArrayList<InputTestDetails>();

    public static final String extentConfigFile = new File("").getAbsolutePath() + "\\extent-config.xml";

    public static final String xmlFile = new File("").getAbsolutePath() + "\\testNG.xml";

    protected static Long startTime_Excution = (long) 0;

    public static final String openBtnImage = new File("").getAbsolutePath() + "\\SupportingDocs\\OpenBtn.PNG";

    protected static long totalTestCases = 0;



    public static String actual;

    public static String casID;

    public static String casIDOne;

    public static String DTACID;

    public static String DPACID;

    public static String caseIdNum;

    public static final Collection<String> Elements = new ArrayList<String>();

    public static Iterator<String> caseiterator;

    public static String checkbox;

    public static String elementText;

    public static Iterator<String> iterator;

    public static String childCase;

    public static String childCase1;

    public static String parentCase;

    public static String parentCase1;



    public static String caseID2;



    public static String caseIDDetails;



    public static String filePathDtac = System.getProperty("user.dir") + "\\SupportingDocs\\LOR-New.pdf";

    public static String uploadFilePathDtac = System.getProperty("user.dir") + "\\SupportingDocs\\ONFR.pdf";

    public static String drafFileName;

    public static String uploadFileName;

    public static String caseIdDtac;

    public static String priority_1_TechinFieldUrgent;

    public static String priority_1a_TechinShop_CustomerWaiting;

    public static String priority_2_Normal;

    public static String priority_3_ReportOnly;



    public static String actualColor;

    public static String expectedColorDA = "#ffed73";

    public static String expectedColorDT = "#dddddd";

    public static String dtacCaseId;

    public static String dpacCaseId;



    public static final String filePathImage = new File("").getAbsolutePath() + "\\SupportingDocs\\WebFormsImg.png";

    public static final String filePathImage1 = new File("").getAbsolutePath() + "\\SupportingDocs\\logo.png";



    public static final String sampleDoc = new File("").getAbsolutePath() + "\\SupportingDocs\\sample.docx";

    public static final String invalidFile = new File("").getAbsolutePath() + "\\SupportingDocs\\Kalimba.mp3";



    public static final String fileUploadrtf = new File("").getAbsolutePath() + "\\SupportingDocs\\RTF.rtf";



    public static final String fileUploadDocx = new File("").getAbsolutePath()

                       + "\\SupportingDocs\\New Microsoft Word Document.docx";

    public static final String fileUploadDoc = new File("").getAbsolutePath() + "\\SupportingDocs\\DOC.doc";

    public static final String fileUploadAbove10 = new File("").getAbsolutePath() + "\\SupportingDocs\\Above10Mb.pdf";

    public static final String fileUploadBelow10Mb = new File("").getAbsolutePath() + "\\SupportingDocs\\Below10Mb.pdf";

    public static final String fileUploadMp4 = new File("").getAbsolutePath() + "\\SupportingDocs\\mp4 file.mp4";



    public static String Above10MBfilePath = System.getProperty("user.dir") + "\\SupportingDocs\\Above10Mb.pdf";



    public static String caseIdTc5768;

    public static String caseIdDpac;

    // public static String workbasketRecords;

    public static String case2;

    public static String currentPriority;

    public static String three;

    public static Boolean hasClosedCCMSPopup = false;


}
