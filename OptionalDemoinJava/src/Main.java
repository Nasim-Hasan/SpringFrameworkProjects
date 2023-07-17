import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional obj1 = Optional.of("This is a sample text");
        Optional obj2 = Optional.empty();

        //..For obj1..//
        if(obj1.isPresent())
        {
            System.out.println("Value is Present for Obj1:"+obj1.get().toString());
        }
        else
        {
            System.out.println("Value is not Present for Obj1");
        }

        //..For obj2...//
        if(obj2.isPresent())
        {
            System.out.println("Value is Present for Obj2:"+obj2.get().toString());
        }
        else
        {
            System.out.println("Value is not Present for Obj2");
        }

    }
}