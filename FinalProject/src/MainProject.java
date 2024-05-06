import java.util.Scanner;

public class MainProject {
    public static void main(String[] args) {
        World world = new World();

        Scanner scanner = new Scanner(System.in);
        while(true) {
            // May change this to just list options
            System.out.println("What would you like to do?");
            String command = scanner.nextLine();
            if (command.equals("create")) {
                //create people or buildings
            }
            else if (command.equals("use")) {
                //interact with nodes of any kind
            }
            else if (command.equals("show all")) {
                world.showBuildings();
                world.showWorkers();
                world.showNodes();
            }
            else if (command.equals("quit")) {
                //break out of the loop
                break;
            }
        }
        scanner.close();
    }
}
