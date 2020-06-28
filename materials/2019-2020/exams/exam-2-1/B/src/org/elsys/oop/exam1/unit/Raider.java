package org.elsys.oop.exam1.unit;

import org.elsys.oop.exam1.Point;
import org.elsys.oop.exam1.target.Resource;

import java.util.List;

public class Raider extends BaseUnit {
    private int attack;
    private double range;
    private Worker victim;
    private int stolenResource = 0;

    public Raider(String name, float speed, Point pos, int maxHp, int attack, double range) {
        super(name, speed, pos, maxHp);
        this.attack = attack;
        this.range = range;
    }

    @Override
    public void nextTick() {
        Point target = getMoveTarget();
        if(target == null) {
            log("Idle");
            return;
        }

        move();

        if(pos.distanceTo(target) <= range) {
            log("In range of " + victim.getName());
            victim.hurt(attack);

            if(victim.currHp <= 0) {
                int stolen = victim.getCurrentCarry();
                stolenResource += stolen;
                victim.setCurrentCarry(0);
                setMoveTarget(null);

                log("Stole " + stolen);
            }
        }
    }

    public void findNewVictim(List<Worker> workers) {
        if(workers == null) {
            throw new NullPointerException("The list of workers cannot be null");
        }

        if(workers.size() <= 0) {
            return;
        }

        Worker closestWorker = workers.get(0);
        double closestDist = pos.distanceTo(closestWorker.pos);

        for(Worker worker : workers) {
            double dist = pos.distanceTo(worker.pos);
            if(dist < closestDist) {
                closestWorker = worker;
                closestDist = dist;
            }
        }
        log("Found closest worker - " + closestWorker.name);
        victim = closestWorker;
        setMoveTarget(victim.pos);
    }
}
