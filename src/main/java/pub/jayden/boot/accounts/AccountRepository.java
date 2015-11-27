package pub.jayden.boot.accounts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jaydenuk on 2015. 11. 27..
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
}
