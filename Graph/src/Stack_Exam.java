import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Margarita on 23-Oct-15.
 */
public class Stack_Exam {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("stack: " + stack);
        showpush(stack, 42);
        showpush(stack, 66);
        showpush(stack, 99);
        showpop(stack);
        showpop(stack);
        showpop(stack);

        try {
            showpop(stack);
        } catch (EmptyStackException ex) {
            System.out.println("empty stack");
        }
    }


    private static void showpop(Stack st) {
        System.out.print("pop -> ");
        Integer num = (Integer) st.pop();
        System.out.println(num);
        System.out.println("stack: " + st);
    }

    private static void showpush(Stack st, int num) {
        st.push(new Integer(num));
        System.out.println("push(" + num + ")");
        System.out.println("stack: " + st);
    }
}
