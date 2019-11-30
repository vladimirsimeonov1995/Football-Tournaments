package football.data.models;

import football.data.models.emuns.Color;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "team")
@Getter
@Setter
@NoArgsConstructor
public class Team extends BaseEntity{

    /**
     *     private String name;
     *     private Color shirtColor;
     *     private User manager;
     *     private Set<Player> players;
     *     private Set<League> leagues;
     */


    @Column(name = "name", updatable = true, unique = false, nullable = false)
    private String name;

    @Column(name = "shirt_color", updatable = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private Color shirtColor;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "username",
            referencedColumnName = "username")
    private User manager;

    @ManyToMany(targetEntity = Player.class, mappedBy = "teams")
    private Set<Player> players;

    @ManyToMany(targetEntity = League.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "leagues_teams",
            joinColumns = { @JoinColumn(name = "team_id", referencedColumnName = "id") } ,
            inverseJoinColumns = { @JoinColumn(name = "league_id", referencedColumnName = "id")}
    )
    private Set<League> leagues;
}
