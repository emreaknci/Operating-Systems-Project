public class Process implements Runnable {


    private int id;
    private int arrivalTime; 
    private int priority;
    private int processTime;
    private String color; //Satir rengi icin


    private int state = 0;
    private boolean isTimeOut; // Proses zamani doldu mu

    public void setState(int state) {
        this.state = state;
    }
    public int getState() {
        return state;
    }

    private int waitingTime;
    public boolean isTimeOut() {
        return isTimeOut;
    }

    public void setTimeOut(boolean timeOut) {
        isTimeOut = timeOut;
    }
    public Process(int id,int arrivalTime, int priority, int processTime,String color) {
        this.arrivalTime = arrivalTime;
        this.id =id;
        this.priority = priority;
        this.processTime = processTime;
        this.waitingTime=0;
        this.isTimeOut=false;
        this.color=color;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority=priority;
    }
    public int getProcessTime() {
        return processTime;
    }
    public void setProcessTime(int processTime) {
        this.processTime = processTime;
    }

    @Override
    public void run() {
        System.out.println("Varış zamanı: " + arrivalTime + " Öncelik değeri: " + priority + " Proses zamanı: " + processTime);
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
}