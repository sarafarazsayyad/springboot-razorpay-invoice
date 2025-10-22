package com.Payments.examples.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Payments.examples.entity.Invoicee;
import com.Payments.examples.repository.PaymentRepository;
import com.razorpay.Invoice;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/api/invoice")

public class PaymentController {

	
	 @Autowired
private	PaymentRepository paymentRepository;
	@PostMapping("/createInvoice")
	public String createInvoice(@RequestBody Map<String,Object> payload) throws RazorpayException{
		
		String name = (String) payload.get("name");
		String phone = (String) payload.get("phone");
		String email =(String) payload.get("email");
		String line1 =(String) payload.get("line1");
		String line2 = (String) payload.get("line2");
		String state = (String) payload.get("state");
		String city =(String) payload.get("city");
		String country = (String) payload.get("country");
		
		   long zipcode = Long.parseLong(payload.get("zipcode").toString());
		    long amount = Long.parseLong(payload.get("amount").toString());
		RazorpayClient razorpay =new RazorpayClient("key_id"`  
				,"key_secret");
		
		
		//  add Customer
		
		JSONObject customer = new JSONObject();
		customer.put("name",name);
		customer.put("phone", phone);
		customer.put("email", email);
		
		//shipping address
		
		JSONObject addressLine =new JSONObject();
		addressLine.put("line1", line1);
		addressLine.put("line2", line2);
		addressLine.put("city", city);
		addressLine.put("state", state);
		addressLine.put("zipcode", zipcode);
		addressLine.put("country", country);
		
		customer.put("addressline", addressLine);
		
		
		//add paisa
		
		List<Object> listItem =new ArrayList<>();
		JSONObject item = new JSONObject();
		item.put("name", "Purches Ites Name");
		item.put("description", "List of Items");
		item.put("amount", amount*100);
		item.put("quantity",1);
		item.put("currency", "INR");
		listItem.add(item);
		
		//create Invoice Request
		
		JSONObject invoiceRequest = new JSONObject();
		invoiceRequest.put("type", "invoice");
		invoiceRequest.put("currency","INR");
		invoiceRequest.put("customer", customer);
		invoiceRequest.put("line_items", listItem);
		invoiceRequest.put("sms_notify", true);
		invoiceRequest.put("email_notify", true);
		invoiceRequest.put("expire_by", System.currentTimeMillis() / 1000 + 864000);
		
		Invoice invoice = razorpay.invoices.create(invoiceRequest);
		
	
		 
		Invoicee in =new Invoicee();
		
		in.setName(name);
		in.setEmail(email);
		in.setPhone(phone);
		in.setLine1(line1);
		in.setLine2(line2);
		in.setCity(city);
		in.setState(state);
		in.setCountry(country);
		in.setStatus(state);
		in.setZipcode(zipcode);
		in.setAmount(amount);
		in.setStatus("padding");
		in.setRazorpayInvoiceId(invoice.get("id"));
		in.setInvoiceUrl(invoice.get("short_url"));
	     paymentRepository.save(in); 	  
		
		return invoice.toString(); 
	}
	
	
	
	
	@PostMapping("/webhook")
	public ResponseEntity<String> handleWebhook(@RequestBody Map<String, Object> payload) {
	    try {
	       
	        String event = (String) payload.get("event");
	        Map<String, Object> payloadData = (Map<String, Object>) payload.get("payload");
	        Map<String, Object> paymentData = (Map<String, Object>) payloadData.get("payment");
	        Map<String, Object> entity = (Map<String, Object>) paymentData.get("entity");

	        String invoiceId = (String) entity.get("invoice_id");
	        String status = (String) entity.get("status"); // captured, failed, etc.

	        System.out.println("Received webhook: " + event + ", Invoice ID: " + invoiceId + ", Status: " + status);

	        // ✅ Update in DB
	       paymentRepository.findAll().stream()
	                .filter(inv -> inv.getRazorpayInvoiceId().equals(invoiceId))
	                .findFirst()
	                .ifPresent(inv -> {
	                    inv.setStatus(status.toUpperCase());
	                    paymentRepository.save(inv);
	                });

	        return ResponseEntity.ok("Webhook received successfully");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error processing webhook");
	    }
	}

	
	
	
}
