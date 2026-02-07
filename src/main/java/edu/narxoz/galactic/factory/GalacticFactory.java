package edu.narxoz.galactic.factory;
import edu.narxoz.galactic.bodies.*;
import edu.narxoz.galactic.cargo.*;
import edu.narxoz.galactic.drones.*;
public interface GalacticFactory {
    Drone createDrone(String id, double payloadKg);
    Cargo createCargo(double weightKg, String description);
    CelestialBody createOrigin();
    CelestialBody createDestination();
}
