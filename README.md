# 베타 테스터 매칭 플랫폼 프로젝트 

## 프로젝트에 대한 간단한 설명
https://www.notion.so/Capstone-9f4a1ff47671440390568a48f61ee368

## 프로젝트에 적용될 기술
- Java
  - SpringBoot
- Postgres
- Vue.js

## 도커 기반 데이터베이스 설정
```text
docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=1q2w3e4r -d postgres
```
- 데이터베이스 정보
  - hostname : localhost
  - username : postgres
  - password : 123
  - database : postgres

## 데이터 베이스 구조
```sql
CREATE TABLE category
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL UNIQUE
);

CREATE TABLE grade
(
    id                     SERIAL PRIMARY KEY,
    name                   VARCHAR NOT NULL UNIQUE,
    available_quest_amount BIGINT  NOT NULL
);

CREATE TABLE quest_maker
(
    id            SERIAL PRIMARY KEY,
    email         VARCHAR                  NOT NULL UNIQUE,
    password      VARCHAR                  NOT NULL,
    nickname      VARCHAR                  NOT NULL UNIQUE,
    phone_number  TEXT                     NOT NULL UNIQUE,
    register_time TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE tester
(
    id                 SERIAL PRIMARY KEY,
    email              VARCHAR                  NOT NULL UNIQUE,
    password           VARCHAR                  NOT NULL,
    nickname           VARCHAR                  NOT NULL UNIQUE,
    phone_number       TEXT                     NOT NULL UNIQUE,
    prefer_category_id INT,
    intro_message      TEXT,
    intro_picture_ref  VARCHAR,
    grade_id           BIGINT                   NOT NULL,
    register_time      TIMESTAMP WITH TIME ZONE NOT NULL,
    FOREIGN KEY (prefer_category_id) REFERENCES category (id),
    FOREIGN KEY (grade_id) REFERENCES GRADE (id)
);

CREATE TABLE quest
(
    id                     SERIAL PRIMARY KEY,
    title                  VARCHAR,
    content                TEXT,
    category_id            BIGINT                   NOT NULL,
    quest_maker_id         BIGINT                   NOT NULL,
--  register_time 은 동작중에 만들어질 수 있는 모든 table 이 필요로 함.
    register_time          TIMESTAMP WITH TIME ZONE NOT NULL,
    recruitment_time_start TIMESTAMP WITH TIME ZONE NOT NULL,
    recruitment_time_limit TIMESTAMP WITH TIME ZONE NOT NULL,
    duration_time_start    TIMESTAMP WITH TIME ZONE NOT NULL,
    duration_time_limit    TIMESTAMP WITH TIME ZONE NOT NULL,
    modify_time_start      TIMESTAMP WITH TIME ZONE NOT NULL,
    modify_time_limit      TIMESTAMP WITH TIME ZONE NOT NULL,
    participant_capacity   BIGINT                   NOT NULL,
    reward                 BIGINT                   NOT NULL,
    require_condition      VARCHAR,
    preference_condition   VARCHAR,
    FOREIGN KEY (category_id) REFERENCES category (id),
    FOREIGN KEY (quest_maker_id) REFERENCES quest_maker (id)
);

CREATE TABLE apply
(
    id                              SERIAL PRIMARY KEY,
    register_time                   TIMESTAMP WITH TIME ZONE NOT NULL,
    permission_time                 TIMESTAMP WITH TIME ZONE,
    tester_id                       BIGINT                   NOT NULL,
    quest_id                        BIGINT                   NOT NULL,
    require_condition_submit_ref    VARCHAR,
    preference_condition_submit_ref VARCHAR,
    FOREIGN KEY (tester_id) REFERENCES tester (id),
    FOREIGN KEY (quest_id) REFERENCES quest (id)
);

CREATE TABLE submit
(
    id            SERIAL PRIMARY KEY,
    register_time timestamp WITH TIME ZONE NOT NULL,
    report_time   TIMESTAMP WITH TIME ZONE,
    tester_id     BIGINT                   NOT NULL,
    quest_id      BIGINT                   NOT NULL,
    FOREIGN KEY (tester_id) REFERENCES tester (id),
    FOREIGN KEY (quest_id) REFERENCES quest (id)
);

CREATE TABLE task
(
    id               SERIAL PRIMARY KEY,
    task_number      BIGINT  NOT NULL,
    quest_id         BIGINT  NOT NULL,
    title            VARCHAR NOT NULL,
    task_example_ref VARCHAR,
    require          TEXT    NOT NULL,
    FOREIGN KEY (quest_id) REFERENCES quest (id),
    UNIQUE (task_number, quest_id)
);

CREATE TABLE task_submit
(
    submit_id       BIGINT  NOT NULL,
    task_id         BIGINT  NOT NULL,
    file_submit_ref VARCHAR NOT NULL,
    is_pass         BOOL,
    primary key (task_id, submit_id),
    FOREIGN KEY (submit_id) REFERENCES submit (id),
    FOREIGN KEY (task_id) REFERENCES task (id)
);

CREATE TABLE auth
(
    id        SERIAL PRIMARY KEY,
    submit_id BIGINT  NOT NULL UNIQUE,
    status    BIGINT  NOT NULL,
    comment   VARCHAR NOT NULL,
    FOREIGN KEY (submit_id) REFERENCES submit (id)
);

CREATE TABLE evaluation
(
    auth_id    SERIAL PRIMARY KEY,
    star_point BIGINT  NOT NULL,
    comment    VARCHAR NOT NULL,
    FOREIGN KEY (auth_id) REFERENCES auth (id)
);

CREATE TABLE report_policy
(
    id       SERIAL PRIMARY KEY,
    category VARCHAR NOT NULL UNIQUE,
    content  VARCHAR NOT NULL,
    penalty  BIGINT  NOT NULL
);

CREATE TABLE tester_report
(
    id            SERIAL PRIMARY KEY,
    apply_id      BIGINT                   NOT NULL,
    report_id     BIGINT                   NOT NULL,
    title         VARCHAR                  NOT NULL,
    register_time TIMESTAMP WITH TIME ZONE NOT NULL,
    result        BOOL,
    FOREIGN KEY (apply_id) REFERENCES apply (id),
    FOREIGN KEY (report_id) REFERENCES report_policy (id)
);

CREATE TABLE quest_maker_report
(
    id            SERIAL PRIMARY KEY,
    apply_id      BIGINT                   NOT NULL,
    report_id     BIGINT                   NOT NULL,
    title         VARCHAR                  NOT NULL,
    register_time TIMESTAMP WITH TIME ZONE NOT NULL,
    result        BOOL,
    FOREIGN KEY (apply_id) REFERENCES apply (id),
    FOREIGN KEY (report_id) REFERENCES report_policy (id)
);

```