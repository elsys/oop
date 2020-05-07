import org.elsys.mbnov.steam.*;
import org.elsys.mbnov.steam.SteamServer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        SteamServer s = new SteamServer();

        s.addUser(new User("1", "user1", "user1@elsys-bg.org"));
        s.addUser(new User("2", "user2", "user2@elsys-bg.org"));
        s.addUser(new User("3", "user3", "user3@elsys-bg.org"));

        s.addGame(new Game("1", "TestGame1", (float)29.99, Arrays.asList(new String[]{"story", "singleplayer"})));
        s.addGame(new Game("2", "TestGame2: Testing Again", (float)49.99, Arrays.asList(new String[]{"story", "singleplayer", "sandbox"})));
        s.addGame(new Game("3", "TestGame3: The Return of Test", (float)69.99, Arrays.asList(new String[]{"singleplayer", "multiplayer"})));

        s.addOwnership(new Ownership("1", "1", "2020-04-20"));
        s.addOwnership(new Ownership("1", "2", "2020-04-20"));
        s.addOwnership(new Ownership("2", "2", "2020-04-20"));
        s.addOwnership(new Ownership("3", "3", "2020-04-20"));

        findUserIdByUsername(s, "user1");
        System.out.println();
        findUserIdByUsername(s, "user2");
        System.out.println();
        findUserIdByUsername(s, "user7");
        System.out.println();

        findGamesByTitleContent(s, "Test");
        System.out.println();
        findGamesByTitleContent(s, "Return");
        System.out.println();
        findGamesByTitleContent(s, "Megatest");
        System.out.println();

        findGamesByFeatures(s, new String[]{"singleplayer", "story"});
        System.out.println();
        findGamesByFeatures(s, new String[]{"multiplayer"});
        System.out.println();
        findGamesByFeatures(s, new String[]{"multiplayer", "sandbox"});
        System.out.println();

        findGamesOwnedByUser(s, "1");
        System.out.println();
        findGamesOwnedByUser(s, "3");
        System.out.println();
        findGamesOwnedByUser(s, "7");
        System.out.println();
    }

    private static void findUserIdByUsername(SteamServer s, String searchUsername) {
        System.out.println("Find the ID of the user with username \"" + searchUsername + "\"");

        List<User> found = s.query((SteamServer.IQuery<String>) (users, games, gameOwnership) -> {
            for (User user : users) {
                if(user.username == searchUsername) {
                    return Arrays.asList(new String[]{user.id});
                }
            }
            return null;
        });

        if(found != null) {
            System.out.println(found.get(0));
        } else {
            System.out.println("User not found!");
        }
    }

    private static void findGamesByTitleContent(SteamServer s, String searchTitle) {
        System.out.println("Find games with titles containing \"" + searchTitle + "\"");

        List<Game> foundGames = s.query((SteamServer.IQuery<Game>) (users, games, gameOwnership) -> {
            List<Game> found = new ArrayList<>();
            for (Game game : games) {
                if(game.title.contains(searchTitle)) found.add(game);
            }
            return found;
        });

        if(foundGames.size() > 0) {
            for (Game foundGame : foundGames) {
                System.out.println(foundGame);
            }
        } else {
            System.out.println("No games found!");
        }
    }

    private static void findGamesByFeatures(SteamServer s, String[] searchFeaturesArray) {
        // Convert to a List since it has an implemented toString method
        System.out.println("Find games with these features \"" + Arrays.asList(searchFeaturesArray) + "\"");

        List<Game> foundGames = s.query((SteamServer.IQuery<Game>) (users, games, gameOwnership) -> {
            List<Game> found = new ArrayList<>();
            for (Game game : games) {
                if(game.features.containsAll(new ArrayList<String>(Arrays.asList(searchFeaturesArray)))) {
                    found.add(game);
                }
            }
            return found;
        });

        if(foundGames.size() > 0) {
            for (Game foundGame : foundGames) {
                System.out.println(foundGame);
            }
        } else {
            System.out.println("No games found!");
        }
    }

    private static void findGamesOwnedByUser(SteamServer s, String userId) {
        System.out.println("Find games owned by user with ID \"" + userId + "\"");

        // You can split the logic into separate query calls or combine it into a single lambda.
        /*List<String> ownedGameIds = s.query((SteamServer.IQuery<String>) (users, games, gameOwnership) -> {
            List<String> found = new ArrayList<>();
            for (Ownership ownership : gameOwnership) {
                if(ownership.userId == userId) {
                    found.add(ownership.gameId);
                }
            }

            return found;
        });

        List<Game> foundGames = s.query((SteamServer.IQuery<Game>) (users, games, gameOwnership) -> {
            List<Game> found = new ArrayList<>();
            for (Game game : games) {
                if(ownedGameIds.contains(game.id)) {
                    found.add(game);
                }
            }

            return found;
        });
         */

        List<Game> foundGames = s.query((SteamServer.IQuery<Game>) (users, games, gameOwnership) -> {
            List<String> ownedGameIds = new ArrayList<>();
            for (Ownership ownership : gameOwnership) {
                if(ownership.userId == userId) {
                    ownedGameIds.add(ownership.gameId);
                }
            }

            List<Game> found = new ArrayList<>();

            for (Game game : games) {
                if(ownedGameIds.contains(game.id)) {
                    found.add(game);
                }
            }

            return found;
        });

        if(foundGames.size() > 0) {
            for (Game foundGame : foundGames) {
                System.out.println(foundGame);
            }
        } else {
            System.out.println("No games found!");
        }
    }
}
