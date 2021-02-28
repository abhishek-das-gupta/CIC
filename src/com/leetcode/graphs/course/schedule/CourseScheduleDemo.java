package com.leetcode.graphs.course.schedule;

public class CourseScheduleDemo {
    public static void main(String[] args){
        int[][] preReq = {{0,1}};
        int numCourses = 3;
        Solution s = new Solution();
        System.out.println(s.canFinish(numCourses,preReq));
    }
}
