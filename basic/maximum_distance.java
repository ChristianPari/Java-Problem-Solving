package basic;

public class maximum_distance {
  public static void main(String[] args) {
    /*
    Write a function that takes fuel (liters), fuelUsage (liters/100km), passengers, airConditioner (boolean) and returns maximum distance that car can travel.

    fuel is the number of liters of fuel in the fuel tank.
    fuelUsage is basic fuel consumption per 100 km (with the driver inside only).
    Every additional passenger is increasing basic fuel consumption by 5%.
    If the air conditioner is ON true, its increasing total (not basic) fuel consumption by 10%.

Examples

totalDistance(70.0, 7.0, 0, false) ➞ 1000.0

totalDistance(36.1, 8.6, 3, true) ➞ 331.83

totalDistance(55.5, 5.5, 5, false) ➞ 807.3
     */
    System.out.println(totalDistance(36.1, 8.6, 3, true));
  }

  private static double totalDistance(
    double fuel
    , double fuelUsage
    , int passengers
    , boolean airConditioner
  ) {
    // passengers > 0 ? (passengers * 5) / 100 ... passengerFuelNeeded * fuelUsage + fuelUsage = new fuelUsage
    // airConditoner = true ? .1 * newFeulUsage = newerFuelUsage 10.879
    // fuel / newerFuelUsage = maxMilage
    int PASS_CONSUMP_INCREASE = 5;
    double AC_CONSUMP_INCREASE = 0.1;
    double mileage = 0;
    double passengerFuelUsage = passengers > 0 ? ((passengers * PASS_CONSUMP_INCREASE) / 100F) * fuelUsage : 0;
    fuelUsage += passengerFuelUsage;
    fuelUsage = airConditioner ? (AC_CONSUMP_INCREASE * fuelUsage) + fuelUsage : fuelUsage;
    mileage = (fuel / fuelUsage) * 100;
    return mileage;
  }
}
