# 🏨 Hotel Reservation System

A Java-based console application for managing hotel reservations, room availability, customer details, payments, feedback, complaints, and hotel analytics.

## 📌 Project Description

The Hotel Reservation System is a command-line application developed using Java. It allows users to browse hotels, check room availability, book rooms, make payments, view bookings, submit feedback, and raise complaints.

The system also provides an admin dashboard and analytics reports for monitoring hotel bookings and room occupancy.

## ✨ Features

- 🏨 View available hotels
- 🛏️ View rooms and room availability
- 📅 Book hotel rooms
- 👤 Manage customer details
- 💳 UPI and Card payment processing
- 🧾 Generate booking receipts
- 📋 View all bookings
- ⭐ Submit and view customer feedback
- 📢 Submit and manage complaints
- 📊 Admin dashboard
- 📈 Hotel analytics report
- 🧹 Room cleaning simulation
- 💾 Store booking and feedback data in text files
- 🧵 Multithreading for welcome message and room cleaning
- ⚠️ Exception handling for invalid operations

## 🛠️ Technologies Used

- Java
- Object-Oriented Programming
- Java Collections
- File I/O
- Exception Handling
- Interfaces
- Polymorphism
- Multithreading

## 📂 Project Structure

```text
hotelreserve/
│
├── hotel/
│   ├── MainApp.java
│   ├── HotelManager.java
│   ├── Hotel.java
│   ├── Room.java
│   ├── Customer.java
│   ├── Booking.java
│   ├── Feedback.java
│   ├── Receipt.java
│   │
│   ├── admin/
│   │   └── AdminDashboard.java
│   │
│   ├── analytics/
│   │   └── AnalyticsEngine.java
│   │
│   ├── io/
│   │   └── BookingWriter.java
│   │
│   ├── payment/
│   │   ├── PaymentProcessor.java
│   │   ├── UpiPayment.java
│   │   └── CardPayment.java
│   │
│   ├── threading/
│   │   ├── WelcomeThread.java
│   │   └── RoomCleanerThread.java
│   │
│   ├── util/
│   │   └── Validator.java
│   │
│   ├── exceptions/
│   │   ├── HotelException.java
│   │   ├── RoomUnavailableException.java
│   │   └── InvalidPaymentException.java
│   │
│   └── complaint/
│       └── ComplaintManager.java
│
├── bookings.txt
├── feedbacks.txt
└── README.md
