package ca.clubFinder.club;

import ca.clubFinder.user.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Club {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name="userId", nullable=false)
    @OnDelete(action=OnDeleteAction.CASCADE)
    private User user;
}
