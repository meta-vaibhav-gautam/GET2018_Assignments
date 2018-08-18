USE StoreFront;

# SQL Query to retreive list of products which falls in more than one category
SELECT p.Product_Id,p.Product_Title, COUNT(p.Product_Title) as Number_Of_Category
FROM Product p
RIGHT JOIN Product_Category pc ON pc.Product_Id=p.Product_Id
GROUP BY Product_Id HAVING COUNT(p.Product_Title)>1;

# SQL Query to display Count of products as per range.
SELECT Range_In_Rs, COUNT(Product_Id) AS Count FROM
   (SELECT Product_Id,
   case when Unit_Price between 500 and 1000 then '500-1000'
        when Unit_Price between 1000 and 2000 then '1000-2000'
        when Unit_Price > 2000 then 'Above 2000'
   end AS Range_In_Rs
   FROM Product)as temporary_table
   GROUP BY Range_In_Rs;

# SQL Query to display Number of Products in each category
SELECT c.Category_Id,c.Category_Name,COUNT(pc.Product_Id) as Number_Of_Products
FROM Category c
LEFT JOIN
Product_Category pc
ON c.category_Id = pc.Category_Id
GROUP BY (c.Category_Name) HAVING COUNT(pc.Product_Id)>=0;
