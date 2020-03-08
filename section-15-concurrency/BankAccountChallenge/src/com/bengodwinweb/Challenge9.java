package com.bengodwinweb;

public class Challenge9 {
    public static void main(String[] args) {
        TutorChallenge9 tutor = new TutorChallenge9();
        StudentChallenge9 student = new StudentChallenge9(tutor);
        tutor.setStudent(student);

        Thread tutorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                tutor.studyTime();
            }
        });

        Thread studentThread = new Thread(new Runnable() {
            @Override
            public void run() {
                student.handInAssignment();
            }
        });

        tutorThread.start();
        studentThread.start();
    }
}

class TutorChallenge9 {
    private StudentChallenge9 student;


    public synchronized void setStudent(StudentChallenge9 student) {
        this.student = student;
    }

    public void studyTime() {
        synchronized (this) {
            System.out.println("Tutor has arrived");
            synchronized (student) {
                try {
                    // wait for student to arrive and hand in assignment
                    this.wait();
                }
                catch (InterruptedException e) {}
                student.startStudy();
                System.out.println("Tutor is studying with student");
            }
        }
    }

    public void getProgressReport() {
        // get progress report
        System.out.println("Tutor gave progress report");
    }
}

class StudentChallenge9 {
    private TutorChallenge9 tutor;

    StudentChallenge9(TutorChallenge9 tutor) {
        this.tutor = tutor;
    }

    public void startStudy() {
        // study
        System.out.println("Student is studying");
    }

    public void handInAssignment() {
        synchronized (tutor) {
            tutor.getProgressReport();
            synchronized (this) {
                System.out.println("Student handed in assignment");
                tutor.notifyAll();
            }
        }
    }
}
