/*Create three tables as follows. Use appropriate data types.
    ┌────────────────────────┐
    │          Exams         │
    ├─────────┬──────────────┤
    │ exam_id │ name         │
    ├─────────┼──────────────┤
    │ 101     │ Spring MVC   │
    ├─────────┼──────────────┤
    │ 102     │ Neo4j        │
    ├─────────┼──────────────┤
    │ 103     │ Oracle 11g   │
    └─────────┴──────────────┘
    ┌───────────────────┐
    │      Students     │
    ├────────────┬──────┤
    │ student_id │ name │
    ├────────────┼──────┤
    │ 1          │ Mila │
    ├────────────┼──────┤
    │ 2          │ Toni │
    ├────────────┼──────┤
    │ 3          │ Ron  │
    └────────────┴──────┘
    ┌──────────────────────┐
    │    Students_exam     │
    ├────────────┬─────────┤
    │ student_id │ exam_id │
    ├────────────┼─────────┤
    │ 1          │ 101     │
    ├────────────┼─────────┤
    │ 1          │ 102     │
    ├────────────┼─────────┤
    │ 2          │ 101     │
    ├────────────┼─────────┤
    │ 3          │ 103     │
    ├────────────┼─────────┤
    │ 2          │ 102     │
    ├────────────┼─────────┤
    │ 2          │ 103     │
    └────────────┴─────────┘
Insert the data from the example above.
•	Add primary and foreign keys.
•	Have in mind that the table student_exams should have a composite primary key.*/

CREATE TABLE students (
    student_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE exams (
    exam_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30)
);

CREATE TABLE students_exams (
    student_id INT,
    exam_id INT,
    PRIMARY KEY (student_id, exam_id),
    CONSTRAINT fk_student_id_students_student_id
        FOREIGN KEY (student_id)
            REFERENCES students(student_id),
    CONSTRAINT fk_exam_id_exams_exam_id
        FOREIGN KEY (exam_id)
            REFERENCES exams(exam_id)
);

INSERT INTO students (name) VALUES
    ('Mila'),
    ('Toni'),
    ('Ron');

INSERT INTO exams (exam_id, name) VALUES
    (101, 'Spring MVC'),
    (102, 'Neo4j'),
    (103, 'Oracle 11g');

INSERT INTO students_exams (student_id, exam_id) VALUES
    (1, 101),
    (1, 102),
    (2, 101),
    (3, 103),
    (2, 102),
    (2, 103);