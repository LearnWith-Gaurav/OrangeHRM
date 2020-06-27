package com.orange.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;

public enum TestSuiteEnum {

	  Suite_ID(0) {

          @Override

          public void process(Cell cell, InputSuiteDetails inputSuiteDetails) {

                 inputSuiteDetails.setsuiteID(cell.getStringCellValue().toString());

          }

   },

   Suite_DESCRIPTION(1) {

          @Override

          public void process(Cell cell, InputSuiteDetails inputSuiteDetails) {

                 inputSuiteDetails.setsuiteDescription(cell.getStringCellValue().toString());

          }

   },

   TEST_MODULE(2) {

          @Override

          public void process(Cell cell, InputSuiteDetails inputSuiteDetails) {

                 inputSuiteDetails.setModule(cell.getStringCellValue().toString());

          }

   },

   Suite_EXECUTE(3) {

          @Override

          public void process(Cell cell, InputSuiteDetails inputSuiteDetails) {

                 inputSuiteDetails.setExecute(cell.getStringCellValue().toString());

          }

   };



   private static Map<Integer, TestSuiteEnum> map = new HashMap<Integer, TestSuiteEnum>();

   private Integer cellId;



   static {

          TestSuiteEnum[] values = TestSuiteEnum.values();



          for (TestSuiteEnum testExcelEnum : values) {

                 map.put(testExcelEnum.getCellId(), testExcelEnum);

          }

   }



   private TestSuiteEnum(Integer cellId) {

          this.cellId = cellId;

   }



   public Integer getCellId() {

          return cellId;

   }



   public static TestSuiteEnum getTestExcelEnum(Integer value) {

          return map.get(value);

   }



   public abstract void process(Cell cell, InputSuiteDetails inputSuiteDetails);


}
