public class Person {

    private String name;
    private Integer age;
    private String sexo;

    public Person(String name, Integer age, String sexo){
        this.name = name;
        this.age = age;
        this.sexo = sexo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
