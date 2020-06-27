package com.orange.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;

public enum TestEnvironmentEnum {

    Env_DESCRIPTION(0) {

        @Override

        public void process(Cell cell, InputEnvironmentDetails inputEnvDetails) {

               inputEnvDetails.setEnvironment(cell.getStringCellValue().toString());

        }

 },

 Env_URL(1) {

        @Override

        public void process(Cell cell, InputEnvironmentDetails inputEnvDetails) {

               inputEnvDetails.setUrl(cell.getStringCellValue().toString());

        }

 },

 Suite_EXECUTE(2) {

        @Override

        public void process(Cell cell, InputEnvironmentDetails inputEnvDetails) {

               inputEnvDetails.setExecute(cell.getStringCellValue().toString());

        }

 };



 private static Map<Integer, TestEnvironmentEnum> map = new HashMap<Integer, TestEnvironmentEnum>();

 private Integer cellId;



 static {

        TestEnvironmentEnum[] values = TestEnvironmentEnum.values();



        for (TestEnvironmentEnum testExcelEnum : values) {

               map.put(testExcelEnum.getCellId(), testExcelEnum);

        }

 }



 private TestEnvironmentEnum(Integer cellId) {

        this.cellId = cellId;

 }



 public Integer getCellId() {

        return cellId;

 }



 public static TestEnvironmentEnum getTestEnvironmentEnum(Integer value) {

        return map.get(value);

 }



 public abstract void process(Cell cell, InputEnvironmentDetails inputEnvDetails);


}
