package com.agl.bixi.rest;

import java.util.Random;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agl.bixi.model.CheckSumModel;
import com.paytm.pg.merchant.CheckSumServiceHelper;

/**
 * @author agl
 *
 */
@RestController
@RequestMapping("/checkSum")

public class CheckSum {

	// The following variable will be moved into property files eventually.
	private static String MID = "abcpvt00402568237238";
	private static String MercahntKey = "&6VL65cI2HEndCxL";
	private static String INDUSTRY_TYPE_ID = "Retail";
	private static String CHANNLE_ID = "WAP";
	private static String WEBSITE = "http://localhost.com";
	private static String CALLBACK_URL = "https://pguat.paytm.com/paytmchecksum/paytmCallback.jsp";
	private static String CUST_ID = "sathiya.reach@gmail.com";

	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value = "/generate", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<CheckSumModel> generate() {

		String orderID = generateOrderId();
		
		TreeMap<String, String> paramMap = new TreeMap<String, String>();
		paramMap.put("MID", MID);
		paramMap.put("ORDER_ID", generateOrderId());
		paramMap.put("CUST_ID", CUST_ID);
		paramMap.put("INDUSTRY_TYPE_ID", INDUSTRY_TYPE_ID);
		paramMap.put("CHANNEL_ID", CHANNLE_ID);
		paramMap.put("TXN_AMOUNT", "1.00");
		paramMap.put("WEBSITE", WEBSITE);
		paramMap.put("EMAIL", "test@gmail.com");
		paramMap.put("MOBILE_NO", "7777777777");
		paramMap.put("CALLBACK_URL", CALLBACK_URL);
		CheckSumModel checksum = new CheckSumModel();

		try {
			String checkSum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(MercahntKey, paramMap);
			// paramMap.put("CHECKSUMHASH" , checkSum);
			checksum.setCheckSumHash(checkSum);
			checksum.setCustomerId(CUST_ID);
			checksum.setOrderID(orderID);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<CheckSumModel>(checksum, HttpStatus.OK);
	}

	private String generateOrderId() {

		Random rand = new Random();

		long l = rand.nextLong();
		String orderId = "ORD" + l;

		return orderId;
	}
}
