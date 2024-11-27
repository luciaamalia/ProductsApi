create table users(

       id_user UUID PRIMARY KEY DEFAULT gen_random_uuid(),
       name VARCHAR(255),
       login VARCHAR(255) UNIQUE NOT NULL,
       phone VARCHAR(20),
       email VARCHAR(255) UNIQUE NOT NULL,
       password VARCHAR(255) NOT NULL,
       type_user VARCHAR(50),
       date_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
       date_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL

    primary key(id)

);