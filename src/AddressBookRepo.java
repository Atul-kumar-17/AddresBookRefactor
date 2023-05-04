import java.util.ArrayList;

public class AddressBookRepo {
    ArrayList<Person> personList = new ArrayList<>();

    public void addPersons(Person persons) {
        personList.add(persons);
        System.out.println("Person added to addressbook");
    }

    public void displayPersons() {
        for (Person persons : personList) {
            System.out.println(persons.getFirstName());
            System.out.println(persons.getLastName());
            System.out.println(persons.getPhoneNumber());
            System.out.println(persons.getAddress());

        }
    }

    public void deletePersons(Person persons) {
        personList.remove(persons);


       }

    public void editPerson() {
    }
}
