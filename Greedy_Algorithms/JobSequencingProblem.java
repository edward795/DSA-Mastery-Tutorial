package Greedy_Algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class JobSequencingProblem {
    public static void main(String[] args) {
        Job[] jobs=new Job[]{new Job(0,2,50),new Job(1,2,60),new Job(2,3,20),new Job(3,3,30)};
        System.out.println("Max Profit "+JobScheduling(jobs, 4));
    }

    //TC : O(nlogn)
    public static int[] JobScheduling(Job[] arr,int n){
        Arrays.sort(arr,new MyCmp());
        int[] res=new int[]{0,0};
        int maxDeadline=0;
        for(int i=0;i<n;i++){
            maxDeadline=Math.max(maxDeadline,arr[i].deadline);
        }

        int[] visited=new int[maxDeadline];
        Arrays.fill(visited,-1);
        for(int i=0;i<n;i++){
            for(int j=arr[i].deadline-1;j>=0;j--){
                if(visited[j]==-1){
                    visited[j]=i;
                    res[0]++;
                    res[i]=arr[i].profit;
                    break;
                }
            }
        }
        return res;
    }
}

class Job{
    int id,profit,deadline;

    Job(int id,int profit,int deadline){
        this.id=id;
        this.profit=profit;
        this.deadline=deadline;
    }
}
class MyCmp implements Comparator<Job>{
    public int compare(Job j1,Job j2){
        return j2.profit-j1.profit;
    }
}