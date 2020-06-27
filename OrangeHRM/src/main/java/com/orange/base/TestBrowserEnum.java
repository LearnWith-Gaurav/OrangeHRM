package com.orange.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;

public enum TestBrowserEnum {

	   Browser(0) {

           @Override

           public void process(Cell cell, InputBrowserDetails inputBrowserDetails) {

                  inputBrowserDetails.setBrowserName((cell.getStringCellValue().toString()));

           }

    },

    EXECUTE(1) {

           @Override

           public void process(Cell cell, InputBrowserDetails inputBrowserDetails) {

                  inputBrowserDetails.setExecute((cell.getStringCellValue().toString()));
                 
           }

    };



    private static Map<Integer, TestBrowserEnum> map = new HashMap<Integer, TestBrowserEnum>();

    private Integer cellId;



    static {

           TestBrowserEnum[] values = TestBrowserEnum.values();



           for (TestBrowserEnum testExcelEnum : values) {

                  map.put(testExcelEnum.getCellId(), testExcelEnum);

           }

    }



    private TestBrowserEnum(Integer cellId) {

           this.cellId = cellId;

    }



    public Integer getCellId() {

           return cellId;

    }



    public static TestBrowserEnum getTestExcelEnum(Integer value) {

           return map.get(value);

    }



    public abstract void process(Cell cell, InputBrowserDetails inputBrowserDetails);


}
