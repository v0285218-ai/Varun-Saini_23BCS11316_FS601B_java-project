create table categories
(
    id   tinyint auto_increment
        primary key,
    name varchar(255) not null
);

create table products
(
    id          bigint auto_increment
        primary key,
    name        varchar(255)   not null,
    price       decimal(10, 2) not null,
    description longtext       not null,
    category_id tinyint        null,
    constraint fk_category
        foreign key (category_id) references categories (id)
);

create table users
(
    id       bigint auto_increment
        primary key,
    name     varchar(255) not null,
    email    varchar(255) not null,
    password varchar(255) not null
);

create table addresses
(
    id      bigint auto_increment
        primary key,
    street  varchar(255) not null,
    city    varchar(255) not null,
    state   varchar(255) not null,
    zip     varchar(255) not null,
    user_id bigint       not null,
    constraint addresses_users_id_fk
        foreign key (user_id) references users (id)
);

create table profiles
(
    id             bigint                   not null
        primary key,
    bio            longtext                 null,
    phone_number   varchar(15)              null,
    date_of_birth  date                     null,
    loyalty_points int unsigned default '0' null,
    constraint profiles_ibfk_1
        foreign key (id) references users (id)
);

create table wishlist
(
    product_id bigint not null,
    user_id    bigint not null,
    primary key (product_id, user_id),
    constraint fk_wishlist_on_product
        foreign key (product_id) references products (id)
            on delete cascade,
    constraint fk_wishlist_on_user
        foreign key (user_id) references users (id)
);

