# Currency Converter Application

This project is a Currency Converter Application that uses the [ExchangeRate API](https://exchangerate-api.com) to provide real-time currency conversion rates. The application allows users to enter an amount in one currency and get the equivalent amount in another currency using the latest exchange rates.

### Features
- Convert between various currencies using real-time data.
- User-friendly console-based interface.
- Input validation to ensure correct values.
- Supports all major global currencies.

### Technologies Used
- **Java**: The main programming language used to develop the application.
- **ExchangeRate API**: An external API used to fetch the latest exchange rates.

### Requirements
- **Java 8+**: Ensure that Java is installed on your system.
- **Internet Connection**: Required to fetch exchange rates from the API.

### Setup Instructions

1. **Clone the Repository**
   ```
   git clone https://github.com/your-username/Exchange_Convert.git
   cd Exchange_Convert
   ```

2. **Add API Key**
   - Sign up at [ExchangeRate API](https://exchangerate-api.com) to obtain your API key.
   - Add your API key in the application code at the specified placeholder (e.g., replace `API_KEY`).

### Usage
1. The program will prompt you to enter a source currency code (e.g., "USD").
2. Enter a target currency code (e.g., "EUR").
3. Input the amount you want to convert.
4. The application will then display the converted value based on the latest exchange rate.

### Example
```
Please enter your base currency code (ISO 4217) Ej. USD: 
mxn
Please enter the target currency code (ISO 4217) Ej. USD: 
usg
Error, enter a valid target currency code
Please enter the target currency code (ISO 4217) Ej. USD: 
usd
Please enter your quantity in MXN ty
Enter a valid quantity
Please enter your quantity in MXN 10

-------------------------------
Conversion rate: 1 MXN - 0.052 USD
Result: 0.517 USD
-------------------------------
```

### Error Handling
- **Invalid Currency Codes**: The application checks if the entered currency codes are valid.
- **Invalid Amount**: Input validation ensures that the amount is a positive integer or decimal value.

### Contributions
Contributions are welcome! Feel free to open issues or submit pull requests to improve the application.

### Contact
If you have any questions or suggestions regarding this project, please contact me at [franyutti62@outlook.com].
