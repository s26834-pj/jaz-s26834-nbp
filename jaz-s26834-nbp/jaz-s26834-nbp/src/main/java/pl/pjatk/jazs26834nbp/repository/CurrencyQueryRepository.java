package pl.pjatk.jazs26834nbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.jazs26834nbp.model.CurrencyQuery;
@Repository
public interface CurrencyQueryRepository extends JpaRepository<CurrencyQuery, Long> {
}