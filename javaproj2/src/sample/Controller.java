package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.List;



public class Controller implements Initializable {


    static HashMap<String, Integer> passangermap;


    static List<String> TQ = new ArrayList<String>();
    static List<String> TQ2 = new ArrayList<String>();
    static List<String> TQ3 = new ArrayList<String>();
    static List<String> TQcopy = new ArrayList<String>();
    static List<String> ViewFunctionUse= new ArrayList<String>();

    static List<Label> SeatArray= new ArrayList<Label>();


    static List<String> PassangerBoadingArray = new ArrayList<String>();

    static List<Integer> PassangerSeatArray = new ArrayList<Integer>();
    static List<Integer> PassangerSeatArrayCOPY = new ArrayList<Integer>();
    static List<Integer> PassangerSeatArray2 = new ArrayList<Integer>();
    static List<Integer> PassangerSeatArray3 = new ArrayList<Integer>();
    static List<Integer> PassangerSeatArrayFINAL= new ArrayList<Integer>();




    @FXML
    public Label label1;
    public Label label2;
    public Label label3;
    public Label label4;
    public Label label5;
    public Label label6;
    public Button button1;

    public Label test;
    public Label seat1;
    public Label seat2;
    public Label seat3;
    public Label seat4;
    public Label seat5;
    public Label seat6;
    public Label seat7;
    public Label seat8;
    public Label seat9;
    public Label seat10;
    public Label seat11;
    public Label seat12;
    public Label seat13;
    public Label seat14;
    public Label seat15;
    public Label seat16;
    public Label seat17;
    public Label seat18;
    public Label seat19;
    public Label seat20;
    public Label seat21;
    public Label seat22;
    public Label seat23;
    public Label seat24;
    public Label seat25;
    public Label seat26;
    public Label seat27;
    public Label seat28;
    public Label seat29;
    public Label seat30;
    public Label seat31;
    public Label seat32;
    public Label seat33;
    public Label seat34;
    public Label seat35;
    public Label seat36;
    public Label seat37;
    public Label seat38;
    public Label seat39;
    public Label seat40;
    public Label seat41;
    public Label seat42;

    public Label MaxLenght;
    public Label MaximumWaitingTime;
    public Label MinimumWaitingTime;
    public Label AverageWaitingTime;


