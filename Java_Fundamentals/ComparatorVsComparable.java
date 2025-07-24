import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Box implements Comparable<Box> {
    public double width, length, height;

    // Constructor
    public Box(double width, double length, double height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    // Helper method to calculate "length plus girth"
    double lengthPlusGirth() {
        // Determine largest, smallest, and middle dimensions
        double largest = Math.max(width, Math.max(length, height));
        double sum = width + length + height;

        // Calculate "length plus girth"
        return largest + 2 * (sum - largest);
    }

    // Implement the compareTo method to compare by "length plus girth"
    @Override
    public int compareTo(Box other) {
        double thisLPG = this.lengthPlusGirth(); // "length plus girth" for this box
        double otherLPG = other.lengthPlusGirth(); // "length plus girth" for the other box

        // Compare "length plus girth" values
        if (thisLPG < otherLPG) {
            return -1; // This box has smaller "length plus girth"
        } else if (thisLPG > otherLPG) {
            return 1; // This box has larger "length plus girth"
        } else {
            return 0; // The boxes have equal "length plus girth"
        }
    }

    @Override
    public String toString() {
        return "Box(" + width + " x " + length + " x " + height + ")";
    }

}

class CompareBoxes implements Comparator<Box> {

    @Override
    public int compare(Box b1, Box b2) {
        return (int) (b2.lengthPlusGirth() - b1.lengthPlusGirth());
    }
}

public class ComparatorVsComparable {

    // Main method to test sorting
    public static void main(String[] args) {
        // Create some Box objects
        Box box1 = new Box(5, 10, 15);
        Box box2 = new Box(7, 8, 9);
        Box box3 = new Box(3, 2, 1);

        List<Box> boxes = new ArrayList<Box>();
        boxes.add(box1);
        boxes.add(box2);
        boxes.add(box3);

        int val = box1.compareTo(box2);
        System.out.println("val = " + val);
        if (val > 0)
            System.out.println("val = 1 i.e. box1 has more lengthPlusGirth than box2");
        else if (val < 0)
            System.out.println("val = -1 i.e box1 has less lengthPlusGirth than box2");
        else
            System.out.println("val = 0 i.e box1 has same lengthPlusGirth to box2");

        Collections.sort(boxes, new CompareBoxes());
        System.out.println("Boxes after sorting");
        System.out.println(boxes);
    }
}
