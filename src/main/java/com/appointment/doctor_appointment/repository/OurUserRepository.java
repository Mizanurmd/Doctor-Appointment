package com.appointment.doctor_appointment.repository;


import com.appointment.doctor_appointment.model.OurUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OurUserRepository extends JpaRepository<OurUser, Long> {

    @Query("SELECT u from OurUser u where u.email=:email")
    Optional<OurUser> findByEmail(String email);

}
