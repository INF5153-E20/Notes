package inf5153;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static class Person {
        private Mediator mediator;
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public void talk() {
            System.out.println(String.format("%s is talking.", name));

            if(mediator != null)
                mediator.talkEvent(this);
        }

        public void listen() {
            System.out.println(String.format("%s is listening.", name));
        }

        public void setMediator(Mediator mediator) {
            this.mediator = mediator;
        }
    }

    private interface Mediator {
        void register(Person p);
        void talkEvent(Person p);
    }

    private static class ConcreteMediator implements Mediator {
        List<Person> registry = new ArrayList<>();

        @Override
        public void register(Person p) {
            registry.add(p);
            p.setMediator(this);
        }

        @Override
        public void talkEvent(Person p) {
            for(Person person : registry) {
                if(person != p)
                    p.listen();
            }
        }
    }

    public static void main(String[] args) {
	    Person jim = new Person("Jim");
	    Person sarah = new Person("Sarah");
	    Mediator m = new ConcreteMediator();
	    m.register(jim);
        m.register(sarah);

	    jim.talk();
	    sarah.talk();
    }
}
