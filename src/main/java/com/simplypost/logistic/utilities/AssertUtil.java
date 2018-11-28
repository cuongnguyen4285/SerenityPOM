package com.simplypost.logistic.utilities;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AssertUtil {

    public static void assertThatEqual(String actualValue, String expectedValue){
        if(expectedValue != null){
            assertThat(actualValue, is(equalTo(expectedValue)));
        }
    }

    public static void assertThatEqual(boolean actualValue, boolean expectedValue){
            assertThat(actualValue, is(equalTo(expectedValue)));
    }

    public static void assertThatNotEqual(String actualValue, String expectedValue){
        if(expectedValue != null){
            assertThat(actualValue, is(not(equalTo(expectedValue))));
        }
    }

    public static void assertThatHasItem(List<String> itemList, String item){
        if(itemList != null){
            assertThat(itemList, hasItem(item));
        }
    }

    public static void assertThatHasItems(List<String> itemList, String[] itemArray){
        if(itemList != null){
            assertThat(itemList, hasItems(itemArray));
        }
    }

    public static void assertThatNotEmpty(String actualValue){
        assertThat(actualValue, not(isEmptyString()));
    }

    public static void assertThatContainsString(String actualValue, String expectedValue){
        if(expectedValue != null){
            assertThat(actualValue, containsString(expectedValue));
        }
    }

    public static void assertThat2ListsEqual(List<String> actualList, List<String> expectedList){
        String actualOrders = actualList.toString();
        boolean flag = true;
        for (String expectedOrder : expectedList) {
            if(actualOrders.indexOf(expectedOrder) == -1){
                flag =false;
                break;
            }
        }
        assertThat(flag, is(true));
    }

    public static void assertThatListContains(List<String> actualList, String expectedString){
        String actualOrders = actualList.toString();
        boolean flag = true;
        if(actualOrders.indexOf(expectedString) == -1){
            flag =false;
        }
        assertThat(flag, is(true));
    }

    public static void assertThatValueLessThan(int smallerValue, int largerValue){
        assertThat(smallerValue, lessThan(largerValue));
    }

    public static void assertThatValueGreaterThan(int smallerValue, int largerValue){
        assertThat(largerValue, greaterThan(smallerValue));
    }

    public static void assertThatValueEqualTo(int smallerValue, int largerValue){
        assertThat(smallerValue, equalTo(largerValue));
    }

    public static void assertThatValueLessOrEqualTo(int smallerValue, int largerValue){
        assertThat(smallerValue, lessThanOrEqualTo(largerValue));
    }

    public static void assertThatValueGreaterOrEqualTo(int smallerValue, int largerValue){
        assertThat(largerValue, greaterThanOrEqualTo(smallerValue));
    }

}
