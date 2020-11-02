insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'John','Warton','warton@gmail.com'); 
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Benn','Affleck','affleck@gmail.com');  
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Adham','Sandler','sandler@gmail.com'); 
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Joshua','Cimich','cimich@gmail.com'); 
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Timm','Bennet','bennet@gmail.com'); 
insert into employee (employee_id, first_name, last_name, email) values (nextval('employee_seq'), 'Morris','Stewart','stewart@gmail.com'); 


insert into project (project_id, name,stage,description) values (nextval('project_seq'), 'Large Production Deploy','NOTSTARTED','Blal alalal alala lala'); 
insert into project (project_id, name,stage,description) values (nextval('project_seq'), 'New Employee Budget','COMPLETED','Blal alalal alala lala'); 
insert into project (project_id, name,stage,description) values (nextval('project_seq'), 'Office Reconstruction','INPROGRES','Blal alalal alala lala'); 
insert into project (project_id, name,stage,description) values (nextval('project_seq'), 'Improve Internet Security','INPROGRES','Blal alalal alala lala'); 

insert into project_employee (project_id,employee_id) values (select project_id from project where name = 'Large Production Deploy', select employee_id from employee where last_name = 'Warton');
insert into project_employee (project_id,employee_id) values (select project_id from project where name = 'New Employee Budget', select employee_id from employee where last_name = 'Affleck');
insert into project_employee (project_id,employee_id) values (select project_id from project where name = 'Office Reconstruction', select employee_id from employee where last_name = 'Sandler');
insert into project_employee (project_id,employee_id) values (select project_id from project where name = 'Improve Internet Security', select employee_id from employee where last_name = 'Cimich');
insert into project_employee (project_id,employee_id) values (select project_id from project where name = 'Improve Internet Security', select employee_id from employee where last_name = 'Bennet');
insert into project_employee (project_id,employee_id) values (select project_id from project where name = 'Large Production Deploy', select employee_id from employee where last_name = 'Stewart');
insert into project_employee (project_id,employee_id) values (select project_id from project where name = 'Improve Internet Security', select employee_id from employee where last_name = 'Warton');
insert into project_employee (project_id,employee_id) values (select project_id from project where name = 'New Employee Budget', select employee_id from employee where last_name = 'Affleck'); 