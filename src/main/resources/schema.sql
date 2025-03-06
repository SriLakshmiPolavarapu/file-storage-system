create DATABASE file_storage_db;

use file_storage_db;

create table file_metadata (
    id int AUTO_INCREMENT PRIMARY KEY,
    filename VARCHAR(255),
    username VARCHAR(255),
    timestamp BIGINT
);