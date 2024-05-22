# Transaction Manager (Kotlin)

Welcome to the Transaction Manager, a Kotlin application designed to help you manage your expenses and incomes efficiently. This application utilizes Room as a local database for storing transaction data and fetches data from a custom API (implemented with JSONPlaceholder) when the database is empty.

## Features

### Transaction Recording

The Transaction Manager allows users to record their financial transactions seamlessly. Users can input transaction details such as date, type (expense or income), and amount.

### Local Database with Room

Transaction data is stored locally using Room, a SQLite database library for Android. This ensures data persistence and allows for efficient querying and manipulation of transaction data.

### Custom API Integration

In cases where the local database is empty, the Transaction Manager fetches transaction data from a custom API implemented using JSONPlaceholder. This ensures that users always have access to transaction data, even when the local database is not populated.

## Installation

1. Clone this repository to your local machine.
2. Open the project in your preferred Kotlin development environment.
3. Run the application on an emulator or physical device to start managing your transactions efficiently.

