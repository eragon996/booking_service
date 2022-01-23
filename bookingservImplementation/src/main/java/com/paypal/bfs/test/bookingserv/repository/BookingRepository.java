package com.paypal.bfs.test.bookingserv.repository;

import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

     @Query("select t from BookingEntity t where (first_name = :firstName and last_name = :lastName)")
     BookingEntity findByFirstAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
