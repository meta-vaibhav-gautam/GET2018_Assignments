USE StoreFront;
Show Tables;

# SQL Query to create a function to calculate number of orders in a month. Month and year will be input parameter to function.
DELIMITER $$
CREATE FUNCTION getNumberOfOrdersInMonth(month INT,Year INT) RETURNS INT
    DETERMINISTIC

BEGIN
    DECLARE numbeOfOrders INT;
    SET numbeOfOrders = (SELECT COUNT(Order_Id) FROM Orders WHERE Month(Order_Date)=month AND Year(Order_Date)=year);
    RETURN numbeOfOrders;
END $$

SELECT getNumberOfOrdersInMonth(08,2018);

#SQL Query to create a function to return month in a year having maximum orders. Year will be input parameter.
DELIMITER $$
CREATE FUNCTION getMonthWithMaximumOrder(inputYear INT) RETURNS INT
    DETERMINISTIC
    
BEGIN
    DECLARE month INT;
    SET month = ( SELECT Month(Order_Date) FROM Orders WHERE Year(Order_Date)=inputYear 
                GROUP BY Month(Order_date) DESC LIMIT 1);
                
    RETURN month;
END $$

SELECT getMonthWithMaximumOrder(2018);