package StudentDistributionSystem;


class Student {
    private final String name;
    private final int id;
    private final int section;
    private final int semester;
    private final double cg;

    Student(String name, int id, int section, int semester, double cg) {
        this.name = name;
        this.id = id;
        this.section = section;
        this.semester = semester;
        this.cg = cg;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getSection() {
        return section;
    }

    public int getSemester() {
        return semester;
    }

    public double getCg() {
        return cg;
    }

    @Override
    public String toString() {
        return "Name: " + name
            + ", ID: " + id
            + ", Semester: " + semester
            + ", Section: " + section
            + ", CG: " + cg;
    }

}