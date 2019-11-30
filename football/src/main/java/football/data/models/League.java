package football.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity()
@Table(name = "leagues")
public class League extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "field", nullable = false)
    private String field;

    @Column(name = "rules", columnDefinition = "TEXT")
    private String rules;

    @Column(name = "taxes_and_rewards", columnDefinition = "TEXT")
    private String taxesAndRewards;

    @ManyToMany(targetEntity = Team.class, mappedBy = "leagues")
    private Set<Team> teams;

    @ManyToMany(targetEntity = Player.class, mappedBy = "leagues")
    private Set<Player> players;

}
