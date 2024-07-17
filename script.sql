CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `perfil` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `usuario_perfil` (
  `id_usuario` int NOT NULL,
  `id_perfil` int NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_perfil`),
  KEY `fk_usuario_perfil_perfil_idx` (`id_perfil`),
  CONSTRAINT `fk_usuario_perfil_perfil` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id`),
  CONSTRAINT `fk_usuario_perfil_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `curso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `categoria` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `topico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(200) DEFAULT NULL,
  `mensagem` varchar(500) DEFAULT NULL,
  `data_criacao` date DEFAULT NULL,
  `id_curso` int DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_curso_idx` (`id_curso`),
  KEY `fk_usuario_idx` (`id_usuario`),
  CONSTRAINT `fk_curso` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id`),
  CONSTRAINT `fk_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `resposta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_topico` int DEFAULT NULL,
  `mensagem` varchar(5000) DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  `solucao` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_topico_idx` (`id_topico`),
  KEY `fk_usuario_resposta_idx` (`id_usuario`),
  CONSTRAINT `fk_topico` FOREIGN KEY (`id_topico`) REFERENCES `topico` (`id`),
  CONSTRAINT `fk_usuario_resposta` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- senha = password
insert into usuario select 	1  ,	'Usuario','user@forumhub.com','$2a$10$fQgIPi2PROWyBckvIV/8DOI28M8tYY3oSyO5t7MLLPimsBL7yC.f2'  from dual;
