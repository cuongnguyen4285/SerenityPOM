package com.simplypost.logistic.utilities;

import ch.lambdaj.function.convert.Converter;
import com.simplypost.logistic.pageObject.PageObjects;
import net.thucydides.core.matchers.BeanMatcher;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

import static ch.lambdaj.Lambda.convert;

/**
 * Class designed to make it easier reading from and reasoning about data in HTML tables.
 */
public class HtmlTableUtil extends PageObjects {
    private final WebElement tableElement;
    private List<String> headings;

    public HtmlTableUtil(final WebElement tableElement) {
        this.tableElement = tableElement;
        this.headings = null;
    }

    public HtmlTableUtil(final WebElement tableElement, List<String> headings) {
        this.tableElement = tableElement;
        this.headings = headings;
    }

    public static HtmlTableUtil inTable(final WebElement table) {
        return new HtmlTableUtil(table);
    }

    public static RUHtmlTableBuilder withColumns(String... headings) {
        return new RUHtmlTableBuilder(Arrays.asList(headings));
    }

    public static List<Map<Object, String>> rowsFrom(final WebElement table) {
        return new HtmlTableUtil(table).getRows();
    }

    public static List<WebElement> filterRows(final WebElement table, final BeanMatcher... matchers) {
        return new HtmlTableUtil(table).getRowElementsWhere(matchers);
    }

    public static String getCellValueAtIndex(WebElement table, int row, int column){
        WebElement cell = table.findElement(By.xpath("tbody/tr["+ row + "]/td[" + column + "]"));
        return cell.getText();
    }

    public static void enterCellValueAtIndex(WebElement table, int row, int column, String value){
        WebElement cell = table.findElement(By.xpath("tbody/tr["+ row + "]/td[" + column + "]"));
        cell.sendKeys(value);
    }

    public static void clickCellValueAtIndex(WebElement table, int row, int column){
        WebElement cell = table.findElement(By.xpath("tbody/tr["+ row + "]/td[" + column + "]"));
        cell.click();
    }

    public static int getColumnIndexByHeader(WebElement table, String header){
        List<WebElement> headers = table.findElements(By.tagName("th"));
        int column = 0;
        for(int i = 0; i < headers.size(); i++){
            if(headers.get(i).getText().equalsIgnoreCase(header)){
                column = i+1;
                break;
            }
        }
        return column;
    }

    public static int getRowIndexByValue(WebElement table, String value){
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int row = 0;
        for(int j = 0; j < rows.size(); j++){
            if(rows.get(j).getText().equalsIgnoreCase(value)){
                row = j+1;
                break;
            }
        }
        return row;
    }

    public static String getCellValueAtHeader(WebElement table, int row, String header){
        List<WebElement> headers = table.findElements(By.tagName("th"));
        String cellValue = "";
        for(int i = 0; i < headers.size(); i++){
            if(headers.get(i).getText().equalsIgnoreCase(header)){
                int column = i;
                WebElement cell = table.findElement(By.xpath("tbody/tr["+ row + "]/td[" + column + "]"));
                cellValue = cell.getText();
            }
        }
        return cellValue;
    }

    public List<Map<Object, String>> getRows() {

        List<Map<Object, String>> results = new ArrayList<Map<Object, String>>();

        List<String> headings = getHeadings();
        List<WebElement> rows = getRowElementsFor(headings);

        for (WebElement row : rows) {
            List<WebElement> cells = cellsIn(row);
            if (enoughCellsFor(headings).in(cells)) {
                results.add(rowDataFrom(cells, headings));
            }
        }
        return results;
    }

    public WebElement findFirstRowWhere(final BeanMatcher... matchers) {
        List<WebElement> rows = getRowElementsWhere(matchers);
        if (rows.isEmpty()) {
            throw new AssertionError("Expecting a table with at least one row where: " + Arrays.deepToString(matchers));
        }
        return rows.get(0);
    }

    public boolean containsRowElementsWhere(BeanMatcher... matchers) {
        List<WebElement> rows = getRowElementsWhere(matchers);
        return (!rows.isEmpty());
    }

