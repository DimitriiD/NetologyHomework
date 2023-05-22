import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public boolean hasAge() {
        return !getAge().isPresent();
    }

    public boolean hasAddress() {
        return address != null;
    }

    public void happyBirthday() {
        if(hasAge()){
            age ++;
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(0)
                .setAddress(this.address);
    }

    @Override
    public String toString() {
        String strAge;
        if (hasAge()) {
            strAge = "Age not set";
        } else {
            strAge = Integer.toString(age);
        }

        return "{Имя '" + name + '\'' + ", Фамилия '" + surname + '\'' + ", Возраст " + strAge +
                ", Адрес '" + address + '\'' + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
