CREATE TABLE IF NOT EXISTS blogdb.post(
        post_id INTEGER AUTO_INCREMENT PRIMARY KEY,
        title VARCHAR(255) NOT NULL,
        posted_text VARCHAR(255) NOT NULL,
        author_name VARCHAR(255) NOT NULL,
        post_time DATE

);