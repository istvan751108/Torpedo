package torpedo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * This is my first Torpedo game.
 *
 * @author István Szabó
 * @version 1.8
 */

public class Main {
    /**
     * This is the main method. Some kind of handy description goes here.
     *
     * @param args The command line arguments.
     */

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("Torpedo");
    }
}

