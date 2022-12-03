package annotations_demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){

        //read spring beans
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //get bean from spring container
        TennisCoach tennis = context.getBean("tennisCoach", TennisCoach.class);
        TennisCoach tennisPrototype = context.getBean("tennisCoach", TennisCoach.class);
        DanceCoach dance = context.getBean("danceCoach", DanceCoach.class);
        DanceCoach dancePrototype = context.getBean("danceCoach", DanceCoach.class);

        //call method on bean
        System.out.println(tennis.getDailyWorkout());
        System.out.println(tennis.getFortune());
        System.out.println(dance.getDailyWorkout());
        System.out.println(dance.getFortune());
        System.out.println(dance.getEmail());
        System.out.println(dance.getName());

        System.out.println("Prototype");
        System.out.println(dancePrototype);
        System.out.println(dance);

        System.out.println("Singleton:");
        System.out.println(tennis);
        System.out.println(tennisPrototype);





        //close the context
        context.close();


    }

}
