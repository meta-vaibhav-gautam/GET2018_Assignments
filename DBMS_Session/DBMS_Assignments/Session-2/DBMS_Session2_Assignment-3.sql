USE StoreFront;

# Query to get last 5 recent orders
SELECT o.ORDER_ID,u.User_Name as Placed_By,o.ORDER_DATE,o.ORDER_AMOUNT,o.Order_Status
FROM Orders o 
INNER JOIN User u ON o.User_Id = u.User_Id
ORDER BY ORDER_DATE DESC LIMIT 5;

# Query to get 5 Most expensive orders
SELECT o.ORDER_ID,u.User_Name as Placed_By,o.ORDER_DATE,o.ORDER_AMOUNT,o.Order_Status
FROM Orders o 
INNER JOIN User u ON o.User_Id = u.User_Id
ORDER BY ORDER_Amount DESC LIMIT 5;

# Query to get list of order which is placed 10 days before
SELECT o.Order_Id,o.Order_Date,o.Order_Amount
FROM Orders o
INNER JOIN Products_In_Order p
ON o.Order_Id = p.Order_Id
WHERE p.status LIKE "%placed%" AND DATEDIFF(NOW(),o.Order_Date) > 10;


# SQL Query to get list of shoppers who have not shopped from last 30 days
SELECT u.User_Name as Shopper,
IF(NULL,'NOT ORDERED YET',o.ORDER_DATE) as Last_Ordered
FROM Orders o 
RIGHT JOIN User u ON o.User_Id = u.User_Id
WHERE DATEDIFF(NOW(),o.Order_Date) > 30;

# SQL Query to find list of shopper and their order from last 15 day
SELECT u.User_Name as Shopper,o.Order_Id as Orders,o.ORDER_DATE as Order_Date
FROM Orders o 
INNER JOIN User u ON o.User_Id = u.User_Id
WHERE o.Order_Date between CURRENT_DATE - INTERVAL '15' DAY AND CURRENT_DATE;

# SQL Query to get products under shipped state in particular order
SELECT p.Product_Title,p.Product_Id,pc.Order_Id,pc.Status 
FROM Product p
RIGHT JOIN Products_IN_Order pc ON p.Product_Id=pc.Product_Id
WHERE pc.Status LIKE "%shipped%" AND pc.Order_Id=1103;

# SQL Query to get order items whose price is in between 500 to 1000 
SELECT p.Product_Id, p.Product_Title,p.Unit_Price,o.Order_Id,o.Order_Date 
FROM Product p
INNER JOIN Products_In_Order po
ON p.Product_Id = po.Product_Id
INNER JOIN Orders o
ON po.Order_Id = o.Order_Id
WHERE p.Unit_Price BETWEEN 500 AND 1000;

# SQL Query to update the status of products to shipped
UPDATE Products_In_Order
INNER JOIN Orders ON Products_In_Order.Order_ID=Orders.Order_ID
SET Products_In_Order.Status = 'Shipped'
WHERE Orders.Order_Date = '2018-08-03';

SELECT p.Product_Title,p.Product_Id,pc.Order_Id,pc.Status 
FROM Product p
RIGHT JOIN Products_IN_Order pc ON p.Product_Id=pc.Product_Id; 