package pub.jayden.boot.accounts;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jaydenuk on 2015. 11. 27..
 */
@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String email;
    private String fullName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date joined;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
}
