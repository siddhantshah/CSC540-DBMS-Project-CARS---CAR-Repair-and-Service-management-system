INSERT INTO ServiceCenter(serviceCenterId,name,address,phoneNumber) VALUES(S0001,'Downtown Auto Care','437 Fayetteville St., Raleigh, NC 27601','1.800.899.9999');
INSERT INTO ServiceCenter(serviceCenterId,name,address,phoneNumber) VALUES(S0002,'Express Auto Shop','201 N Tryon St, Charlotte, NC 28202','1.704.333.1555');

INSERT INTO DISTRIBUTOR(distributorId,name) VALUES(1001,'D1');
INSERT INTO DISTRIBUTOR(distributorId,name) VALUES(1002,'D2');

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

INSERT INTO User(loginId,password,employeeOrCustomer) VALUES('lacohen@acme.com','password','Employee');
INSERT INTO User(loginId,password,employeeOrCustomer) VALUES('wimartin@acme.com','password','Employee');
INSERT INTO User(loginId,password,employeeOrCustomer) VALUES('jagloss@acme.com','password','Employee');
INSERT INTO User(loginId,password,employeeOrCustomer) VALUES('anfreeman@acme.com','password','Employee');
INSERT INTO User(loginId,password,employeeOrCustomer) VALUES('erfowler@acme.com','password','Employee');
INSERT INTO User(loginId,password,employeeOrCustomer) VALUES('rorichmond@acme.com','password','Employee');
INSERT INTO User(loginId,password,employeeOrCustomer) VALUES('pefitzpatrick@acme.com','password','Employee');
INSERT INTO User(loginId,password,employeeOrCustomer) VALUES('rophillips@acme.com','password','Employee');
INSERT INTO User(loginId,password,employeeOrCustomer) VALUES('deholmes@acme.com','password','Employee');
INSERT INTO User(loginId,password,employeeOrCustomer) VALUES('duesparza@acme.com','password','Employee');
INSERT INTO User(loginId,password,employeeOrCustomer) VALUES('chpudilo@acme.com','password','Employee');
INSERT INTO User(loginId,password,employeeOrCustomer) VALUES('jarivera@acme.com','password','Employee');
INSERT INTO User(loginId,password,employeeOrCustomer) VALUES('wimorton@acme.com','password','Employee');
INSERT INTO User(loginId,password,employeeOrCustomer) VALUES('rihenderson@acme.com','password','Employee');

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
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(52,'Wiper Fluid',28,null,'Toyota');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(53,'Wiper Fluid',56,null,'Honda');
INSERT INTO Inventory(partId,name,unitprice,warranty,make) VALUES(54,'Wiper Fluid',31,null,'Nissan');


INSERT INTO Orders(orderId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(7,'Complete',5,'2014-06-13','2014-06-18',1001,1);
INSERT INTO Orders(orderId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(53,'Complete',5,'2015-09-21','2015-09-21',1002,1);
INSERT INTO Orders(orderId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(32,'Complete',5,'2016-02-11','2016-02-11',1,2);
INSERT INTO Orders(orderId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(24,'Complete',4,'2017-08-10','2017-08-11',2,1);
INSERT INTO Orders(orderId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(1,'Complete',6,'2018-10-05','2018-10-05',1,2);
INSERT INTO Orders(orderId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(18,'Complete',5,'2018-11-01','2018-11-05',1001,1);
INSERT INTO Orders(orderId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(53,'Pending',7,'2018-11-14',null,1002,2);
INSERT INTO Orders(orderId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(5,'Pending',12,'2018-11-14',null,1001,2);
INSERT INTO Orders(orderId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(17,'Pending',6,'2018-11-14',null,1001,2);
INSERT INTO Orders(orderId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(38,'Pending',5,'2018-11-14',null,1001,2);
INSERT INTO Orders(orderId,status,quantity,expectedDeliveryDate,actualDeliveryDate,source,destination) VALUES(11,'Pending',5,'2018-11-14',null,1002,2);


INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,2,43,20,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,2,46,35,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,5,8,5,7);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,5,7,6,10);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,8,20,20,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,8,64,52,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,11,14,4,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,11,15,3,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,14,8,4,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,14,20,3,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,17,22,20,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,17,42,42,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,20,31,10,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,20,29,24,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,23,23,23,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,23,21,12,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,26,35,30,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,26,30,23,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,29,15,5,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,29,26,10,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,32,18,3,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,32,70,7,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,35,12,10,8);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,35,8,6,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,38,11,4,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,38,31,24,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,41,55,48,2);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,41,81,73,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,44,12,7,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,44,17,6,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,47,45,42,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,47,50,32,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,50,13,11,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,50,15,6,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,53,12,7,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,53,11,3,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,56,12,5,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,56,16,13,5);


INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,1,13,2,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,1,26,5,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,4,18,5,7);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,4,27,6,10);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,7,10,2,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,7,24,2,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,10,4,4,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,10,25,3,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,13,18,4,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,13,20,3,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,16,12,2,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,16,22,22,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,19,11,1,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,19,29,4,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,22,13,2,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,22,21,2,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,25,15,3,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,25,20,3,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,28,5,5,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,28,26,20,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,31,8,3,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,31,20,7,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,34,2,1,8);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,34,28,6,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,37,1,1,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,37,21,4,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,40,15,4,2);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,40,21,3,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,43,2,1,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,43,27,6,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,46,15,4,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,46,20,2,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,49,3,1,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,49,25,6,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,52,12,7,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,52,11,3,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,55,12,5,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,55,16,13,5);


INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,3,33,20,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,3,16,5,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,6,38,5,7);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,6,17,6,10);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,9,30,20,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,9,14,5,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,12,34,4,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,12,15,3,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,15,38,4,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,15,10,3,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,18,32,20,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,18,12,4,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,21,31,10,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,21,19,4,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,24,33,23,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,24,11,2,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,27,35,30,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,27,10,3,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,30,35,5,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,30,16,10,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,33,38,3,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,33,10,7,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,36,32,10,8);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,36,18,6,3);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,39,31,4,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,39,11,4,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,42,35,18,2);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,42,11,7,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,45,32,7,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,45,17,6,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,48,35,12,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,48,10,2,4);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,51,33,11,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,51,15,6,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,54,32,7,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,54,11,3,6);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0001,57,12,5,5);
INSERT INTO Has(serviceCenterId,partId,currentQuantity,minimumQuantityThreshold,minimumOrderThreshold) VALUES(S0002,57,16,13,5);


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













