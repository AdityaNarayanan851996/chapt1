import static com.google.common.base.Preconditions.checkState;

public class Person {
    private String title;
    private final String name;
    private String prefix;
    private final String surname;

    private Person(String title, String name, String prefix, String surname) {
        this.title = title;
        this.name = name;
        this.prefix = prefix;
        this.surname = surname;
    }

    public static class Builder{
        private String title;
        private final String name;
        private String prefix;
        private final String surname;


        private Builder(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        static Builder createBuilder(String name, String surname) {
            return new Builder(name, surname);
        }

        Builder setTitle(String title){
            this.title = title;
            return this;
        }
        Builder setPrefix(String prefix){
            this.prefix = prefix;
            return this;

        }
        Person build(){
            // Check Conditions here
            checkState(prefix != null && surname != null);
            return new Person(title,name,prefix,surname);
        }
    }
    
    public static void main(String[] args){
        Person b = Builder.createBuilder("Adi","Narayanan")
                    .setPrefix("Mr.")
                    .setTitle("IV")
                    .build();
        System.out.println(b.prefix+b.name+b.surname+", "+b.title);
    }
}
