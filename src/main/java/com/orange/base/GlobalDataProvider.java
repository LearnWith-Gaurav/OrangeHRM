package com.orange.base;

import static com.orange.base.GlobalThings.listOfEnv;
import static com.orange.base.GlobalThings.listOfInputs;
import org.testng.ITestNGMethod;
import org.testng.annotations.DataProvider;

public class GlobalDataProvider {

    public static final String TEST_DATA_PROVIDER = "TEST_DATA_PROVIDER";

    

    @DataProvider(name = TEST_DATA_PROVIDER)

    public static Object[][] getData(ITestNGMethod method) {

           try {

                  Object[][] arr = new Object[getSize(method.getMethodName())][2];

                  int i = 0;

                  for (InputTestDetails inputTestDetails : listOfInputs) {

                        if (method.getMethodName().equals(("test_" + inputTestDetails.getTestCaseID()))) {

                               arr[i][0] = listOfEnv.get(0);

                               arr[i][1] = inputTestDetails;

                               i++;

                        }

                  }

                  return arr;

           } catch (Exception e) {

                  throw new AssertionError("No Data available");

           }

    }



    private static int getSize(String method) {

           int count = 0;

           for (InputTestDetails inputTestDetails : listOfInputs) {

                  if (method.equals("test_" + inputTestDetails.getTestCaseID())) {

                        count++;

                  }

           }

           return count;

    }
}
