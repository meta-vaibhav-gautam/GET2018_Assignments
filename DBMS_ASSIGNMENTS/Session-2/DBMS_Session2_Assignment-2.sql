USE StoreFront;
LOAD DATA INFILE 'C:/Users/User24/Desktop/DBMS_Assignments/Session-2/Data_Text_Files/Category_Data.txt' INTO TABLE Category FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Category_Name,Parent_Category);
LOAD DATA INFILE 'C:/Users/User24/Desktop/DBMS_Assignments/Session-2/Data_Text_Files/Product_Data.txt' INTO TABLE Product FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Product_Title,Product_Description,Unit_Price,Stock_Quantity);
LOAD DATA INFILE 'C:/Users/User24/Desktop/DBMS_Assignments/Session-2/Data_Text_Files/User_Data.txt' INTO TABLE User FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (User_Name,User_Mail,Birth_Date,Contact_no);
LOAD DATA INFILE 'C:/Users/User24/Desktop/DBMS_Assignments/Session-2/Data_Text_Files/Address_Data.txt' INTO TABLE Address FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (User_Id,Area,City,Zipcode,State,Country);
LOAD DATA INFILE 'C:/Users/User24/Desktop/DBMS_Assignments/Session-2/Data_Text_Files/Image_Data.txt' INTO TABLE Image FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Image_Id,Product_Id,Image_URL);
LOAD DATA INFILE 'C:/Users/User24/Desktop/DBMS_Assignments/Session-2/Data_Text_Files/Login_Data.txt' INTO TABLE Login FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (User_Id,Password,User_Role,Last_Login);
LOAD DATA INFILE 'C:/Users/User24/Desktop/DBMS_Assignments/Session-2/Data_Text_Files/Product_Category_Data.txt' INTO TABLE Product_Category FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Product_Id,Category_Id);
LOAD DATA INFILE 'C:/Users/User24/Desktop/DBMS_Assignments/Session-2/Data_Text_Files/Order_Data.txt' INTO TABLE Orders FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Order_Id,User_Id,Order_Date,Order_Amount,Shipping_Address,Order_Status);
LOAD DATA INFILE 'C:/Users/User24/Desktop/DBMS_Assignments/Session-2/Data_Text_Files/Products_In_Order_Data.txt' INTO TABLE Products_In_Order FIELDS TERMINATED BY '\t' LINES TERMINATED BY '\n' IGNORE 0 LINES (Order_Id,Product_Id,Quantity,status);

# Query to get list of products having no image 
SELECT Product_Id, Product_Title FROM Product WHERE Product_Id NOT IN (SELECT Product_Id FROM Image);

# Query to get all the category list in ascending order on the basis of category names
SELECT c.Category_Id,c.Category_Name,
IF (c.Parent_Category = 0,'Top Category',c1.Category_Name ) as Parent_Category
FROM Category c
LEFT JOIN Category c1
ON c.Parent_Category = c1.Category_Id ORDER BY Category_Name;

# Query to display all the leaf categories
SELECT c.Category_Id,c.Category_Name,c1.Category_Name as Parent_Category_Name
FROM Category c
LEFT JOIN Category c1
ON c.Parent_Category = c1.Category_Id
WHERE c1.Category_Id NOT IN (c.Category_Id);

# Query to have Products from mobile category
SELECT p.Product_Title,p.Unit_Price,p.Product_Description
FROM Product p
INNER JOIN Product_Category pc
ON (p.Product_Id = pc.Product_Id AND pc.Category_Id=13);

# Query to get list of products whose quantity < 50 
SELECT Product_Title,Product_Description,Unit_Price,Stock_Quantity FROM Product WHERE Stock_Quantity < 50;

# Query to increase all the product quantity by 100
SET SQL_SAFE_UPDATES=0;
UPDATE Product 
SET Stock_Quantity = Stock_Quantity+100;
SELECT Product_Title,Product_Description,Unit_Price,Stock_Quantity FROM Product;

