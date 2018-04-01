package pl.mjedynak;

import java.util.Optional;

public class CityRetrieverWithOptional {

    private final PersonService personService;

    public CityRetrieverWithOptional(PersonService personService) {
        this.personService = personService;
    }

    public Optional<String> retrieveCity(String name) {
        return Optional.ofNullable(personService.getByName(name))
                .map(Person::getAddress)
                .map(Address::getCity);
    }
}
