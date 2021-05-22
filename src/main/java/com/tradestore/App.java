package com.tradestore;

/**
 * Hello Trade Store!
 */
public final class App {
  private App() {
  }

  static int lastVersion = 0;

  /**
   * Says hello to the trade store!.
   * 
   * @param args The arguments of the program.
   */
  public static void main(String[] args) {
    System.out.println("Welcome to the Trade Store! \n");

    TradeStoreUtil tradeStoreUtil = new TradeStoreUtil();
    tradeStoreUtil.saveTradesFromFile("./data.json");

  }

}