    public void shouldHaveRowElementsWhere(BeanMatcher... matchers) {
        List<WebElement> rows = getRowElementsWhere(matchers);
        if (rows.isEmpty()) {
            throw new AssertionError("Expecting a table with at least one row where: " + Arrays.deepToString(matchers));
        }
    }

    public void shouldNotHaveRowElementsWhere(BeanMatcher... matchers) {
        List<WebElement> rows = getRowElementsWhere(matchers);
        if (!rows.isEmpty()) {
            throw new AssertionError("Expecting a table with no rows where: " + Arrays.deepToString(matchers));
        }
    }

    private EnoughCellsCheck enoughCellsFor(List<String> headings) {
        return new EnoughCellsCheck(headings);
    }

    public List<String> getHeadings() {
        if (headings == null) {
            List<String> thHeadings = convert(headingElements(), toTextValues());
            if (thHeadings.isEmpty()) {
                headings = convert(firstRowElements(), toTextValues());
            } else {
                headings = thHeadings;
            }
        }
        return headings;
    }

    public List<WebElement> headingElements() {
        return tableElement.findElements(By.xpath(".//th"));
    }

    public List<WebElement> firstRowElements() {
        return tableElement.findElement(By.tagName("tr")).findElements(By.xpath(".//td"));
    }

    public List<WebElement> getRowElementsFor(List<String> headings) {

        List<WebElement> rowCandidates = tableElement.findElements(By.xpath(".//tr[td][count(td)>=" + headings.size() + "]"));
        rowCandidates = stripHeaderRowIfPresent(rowCandidates, headings);
        return rowCandidates;
    }

    public List<WebElement> getRowElementsFormtFoot() {
        List<WebElement> rowCandidates = tableElement.findElements(By.xpath("./tfoot/tr[th]"));
        return rowCandidates;
    }


    public List<WebElement> getRowElements() {

        return getRowElementsFor(getHeadings());
    }

    private List<WebElement> stripHeaderRowIfPresent(List<WebElement> rowCandidates, List<String> headings) {
        if (!rowCandidates.isEmpty()) {
            WebElement firstRow = rowCandidates.get(0);
            if (hasMatchingCellValuesIn(firstRow, headings)) {
                rowCandidates.remove(0);
            }
        }
        return rowCandidates;
    }

    private boolean hasMatchingCellValuesIn(WebElement firstRow, List<String> headings) {
        List<WebElement> cells = firstRow.findElements(By.xpath("./td"));
        for (int cellIndex = 0; cellIndex < headings.size(); cellIndex++) {
//            if ((cells.size() < cellIndex) || (!cells.get(cellIndex).getText().equals(headings.get(cellIndex)))) {
            if ((cells.size() < cellIndex) || (!getText(cells.get(cellIndex)).equals(headings.get(cellIndex)))) {
                return false;
            }
        }
        return true;
    }

    public List<Map<String, WebElement>> getWebElementRows(List<String> headings) {

        List<Map<String, WebElement>> results = new ArrayList<Map<String, WebElement>>();

        List<WebElement> rows = getRowElementsFor(headings);

        for (WebElement row : rows) {
            List<WebElement> cells = cellsIn(row);
            if (enoughCellsFor(headings).in(cells)) {
                results.add(rowObjectFrom(cells, headings));
            }
        }
        return results;
    }

    public List<List<WebElement>> getCellsElementInRows() {
        List<List<WebElement>> results = new ArrayList<List<WebElement>>();
        List<WebElement> rows = getRowElementsFormtFoot();

        for (WebElement row : rows) {
            List<WebElement> cells = fFootCellsIn(row);
                results.add(cells);
        }
        return results;
    }

    private Map<String, WebElement> rowObjectFrom(List<WebElement> cells, List<String> headings) {
        Map<String, WebElement> rowData = new HashMap<String, WebElement>();

        int column = 0;
        for (String heading : headings) {
            WebElement cell = cellValueAt(column++, cells);
            rowData.put(heading, (WebElement) cell);

        }
        return rowData;
    }

