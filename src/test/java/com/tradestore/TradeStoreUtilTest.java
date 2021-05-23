package com.tradestore;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TradeStoreUtilTest {

    TradeStoreUtil tst = new TradeStoreUtil();
    JSONArray tradeRecordsArray;
    JSONObject record1;
    JSONObject record2;
    JSONObject record3;
    JSONObject record4;
    JSONObject record5;

    HashMap<Integer, TradeStoreRecord> allRecords;

    @SuppressWarnings("unchecked")
    @Before
    public void setup() {
        tst = new TradeStoreUtil();
        allRecords = new HashMap<Integer, TradeStoreRecord>();
        record1 = new JSONObject();
        record1.put("TradeId", "T1");
        record1.put("Version", "1");
        record1.put("Counter-PartyId", "CP-1");
        record1.put("Book-Id", "B1");
        record1.put("MaturityDate", "05/23/2021");
        record1.put("CreatedDate", "05/22/2021");
        record1.put("Expired", "N");

        record2 = new JSONObject();
        record2.put("TradeId", "T2");
        record2.put("Version", "2");
        record2.put("Counter-PartyId", "CP-2");
        record2.put("Book-Id", "B2");
        record2.put("MaturityDate", "05/23/2020");
        record2.put("CreatedDate", "05/22/2021");
        record2.put("Expired", "N");

        record3 = new JSONObject();
        record3.put("TradeId", "T2");
        record3.put("Version", "2");
        record3.put("Counter-PartyId", "CP-2");
        record3.put("Book-Id", "B2");
        record3.put("MaturityDate", "05/23/2021");
        record3.put("CreatedDate", "05/22/2021");
        record3.put("Expired", "N");

        record4 = new JSONObject();
        record4.put("TradeId", "T2");
        record4.put("Version", "1");
        record4.put("Counter-PartyId", "CP-2");
        record4.put("Book-Id", "B2");
        record4.put("MaturityDate", "05/23/2021");
        record4.put("CreatedDate", "05/22/2021");
        record4.put("Expired", "N");

        record5 = new JSONObject();
        record5.put("TradeId", "T2");
        record5.put("Version", "2");
        record5.put("Counter-PartyId", "CP-2");
        record5.put("Book-Id", "B6");
        record5.put("MaturityDate", "05/23/2021");
        record5.put("CreatedDate", "05/22/2021");
        record5.put("Expired", "N");

    }

    @Test
    public void testParseEachRecord_ValidDataWithMaturityDateAsToday() {
        TradeStoreUtil tst = new TradeStoreUtil();
        tst.parseEachRecord(record1, allRecords);
        // assertTrue(true, allRecords.size() == 1);
        assertEquals(1, allRecords.size());
    }

    @Test
    public void testParseEachRecord_ValidDataWithMaturityDateAsBefore() {
        tst.parseEachRecord(record2, allRecords);
        System.out.println(allRecords.toString());
        assertEquals(0, allRecords.size());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testParseEachRecord_ValidDataWithLowerNumberVersion() {
        tradeRecordsArray = new JSONArray();
        tradeRecordsArray.add(record1); // version 1
        tradeRecordsArray.add(record3); // version 2
        tradeRecordsArray.add(record4); // version 1 -- This record will get rejected
        Iterator<JSONObject> iterator = tradeRecordsArray.iterator();
        while (iterator.hasNext()) {
            tst.parseEachRecord((JSONObject) iterator.next(), allRecords);
        }
        System.out.println(allRecords.toString());
        assertEquals(2, allRecords.size());

    }

    @SuppressWarnings("unchecked")
    @Test
    public void testParseEachRecord_ValidDataWithUpdateCurrentVersionWithSameVersionRecord() {
        tradeRecordsArray = new JSONArray();
        tradeRecordsArray.add(record1); // version 1
        tradeRecordsArray.add(record3); // version 2
        tradeRecordsArray.add(record5); // version 2 - This record will overwrite previous record with version 2
        Iterator<JSONObject> iterator = tradeRecordsArray.iterator();
        while (iterator.hasNext()) {
            tst.parseEachRecord((JSONObject) iterator.next(), allRecords);
        }
        System.out.println(allRecords.toString());
        assertEquals(2, allRecords.size());

    }

    @Test
    public void testReadFileAndReturnJsonObject_BlankFilePath() throws Exception {
        assertNull(tst.readFileAndReturnJsonObject(""));
    }

    @Test
    public void testReadFileAndReturnJsonObject_CorrectFilePath() {
        String testFileName = "./data.json";
        assertTrue(tst.readFileAndReturnJsonObject(testFileName) != null);
    }

    @Test
    public void testSaveTradesFromFile_EmptyFile() throws Exception {
        boolean recordsFoundFlag = tst.saveTradesFromFile("src/test/resources/emptyTestData.json");
        assertFalse(recordsFoundFlag);
    }

    @Test
    public void testSaveTradesFromFile_FileWithData() throws Exception {
        boolean recordsFoundFlag = tst.saveTradesFromFile("./data.json");
        assertTrue(recordsFoundFlag);
    }
}
