package cn.lanqiao.controller;

import cn.lanqiao.pojo.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {

    public static void main(String[] args) {
        //创建集合
        ArrayList<Student> list = new ArrayList<>();
        //使用while死循环让程序
        while (true) {
            //键盘导入
            Scanner sc = new Scanner(System.in);
            System.out.println("------大数据3班学生管理系统------");
            System.out.println("*       1.添加学生信息        *");
            System.out.println("*       2.删除学生信息        *");
            System.out.println("*       3.修改学生信息        *");
            System.out.println("*       4.查询学生信息        *");
            System.out.println("*       5.退出程序           *");
            System.out.println("----------------------------");
            //提示语句
            System.out.println("请输入您要执行的命令：");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
//                    System.out.println("添加学生信息");
                    Add(list);
                    break;
                case 2:
//                    System.out.println("删除学生信息");
                    Delete(list);
                    break;
                case 3:
//                    System.out.println("修改学生信息");
                    Modify(list);
                    break;
                case 4:
//                    System.out.println("查询学生信息");
                    Query(list);
                    break;
                case 5:
                    //System.out.println("退出程序");
                    System.out.println("退出成功，欢迎您下次使用大数据3班学生管理系统，再见！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("您输入的命令有错误，请重新输入。");
            }
        }
    }

    public static void Add(ArrayList<Student> list) {
        //添加学生信息
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        while (true) {
            System.out.println("请输入新学生的id：");
            int id = sc.nextInt();
            boolean a = Judge(list, id);
            if (a) {
                System.out.println("id已经存在，请重新输入:");
            } else {
                student.setId(id);
                break;
            }
        }
        System.out.println("请输入学生的姓名");
        String name = sc.next();
        System.out.println("请输入学生的年龄");
        int age = sc.nextInt();
        System.out.println("请输入学生的地址");
        String address = sc.next();
        //利用set给学生信息进行赋值
        student.setName(name);
        student.setAge(age);
        student.setAddress(address);
        //添加进集合里面
        list.add(student);
        System.out.println("添加学生信息成功！");
    }


    private static void Delete(ArrayList<Student> list) {
        //删除学生信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入删除学生的id：");
        int id = scanner.nextInt();
        int idx = DeleteStudent(list, id);
        if (idx >= 0) {
            Student remove = list.remove(idx);
            System.out.println("id为:"+id+"的学生信息已经删除成功");
        } else {
            System.out.println("id为："+id+"的学生信息不存在，请查询确认id后重新删除。");
        }
    }

    public static void Modify(ArrayList<Student> list) {
        //修改学生信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入将要被修改学生信息的id：");
        int id = scanner.nextInt();
        int modify = modify(list, id);
        System.out.println(modify);
        if (modify >= -1){
            Student student = list.get(modify);
            System.out.println("请输入学生的id：");
            int id1 = scanner.nextInt();
            System.out.println("请输入学生的姓名：");
            String name = scanner.next();
            System.out.println("请输入学生的年龄：");
            int age = scanner.nextInt();
            System.out.println("请输入学生的地址：");
            String address = scanner.next();

            student.setId(id1);
            student.setName(name);
            student.setAge(age);
            student.setAddress(address);

            list.set(modify,student);
            System.out.println("id为:"+id+"的学生信息已经修改成功");
        } else {
            System.out.println("id为："+id+"的学生信息不存在，请查询确认id后重新修改。");
        }
    }


    public static void Query(ArrayList<Student> list) {
        //查询学生信息
        //判断学生信息是否存在
        if (list.size() == 0) {
            System.out.println("请添加学生信息后再查询。");
        }
        //打印头部信息
        System.out.println("***********学生信息表***********");
        System.out.println("ID\t\t姓名\t\t年龄\t\t家庭住址");
        for (int i = 0; i < list.size(); i++) {
            //遍历集合中的id信息
            Student student = list.get(i);
            int id = student.getId();
            String name = student.getName();
            int age = student.getAge();
            String address = student.getAddress();
            //输出学生信息
            System.out.println(id + "\t\t" + name + "\t\t" + age + "\t\t" + address);
        }
    }

    //查询判断id是否存在(添加)
    public static boolean Judge(ArrayList<Student> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            int id1 = student.getId();
            if (id1 == id) {
                return true;
            }
        }
        return false;
    }

    //删除判断学生id是否存在(删除)
    public static int DeleteStudent(ArrayList<Student> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            int id1 = student.getId();
            if (id1 == id) {
                return i;
            }
        }
        return -1;
    }

    //判断id是否存在(修改)
    public static int modify(ArrayList<Student> list, int id){
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            int id1 = student.getId();
            if (id1 == id) {
                return i;
            }
        }
        return -2;
    }
}