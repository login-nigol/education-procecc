package example.programms.annotationreader;

@Info(
        author = "John Doe",
        date = "2024-08-09",
        description = "Example class with Info annotation"

)
public class AnnotatedClass {

    @Info(
            author = "Jane Doe",
            date = "2024-08-09",
            description = "Example method with Info annotation"
    )
    public void annotatedMethod() {
        System.out.println("This is a method with Info annotation.");
    }
}
