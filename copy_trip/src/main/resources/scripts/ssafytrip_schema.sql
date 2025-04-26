-- MySQL Workbench Forward Engineering
CREATE
DATABASE ssafytrip;
use
ssafytrip;
SET
@OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET
@OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET
@OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ssafytrip
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ssafytrip
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ssafytrip` DEFAULT CHARACTER SET utf8;
-- -----------------------------------------------------
-- Schema ssafytrip
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ssafytrip
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ssafytrip` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE
`ssafytrip` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`user`
(
    `no`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `id`
    VARCHAR
(
    45
) NOT NULL,
    `password` VARCHAR
(
    100
) NOT NULL,
    `user_name` VARCHAR
(
    45
) NULL,
    `email` VARCHAR
(
    50
) NOT NULL,
    `nickname` VARCHAR
(
    45
) NOT NULL,
    `image` VARCHAR
(
    100
) NULL,
    `authority` ENUM
(
    "admin",
    "none"
) NULL DEFAULT 'none',
    PRIMARY KEY
(
    `no`
),
    UNIQUE INDEX `user_id_UNIQUE`
(
    `id`
    ASC
) VISIBLE,
    UNIQUE INDEX `email_UNIQUE`
(
    `email`
    ASC
) VISIBLE,
    UNIQUE INDEX `nickname_UNIQUE`
(
    `nickname`
    ASC
) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ssafytrip`.`sidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`sidos`
(
    `no`
    INT
    NOT
    NULL
    AUTO_INCREMENT
    COMMENT
    '시도번호',
    `sido_code`
    INT
    NOT
    NULL
    COMMENT
    '시도코드',
    `sido_name`
    VARCHAR
(
    20
) NULL DEFAULT NULL COMMENT '시도이름',
    PRIMARY KEY
(
    `no`
),
    UNIQUE
(
    `sido_code`
)
    )
    ENGINE = InnoDB
    AUTO_INCREMENT = 35
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci
    COMMENT = '시도정보테이블';



-- -----------------------------------------------------
-- Table `ssafytrip`.`guguns`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`guguns`
(
    `no`
    INT
    NOT
    NULL
    AUTO_INCREMENT
    COMMENT
    '구군번호',
    `sido_code`
    INT
    NOT
    NULL
    COMMENT
    '시도코드',
    `gugun_code`
    INT
    NOT
    NULL
    COMMENT
    '구군코드',
    `gugun_name`
    VARCHAR
(
    20
) NULL DEFAULT NULL COMMENT '구군이름',
    PRIMARY KEY
(
    `no`
),
    UNIQUE
(
    `gugun_code`
), -- 👈 이 줄 추가
    INDEX `guguns_sido_to_sidos_cdoe_fk_idx`
(
    `sido_code`
    ASC
) VISIBLE,
    CONSTRAINT `guguns_sido_to_sidos_cdoe_fk`
    FOREIGN KEY
(
    `sido_code`
)
    REFERENCES `ssafytrip`.`sidos`
(
    `sido_code`
)
    )
    ENGINE = InnoDB
    AUTO_INCREMENT = 469
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci
    COMMENT = '구군정보테이블';



-- -----------------------------------------------------
-- Table `ssafytrip`.`contenttypes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`contenttypes`
(
    `content_type_id`
    INT
    NOT
    NULL
    COMMENT
    '콘텐츠타입번호',
    `content_type_name`
    VARCHAR
(
    45
) NULL DEFAULT NULL COMMENT '콘텐츠타입이름',
    PRIMARY KEY
(
    `content_type_id`
))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci
    COMMENT = '콘텐츠타입정보테이블';


-- -----------------------------------------------------
-- Table `ssafytrip`.`attractions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`attractions`
(
    `no`
    INT
    NOT
    NULL
    AUTO_INCREMENT
    COMMENT
    '명소코드',
    `content_id`
    INT
    NULL
    DEFAULT
    NULL
    COMMENT
    '콘텐츠번호',
    `title`
    VARCHAR
(
    500
) NULL DEFAULT NULL COMMENT '명소이름',
    `content_type_id` INT NULL DEFAULT NULL COMMENT '콘텐츠타입',
    `area_code` INT NULL DEFAULT NULL COMMENT '시도코드',
    `si_gun_gu_code` INT NULL DEFAULT NULL COMMENT '구군코드',
    `first_image1` VARCHAR
(
    100
) NULL DEFAULT NULL COMMENT '이미지경로1',
    `first_image2` VARCHAR
(
    100
) NULL DEFAULT NULL COMMENT '이미지경로2',
    `map_level` INT NULL DEFAULT NULL COMMENT '줌레벨',
    `latitude` DECIMAL
(
    20,
    17
) NULL DEFAULT NULL COMMENT '위도',
    `longitude` DECIMAL
(
    20,
    17
) NULL DEFAULT NULL COMMENT '경도',
    `tel` VARCHAR
(
    20
) NULL DEFAULT NULL COMMENT '전화번호',
    `addr1` VARCHAR
(
    100
) NULL DEFAULT NULL COMMENT '주소1',
    `addr2` VARCHAR
(
    100
) NULL DEFAULT NULL COMMENT '주소2',
    `homepage` VARCHAR
(
    1000
) NULL DEFAULT NULL COMMENT '홈페이지',
    `overview` VARCHAR
(
    10000
) NULL DEFAULT NULL COMMENT '설명',
    PRIMARY KEY
(
    `no`
),
    INDEX `attractions_typeid_to_types_typeid_fk_idx`
(
    `content_type_id`
    ASC
) VISIBLE,
    INDEX `attractions_sido_to_sidos_code_fk_idx`
(
    `area_code`
    ASC
) VISIBLE,
    INDEX `attractions_sigungu_to_guguns_gugun_fk_idx`
(
    `si_gun_gu_code`
    ASC
) VISIBLE,
    CONSTRAINT `attractions_area_to_sidos_code_fk`
    FOREIGN KEY
(
    `area_code`
)
    REFERENCES `ssafytrip`.`sidos`
(
    `sido_code`
),
    CONSTRAINT `attractions_sigungu_to_guguns_gugun_fk`
    FOREIGN KEY
(
    `si_gun_gu_code`
)
    REFERENCES `ssafytrip`.`guguns`
(
    `gugun_code`
),
    CONSTRAINT `attractions_typeid_to_types_typeid_fk`
    FOREIGN KEY
(
    `content_type_id`
)
    REFERENCES `ssafytrip`.`contenttypes`
(
    `content_type_id`
))
    ENGINE = InnoDB
    AUTO_INCREMENT = 107559
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci
    COMMENT = '명소정보테이블';


-- -----------------------------------------------------
-- Table `ssafytrip`.`preferred_attraction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`preferred_attraction`
(
    `user_no`
    INT
    NOT
    NULL,
    `attractions_no`
    INT
    NOT
    NULL,
    INDEX
    `fk_preferred_attraction_user_idx`
(
    `user_no`
    ASC
) VISIBLE,
    INDEX `fk_preferred_attraction_attractions1_idx`
(
    `attractions_no`
    ASC
) VISIBLE,
    CONSTRAINT `fk_preferred_attraction_user`
    FOREIGN KEY
(
    `user_no`
)
    REFERENCES `ssafytrip`.`user`
(
    `no`
)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_preferred_attraction_attractions1`
    FOREIGN KEY
(
    `attractions_no`
)
    REFERENCES `ssafytrip`.`attractions`
(
    `no`
)
    ON DELETE CASCADE
    ON UPDATE RESTRICT)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ssafytrip`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`board`
(
    `no`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `user_no`
    INT
    NOT
    NULL,
    `title`
    VARCHAR
(
    100
) NOT NULL,
    `content` TEXT NULL,
    `release_date` DATE NULL,
    PRIMARY KEY
(
    `no`
),
    INDEX `fk_board_user1_idx`
(
    `user_no`
    ASC
) VISIBLE,
    CONSTRAINT `fk_board_user1`
    FOREIGN KEY
(
    `user_no`
)
    REFERENCES `ssafytrip`.`user`
(
    `no`
)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ssafytrip`.`notice_board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`notice_board`
(
    `no`
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    `title`
    VARCHAR
(
    100
) NOT NULL,
    `content` TEXT NULL,
    `release_date` DATE NULL,
    PRIMARY KEY
(
    `no`
))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ssafytrip`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`review`
(
    `attractions_no`
    INT
    NOT
    NULL,
    `user_no`
    INT
    NOT
    NULL,
    `rating`
    TINYINT
(
    1
) NOT NULL,
    `comment` VARCHAR
(
    100
) NULL,
    `release_date` DATE NOT NULL,
    INDEX `fk_review_attractions1_idx`
(
    `attractions_no`
    ASC
) VISIBLE,
    INDEX `fk_review_user1_idx`
(
    `user_no`
    ASC
) VISIBLE,
    CONSTRAINT `fk_review_attractions1`
    FOREIGN KEY
(
    `attractions_no`
)
    REFERENCES `ssafytrip`.`attractions`
(
    `no`
)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `fk_review_user1`
    FOREIGN KEY
(
    `user_no`
)
    REFERENCES `ssafytrip`.`user`
(
    `no`
)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`comment`
(
    `board_no`
    INT
    NOT
    NULL,
    `user_no`
    INT
    NOT
    NULL,
    `content`
    VARCHAR
(
    500
) NOT NULL,
    `release_date` DATE NOT NULL,
    INDEX `fk_comment_board1_idx`
(
    `board_no`
    ASC
) VISIBLE,
    INDEX `fk_comment_user1_idx`
(
    `user_no`
    ASC
) VISIBLE,
    CONSTRAINT `fk_comment_board1`
    FOREIGN KEY
(
    `board_no`
)
    REFERENCES `ssafytrip`.`board`
(
    `no`
)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `fk_comment_user1`
    FOREIGN KEY
(
    `user_no`
)
    REFERENCES `ssafytrip`.`user`
(
    `no`
)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`preferred_plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafytrip`.`preferred_plan`
(
    `user_no`
    INT
    NOT
    NULL,
    `plans`
    VARCHAR
(
    100
) NULL,
    INDEX `fk_preferred_plan_user1_idx`
(
    `user_no`
    ASC
) VISIBLE,
    CONSTRAINT `fk_preferred_plan_user1`
    FOREIGN KEY
(
    `user_no`
)
    REFERENCES `ssafytrip`.`user`
(
    `no`
)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB;

USE
`ssafytrip` ;

SET
SQL_MODE=@OLD_SQL_MODE;
SET
FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET
UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
