INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'2000-01-27','nhatphuongtran@gmail.com','Phuong','GENDER_FEMALE','Tran La Nhat','$2a$12$PuGNndCrX0Uu46Z8hj/KfezEOM6AGiD/9dcIX6w8/.wSApdkxZzPy','phuongtran');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'1997-07-08','annguyen@gmail.com','An','GENDER_MALE','Nguyen Dat','anNguyen@123', 'annguyen');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'1995-07-05','hoangvu@gmail.com','Vu','GENDER_MALE','Bui Minh Hoang','vuHoang@123','vuhoang');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'1998-07-06','thanhnhan@gmail.com','Nhan','GENDER_MALE','Pham Thanh', 'nhanThanh@123','nhanthanh');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'1995-05-02','huyhoang@gmail.com','Hoang','GENDER_MALE','Vu Huy','hoangVu@123','hoangvu');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'1995-09-06','ngoctan@gmail.com','Tan','GENDER_MALE','Pham Ngoc','ngocTan@123','tanpham');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'1995-06-03','minhtung@gmail.com','Tung','GENDER_MALE','Tran Minh','minhTung@123','tungTran');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'1995-09-17','thanhbinh@gmail.com','Binh','GENDER_MALE','Dao Hoa','hoaBinh@123','hoabinh');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'1999-02-04','thuytrang@gmail.com','Trang','GENDER_FEMALE','Pham Thuy','thuyTrang@123','thuytrang');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'1995-07-01','quockhanh@gmail.com','Khanh','GENDER_MALE','Bui Quoc','quocKhanh@123','quockhanh');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'1997-04-07','thanhthuy@gmail.com','Thuy','GENDER_FEMALE','Nguyen Ngoc Thanh','thanhThuy@123','thanhthuy');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'1995-05-03','thienan@gmail.com','An','GENDER_MALE','Nguyen Thien','thienAn@123','thienan');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'1997-04-05','hoangtan@gmail.com','Tan','GENDER_MALE','Nguyen Hoang','hoangTan@123','hoangtan');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'1999-05-06','minhluat@gmail.com','Luat','GENDER_MALE','Bui Minh','minhLuat@123','minhluat');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(false,NULL,'2000-03-19','minhquy@gmail.com','Quy','GENDER_OTHERS','Vo Minh','minhQuy@123','minhquy');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(false,NULL,'2001-05-06','tuananh@gmail.com','Anh','GENDER_OTHERS','Phan Xuan Tuan','tuanAnh@123','tuananh');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(false,NULL,'1999-07-09','hatrang@gmial.com','Trang','GENDER_FEMALE','Nguyen Ha','haTrang@123','hatrang');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'2001-05-07','thuyngan@gmail.com','Ngan','GENDER_FEMALE','Dang Thi Thuy','thuyNgan@123','thuyngan');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'2000-07-09','thanhtoan@gmail.com','Toan','GENDER_FEMALE','Dinh Thanh','thanhToan@123','thanhtoan');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'2001-01-12','hoanghuy@gmail.com','Huy','GENDER_MALE','Huynh Hoang','hoangHuy@123','hoanghuy');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'1979-03-05','quochuy@gmail.com','Huy','GENDER_MALE','Nguyen Quoc','quocHuy@123','quochuy');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'1979-07-04','thanhliem@gmail.com','Liem','GENDER_MALE','Ha Thanh','thanhLiem@123','thanhliem');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'1980-05-06','thomasbui@gmail.com','Thomas','GENDER_MALE','Bui','thomasBui@123','thomasbui');
INSERT INTO users (active, avatar, date_of_birth, email, first_name, gender, last_name, password, username) VALUES(true,NULL,'1992-04-07','joshwenner@gmail.com','Josh','GENDER_MALE','Wenner','joshWenner@123','joshwenner');

INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_ADMIN',1);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',2);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',3);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',4);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',5);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',6);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',7);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',8);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',9);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',10);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',11);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',12);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',13);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',14);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',15);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',16);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',17);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',18);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',19);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_STUDENT',20);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_TEACHER',21);
INSERT INTO public.user_role_assignment("role",user_id) VALUES('ROLE_TEACHER',22);


INSERT INTO public.courses(description, "name") VALUES('For Non-IT employees','NON-IT course');
INSERT INTO public.courses(description, "name") VALUES('For Fresher employees', 'Fresher course');
INSERT INTO public.courses(description, "name") VALUES('For employees who want to improve English skills', 'English course');

