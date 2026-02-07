package edu.narxoz.galactic;
import edu.narxoz.galactic.dispatcher.Dispatcher;
import edu.narxoz.galactic.factory.DroneFactory;
import edu.narxoz.galactic.factory.DroneType;
import edu.narxoz.galactic.factory.GalacticFactory;
import edu.narxoz.galactic.factory.TrainingGalaxyFactory;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.Drone;
import edu.narxoz.galactic.task.DeliveryTask;
public class Demo {
    public static void main(String[] args) {
        GalacticFactory galaxyFactory = new TrainingGalaxyFactory();
        Drone lightDrone = DroneFactory.createDrone(
                DroneType.LIGHT, "A", 50
        );
        Drone heavyDrone = DroneFactory.createDrone(
                DroneType.HEAVY, "B", 200
        );
        Cargo heavyCargo = galaxyFactory.createCargo(120, "heavy box");
        Cargo lightCargo = galaxyFactory.createCargo(30, "light box");
        DeliveryTask task1 = new DeliveryTask(
                galaxyFactory.createOrigin(),
                galaxyFactory.createDestination(),
                heavyCargo
        );
        DeliveryTask task2 = new DeliveryTask(
                galaxyFactory.createOrigin(),
                galaxyFactory.createDestination(),
                lightCargo
        );
        Dispatcher dispatcher = new Dispatcher();
        System.out.println("assign heavy cargo to light drone: " + dispatcher.assignTask(task1, lightDrone).reason());
        System.out.println("assign light cargo to heavy drone: " + dispatcher.assignTask(task2, heavyDrone).reason());
        System.out.println("delivery time: " + task2.estimateTime() + " minutes");
        System.out.println("completing task: " + dispatcher.completeTask(task2).reason());
        System.out.println("final drone status: " + heavyDrone.getStatus());
        System.out.println("final task state: " + task2.getState());
    }
}
