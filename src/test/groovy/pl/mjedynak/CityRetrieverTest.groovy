package pl.mjedynak

import spock.lang.Specification

class CityRetrieverTest extends Specification {

    private PersonService personService = Mock()
    private CityRetriever cityRetriever = new CityRetriever(personService)
    private static final String CITY = 'Cracow'
    private static final String NAME = 'Jan Matejko'

    def 'retrieves city'() {
        given:
        Address address = new Address('street', CITY)
        personService.getByName(NAME) >> new Person(NAME, 1, address)

        when:
        def result = cityRetriever.retrieveCity(NAME)

        then:
        result == CITY
    }

    def 'returns null if service returns nothing'() {
        given:
        personService.getByName(NAME) >> null

        when:
        def result = cityRetriever.retrieveCity(NAME)

        then:
        result == null
    }

    def 'returns null if address is not present'() {
        given:
        personService.getByName(NAME) >> new Person(NAME, 1, null)

        when:
        def result = cityRetriever.retrieveCity(NAME)

        then:
        result == null
    }

    def 'returns null if city is not present'() {
        given:
        Address address = new Address('street', null)
        personService.getByName(NAME) >> new Person(NAME, 1, address)

        when:
        def result = cityRetriever.retrieveCity(NAME)

        then:
        result == null
    }
}
