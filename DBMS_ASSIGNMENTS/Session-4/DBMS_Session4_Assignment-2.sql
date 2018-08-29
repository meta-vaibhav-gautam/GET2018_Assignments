USE StoreFront;

#SQL Query to create a Stored procedure to retrieve average sales of each product in a month.
DELIMITER $$
CREATE PROCEDURE getAverageSale (IN month INT,IN year INT)

BEGIN
    SELECT Products_In_Order.Product_Id,Product.Product_Title,SUM(Products_In_Order.Quantity) AS AVERAGE
    FROM Products_In_Order 
    LEFT JOIN Product ON Products_In_Order.Product_Id=Product.Product_Id
    INNER JOIN Orders ON Orders.Order_Id = Products_In_Order.Order_Id
    WHERE Year(Orders.Order_Date)=year AND Month(Orders.Order_Date)=month
    GROUP BY Products_In_order.Product_Id;
END $$

CALL getAverageSale(08,2018);

#SQL query to create a stored procedure to retrieve table having order detail with status for a given period.
DELIMITER $$
CREATE PROCEDURE getOrderDetails(IN initialDate DATE,IN finalDate DATE)

BEGIN
    SET initialDate = IF(initialDate < finalDate, initialDate, finalDate-INTERVAL DAY(finalDate)-1 DAY);
    
    SELECT Order_Id,User_Id,Order_Date,Order_Amount,Shipping_Address,Order_Status FROM Orders
    WHERE Order_Date 
    BETWEEN initialDate AND finalDate;
END $$

CALL getOrderDetails('2018-08-02','2018-08-17');

