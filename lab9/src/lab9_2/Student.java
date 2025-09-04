package lab9_2;

public class Student {
    private String name;
    private String grade;

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    void show() {
        try {
            validateName();
            validateGrade();

            int subjectCount = grade.length();
            double gpa = calculateGPA(grade);

            System.out.println(name + " registered " + subjectCount + " subjects and got GPA " + gpa);

        } catch (IncompleteException e) {
            System.out.println("IncompleteException: (" + e.getMessage() + ") can not display.");
        } catch (DigitException e) {
            System.out.println("DigitException: (" + e.getMessage() + ") can not display.");
        } catch (SpaceException e) {
            System.out.println("SpaceException: (" + e.getMessage() + ") can not display.");
        } catch (GradeException e) {
            System.out.println("GradeException: (" + e.getMessage() + ") can not display.");
        }
    }

    private void validateName() throws DigitException, SpaceException {
        // ตรวจสอบตัวเลขก่อนช่องว่าง
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new DigitException("digit is not allowed in name");
            }
        }
        if (name.contains(" ")) {
            throw new SpaceException("space is not allowed in name");
        }
    }

    private void validateGrade() throws IncompleteException, GradeException {
        
        if (grade.contains("I")) {
            throw new IncompleteException("grade I is incomplete");
        }
        for (char g : grade.toCharArray()) {
            if (g != 'A' && g != 'B' && g != 'C' && g != 'D' && g != 'E' && g != 'F') {
                throw new GradeException("grade must be ABCDEF");
            }
        }
    }
    
    private double calculateGPA(String grade) {
        double totalPoints = 0;
        for (char g : grade.toCharArray()) {
            switch (g) {
                case 'A': totalPoints += 4.0; break;
                case 'B': totalPoints += 3.0; break;
                case 'C': totalPoints += 2.0; break;
                case 'D': totalPoints += 1.0; break;
                case 'F': totalPoints += 0.0; break;
                
            }
        }
        return totalPoints / grade.length();
    }
}
