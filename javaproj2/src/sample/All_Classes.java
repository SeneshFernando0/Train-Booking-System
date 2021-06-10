package sample;

import java.util.*;

//---------------------------------------------------Train Station main class
class TrainStation {

    static List<Integer> SecondsInQueueArray = new ArrayList<Integer>();   //array to store time of all passangers
    static List<String> TotalPassangersInQueueArray = new ArrayList<String>();  //array to store  passangers in queue for calculations


    //-----------------------------------------------------------------------

    //------------------------------------------------Passanger list sub class
    public static class passengers {

        String firstName;
        int secondsinQueue;

        passengers(String FN, int SIQ) {

            firstName = FN;
            secondsinQueue = SIQ;

        }


        public void AddDataToQueue() {
            SecondsInQueueArray.add(secondsinQueue);     //add second to array for calculation
            TotalPassangersInQueueArray.add(firstName); //add names for calculation

            //System.out.println(SecondsInQueueArray);
            //System.out.println(TotalPassangersInQueueArray);
        }


    }
    //--------------------------------------------------------------------------

    //------------------------------------------------Passanger Queue sub class
    public static class passengerQueue {


        int First;
        int MaxStayinQueue;
        int Maxlenght;

        public int ReportCalculationMinTime() {

            //getting min value in array

            int MIN = SecondsInQueueArray.get(0);
            for (int i = 1; i < SecondsInQueueArray.size(); i++) {
                if (SecondsInQueueArray.get(i) < MIN) {
                    MIN = SecondsInQueueArray.get(i);
                }
            }
            return MIN;
        }


        public int ReportCalculationMaxTime(){

            //calculating the max time

            int MAX = SecondsInQueueArray.get(0);
            for(int i=1;i<SecondsInQueueArray.size();i++){
                if(SecondsInQueueArray.get(i) > MAX){
                    MAX = SecondsInQueueArray.get(i);
                }
            }
            return MAX;
        }

        public int ReportCalculationMaxLenght(){
            //calculating the max lenght
           int Size=TotalPassangersInQueueArray.size();
           return Size;
        }

        public double AverageWaitingTime(){
            //calculating the average waiting time
            int TotalSec=0;
            for(int i=0; i<SecondsInQueueArray.size();i++){
                TotalSec+=SecondsInQueueArray.get(i);
            }
            int Average=TotalSec/SecondsInQueueArray.size();
            return Average;
        }
    }
}