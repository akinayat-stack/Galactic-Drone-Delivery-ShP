package edu.narxoz.galactic.demo;
import edu.narxoz.galactic.bodies.Planet;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.HeavyDrone;
import edu.narxoz.galactic.drones.LightDrone;
import edu.narxoz.galactic.dispatcher.Dispatcher;
import edu.narxoz.galactic.task.DeliveryTask;
import edu.narxoz.galactic.task.TaskState;
public class Demo{
    public static void main(String[] args){
        Planet earth = new Planet("earth", 0, 0, "air");
        Planet mars = new Planet("mars", 100, 100, "co2");
        LightDrone a = new LightDrone("a", 50);
        HeavyDrone b = new HeavyDrone("b", 200);
        Cargo c1 = new Cargo(120, "heavy box");
        Cargo c2 = new Cargo(30, "light box");
        DeliveryTask t1 = new DeliveryTask(earth, mars, c1);
        DeliveryTask t2 = new DeliveryTask(earth, mars, c2);
        Dispatcher d = new Dispatcher();
        System.out.println("assign heavy cargo to a: " + d.assignTask(t1, a).reason());
        System.out.println("assign light cargo to b: " + d.assignTask(t2, b).reason());
        System.out.println("delivery time: " + t2.estimateTime() + " minutes");
        System.out.println("completing task: " + d.completeTask(t2).reason());
        System.out.println("final drone status: " + b.getStatus());
        System.out.println("final task state: " + t2.getState()); 
    }
}
