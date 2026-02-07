package edu.narxoz.galactic.factory;
import edu.narxoz.galactic.bodies.*;
import edu.narxoz.galactic.cargo.*;
import edu.narxoz.galactic.drones.*;
public class TrainingGalaxyFactory implements GalacticFactory {
    @Override
    public Drone createDrone(String id, double payloadKg) {
        return new LightDrone(id, payloadKg);
    }
    @Override
    public Cargo createCargo(double weightKg, String description) {
        return new Cargo(weightKg, description);
    }
    @Override
    public CelestialBody createOrigin() {
        return new Planet("Earth", 0, 0, "O2");
    }
    @Override
    public CelestialBody createDestination() {
        return new Planet("Mars", 10, 10, "CO2");
    }
}
