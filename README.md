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

🧰 Step 2: Start Your Spring Boot Application

Your webhook endpoint will now be live at:
👉 http://localhost:5050/api/payment/webhook

Make sure your server is running when testing!

🧪 Step 3: Test Webhook Using Postman

You can simulate Razorpay webhook like this:

✅ Postman Request:

Method: POST

URL: http://localhost:5050/api/payment/webhook

Headers:

Content-Type: application/json


Body → raw → JSON:

{
  "event": "payment.captured",
  "payload": {
    "payment": {
      "entity": {
        "invoice_id": "inv_Nabcd1234",
        "status": "captured"
      }
    }
  }
}

✅ Expected Result:

If your invoice with ID inv_Nabcd1234 exists in DB,
→ status column updates from PENDING → CAPTURED.

🧰 Step 4: Test Payment Failure

In Postman, send another JSON to test failure:

{
  "event": "payment.failed",
  "payload": {
    "payment": {
      "entity": {
        "invoice_id": "inv_Nabcd1234",
        "status": "failed"
      }
    }
  }
}


🧰 Step 2: Start Your Spring Boot Application

Your webhook endpoint will now be live at:
👉 http://localhost:5050/api/payment/webhook

Make sure your server is running when testing!

🧪 Step 3: Test Webhook Using Postman

You can simulate Razorpay webhook like this:

✅ Postman Request:

Method: POST

URL: http://localhost:5050/api/payment/webhook

Headers:

Content-Type: application/json


Body → raw → JSON:

{
  "event": "payment.captured",
  "payload": {
    "payment": {
      "entity": {
        "invoice_id": "inv_Nabcd1234",
        "status": "captured"
      }
    }
  }
}

✅ Expected Result:

If your invoice with ID inv_Nabcd1234 exists in DB,
→ status column updates from PENDING → CAPTURED.

🧰 Step 4: Test Payment Failure

In Postman, send another JSON to test failure:

{
  "event": "payment.failed",
  "payload": {
    "payment": {
      "entity": {
        "invoice_id": "inv_Nabcd1234",
        "status": "failed"
      }
    }
  }
}


🧰 Step 2: Start Your Spring Boot Application

Your webhook endpoint will now be live at:
👉 http://localhost:5050/api/payment/webhook

Make sure your server is running when testing!

🧪 Step 3: Test Webhook Using Postman

You can simulate Razorpay webhook like this:

✅ Postman Request:

Method: POST

URL: http://localhost:5050/api/payment/webhook

Headers:

Content-Type: application/json


Body → raw → JSON:

{
  "event": "payment.captured",
  "payload": {
    "payment": {
      "entity": {
        "invoice_id": "inv_Nabcd1234",
        "status": "captured"
      }
    }
  }
}

✅ Expected Result:

If your invoice with ID inv_Nabcd1234 exists in DB,
→ status column updates from PENDING → CAPTURED.

🧰 Step 4: Test Payment Failure

In Postman, send another JSON to test failure:

{
  "event": "payment.failed",
  "payload": {
    "payment": {
      "entity": {
        "invoice_id": "inv_Nabcd1234",
        "status": "failed"
      }
    }
  }
}
🧰 Step 2: Start Your Spring Boot Application

Your webhook endpoint will now be live at:
👉 http://localhost:5050/api/payment/webhook

Make sure your server is running when testing!

🧪 Step 3: Test Webhook Using Postman

You can simulate Razorpay webhook like this:

✅ Postman Request:

Method: POST

URL: http://localhost:5050/api/payment/webhook

Headers:

Content-Type: application/json


Body → raw → JSON:

{
  "event": "payment.captured",
  "payload": {
    "payment": {
      "entity": {
        "invoice_id": "inv_Nabcd1234",
        "status": "captured"
      }
    }
  }
}

✅ Expected Result:

If your invoice with ID inv_Nabcd1234 exists in DB,
→ status column updates from PENDING → CAPTURED.

🧰 Step 4: Test Payment Failure

In Postman, send another JSON to test failure:

{
  "event": "payment.failed",
  "payload": {
    "payment": {
      "entity": {
        "invoice_id": "inv_Nabcd1234",
        "status": "failed"
      }
    }
  }
}


🧰 Step 2: Start Your Spring Boot Application

Your webhook endpoint will now be live at:
👉 http://localhost:5050/api/payment/webhook

Make sure your server is running when testing!

🧪 Step 3: Test Webhook Using Postman

You can simulate Razorpay webhook like this:

✅ Postman Request:

Method: POST

URL: http://localhost:5050/api/payment/webhook

Headers:

Content-Type: application/json


Body → raw → JSON:

{
  "event": "payment.captured",
  "payload": {
    "payment": {
      "entity": {
        "invoice_id": "inv_Nabcd1234",
        "status": "captured"
      }
    }
  }
}

✅ Expected Result:

If your invoice with ID inv_Nabcd1234 exists in DB,
→ status column updates from PENDING → CAPTURED.

🧰 Step 4: Test Payment Failure

In Postman, send another JSON to test failure:

{
  "event": "payment.failed",
  "payload": {
    "payment": {
      "entity": {
        "invoice_id": "inv_Nabcd1234",
        "status": "failed"
      }
    }
  }
}


🧰 Step 5: Start Your Spring Boot Application

Your webhook endpoint will now be live at:
👉 http://localhost:5050/api/payment/webhook

Make sure your server is running when testing!


🧪 Step 6: Test Webhook Using Postman

You can simulate Razorpay webhook like this:

✅ Postman Request:

Method: POST

URL: http://localhost:5050/api/payment/webhook

Headers:
           Content-Type: application/json


Body → raw → JSON:

{
  "event": "payment.captured",
  "payload": {
    "payment": {
      "entity": {
        "invoice_id": "inv_Nabcd1234",
        "status": "captured"
      }
    }
  }
}


✅ Expected Result:

If your invoice with ID inv_Nabcd1234 exists in DB,
→ status column updates from PENDING → CAPTURED.





🧰 Step 7: Test Payment Failure

In Postman, send another JSON to test failure:



{
  "event": "payment.failed",
  "payload": {
    "payment": {
      "entity": {
        "invoice_id": "inv_Nabcd1234",
        "status": "failed"
      }
    }
  }
}



✅ Now status should change to
