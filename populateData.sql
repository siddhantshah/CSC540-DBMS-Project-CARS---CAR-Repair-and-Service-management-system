INSERT INTO ServiceCenter(serviceCenterId,name,address,phoneNumber) VALUES(1,'Downtown Auto Care','437 Fayetteville St., Raleigh, NC 27601','1.800.899.9999');
INSERT INTO ServiceCenter(serviceCenterId,name,address,phoneNumber) VALUES(2,'Express Auto Shop','201 N Tryon St, Charlotte, NC 28202','1.704.333.1555');

INSERT INTO Distributor(distributorId) VALUES(1001);
INSERT INTO Distributor(distributorId) VALUES(1002);

INSERT INTO Employee(employeeId,name,phoneNumber,address,email,startDate,loginId) VALUES(950932130,'Larry Cohen','316-978-5494','1979 Henry Street, Raleigh, NC 27606','lacohen@acme.com','2016-08-15','lacohen@acme.com');
INSERT INTO Employee(employeeId,name,phoneNumber,address,email,startDate,loginId) VALUES(634622236,'Willis Martin','213-988-2011','465 Aviation Way, Raleigh, NC 27601','wimartin@acme.com','2017-12-04','wimartin@acme.com');
INSERT INTO Employee(employeeId,name,phoneNumber,address,email,startDate,loginId) VALUES(557279280,'Jacob Gloss','413-335-9523','2014 Leverton Cove Road, Raleigh, NC 27560','jagloss@acme.com','2018-07-29','jagloss@acme.com');
INSERT INTO Employee(employeeId,name,phoneNumber,address,email,startDate,loginId) VALUES(183683346,'Anthony Freeman','563-496-7912','1188 Summit Street, Raleigh, NC 27627','anfreeman@acme.com','2015-02-09','anfreeman@acme.com');
INSERT INTO Employee(employeeId,name,phoneNumber,address,email,startDate,loginId) VALUES(557279281,'Eric Fowler','760-457-9846','1114 Fincham Road, Raleigh, NC 27545','erfowler@acme.com','2016-05-01','erfowler@acme.com');
INSERT INTO Employee(employeeId,name,phoneNumber,address,email,startDate,loginId) VALUES(557279282,'Roland Richmond','829-843-3373','1951 Little Acres Lane, Raleigh, NC 27513','rorichmond@acme.com','2017-12-28','rorichmond@acme.com');
INSERT INTO Employee(employeeId,name,phoneNumber,address,email,startDate,loginId) VALUES(557279283,'Peter Fitzpatrick','315-485-1152','4738 Buckhannan Avenue, Raleigh, NC 27625','pefitzpatrick@acme.com','2017-04-12','pefitzpatrick@acme.com');
INSERT INTO Employee(employeeId,name,phoneNumber,address,email,startDate,loginId) VALUES(291056276,'Roderick Phillips','901-777-0492','1133 Burton Avenue, Charlotte, NC 28201','rophillips@acme.com','2017-04-15','rophillips@acme.com');
INSERT INTO Employee(employeeId,name,phoneNumber,address,email,startDate,loginId) VALUES(911639633,'Dena Holmes','972-353-3691','1382 Whispering Pines Circle, Charlotte, NC 28205','deholmes@acme.com','2010-01-04','deholmes@acme.com');
INSERT INTO Employee(employeeId,name,phoneNumber,address,email,startDate,loginId) VALUES(590424694,'Dustin Esparza','956-444-0948','3510 Hemlock Lane, Charlotte, NC 28202','duesparza@acme.com','2017-01-26','duesparza@acme.com');
INSERT INTO Employee(employeeId,name,phoneNumber,address,email,startDate,loginId) VALUES(401671897,'Charles Pudilo','641-752-9403','196 Park Boulevard, Charlotte, NC 28222','chpudilo@acme.com','2016-07-06','chpudilo@acme.com');
INSERT INTO Employee(employeeId,name,phoneNumber,address,email,startDate,loginId) VALUES(310773348,'James Rivera','903-967-1809','908 Alpha Avenue, Charlotte, NC 28130','jarivera@acme.com','2013-10-29','jarivera@acme.com');
INSERT INTO Employee(employeeId,name,phoneNumber,address,email,startDate,loginId) VALUES(983204784,'Willis Morton','757-886-6330','404 Tenmile, Charlotte, NC 28134','wimorton@acme.com','2018-10-13','wimorton@acme.com');
INSERT INTO Employee(employeeId,name,phoneNumber,address,email,startDate,loginId) VALUES(187658163,'Rickie Henderson','931-539-1294','1963 Chenoweth Drive, Charlotte, NC 28228','rihenderson@acme.com','2017-03-29','rihenderson@acme.com');

INSERT INTO Manager(employeeId,salary) VALUES(950932130,11000);
INSERT INTO Manager(employeeId,salary) VALUES(291056276,12000);

INSERT INTO Receptionist(employeeId,salary) VALUES(911639633,9000);
INSERT INTO Receptionist(employeeId,salary) VALUES(634622236,8000);

INSERT INTO Mechanic(employeeId,hourlyWages) VALUES(557279280,30);
INSERT INTO Mechanic(employeeId,hourlyWages) VALUES(183683346,40);
INSERT INTO Mechanic(employeeId,hourlyWages) VALUES(557279281,35);
INSERT INTO Mechanic(employeeId,hourlyWages) VALUES(557279282,30);
INSERT INTO Mechanic(employeeId,hourlyWages) VALUES(557279283,34);
INSERT INTO Mechanic(employeeId,hourlyWages) VALUES(590424694,35);
INSERT INTO Mechanic(employeeId,hourlyWages) VALUES(401671897,40);
INSERT INTO Mechanic(employeeId,hourlyWages) VALUES(310773348,40);
INSERT INTO Mechanic(employeeId,hourlyWages) VALUES(983204784,30);
INSERT INTO Mechanic(employeeId,hourlyWages) VALUES(187658163,30);

