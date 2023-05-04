public class AddressBookService {
    AddressBookRepo addressBookRepo = new AddressBookRepo();

    public void addPersons(Person persons) {
        addressBookRepo.addPersons(persons);
    }

    public void displayPersons() {
        addressBookRepo.displayPersons();
    }

    public void deletePersons(Person person) {
        addressBookRepo.deletePersons(person);
    }

    public void editPerson() {
        addressBookRepo.editPerson();
    }
}

