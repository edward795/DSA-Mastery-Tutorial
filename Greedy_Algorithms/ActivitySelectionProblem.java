package Greedy_Algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelectionProblem {
    public static void main(String[] args) {
        Activity[] activities=new Activity[]{new Activity(2, 3),new Activity(1,4),new Activity(5, 8),new Activity(6, 10)};
        System.out.println("Max no: of activities : "+maxActivity(activities));
    }

    //TC : O(n^2)
    // static int  maxActivity(Activity[] activities){
    //     int res=0;
    //     for(int i=0;i<activities.length;i++){
    //         for(int j=i+1;j<activities.length;j++){
    //             if(activities[j].startTime>=activities[i].endTime){
    //                 res++;
    //             }
    //         }
    //     }
    //     return res;
    // }

    //TC : O(n)
    static int maxActivity(Activity[] activities){
        Arrays.sort(activities,new MyCmp());
        int res=1;
        int prev=0;
        for(int curr=1;curr<activities.length;curr++){
            if(activities[curr].startTime>=activities[prev].endTime){
                res++;
                prev=curr;
            }
        }
        return res;
    }
    
}

class MyCmp implements Comparator<Activity>{
    public int compare(Activity a1,Activity a2){
        return a1.endTime-a2.endTime;
    }
}


class Activity{
    int startTime,endTime;

    Activity(int start,int end){
        startTime=start;
        endTime=end;
    }
}