    public List<WebElement> getRowElementsWhere(BeanMatcher... matchers) {

        List<WebElement> rowElements = getRowElementsFor(getHeadings());
        List<Integer> matchingRowIndexes = findMatchingIndexesFor(rowElements, matchers);

        List<WebElement> matchingElements = new ArrayList<WebElement>();
        for (Integer index : matchingRowIndexes) {
            matchingElements.add(rowElements.get(index));
        }
        return matchingElements;
    }

    private List<Integer> findMatchingIndexesFor(List<WebElement> rowElements,
                                                 BeanMatcher[] matchers) {
        List<Integer> indexes = new ArrayList<Integer>();
        List<String> headings = getHeadings();

        int index = 0;
        for (WebElement row : rowElements) {
            List<WebElement> cells = cellsIn(row);
            Map<Object, String> rowData = rowDataFrom(cells, headings);
            if (matches(rowData, matchers)) {
                indexes.add(index);
            }
            index++;
        }

        return indexes;
    }

    private boolean matches(Map<Object, String> rowData, BeanMatcher[] matchers) {
        for (BeanMatcher matcher : matchers) {
            if (!matcher.matches(rowData)) {
                return false;
            }
        }
        return true;
    }


    private Map<Object, String> rowDataFrom(List<WebElement> cells, List<String> headings) {
        Map<Object, String> rowData = new HashMap<>();

        int column = 0;
        for (String heading : headings) {
            String cell = cellValueAt(column++, cells).getText();
            if (!StringUtils.isEmpty(heading)) {
                rowData.put(heading, cell);
            }
            rowData.put(column, cell);
        }
        return rowData;
    }

    private List<WebElement> cellsIn(WebElement row) {
        return row.findElements(By.xpath("./td"));
    }

    private List<WebElement> fFootCellsIn(WebElement row) {
        return row.findElements(By.xpath("./th"));
    }

    private WebElement cellValueAt(final int column, final List<WebElement> cells) {
        return cells.get(column);
    }

    private Converter<WebElement, String> toTextValues() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
//                return from.getText();
                return getText(from);
            }
        };
    }

    public List<WebElement> filterRows(final BeanMatcher... matchers) {
        return new HtmlTableUtil(tableElement).getRowElementsWhere(matchers);
    }

    public static class RUHtmlTableBuilder {
        private final List<String> headings;

        public RUHtmlTableBuilder(List<String> headings) {
            this.headings = headings;
        }

        public List<Map<Object, String>> readRowsFrom(WebElement table) {
            return new HtmlTableUtil(table, headings).getRows();
        }

        public HtmlTableUtil inTable(WebElement table) {
            return new HtmlTableUtil(table, headings);
        }
    }

    private class EnoughCellsCheck {
        private final int minimumNumberOfCells;

        private EnoughCellsCheck(List<String> headings) {
            this.minimumNumberOfCells = headings.size();
        }

        public boolean in(List<WebElement> cells) {
            return (cells.size() >= minimumNumberOfCells);
        }
    }

    public static HashMap<String, String> getTableCellValuesAtRow(WebElement table, int row){
        HashMap<String, String> hashMap = new HashMap<String, String>();
        HtmlTableUtil itemHTMLTable = new HtmlTableUtil(table);

        List<String> headings = convert(table.findElements(By.xpath("thead//th")), SerenityUtil.toTextValues());
        List<Map<String, WebElement>> rows = itemHTMLTable.getWebElementRows(headings);

        for (int i = 0; i < headings.size(); i++){

            hashMap.put(headings.get(i), rows.get(row).get(headings.get(i)).getText());
        }

        return hashMap;
    }

    public static List<Map<String, String>> getTableCellValues(WebElement table){
        List<Map<String, String>> results = new ArrayList<>();
        Map<String, String> map = new HashMap<String, String>();
        HtmlTableUtil itemHTMLTable = new HtmlTableUtil(table);

        List<String> headings = convert(table.findElements(net.serenitybdd.core.annotations.findby.By.xpath("thead//th")), SerenityUtil.toTextValues());
        List<Map<String, WebElement>> rows = itemHTMLTable.getWebElementRows(headings);

        for (Map<String, WebElement> row : rows){
            for (String heading : headings){
                map.put(heading, row.get(heading).getText());
            }
            results.add(map);
        }
        return results;
    }

}
