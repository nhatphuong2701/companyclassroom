INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (false,NULL,'1995-08-19','egriffiths1@google.de','Erasmus','GENDER_OTHERS','Griffiths','YYm4iL7Khx9K','egriffiths1')
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (true,NULL,'1996-02-19','kstubbins2@squidoo.com','Kimberli','GENDER_OTHERS','Stubbins','sYQlKnbV','kstubbins2');
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (false,NULL,'1996-04-28','bhuggens3@usa.gov','Broddie','GENDER_MALE','Huggens','uqNduahe','bhuggens3');
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (true,NULL,'1998-02-11','asimkiss4@tiny.cc','Annalee','GENDER_MALE','Simkiss','WBPc4C4Eiz','asimkiss4');
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (false,NULL,'1995-07-26','asanto5@devhub.com','Antoinette','GENDER_FEMALE','Santo','6mUKiaDmTZM','asanto5');
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (false,NULL,'1996-04-11','bsimonutti6@hostgator.com','Brandie','GENDER_FEMALE','Simonutti','kOeigM5VGk','bsimonutti6');
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (false,NULL,'2000-01-26','nmassel7@nature.com','Nikkie','GENDER_FEMALE','Massel','WMXRpN','nmassel7');
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (false,NULL,'1998-05-25','wrorke8@engadget.com','Wilburt','GENDER_OTHERS','Rorke','4E1YG37','wrorke8');
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (true,NULL,'1997-01-24','jrein9@cisco.com','Janine','GENDER_OTHERS','Rein','4LsWztKxKfs','jrein9');
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (true,NULL,'1999-01-15','mfraya@forbes.com','Madella','GENDER_OTHERS','Fray','Didbbd','mfraya');
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (true,NULL,'1998-01-27','ebruneaub@live.com','Eberto','GENDER_OTHERS','Bruneau','UGh37avzpFt','ebruneaub');
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (false,NULL,'1995-11-04','jteanbyc@java.com','Josh','GENDER_MALE','Teanby','zJBR4qtRccR','jteanbyc');
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (false,NULL,'1997-11-22','wwreifordd@paypal.com','Worden','GENDER_OTHERS','Wreiford','5rZcUZnGL','wwreifordd');
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (true,NULL,'1998-07-28','edobbyne@youtu.be','Edeline','GENDER_OTHERS','Dobbyn','fp5cRowiE','edobbyne');
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (true,NULL,'1996-01-21','mhallbirdf@oracle.com','Meris','GENDER_FEMALE','Hallbird','jIrvSHM','mhallbirdf');
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (true,NULL,'2000-04-15','pbelseyg@timesonline.co.uk','Perle','GENDER_FEMALE','Belsey','JkTEbU36Ixe','pbelseyg');
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (true,NULL,'1998-08-19','pyantsurevh@icio.us','Pat','GENDER_FEMALE','Yantsurev','ffiaqvfZtKf','pyantsurevh');
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (true,NULL,'1995-11-18','rwomacki@acquirethisname.com','Rhona','GENDER_MALE','Womack','JkMZGjbVBcQ','rwomacki');
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (false,NULL,'1997-04-13','mdeakesj@jiathis.com','Mellisent','GENDER_MALE','Deakes','mftZKIuXq','mdeakesj');
INSERT INTO users (active,avatar,date_of_birth,email,first_name,gender,last_name,password,username) VALUES (false,NULL,'1995-10-11','acarden0@tripadvisor.com','Aurelea','GENDER_OTHERS','Carden','$2a$12$kYRpPIR9/yF06L3GalApKug5Lxu3stTNVgXmOaS6M1Mh8e30zwKry','acarden0');

insert into user_role_assignment (role,user_id) values ('ROLE_ADMIN',20);
insert into user_role_assignment (role,user_id) values ('ROLE_TEACHER',2);
insert into user_role_assignment (role,user_id) values ('ROLE_STUDENT',3);

insert into courses (description, name) values ('for Non-it students', 'NON-IT');
insert into courses (description, name) values ('for freshers', 'fresher course');

insert into classrooms (name, academic_year, start_date, end_date, course_id) values ('non-it 1', 2023, '2023-03-13', '2023-09-13', 1);
insert into classrooms (name, academic_year, start_date, end_date, course_id) values ('non-it 2', 2023, '2023-04-13', '2023-10-13', 1);

insert into participate (classroom_id, user_id) values (1, 1);
insert into participate (classroom_id, user_id) values (1, 2);