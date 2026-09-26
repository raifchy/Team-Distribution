# Student Distribution System

A Java console application for recording students by semester and section, listing those records, and distributing students into teams using their CG values.

## Requirements

- Java Development Kit (JDK) with `javac` and `java` available on your PATH

## Build and Run

From the project root, compile the source files and launch the application:

```powershell
javac -d out src/StudentDistributionSystem/Main.java src/StudentDistributionSystem/Student.java src/StudentDistributionSystem/StudentDB.java src/StudentDistributionSystem/StudentDistribution.java src/StudentDistributionSystem/StudentInput.java
java -cp out StudentDistributionSystem.Main
```

## Using the Application

Choose one of the commands shown in the console:

| Command | Action |
| --- | --- |
| `1` | Add students |
| `2` | Make teams for a semester/section code |
| `3` | Show students for a semester/section code |
| `4` | Exit |

When adding students, enter the number of records, then provide each student's fields in this order:

1. Name (may include spaces)
2. Student ID (integer)
3. Section letter (for example, `A` or `B`)
4. Semester (integer)
5. CG (decimal number)

The section letter is converted to a number (`A` = 1, `B` = 2, and so on). A section code is calculated as:

```text
code = semester * 10 + section number
```

For example, semester 3 and section B use code `32`. Enter that code when showing students or making teams.

When making teams, enter the section code and a requested team size. The application sorts students by CG and distributes them across the calculated number of teams in alternating order. The requested size determines the number of teams; the resulting team sizes can vary slightly.

Student records exist only while the application is running. Restarting the program clears them.