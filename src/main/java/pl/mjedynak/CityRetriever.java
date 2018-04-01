package pl.mjedynak;

public class CityRetriever {

    private final PersonService personService;

    public CityRetriever(PersonService personService) {
        this.personService = personService;
    }

    public String retrieveCity(String name) {
        Person person = personService.getByName(name);
        if (person != null) {
            Address address = person.getAddress();
            if (address != null) {
                if (address.getCity() != null) {
                    return address.getCity();
                }
            }
        }
        return null;
    }

}
