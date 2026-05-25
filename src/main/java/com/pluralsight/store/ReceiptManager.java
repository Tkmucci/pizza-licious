package com.pluralsight.store;

import java.io.File;

public class ReceiptManager {

    private static final String RECEIPTS_FOLDER = "receipts";

    public ReceiptManager(){

        //creating a new folder named receipts if it does not already exist
        File receiptsFolder = new File("receipts");

        if (!receiptsFolder.exists()) {

            receiptsFolder.mkdirs();
        }
    }

}
