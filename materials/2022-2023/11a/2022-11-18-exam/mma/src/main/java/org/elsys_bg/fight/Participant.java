package org.elsys_bg.fight;

public abstract class Participant {
    private int id;
    private String name;
    protected int power;
    private double health;
    private double maxHealth;

    public Participant(String name, int power, double health) {
        if(power < 10 || power > 100) {
            throw new IllegalArgumentException("Power must be between 10 and 100");
        }

        if(health < 1 || health > 500) {
            throw new IllegalArgumentException("Healt must be between 0 and 500");
        }
        this.name = name;
        this.power = power;
        this.maxHealth = health;
        this.health = health;
    }

    public void takeDamage(double damage) {
        health -= damage;
        System.out.println(this + " took " + damage + "damage");
    }

    public boolean isKnockedOut() {
        return health <= 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void resetHealth() {
        health = maxHealth;
    }

    public abstract void attack(Participant participant);

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    double geHealth() {
        return health;
    }

    public int getId() {
        return id;
    }

    public double getMaxHealth() {
        return maxHealth;
    }
}
