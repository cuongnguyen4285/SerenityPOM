package com.simplypost.logistic.utilities;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;


public class DateTimeUtil {

    public static Integer DAY = 3;

    private static final String XLSFILE_PATH = SerenityUtil.getEnv("data.testdata");
    private static final String SHEET_NAME = "Data";

    public static String getAPIDriverTaskListDate(int index) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, index-1);
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(date)+"T16:00:00.000Z";
        return formattedDate;
    }

    public static String getAPIRescheduleDate(String futureDate) {
        Date date = formatStrToDate(futureDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        Date rescheduleDate= cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(rescheduleDate)+"T16:00:00.000Z";
        return formattedDate;
    }

    public static int getAPIToTime(String timeSlot){
        int toTime = Integer.parseInt(timeSlot.substring(8,10));
        return toTime;
    }

    public static int getAPIFromTime(String timeSlot){
        int fromTime = Integer.parseInt(timeSlot.substring(0,2));
        return fromTime;
    }

    public static String getAPIToday(){
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(today);
        return formattedDate;
    }

    public static String getAPISunday(){
        LocalDate today = LocalDate.now();
        LocalDate sunday = today;

        while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
            sunday = sunday.plusDays(1);
        }

        Date date = Date.from(sunday.atStartOfDay(ZoneId.systemDefault()).toInstant());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    public static String getAPIPastPickupDate(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);
        Date currentDate = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String pastDate = sdf.format(currentDate);
        return pastDate;
    }

    public static boolean isHolidays(String pickupDate) throws IOException {
        boolean isHoldays = false;
        XlsxUtil xls = new XlsxUtil();
        String[] holidays = xls.readSpecificColumnDataFromXLSFile(XLSFILE_PATH, SHEET_NAME, "Holidays");
        for(int i = 0; i < holidays.length;i++){
            if(pickupDate.equalsIgnoreCase(holidays[i])){
                isHoldays = true;
                break;
            }
        }
        return isHoldays;
    }

    public static String getAPIFuturePickupDate(String futureDate){
        Date date = formatStrToDate(futureDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String apiFutureDate = sdf.format(date);
        return apiFutureDate;
    }

    public static String getFuturePickupDate(String merchantCode, int plusDay) throws IOException{
        Calendar c = Calendar.getInstance();
        int dayOffWeek;

        //plus day to get future day
        c.add(Calendar.DATE,plusDay);

        //if Merchant Lazada and today is saturday, plus 1 day
        dayOffWeek = c.get(Calendar.DAY_OF_WEEK);
        if(merchantCode.contains( "LAZ")){
            if(dayOffWeek == Calendar.SATURDAY) {
                c.add(Calendar.DATE, 1);
            }
        }

        //plus 1 day if current day is sunday.
        dayOffWeek = c.get(Calendar.DAY_OF_WEEK);
        if(dayOffWeek == Calendar.SUNDAY){
            c.add(Calendar.DATE,1);
        }

        Date currentDate = c.getTime();
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/YYYY");
        String holidays = sfd.format(currentDate);
        if(isHolidays(holidays.substring(0,5))){
            c.add(Calendar.DATE, 1);
        }
        currentDate = c.getTime();
        String futureDate = sfd.format(currentDate);
        return futureDate;
    }

    public static String getAPIDateWithPlusDay(Date date, int plusDay){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, plusDay);
        Date pickupDate = cal.getTime();
        String apiPickupDate =sdf.format(pickupDate);
        return apiPickupDate;
    }

    public static String getDateWithPlusDay(Date date, int plusDay){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, plusDay);
        Date pickupDate = cal.getTime();
        String apiPickupDate =sdf.format(pickupDate);
        return apiPickupDate;
    }

    public static String convertToApiPickupDate(String pickupDate){
        Date date = formatStrToDate(pickupDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String apiPickupDate = sdf.format(date);
        return apiPickupDate;
    }

    public static String getPickupDate(String merchantCode) throws IOException {
        Calendar c = Calendar.getInstance();
        int currentHour = c.get(Calendar.HOUR_OF_DAY);
        int dayOffWeek = c.get(Calendar.DAY_OF_WEEK);

        //plus 1 day if after 16:00 and not Sunday
        if(currentHour >= 16 && dayOffWeek != Calendar.SUNDAY) {
            c.add(Calendar.DATE,1);
        }

        //if Merchant Lazada and today is saturday, plus 1 day
        dayOffWeek = c.get(Calendar.DAY_OF_WEEK);
        if(merchantCode != null){
            if(merchantCode.contains( "LAZ")){
                if(dayOffWeek == Calendar.SATURDAY) {
                    c.add(Calendar.DATE, 0);
                }
            }
        }

        //plus 1 day if current day is sunday.
        dayOffWeek = c.get(Calendar.DAY_OF_WEEK);
        if(dayOffWeek == Calendar.SUNDAY){
            c.add(Calendar.DATE,1);
        }

        Date currentDate = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        String holidays = sdf.format(currentDate);
        if(isHolidays(holidays.substring(0,5))){
            c.add(Calendar.DATE, 1);
        }

        currentDate = c.getTime();
        String pickupDate =sdf.format(currentDate);

        return pickupDate;
    }

    public static String getTimeSlot(String merchantCode){
        String lazadaTimeSlot = "";
        Calendar c = Calendar.getInstance();
        int currentHour = c.get(Calendar.HOUR_OF_DAY);
        int dayOffWeek = c.get(Calendar.DAY_OF_WEEK);

        if(merchantCode.contains("LAZ")){
            if(dayOffWeek == Calendar.SATURDAY || dayOffWeek == Calendar.SUNDAY){
                lazadaTimeSlot = "09:00 - 12:00";
            }else {

                if (currentHour <= 10) {
                    lazadaTimeSlot = "09:00 - 12:00";
                } else if (10 < currentHour && currentHour <= 13) {
                    lazadaTimeSlot = "12:00 - 15:00";
                } else if (13 < currentHour && currentHour < 16) {
                    lazadaTimeSlot = "15:00 - 18:00";
                } else {
                    lazadaTimeSlot = "09:00 - 12:00";
                }
            }
        }else{
            if(dayOffWeek == Calendar.SUNDAY){
                lazadaTimeSlot = "09:00 - 12:00";
            }else {

                if (currentHour <= 10) {
                    lazadaTimeSlot = "09:00 - 12:00";
                } else if (10 < currentHour && currentHour <= 13) {
                    lazadaTimeSlot = "12:00 - 15:00";
                } else if (13 < currentHour && currentHour < 16) {
                    lazadaTimeSlot = "15:00 - 18:00";
                } else {
                    lazadaTimeSlot = "09:00 - 12:00";
                }
            }
        }
        return lazadaTimeSlot;
    }

    public static String getDeliveryDate(String pickupDate, int standardServiceDay) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        Date cPickupDate = formatStrToDate(pickupDate);
        Calendar c = Calendar.getInstance();
        c.setTime(cPickupDate);

        //int isFlag = 0;
        for(int i = 1; i < standardServiceDay+1; i++){
            c.add(Calendar.DATE, 1);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            if(dayOfWeek == Calendar.SUNDAY){
                //isFlag++;
                c.add(Calendar.DATE, 1);
            }
            Date currentDate = c.getTime();
            String holidays = sdf.format(currentDate);
            if(isHolidays(holidays.substring(0,5))){
                c.add(Calendar.DATE, 1);
            }
        }

        //c.add(Calendar.DATE, isFlag);
        Date currentDate = c.getTime();
        String deliveryDate =sdf.format(currentDate);
        return deliveryDate;
    }

    public static String getAPIDeliveryDate(String deliveryDate) {
        Date date = formatStrToDate(deliveryDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String apiDeliveryDate = sdf.format(date);
        return apiDeliveryDate;
    }

    public static String getNextDate(){return getDate(1);}

    public static String getDateInThePast(){return getDate(-1);}

    public static String getDate(int index) {

        Calendar c = Calendar.getInstance();
        long millis = System.currentTimeMillis() + 24 * index * 3600 * 1000;
        c.setTime(new Date(millis));
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.SUNDAY) {
            millis += 24 * 3600 * 1000;
        }

        Date d = new Date(millis);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String formattedDate = sdf.format(d);
        return formattedDate;
    }

    public static String getDateWithFormat(int index, String dateFormat) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, index);
        Date date = c.getTime();

        String formattedDate = "";
        switch (dateFormat){
            case "dd/MM/YYYY":
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/YYYY");
                formattedDate = sdf1.format(date);
                break;
            case "YYYY/MM/dd":
                SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY/MM/dd");
                formattedDate = sdf2.format(date);
                break;
            case "YYYY_MM_dd_hh_mm_ss":
                SimpleDateFormat sdf3 = new SimpleDateFormat("YYYY_MM_dd_hh_mm_ss");
                formattedDate = sdf3.format(date);
                break;
            default:
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
                formattedDate = sdf.format(date);
        }

        return formattedDate;
    }

    public static String getUnquieName(String name) {
        String uniqueName = "";
        try{
            uniqueName = name + getDateWithFormat(0, "YYYY_MM_dd_hh_mm_ss");
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return uniqueName;
    }

    public static String getCurrentHour() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static String getCurrentDateTime() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public static int getUnixTimeStamp() {
        return (int) (System.currentTimeMillis() / 1000L);
    }

    private static Date parseStringToDate(String targetString) throws Exception{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'X'");
        Date date =formatter.parse(targetString);
        return date;
    }

    public static Date formatStrToAPIDate(String date){
        // PARSE: String to date

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date cDate = null;
        try{
            cDate = dateFormat.parse(date);
        }catch (ParseException e) {
            e.printStackTrace();
        }

        return cDate;
    }

    public static Date formatStrToDate(String date){
        // PARSE: String to date
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date cDate = null;
        try{
            cDate = dateFormat.parse(date);
        }catch (ParseException e) {
            e.printStackTrace();
        }

        return cDate;
    }


    public static String formatAPIDateToStr(Date date){
        // FORMAT: Date to String
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String cDate = null;
        try{
            cDate = dateFormat.format(date);
        } catch (Exception e){
            e.printStackTrace();
        }

        return cDate;
    }

    public static String formatDateToStr(Date date){
        // FORMAT: Date to String
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String cDate = null;
        try{
            cDate = dateFormat.format(date);
        } catch (Exception e){
            e.printStackTrace();
        }

        return cDate;
    }

    public static String getTodayDate(){
        Date today = new Date();
        String todaydate = formatDateToStr(today);
        return  todaydate;
    }

    public static boolean compareSDateEDate_vs_CurrentDate(String startdate, String enddate){
        // to compare the today date and time is actually in between the configured start date (time) and end date (time)
        return formatStrToDate(getTodayDate()).after(formatStrToDate(startdate)) && formatStrToDate(getTodayDate()).before(formatStrToDate(enddate));
    }


}
