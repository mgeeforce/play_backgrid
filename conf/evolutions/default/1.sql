# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table detail (
  id                        bigint auto_increment not null,
  detail_date               datetime,
  inventory                 integer,
  price                     decimal(9,2),
  item_id                   bigint,
  created                   datetime not null,
  updated                   datetime not null,
  constraint pk_detail primary key (id))
;

create table item (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  description               varchar(255),
  date                      datetime,
  quantity                  integer,
  amount                    decimal(9,2),
  created                   datetime not null,
  updated                   datetime not null,
  constraint pk_item primary key (id))
;

alter table detail add constraint fk_detail_item_1 foreign key (item_id) references item (id) on delete restrict on update restrict;
create index ix_detail_item_1 on detail (item_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table detail;

drop table item;

SET FOREIGN_KEY_CHECKS=1;

