package com.liujin.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//比较器
public class Code17_ShowComparator {
    public static class Student{
        public String name;
        public int age;
        public int id;

        public Student(String name, int age, int id) {
            this.name = name;
            this.age = age;
            this.id = id;
        }
    }
    //id比较器 谁大谁放前面
    public static class IdComparator implements Comparator<Student>{

        // 如果返回负数，认为第一个参数应该排在前面
        // 如果返回正数，认为第二个参数应该排在前面
        // 如果返回0，认为谁放前面无所谓
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.id < o2.id){
                return 1;
            }else if (o1.id > o2.id){
                return -1;
            }else {
                return 0;
            }
        }
    }
    // 谁age大，谁放前！
    public static class AgeComparator implements Comparator<Student> {

        // 如果返回负数，认为第一个参数应该排在前面
        // 如果返回正数，认为第二个参数应该排在前面
        // 如果返回0，认为谁放前面无所谓
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.age < o2.age) {
                return 1;
            } else if (o2.age < o1.age) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    //打印器
    public static void printArray(int [] arr){
        for (int i : arr) {
            System.out.print(i+ " ");
        }
        System.out.println();
    }
    public static void printStudent(Student [] student){
        for (int i = 0; i < student.length; i++) {
            System.out.println(student[i].name + "," + student[i].age + "," + student[i].id);
        }
    }
    public static class MyComparator implements Comparator<Integer>{
        // 如果返回负数，认为第一个参数应该排在前面
        // 如果返回正数，认为第二个参数应该排在前面
        // 如果返回0，认为谁放前面无所谓
        //谁大在前面
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2){
                return 1;
            }else if (o1 > o2){
                return -1;
            }else {
                return 0;
            }


        }

    }

    public static void main(String[] args) {
        int[] arr = { 8, 1, 4, 1, 6, 8, 4, 1, 5, 8, 2, 3, 0 };
        printArray(arr);
        Arrays.sort(arr);
        printArray(arr);
        Student s1 = new Student("张三", 5, 27);
        Student s2 = new Student("李四", 1, 17);
        Student s3 = new Student("王五", 4, 29);
        Student s4 = new Student("赵六", 3, 9);
        Student s5 = new Student("左七", 2, 34);
        Student [] students = {s1, s2, s3, s4, s5};
        printStudent(students);
        System.out.println("=====");
        Arrays.sort(students,new IdComparator());
        printStudent(students);
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(s1);
        studentArrayList.add(s2);
        studentArrayList.add(s3);
        studentArrayList.add(s4);
        studentArrayList.add(s5);
        studentArrayList.sort(new IdComparator());
        for (Student student : studentArrayList) {
            System.out.println(student.age + ", " + student.id + ", " + student.name);
        }
        System.out.println("=======");

        //小根堆
        PriorityQueue<Integer> heap1 = new PriorityQueue<>(new MyComparator());
        heap1.add(3);
        heap1.add(2);
        heap1.add(8);
        heap1.add(1);
        heap1.add(5);

        while (!heap1.isEmpty()){
            System.out.println(heap1.poll());
        }
        PriorityQueue<Student> heap2 = new PriorityQueue<>();
//        heap2.add()


    }
}
