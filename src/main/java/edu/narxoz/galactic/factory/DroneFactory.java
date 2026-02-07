package edu.narxoz.galactic.factory;
import edu.narxoz.galactic.drones.*;
public class DroneFactory {
    public static Drone createDrone(DroneType type, String id, double maxPayloadKg) {
        return switch (type) {
            case LIGHT -> new LightDrone(id, maxPayloadKg);
            case HEAVY -> new HeavyDrone(id, maxPayloadKg);
        };
    }
}
