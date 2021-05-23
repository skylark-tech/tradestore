package com.tradestore;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * TradeStore single record Java bean class
 * 
 * @author Shipra
 *
 */

public class TradeStoreRecord implements Serializable {

  String tradeId;
  int version;
  String counterPartyId;
  String bookId;
  LocalDate maturityDate;
  LocalDate createdDate;
  char expired;

  /**
   * @return the tradeId
   */
  public String getTradeId() {
    return tradeId;
  }

  /**
   * @param tradeId the tradeId to set
   */
  public void setTradeId(String tradeId) {
    this.tradeId = tradeId;
  }

  /**
   * @return the version
   */
  public int getVersion() {
    return version;
  }

  /**
   * @param version the version to set
   */
  public void setVersion(int version) {
    this.version = version;
  }

  /**
   * @return the counterPartyId
   */
  public String getCounterPartyId() {
    return counterPartyId;
  }

  /**
   * @param counterPartyId the counterPartyId to set
   */
  public void setCounterPartyId(String counterPartyId) {
    this.counterPartyId = counterPartyId;
  }

  /**
   * @return the bookId
   */
  public String getBookId() {
    return bookId;
  }

  /**
   * @param bookId the bookId to set
   */
  public void setBookId(String bookId) {
    this.bookId = bookId;
  }

  /**
   * @return the maturityDate
   */
  public LocalDate getMaturityDate() {
    return maturityDate;
  }

  /**
   * @param maturityDate the maturityDate to set
   */
  public void setMaturityDate(LocalDate maturityDate) {
    this.maturityDate = maturityDate;
  }

  /**
   * @return the createdDate
   */
  public LocalDate getCreatedDate() {
    return createdDate;
  }

  /**
   * @param createdDate the createdDate to set
   */
  public void setCreatedDate(LocalDate createdDate) {
    this.createdDate = createdDate;
  }

  /**
   * @return the expired
   */
  public char getExpired() {
    return expired;
  }

  /**
   * @param expired the expired to set
   */
  public void setExpired(char expired) {
    this.expired = expired;
  }

  @Override
  public String toString() {
    return "TradeStoreRecord [bookId=" + bookId + ", counterPartyId=" + counterPartyId + ", createdDate=" + createdDate
        + ", expired=" + expired + ", maturityDate=" + maturityDate + ", tradeId=" + tradeId + ", version=" + version
        + "]";
  }

}
