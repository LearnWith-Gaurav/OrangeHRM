package com.orange.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;

public enum TestExcelEnum {

	TEST_ID(0) {

        @Override

        public void process(Cell cell, InputTestDetails inputTestDetails) {

               inputTestDetails.setTestCaseID(cell.getStringCellValue().toString());

        }

 },



 TEST_FUNCTIONALITY(1) {

        @Override

        public void process(Cell cell, InputTestDetails inputTestDetails) {

               inputTestDetails.setFunctionality(cell.getStringCellValue().toString());

        }

 },

 TEST_DESCRIPTION(2) {

        @Override

        public void process(Cell cell, InputTestDetails inputTestDetails) {

               inputTestDetails.setTestCaseDescription(cell.getStringCellValue().toString());

        }

 },



 TEST_MODULE(3) {

        @Override

        public void process(Cell cell, InputTestDetails inputTestDetails) {

               inputTestDetails.setModule(cell.getStringCellValue().toString());

        }

 },

 TEST_FLOW(4) {

        @Override

        public void process(Cell cell, InputTestDetails inputTestDetails) {

               inputTestDetails.setfunctionalityFlow(cell.getStringCellValue().toString());

        }

 },

 TEST_EXECUTE(5) {

        @Override

        public void process(Cell cell, InputTestDetails inputTestDetails) {

               inputTestDetails.setExecute(cell.getStringCellValue().toString());

        }

 },



 TEST_DATA(6) {

        @Override

        public void process(Cell cell, InputTestDetails inputTestDetails) {

               inputTestDetails.setTestdata(cell.getStringCellValue().toString().split(";"));

        }

 },



 EXPECTED_DATA(7) {

        @Override

        public void process(Cell cell, InputTestDetails inputTestDetails) {

               inputTestDetails.setExpectedResult(cell.getStringCellValue().toString().split(";"));

        }

 };



 private static Map<Integer, TestExcelEnum> map = new HashMap<Integer, TestExcelEnum>();

 private Integer cellId;



 static {

        TestExcelEnum[] values = TestExcelEnum.values();



        for (TestExcelEnum testExcelEnum : values) {

               map.put(testExcelEnum.getCellId(), testExcelEnum);

        }

 }



 private TestExcelEnum(Integer cellId) {

        this.cellId = cellId;

 }



 public Integer getCellId() {

        return cellId;

 }



 public static TestExcelEnum getTestExcelEnum(Integer value) {

        return map.get(value);

 }



 public abstract void process(Cell cell, InputTestDetails inputTestDetails);


}
