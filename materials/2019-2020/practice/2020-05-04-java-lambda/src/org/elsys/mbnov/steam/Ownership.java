package org.elsys.mbnov.steam;

public class Ownership {
    public String userId;
    public String gameId;
    public String boughtDate;

    public Ownership(String userId, String gameId, String boughtDate) {
        this.userId = userId;
        this.gameId = gameId;
        this.boughtDate = boughtDate;
    }

    @Override
    public String toString() {
        return "Ownership{" +
                "userId='" + userId + '\'' +
                ", gameId='" + gameId + '\'' +
                ", boughtDate='" + boughtDate + '\'' +
                '}';
    }
}
