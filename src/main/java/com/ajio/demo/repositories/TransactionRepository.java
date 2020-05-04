package com.ajio.demo.repositories;
import com.ajio.demo.model.Transaction_History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction_History,Integer> {
    List<Transaction_History> findAllByuserId(String userId);


}
