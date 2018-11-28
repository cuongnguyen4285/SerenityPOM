package com.simplypost.logistic.dataBuilder;
import com.simplypost.logistic.pageObject.PageObjects;
import com.simplypost.logistic.utilities.XlsxUtil;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scorpion on 6/7/17.
 */
public class CsvDataBuilder extends PageObjects {
    private static final String CSV_SEPARATOR = ",";
    private static final String ORDER_REF = "B";
    private static final String SERVICE_TYPE = "C";
    private static final String COD_TYPE = "D";
    private static final String COD_AMOUNT = "E";
    private static final String PARCEL = "F";
    private static final String PICKUP_DATE = "G";
    private static final String DROPOFF_DATE = "H";
    private static final String IS_NONPICKUP = "I";
    private static final String IS_FOLLOW_SLA = "J";
    private static final String SENDER_NAME = "K";
    private static final String SENDER_EMAIL = "L";
    private static final String SENDER_COUNTRY = "M";
    private static final String SENDER_CITY = "N";
    private static final String SENDER_PHONE = "O";
    private static final String SENDER_STREET = "P";
    private static final String SENDER_ZIPCODE = "Q";
    private static final String SENDER_BUILDING = "R";
    private static final String SENDER_UNIT = "S";
    private static final String RECEIVER_NAME = "T";
    private static final String RECEIVER_EMAIL = "U";
    private static final String RECEIVER_COUNTRY = "V";
    private static final String RECEIVER_CITY = "W";
    private static final String RECEIVER_PHONE = "X";
    private static final String RECEIVER_STREET = "Y";
    private static final String RECEIVER_ZIPCODE = "Z";
    private static final String RECEIVER_BUILDING = "AA";
    private static final String RECEIVER_UNIT = "AB";
    private static final String CASE_TYPES= "AC";

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    protected static Object[][] obj = null;
    protected static String currentDataFile = "";

