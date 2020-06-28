package org.elsys.oop.exam1;

import org.elsys.oop.exam1.target.Dropoff;
import org.elsys.oop.exam1.target.Resource;
import org.elsys.oop.exam1.unit.Raider;
import org.elsys.oop.exam1.unit.Worker;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private List<Worker> workers = new ArrayList<>();
    private List<Raider> raiders = new ArrayList<>();
    private List<Resource> availableResources = new ArrayList<>();
    private Dropoff dropoff;

    public void setDropoff(Dropoff dropoff) {
        this.dropoff = dropoff;
    }

    public void addWorker(Worker worker) {
        worker.setDropoff(dropoff);
        workers.add(worker);
        log("Added worker " + worker.getName());
    }

    public void addRaider(Raider raider) {
        raiders.add(raider);
        log("Added raider " + raider.getName());
    }

    public void addResource(Resource res) {
        availableResources.add(res);
        log("Added resource " + res);
    }

    public void run() {
        int cycleCount = 0;
        while(availableResources.size() > 0 && workers.size() > 0) {
            cycleCount++;
            for(Worker worker : workers) {
                worker.nextTick();
            }

            for(Raider raider : raiders) {
                raider.nextTick();
            }

            filterResources();
            filterWorkers();

            for(Worker worker : workers) {
                worker.findNewResource(availableResources);
            }

            for(Raider raider : raiders) {
                raider.findNewVictim(workers);
            }
        }
        log("Finished after " + cycleCount + " cycles.");
        if(workers.size() == 0) {
            log("All workers are dead.");
        }
        if(availableResources.size() == 0) {
            log("THe workers collected all resources.");
        }
        log("Final collected resources = " + dropoff.getTotalResource());
    }

    private void filterResources() {
        List<Resource> filtered = new ArrayList<>();
        for(Resource res : availableResources) {
            if(res.getQuantity() > 0) {
                filtered.add(res);
            }
        }

        availableResources = filtered;
    }

    private void filterWorkers() {
        List<Worker> filtered = new ArrayList<>();
        for(Worker worker : workers) {
            if(worker.getCurrHp() > 0) {
                filtered.add(worker);
            }
        }

        workers = filtered;
    }

    private void log(String message) {
        System.out.println("[Simulation] " + message);
    }
}
