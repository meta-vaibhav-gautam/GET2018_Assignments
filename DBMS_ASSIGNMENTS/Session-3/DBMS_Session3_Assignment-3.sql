USE StoreFront;
SHOW Tables;

# SQL Query to display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT u.User_Id,u.User_Name,u.User_Mail,u.Birth_Date,u.Contact_No,o.Order_Date,COUNT(o.Order_Id) as Number_Of_Orders
FROM User u
LEFT JOIN
Orders o
ON u.User_Id = o.User_Id
WHERE (DATEDIFF(NOW(),o.Order_Date) < 30)
GROUP BY u.User_Id HAVING ((COUNT(o.Order_Id)>=0));

# SQL Query to display the top 3 Shoppers who generated maximum number of revenue in last 30 days.
SELECT u.User_Id,u.User_Name,SUM(o.Order_Amount) as Total_Order_Amount
FROM User u
LEFT JOIN
Orders o
ON u.User_Id = o.User_Id
WHERE (DATEDIFF(NOW(),o.Order_Date) < 30)
GROUP BY u.User_Id 
ORDER BY Total_Order_Amount DESC LIMIT 3;

# SQL Query to display top Products which are ordered most in last 10 days along with numbers.
SELECT po.Product_Id, SUM(po.Quantity) as Total_Units
FROM Orders o
INNER JOIN 
Products_In_Order po
ON o.Order_Id = po.Order_Id
WHERE (DATEDIFF(NOW(),o.Order_Date) < 10)
GROUP BY po.Product_Id 
ORDER BY Total_Units DESC;

# SQL Query to display Monthly sales revenue of the StoreFront for last 3 months. It should display each month’s sale.
SELECT Month,SUM(Order_Amount) AS Sales_Revenue FROM
    (SELECT Order_Amount,
    CASE WHEN DATEDIFF(NOW(),Order_Date)  BETWEEN 1 AND 30 then 'last 1 month' 
        WHEN DATEDIFF(NOW(),Order_Date)  BETWEEN 30 AND 60 then 'last 2 month'
        WHEN DATEDIFF(NOW(),Order_Date)  BETWEEN 60 AND 90 then 'last 3 month'
    end AS Month
FROM Orders WHERE DATEDIFF(NOW(),Order_Date) <=90 )as temporary_table
GROUP BY Month;

# SQL Query to mark the products as Inactive which are not ordered in last 90 days
ALTER TABLE Product
ADD Product_Status VARCHAR(10) DEFAULT 'ACTIVE';

SET SQL_SAFE_UPDATES = 0;
UPDATE Product 
SET Product_Status = "INACTIVE"
WHERE Product_Id NOT IN(
SELECT po.Product_Id FROM Orders o
INNER JOIN Products_In_Order po
ON o.Order_Id = po.Order_Id
WHERE DATEDIFF(NOW(),o.Order_Date) BETWEEN 1 AND 90); 

SELECT * FROM Product;

# SQL Query for given a category search keyword, display all the Products present in this category/categories. 

DELIMITER //
CREATE PROCEDURE get_tr(IN Category_Name VARCHAR(30))
 BEGIN
 DECLARE id int;
 DECLARE Parent_id int;
 
 SELECT Category_Id into id 
 FROM Category WHERE Category_Name = Category_Name;
 
 SELECT Parent_Category into Parent_id 
 FROM Category WHERE Category_id = id;
 
 create TEMPORARY  table IF NOT EXISTS temp_table as (select Product_Id from Product_Category where 1=0);
 truncate table temp_table;
 

 WHILE Parent_id <> 0 DO
   insert into temp_table select Product_Id from Product_Category WHERE Category_Id=Parent_id;
   
   SELECT Parent_Category into Parent_id 
   FROM Category WHERE Category_id = id;
 
   SET Parent = child_id;
   SET child_id=0;
   SELECT Parent_Category into child_id
   FROM Category WHERE Category_Id=prev_id;
 END WHILE;
 END //
DELIMITER ; 
 CALL get_tr(5);
 select * from temp_table; 

# SQL Query to display top 10 Items which were cancelled most.
INSERT INTO Products_In_Order(Order_Id,Product_Id,Quantity,Status) values
    ('1102','2','1','cancelled'),
    ('1103','2','2','cancelled'),
    ('1104','3','1','cancelled'),
    ('1105','2','1','cancelled'),
    ('1106','4','1','cancelled'),
    ('1103','5','1','cancelled'),
    ('1102','1','1','cancelled'),
    ('1101','2','1','cancelled');
    
SELECT p.Product_Id,p.Product_Title,COUNT(po.Product_Id) AS Status_Count_Cancelled
FROM Products_In_Order po
LEFT JOIN Product p
ON po.Product_Id = p.Product_Id
WHERE po.Status LIKE "%cancelled%" 
GROUP BY(po.Product_Id)
ORDER BY Status_Count_Cancelled DESC LIMIT 3;


