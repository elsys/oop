package org.elsys.oop.exam1.unit;

import org.elsys.oop.exam1.Point;

public abstract class BaseUnit {
    protected String name;
    protected float speed;
    protected Point pos;
    protected int maxHp;
    protected int currHp;

    private Point moveTarget;

    public BaseUnit(String name, float speed, Point pos, int maxHp) {
        this.name = name;
        this.speed = speed;
        this.pos = pos;
        this.maxHp = maxHp;
        this.currHp = maxHp;
    }

    public void move() {
        if(moveTarget == null) {
            log("move() called but no target is set.");
            return;
        }

        float remainingMove = speed;

        double distX = moveTarget.x - pos.x;
        double distXAbs = Math.abs(distX);
        double xMod = distX / distXAbs;

        if(distXAbs > remainingMove) {
            pos.x += remainingMove * xMod;
            remainingMove = 0;
        } else {
            pos.x = moveTarget.x;
            remainingMove -= distXAbs;
        }

        double distY = moveTarget.y - pos.y;
        double distYAbs = Math.abs(distY);
        double yMod = distY / distYAbs;

        if(distYAbs > remainingMove) {
            pos.y += remainingMove * yMod;
        } else {
            pos.y = moveTarget.y;
        }

        log("Moved to " + pos.toString());
    }

    protected void log(String message) {
        System.out.println("[" + name + "] " + message);
    }

    public abstract void nextTick();

    protected void setMoveTarget(Point moveTarget) {
        this.moveTarget = moveTarget;
    }

    protected Point getMoveTarget() {
        return moveTarget;
    }

    public void hurt(int damage) {
        currHp = Math.max(currHp - damage, 0);
        if(currHp > 0) {
            log("Took " + damage + " damage and down to " + currHp);
        } else {
            log("Took " + damage + " damage and died.");
        }
    }

    public String getName() {
        return name;
    }

    public int getCurrHp() {
        return currHp;
    }
}
