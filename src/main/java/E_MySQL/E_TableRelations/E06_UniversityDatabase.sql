-- Create a new database and design the following structure.

CREATE TABLE majors (
    major_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE students (
    student_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_number VARCHAR(12) NOT NULL,
    student_name VARCHAR(50) NOT NULL,
    major_id INT,
    CONSTRAINT fk_major_id_majors
        FOREIGN KEY (major_id)
            REFERENCES majors(major_id)
);

CREATE TABLE payments (
    payment_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    payment_date DATE,
    payment_amount DECIMAL(8,2),
    student_id INT NOT NULL,
    CONSTRAINT fk_student_id_students
        FOREIGN KEY (student_id)
            REFERENCES students(student_id)
);

CREATE TABLE subjects (
    subject_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    subject_name VARCHAR(50) NOT NULL
);

CREATE TABLE agenda(
    student_id INT NOT NULL,
    subject_id INT NOT NULL,
    PRIMARY KEY (student_id, subject_id),
    CONSTRAINT fk_agenda_student_id_students
        FOREIGN KEY (student_id)
            REFERENCES students(student_id),
    CONSTRAINT fk_agenda_subject_id_subjects
        FOREIGN KEY (subject_id)
            REFERENCES subjects(subject_id)
);