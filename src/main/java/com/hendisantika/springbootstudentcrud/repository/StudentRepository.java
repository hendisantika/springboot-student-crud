package com.hendisantika.springbootstudentcrud.repository;

import com.hendisantika.springbootstudentcrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-student-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-02-24
 * Time: 14:10
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByName(String name);

}