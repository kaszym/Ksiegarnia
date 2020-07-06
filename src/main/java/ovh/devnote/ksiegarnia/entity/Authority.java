package ovh.devnote.ksiegarnia.entity;

import javax.persistence.*;

@IdClass(AuthorityPK.class)
@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    private String username;

    @Id
    private String authority;

    @ManyToOne
    @JoinColumn(name = "username", updatable = false, insertable = false)
    private User user;

    public Authority() {
    }

    public Authority(User user, String authority) {
        this.username = user.getUsername();
        this.authority = authority;
        this.user = user;
    }

    public String getUsername() {
        return username;
    }
}