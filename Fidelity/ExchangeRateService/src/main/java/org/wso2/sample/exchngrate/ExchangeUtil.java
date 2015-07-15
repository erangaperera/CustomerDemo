package org.wso2.sample.exchngrate;

import java.util.HashMap;

public class ExchangeUtil {

	private static HashMap<String, Double> currencyExchangeMap = new HashMap<String, Double>();
	private static ExchangeUtil exchangeUtil;
	
	public static ExchangeUtil getInstance(){
		if (exchangeUtil == null){
			exchangeUtil = new ExchangeUtil();
		}
		return exchangeUtil;
	}

	public double getExchangeRate(String fromCurrency, String toCurrency) {

		String exchKey = fromCurrency + "|" + toCurrency;
		Double lastval = currencyExchangeMap.get(exchKey);
		double newrate = (lastval == null) ? getRandom(1, 0.01) : getRandom(lastval.doubleValue(), 0.01);
		currencyExchangeMap.put(exchKey, newrate);
		return newrate;
	}
	
	public double setExchangeRate(String fromCurrency, String toCurrency, double exchangeRate){
		String exchKey = fromCurrency + "|" + toCurrency;
		currencyExchangeMap.put(exchKey, exchangeRate);
		return exchangeRate;
	}

	private static double getRandom(double base, double varience) {
		double rand = Math.random() - 0.5D;
		return (base + (varience * base * rand));
	}

}