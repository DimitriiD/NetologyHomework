import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
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

    public Integer getAge() {
        if (age == null) {
            System.out.println("Age not set");
        }
        return age;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public boolean hasAge() {
        return age != null;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public void happyBirthday() {
        if (age != null && age >= 0) {
            this.age++;
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
        if (age == null) {
            strAge = "Age not set";
        } else {
            strAge = age.toString();
        }

        return "{Имя '" + name + '\'' + ", Фамилия '" + surname + '\'' + ", Возраст " + strAge +
                ", Адрес '" + address + '\'' + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
