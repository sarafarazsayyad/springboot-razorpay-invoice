# Spring Boot Razorpay Invoice Integration

This project is built using **Spring Boot** and **MySQL** to manage invoice creation and customer details.  It is designed to be extended in the future for **online payment integration** using **Razorpay REST APIs**.



## 🚀 Features
- Create Razorpay invoice with customer details
- Save invoice data and payment status to MySQL
- Supports Razorpay API integration

## 🛠️ Tech Stack
- Java 17
- Spring Boot
- MySQL
- Razorpay Java SDK

## 🔧 How to Run
1. Clone this repository  
2. Add your Razorpay `key_id` and `key_secret` in `application.properties`  
3. Run the project using `SpringBootApplication` main class  
4. Test using Postman:  
   **POST** `/api/payment/createInvoice`
URL: http://localhost:5050/api/payment/createInvoice

Method: POST

Authorization: Basic Auth → key_id / key_secret

Body → JSON


### Example JSON:
```json
{
  "name": "Sarfaraz sayyad ",
  "phone": "1231245430",
  "email": "xyz10@example.com",
  "line1": "123 Main Street",
  "line2": "Near Park",
  "zipcode": "400001",
  "city": "Mumbai",
  "state": "Maharashtra",
  "country": "India",
  "amount": 500
}





