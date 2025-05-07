create database student_management;
use student_management;

create table admin(
	id int not null identity (1,1),
	username nvarchar(45) not null,
	password nvarchar(45) not null,
	constraint PK_ADMIN primary key (id)
	);

create table student(
	id int not null identity (1,1),
	name nvarchar(150) not null,
	date_of_birth date not null,
	gender nvarchar(10) not null,
	email varchar(100) not null,
	phone varchar(15) not null,
	father_name nvarchar(150) not null,
	mother_name nvarchar(150) not null,
	address1 NVARCHAR(MAX) not null,
	address2 NVARCHAR(MAX) not null,
	image_path nvarchar(200) null,
	constraint PK_STUDENT primary key (id)
	);

create table course(
	id int not null identity (1,1),
	student_id int,
	semester int,
	course1 nvarchar(200),
	course2 nvarchar(200),
	course3 nvarchar(200),
	course4 nvarchar(200),
	course5 nvarchar(200),
	constraint PK_COURSE primary key (id),
	constraint FK_STUDENT_ID foreign key (student_id) references student (id) on delete cascade
	);
create index FK_STUDENT_ID on course (student_id);

create table score(
	id int not null identity(1,1),
	student_id int not null,
	semester int not null,
	course1 nvarchar(200) not null,
	score1 numeric(5,2) not null, -- (-999.99 to 999.99)
	(-- numeric (6,2) -9999.99 to 9999.99)
	course2 nvarchar(200) not null,
	score2 numeric(5,2) not null,
	course3 nvarchar(200) not null,
	score3 numeric(5,2) not null,
	course4 nvarchar(200) not null,
	score4 numeric(5,2) not null,
	course5 nvarchar(200) not null,
	score5 numeric(5,2) not null,
	average numeric(5,2) not null,
	constraint PK_SCORE primary key (id),
	constraint FK_STU_ID foreign key (student_id) references student (id) on delete cascade
	);
create index FK_STU_ID on score (student_id);