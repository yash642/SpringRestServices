package com.cg.RestServices;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value="datajpa")
@Profile("prod")
public interface UserJpaRepository extends JpaRepository<User, Integer>, UserDao{

}
