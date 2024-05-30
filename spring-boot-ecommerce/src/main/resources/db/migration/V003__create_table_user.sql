SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `user_profiles`;
DROP TABLE IF EXISTS `users`;

SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    birthday DATE NOT NULL,
    membro BOOLEAN NOT NULL
);

-- Criação da tabela 'user_profiles' para mapear o relacionamento muitos-para-muitos
CREATE TABLE user_profiles (
    user_id BIGINT NOT NULL,
    profile VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
