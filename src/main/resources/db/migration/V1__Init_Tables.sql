# create table car
# (
#     id                         bigint  not null auto_increment,
#     acceleration               float   not null,
#     body_type                  varchar(255),
#     combined_fuel_cons         float   not null,
#     drive_type                 varchar(255),
#     engine_displacement        integer not null,
#     fuel_cons_in_the_city      float   not null,
#     fuel_cons_outside_the_city float   not null,
#     fuel_tank_volume           float   not null,
#     fuel_type                  varchar(255),
#     height                     float   not null,
#     interior                   varchar(255),
#     length                     float   not null,
#     max_speed                  integer not null,
#     model                      varchar(255),
#     number_of_doors            integer not null,
#     payload                    float   not null,
#     places                     integer not null,
#     power                      integer not null,
#     price                      varchar(255),
#     transmission               integer not null,
#     type_of_transmission       varchar(255),
#     weight                     float   not null,
#     year_of_manufacture        integer not null,
#     primary key (id)
# );
# create table deal
# (
#     id            bigint not null auto_increment,
#     creating_date datetime(6),
#     status        varchar(255),
#     car_id        bigint not null,
#     user_id       bigint not null,
#     primary key (id)
# );
# create table form
# (
#     id           bigint not null auto_increment,
#     city         varchar(255),
#     country      varchar(255),
#     phone_number varchar(255),
#     user_id      bigint not null,
#     primary key (id)
# );
# create table role
# (
#     id   bigint not null auto_increment,
#     name varchar(255),
#     primary key (id)
# );
# create table user
# (
#     id         bigint       not null auto_increment,
#     age        integer      not null,
#     first_name varchar(20)  not null,
#     last_name  varchar(20)  not null,
#     login      varchar(255) not null,
#     password   varchar(255) not null,
#     primary key (id)
# );
# create table user_role
# (
#     user_id bigint not null,
#     role_id bigint not null
# );
# alter table deal
#     add constraint FKgfyi7pj871ijqm5ovvus2d9vo foreign key (car_id) references car (id);
# alter table deal
#     add constraint FKlrkitlk0jhhid7vo4irsy4f50 foreign key (user_id) references user (id);
# alter table form
#     add constraint FKsniuo4i0n35d0lw0pjlc2iqwe foreign key (user_id) references user (id);
# alter table user_role
#     add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id);
# alter table user_role
#     add constraint FK859n2jvi8ivhui0rl0esws6o foreign key (user_id) references user (id);

create table car
(
    id                         bigint  not null auto_increment,
    acceleration               float   not null,
    body_type                  varchar(255),
    combined_fuel_cons         float   not null,
    drive_type                 varchar(255),
    engine_displacement        integer not null,
    fuel_cons_in_the_city      float   not null,
    fuel_cons_outside_the_city float   not null,
    fuel_tank_volume           float   not null,
    fuel_type                  varchar(255),
    height                     float   not null,
    interior                   varchar(255),
    length                     float   not null,
    max_speed                  integer not null,
    model                      varchar(255),
    number_of_doors            integer not null,
    payload                    float   not null,
    places                     integer not null,
    power                      integer not null,
    price                      varchar(255),
    transmission               integer not null,
    type_of_transmission       varchar(255),
    weight                     float   not null,
    year_of_manufacture        integer not null,
    primary key (id)
);
create table deal
(
    id            bigint not null auto_increment,
    creating_date datetime(6),
    status        varchar(255),
    form_id       bigint,
    primary key (id)
);
create table form
(
    id           bigint not null auto_increment,
    city         varchar(255),
    country      varchar(255),
    phone_number varchar(255),
    car_id       bigint not null,
    user_id      bigint not null,
    primary key (id)
);
create table role
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
);
create table user
(
    id         bigint       not null auto_increment,
    age        integer      not null,
    first_name varchar(20)  not null,
    last_name  varchar(20)  not null,
    login      varchar(255) not null,
    password   varchar(255) not null,
    primary key (id)
);
create table user_role
(
    user_id bigint not null,
    role_id bigint not null
);
alter table deal
    add constraint deal_form_fk foreign key (form_id) references form (id);
alter table form
    add constraint form_car_fk foreign key (car_id) references car (id);
alter table form
    add constraint form_user_fk foreign key (user_id) references user (id);
alter table user_role
    add constraint user_role_role_fk foreign key (role_id) references role (id);
alter table user_role
    add constraint user_role_user_fk foreign key (user_id) references user (id);