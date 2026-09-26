package StudentDistributionSystem;

class SectionException extends Exception {

    // Polymorphism - Constructor Overloading
    SectionException(){
        super("Section must be between A-F ");
    }
    SectionException(String s){
        super(s);
    }


}
