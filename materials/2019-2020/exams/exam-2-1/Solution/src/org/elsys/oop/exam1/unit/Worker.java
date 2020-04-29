package org.elsys.oop.exam1.unit;

import org.elsys.oop.exam1.target.Dropoff;
import org.elsys.oop.exam1.Point;
import org.elsys.oop.exam1.target.Resource;

import java.util.List;

public class Worker extends BaseUnit {
    private Dropoff dropoff;
    private Resource resource;
    private int currentCarry = 0;
    private int maxCarry;

    public Worker(String name, float speed, Point pos, int maxCarry, int maxHp) {
        super(name, speed, pos, maxHp);
        this.maxCarry = maxCarry;
    }

    public void setDropoff(Dropoff dropoff) {
        this.dropoff = dropoff;
        log("Set dropoff to " + dropoff);
    }

    public void setResource(Resource resource) {
        this.resource = resource;
        log("Set resource to " + resource);
    }

    public int getCurrentCarry() {
        return currentCarry;
    }

    public void setCurrentCarry(int currentCarry) {
        this.currentCarry = currentCarry;
    }

    @Override
    public void nextTick() {
        Point target = getMoveTarget();
        if(target == null) {
            log("Idle");
            return;
        }

        move();

        if(pos.distanceTo(target) == 0) {
            log("Target reached. Setting new target.");
            if (resource != null && resource.getPos().equals(target)) {
                collectResource();
                setMoveTarget(dropoff.getPos());
                log("Start moving to dropoff " + dropoff);
            } else if (dropoff != null && dropoff.getPos().equals(target)) {
                dropResource();
                setMoveTarget(resource.getPos());
                log("Start moving to resource " + resource);
            } else {
                log("No resource and dropoff set. Can't set new target.");
                setMoveTarget(null);
            }
        }
    }

    private void dropResource() {
        dropoff.add(currentCarry);
        currentCarry = 0;
    }

    private void collectResource() {
        int delta = maxCarry;

        if(maxCarry > resource.getQuantity()) {
            delta = resource.getQuantity();
        }

        currentCarry = delta;
        resource.subtract(delta);

        log("Collected " + delta + " resource from " + resource.getPos());
    }

    public void findNewResource(List<Resource> resources) {
        if(resources == null) {
            throw new NullPointerException("The list of resources cannot be null");
        }

        if(resources.size() <= 0) {
            return;
        }

        if(currentCarry == 0 && resource != null && resource.getQuantity() > 0) {
            return;
        }

        Resource closestRes = resources.get(0);
        double closestDist = pos.distanceTo(closestRes.getPos());

        for(Resource res : resources) {
            double dist = pos.distanceTo(res.getPos());
            if(dist < closestDist) {
                closestRes = res;
                closestDist = dist;
            }
        }
        log("Found closest resource - " + closestRes);

        setResource(closestRes);
        if(currentCarry == 0 || getMoveTarget() == null) {
            setMoveTarget(resource.getPos());
            log("Start moving to resource " + resource);
        }
    }
}