INSERT INTO Works_In(serviceCenterId,employeeId) VALUES(1,950932130);
INSERT INTO Works_In(serviceCenterId,employeeId) VALUES(1,634622236);
INSERT INTO Works_In(serviceCenterId,employeeId) VALUES(1,557279280);
INSERT INTO Works_In(serviceCenterId,employeeId) VALUES(1,183683346);
INSERT INTO Works_In(serviceCenterId,employeeId) VALUES(1,557279281);
INSERT INTO Works_In(serviceCenterId,employeeId) VALUES(1,557279282);
INSERT INTO Works_In(serviceCenterId,employeeId) VALUES(1,557279283);
INSERT INTO Works_In(serviceCenterId,employeeId) VALUES(2,291056276);
INSERT INTO Works_In(serviceCenterId,employeeId) VALUES(2,911639633);
INSERT INTO Works_In(serviceCenterId,employeeId) VALUES(2,590424694);
INSERT INTO Works_In(serviceCenterId,employeeId) VALUES(2,401671897);
INSERT INTO Works_In(serviceCenterId,employeeId) VALUES(2,310773348);
INSERT INTO Works_In(serviceCenterId,employeeId) VALUES(2,983204784);
INSERT INTO Works_In(serviceCenterId,employeeId) VALUES(2,187658163);

INSERT INTO Users VALUES('lacohen@acme.com','password','Manager');
INSERT INTO Users VALUES('wimartin@acme.com','password','Receptionist');
INSERT INTO Users VALUES('jagloss@acme.com','password','Mechanic');
INSERT INTO Users VALUES('anfreeman@acme.com','password','Mechanic');
INSERT INTO Users VALUES('erfowler@acme.com','password','Mechanic');
INSERT INTO Users VALUES('rorichmond@acme.com','password','Mechanic');
INSERT INTO Users VALUES('pefitzpatrick@acme.com','password','Mechanic');
INSERT INTO Users VALUES('rophillips@acme.com','password','Manager');
INSERT INTO Users VALUES('deholmes@acme.com','password','Receptionist');
INSERT INTO Users VALUES('duesparza@acme.com','password','Mechanic');
INSERT INTO Users VALUES('chpudilo@acme.com','password','Mechanic');
INSERT INTO Users VALUES('jarivera@acme.com','password','Mechanic');
INSERT INTO Users VALUES('wimorton@acme.com','password','Mechanic');
INSERT INTO Users VALUES('rihenderson@acme.com','password','Mechanic');

INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(1,'Air Filter',11,null,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(2,'Air Filter',59,null,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(3,'Air Filter',61,null,'Nissan');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(4,'Axel Rod',124,2,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(5,'Axel Rod',141,2,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(6,'Axel Rod',241,3,'Nissan');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(7,'Battery',63,6,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(8,'Battery',79,3,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(9,'Battery',14,3,'Nissan');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(10,'Brake Fluid',24,null,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(11,'Brake Fluid',75,null,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(12,'Brake Fluid',16,null,'Nissan');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(13,'Brake Shoes',62,2,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(14,'Brake Shoes',41,3,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(15,'Brake Shoes',47,1,'Nissan');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(16,'Camshaft',1428,3,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(17,'Camshaft',511,2,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(18,'Camshaft',1295,2,'Nissan');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(19,'Catalytic converter',801,1,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(20,'Catalytic converter',716,2,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(21,'Catalytic converter',589,1,'Nissan');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(22,'Coolant',63,null,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(23,'Coolant',10,null,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(24,'Coolant',39,null,'Nissan');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(25,'Drive belt',528,1,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(26,'Drive belt',1443,1,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(27,'Drive belt',1084,3,'Nissan');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(28,'Engine oil',63,null,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(29,'Engine oil',27,null,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(30,'Engine oil',14,null,'Nissan');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(31,'Gears',523,1,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(32,'Gears',1344,3,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(33,'Gears',1176,3,'Nissan');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(34,'Light assembly',617,2,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(35,'Light assembly',1342,2,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(36,'Light assembly',1367,2,'Nissan');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(37,'Oil Filter',36,null,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(38,'Oil Filter',42,null,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(39,'Oil Filter',61,null,'Nissan');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(40,'Piston',1256,1,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(41,'Piston',1145,1,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(42,'Piston',1341,3,'Nissan');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(43,'Power Steering Fluid',17,null,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(44,'Power Steering Fluid',24,null,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(45,'Power Steering Fluid',20,null,'Nissan');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(46,'Spark plug',64,2,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(47,'Spark plug',50,2,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(48,'Spark plug',11,1,'Nissan');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(49,'Suspension fluid',70,null,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(50,'Suspension fluid',77,null,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(51,'Suspension fluid',32,null,'Nissan');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(52,'Valve',1338,1,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(53,'Valve',1261,2,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(54,'Valve',1013,1,'Nissan');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(55,'Wiper Fluid',28,null,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(56,'Wiper Fluid',56,null,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(57,'Wiper Fluid',31,null,'Nissan');


INSERT INTO Orders(partId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(7,'Complete',5,'2014-06-13','2014-06-18',1001,1);
INSERT INTO Orders(partId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(53,'Complete',5,'2015-09-21','2015-09-21',1002,1);
INSERT INTO Orders(partId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(32,'Complete',5,'2016-02-11','2016-02-11',1,2);
INSERT INTO Orders(partId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(24,'Complete',4,'2017-08-10','2017-08-11',2,1);
INSERT INTO Orders(partId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(1,'Complete',6,'2018-10-05','2018-10-05',1,2);
INSERT INTO Orders(partId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(18,'Complete',5,'2018-11-01','2018-11-05',1001,1);
INSERT INTO Orders(partId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(53,'Pending',7,'2018-11-14',null,1002,2);
INSERT INTO Orders(partId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(5,'Pending',12,'2018-11-14',null,1001,2);
INSERT INTO Orders(partId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(17,'Pending',6,'2018-11-14',null,1001,2);
INSERT INTO Orders(partId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(38,'Pending',5,'2018-11-14',null,1001,2);
INSERT INTO Orders(partId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(11,'Pending',5,'2018-11-14',null,1002,2);


INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,2,43,20,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,2,46,35,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,5,8,5,7);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,5,7,6,10);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,8,20,20,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,8,64,52,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,11,14,4,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,11,15,3,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,14,8,4,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,14,20,3,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,17,22,20,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,17,42,42,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,20,31,10,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,20,29,24,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,23,23,23,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,23,21,12,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,26,35,30,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,26,30,23,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,29,15,5,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,29,26,10,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,32,18,3,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,32,70,7,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,35,12,10,8);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,35,8,6,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,38,11,4,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,38,31,24,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,41,55,48,2);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,41,81,73,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,44,12,7,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,44,17,6,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,47,45,42,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,47,50,32,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,50,13,11,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,50,15,6,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,53,12,7,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,53,11,3,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,56,12,5,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,56,16,13,5);


INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,1,13,2,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,1,26,5,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,4,18,5,7);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,4,27,6,10);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,7,10,2,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,7,24,2,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,10,4,4,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,10,25,3,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,13,18,4,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,13,20,3,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,16,12,2,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,16,22,22,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,19,11,1,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,19,29,4,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,22,13,2,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,22,21,2,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,25,15,3,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,25,20,3,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,28,5,5,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,28,26,20,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,31,8,3,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,31,20,7,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,34,2,1,8);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,34,28,6,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,37,1,1,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,37,21,4,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,40,15,4,2);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,40,21,3,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,43,2,1,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,43,27,6,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,46,15,4,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,46,20,2,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,49,3,1,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,49,25,6,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,52,12,7,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,52,11,3,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,55,12,5,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,55,16,13,5);


INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,3,33,20,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,3,16,5,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,6,38,5,7);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,6,17,6,10);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,9,30,20,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,9,14,5,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,12,34,4,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,12,15,3,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,15,38,4,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,15,10,3,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,18,32,20,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,18,12,4,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,21,31,10,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,21,19,4,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,24,33,23,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,24,11,2,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,27,35,30,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,27,10,3,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,30,35,5,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,30,16,10,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,33,38,3,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,33,10,7,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,36,32,10,8);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,36,18,6,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,39,31,4,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,39,11,4,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,42,35,18,2);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,42,11,7,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,45,32,7,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,45,17,6,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,48,35,12,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,48,10,2,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,51,33,11,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,51,15,6,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,54,32,7,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,54,11,3,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(1,57,12,5,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(2,57,16,13,5);


INSERT INTO Appointment(appointmentId,mechanicPref,status,timeIn,mechId,typeOfService) VALUES(1,null,'Completed',TIMESTAMP '2018-09-10 10:00:00',557279280,3);
INSERT INTO Appointment(appointmentId,mechanicPref,status,timeIn,mechId,typeOfService) VALUES(2,null,'Completed',TIMESTAMP '2018-02-25 09:00:00',557279281,2);
INSERT INTO Appointment(appointmentId,mechanicPref,status,timeIn,mechId,typeOfService) VALUES(3,null,'Completed',TIMESTAMP '2017-10-15 08:00:00',183683346,1);
INSERT INTO Appointment(appointmentId,mechanicPref,status,timeIn,mechId,typeOfService) VALUES(4,null,'Completed',TIMESTAMP '2018-08-06 08:00:00',557279282,6);
INSERT INTO Appointment(appointmentId,mechanicPref,status,timeIn,mechId,typeOfService) VALUES(5,null,'Completed',TIMESTAMP '2018-05-15 10:30:00',557279283,2);
INSERT INTO Appointment(appointmentId,mechanicPref,status,timeIn,mechId,typeOfService) VALUES(6,null,'Completed',TIMESTAMP '2018-01-28 12:00:00',557279283,1);
INSERT INTO Appointment(appointmentId,mechanicPref,status,timeIn,mechId,typeOfService) VALUES(7,null,'Completed',TIMESTAMP '2018-02-11 08:30:00',557279281,1);
INSERT INTO Appointment(appointmentId,mechanicPref,status,timeIn,mechId,typeOfService) VALUES(8,null,'Completed',TIMESTAMP '2017-12-10 09:30:00',557279281,3);
INSERT INTO Appointment(appointmentId,mechanicPref,status,timeIn,mechId,typeOfService) VALUES(9,null,'Completed',TIMESTAMP '2017-01-20 10:00:00',557279281,2);
INSERT INTO Appointment(appointmentId,mechanicPref,status,timeIn,mechId,typeOfService) VALUES(10,null,'Completed',TIMESTAMP '2018-02-11 08:30:00',187658163,1);
INSERT INTO Appointment(appointmentId,mechanicPref,status,timeIn,mechId,typeOfService) VALUES(11,null,'Completed',TIMESTAMP '2016-11-05 09:00:00',401671897,9);
INSERT INTO Appointment(appointmentId,mechanicPref,status,timeIn,mechId,typeOfService) VALUES(12,null,'Completed',TIMESTAMP '2017-09-01 09:00:00',590424694,2);
INSERT INTO Appointment(appointmentId,mechanicPref,status,timeIn,mechId,typeOfService) VALUES(13,null,'Completed',TIMESTAMP '2014-06-15 08:30:00',310773348,1);
INSERT INTO Appointment(appointmentId,mechanicPref,status,timeIn,mechId,typeOfService) VALUES(14,null,'Completed',TIMESTAMP '2016-11-11 08:30:00',310773348,1);
INSERT INTO Appointment(appointmentId,mechanicPref,status,timeIn,mechId,typeOfService) VALUES(15,null,'Completed',TIMESTAMP '2016-01-02 14:00:00',401671897,8);
INSERT INTO Appointment(appointmentId,mechanicPref,status,timeIn,mechId,typeOfService) VALUES(16,null,'Completed',TIMESTAMP '2015-09-30 11:00:00',401671897,4);

update appointment set typeofservice = 1 where appointmentid =3;
update appointment set typeofservice = 2 where appointmentid =4;
update appointment set typeofservice = 1 where appointmentid =5;
update appointment set typeofservice = 1 where appointmentid =6;
update appointment set typeofservice = 1 where appointmentid =7;
update appointment set typeofservice = 1 where appointmentid =8;
update appointment set typeofservice = 1 where appointmentid =9;
update appointment set typeofservice = 1 where appointmentid =10;
update appointment set typeofservice = 2 where appointmentid =11;
update appointment set typeofservice = 1 where appointmentid =12;
update appointment set typeofservice = 1 where appointmentid =13;
update appointment set typeofservice = 1 where appointmentid =14;
update appointment set typeofservice = 2 where appointmentid =15;
update appointment set typeofservice = 2 where appointmentid =16;

INSERT INTO Books(serviceId,appointmentId,licensePlate,customerId) VALUES(3,1,'XYZ-5643',1001);
INSERT INTO Books(serviceId,appointmentId,licensePlate,customerId) VALUES(2,2,'XYZ-5643',1001);
INSERT INTO Books(serviceId,appointmentId,licensePlate,customerId) VALUES(1,3,'XYZ-5643',1001);
INSERT INTO Books(serviceId,appointmentId,licensePlate,customerId) VALUES(6,4,'AHS-3132',1001);
INSERT INTO Books(serviceId,appointmentId,licensePlate,customerId) VALUES(2,5,'AHS-3132',1001);
INSERT INTO Books(serviceId,appointmentId,licensePlate,customerId) VALUES(1,6,'AHS-3132',1001);
INSERT INTO Books(serviceId,appointmentId,licensePlate,customerId) VALUES(1,7,'IRM-1212',1002);
INSERT INTO Books(serviceId,appointmentId,licensePlate,customerId) VALUES(3,8,'IRM-1212',1002);
INSERT INTO Books(serviceId,appointmentId,licensePlate,customerId) VALUES(2,9,'IRM-1212',1002);
INSERT INTO Books(serviceId,appointmentId,licensePlate,customerId) VALUES(1,10,'DEL-8888',1003);
INSERT INTO Books(serviceId,appointmentId,licensePlate,customerId) VALUES(9,11,'DEL-8888',1003);
INSERT INTO Books(serviceId,appointmentId,licensePlate,customerId) VALUES(2,12,'P11-212A',1004);
INSERT INTO Books(serviceId,appointmentId,licensePlate,customerId) VALUES(1,13,'P11-212A',1004);
INSERT INTO Books(serviceId,appointmentId,licensePlate,customerId) VALUES(1,14,'WIM-BLE5',1004);
INSERT INTO Books(serviceId,appointmentId,licensePlate,customerId) VALUES(8,15,'WIM-BLE5',1004);
INSERT INTO Books(serviceId,appointmentId,licensePlate,customerId) VALUES(4,16,'WIM-BLE5',1004);


INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(1,0.25,50,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(2,0.25,50,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(3,0.25,50,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(4,0.5,50,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(5,1,60,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(6,1,60,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(7,0.25,50,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(8,1,60,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(9,0.25,50,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(10,1,60,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(11,0.5,50,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(12,0.25,50,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(13,1,60,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(14,0.25,50,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(15,0.25,50,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(16,0.25,50,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(17,0.5,50,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(18,0.5,50,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(19,1,60,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(20,1,60,"null");
INSERT INTO BasicService(basicServiceId,hoursRequired,laborChargeRate,description) VALUES(21,0.25,50,"null");

INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,1,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,2,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,3,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,1,3);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,2,3);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,3,3);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,4,5);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,5,5);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,6,5);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,4,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,5,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,6,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,7,4);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,8,4);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,9,4);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,7,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,8,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,9,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,10,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,11,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,12,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,10,4);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,11,4);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,12,4);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,13,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,14,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,15,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,13,5);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,14,5);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,15,5);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,16,4);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,17,4);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,18,4);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,16,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,17,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,18,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,19,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,20,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,21,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,19,3);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,20,3);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,21,3);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,22,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,23,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,24,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,22,4);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,23,4);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,24,4);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,25,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,26,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,27,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,25,2);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,26,2);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,27,2);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,28,2);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,29,2);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,30,2);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,28,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,29,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,30,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,31,5);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,32,5);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,33,5);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,31,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,32,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,33,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,34,3);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,35,3);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,36,3);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,34,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,35,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,36,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,37,4);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,38,4);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,39,4);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,37,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,38,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,39,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,40,2);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,41,2);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,42,2);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,40,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,41,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,42,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,43,5);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,44,5);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,45,5);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,43,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,44,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,45,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,46,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,47,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,48,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,46,5);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,47,5);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,48,5);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,49,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,50,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,51,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,49,3);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,50,3);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,51,3);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,52,3);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,53,3);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,54,3);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,52,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,53,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,54,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,55,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,56,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1001,57,null);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,55,3);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,56,3);
INSERT INTO Supplies(distributorId,partId,deliveryWindow) VALUES(1002,57,3);

INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(1,1,1,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(1,1,1,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(1,2,1,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(1,2,2,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(1,3,1,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(1,3,3,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(2,7,1,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(2,7,1,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(2,8,1,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(2,8,2,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(2,9,1,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(2,9,2,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(3,10,1,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(3,10,1,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(3,11,1,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(3,11,2,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(3,12,1,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(3,12,2,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(4,13,4,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(4,13,4,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(4,14,4,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(4,14,4,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(4,15,4,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(4,15,4,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(5,16,1,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(5,16,1,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(5,17,1,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(5,17,1,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(5,18,1,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(5,18,2,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(6,19,1,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(6,19,1,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(6,20,1,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(6,20,1,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(6,21,1,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(6,21,1,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(7,22,1,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(7,22,1,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(7,23,1,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(7,23,1,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(7,24,2,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(7,24,2,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(8,25,1,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(8,25,1,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(8,26,1,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(8,26,1,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(8,27,1,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(8,27,1,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(9,28,1,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(9,28,1,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(9,29,1,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(9,29,1,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(9,30,2,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(9,30,3,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(10,31,6,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(10,31,6,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(10,32,12,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(10,32,7,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(10,33,7,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(10,33,9,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(11,34,2,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(11,34,2,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(11,35,2,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(11,35,2,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(11,36,2,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(11,36,2,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(12,37,1,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(12,37,1,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(12,38,1,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(12,38,1,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(12,39,1,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(12,39,2,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(13,40,4,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(13,40,4,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(13,41,4,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(13,41,4,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(13,42,6,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(13,42,8,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(14,43,1,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(14,43,1,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(14,44,1,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(14,44,1,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(14,45,1,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(14,45,1,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(15,46,4,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(15,46,4,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(15,47,4,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(15,47,4,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(15,48,6,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(15,48,8,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(16,49,1,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(16,49,1,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(16,50,1,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(16,50,1,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(16,51,1,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(16,51,1,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(17,34,2,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(17,34,2,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(17,35,2,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(17,35,2,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(17,36,2,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(17,36,2,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(18,34,4,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(18,34,4,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(18,35,4,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(18,35,4,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(18,36,4,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(18,36,4,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(19,52,4,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(19,52,4,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(19,53,4,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(19,53,4,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(19,54,6,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(19,54,8,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(20,4,2,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(20,4,2,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(20,5,2,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(20,5,2,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(20,6,2,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(20,6,2,'Nissan','Rogue');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(21,55,1,'Toyota','Corolla');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(21,55,1,'Toyota','Prius');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(21,56,1,'Honda','Civic');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(21,56,1,'Honda','Accord');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(21,57,1,'Nissan','Altima');
INSERT INTO Uses(basicServiceId,partId,quantity,make,model) VALUES(21,57,1,'Nissan','Rogue');

Insert into Userss values('ethanhunt@gmail.com','password','Customer');
Insert into Userss values('jarvis@gmail.com','password','Customer');
Insert into Userss values('lovestory@gmail.com','password','Customer');
Insert into Userss values('venus@gmail.com','password','Customer');

Insert into owns values(1001,'XYZ-5643');
Insert into owns values(1001,'AHS-3132');
Insert into owns values(1002,'IRM-1212');
Insert into owns values(1003,'TSW-3462');
Insert into owns values(1003,'DEL-8888');
Insert into owns values(1004,'P11-212A');
Insert into owns values(1004,'WIM-BLE5');

Insert into service values(1);
Insert into service values(2);
Insert into service values(3);
Insert into service values(4);
Insert into service values(5);
Insert into service values(6);
Insert into service values(7);
Insert into service values(8);
Insert into service values(9);
Insert into service values(10);

Insert into repair values(4,'Engine knock',75,'Timing issue');
Insert into repair values(5,'Car drifts in a particular direction',50,'Wheel alignment issue');
Insert into repair values(6,'Battery does not hold charge',25,'Battery needs replacement');
Insert into repair values(7,'Black/unclean exhaust',75,'Bad catalytic convertor and filters');
Insert into repair values(8,'A/C-Heater not working',50,'Drive belt damaged, coolant not enough, weak battery');
Insert into repair values(9,'Headlamps/Tail lamps not working',30,'Light assembly damaged');
Insert into repair values(10,'Check engine light',100,'Gearbox and Torque convertor issue');

Insert into maintenance values(1,'A');
Insert into maintenance values(2,'B');
Insert into maintenance values(3,'C');

Insert into contains values(8,4,'Toyota','Corrola');
Insert into contains values(15,4,'Toyota','Corrola');    
Insert into contains values(5,4,'Toyota','Corrola');
Insert into contains values(19,4,'Toyota','Corrola');

Insert into contains values(8,4,'Toyota','Prius');
Insert into contains values(15,4,'Toyota','Prius');    
Insert into contains values(5,4,'Toyota','Prius');
Insert into contains values(19,4,'Toyota','Prius');

Insert into contains values(8,4,'Honda','Civic');
Insert into contains values(15,4,'Honda','Civic');    
Insert into contains values(5,4,'Honda','Civic');
Insert into contains values(19,4,'Honda','Civic');

Insert into contains values(8,4,'Honda','Accord');
Insert into contains values(15,4,'Honda','Accord');    
Insert into contains values(5,4,'Honda','Accord');
Insert into contains values(19,4,'Honda','Accord');

Insert into contains values(8,4,'Nissan','Altima');
Insert into contains values(15,4,'Nissan','Altima');    
Insert into contains values(5,4,'Nissan','Altima');
Insert into contains values(19,4,'Nissan','Altima');

Insert into contains values(8,4,'Nissan','Rogue');
Insert into contains values(15,4,'Nissan','Rogue');    
Insert into contains values(5,4,'Nissan','Rogue');
Insert into contains values(19,4,'Nissan','Rogue');


Insert into contains values(20,5,'Toyota','Corrola');

Insert into contains values(20,5,'Toyota','Prius');

Insert into contains values(20,5,'Honda','Civic');

Insert into contains values(20,5,'Honda','Accord');

Insert into contains values(20,5,'Nissan','Altima');

Insert into contains values(20,5,'Nissan','Rogue');


Insert into contains values(2,6,'Toyota','Corrola');

Insert into contains values(2,6,'Toyota','Prius');

Insert into contains values(2,6,'Honda','Civic');

Insert into contains values(2,6,'Honda','Accord');

Insert into contains values(2,6,'Nissan','Altima');

Insert into contains values(2,6,'Nissan','Rogue');

Insert into contains values(1,7,'Toyota','Corrola');
Insert into contains values(12,7,'Toyota','Corrola');    
Insert into contains values(6,7,'Toyota','Corrola');

Insert into contains values(1,7,'Toyota','Prius');
Insert into contains values(12,7,'Toyota','Prius');    
Insert into contains values(6,7,'Toyota','Prius');

Insert into contains values(1,7,'Honda','Civic');
Insert into contains values(12,7,'Honda','Civic');    
Insert into contains values(6,7,'Honda','Civic');

Insert into contains values(1,7,'Honda','Accord');
Insert into contains values(12,7,'Honda','Accord');    
Insert into contains values(6,7,'Honda','Accord');

Insert into contains values(1,7,'Nissan','Altima');
Insert into contains values(12,7,'Nissan','Altima');    
Insert into contains values(6,7,'Nissan','Altima');

Insert into contains values(1,7,'Nissan','Rogue');
Insert into contains values(12,7,'Nissan','Rogue');    
Insert into contains values(6,7,'Nissan','Rogue');


Insert into contains values(8,8,'Toyota','Corrola');
Insert into contains values(7,8,'Toyota','Corrola');   
Insert into contains values(2,8,'Toyota','Corrola');

Insert into contains values(8,8,'Toyota','Prius');
Insert into contains values(7,8,'Toyota','Prius');   
Insert into contains values(2,8,'Toyota','Prius');

Insert into contains values(8,8,'Honda','Civic');
Insert into contains values(7,8,'Honda','Civic');   
Insert into contains values(2,8,'Honda','Civic');

Insert into contains values(8,8,'Honda','Accord');
Insert into contains values(7,8,'Honda','Accord');   
Insert into contains values(2,8,'Honda','Accord');

Insert into contains values(8,8,'Nissan','Altima');
Insert into contains values(7,8,'Nissan','Altima');   
Insert into contains values(2,8,'Nissan','Altima');

Insert into contains values(8,8,'Nissan','Rogue');
Insert into contains values(7,8,'Nissan','Rogue');   
Insert into contains values(2,8,'Nissan','Rogue');

Insert into contains values(11,9,'Toyota','Corrola');
Insert into contains values(17,9,'Toyota','Corrola');   
Insert into contains values(18,9,'Toyota','Corrola');

Insert into contains values(11,9,'Toyota','Prius');
Insert into contains values(17,9,'Toyota','Prius');   
Insert into contains values(18,9,'Toyota','Prius');

Insert into contains values(11,9,'Honda','Civic');
Insert into contains values(17,9,'Honda','Civic');   
Insert into contains values(18,9,'Honda','Civic');

Insert into contains values(11,9,'Honda','Accord');
Insert into contains values(17,9,'Honda','Accord');   
Insert into contains values(18,9,'Honda','Accord');

Insert into contains values(11,9,'Nissan','Altima');
Insert into contains values(17,9,'Nissan','Altima');   
Insert into contains values(18,9,'Nissan','Altima');

Insert into contains values(11,9,'Nissan','Rogue');
Insert into contains values(17,9,'Nissan','Rogue');   
Insert into contains values(18,9,'Nissan','Rogue');



Insert into contains values(13,10,'Toyota','Corrola');
Insert into contains values(10,10,'Toyota','Corrola');    
Insert into contains values(5,10,'Toyota','Corrola');
Insert into contains values(19,10,'Toyota','Corrola');

Insert into contains values(13,10,'Toyota','Prius');
Insert into contains values(10,10,'Toyota','Prius');    
Insert into contains values(5,10,'Toyota','Prius');
Insert into contains values(19,10,'Toyota','Prius');

Insert into contains values(13,10,'Honda','Civic');
Insert into contains values(10,10,'Honda','Civic');   
Insert into contains values(5,10,'Honda','Civic');
Insert into contains values(19,10,'Honda','Civic');

Insert into contains values(13,10,'Honda','Accord');
Insert into contains values(10,10,'Honda','Accord');    
Insert into contains values(5,10,'Honda','Accord');
Insert into contains values(19,10,'Honda','Accord');

Insert into contains values(13,10,'Nissan','Altima');
Insert into contains values(10,10,'Nissan','Altima');   
Insert into contains values(5,10,'Nissan','Altima');
Insert into contains values(19,10,'Nissan','Altima');

Insert into contains values(13,10,'Nissan','Rogue');
Insert into contains values(10,10,'Nissan','Rogue');   
Insert into contains values(5,10,'Nissan','Rogue');
Insert into contains values(19,10,'Nissan','Rogue');

Insert into contains values(9,1,'Toyota','Corrola');
Insert into contains values(7,1,'Toyota','Corrola');

Insert into contains values(9,2,'Toyota','Corrola');
Insert into contains values(7,2,'Toyota','Corrola');
Insert into contains values(1,2,'Toyota','Corrola');
Insert into contains values(12,2,'Toyota','Corrola');
Insert into contains values(3,2,'Toyota','Corrola');
Insert into contains values(21,2,'Toyota','Corrola');
Insert into contains values(15,2,'Toyota','Corrola');

Insert into contains values(9,3,'Toyota','Corrola');
Insert into contains values(7,3,'Toyota','Corrola');
Insert into contains values(1,3,'Toyota','Corrola');
Insert into contains values(12,3,'Toyota','Corrola');
Insert into contains values(3,3,'Toyota','Corrola');
Insert into contains values(21,3,'Toyota','Corrola');
Insert into contains values(15,3,'Toyota','Corrola');
Insert into contains values(16,3,'Toyota','Corrola');
Insert into contains values(4,3,'Toyota','Corrola');
Insert into contains values(14,3,'Toyota','Corrola');

Insert into contains values(9,1,'Toyota','Prius');
Insert into contains values(7,1,'Toyota','Prius');
Insert into contains values(12,1,'Toyota','Prius');

Insert into contains values(9,2,'Toyota','Prius');
Insert into contains values(7,2,'Toyota','Prius');
Insert into contains values(12,2,'Toyota','Prius');
Insert into contains values(1,2,'Toyota','Prius');
Insert into contains values(2,2,'Toyota','Prius');
Insert into contains values(3,2,'Toyota','Prius');
Insert into contains values(21,2,'Toyota','Prius');
Insert into contains values(15,2,'Toyota','Prius');

Insert into contains values(9,3,'Toyota','Prius');
Insert into contains values(7,3,'Toyota','Prius');
Insert into contains values(12,3,'Toyota','Prius');
Insert into contains values(1,3,'Toyota','Prius');
Insert into contains values(2,3,'Toyota','Prius');
Insert into contains values(3,3,'Toyota','Prius');
Insert into contains values(21,3,'Toyota','Prius');
Insert into contains values(15,3,'Toyota','Prius');
Insert into contains values(16,3,'Toyota','Prius');
Insert into contains values(4,3,'Toyota','Prius');
Insert into contains values(14,3,'Toyota','Prius');


Insert into contains values(9,1,'Nissan','Altima');
Insert into contains values(1,1,'Nissan','Altima');
Insert into contains values(7,1,'Nissan','Altima');
Insert into contains values(12,1,'Nissan','Altima');

Insert into contains values(9,2,'Nissan','Altima');
Insert into contains values(1,2,'Nissan','Altima');
Insert into contains values(7,2,'Nissan','Altima');
Insert into contains values(12,2,'Nissan','Altima');
Insert into contains values(21,2,'Nissan','Altima');
Insert into contains values(3,2,'Nissan','Altima');


Insert into contains values(9,3,'Nissan','Altima');
Insert into contains values(1,3,'Nissan','Altima');
Insert into contains values(7,3,'Nissan','Altima');
Insert into contains values(12,3,'Nissan','Altima');
Insert into contains values(21,3,'Nissan','Altima');
Insert into contains values(3,3,'Nissan','Altima');
Insert into contains values(16,3,'Nissan','Altima');
Insert into contains values(4,3,'Nissan','Altima');
Insert into contains values(14,3,'Nissan','Altima');
Insert into contains values(15,3,'Nissan','Altima');


Insert into contains values(9,1,'Nissan','Rogue');
Insert into contains values(1,1,'Nissan','Rogue');
Insert into contains values(7,1,'Nissan','Rogue');
Insert into contains values(12,1,'Nissan','Rogue');
Insert into contains values(14,1,'Nissan','Rogue');
Insert into contains values(3,1,'Nissan','Rogue');

Insert into contains values(9,2,'Nissan','Rogue');
Insert into contains values(1,2,'Nissan','Rogue');
Insert into contains values(7,2,'Nissan','Rogue');
Insert into contains values(12,2,'Nissan','Rogue');
Insert into contains values(14,2,'Nissan','Rogue');
Insert into contains values(3,2,'Nissan','Rogue');
Insert into contains values(16,2,'Nissan','Rogue');
Insert into contains values(21,2,'Nissan','Rogue');
Insert into contains values(15,2,'Nissan','Rogue');

Insert into contains values(9,3,'Nissan','Rogue');
Insert into contains values(1,3,'Nissan','Rogue');
Insert into contains values(7,3,'Nissan','Rogue');
Insert into contains values(12,3,'Nissan','Rogue');
Insert into contains values(14,3,'Nissan','Rogue');
Insert into contains values(3,3,'Nissan','Rogue');
Insert into contains values(16,3,'Nissan','Rogue');
Insert into contains values(21,3,'Nissan','Rogue');
Insert into contains values(15,3,'Nissan','Rogue');
Insert into contains values(4,3,'Nissan','Rogue');
Insert into contains values(2,3,'Nissan','Rogue');

Insert into contains values(9,1,'Honda','Accord');
Insert into contains values(1,1,'Honda','Accord');
Insert into contains values(7,1,'Honda','Accord');
Insert into contains values(12,1,'Honda','Accord');

Insert into contains values(9,2,'Honda','Accord');
Insert into contains values(1,2,'Honda','Accord');
Insert into contains values(7,2,'Honda','Accord');
Insert into contains values(12,2,'Honda','Accord');
Insert into contains values(3,2,'Honda','Accord');
Insert into contains values(21,2,'Honda','Accord');
Insert into contains values(15,2,'Honda','Accord');

Insert into contains values(9,3,'Honda','Accord');
Insert into contains values(1,3,'Honda','Accord');
Insert into contains values(7,3,'Honda','Accord');
Insert into contains values(12,3,'Honda','Accord');
Insert into contains values(3,3,'Honda','Accord');
Insert into contains values(21,3,'Honda','Accord');
Insert into contains values(15,3,'Honda','Accord');
Insert into contains values(16,3,'Honda','Accord');
Insert into contains values(4,3,'Honda','Accord');
Insert into contains values(14,3,'Honda','Accord');

Insert into contains values(9,1,'Honda','Civic');
Insert into contains values(3,1,'Honda','Civic');
Insert into contains values(7,1,'Honda','Civic');

Insert into contains values(9,2,'Honda','Civic');
Insert into contains values(3,2,'Honda','Civic');
Insert into contains values(7,2,'Honda','Civic');
Insert into contains values(1,2,'Honda','Civic');
Insert into contains values(12,2,'Honda','Civic');
Insert into contains values(4,2,'Honda','Civic');
Insert into contains values(21,2,'Honda','Civic');
Insert into contains values(15,2,'Honda','Civic');

Insert into contains values(9,3,'Honda','Civic');
Insert into contains values(3,3,'Honda','Civic');
Insert into contains values(7,3,'Honda','Civic');
Insert into contains values(1,3,'Honda','Civic');
Insert into contains values(12,3,'Honda','Civic');
Insert into contains values(4,3,'Honda','Civic');
Insert into contains values(21,3,'Honda','Civic');
Insert into contains values(15,3,'Honda','Civic');
Insert into contains values(16,3,'Honda','Civic');
Insert into contains values(14,3,'Honda','Civic');

Insert into customer(cutomerId,name, phoneNumber, address, email, loginId) values(1001, 'Tom Cruise', 1234567890,'203, Park St, Raleigh, NC - 27603', 'ethanhunt@gmail.com','ethanhunt@gmail.com');
Insert into customer(customerId,name, phoneNumber, address, email, loginId) values(1002, 'Robert Downey Jr.', '9989877791','12-A, High St, Raleigh, NC - 27605', 'jarvis@gmail.com','jarvis@gmail.com');
Insert into customer(cutomerId,name, phoneNumber, address, email, loginId) values(1003, 'Taylor Swift', '8179827199','2A, 3rd Ave, Charlotte, NC - 28134', 'lovestory@gmail.com','lovestory@gmail.com');
Insert into customer(customerId,name, phoneNumber, address, email, loginId) values(1004, 'Serena Williams', '8714791879','90, Gorman St, Charlotte, NC - 28201', 'venus@gmail.com','venus@gmail.com');

Insert into vehicle(licenseplate,model,dateofpurchase,lastrecordedmileage,make,typeoflastservice,dateOfLastService,yearManufactured,serviceCenterId) values('XYZ-5643', 'Civic', '2009-12-24',90452,'Honda',3,'2018-09-10',2009,1);
Insert into vehicle(licenseplate,model,dateofpurchase,lastrecordedmileage,make,typeoflastservice,dateOfLastService,yearManufactured,serviceCenterId) values('AHS-3132', 'Prius', '2011-01-02',65452,'Toyota',6,'2018-08-06',2007,1);
Insert into vehicle(licenseplate,model,dateofpurchase,lastrecordedmileage,make,typeoflastservice,dateOfLastService,yearManufactured,serviceCenterId) values('IRM-1212', 'Altima', '2002-09-07',210452,'Nissan','1','2018-02-11',2001,1);
Insert into vehicle(licenseplate,model,dateofpurchase,lastrecordedmileage,make,typeoflastservice,dateOfLastService,yearManufactured,serviceCenterId) values('TSW-3462', 'Accord', '2015-12-9',null,'Honda',null,null,2015,1);
Insert into vehicle(licenseplate,model,dateofpurchase,lastrecordedmileage,make,typeoflastservice,dateOfLastService,yearManufactured,serviceCenterId) values('DEL-8888', 'Rogue', '2016-05-11',31209,'Nissan','1','2018-02-11',2014,1);
Insert into vehicle(licenseplate,model,dateofpurchase,lastrecordedmileage,make,typeoflastservice,dateOfLastService,yearManufactured,serviceCenterId) values('P11-212A', 'Accord', '2010-04-14',60452,'Honda','2','2017-09-01',2009,2);
Insert into vehicle(licenseplate,model,dateofpurchase,lastrecordedmileage,make,typeoflastservice,dateOfLastService,yearManufactured,serviceCenterId) values('WIM-BLE5', 'Prius', '2014-03-01',19876,'Toyota','1','2016-11-11',2013,2);

update basicservice set hoursrequired = 0.25, description = 'Air Filter Change' where basicserviceid = 1;
update basicservice set hoursrequired = 0.25, description = 'Battery Replacement' where basicserviceid = 2;
update basicservice set hoursrequired = 0.25, description = 'Brake Check' where basicserviceid = 3;
update basicservice set hoursrequired = 0.5, description = 'Brake Repair'where basicserviceid = 4;
update basicservice set hoursrequired = 1, description = 'Camshaft Replacement' where basicserviceid = 5;
update basicservice set hoursrequired = 1, description = 'Catalytic Covertor Replacement' where basicserviceid = 6;
update basicservice set hoursrequired = 0.25, description = 'Coolant Recycle' where basicserviceid = 7;
update basicservice set hoursrequired = 1, description = 'Drive Belt Replacement' where basicserviceid = 8;
update basicservice set hoursrequired = 0.25, description = 'Engine Oil Change' where basicserviceid = 9;
update basicservice set hoursrequired = 1, description = 'Gear Box Repair' where basicserviceid = 10;
update basicservice set hoursrequired = 0.5, description = 'Headlights Replacement' where basicserviceid = 11;
update basicservice set hoursrequired = 0.25, description = 'Oil Filter Change' where basicserviceid = 12;
update basicservice set hoursrequired = 1, description = 'Piston Replacement' where basicserviceid = 13;
update basicservice set hoursrequired = 0.25, description = 'Power Steering Check' where basicserviceid = 14;
update basicservice set hoursrequired = 0.25, description = 'Spark Plugs Replacement' where basicserviceid = 15;
update basicservice set hoursrequired = 0.25, description = 'Suspension Check' where basicserviceid = 16;
update basicservice set hoursrequired = 0.5, description = 'Tail Lights Replacement' where basicserviceid = 17;
update basicservice set hoursrequired = 0.5, description = 'Turn Lights Replacement' where basicserviceid = 18;
update basicservice set hoursrequired = 1, description = 'Valve Replacement' where basicserviceid = 19;
update basicservice set hoursrequired = 1, description = 'Wheel Alignment' where basicserviceid = 20;
update basicservice set hoursrequired = 0.25, description = 'Wiper Check' where basicserviceid = 21;
