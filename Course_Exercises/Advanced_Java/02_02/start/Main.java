import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Optional<String> emptyOpt = Optional.empty();
        Optional<String> nameOpt = Optional.of("Kathryn");
        
        // Example usage to demonstrate Optional functionality
        if (emptyOpt.isPresent()) {
            System.out.println("Empty optional has value: " + emptyOpt.get());
        } else {
            System.out.println("Empty optional is empty");
        }
        
        if (nameOpt.isPresent()) {
            System.out.println("Name optional has value: " + nameOpt.get());
        } else {
            System.out.println("Name optional is empty");
        }
        
        // Using orElse for safer handling
        String defaultName = emptyOpt.orElse("No name provided");
        String actualName = nameOpt.orElse("No name provided");
        
        System.out.println("Default name: " + defaultName);
        System.out.println("Actual name: " + actualName);
    }
}
