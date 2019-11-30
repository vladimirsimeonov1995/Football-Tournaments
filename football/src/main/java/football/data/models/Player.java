package football.data.models;

import football.data.models.emuns.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "players")
@NoArgsConstructor
@Getter
@Setter
public class Player extends BaseEntity{

    @Column(name = "first_name", nullable = false, updatable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false, updatable = false)
    private String lastName;

    @Column(name = "personal_id_number", nullable = false, updatable = false, unique = true)
    private String personalIdNumber;

    @Column(name = "position", nullable = false)
    @Enumerated(EnumType.STRING)
    private Position position;

    @ManyToMany(targetEntity = Team.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "teams_players",
            joinColumns = { @JoinColumn(name = "player_PID", referencedColumnName = "personal_id_number") } ,
            inverseJoinColumns = { @JoinColumn(name = "team_id", referencedColumnName = "id")}
    )
    private Set<Team> teams;

    @ManyToMany(targetEntity = League.class)
    @JoinTable(
            name = "leagues_players",
            joinColumns = @JoinColumn(name = "player_PID", referencedColumnName = "personal_id_number"),
            inverseJoinColumns = @JoinColumn(name = "league_id", referencedColumnName = "id")
    )
    private Set<League> leagues;

}
