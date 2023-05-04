import java.util.Iterator;
import java.util.Scanner;
public class AddressBookController {
    static Person persons = new Person();
    static  Scanner sc = new Scanner(System.in);
    static PersonAddress personAddress = new PersonAddress();
    public static Person readPersonFromConsole(){
        System.out.println("Enter the first name ");
        String firstName = sc.next();
        persons.setFirstName(firstName);
        System.out.println("Enter the last name");
        String lastName = sc.next();
        persons.setLastName(lastName);
        System.out.println("Enter the phone Number");
        long phoneNumber = sc.nextLong();
        persons.setPhoneNumber(phoneNumber);
        System.out.println("Enter the city");
        String city = sc.next();
        personAddress.setCity(city);
        System.out.println("Enter the State");
        String state=sc.next();
        personAddress.setState(state);
        System.out.println("Enter the Zip ");
        int zip= sc.nextInt();
        personAddress.setZip(zip);
        return persons;
    }
    public static Person deletePersonFromConsole(){
        AddressBookRepo addressBookRepo=new AddressBookRepo();
        System.out.println("enter the first name");
        String firstName=sc.next();
        Iterator<Person>iterator=addressBookRepo.personList.iterator();
        while (iterator.hasNext()){
            Person persons=iterator.next();
            if(firstName.equals(persons.getFirstName())){
                addressBookRepo.personList.remove(persons);
            }
        }
        return persons;
    }
    public static  Person editPersonFromConsole(){
        AddressBookRepo addressBookRepo=new AddressBookRepo();
        System.out.println("Enter the first name you want to edit ");
        String firstName=sc.next();
        Iterator<Person>iterator=addressBookRepo.personList.listIterator();
        while(iterator.hasNext()){
            Person persons=iterator.next();
            if(firstName.equals(persons.getFirstName())){
                String address=persons.getAddress();
                System.out.println("Choose Action ");
                System.out.println("1. First Name,2. LastName ,3. Phone Number ,4. Address");
                switch (sc.nextInt()){
                    case 1:
                        System.out.println("Edit first Name: ");
                        persons.setFirstName(sc.next());
                        break;
                    case 2:
                        System.out.println("Edit last name: ");
                        persons.setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Edit phone Number: ");
                        persons.setPhoneNumber(sc.nextLong());
                        break;
                    case 4:
                        System.out.println("Edit Address: ");
                        persons.setAddress(sc.next());
                        break;
                    default:
                        System.out.println("please enter correct choice ");
                        break;
                }

            }
        }
        return persons;
    }
    
    public static void main(String[] args) {
        AddressBookService addressBookService=new AddressBookService();
        while(true){
            Scanner sc=new Scanner(System.in);
            System.out.println(" 1.Add , 2.Display , 3.Delete , 4.Update ");
            int choice= sc.nextInt();
            switch (choice){
                case 1:
                    Person person= readPersonFromConsole();
                    addressBookService.addPersons(person);
                    break;
                case 2:
                    addressBookService.displayPersons();
                    break;
                case 3:
                    Person persons=deletePersonFromConsole();
                    addressBookService.deletePersons(persons);
                    break;
                case 4:
                    Person person1=editPersonFromConsole();
                    addressBookService.editPerson();
                    break;
                default:
                    System.out.println("Enter Correct Option ");
                    break;
            }
        }
    }
}
