import java.util.ArrayList;
import java.util.HashMap;

public class Banker {

    int nUnits;
    HashMap<String, ArrayList<Integer>> clientMap;

    public Banker(int nUnits) {
        this.nUnits = nUnits;
        clientMap = new HashMap<>();
    }

    public synchronized void setClaim(int nUnits) {
        if (nUnits <= 0 || nUnits > this.nUnits
                || clientMap.containsKey(Thread.currentThread().getName())) {
            System.exit(1);
        }
        // Key is Thread name, Value is an array list of size 2 with [allocated,remaining]
        ArrayList<Integer> allocatedRemaining = new ArrayList<>();
        allocatedRemaining.add(0); //number allocated allocatedRemaining[0]
        allocatedRemaining.add(nUnits); //number Remaining allocatedRemaining[1]
        clientMap.put(Thread.currentThread().getName(), allocatedRemaining);
        System.out.println("Thread " + Thread.currentThread().getName() +
                " sets a claim for " + nUnits + " units.");
    }

    public boolean bankersAlgo(int numberOfUnitsOnHand, HashMap<String, ArrayList<Integer>> map) {
        HashMap<String, ArrayList<Integer>> mapCopy = new HashMap<>(map);
        int numUnitsCopy = numberOfUnitsOnHand;

        //Creating a copy of the array list of allocated and remaining pairs
        ArrayList<ArrayList<Integer>> allocatedRemainArray = new ArrayList<>();
        mapCopy.forEach((key, value) -> {
            allocatedRemainArray.add(value);
        });

        //Sorting the array by increasing order of remaining claim:
        for (int i = 0; i < allocatedRemainArray.size(); i++) {
            for (int j = i + 1; j < allocatedRemainArray.size(); j++) {
                ArrayList<Integer> temp;
                if (allocatedRemainArray.get(i).get(1) > allocatedRemainArray.get(j).get(1)) {
                    temp = allocatedRemainArray.get(i);
                    allocatedRemainArray.set(i, allocatedRemainArray.get(j));
                    allocatedRemainArray.set(j, temp);
                }
            }
        }
        for (int i = 0; i < allocatedRemainArray.size() - 1; i++) {
            if (allocatedRemainArray.get(i).get(1) > numUnitsCopy) {
                return false;
            }
        }

        return true;
    }

    public synchronized boolean request(int nUnits) {
        int remaining = clientMap.get(Thread.currentThread().getName()).get(1);
        if (!clientMap.containsKey(Thread.currentThread().getName()) || nUnits <= 0 || nUnits > remaining) {
            System.exit(1);
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " requests " + nUnits + " units.");
        return true;
    }
}
