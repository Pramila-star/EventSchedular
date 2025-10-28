import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
 class Events {
    String department;
    int start;
    int end;

    Events(String department, int start, int end){
        this.department = department;
        this.start = start;
        this.end = end;
    }
}

public class collegeEventScheduler {
    
    public static void main(String[] args){
        List<Events> events = new ArrayList<>();
        events.add(new Events("CSE", 9, 10));
        events.add(new Events("ECE", 10, 11));
        events.add(new Events("MECH", 11, 12));
        events.add(new Events("CIVIL", 9, 10));

        //sort by start time
        Collections.sort(events, Comparator.comparingInt(e -> e.start));

        boolean clash = false;
        System.out.println("Event Schedule: ");
        for(int i =0; i< events.size(); i++){
            Events curr = events.get(i);
            System.out.println(curr.department + " : " + curr.start + " - " + curr.end);

            if(i > 0){
                Events prev = events.get(i - 1);
                if(curr.start < prev.end){
                    System.out.println("Clash detected between " + prev.department + " and " + curr.department);
                    clash = true;
                     
                }
            }
        }

        if (!clash) {
            System.out.println("\n Schedule is valid - no events overlap!");

        }else {
            System.out.println("\n Schedule invalid - some events clash!");
        }
    }
}
