package football.data.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {

    private String name;
    private String shirtColor;
    private User manager;
    private List<Player> players;

    public Team() {
    }

    @Column(name = "name", updatable = true, unique = false, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "shirt_color", updatable = true, nullable = false)
    public String getShirtColor() {
        return shirtColor;
    }

    public void setShirtColor(String shirtColor) {
        this.shirtColor = shirtColor;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "username",
                referencedColumnName = "username")
    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    @ManyToMany(targetEntity = Player.class)
    @JoinTable(name = "teams_players",
            joinColumns = { @JoinColumn(name = "team_id", referencedColumnName = "id") } ,
            inverseJoinColumns = { @JoinColumn(name = "player_egn", referencedColumnName = "egn")}
    )
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
