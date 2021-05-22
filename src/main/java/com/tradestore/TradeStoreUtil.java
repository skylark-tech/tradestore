package com.tradestore;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Utility File for all the functions for reading, parsing and storing trades
 */
public class TradeStoreUtil {
    int lastVersion = 0;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    JSONParser parser = new JSONParser();

    /**
     * 
     * @param fileName - Entire path and the filename of the json file that needs to
     *                 be read
     * @return
     */
    public Object readFileAndReturnJsonObject(String fileName) {
        try {
            return parser.parse(new FileReader(fileName));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * description - This function reads a json file, parses the response and stores
     * it Hashmap
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    public void saveTradesFromFile(String fileName) {
        Object tradeRecordsData = readFileAndReturnJsonObject(fileName); // Read file, if exception, nothing happens

        if (tradeRecordsData != null) {

            JSONObject jsonObject = (JSONObject) tradeRecordsData;
            JSONArray tradeRecords = (JSONArray) jsonObject.get("tradeRecords");

            HashMap<Integer, TradeStoreRecord> allRecords = new HashMap<Integer, TradeStoreRecord>();

            @SuppressWarnings("unchecked")
            Iterator<JSONObject> iterator = tradeRecords.iterator();

            while (iterator.hasNext()) {
                JSONObject record = (JSONObject) iterator.next();
                parseEachRecord(record, allRecords);
            }

            if (!allRecords.isEmpty()) {
                displayTradeStoreRecords(allRecords);
            } else {
                System.out.println("No trades to display currently.");
            }
        }

    }

    /**
     * description - This function reads each record, validates against lower
     * version number and outdated maturity date and adds to Hashmap
     *
     * @param record     {JSONObject} - Each trade store record
     * @param allRecords {HashMap<Integer, TradeStoreRecord>} - Hashmap to store all
     *                   the valid trades
     */
    public void parseEachRecord(JSONObject record, HashMap<Integer, TradeStoreRecord> allRecords) {
        int currentVersion = record.get("Version") != null ? Integer.parseInt(record.get("Version").toString()) : -1;

        LocalDate todayDate = LocalDate.now();
        LocalDate maturityDate = LocalDate.parse(record.get("MaturityDate").toString(), dtf);
        LocalDate createdDate = LocalDate.parse(record.get("CreatedDate").toString(), dtf);

        // Validation criterias:
        // #1 Only add higher version record or update current version record; #2 Reject
        // record if maturity date is before currentDate
        if (currentVersion != -1 && (lastVersion < currentVersion || lastVersion == currentVersion)
                && !maturityDate.isBefore(todayDate)) {
            lastVersion = currentVersion;

            // #3 Update expired flag to Y if maturityDate is today. Anything before today's
            // date will get rejected as per #2
            char expiredFlag = maturityDate.isEqual(todayDate) ? 'Y' : record.get("Expired").toString().charAt(0);

            String tradeId = record.get("TradeId") != null ? record.get("TradeId").toString() : "";
            String counterPartyId = record.get("Counter-PartyId") != null ? record.get("Counter-PartyId").toString()
                    : "";
            String bookId = record.get("Book-Id") != null ? record.get("Book-Id").toString() : "";

            TradeStoreRecord tradeStoreRecord = new TradeStoreRecord(tradeId, currentVersion, counterPartyId, bookId,
                    maturityDate, createdDate, expiredFlag);
            allRecords.put(currentVersion, tradeStoreRecord);
        } else {
            System.out.println("Record: " + record.toJSONString() + "cannot be added.");
        }

    }

    /**
     * description - This function displays all the valid trades
     *
     * @param allRecords
     */
    public void displayTradeStoreRecords(HashMap<Integer, TradeStoreRecord> allRecords) {
        System.out.println("The current records in Trade Store are: \n");

        for (TradeStoreRecord record : allRecords.values()) {
            System.out.println(record.toString());
        }
    }
}
