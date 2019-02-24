package com.hendisantika.springbootstudentcrud.repository;

import com.hendisantika.springbootstudentcrud.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-student-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-02-24
 * Time: 14:09
 */
public interface GuideRepository extends JpaRepository<Guide, Long> {
}