INSERT INTO public.classes(academic_year, end_date, "name", start_date, course_id) VALUES(2022, '2022-09-13', 'Non-IT class No.1', '2022-03-13', 1);
INSERT INTO public.classes(academic_year, end_date, "name", start_date, course_id) VALUES(2023, '2023-09-13', 'Non-IT class No.2', '2023-03-13', 1);
INSERT INTO public.classes(academic_year, end_date, "name", start_date, course_id) VALUES(2023, '2023-04-15', 'Fresher class No.2', '2023-01-15', 2);
INSERT INTO public.classes(academic_year, end_date, "name", start_date, course_id) VALUES(2022, '2022-05-15', 'Fresher class No.1', '2021-12-15', 2);
INSERT INTO public.classes(academic_year, end_date, "name", start_date, course_id) VALUES(2023, '2023-07-16', 'English class No.1', '2023-02-16', 3);
INSERT INTO public.classes(academic_year, end_date, "name", start_date, course_id) VALUES(2023, '2023-09-18', 'Advanced English class No.1', '2023-04-18', 3);

INSERT INTO public.participate(class_id, user_id) VALUES(1, 2);
INSERT INTO public.participate(class_id, user_id) VALUES(1, 3);
INSERT INTO public.participate(class_id, user_id) VALUES(1, 4);
INSERT INTO public.participate(class_id, user_id) VALUES(1, 5);
INSERT INTO public.participate(class_id, user_id) VALUES(2, 6);
INSERT INTO public.participate(class_id, user_id) VALUES(2, 7);
INSERT INTO public.participate(class_id, user_id) VALUES(2, 8);
INSERT INTO public.participate(class_id, user_id) VALUES(2, 9);
INSERT INTO public.participate(class_id, user_id) VALUES(2, 10);
INSERT INTO public.participate(class_id, user_id) VALUES(5, 11);
INSERT INTO public.participate(class_id, user_id) VALUES(5, 12);
INSERT INTO public.participate(class_id, user_id) VALUES(5, 13);
INSERT INTO public.participate(class_id, user_id) VALUES(5, 14);
INSERT INTO public.participate(class_id, user_id) VALUES(5, 15);
INSERT INTO public.participate(class_id, user_id) VALUES(6, 16);
INSERT INTO public.participate(class_id, user_id) VALUES(6, 17);
INSERT INTO public.participate(class_id, user_id) VALUES(6, 18);
INSERT INTO public.participate(class_id, user_id) VALUES(6, 19);
INSERT INTO public.participate(class_id, user_id) VALUES(6, 20);
INSERT INTO public.participate(class_id, user_id) VALUES(2, 21);
INSERT INTO public.participate(class_id, user_id) VALUES(2, 22);
INSERT INTO public.participate(class_id, user_id) VALUES(1, 21);
INSERT INTO public.participate(class_id, user_id) VALUES(1, 22);
INSERT INTO public.participate(class_id, user_id) VALUES(3, 21);
INSERT INTO public.participate(class_id, user_id) VALUES(3, 22);
INSERT INTO public.participate(class_id, user_id) VALUES(4, 21);
INSERT INTO public.participate(class_id, user_id) VALUES(4, 22);
INSERT INTO public.participate(class_id, user_id) VALUES(5, 21);
INSERT INTO public.participate(class_id, user_id) VALUES(5, 22);
INSERT INTO public.participate(class_id, user_id) VALUES(6, 21);
INSERT INTO public.participate(class_id, user_id) VALUES(6, 22);


INSERT INTO public.assignments(attachment, due_time, instruction, "name", points, class_id) VALUES(NULL, '2023-03-15', 'Complete 10 per 13 exercises', 'Module 1 Chapter 1', 100, 2);
INSERT INTO public.assignments(attachment, due_time, instruction, "name", points, class_id) VALUES(NULL, '2023-03-20', NULL, 'Module 1 Chapter 2', 100, 2);
INSERT INTO public.assignments(attachment, due_time, instruction, "name", points, class_id) VALUES(NULL, '2023-03-25', NULL, 'Module 1 Chapter 3', 100, 2);
INSERT INTO public.assignments(attachment, due_time, instruction, "name", points, class_id) VALUES(NULL, '2023-04-01', NULL, 'Module 1 Chapter 4', 100, 2);
INSERT INTO public.assignments(attachment, due_time, instruction, "name", points, class_id) VALUES(NULL, '2023-03-25', NULL, 'English ex.1', 100, 5);
INSERT INTO public.assignments(attachment, due_time, instruction, "name", points, class_id) VALUES(NULL, '2023-04-02', NULL, 'English ex.2', 100, 5);
INSERT INTO public.assignments(attachment, due_time, instruction, "name", points, class_id) VALUES(NULL, '2023-05-02', NULL, 'Advanced English ex.1', 100, 6);
INSERT INTO public.assignments(attachment, due_time, instruction, "name", points, class_id) VALUES(NULL, '2023-06-03', NULL, 'Advanced English ex.2', 100, 6);

INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 80, '2023-03-14 23:30:00',1 , 6);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 75, '2023-03-14 23:00:00',1 , 7);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 60, '2023-03-15 01:00:00',1 , 8);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 65, '2023-03-15 01:30:00',1 , 9);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 50, '2023-03-15 01:30:00',1 , 10);

INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 80, '2023-03-19 23:30:00',2 , 6);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 78, '2023-03-19 23:00:00',2 , 7);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 55, '2023-03-19 20:00:00',2 , 8);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 90, '2023-03-19 21:30:00',2 , 9);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 85, '2023-03-19 22:30:00',2 , 10);

INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 70, '2023-03-24 20:30:00',3 , 6);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 78, '2023-03-24 19:00:00',3 , 7);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 65, '2023-03-24 21:00:00',3 , 8);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 50, '2023-03-25 01:30:00',3 , 9);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 75, '2023-03-25 02:30:00',3 , 10);

INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 60, '2023-03-31 20:30:00',4 , 6);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 78, '2023-03-31 19:00:00',4 , 7);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 65, '2023-04-01 01:00:00',4 , 8);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 50, '2023-04-01 01:30:00',4 , 9);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 75, '2023-04-01 01:30:00',4 , 10);

INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 60, '2023-03-24 20:30:00',5 , 11);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 78, '2023-03-24 19:00:00',5 , 12);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 65, '2023-03-25 01:00:00',5 , 13);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 50, '2023-03-25 01:30:00',5 , 14);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 75, '2023-03-25 01:30:00',5 , 15);

INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 60, '2023-04-01 20:30:00',6 , 11);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 78, '2023-04-01 19:00:00',6 , 12);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 65, '2023-04-02 01:00:00',6 , 13);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 50, '2023-04-02 01:30:00',6 , 14);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 75, '2023-04-02 01:30:00',6 , 15);

INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 60, '2023-05-01 20:30:00',7 , 16);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 78, '2023-05-01 19:00:00',7 , 17);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 65, '2023-05-02 01:00:00',7 , 18);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 50, '2023-05-02 01:30:00',7 , 19);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 75, '2023-05-02 01:30:00',7 , 20);


INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 60, '2023-06-02 20:30:00',8 , 16);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 78, '2023-06-02 19:00:00',8 , 17);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 65, '2023-06-03 01:00:00',8 , 18);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 50, '2023-06-03 01:30:00',8 , 19);
INSERT INTO public.submissions(attachment, note, points, submit_time, assignment_id, user_id) VALUES(NULL, NULL, 75, '2023-06-03 01:30:00',8 , 20);

INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content1', '2022-03-19 14:30:00', 'Title1', 1, 21);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content2', '2022-03-25 14:30:00', 'Title2', 1, 21);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content3', '2022-04-01 14:30:00', 'Title3', 1, 21);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content4', '2022-04-10 15:30:00', 'Title4', 1, 21);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content5', '2022-05-15 16:30:00', 'Title5', 1, 22);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content6', '2022-05-16 14:30:00', 'Title6', 1, 22);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content7', '2022-05-25 14:30:00', 'Title7', 1, 22);

INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content8', '2023-03-19 14:30:00', 'Title8', 2, 21);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content9', '2023-03-25 14:30:00', 'Title9', 2, 21);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content10', '2023-04-01 14:30:00', 'Title10', 2, 21);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content11', '2023-04-10 15:30:00', 'Title11', 2, 21);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content12', '2023-04-25 16:30:00', 'Title12', 2, 22);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content13', '2023-05-05 14:30:00', 'Title13', 2, 22);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content14', '2023-05-15 14:30:00', 'Title14', 2, 22);

INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content15', '2023-03-19 14:30:00', 'Title15', 3, 21);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content16', '2023-03-25 14:30:00', 'Title16', 3, 21);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content17', '2023-04-01 14:30:00', 'Title17', 3, 21);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content18', '2023-04-10 15:30:00', 'Title18', 3, 21);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content19', '2023-04-12 16:30:00', 'Title19', 3, 22);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content20', '2023-04-15 14:30:00', 'Title20', 3, 22);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content21', '2023-05-01 14:30:00', 'Title21', 3, 22);

INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content22', '2022-03-19 14:30:00', 'Title22', 4, 21);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content23', '2022-03-25 14:30:00', 'Title23', 4, 21);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content24', '2022-04-01 14:30:00', 'Title24', 4, 21);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content25', '2022-04-10 15:30:00', 'Title25', 4, 21);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content26', '2022-03-25 16:30:00', 'Title26', 4, 22);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content27', '2022-03-25 14:30:00', 'Title27', 4, 22);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content28', '2022-03-25 14:30:00', 'Title28', 4, 22);

INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content29', '2023-03-19 14:30:00', 'Title29', 5, 23);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content30', '2023-03-25 14:30:00', 'Title30', 5, 23);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content31', '2023-04-01 14:30:00', 'Title31', 5, 23);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content32', '2023-04-10 15:30:00', 'Title32', 5, 23);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content33', '2023-03-25 16:30:00', 'Title33', 5, 24);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content34', '2023-03-25 14:30:00', 'Title34', 5, 24);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content35', '2023-03-25 14:30:00', 'Title35', 5, 24);

INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content36', '2023-04-19 14:30:00', 'Title36', 6, 23);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content37', '2023-04-25 14:30:00', 'Title37', 6, 23);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content38', '2023-05-01 14:30:00', 'Title38', 6, 23);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content39', '2023-05-10 15:30:00', 'Title39', 6, 23);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content40', '2023-06-25 16:30:00', 'Title40', 6, 24);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content41', '2023-06-25 14:30:00', 'Title41', 6, 24);
INSERT INTO public.posts(attachment, "content", post_time, title, class_id, user_id) VALUES(NULL, 'Content42', '2023-07-25 14:30:00', 'Title42', 6, 24);

INSERT INTO public."comments" (attachment, "content", "time", post_id, user_id) VALUES(NULL, 'Comment1', '2022-03-19 14:35:00', 1, 2);
INSERT INTO public."comments" (attachment, "content", "time", post_id, user_id) VALUES(NULL, 'Comment2', '2022-03-19 14:35:06', 1, 3);
INSERT INTO public."comments" (attachment, "content", "time", post_id, user_id) VALUES(NULL, 'Comment3', '2022-03-19 14:36:00', 1, 4);

INSERT INTO public."comments" (attachment, "content", "time", post_id, user_id) VALUES(NULL, 'Comment4', '2022-03-25 15:30:00', 2, 2);
INSERT INTO public."comments" (attachment, "content", "time", post_id, user_id) VALUES(NULL, 'Comment5', '2022-03-25 16:30:00', 2, 3);
INSERT INTO public."comments" (attachment, "content", "time", post_id, user_id) VALUES(NULL, 'Comment6', '2022-03-25 17:30:00', 2, 4);

INSERT INTO public."comments" (attachment, "content", "time", post_id, user_id) VALUES(NULL, 'Comment7', '2023-03-19 14:31:00', 8, 6);
INSERT INTO public."comments" (attachment, "content", "time", post_id, user_id) VALUES(NULL, 'Comment8', '2023-03-19 14:35:00', 8, 7);

INSERT INTO public."comments" (attachment, "content", "time", post_id, user_id) VALUES(NULL, 'Comment9', '2023-03-25 14:32:00', 9, 8);
INSERT INTO public."comments" (attachment, "content", "time", post_id, user_id) VALUES(NULL, 'Comment10', '2023-03-25 14:33:00', 9, 9);

INSERT INTO public."comments" (attachment, "content", "time", post_id, user_id) VALUES(NULL, 'Comment11', '2023-04-01 14:33:00', 10, 8);
INSERT INTO public."comments" (attachment, "content", "time", post_id, user_id) VALUES(NULL, 'Comment12', '2023-04-01 14:33:00', 10, 10);
--
