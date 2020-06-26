use job_finder;
create table role(
	id int primary key auto_increment,
    name varchar(50) not null unique
);

create table account(
	id int primary key auto_increment,
    username varchar(100) not null unique,
    password varchar(100) not null,
    email varchar(100) not null unique,
    isActive tinyint default 1,
    role_id int not null
);

create table address(
	id int primary key auto_increment,
    address_detail varchar(255) null,
    street varchar(255) null,
    district varchar(255) null,
    city varchar(255) null
);

create table full_name(
	id int primary key auto_increment,
    first_name varchar(255) not null,
    last_name varchar(255) not null
);

create table person(
	id int primary key auto_increment,
    gender varchar(20) null,
    phone varchar(20) null,
    full_name_id int not null,
    address_id int null,
    account_id int not null
);

create table admin(
	id int primary key not null,
    created_at datetime null
);

create table hr_manager(
	id int primary key not null,
    company_id int not null
);

create table company(
	id int primary key auto_increment,
    name varchar(255) not null
);

create table user(
	id int primary key not null,
    profile_id int null
);

create table vip_user(
	id int primary key not null,
    created_at datetime not null
);

create table profile(
	id int primary key auto_increment,
    avatar varchar(255) null,
    position varchar(255) null,
    description text null
);

create table education(
	id int primary key auto_increment,
    school varchar(255) null,
    start_at date null,
    end_at date null,
    description text null,
    profile_id int not null
);

create table work_experience(
	id int primary key auto_increment,
    company_name varchar(255) null,
    start_at date null,
    end_at date null,
    description text null,
    profile_id int not null
);

create table skill(
	id int primary key auto_increment,
    name varchar(255) null,
    point float null,
    description text null,
    profile_id int not null
);

create table certification(
	id int primary key auto_increment,
    name varchar(255) null,
    organization varchar(255) null,
    receive_time date null,
    profile_id int not null
);

create table prize(
	id int primary key auto_increment,
    name varchar(255) null,
    organization varchar(255) null,
    receive_time date null,
    profile_id int not null
);

create table project(
	id int primary key auto_increment,
    name varchar(255) null,
    customer varchar(255) null,
    position varchar(255) null,
    technology varchar(255) null,
    start_at date null,
    end_at date null,
    description text null,
    profile_id int not null
);

create table post(
	id int primary key auto_increment,
    job_name varchar(255) not null,
    company_id int not null,
    job_category_id int null,
    amount int null,
    min_salary double null,
    max_salary double null,
    experience varchar(255) null,
    description mediumtext null,
    requirement mediumtext null,
    benefit mediumtext null
);

create table job_category(
	id int primary key auto_increment,
    name varchar(255)  not null
);

create table recruitment_detail(
	id int primary key auto_increment,
    post_id int not null,
    user_id int not null,
    apply_at datetime not null,
    status varchar(255) not null
);

create table interview_schedule(
	id int primary key auto_increment,
    address text not null,
    interview_at datetime not null,
    recruitment_detail_id int not null
);