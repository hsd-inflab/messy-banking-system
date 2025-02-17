# Requirements for extendind and improving

- **Add Transaction History**:
   - Store each transaction (deposit, withdrawal) in the `Account` class.
   - Display the transaction history when showing account details.

- **Improve Error Handling**:
   - Handle invalid input gracefully (e.g., non-numeric account numbers or amounts).
   - Provide meaningful error messages for invalid commands.

- **Refactor Code**:
   - Separate the `Account` class from the repository logic.
   - Make the repository exchangeable (e.g., use an interface for account storage).

- **Add Unit Tests**:
   - Write unit tests
   - Test application logic without UI
   - Ensure that all functionalities (deposit, withdrawal, show) are covered by tests.

- **Introduce Instant Payment**:
   - Add a flag in the `Account` class to specify whether an account supports instant payment.
   - Update the `Bank.updateAccount` method to consider the payment method.

- **Enhance CLI**:
   - Add more commands (e.g., transfer between accounts, list all accounts).
   - Improve the user interface with clearer prompts and feedback.

- **Persist Data**:
   - Implement data persistence to save and load account information from a file or database.

- **Security Improvements**:
   - Add basic authentication for accessing the banking system.
   - Ensure sensitive information (e.g., account balances) is not exposed unnecessarily.

- **Code Cleanup**:
   - Fix any code smells or messy code identified in the current implementation.
   - Ensure the code follows best practices and is well-documented.

- **User Interface**:
    - Create a graphical user interface (GUI) for the banking application using a library like JavaFX.
