package com.tradestore;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TradeStoreRecordTest {

    private TradeStoreRecord tradeStoreRecord;

    @Test
    public void testGetTradeId() {
        tradeStoreRecord = new TradeStoreRecord();
        String expectedTradeId = "S1";
        tradeStoreRecord.setTradeId(expectedTradeId);
        assertEquals(expectedTradeId, tradeStoreRecord.getTradeId());
    }

    @Test
    public void testSetTradeId() {
        tradeStoreRecord = new TradeStoreRecord();
        String expectedTradeId = "S2";
        tradeStoreRecord.setTradeId(expectedTradeId);
        assertEquals(expectedTradeId, tradeStoreRecord.getTradeId());
    }

    @Test
    public void testGetVersion() {
        tradeStoreRecord = new TradeStoreRecord();
        int expectedVersion = 1;
        tradeStoreRecord.setVersion(expectedVersion);
        assertEquals(expectedVersion, tradeStoreRecord.getVersion());
    }

    @Test
    public void testSetVersion() {
        tradeStoreRecord = new TradeStoreRecord();
        int expectedVersion = 2;
        tradeStoreRecord.setVersion(expectedVersion);
        assertEquals(expectedVersion, tradeStoreRecord.getVersion());
    }

    @Test
    public void testGetBookId() {
        tradeStoreRecord = new TradeStoreRecord();
        String expectedBookId = "B1";
        tradeStoreRecord.setBookId(expectedBookId);
        assertEquals(expectedBookId, tradeStoreRecord.getBookId());
    }

    @Test
    public void testSetBookId() {
        tradeStoreRecord = new TradeStoreRecord();
        String expectedBookId = "B2";
        tradeStoreRecord.setBookId(expectedBookId);
        assertEquals(expectedBookId, tradeStoreRecord.getBookId());
    }

    @Test
    public void testGetExpired() {
        tradeStoreRecord = new TradeStoreRecord();
        char expectedExpiredFlag = 'Y';
        tradeStoreRecord.setExpired(expectedExpiredFlag);
        assertEquals(expectedExpiredFlag, tradeStoreRecord.getExpired());
    }

    @Test
    public void testSetExpired() {
        tradeStoreRecord = new TradeStoreRecord();
        char expectedExpiredFlag = 'N';
        tradeStoreRecord.setExpired(expectedExpiredFlag);
        assertEquals(expectedExpiredFlag, tradeStoreRecord.getExpired());
    }

    @Test
    public void testGetMaturityDate() {
        tradeStoreRecord = new TradeStoreRecord();
        LocalDate expectedMaturityDate = LocalDate.now();
        tradeStoreRecord.setMaturityDate(expectedMaturityDate);
        assertEquals(expectedMaturityDate, tradeStoreRecord.getMaturityDate());
    }

    @Test
    public void testSetMaturityDate() {
        tradeStoreRecord = new TradeStoreRecord();
        LocalDate expectedMaturityDate = LocalDate.now();
        tradeStoreRecord.setMaturityDate(expectedMaturityDate);
        assertEquals(expectedMaturityDate, tradeStoreRecord.getMaturityDate());
    }

    @Test
    public void testGetCreatedDate() {
        tradeStoreRecord = new TradeStoreRecord();
        LocalDate expectedCreatedDate = LocalDate.now();
        tradeStoreRecord.setCreatedDate(expectedCreatedDate);
        assertEquals(expectedCreatedDate, tradeStoreRecord.getCreatedDate());
    }

    @Test
    public void testSetCreatedDate() {
        tradeStoreRecord = new TradeStoreRecord();
        LocalDate expectedCreatedDate = LocalDate.now();
        tradeStoreRecord.setCreatedDate(expectedCreatedDate);
        assertEquals(expectedCreatedDate, tradeStoreRecord.getCreatedDate());
    }

    @Test
    public void testGetCounterPartyId() {
        tradeStoreRecord = new TradeStoreRecord();
        String expectedounterPartyId = "CP-1";
        tradeStoreRecord.setCounterPartyId(expectedounterPartyId);
        assertEquals(expectedounterPartyId, tradeStoreRecord.getCounterPartyId());
    }

    @Test
    public void testSetCounterPartyId() {
        tradeStoreRecord = new TradeStoreRecord();
        String expectedounterPartyId = "CP-2";
        tradeStoreRecord.setCounterPartyId(expectedounterPartyId);
        assertEquals(expectedounterPartyId, tradeStoreRecord.getCounterPartyId());
    }
}
