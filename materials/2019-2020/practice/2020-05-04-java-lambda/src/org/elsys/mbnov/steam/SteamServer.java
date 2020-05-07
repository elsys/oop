package org.elsys.mbnov.steam;

import java.util.ArrayList;
import java.util.List;

public class SteamServer {
    public interface IQuery<T> {
        List<T> run(List<User> users, List<Game> games, List<Ownership> gameOwnership);
    }

    private List<User> users = new ArrayList<>();
    private List<Game> games = new ArrayList<>();
    private List<Ownership> gameOwnership = new ArrayList<>();

    public <T> List<T> query(IQuery query) {
        return query.run(users, games, gameOwnership);
    }

    public void addUser(User user) { users.add(user); }
    public void addGame(Game game) { games.add(game); }
    public void addOwnership(Ownership ownership) { gameOwnership.add(ownership); }
}
