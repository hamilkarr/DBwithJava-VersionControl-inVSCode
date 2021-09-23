package classClassStudy;

public class ClassTest {
  public static void main(String[] args) throws ClassNotFoundException {
    Person person = new Person();
    Class pClass1 = person.getClass();
    System.out.println(pClass1.getName());
    System.out.println("============================");

    Class pClass2 = Person.class;
    System.out.println(pClass2.getName());
    System.out.println("=============================");

    Class pClass3 = Class.forName("classClassStudy.Person");
    System.out.println(pClass3.getName());
  }
}
