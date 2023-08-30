package Graphs;
//690. Employee Importance
/*
You have a data structure of employee information, including the employee's unique ID, importance value,
and direct subordinates' IDs.

You are given an array of employees 'employees' where:

employees[i].id is the ID of the ith employee.
employees[i].importance is the importance value of the ith employee.
employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
Given an integer id that represents an employee's ID, return the total importance value of this employee
and all their direct and indirect subordinates.
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EmployeeImportance {
    HashMap<Integer, Employee> empMap;
    public int getImportance(List<Employee> employees, int id) {

        //Create HashMap to store employee vs id
        if(empMap == null){
            empMap = new HashMap<>();
            employees.forEach(emp -> empMap.put(emp.id,emp));
        }
        int imp = 0;

        //queue to add the employee subordinates
        Queue<Employee> queue = new LinkedList<>();
        queue.add(empMap.get(id));
        while(!queue.isEmpty()){
            Employee curr = queue.poll();
            imp += curr.importance;
            curr.subordinates.forEach(empid -> queue.add(empMap.get(empid)));
        }
        return imp;
    }
}
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
