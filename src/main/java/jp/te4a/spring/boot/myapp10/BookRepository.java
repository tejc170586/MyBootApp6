package jp.te4a.spring.boot.myapp10;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<BookBean, Integer>{

}
