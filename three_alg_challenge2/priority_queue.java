package three_alg_challenge2;
/*
There are a number of students in a school who wait to be served. Two types of events, ENTER and SERVED, can take place which are described below.

    ENTER: A student with some priority enters the queue to be served.
    SERVED: The student with the highest priority is served (removed) from the queue.

A unique id is assigned to each student entering the queue. The queue serves the students based on the following criteria (priority criteria):

    The student having the highest Cumulative Grade Point Average (CGPA) is served first.
    Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
    Any students having the same CGPA and name will be served in ascending order of the id.

Create the following two classes:

    The Student class should implement:
        [x]: The constructor Student(int id, String name, double cgpa).
        [x]: The method int getID() to return the id of the student.
        [x]: The method String getName() to return the name of the student.
        [x]: The method double getCGPA() to return the CGPA of the student.
    The Priorities class should implement the method
      []: List<Student> getStudents(List<String> events)
        to process all the given events and return all the students yet to be served in the priority order.
 */
import java.util.*;

/*
 CREATE STUDENT AND PRIORITIES CLASSES
 */
class Student implements Comparable<Student> {
  int id;
  String name;
  double cgpa;

  public Student(
    int id
    , String name
    , double cgpa
  ) {
    this.id = id;
    this.cgpa = cgpa;
    this.name = name;
  }

  public int getID() { return id; }
  public String getName() { return name; }
  public double getCGPA() { return cgpa; }

  @Override
  public int compareTo(Student student) {
    double diffCGPA = student.cgpa - this.cgpa;
    if (diffCGPA == 0D) {
      if (student.name.equals(this.name)) {
        return student.id - this.id;
      } else {
        return this.name.compareTo(student.name);
      }
    } else {
      return diffCGPA < 0 ? -1 : 1;
    }
  }

  @Override
  public String toString() {
    return name + " " + cgpa + " " + id;
  }
}

class Priorities {

  public ArrayList<Student> getStudents(List<String> events) {
    PriorityQueue<Student> queue = new PriorityQueue<>();

    for (String e : events) {
      String[] eArray = e.split(" ");
      String ACTION = eArray[0];
      switch (ACTION) {
        case "ENTER":
          String NAME = eArray[1];
          double CPGA = Double.parseDouble(eArray[2]);
          int ID = Integer.parseInt(eArray[3]);
          Student newStudent = new Student(ID, NAME, CPGA);
          queue.add(newStudent);
          break;

        case "SERVED":
          queue.poll();
          break;
      }
    }

    ArrayList<Student> students = new ArrayList<>();
    while (!queue.isEmpty()) {
      students.add(queue.poll());
    }
    return students;
  }
}

// TRIED MAKING MY OWN COMPARATOR

//class CompareStudents implements Comparator<Student> {
//
//  @Override
//  public int compare(Student o1, Student o2) {
//    System.out.println(o1.name + " vs " + o2.name);
//    boolean oneHasHigherCGPA = o1.cgpa <= o2.cgpa;
//    boolean areSame = o1.id == o2.id;
//
//    if (areSame) {
//      return 0;
//    }
//
//    if (oneHasHigherCGPA) {
//      return -1;
//    } else if (o1.name.compareTo(o2.name) < 0) {
//      return 1;
//    } else if (o1.id < o2.id) {
//      return -1;
//    } else {
//      return 1;
//    }
//  }
//}

public class priority_queue {
  private static final Scanner scan = new Scanner(System.in);
  private static final Priorities priorities = new Priorities();

  public static void main(String[] args) {
    // MY TESTING
//    List<String> events = new ArrayList<>();
//    events.add("ENTER John 3.75 50");
//    events.add("ENTER Mark 3.8 24");
//    events.add("ENTER Shafaet 3.7 35");
//    events.add("SERVED");
//    events.add("SERVED");
//    events.add("ENTER Samiha 3.85 36");
//    events.add("SERVED");
//    events.add("ENTER Ashley 3.9 42");
//    events.add("ENTER Maria 3.6 46");
//    events.add("ENTER Anik 3.95 49");
//    events.add("ENTER Dan 3.95 50");
//    events.add("SERVED");

    // HACKERRANK CODE
    int totalEvents = Integer.parseInt(scan.nextLine());
    List<String> events = new ArrayList<>();

    while (totalEvents-- != 0) {
      String event = scan.nextLine();
      events.add(event);
    }



    ArrayList<Student> students = priorities.getStudents(events);

    if (students.isEmpty()) {
      System.out.println("EMPTY");
    } else {
      for (Student st : students) {
        System.out.println(st.getName());
      }
    }
  }
}