    protected static void prepareTestData(String issue, String datafile) throws Exception {
        currentDataFile = datafile;
        XlsxUtil xls = new XlsxUtil();
        List<String[]> datasrc = xls.readXLSFile(datafile, 0);
        int size = datasrc.size() - 1;
        Object[][] obj = new Object[size][];
        UserDataBuilder.obj = obj;
        //Remove header
        for (int key = 1; key < datasrc.size(); key++) {
            String[] row = datasrc.get(key);
            obj[key - 1] = new Object[]{key - 1, row};
        }
    }

//    public static List<Delivery> getDeliveryData(String caseTypes) throws Exception {
//        List<Delivery> deliveryList = new ArrayList<>();
//        Delivery delivery = new Delivery();
//        COD cod = new COD();
//        List<Parcel> listParcel = new ArrayList<Parcel>();
//        Parcel parcel = new Parcel();
//        Sender sender = new Sender();
//        Receiver receiver = new Receiver();
//
//        if (obj == null || !Constants.DATA_FILEPATH.equalsIgnoreCase(currentDataFile)) {
//            prepareTestData(SerenityUtil.getIssue(), Constants.DATA_FILEPATH);
//        }
//
//        for (Object[] row : obj) {
//            String[] array = (String[]) row[1];
//            if (array[XlsDataUtil.toNumber(CASE_TYPES)].trim().equalsIgnoreCase(caseTypes)){
////            if (!array[0].equalsIgnoreCase(SerenityUtil.getIssue())) {
//                cod.setCodType(array[XlsDataUtil.toNumber(COD_TYPE)].trim())
//                        .setCodAmount(array[XlsDataUtil.toNumber(COD_AMOUNT)].trim());
//
//                sender.setName(array[XlsDataUtil.toNumber(SENDER_NAME)].trim())
//                        .setEmail(array[XlsDataUtil.toNumber(SENDER_EMAIL)].trim())
//                        .setCity(array[XlsDataUtil.toNumber(SENDER_CITY)].trim())
//                        .setPhone(array[XlsDataUtil.toNumber(SENDER_PHONE)].trim())
//                        .setStreet(array[XlsDataUtil.toNumber(SENDER_STREET)].trim())
//                        .setZip(array[XlsDataUtil.toNumber(SENDER_ZIPCODE)].trim())
//                        .setBuildingName(array[XlsDataUtil.toNumber(SENDER_BUILDING)].trim())
//                        .setUnitNo(array[XlsDataUtil.toNumber(SENDER_UNIT)].trim());
//
//                receiver.setName(array[XlsDataUtil.toNumber(RECEIVER_NAME)].trim())
//                        .setEmail(array[XlsDataUtil.toNumber(RECEIVER_EMAIL)].trim())
//                        .setCity(array[XlsDataUtil.toNumber(RECEIVER_CITY)].trim())
//                        .setPhone(array[XlsDataUtil.toNumber(RECEIVER_PHONE)].trim())
//                        .setStreet(array[XlsDataUtil.toNumber(RECEIVER_STREET)].trim())
//                        .setZip(array[XlsDataUtil.toNumber(RECEIVER_ZIPCODE)].trim())
//                        .setBuildingName(array[XlsDataUtil.toNumber(RECEIVER_BUILDING)].trim())
//                        .setUnitNo(array[XlsDataUtil.toNumber(RECEIVER_UNIT)].trim());
//
//                String[] strings = array[XlsDataUtil.toNumber(PARCEL)].trim().split("\\|");
//                parcel.setDeclaredLength(strings[0])
//                        .setDeclaredWidth(strings[1])
//                        .setDeclaredHeight(strings[2])
//                        .setDeclaredWeight(strings[3])
//                        .setDeclaredUnit(strings[4])
//                        .setDescription(strings[5]);
//                listParcel.add(parcel);
//
//                delivery.setNonPickup((array[XlsDataUtil.toNumber(IS_NONPICKUP)].trim().equalsIgnoreCase("TRUE") ? true : false));
//                delivery.setDropOffDateFollowSLA(array[XlsDataUtil.toNumber(IS_FOLLOW_SLA)].trim().equalsIgnoreCase("TRUE") ? true : false);
//
//                delivery.setOrderRef(array[XlsDataUtil.toNumber(ORDER_REF)].trim())
//                        .setServiceType(new ServiceType().setName(array[XlsDataUtil.toNumber(SERVICE_TYPE)].trim()))
//                        .setCod(cod)
//                        .setParcel(listParcel)
//                        .setSender(sender)
//                        .setReceiver(receiver);
//
//                deliveryList.add(delivery);
//            }
//        }
//        return deliveryList;
//    }
//
//
//
//    public static void createDomesticBlukUploadExchangeToCSVFile(List<DeliveryApi> deliveriesApi)  {
//        FileUtil.deleteFileExists(Constants.DBUEX_FILEPATH);
//        String outHeader = "Original Order No.,Order Reference No.,Shipment Weight (G),No. of Items,COD Collection";
//        BufferedWriter bw = null;
//
//        try{
//            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Constants.DBUEX_FILEPATH), "UTF-8"));
//
//            //Write header to CSV file
//            bw.append(outHeader);
//            //Add a new line separator after header
//            bw.append(NEW_LINE_SEPARATOR);
//
//            //Write deliveries data into CSV file
//            for(DeliveryApi delivery : deliveriesApi){
//                bw.append(delivery.getOriginalOrderNumber() == null ? "" : delivery.getOriginalOrderNumber());
//                bw.append(COMMA_DELIMITER);
//                //Write Order Ref
//                bw.append(delivery.getReferenceNumber() == null ? "" : delivery.getReferenceNumber());
//                bw.append(COMMA_DELIMITER);
//                //Write item Information
//                bw.append(delivery.getItemDetails().get(0).getWeight() == null ? "" : delivery.getItemDetails().get(0).getWeight());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getItemDetails().get(0).getQuantity() ==  null ? "" : delivery.getItemDetails().get(0).getQuantity());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getCod().getAmount() == null ? "" : delivery.getCod().getAmount());
//                bw.append(COMMA_DELIMITER);
//                bw.append(NEW_LINE_SEPARATOR);
//            }
//
//        }catch (Exception e){
//            System.out.println("Error in write to CSV file");
//            e.printStackTrace();
//        }finally {
//            try{
//                bw.flush();
//                bw.close();
//            }catch(IOException e){
//                System.out.println("Error while flushing/closing Writer!!!");
//            }
//        }
//
//    }
//
//    public static void createDomesticBlukUploadUSingleLocationToCSVFile(List<Delivery> deliveries)  {
//        FileUtil.deleteFileExists(Constants.DBUSL_FILEPATH);
//        String outHeader = "Service Type,Order Reference No.,Receiver Name,Contact Number,Email Address,Receiver Address,Postal Code,Shipment Weight (G)" +
//                ",No. of Items,Delivery Instructions,COD Collection";
//        BufferedWriter bw = null;
//
//        try{
//            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Constants.DBUSL_FILEPATH), "UTF-8"));
//
//            //Write header to CSV file
//            bw.append(outHeader);
//            //Add a new line separator after header
//            bw.append(NEW_LINE_SEPARATOR);
//
//            //Write deliveries data into CSV file
//            for(Delivery delivery : deliveries){
//                bw.append(delivery.getServiceType().getCode() == null ? "" : delivery.getServiceType().getCode());
//                bw.append(COMMA_DELIMITER);
//                //Write Order Ref
//                bw.append(delivery.getOrderRef() == null ? "" : delivery.getOrderRef());
//                bw.append(COMMA_DELIMITER);
//                //Write Receiver Information
//                bw.append(delivery.getReceiver().getName() == null ? "" : delivery.getReceiver().getName());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getReceiver().getPhone() ==  null ? "" : delivery.getReceiver().getPhone());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getReceiver().getEmail() == null ? "" : delivery.getReceiver().getEmail());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getReceiver().getStreet() == null ? "" : delivery.getReceiver().getStreet());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getReceiver().getZip() == null ? "" : delivery.getReceiver().getZip());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getParcels().get(0).getDeclaredWeight() == null ? "" : delivery.getParcels().get(0).getDeclaredWeight());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getQuantity() == null ? "" : delivery.getQuantity());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getReceiver().getDeliveryNote() == null ? "" : delivery.getReceiver().getDeliveryNote());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getCod().getCodAmount() == null ? "" : delivery.getCod().getCodAmount());
//                bw.append(COMMA_DELIMITER);
//                bw.append(NEW_LINE_SEPARATOR);
//            }
//
//        }catch (Exception e){
//            System.out.println("Error in write to CSV file");
//            e.printStackTrace();
//        }finally {
//            try{
//                bw.flush();
//                bw.close();
//            }catch(IOException e){
//                System.out.println("Error while flushing/closing Writer!!!");
//            }
//        }
//
//    }
//
//    public static void createDomesticBulkUploadMultipleLocationToCSVFile(List<Delivery> deliveries)  {
//        String randomNumber = getRandomNumber(1,10000);
//        FileUtil.deleteFileExists(Constants.DBUML_FILEPATH);
//
//        String outHeader = "Merchant code,Service Type,Order Reference No.,Receiver Name,Contact Number,Email Address,Receiver Address,Postal Code," +
//                "Shipment Weight (G),Shipment Volume (cm3),No. of Items,Custom Declared Currency,Custom Declared Value,Delivery Instructions,COD Collection,Pickup Name,Pickup Phone,Pickup Address," +
//                "Pickup Unit,Pickup Postcode,Pickup Date,Pickup Ready time,Pickup Close time";
//        BufferedWriter bw = null;
//
//        try{
//            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Constants.DBUML_FILEPATH), "UTF-8"));
//
//            //Write header to CSV file
//            bw.append(outHeader);
//            //Add a new line separator after header
//            bw.append(NEW_LINE_SEPARATOR);
//
//            //Write deliveries data into CSV file
//            for(Delivery delivery : deliveries){
//                //Write Merchant Code
//                bw.append(delivery.getMerchant().getCode() == null ? "" : delivery.getMerchant().getCode());
//                bw.append(COMMA_DELIMITER);
//                //Write Service Type
//                bw.append(delivery.getServiceType().getCode() == null ? "" : delivery.getServiceType().getCode());
//                bw.append(COMMA_DELIMITER);
//                //Write Order Ref
//                bw.append(delivery.getOrderRef() == null ? "" : delivery.getOrderRef());
//                bw.append(COMMA_DELIMITER);
//                //Write Receiver Information
//                bw.append(delivery.getReceiver().getName() == null ? "" : delivery.getReceiver().getName());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getReceiver().getPhone() ==  null ? "" : delivery.getReceiver().getPhone());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getReceiver().getEmail() == null ? "" : delivery.getReceiver().getEmail());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getReceiver().getStreet() == null ? "" : delivery.getReceiver().getStreet());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getReceiver().getZip() == null ? "" : delivery.getReceiver().getZip());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getParcels().get(0).getDeclaredWeight() == null ? "" : delivery.getParcels().get(0).getDeclaredWeight());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getParcels().get(0).getVolume() == null ? "" : delivery.getParcels().get(0).getVolume());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getQuantity() == null ? "" : delivery.getQuantity());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getValueCustoms().getCurrencyCode() == null ? "" : delivery.getValueCustoms().getCurrencyCode());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getValueCustoms().getAmount() == null ? "" : delivery.getValueCustoms().getAmount());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getReceiver().getDeliveryNote() == null ? "" : delivery.getReceiver().getDeliveryNote());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getCod().getCodAmount() == null ? "" : delivery.getCod().getCodAmount());
//                bw.append(COMMA_DELIMITER);
//                //Write Sender informaition
//                bw.append(delivery.getSender().getName() == null ? "" : delivery.getSender().getName());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getSender().getPhone() == null ? "" : delivery.getSender().getPhone());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getSender().getStreet() == null ? "" : delivery.getSender().getStreet());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getSender().getUnitNo() == null ? "" : delivery.getSender().getUnitNo() + randomNumber);
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getSender().getZip() == null ? "" : delivery.getSender().getZip());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getSender().getDate() == null ? "" : delivery.getSender().getDate().replace("/", "."));
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getSender().getPickupReadyTime() == null ? "" : delivery.getSender().getPickupReadyTime());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getSender().getPickupCloseTime() == null ? "" : delivery.getSender().getPickupCloseTime());
//                bw.append(COMMA_DELIMITER);
//                bw.append(NEW_LINE_SEPARATOR);
//            }
//
//        }catch (Exception e){
//            System.out.println("Error in write to CSV file");
//            e.printStackTrace();;
//        }finally {
//            try{
//                bw.flush();
//                bw.close();
//            }catch(IOException e){
//                System.out.println("Error while flushing/closing Writer!!!");
//            }
//        }
//
//    }
//
//    public static void createInternationalBulkUploadMultipleLocationToCSVFile(List<Delivery> deliveries)  {
//        String randomNumber = getRandomNumber(1,10000);
//        FileUtil.deleteFileExists(Constants.IBUML_FILEPATH);
//
//        String outHeader = "Merchant Code,Service Code,Order Reference No.,Receiver Name,Receiver Phone,Receiver Email,Receiver Address,Receiver City,Receiver State," +
//                "Receiver Country,Receiver Postcode,No. of Items,Shipment Weight (G),Shipment Length (cm),Shipment Width (cm)," +
//                "Shipment Height (cm),Description,Delivery Instructions,Custom Declared Value,Custom Declared Currency,Pickup Name," +
//                "Pickup Phone,Pickup Address,Pickup Unit No.,Pickup Postcode,Pickup Date,Pickup Ready Time,Pickup Close Time";
//        BufferedWriter bw = null;
//
//        try{
//            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Constants.IBUML_FILEPATH), "UTF-8"));
//
//            //Write header to CSV file
//            bw.append(outHeader);
//            //Add a new line separator after header
//            bw.append(NEW_LINE_SEPARATOR);
//
//            //Write deliveries data into CSV file
//            for(Delivery delivery : deliveries){
//                //Write Merchant Code
//                bw.append(delivery.getMerchant().getCode() == null ? "" : delivery.getMerchant().getCode());
//                bw.append(COMMA_DELIMITER);
//                //Write Service Type
//                bw.append(delivery.getServiceType().getCode() == null ? "" : delivery.getServiceType().getCode());
//                bw.append(COMMA_DELIMITER);
//                //Write Order Ref
//                bw.append(delivery.getOrderRef() == null ? "" : delivery.getOrderRef());
//                bw.append(COMMA_DELIMITER);
//                //Write Receiver Information
//                bw.append(delivery.getReceiver().getName() == null ? "" : delivery.getReceiver().getName());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getReceiver().getPhone() ==  null ? "" : delivery.getReceiver().getPhone());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getReceiver().getEmail() == null ? "" : delivery.getReceiver().getEmail());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getReceiver().getStreet() == null ? "" : delivery.getReceiver().getStreet());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getReceiver().getCity() == null ? "" : delivery.getReceiver().getCity());
//                bw.append(COMMA_DELIMITER);
//                //Write City for State
//                bw.append(delivery.getReceiver().getState() == null ? "" : delivery.getReceiver().getState());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getReceiver().getCountry() == null ? "" : delivery.getReceiver().getCountry());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getReceiver().getZip() == null ? "" : delivery.getReceiver().getZip());
//                bw.append(COMMA_DELIMITER);
//                //Write Parcel
//                bw.append(delivery.getQuantity() == null ? "" :  delivery.getQuantity());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getParcels().get(0).getDeclaredWeight() == null ? "" : delivery.getParcels().get(0).getDeclaredWeight());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getParcels().get(0).getDeclaredLength() == null ? "" : delivery.getParcels().get(0).getDeclaredLength());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getParcels().get(0).getDeclaredWidth() == null ? "" : delivery.getParcels().get(0).getDeclaredWidth());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getParcels().get(0).getDeclaredHeight() == null ? "" : delivery.getParcels().get(0).getDeclaredHeight());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getParcels().get(0).getDeclaredHeight() == null ? "" : delivery.getParcels().get(0).getDescription());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getReceiver().getDeliveryNote() == null ? "" : delivery.getReceiver().getDeliveryNote());
//                bw.append(COMMA_DELIMITER);
//                //Write currency
//                bw.append(delivery.getValueCustoms().getAmount() == null ? "" : delivery.getValueCustoms().getAmount());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getValueCustoms().getCurrencyCode() == null ? "" : delivery.getValueCustoms().getCurrencyCode());
//                bw.append(COMMA_DELIMITER);
//                //Write Sender informaition
//                bw.append(delivery.getSender().getName() == null ? "" : delivery.getSender().getName());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getSender().getPhone() == null ? "" : delivery.getSender().getPhone());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getSender().getStreet() == null ? "" : delivery.getSender().getStreet());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getSender().getUnitNo() == null ? "" : delivery.getSender().getUnitNo() + randomNumber);
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getSender().getZip() == null ? "" : delivery.getSender().getZip());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getSender().getDate() == null ? "" : delivery.getSender().getDate().replace("/", "."));
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getSender().getPickupReadyTime() == null ? "" : delivery.getSender().getPickupReadyTime());
//                bw.append(COMMA_DELIMITER);
//                bw.append(delivery.getSender().getPickupCloseTime() == null ? "" : delivery.getSender().getPickupCloseTime());
//                bw.append(COMMA_DELIMITER);
//                bw.append(NEW_LINE_SEPARATOR);
//            }
//
//        }catch (Exception e){
//            System.out.println("Error in write to CSV file");
//            e.printStackTrace();;
//        }finally {
//            try{
//                bw.flush();
//                bw.close();
//            }catch(IOException e){
//                System.out.println("Error while flushing/closing Writer!!!");
//            }
//        }
//
//    }

}