    //this will run automatically when the programme runs

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void initialize(URL location, ResourceBundle resources) {


        try {
            AddtoWaitingRoom();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("Type(A) to add passangers To train queue");
        System.out.println("");
        System.out.println("Type(D) to delete passangers from train queue");
        System.out.println("");
        System.out.println("Type(S) Store train queue data");
        System.out.println("");
        System.out.println("Type(L) To load train queue data");
        System.out.println("");
        System.out.println("Type(R) To run the simulation");
        System.out.println(" ");
        System.out.println(" ");

    }

    public void prompt(){
        System.out.println(" ");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println(" ");
        String input;
        Scanner userin = new Scanner(System.in);

            System.out.print("Type Input  : ");
            input = userin.nextLine();
            try {
                alloptions(input.toUpperCase());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


    }


        //main programme--------------------------------------------------------------------------------------------------


    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void alloptions(String choice) throws IOException, ClassNotFoundException, InterruptedException {

            if (choice.equals("A")) {    //all options in the application is run if the specified methord is called using the letters assigned to them
                AddToPassangerQueue();

            } else if (choice.equals("R")) {
                RunReport();             //running the report method

            } else if (choice.equals("V")) {
                ViewTrainQueue();        //running the view method

            } else if (choice.equals("D")) {
                DeletePassangers();     //running the delete method

            } else if (choice.equals("S")) {
                SaveQueueDetails();     //running the save method

            } else if (choice.equals("L")) {
                LoadQueueDetails();     //running the load method

            }else if(choice.equals("Q")){
                System.exit(0);  //quting the programme if the choice is Q
            }
        }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void SaveQueueDetails() throws IOException {

        //saving the passanger names into a file
            {
                HashMap<String, Map<String, Integer>> customerfile = new HashMap<>();

                File file = new File("CustomerSaveData");
                FileOutputStream f = new FileOutputStream(file);
                ObjectOutputStream s = new ObjectOutputStream(f);
                s.writeObject(customerfile);
                s.close();
                FileOutputStream fos = new FileOutputStream("TrainQueueDataP");//the name of the file given
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(ViewFunctionUse);
            }

            //saving the passanger seats into a file
            {
                HashMap<String, Map<String, Integer>> customerfile = new HashMap<>();

                File file = new File("CustomerSaveData"); //nameing the file
                FileOutputStream f = new FileOutputStream(file);
                ObjectOutputStream s = new ObjectOutputStream(f);
                s.writeObject(customerfile);
                s.close();
                FileOutputStream fos = new FileOutputStream("TrainQueueDataS");//the name of the file given
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(PassangerSeatArrayFINAL);
                System.out.println("Passangers details have been sucessfully saved !");
            }
        }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void LoadQueueDetails() throws IOException, ClassNotFoundException, InterruptedException {

            File file = new File("CustomerSaveData");
            FileInputStream f = new FileInputStream(file);
            ObjectInputStream s = new ObjectInputStream(f);
            HashMap<String, Integer> fileObj = (HashMap<String, Integer>) s.readObject();
            passangermap = fileObj;

            FileInputStream fiss = new FileInputStream("TrainQueueDataP");
            ObjectInputStream oiss = new ObjectInputStream(fiss);
            ViewFunctionUse.removeAll(ViewFunctionUse);
            ViewFunctionUse = (List) oiss.readObject();

            //System.out.println(ViewFunctionUse);

            FileInputStream fis = new FileInputStream("TrainQueueDataS");
            ObjectInputStream ois = new ObjectInputStream(fis);
            PassangerSeatArray.removeAll(PassangerSeatArray);
            PassangerSeatArray = (List) ois.readObject();

            //System.out.println(PassangerSeatArray);

            System.out.println("| Please note that the current data have been overwritten by the loaded data |");
        }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void DeletePassangers() {
            Scanner userin = new Scanner(System.in);
            System.out.print("Enter the name of the passanger to be deleted :");
            String PassangerName = userin.nextLine();

            if (ViewFunctionUse.contains(PassangerName) == true) {

               int LocationofPassanger= ViewFunctionUse.indexOf(PassangerName);
               PassangerSeatArrayFINAL.remove(LocationofPassanger);

                ViewFunctionUse.remove(PassangerName);
                System.out.println("The passanger " + PassangerName + " is sucessfully deleted from the train queue.");

                for(int i=0;i<SeatArray.size();i++){

                    if(SeatArray.get(i).getText().equals(PassangerName)){
                        SeatArray.get(i).setText(" ");
                    }
                }


            }
            else {
                System.out.println("The passanger is not available in queue !");
            }

        }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void RunReport() throws InterruptedException, IOException {

            Random random = new Random();


        for(int i=0; i<ViewFunctionUse.size();i++){

            //the three six sided dices to generate the time taken to check the tickets
            int dice1 = random.nextInt(5) + 1;
            int dice2 = random.nextInt(5) + 1;
            int dice3 = random.nextInt(5) + 1;
            int DiceTOT = dice1 + dice2 + dice3;

            PassangerBoadingArray.add(ViewFunctionUse.get(i));
            Thread.sleep(DiceTOT * 100);                   //this is the time generated using the 3 6 sided dices to use as the time taken to check the bording tickets
            String name = ViewFunctionUse.get(i);
            TrainStation.passengers passanger = new TrainStation.passengers(name, DiceTOT );
            passanger.AddDataToQueue();
        }
           TrainStation.passengerQueue report=new TrainStation.passengerQueue();
            int MinTime=report.ReportCalculationMinTime();  //calling a class method to calculate min time
            int MaxTime=report.ReportCalculationMaxTime();  //calling class method to calculate max time
            int LenghtOfQueue=report.ReportCalculationMaxLenght();  //calling class method to calculate max lenght of queue
            Double AverageTime=report.AverageWaitingTime();  //calling method class to claculate average waiting time


            MinimumWaitingTime.setText(MinTime+" Mins");  //printing the min time in gui screen
            MaximumWaitingTime.setText(MaxTime+" Mins");  //printing the max time in gui screen
            MaxLenght.setText(LenghtOfQueue+" Passangers");  //printing lenght of queue in gui screen
            AverageWaitingTime.setText(AverageTime+" Mins"); //printing average time in gui screen


            //printing the report details to a plain txt file using print writer class

            FileWriter fileWriter = new FileWriter("QueueReport.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.printf("|  The minimum time taken in queue : "+MinTime+"  |  ");
            printWriter.printf("|  The max time taken in queue : "+MaxTime+"  |  ");
            printWriter.printf("|  The average time in queue : "+AverageTime+"  |  ");
            printWriter.printf("|  The max lenght of queue : "+LenghtOfQueue+"  |  ");
            printWriter.close();

            System.out.println("The report have been sucessfully saved into a txt file !");
        }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void ViewTrainQueue()  {
        System.out.println("This is the passangers in queue : " + ViewFunctionUse);



        for(int i=0;i<ViewFunctionUse.size();i++){

            SeatArray.get(PassangerSeatArrayFINAL.get(i)).setText(ViewFunctionUse.get(i));  //getting the seat at "i" position fro m

        }

        }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void AddtoWaitingRoom() throws IOException, ClassNotFoundException, InterruptedException {

            File file = new File("CustomerSaveData");
            FileInputStream f = new FileInputStream(file);
            ObjectInputStream s = new ObjectInputStream(f);
            HashMap<String, Integer> fileObj = (HashMap<String, Integer>) s.readObject();
            passangermap = fileObj;

            FileInputStream fiss = new FileInputStream("TrainQueueSeats");  //importing the TrainQueue seats from cw1
            ObjectInputStream oiss = new ObjectInputStream(fiss);
           PassangerSeatArray = (List) oiss.readObject();
           System.out.println(PassangerSeatArray);

            FileInputStream fis = new FileInputStream("TrainQueuePassangers"); //importing the TrainQueue passangers from cw1
            ObjectInputStream ois = new ObjectInputStream(fis);
            TQ = (List) ois.readObject();

            TQ3.addAll(TQ);
            TQcopy.addAll(TQ);

            PassangerSeatArray3.addAll(PassangerSeatArray);
            PassangerSeatArrayCOPY.addAll(PassangerSeatArray);

            SeatArray.add(test);
            SeatArray.add(seat1);
            SeatArray.add(seat2);
            SeatArray.add(seat3);
            SeatArray.add(seat4);
            SeatArray.add(seat5);
            SeatArray.add(seat6);
            SeatArray.add(seat7);
            SeatArray.add(seat8);
            SeatArray.add(seat9);
            SeatArray.add(seat10);
            SeatArray.add(seat11);
            SeatArray.add(seat12);
            SeatArray.add(seat13);
            SeatArray.add(seat14);
            SeatArray.add(seat15);
            SeatArray.add(seat16);
            SeatArray.add(seat17);
            SeatArray.add(seat18);
            SeatArray.add(seat19);
            SeatArray.add(seat20);
            SeatArray.add(seat21);
            SeatArray.add(seat22);
            SeatArray.add(seat23);
            SeatArray.add(seat24);
            SeatArray.add(seat25);
            SeatArray.add(seat26);
            SeatArray.add(seat27);
            SeatArray.add(seat28);
            SeatArray.add(seat29);
            SeatArray.add(seat30);
            SeatArray.add(seat31);
            SeatArray.add(seat32);
            SeatArray.add(seat33);
            SeatArray.add(seat34);
            SeatArray.add(seat35);
            SeatArray.add(seat36);
            SeatArray.add(seat37);
            SeatArray.add(seat38);
            SeatArray.add(seat39);
            SeatArray.add(seat40);
            SeatArray.add(seat41);
            SeatArray.add(seat42);
        }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void AddToPassangerQueue() throws IOException, ClassNotFoundException, IndexOutOfBoundsException, InterruptedException {

            Random random = new Random();
            int NumOfPassangers = random.nextInt(5) + 1; //generating a random number from 1-6 for the random amount of passangers to be added to queue

            System.out.println(TQ);

            int number = NumOfPassangers;
            //System.out.println("before calc"+number);

            while(TQ3.size()<number){
                number=number-1;

            }


            //System.out.println("after calc" +number);

            for (int i = 0; i < number; i++) {  //adding passangers selected randomly by a for loop into a array list


                PassangerSeatArray2.add(i,PassangerSeatArrayCOPY.get(i));  //adding the seatnumbers of passangers selected to be in queue to a array
                PassangerSeatArray3.remove(PassangerSeatArrayCOPY.get(i)); //adding the seatnumbers of
                PassangerSeatArrayCOPY.remove(i);

                TQ2.add(i, TQcopy.get(i)); //adding the seleccted passangers into  TQ2 array to display customers in queue
                TQ3.remove(TQcopy.get(i)); //removing the customer added to PQ2 from PQ3 to display the customers yet to be in queue
                TQcopy.remove(i);


            }

            System.out.println("This is the customer in queue                       :  " + TQ2 );
            System.out.println( "                                                       "+ PassangerSeatArray2);
            System.out.println("");
            System.out.println("these are the customers that are yet to be in queue :  " + TQ3);
            System.out.println("                                                       "+PassangerSeatArray3);

            SetNamesToLabels(); //methord to display the passangers to be in queue in gui

            ViewFunctionUse.addAll(TQ2); //adding the passanngers in queue to a new array for further use
            PassangerSeatArrayFINAL.addAll(PassangerSeatArray2); //adding passanger seat nummbers to a new array for further use


            TQ2.removeAll(TQ2); //removing all data from TQ2(passangers to be in queue) to remove any duplication of data when the methord is relaunched
            PassangerSeatArray2.removeAll(PassangerSeatArray2); //removing all data  from Passangerseatarray2(passanger seats to be in queue) to remove duplication of data

        }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------

        public void SetNamesToLabels() {

            if (TQ2.size() == 1) {


                if (TQ2.get(0) != null) {
                    label1.setText(TQ2.get(0)+"| seat - "+PassangerSeatArray2.get(0));
                    label2.setText("2");
                    label3.setText("3");
                    label4.setText("4");
                    label5.setText("5");
                    label6.setText("6");
                }

            }


            if (TQ2.size() == 2) {

                if (TQ2.get(0) != null) {
                    label1.setText(TQ2.get(0)+"  | seat - "+PassangerSeatArray2.get(0));
                }

                if (TQ2.get(1) != null) {
                    label2.setText(TQ2.get(1)+"  | seat - "+PassangerSeatArray2.get(1));
                    label3.setText("3");
                    label4.setText("4");
                    label5.setText("5");
                    label6.setText("6");
                }

            }


            if (TQ2.size() == 3) {

                if (TQ2.get(0) != null) {
                    label1.setText(TQ2.get(0)+"  | seat - "+PassangerSeatArray2.get(0));
                }

                if (TQ2.get(1) != null) {
                    label2.setText(TQ2.get(1)+"  | seat - "+PassangerSeatArray2.get(1));
                }

                if (TQ2.get(2) != null) {
                    label3.setText(TQ2.get(2)+"  | seat - "+PassangerSeatArray2.get(2));
                    label4.setText("4");
                    label5.setText("5");
                    label6.setText("6");
                }
            }


            if (TQ2.size() == 4) {

                if (TQ2.get(0) != null) {
                    label1.setText(TQ2.get(0)+"  | seat - "+PassangerSeatArray2.get(0));
                }

                if (TQ2.get(1) != null) {
                    label2.setText(TQ2.get(1)+"  | seat - "+PassangerSeatArray2.get(1));
                }

                if (TQ2.get(2) != null) {
                    label3.setText(TQ2.get(2)+"  | seat - "+PassangerSeatArray2.get(2));
                }

                if (TQ2.get(3) != null) {
                    label4.setText(TQ2.get(3)+"  | seat - "+PassangerSeatArray2.get(3));
                    label5.setText("5");
                    label6.setText("6");
                }

            }


            if (TQ2.size() == 5) {

                if (TQ2.get(0) != null) {
                    label1.setText(TQ2.get(0)+"  | seat - "+PassangerSeatArray2.get(0));
                }

                if (TQ2.get(1) != null) {
                    label2.setText(TQ2.get(1)+"  | seat - "+PassangerSeatArray2.get(1));
                }

                if (TQ2.get(2) != null) {
                    label3.setText(TQ2.get(2)+"  | seat - "+PassangerSeatArray2.get(2));
                }

                if (TQ2.get(3) != null) {
                    label4.setText(TQ2.get(3)+"  | seat - "+PassangerSeatArray2.get(3));
                }

                if (TQ2.get(4) != null) {
                    label5.setText(TQ2.get(4)+"  | seat - "+PassangerSeatArray2.get(4));
                    label6.setText("6");
                }
            }

            if (TQ2.size() == 6) {


                if (TQ2.get(0) != null) {
                    label1.setText(TQ2.get(0)+"  | seat - "+PassangerSeatArray2.get(0));
                }

                if (TQ2.get(1) != null) {
                    label2.setText(TQ2.get(1)+"  | seat - "+PassangerSeatArray2.get(1));
                }

                if (TQ2.get(2) != null) {
                    label3.setText(TQ2.get(2)+"  | seat - "+PassangerSeatArray2.get(2));
                }

                if (TQ2.get(3) != null) {
                    label4.setText(TQ2.get(3)+"  | seat - "+PassangerSeatArray2.get(3));
                }

                if (TQ2.get(4) != null) {
                    label5.setText(TQ2.get(4)+"  | seat - "+PassangerSeatArray2.get(4));
                }

                if (TQ2.get(5) != null) {
                    label6.setText(TQ2.get(5)+"  | seat - "+PassangerSeatArray2.get(5));
                }
            }


        }
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------



