package com.orange.base;

import static com.orange.base.GlobalThings.failedTestcaseCount;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CreationHelper;

public enum TestResultEnum {

    SET_ENVIRONMENT(0) {

        @Override

        public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,

                     HSSFCellStyle cellStyleForFailed, HSSFCellStyle cellStyleForPass) {

               cell.setCellValue(testResultReport.getEnvironment());

               cell.setCellStyle(cellStyleInGeneral);

        }

 },

 SET_Browser(1) {

        @Override

        public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,

                     HSSFCellStyle cellStyleForFailed, HSSFCellStyle cellStyleForPass) {

               cell.setCellValue(testResultReport.getBrowser());

               cell.setCellStyle(cellStyleInGeneral);

        }

 },

 SET_TEST_ID(2) {

        @Override

        public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,

                     HSSFCellStyle cellStyleForFailed, HSSFCellStyle cellStyleForPass) {

               cell.setCellValue(testResultReport.getTestCaseId());

               cell.setCellStyle(cellStyleInGeneral);

        }

 },

 SET_TEST_DESCRIPTION(3) {

        @Override

        public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,

                     HSSFCellStyle cellStyleForFailed, HSSFCellStyle cellStyleForPass) {

               cell.setCellValue(testResultReport.getTestCaseDescription());

               cell.setCellStyle(cellStyleInGeneral);

        }

 },

 SET_TEST_RESULT(4) {

        @Override

        public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,

                     HSSFCellStyle cellStyleForFailed, HSSFCellStyle cellStyleForPass) {

               cell.setCellValue(testResultReport.getResult());

               if (testResultReport.getResult().equals("Fail")) {

                     cell.setCellStyle(cellStyleForFailed);

                     failedTestcaseCount++;

               } else {

                     cell.setCellStyle(cellStyleForPass);

               }

        }

 },

 SET_SCREENSHOT_PATH(5) {

        @Override

        public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,

                     HSSFCellStyle cellStyleForFailed, HSSFCellStyle cellStyleForPass) {

               CreationHelper helper = CommonFunctions.reportWorkbook.getCreationHelper();

               HSSFFont hlinkfont = CommonFunctions.reportWorkbook.createFont();

               hlinkfont.setUnderline(HSSFFont.U_SINGLE);

               hlinkfont.setColor(HSSFColor.BLUE.index);

               HSSFCellStyle cellStyle = CommonFunctions.reportWorkbook.createCellStyle();

               cellStyle.setFont(hlinkfont);

               if (testResultReport.getResult().equalsIgnoreCase("Fail")) {

                      HSSFHyperlink hyperLink = (HSSFHyperlink) helper.createHyperlink(HSSFHyperlink.LINK_URL);

                     hyperLink = (HSSFHyperlink) helper.createHyperlink(HSSFHyperlink.LINK_FILE);

                     hyperLink.setAddress(testResultReport.getSSPath());

                     cell.setCellValue("Screenshot");

                     cell.setHyperlink(hyperLink);

                     cell.setCellStyle(cellStyle);

               } else {

                     cell.setCellStyle(cellStyleInGeneral);

               }

        }

 },

 SET_FUNCTIONAL_ERROR(6) {

        @Override

        public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,

                     HSSFCellStyle cellStyleForFailed, HSSFCellStyle cellStyleForPass) {

               cell.setCellValue(testResultReport.getFunctionalError());

               cell.setCellStyle(cellStyleInGeneral);

        }

 },

 SET_TECHNICAL_ERROR(7) {

        @Override

        public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,

                     HSSFCellStyle cellStyleForFailed, HSSFCellStyle cellStyleForPass) {

               cell.setCellValue(testResultReport.getTechnicalError());

               cell.setCellStyle(cellStyleInGeneral);

        }

 },

 SET_USERDEFINED_ERROR(8) {

        @Override

        public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,

                     HSSFCellStyle cellStyleForFailed, HSSFCellStyle cellStyleForPass) {

               cell.setCellValue(testResultReport.getUserDefinedError());

               cell.setCellStyle(cellStyleInGeneral);

        }

 },

 SET_EXECUTION_TIME(9) {

        @Override

        public void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,

                     HSSFCellStyle cellStyleForFailed, HSSFCellStyle cellStyleForPass) {

               cell.setCellValue(testResultReport.getExecutionTime());

               cell.setCellStyle(cellStyleInGeneral);

        }

 };



 private static Map<Integer, TestResultEnum> map = new HashMap<Integer, TestResultEnum>();

 private Integer cellValue;



 static {

        TestResultEnum[] values = TestResultEnum.values();

        for (TestResultEnum testResultEnum : values) {

               map.put(testResultEnum.getCellValue(), testResultEnum);

        }

 }



 private TestResultEnum(Integer cellValue) {

        this.cellValue = cellValue;

 }



 public Integer getCellValue() {

        return cellValue;

 }



 public static TestResultEnum getTestResultEnum(Integer cellColumnIndex) {

        return map.get(cellColumnIndex);

 }



 public abstract void process(TestResultReport testResultReport, HSSFCell cell, HSSFCellStyle cellStyleInGeneral,

               HSSFCellStyle cellStyleForFailed, HSSFCellStyle cellStyleForPass);


}
