package org.wso2.sample.exchngrate;

import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "ExchangeRate")
public class ExchangeRate{

	/** This is a sample web service operation */
	@WebMethod(operationName = "getEchangeRate")
	@WebResult(name = "ExchangeRate")
	public double getEchangeRate(@WebParam(name = "FromCurrency") String fromCurrency, 
			                     @WebParam(name = "ToCurrency") String toCurrency) {
		return ExchangeUtil.getInstance().getExchangeRate(fromCurrency, toCurrency);
	}
	
	@WebMethod(operationName = "setEchangeRate")
	@WebResult(name = "status")
	public String setEchangeRate(@WebParam(name = "FromCurrency") String fromCurrency, 
            					 @WebParam(name = "ToCurrency") String toCurrency,
            					 @WebParam(name = "ExchangeRate") Double rate) {
		ExchangeUtil.getInstance().setExchangeRate(fromCurrency, toCurrency, rate);
		return "Updated Succesfuly";
	}


}