package com.orange.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;

public enum TestEmailEnum {

	   TYPE(0) {

           @Override

           public void process(Cell cell, InputEmailDetails inputEmailDetails) {

                  inputEmailDetails.setEmailType(cell.getStringCellValue().toString());

           }

    },

    ADDRESS(1) {

           @Override

           public void process(Cell cell, InputEmailDetails inputEmailDetails) {

                  inputEmailDetails.setEmailAddress(cell.getStringCellValue().toString().split(";"));

           }

    },

    SEND(2) {

           @Override

           public void process(Cell cell, InputEmailDetails inputEmailDetails) {

                  inputEmailDetails.setSendEmail(cell.getStringCellValue().toString());

           }

    };



    private static Map<Integer, TestEmailEnum> map = new HashMap<Integer, TestEmailEnum>();

    private Integer cellId;



    static {

           TestEmailEnum[] values = TestEmailEnum.values();



           for (TestEmailEnum testEmailEnum : values) {

                  map.put(testEmailEnum.getCellId(), testEmailEnum);

           }

    }



    private TestEmailEnum(Integer cellId) {

           this.cellId = cellId;

    }



    public Integer getCellId() {

           return cellId;

    }



    public static TestEmailEnum getTestEmailEnum(Integer value) {

           return map.get(value);

    }



    public abstract void process(Cell cell, InputEmailDetails inputEmailDetails);


}
