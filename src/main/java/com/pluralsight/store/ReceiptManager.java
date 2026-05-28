package com.pluralsight.store;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptManager {

    private static final String RECEIPTS_FOLDER = "receipts";

    public ReceiptManager(){

        //creating a new folder named receipts if it does not already exist
        File receiptsFolder = new File(RECEIPTS_FOLDER);

        //creating a new folder named "receipts" if it does not already exist
        if (!receiptsFolder.exists()) {

            receiptsFolder.mkdirs();
        }
    }

    //saving the order as a receipt in the folder named "receipts"
    public void saveReceipt(Order order) {

        //writing the file name as "localdatetime.txt" in the folder named "receipts"
        //used File.seperator to make the code portable in case the code is run from a different system..
        String saveReceiptAs = RECEIPTS_FOLDER + File.separator + order.getReceiptSaveName();

        try (BufferedWriter filenameWriter = new BufferedWriter( new FileWriter(saveReceiptAs))){


            //writing the order details from Order class toString method to the file named
            // "receipts/localdatetime.txt"
            filenameWriter.write(order.toString());

            //confirming that the file creation was successful.
            System.out.println("Receipt saved: ");

        }
        catch (IOException e) {

            //letting you know that the receipt could not be saved because of some error.
            System.out.println("Error saving receipt : " + e.getMessage());
        }
    }

}
