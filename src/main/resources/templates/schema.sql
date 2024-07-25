create table security_question (q_id integer not null, question varchar(255), primary key (q_id))
create table user_db (id integer not null, answer varchar(255), password varchar(255), q_id integer not null, username varchar(255), primary key (id))
